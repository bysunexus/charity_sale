<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="priceTag">
  <link href="${ctx}/static/assets/plugins/data-tables/dataTables.bootstrap.css" type="text/css"/>
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
        <a href="${ctx}/goods">捐品列表</a>
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
    <div class="portlet box blue">
      <div class="portlet-title">
        <div class="caption"><i class="fa fa-edit"></i>捐品列表</div>
      </div>
      <div class="portlet-body">
        <div class="table-toolbar">
          <div class="btn-group">
            <button class="btn green">
              Add New <i class="fa fa-plus"></i>
            </button>
          </div>
        </div>
        <table class="table table-striped table-bordered table-hover" id="sample_1">
        </table>
      </div>
    </div>
  </div>
</div>
<!-- END PAGE CONTENT-->
<script src="${ctx}/static/assets/plugins/data-tables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/data-tables/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<script src="${ctx}/static/viewlogics/goods/goods.js" type="text/javascript"></script>
</body>
</html>

