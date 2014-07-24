<%--
  Created by IntelliJ IDEA.
  User: Watson
  Date: 2014/6/17
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="BIZ_OPT_STORAGE_GROUPREPORT">
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/select2/select2_metro.css"/>
  <link rel="stylesheet" href="${ctx}/static/assets/plugins/data-tables/DT_bootstrap.css"/>
  <!-- END PAGE LEVEL STYLES -->
</head>
<body>
<!-- BEGIN PAGE HEADER-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      组内销售报表
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">主页</a>
        <i class="fa fa-angle-right"></i>
        <a>业务功能</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/groupReport">组内销售报表</a>
      </li>
      <li><a href="#"></a></li>
    </ul>
    <!-- END PAGE TITLE & BREADCRUMB-->
  </div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet box blue">
  <div class="portlet-title">
    <div class="caption"><i class="fa fa-globe"></i>组内销售报表</div>
    <div class="actions">
      <div class="btn-group">
        <a class="btn default" href="#" data-toggle="dropdown">
          列选择
          <i class="fa fa-angle-down"></i>
        </a>
        <div id="gpTable_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
          <label><input type="checkbox" checked data-column="0">商品编号</label>
          <label><input type="checkbox" checked data-column="1">商品名称</label>
          <label><input type="checkbox" checked data-column="2">捐赠人</label>
          <label><input type="checkbox" checked data-column="3">商品单价</label>
          <label><input type="checkbox" checked data-column="4">售出总价</label>
          <label><input type="checkbox" checked data-column="5">捐品数量</label>
          <label><input type="checkbox" checked data-column="6">已售</label>
          <label><input type="checkbox" checked data-column="7">库存</label>
        </div>
      </div>
    </div>
  </div>
  <div class="portlet-body">
    <table class="table table-striped table-bordered table-hover table-full-width" id="gpTable">
      <thead>
      <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>捐赠人</th>
        <th>商品单价</th>
        <th>售出总价</th>
        <th>捐品数量</th>
        <th>已售</th>
        <th>库存</th>
      </tr>
      </thead>
      <tbody></tbody>
    </table>
  </div>
</div>
<!-- END EXAMPLE TABLE PORTLET-->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/static/assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/data-tables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/data-tables/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/static/viewlogics/report/group_report.js"></script>
<script>
  jQuery(document).ready(function () {
    GroupReport.init();
  });
</script>
</body>
</html>

