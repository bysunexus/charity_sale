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
        <a href="${ctx}/storage">商品录入</a>
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
    <div class="tabbable tabbable-custom boxless">
      <div class="tab-content">
        <div class="tab-pane active" id="tab_0">
          <div class="portlet box green">
            <div class="portlet-title">
              <div class="caption"><i class="fa fa-reorder"></i>商品录入</div>
            </div>
            <div class="portlet-body form">
              <!-- BEGIN FORM-->
              <form action="#" class="form-horizontal" id="storage">
                <div class="form-body">
                  <div class="form-group">
                    <label class="col-md-3 control-label">商品编号:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <input id="goodsNum" name="goodsNum" type="text" class="form-control" placeholder="如:A01">
                      <span class="help-block">可选择扫描(选择扫描方式,直接将条码对准摄像头即可.)或手动录入.</span>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">商品数量:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <input id="goodsCount" name="goodsCount" type="text" class="form-control" placeholder="只能为数字">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">商品单价:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <input id="goodsPrice" name="goodsPrice" type="text" class="form-control" placeholder="以元为单位">
                    </div>
                  </div>
                  <div class="form-actions fluid">
                    <div class="col-md-offset-3 col-md-9">
                      <button type="button" class="btn green" onclick="Storage.check();">保存</button>
                      <button type="reset" class="btn yellow">重置</button>
                    </div>
                  </div>
                </div>
                <input type="hidden" id="pkid" name="pkid" >
              </form>
              <!-- END FORM-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery/jquery-serializeForm.min.js" type="text/javascript"></script>
<script src="${ctx}/static/viewlogics/storage/storage.js" type="text/javascript"></script>

<!-- END PAGE CONTENT-->
</body>
</html>