/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 15:32
 */
var TotalReport = function () {

  var initTable = function () {
    var oTable = $('#tpTable').dataTable({
      "autoWidth": false, // 自适应宽度
      "deferRender": false, // 是否延时渲染(前端分页)
      "info": true, // 分页详细信息说明
      "lengthChange": true,//是否允许分页数选择
      "lengthMenu": [ 10, 25, 50, 75, 100 ], // 分页条数选择工具
      "pageLength": 10,
      "ordering": true, // 是否开启排序功能
      "paging": true, // 是否分页
      "processing": true,// 是否显示加载ing
      "scrollX": false,//是否允许水平滚动
      "scrollY": false,//是否允许垂直滚动
      "searching": true,//是否显示搜索框
      "serverSide": true,//是否是服务端数据
      stateSave: true,//启用或禁用状态保存
      ajax: {
        "url": ctx + "/totalReport/findTotalTable",
        "type": "post",
        traditional: true,
        contentType: "application/json; charset=UTF-8",
        data: function (d) {
          return JSON.stringify(d);
        }

      },
      language: {
        processing: "处理中...",
        search: "搜索:",
        lengthMenu: "显示 _MENU_ 项结果",
        info: "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        infoEmpty: "显示第 0 至 0 项结果，共 0 项",
        infoFiltered: "(由 _MAX_ 项结果过滤)",
        infoPostFix: "",
        loadingRecords: "载入中...",
        zeroRecords: "没有匹配结果",
        emptyTable: "表中数据为空",
        paginate: {
          first: "首页",
          previous: "上页",
          next: "下页",
          last: "末页"
        },
        aria: {
          sortAscending: ": 以升序排列此列",
          sortDescending: ": 以降序排列此列"
        }
      },
      "columns": [
        {
          "data": "goodsNum",
          name: "goodsNumOrder",
          render: function (data, type, row, meta) {
            return '<a class="goodsInfoShow" onclick="TotalReport.showInfo(\'#tpTable\',\'' + meta.row + '\');">' + data + '</a>';
          }
        },
        {
          "data": "goodsName",
          name: "goodsName"
        },
        {
          "data": "personName",
          name: "personName"
        },
        {
          "data": "goodsPrice",
          "orderable": false,
          name: "goodsPrice"
        },
        {
          "data": "saleInfos",
          name: "saleInfos.saleMoney",
          "orderable": false,
          render: function (data, type, row, meta) {
            var saleCount = 0;
            $(data).each(function (idx, item) {
              saleCount += item.saleMoney;
            });
            return saleCount + " 元";
          }
        },
        {
          "data": "goodsCount",
          name: "goodsCount",
          render: function (data, type, row, meta) {
            return data + " 件";
          }
        },
        {
          "data": "saleInfos",
          name: "saleInfos.saleCount",
          "orderable": false,
          render: function (data, type, row, meta) {
            var saleCount = 0;
            $(data).each(function (idx, item) {
              saleCount += item.saleCount;
            });
            return saleCount + " 件";
          }
        },
        {
          "data": "saleInfos",
          name: "saleInfos.saleCount",
          "orderable": false,
          render: function (data, type, row, meta) {
            var saleCount = 0;
            $(data).each(function (idx, item) {
              saleCount += item.saleCount;
            });
            return row.goodsCount - saleCount + " 件";
          }
        }
      ]
    });
    $('.dataTables_filter input').addClass("charity_input ime_disabled");
    $('#tpTable_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
    $('#tpTable_wrapper .dataTables_length select').select2({
    }); // initialize select2 dropdown

  };

  /**
   * 导出Excel监听器
   */
  var exportExcelListener = function () {
    $("#exportExcel").click(function () {

      var goodsNum = null;
      if($("#tpTable_filter").find("input").val() != "") {
        goodsNum = $("#tpTable_filter").find("input").val();
      }

      var exportUrl = ctx + "/totalReport/exportExcel/" + goodsNum;
      //noinspection JSJQueryEfficiency
      $("#exportExcelForm").attr("action", exportUrl);
      //noinspection JSJQueryEfficiency
      $("#exportExcelForm").attr("target", "_blank");
      //noinspection JSJQueryEfficiency
      $("#exportExcelForm").submit();
    });
  };

  return {

    //main function to initiate the module
    init: function () {
      if (!jQuery().dataTable) {
        return;
      }

      initTable();
      exportExcelListener();
    },
    showInfo: function (dt, rowIdx) {
      $.goodsInfo({
        data: $(dt).DataTable().row(rowIdx).data()
      });
    }

  };

}();


$(function () {
  TotalReport.init();
});