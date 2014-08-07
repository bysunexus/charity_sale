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
  <meta name="menu" content="GOODS_INFO_RECORD">
  <!-- BEGIN PAGE LEVEL STYLES -->
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/bootstrap-toastr/toastr.min.css" />
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/select2/select2_metro.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
  <!-- END PAGE LEVEL STYLES -->
</head>
<body>
<!-- BEGIN PAGE HEADER-->
<div class="row">
  <div class="col-md-12">
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
    <h3 class="page-title">
      捐品信息维护
    </h3>
    <ul class="page-breadcrumb breadcrumb">
      <li>
        <i class="fa fa-home"></i>
        <a href="${ctx}/">主页</a>
        <i class="fa fa-angle-right"></i>
        <a>捐品信息维护</a>
        <i class="fa fa-angle-right"></i>
        <a href="${ctx}/goodsRecord">捐品维护</a>
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
    <!-- BEGIN EXAMPLE TABLE PORTLET-->
    <div class="portlet box grey">


      <div class="portlet-title">
        <div class="caption">
          <i class="fa fa-globe"></i>捐品维护
        </div>
        <div class="actions">
          <div class="btn"></div>
          <a id="addNewBtn" class="btn blue">
            <i class="fa fa-cloud-download"></i><span>维护</span>
          </a>
        </div>
      </div>


      <div class="portlet-body">
        <div class="panel-group accordion" id="accordion1">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1">
                  捐品总表
                </a>
              </h4>
            </div>
            <div id="collapse_1" class="panel-collapse in">
              <table class="table table-striped table-bordered table-hover" id="tpTable">
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
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1">
                  捐品信息维护
                </a>
              </h4>
            </div>
            <div id="collapse_2" class="panel-collapse collapse">
              <form class="panel-body form-horizontal" id="storage">
                <!-- BEGIN FORM-->
                <div class="form-body">
                  <div class="form-group">
                    <label class="col-md-3 control-label">商品编号:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="goodsNum" name="goodsNum" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">商品名称:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="goodsName" name="goodsName" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">捐献人:<span class="required">*</span></label>

                    <div class="col-md-4">
                      <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="personName" name="personName" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">未售出处理:</label>

                    <div class="col-md-4 radio-list">
                      <label class="radio-inline">
                        <input type="radio" name="goodsReturn" id="goodsReturn_0" value="0" checked>捐孤儿院
                      </label>
                      <label class="radio-inline">
                        <input type="radio" name="goodsReturn" id="goodsReturn_1" value="1">退回
                      </label>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">捐献人电话:</label>
                    <div class="col-md-4">
                      <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="personPhone" name="personPhone" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-md-3 control-label">备注:</label>
                    <div class="col-md-4">
                      <div class="input-icon right">
                        <i class="fa"></i>
                        <input id="remark" name="remark" type="text" class="form-control">
                      </div>
                    </div>
                  </div>
                  <div class="form-actions fluid">
                    <div class="col-md-offset-3 col-md-9">
                      <a type="button" id="saveBtn" class="btn green" onclick="GoodsInfo.saveGoodsInfoBtn();">保存</a>
                      <a type="button" id="saveAndGoonBtn" class="btn yellow" onclick="GoodsInfo.saveAndContinueGoodsInfoBtn();">保存并继续新增</a>
                    </div>
                  </div>
                </div>
                <!-- END FORM-->
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END EXAMPLE TABLE PORTLET-->
  </div>
</div>
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/static/assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/plugins/bootstrap-toastr/toastr.min.js"></script>
<script src="${ctx}/static/jquery/jquery-serializeForm.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/static/viewlogics/goods/goodsInfo.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/static/viewlogics/goodsinfo/goodsinfo.js"></script>

</body>
</html>
