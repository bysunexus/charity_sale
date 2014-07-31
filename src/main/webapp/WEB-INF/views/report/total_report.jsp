<%--
  Created by IntelliJ IDEA.
  User: Watson
  Date: 2014/6/16
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="MAIN_REPORT_LIST">
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/select2/select2_metro.css"/>
  <link rel="stylesheet" href="${ctx}/static/assets/plugins/data-tables/dataTables.bootstrap.css"/>
  <!-- END PAGE LEVEL STYLES -->
</head>
<body>
  <!-- BEGIN PAGE HEADER-->
  <div class="row">
    <div class="col-md-12">
      <!-- BEGIN PAGE TITLE & BREADCRUMB-->
      <h3 class="page-title">
        总报表查询
      </h3>
      <ul class="page-breadcrumb breadcrumb">
        <li>
          <i class="fa fa-home"></i>
          <a href="${ctx}/">主页</a>
          <i class="fa fa-angle-right"></i>
          <a>管理员功能</a>
          <i class="fa fa-angle-right"></i>
          <a href="${ctx}/totalReport">总报表查询</a>
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
      <div class="caption"><i class="fa fa-globe"></i>总报表查询</div>
      <div class="actions">
        <div class="btn-group">
          <a class="btn default" href="#" data-toggle="dropdown">
            列选择
            <i class="fa fa-angle-down"></i>
          </a>

          <div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
            <label><input type="checkbox" checked data-column="0">Rendering engine</label>
            <label><input type="checkbox" checked data-column="1">Browser</label>
            <label><input type="checkbox" checked data-column="2">Platform(s)</label>
            <label><input type="checkbox" checked data-column="3">Engine version</label>
            <label><input type="checkbox" checked data-column="4">CSS grade</label>
          </div>
        </div>
        <div class="btn-group">
          <a class="btn default" href="#" data-toggle="dropdown">
            工具
            <i class="fa fa-angle-down"></i>
          </a>
          <div id="sample_2_column_toggler_tools" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
            <label><a href="#">打印</a></label>
            <label><a href="#">保存为 PDF</a></label>
            <label><a href="#">保存为 Excel</a></label>
          </div>
        </div>
      </div>
    </div>
    <div class="portlet-body">
      <table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
        <thead>
        <tr>
          <th>pkid</th>
          <th>bscode</th>
          <th>amount</th>
          <th>name</th>
          <th>sex</th>
          <th>age</th>
          <th>tel</th>
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
  <script type="text/javascript" src="${ctx}/static/assets/plugins/data-tables/dataTables.bootstrap.js"></script>
  <!-- END PAGE LEVEL PLUGINS -->
  <!-- BEGIN PAGE LEVEL SCRIPTS -->
  <script src="${ctx}/static/viewlogics/report/total_report.js"></script>
  <script>
    jQuery(document).ready(function() {
      TotalReport.init();
    });
  </script>

</body>
</html>
