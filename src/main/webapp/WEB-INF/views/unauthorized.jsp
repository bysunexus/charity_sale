<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="menu" content="">
  <link href="${ctx}/static/assets/css/pages/error.css" rel="stylesheet" type="text/css"/>
</head>
<body class="page-404-3">
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      权限不足 <small>您没有权限</small>
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">首页</a>
        <i class="fa fa-angle-right"></i>
      </li>
      <li><a href="#">权限不足</a></li>
    </ul>
    <!-- END PAGE TITLE & BREADCRUMB-->
  </div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE CONTENT-->
<div class="row">
  <div class="col-md-12 page-404">
    <div class="number">
      403
    </div>
    <div class="details">
      <h3>Oops!  您没有权限</h3>
      <p>
        您没有权限访问当前页面<br />
        <a href="${ctx}/">返回首页</a>
      </p>
    </div>
  </div>
</div>
</body>
</html>
