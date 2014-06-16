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
  <meta name="menu" content="totalReport">
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
        总报表查询
      </h3>
      <ul class="page-breadcrumb breadcrumb">
        <li>
          <i class="fa fa-home"></i>
          <a href="${ctx}/">主页</a>
          <i class="fa fa-angle-right"></i>
          <a>管理员功能</a>
          <i class="fa fa-angle-right"></i>
          <a href="${ctx}/goTotalReport">总报表查询</a>
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
      </div>
    </div>
    <div class="portlet-body">
      <div class="table-toolbar">
        <div class="btn-group" style="visibility: hidden;">
          <button id="sample_editable_1_new" class="btn green" style="visibility: hidden;">
            &nbsp;<i class="fa fa-plus" style="visibility: hidden;"></i>
          </button>
        </div>
        <div class="btn-group pull-right">
          <button class="btn dropdown-toggle" data-toggle="dropdown">工具 <i class="fa fa-angle-down"></i>
          </button>
          <ul class="dropdown-menu pull-right">
            <li><a href="#">打印</a></li>
            <li><a href="#">保存为 PDF</a></li>
            <li><a href="#">保存为 Excel</a></li>
          </ul>
        </div>
      </div>
      <table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
      <thead>
        <tr>
          <th>Rendering engine</th>
          <th>Browser</th>
          <th class="hidden-xs">Platform(s)</th>
          <th class="hidden-xs">Engine version</th>
          <th class="hidden-xs">CSS grade</th>
        </tr>
      </thead>
      <tbody>
      <tr>
        <td>Trident</td>
        <td>Internet
          Explorer 4.0
        </td>
        <td>Win 95+</td>
        <td>4</td>
        <td>X</td>
      </tr>
      <tr>
        <td>Trident</td>
        <td>Internet
          Explorer 5.0
        </td>
        <td>Win 95+</td>
        <td>5</td>
        <td>C</td>
      </tr>
      <tr>
        <td>Trident</td>
        <td>Internet
          Explorer 5.5
        </td>
        <td>Win 95+</td>
        <td>5.5</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Trident</td>
        <td>Internet
          Explorer 6
        </td>
        <td>Win 98+</td>
        <td>6</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Trident</td>
        <td>Internet Explorer 7</td>
        <td>Win XP SP2+</td>
        <td>7</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Trident</td>
        <td>AOL browser (AOL desktop)</td>
        <td>Win XP</td>
        <td>6</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Firefox 1.0</td>
        <td>Win 98+ / OSX.2+</td>
        <td>1.7</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Firefox 1.5</td>
        <td>Win 98+ / OSX.2+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Firefox 2.0</td>
        <td>Win 98+ / OSX.2+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Firefox 3.0</td>
        <td>Win 2k+ / OSX.3+</td>
        <td>1.9</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Camino 1.0</td>
        <td>OSX.2+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Camino 1.5</td>
        <td>OSX.3+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Netscape 7.2</td>
        <td>Win 95+ / Mac OS 8.6-9.2</td>
        <td>1.7</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Netscape Browser 8</td>
        <td>Win 98SE+</td>
        <td>1.7</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Netscape Navigator 9</td>
        <td>Win 98+ / OSX.2+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.0</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.1</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.1</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.2</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.2</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.3</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.3</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.4</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.4</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.5</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.5</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.6</td>
        <td>Win 95+ / OSX.1+</td>
        <td>1.6</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.7</td>
        <td>Win 98+ / OSX.1+</td>
        <td>1.7</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Mozilla 1.8</td>
        <td>Win 98+ / OSX.1+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Seamonkey 1.1</td>
        <td>Win 98+ / OSX.2+</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Gecko</td>
        <td>Epiphany 2.20</td>
        <td>Gnome</td>
        <td>1.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>Safari 1.2</td>
        <td>OSX.3</td>
        <td>125.5</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>Safari 1.3</td>
        <td>OSX.3</td>
        <td>312.8</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>Safari 2.0</td>
        <td>OSX.4+</td>
        <td>419.3</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>Safari 3.0</td>
        <td>OSX.4+</td>
        <td>522.1</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>OmniWeb 5.5</td>
        <td>OSX.4+</td>
        <td>420</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>iPod Touch / iPhone</td>
        <td>iPod</td>
        <td>420.1</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Webkit</td>
        <td>S60</td>
        <td>S60</td>
        <td>413</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 7.0</td>
        <td>Win 95+ / OSX.1+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 7.5</td>
        <td>Win 95+ / OSX.2+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 8.0</td>
        <td>Win 95+ / OSX.2+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 8.5</td>
        <td>Win 95+ / OSX.2+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 9.0</td>
        <td>Win 95+ / OSX.3+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 9.2</td>
        <td>Win 88+ / OSX.3+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera 9.5</td>
        <td>Win 88+ / OSX.3+</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Opera for Wii</td>
        <td>Wii</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Nokia N800</td>
        <td>N800</td>
        <td>-</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Presto</td>
        <td>Nintendo DS browser</td>
        <td>Nintendo DS</td>
        <td>8.5</td>
        <td>C/A<sup>1</sup></td>
      </tr>
    </tbody>
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
  <script src="${ctx}/static/viewlogics/report/total_report.js"></script>
  <script>
    jQuery(document).ready(function() {
      TotalReport.init();
    });
  </script>

</body>
</html>
