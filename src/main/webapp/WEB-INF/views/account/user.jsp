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
  <meta name="menu" content="BIZ_OPT_USER">
  <link href="${ctx}/static/ztree/css/zTreeStyle/metro.css" rel="stylesheet" type="text/css">
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
<!-- BEGIN PAGE CONTENT-->

<div class="tabbable">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab_users" data-toggle="tab">用户管理</a></li>
    <li><a href="#tab_menus" data-toggle="tab">权限管理</a></li>
    <li><a href="#tab_userMenus" data-toggle="tab">用户权限</a></li>
  </ul>
  <div  class="tab-content">
    <div class="tab-pane active" id="tab_users">

      <h2>添加用户</h2>
        <div id="userForm">
          用户名<input name="userName" type="text" class="form-control"/><br/>
          昵称<input name="nickName" type="text" class="form-control"/><br/>
          密码<input name="password" type="text" class="form-control"/><br/>
          组:
          <label>A<input name="group" value="A" type="radio" class="form-control"/></label>
          <label>B<input name="group" value="B" type="radio" class="form-control"/></label>
          <label>C<input name="group" value="C" type="radio" class="form-control"/></label>
          <label>D<input name="group" value="D" type="radio" class="form-control"/></label>
          <label>E<input name="group" value="E" type="radio" class="form-control"/></label><br/>
          级别:
          <label>管理员<input name="level" value="A" type="radio" class="form-control"/></label>
          <label>销售<input name="level" value="S" type="radio" class="form-control"/></label>
          <label>记录员<input name="level" value="B" type="radio" class="form-control"/></label><br/>
          <button type="button" class="btn green" onclick="Account.saveUser();">保存</button>
        </div>
    </div>
    <div class="tab-pane fade" id="tab_menus">
      <h2>添加菜单</h2>
      <div class="row">
        <div class="col-md-8" id="MenuForm">
              父id<input id="menu_pid" name="pid" type="text" class="form-control"/><br/>
              名称<input name="name" type="text" class="form-control"/><br/>
              标记<input name="sign" type="text" class="form-control"/><br/>
              路径<input name="path" type="text" class="form-control"/><br/>
              排序<input name="order" type="text" class="form-control"/><br/>
              <button type="button" class="btn green" onclick="Account.saveMenu();">保存</button>
            <!-- END FORM-->
          </div>

        <div class="col-md-4">
          <ul id="menuTreeDiv" class="ztree"></ul>
          <button type="button" class="btn green" onclick="Account.loadTree();">重新载入</button>
        </div>
      </div>
    </div>
    <div class="tab-pane fade" id="tab_userMenus">
      <h2>添加用户菜单</h2>
      <div class="row" id="UserMenuForm">
        <div class="col-md-8" >
          <div class="portlet-body form">
            <div class="form-horizontal">
              用户名<input id="umf_userName" type="text" class="form-control"/><br/>
              <button type="button" class="btn green" onclick="Account.saveUserMenu();">保存</button>
            </div>
            <!-- END FORM-->
          </div>
        </div>
        <div class="col-md-4">
          <ul id="userMenuTreeDiv" class="ztree"></ul>
          <button type="button" class="btn green" onclick="Account.loadTree();">重新载入</button>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- END PAGE HEADER-->
<script src="${ctx}/static/ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery/jquery-serializeForm.min.js" type="text/javascript"></script>
<script src="${ctx}/static/viewlogics/account/user.js" type="text/javascript"></script>

</body>
</html>


