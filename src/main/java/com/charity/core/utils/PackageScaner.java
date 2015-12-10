package com.charity.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class PackageScaner {

    protected final Logger logger = LoggerFactory.getLogger(PackageScaner.class);

    private static final String RESOURCE_PATTERN = "/**/*.class";

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private List<String> packagesList= new LinkedList<>();

    private List<TypeFilter> typeFilters = new LinkedList<>();

    private List<Class> classSet= new ArrayList<>();

    /**
     * 构造函数
     * @param packagesToScan 指定哪些包需要被扫描,支持多个包"package.a,package.b"并对每个包都会递归搜索
     * @param annotationFilter 指定扫描包中含有特定注解标记的bean,支持多个注解
     */
    public PackageScaner(String[] packagesToScan, Class<? extends Annotation>[] annotationFilter){
        if (packagesToScan != null) {
            Collections.addAll(this.packagesList, packagesToScan);
        }
        if (annotationFilter != null){
            for (Class<? extends Annotation> annotation : annotationFilter) {
                typeFilters.add(new AnnotationTypeFilter(annotation, false));
            }
        }
    }

    /**
     * 构造函数
     * @param packagesToScan 指定哪些包需要被扫描,支持多个包"package.a,package.b"并对每个包都会递归搜索
     */
    public PackageScaner(String[] packagesToScan){
        if (packagesToScan != null) {
            Collections.addAll(this.packagesList, packagesToScan);
        }
    }

    /**
     * 构造函数
     * @param packagesToScan 指定哪些包需要被扫描,支持多个包"package.a,package.b"并对每个包都会递归搜索
     */
    public PackageScaner(String[] packagesToScan,List<TypeFilter> typeFilters){
        if (packagesToScan != null) {
            Collections.addAll(this.packagesList, packagesToScan);
        }

        if(null != typeFilters && !typeFilters.isEmpty()){
            this.typeFilters.addAll(typeFilters);
        }
    }

    /**
     * 将符合条件的Bean以Class集合的形式返回
     * @return list 集合
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<Class> getClassSet() throws IOException, ClassNotFoundException {
        this.classSet.clear();
        if (!this.packagesList.isEmpty()) {
            for (String pkg : this.packagesList) {
                String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
                Resource[] resources = this.resourcePatternResolver.getResources(pattern);
                MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        MetadataReader reader = readerFactory.getMetadataReader(resource);
                        String className = reader.getClassMetadata().getClassName();
                        if (matchesEntityTypeFilter(reader, readerFactory)) {
                            this.classSet.add(Class.forName(className));
                        }
                    }
                }
            }
        }
        //输出日志
        if (logger.isInfoEnabled()){
            for (Class clazz : this.classSet) {
                logger.info(String.format("Found class:%s", clazz.getName()));
            }
        }
        return this.classSet;
    }



    /**
     * 检查当前扫描到的Bean含有任何一个指定的注解标记
     * @param reader 读取器
     * @param readerFactory 读取器工厂
     * @return 是否符合
     * @throws IOException
     */
    private boolean matchesEntityTypeFilter(MetadataReader reader, MetadataReaderFactory readerFactory) throws IOException {
        if (!this.typeFilters.isEmpty()) {
            for (TypeFilter filter : this.typeFilters) {
                if (filter.match(reader, readerFactory)) {
                    return true;
                }
            }
        }
        return false;
    }

}