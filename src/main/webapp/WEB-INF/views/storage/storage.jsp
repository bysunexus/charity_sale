<%--
  Created by IntelliJ IDEA.
  User: Watson
  Date: 2014/6/16
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="storage">
  <script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
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
        <a>业务功能</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/goStorage">商品入库</a>
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
          <i class="fa fa-reorder"></i>商品入库
        </div>
      </div>
      <div class="portlet-body form">
        <div class="form-horizontal" role="form">
          <div id="tagForm" class="form-body">
            <div class="form-group">
              <label class="col-lg-3 control-label">商品编号</label>

              <div class="col-lg-9">
                <input id="commodityNumber" name="commodityNumber" type="text" class="form-control input-lg" placeholder="商品编号此处采用手动录入为了防备手机客户端故障." value="">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">商品数量</label>

              <div class="col-lg-9">
                <input id="commodityQuantity" name="commodityQuantity" type="text" class="form-control input-lg" placeholder="商品个数总量." value="">
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-3 control-label">商品单价</label>

              <div class="col-lg-9">
                <input id="commodityPrice" name="commodityPrice" type="text" class="form-control input-lg" placeholder="商品单价." value="">
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
  </div>
</div>
<!-- END PAGE CONTENT-->
<script type="text/javascript">

</script>
</body>
</html>