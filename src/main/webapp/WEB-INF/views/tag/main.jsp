<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="SYS_OPTS_PT">
</head>
<body>
<!-- BEGIN PAGE HEADER-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      生成价签
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">主页</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/priceTag">生成价签</a>
      </li>
      <li><a href="#"></a></li>
    </ul>
    <!-- END PAGE TITLE & BREADCRUMB-->
  </div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE CONTENT-->
<div class="row">

  <div class="col-md-12">
    <!-- BEGIN SAMPLE FORM PORTLET-->
    <div class="portlet box purple">
      <div class="portlet-title">
        <div class="caption">
          <i class="fa fa-reorder"></i>价签生成选项
        </div>
      </div>
      <div class="portlet-body form">
        <div class="form-horizontal" role="form">
          <div id="tagForm" class="form-body">
            <div class="form-group">
              <label class="col-lg-3 control-label">数量</label>

              <div class="col-lg-9">
                <input id="total" name="total" type="text" class="form-control input-lg charity_input ime_disabled" placeholder="生成价签的数量" value="200">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">价签分类</label>

              <div class="col-lg-9">
                <select id="goodsType" name="goodsType" class="form-control input-lg">
                  <option value="A">A组2元区</option>
                  <option value="B">B组5元区</option>
                  <option value="C">C组10元区</option>
                  <option value="D">D组25元区</option>
                  <option value="E">E组50元及以上区</option>
                </select>
              </div>
            </div>
          </div>
          <div class="form-actions right">
            <button type="button" class="btn default" onclick="TagMain.cancel();">取消</button>
            <button type="submit" class="btn green" onclick="TagMain.create();">确定</button>
          </div>
        </div>
      </div>
    </div>
    <!-- END SAMPLE FORM PORTLET-->

    <div class="portlet box yellow">
      <div class="portlet-title">
        <div class="caption"><i class="fa fa-reorder"></i>下载文件(请先生成后再下载)</div>
      </div>
      <div class="portlet-body">
        <table class="table table-hover table-striped table-bordered">
          <tbody id="fileResult">
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<!-- END PAGE CONTENT-->
<script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery/jquery-serializeForm.min.js" type="text/javascript"></script>
<script type="text/javascript">
  var TagMain = function(){

    return {
      cancel:function(){
        $("#total").val(200);
        $("#goodsType").val("A");
      },
      create:function(){

        $.ajax({
          type: "POST",
          url:ctx+'/priceTag/export',
          data:$('#tagForm').serializeForm(),
          beforeSend: function(){
            //AJAX请求完成时显示提示，防止表单重复提交
            App.blockUI($("body"));
          },
          complete: function(){
            //AJAX请求完成时隐藏loading提示
            App.unblockUI($("body"));
          },
          success: function (data) {
            if(data.success){
              var file = data.data;
              var fileName = file.split("/")[1];
              $("#fileResult").append('<tr><td>'+fileName+'&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn green" target="_blank" href="'+ctx+'/download/'+file+'"><i class="fa fa-cloud-download"></i>下载</a></td></tr>');
            }else{
              bootbox.alert(data.msg);
            }
          }
        });
      }
    };
  }();
</script>
</body>
</html>

