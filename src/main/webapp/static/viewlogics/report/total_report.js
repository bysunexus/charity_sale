/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 15:32
 */
var TotalReport = function () {

  var initTable = function () {
    var oTable = $('#sample_2').dataTable({
      "sDom" : "<'row'<'col-md-6 col-sm-12'l><'col-md-12 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", //default layout without horizontal scroll(remove this setting to enable horizontal scroll for the table)
      "bProcessing": true,
      "bServerSide": true,
      "iDisplayLength": 10,
      "sPaginationType": "bootstrap",
      "oLanguage": {
        "sProcessing": "正在获取数据，请稍后...",
        "sLengthMenu": "显示 _MENU_ 条",
        "sZeroRecords": "没有您要搜索的内容",
        "sInfo": "从 _START_ 到  _END_ 条记录 总显示记录数为 _TOTAL_ 条",
        "sInfoEmpty": "记录数为0",
        "sInfoFiltered": "(共显示 _MAX_ 条数据)",
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
          'bSortable': false,
          "aTargets": [ 0 ]
        }
      ],
      "aaSorting": [
        [1, 'asc']
      ],
      "aLengthMenu": [
        [5, 15, 20, -1],
        [5, 15, 20, "All"] // change per page values here
      ],
      "processing": true,
      "serverSide": true,
      "sAjaxSource": ctx + "/totalReport/findTotalTable",
      //服务器端，数据回调处理
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
      },
      "columns": [
        { "data": "pkid" },
        { "data": "bscode" },
        { "data": "amount" },
        { "data": "name" },
        { "data": "sex" },
        { "data": "age" },
        { "data": "tel" }
      ]
    });

    jQuery('#sample_2_wrapper .dataTables_filter input').addClass("form-control input-small"); // modify table search input
    jQuery('#sample_2_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
    jQuery('#sample_2_wrapper .dataTables_length select').select2(); // initialize select2 dropdown

    $('#sample_2_column_toggler input[type="checkbox"]').change(function () {
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