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
  <meta name="menu" content="BIZ_OPT_STORAGE">
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

    <div class="portlet box red">
      <div class="portlet-title">
        <div class="caption"><i class="fa fa-shopping-cart"></i>购物车</div>
      </div>
      <div class="portlet-body">
        <div class="table-responsive">
          <table class="table table-striped table-bordered table-advance table-hover">
            <thead>
            <tr>
              <th>编号</th>
              <th class="hidden-xs">名称</th>
              <th>单价</th>
              <th>库存</th>
              <th>数量</th>
              <th>金额</th>
            </tr>
            </thead>
            <tbody id="salesTable">

            </tbody>
            <tfoot>
              <tr>
                <td colspan="6" style="text-align: right;" id="totalPrice"></td>
              </tr>
            </tfoot>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div>
    <div class="col-md-offset-3 col-md-9">
      <button type="button" class="btn green" onclick="OrderTable.sale();">确认提交</button>
      <button type="button" class="btn yellow" onclick="OrderTable.back();">放弃</button>
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
      <a>{{goods.goodsNum}}</a>
    </td>
    <td class="hidden-xs">{{goods.goodsName}}</td>
    <td>{{goods.goodsPrice}}</td>
    <td>{{stock}}</td>
    <td style="padding: 0;vertical-align: middle;">
      <input type="hidden" class="form-control sale_id" value="{{id}}" />
      <input type="hidden" class="form-control sale_singlePrice" value="{{goods.goodsPrice}}" />
      <input style="border: 0;" type="text" class="form-control sale_count charity_input ime_disabled" value="{{saleCount}}" />
    </td>
    <td style="padding: 0;vertical-align: middle;">
      <input style="border: 0;" type="text" class="form-control sale_price charity_input ime_disabled" value="{{price}}" />
    </td>
  </tr>
  {{/goods}}
</script>
<script src="${ctx}/static/assets/plugins/bootbox/bootbox.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/jquery-validation/dist/additional-methods.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/plugins/jquery-validation/src/localization/messages_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/viewlogics/storage/orderTable.js"></script>
<script>
  var SALES_DATA = eval('(${salesJson})') || [];
  $(function () {
    OrderTable.init();
  });
</script>

</body>
</html>