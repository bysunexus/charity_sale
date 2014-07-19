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
  <meta name="menu" content="orderTable">
  <!-- BEGIN PAGE LEVEL STYLES -->
  <!-- END PAGE LEVEL STYLES -->
</head>
<body>
<!-- BEGIN PAGE HEADER-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      购物车
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">主页</a>
        <i class="fa fa-angle-right"></i>
        <a>业务功能</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/storage">商品录入</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/">购物车</a>
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
              <div class="caption"><i class="fa fa-reorder"></i>购物车</div>
            </div>
            <div class="portlet-body form">
              <!-- BEGIN FORM-->
              <table class="table table-striped table-bordered table-advance table-hover">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>名称</th>
                  <th>单价</th>
                  <th>数量</th>
                  <th>金额</th>
                </tr>
                </thead>
                <tbody id="salesTable">

                </tbody>
              </table>
              <!-- END FORM-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- END EXAMPLE TABLE PORTLET-->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script id="initTable" type="text/html">
  {{#goods}}
  <tr>
    <td class="highlight">
      <div class="success"></div>
      {{goods.goodsNum}}
    </td>
    <td>{{goods.goodsName}}</td>
    <td>{{goods.goodsPrice}}</td>
    <td>
      <input type="text" class="form-control sale_id" value="{{id}}" />
      <input type="text" class="form-control sale_count" value="{{saleCount}}" />
    </td>
    <td><input type="text" class="form-control sale_price" value="{{price}}" /></td>
  </tr>
  {{/goods}}
</script>
<script src="${ctx}/static/viewlogics/storage/orderTable.js"></script>
<script>
  var SALES_DATA = eval('(${salesJson})')||[];
  $(function(){
    OrderTable.init();
  });
</script>

</body>
</html>