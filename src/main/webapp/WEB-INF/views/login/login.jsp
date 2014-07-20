<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/commons/commons.jsp" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="zh" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="zh" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
  <meta charset="utf-8"/>
  <title>爱心义卖</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
  <meta name="MobileOptimized" content="320">
  <!-- BEGIN GLOBAL MANDATORY STYLES -->
  <link href="${ctx}/static/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
  <!-- END GLOBAL MANDATORY STYLES -->
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/select2/select2_metro.css"/>
  <!-- END PAGE LEVEL SCRIPTS -->
  <!-- BEGIN THEME STYLES -->
  <link href="${ctx}/static/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/css/style.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
  <link href="${ctx}/static/assets/css/pages/login-soft.css" rel="stylesheet" type="text/css"/>
  <link href="${ctx}/static/assets/css/custom.css" rel="stylesheet" type="text/css"/>
  <!-- END THEME STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
  <!-- BEGIN LOGO -->
  <div class="logo">
    <img src="${ctx}/static/assets/img/logo-big.png" alt=""/>
  </div>
  <!-- END LOGO -->
  <!-- BEGIN LOGIN -->
  <div class="content">
    <!-- BEGIN LOGIN FORM -->
    <form class="login-form" action="${ctx}/checkLogin" method="post">
      <h3 class="form-title">请登录您的账号</h3>

      <div class="alert alert-danger display-hide">
        <button class="close" data-close="alert"></button>
        <span>请输入您的账号密码.</span>
      </div>
      <div class="form-group">
        <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
        <label class="control-label visible-ie8 visible-ie9">账号</label>

        <div class="input-icon">
          <i class="fa fa-user"></i>
          <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="账号" name="userName"/>
        </div>
      </div>
      <div class="form-group">
        <label class="control-label visible-ie8 visible-ie9">密码</label>

        <div class="input-icon">
          <i class="fa fa-lock"></i>
          <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="passWord"/>
        </div>
      </div>
      <div class="form-actions">
        <button type="submit" class="btn blue pull-right">
          登录 <i class="m-icon-swapright m-icon-white"></i>
        </button>
      </div>
    </form>
    <!-- END LOGIN FORM -->
  </div>
  <!-- END LOGIN -->
  <!-- BEGIN COPYRIGHT -->
  <div class="copyright">
    2014 &copy; Charity by <a class="text-info" href="http://www.quyeying.com" target="_blank">QuYeYing</a>
  </div>
  <!-- END COPYRIGHT -->
  <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
  <!-- BEGIN CORE PLUGINS -->
  <!--[if lt IE 9]>
  <script src="${ctx}/static/assets/plugins/respond.min.js"></script>
  <script src="${ctx}/static/assets/plugins/excanvas.min.js"></script>
  <![endif]-->
  <script src="${ctx}/static/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
  <!-- END CORE PLUGINS -->
  <!-- BEGIN PAGE LEVEL PLUGINS -->
  <script src="${ctx}/static/assets/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="${ctx}/static/assets/plugins/select2/select2.min.js"></script>
  <!-- END PAGE LEVEL PLUGINS -->
  <!-- BEGIN PAGE LEVEL SCRIPTS -->
  <script src="${ctx}/static/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/scripts/app.js" type="text/javascript"></script>
  <script src="${ctx}/static/assets/scripts/login-soft.js" type="text/javascript"></script>
  <!-- END PAGE LEVEL SCRIPTS -->
  <script>
    jQuery(document).ready(function () {
      Login.init('${ctx}/static');
    });
  </script>
  <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->