package com.quyeying.charity.export;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.quyeying.charity.domain.Goods;
import com.quyeying.framework.utils.Exceptions;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: bysun
 * Date: 2014/5/29 0029
 * Time: 11:13
 * <p/>
 * 生成价签文档
 * 添加条码
 */
public class PriceTagCreator {
    private final static Logger log = LoggerFactory.getLogger(PriceTagCreator.class);
    public final static String BASE_PATH = PriceTagCreator.class.getClassLoader().getResource("doctmp/").getFile();
    public final static String PDF_PATH = BASE_PATH + "pdf/";
    private TagDto dto;

    public PriceTagCreator(TagDto dto) {
        this.dto = dto;
    }

    private void createBarcodeImg() {
        // clean image dir
        try {
            FileUtils.cleanDirectory(new File(BASE_PATH + "images/"));
        } catch (IOException e) {
            log.info("清理条码目录的时候发生了错误", e);
            throw Exceptions.unchecked(e);
        }
        // create image
        for (int i = 0; i < dto.getTotal(); i++) {
            createImg(i+1);
        }
    }

    private void createImg(int num) {
        String code = Goods.GoodsType.getByCode(dto.getGoodsType()).getCode() + num;
        Code128Bean bean = new Code128Bean();
        bean.getBarWidth(1);
        bean.setBarHeight(10);
        bean.setModuleWidth(0.4);
        bean.setMsgPosition(HumanReadablePlacement.HRP_NONE);
        File outputFile = new File(BASE_PATH + "images/" + code + ".png");
        OutputStream out = null;
        try {
            out = new FileOutputStream(outputFile);
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                out,
                "image/png",
                96,
                BufferedImage.TYPE_BYTE_GRAY,
                false,
                0
            );
            bean.generateBarcode(canvas, code);
            canvas.finish();
        } catch (IOException e) {
            log.info("生成二维码图片[" + code + "]时发生错误", e);
            throw Exceptions.unchecked(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    private String createHtml() {

        StringWriter out = null;
        try {

            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File(BASE_PATH));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码

            Template template = configuration.getTemplate("tagtmp.htm");

            Map<String, Object> params = new TreeMap<String, Object>();
            Goods.GoodsType type = Goods.GoodsType.getByCode(dto.getGoodsType());
            params.put("codePrefix", type.getCode());
            params.put("total",dto.getTotal());
            params.put("desc", type.getName());
            params.put("ext", type.isExt());
            out = new StringWriter();

            template.process(params, out);
            return out.getBuffer().toString();
        } catch (Throwable e) {
            log.info("生成HTML时发生了错误", e);
            throw Exceptions.unchecked(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    private String createPdf() {

        OutputStream file = null;
        Document document = null;
        try {
            FileUtils.forceMkdir(new File(PDF_PATH));
            String pdfFile = PDF_PATH + dto.getGoodsType() + "-" + System.currentTimeMillis() + ".pdf";
            file = new FileOutputStream(new File(pdfFile));
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            CssFilesImpl cssFiles = new CssFilesImpl();
            StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
            HtmlPipelineContext hpc = new HtmlPipelineContext(null);
            hpc.setImageProvider(new AbstractImageProvider() {

                @Override
                public String getImageRootPath() {
                    return BASE_PATH;
                }
            });

            hpc.setAcceptUnknown(true).autoBookmark(true).setTagFactory(Tags.getHtmlTagProcessorFactory());
            Pipeline<?> pipeline = new CssResolverPipeline(
                cssResolver,
                new HtmlPipeline(hpc, new PdfWriterPipeline(document, writer))
            );
            XMLWorker worker = new XMLWorker(pipeline, true);
            XMLParser p = new XMLParser();
            p.addListener(worker);
            p.parse(new StringReader(createHtml()));

            return pdfFile;
        } catch (Throwable e) {
            log.info("生成PDF时发生了错误", e);
            throw Exceptions.unchecked(e);
        } finally {
            if (null != document)
                document.close();
            IOUtils.closeQuietly(file);
        }
    }

    /**
     * 创建pdf
     *
     * @return pdf名称
     */
    public String create() {
        // 生成条码
        createBarcodeImg();
        // 生成pdf
        return createPdf();
    }
}
