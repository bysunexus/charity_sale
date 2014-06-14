<%--
  Created by IntelliJ IDEA.
  User: Watson
  Date: 2014/6/13
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="adminAccountManager">
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link rel="stylesheet" href="${ctx}/static/assets/plugins/data-tables/DT_bootstrap.css" />
  <!-- END PAGE LEVEL STYLES -->
</head>
<body>
<!-- BEGIN PAGE HEADER-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      账号管理
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">主页</a>
        <i class="fa fa-angle-right"></i>
        <a>管理员功能</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/goAdminAccountManager">账号管理</a>
      </li>
      <li><a href="#"></a></li>
    </ul>
    <!-- END PAGE TITLE & BREADCRUMB-->
  </div>
</div>
<!-- END PAGE HEADER-->

<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">Modal title</h4>
      </div>
      <div class="modal-body">
        Widget settings form goes here
      </div>
      <div class="modal-footer">
        <button type="button" class="btn blue">Save changes</button>
        <button type="button" class="btn default" data-dismiss="modal">Close</button>
      </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

<!-- BEGIN PAGE CONTENT-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN EXAMPLE TABLE PORTLET-->
    <div class="portlet box blue">
      <div class="portlet-title">
        <div class="caption"><i class="fa fa-edit"></i>Editable Table</div>
        <div class="tools">
          <a href="javascript:;" class="collapse"></a>
          <a href="#portlet-config" data-toggle="modal" class="config"></a>
          <a href="javascript:;" class="reload"></a>
          <a href="javascript:;" class="remove"></a>
        </div>
      </div>
      <div class="portlet-body">
        <div class="table-toolbar">
          <div class="btn-group">
            <button id="sample_editable_1_new" class="btn green">
              Add New <i class="fa fa-plus"></i>
            </button>
          </div>
          <div class="btn-group pull-right">
            <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
            </button>
            <ul class="dropdown-menu pull-right">
              <li><a href="#">Print</a></li>
              <li><a href="#">Save as PDF</a></li>
              <li><a href="#">Export to Excel</a></li>
            </ul>
          </div>
        </div>
        <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
          <thead>
          <tr>
            <th>Username</th>
            <th>Full Name</th>
            <th>Points</th>
            <th>Notes</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
          </thead>
          <tbody>
          <tr >
            <td>alex</td>
            <td>Alex Nilson</td>
            <td>1234</td>
            <td class="center">power user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          <tr >
            <td>lisa</td>
            <td>Lisa Wong</td>
            <td>434</td>
            <td class="center">new user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          <tr >
            <td>nick12</td>
            <td>Nick Roberts</td>
            <td>232</td>
            <td class="center">power user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          <tr >
            <td>goldweb</td>
            <td>Sergio Jackson</td>
            <td>132</td>
            <td class="center">elite user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          <tr >
            <td>webriver</td>
            <td>Antonio Sanches</td>
            <td>462</td>
            <td class="center">new user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          <tr >
            <td>gist124</td>
            <td>Nick Roberts</td>
            <td>62</td>
            <td class="center">new user</td>
            <td><a class="edit" href="javascript:;">Edit</a></td>
            <td><a class="delete" href="javascript:;">Delete</a></td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- END EXAMPLE TABLE PORTLET-->
  </div>
</div>
<!-- END PAGE CONTENT -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/static/assets/plugins/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/data-tables/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/static/viewlogics/account/admin_account_manager.js"></script>
<script type="text/javascript">
  jQuery(document).ready(function() {
    AdminAccountManagerTable.init();
  });
</script>
</body>
</html>


