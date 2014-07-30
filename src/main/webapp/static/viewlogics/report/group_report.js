/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/23
 * Time: 21:10
 */
var GroupReport = function () {

  var initTable = function () {
    var oTable = $('#gpTable').dataTable({
      "autoWidth": false, // 自适应宽度
      "deferRender":false, // 是否延时渲染(前端分页)
      "info": true, // 分页详细信息说明
      "lengthChange":true,//是否允许分页数选择
      "lengthMenu": [ 10, 25, 50, 75, 100 ], // 分页条数选择工具
      "ordering":true, // 是否开启排序功能
      "paging":true, // 是否分页
      "processing": true,// 是否显示加载ing
      "scrollX":false,//是否允许水平滚动
      "scrollY":false,//是否允许垂直滚动
      "searching": true,//是否显示搜索框
      "serverSide": true,//是否是服务端数据
      stateSave: false,//启用或禁用状态保存
      ajax:{
        "url": ctx + "/groupReport/findTotalTable",
        "type": "post",

        "data": {
          "user_id": 451
        }

      },// 服务器请求

      "iDisplayLength": 10,
      //"bStateSave": true,
//      "sAjaxSource": ctx + "/groupReport/findTotalTable",
      "sPaginationType": "bootstrap",
      "oLanguage": {
        "sProcessing": "正在获取数据，请稍后...",
        "sLengthMenu": "显示 _MENU_ 条",
        "sZeroRecords": "没有您要搜索的内容",
        "sInfo": "从 _START_ 到  _END_ 条记录 总显示记录数为 _TOTAL_ 条",
        "sInfoEmpty": "记录数为0",
        "sInfoPostFix": "",
        "oPaginate": {
          "sFirst": "第一页",
          "sPrevious": "上一页",
          "sNext": "下一页",
          "sLast": "最后一页"
        }
      },
      "aoColumnDefs": [
        {
          "aTargets": [ 4 ],
          "mData": "saleMoney",
          "mRender": function (data, type, full) {
            var saleMoney = 0;
            $(data).each(function (idx, item) {
              saleMoney += item.saleMoney;
            });
            return saleMoney + " 元";
          }
        },
        {
          "aTargets": [ 6 ],
          "mData": "saleCount",
          "mRender": function (data, type, full) {
            var saleCount = 0;
            $(data).each(function (idx, item) {
              saleCount += item.saleCount;
            });
            return saleCount + " 件";
          }
        },
        {
          "aTargets": [ 7 ],
          "mData": "saleInfos",
          "mRender": function (data, type, full) {
            var saleCount = 0;
            $(data).each(function (idx, item) {
              saleCount += item.saleCount;
            });
            return full.goodsCount - saleCount + " 件";
          }
        }
      ],
/*      //服务器端，数据回调处理
      "fnServerData": function (sSource, aDataSet, fnCallback) {
        $.ajax({
          "dataType": 'json',
          "type": "post",
          "url": sSource,
          "data": aDataSet,
          "success": function (resp) {
            fnCallback(resp.data);
          }
        });
      },*/
      "columns": [
        { "data": "goodsNum"},
        { "data": "goodsName" },
        { "data": "personName" },
        { "data": "goodsPrice" },
        { "data": "saleInfos" },
        { "data": "goodsCount" },
        { "data": "saleInfos" },
        { "data": "saleInfos" }
      ]
    });

    jQuery('#gpTable_wrapper .dataTables_filter input').addClass("form-control input-medium"); // modify table search input
    jQuery('#gpTable_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
    jQuery('#gpTable_wrapper .dataTables_length select').select2({
    }); // initialize select2 dropdown

    $('#gpTable_column_toggler input[type="checkbox"]').change(function () {
      /* Get the DataTables object again - this is not a recreation, just a get of the object */
      var iCol = parseInt($(this).attr("data-column"));
      var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
      oTable.fnSetColumnVis(iCol, (bVis ? false : true));
    });
  }

  return {

    //main function to initiate the module
    init: function () {

      if (!jQuery().dataTable) {
        return;
      }

      initTable();
    }

  };

}();