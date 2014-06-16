/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/13
 * Time: 14:21
 */
var AdminAccountManagerTable = function () {

  return {

    //main function to initiate the module
    init: function () {
      function restoreRow(oTable, nRow) {
        var aData = oTable.fnGetData(nRow);
        var jqTds = $('>td', nRow);

        for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
          oTable.fnUpdate(aData[i], nRow, i, false);
        }

        oTable.fnDraw();
      }

      function editRow(oTable, nRow) {
        var aData = oTable.fnGetData(nRow);
        var jqTds = $('>td', nRow);
        jqTds[0].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[0] + '">';
        jqTds[1].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[1] + '">';
        jqTds[2].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[2] + '">';
        jqTds[3].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[3] + '">';
        jqTds[4].innerHTML = '<a class="edit" href="">Save</a>';
        jqTds[5].innerHTML = '<a class="cancel" href="">Cancel</a>';
      }

      function saveRow(oTable, nRow) {
        var jqInputs = $('input', nRow);
        oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
        oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
        oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
        oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
        oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
        oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 5, false);
        oTable.fnDraw();
      }

      function cancelEditRow(oTable, nRow) {
        var jqInputs = $('input', nRow);
        oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
        oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
        oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
        oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
        oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
        oTable.fnDraw();
      }

      var oTable = $('#sample_editable_1').dataTable({
        "sDom" : "<'row'<'col-md-6 col-sm-12'l><'col-md-12 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", //default layout without horizontal scroll(remove this setting to enable horizontal scroll for the table)
        "aLengthMenu": [
          [10, 25, 50, 100, -1],
          [10, 25, 50, 100, "All"] // 更改显示记录数选项
        ],
        "bProcessing": false, // DataTables载入数据时，是否显示‘进度’提示
        "bServerSide": false, // 是否启动服务器端数据导入
        "bStateSave" : true, // 是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
        "bJQueryUI" : false, // 是否使用 jQuery的UI theme
//        "sAjaxSource": "",
        "iDisplayLength": 10, // 默认显示的记录数
        //"bScrollInfinite" : false, // 是否启动初始化滚动条
        //"sScrollY" : 450, // DataTables的高
        //"sScrollX" : 820, // DataTables的宽
        //"bAutoWidth" : false, // 是否自适应宽度
        //"bScrollCollapse" : true, // 是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
        //"bInfo" : true, //是否显示页脚信息，DataTables插件左下角显示记录数
        //"bSort" : true, //是否启动各个字段的排序功能
        //"aaSorting" : [[1, "asc"]], //默认的排序方式，第2列，升序排列
        //"bPaginate" : true, //是否显示（应用）分页器
        "sPaginationType": "bootstrap", // 详细分页组，可以支持直接跳转到某页
        "oLanguage": {
          "sProcessing": '<i class="fa fa-coffee"></i>&nbsp;请等待...',
          "sLengthMenu": "显示 _MENU_ 条",
          "oPaginate": {
            "sPrevious": "上一页",
            "sNext": "下一页"
          }
        },
        "aoColumnDefs": [{
          'bSortable': false,
          'aTargets': [0]
        }
        ]
      });

      jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("form-control input-medium"); // modify table search input
      jQuery('#sample_editable_1_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
      jQuery('#sample_editable_1_wrapper .dataTables_length select').select2({
        showSearchInput : true //hide search box with special css class
      }); // initialize select2 dropdown

      var nEditing = null;

      //TODO: 添加两条后取消会报错  这里看下是否限制只允许同时添加一条数据
      $('#sample_editable_1_new').click(function (e) {
        e.preventDefault();
        var aiNew = oTable.fnAddData(['', '', '', '',
          '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
        ]);
        var nRow = oTable.fnGetNodes(aiNew[0]);
        editRow(oTable, nRow);
        nEditing = nRow;
      });

      $('#sample_editable_1 a.delete').live('click', function (e) {
        e.preventDefault();

        if (confirm("Are you sure to delete this row ?") == false) {
          return;
        }

        var nRow = $(this).parents('tr')[0];
        oTable.fnDeleteRow(nRow);
        alert("Deleted! Do not forget to do some ajax to sync with backend :)");
      });

      $('#sample_editable_1 a.cancel').live('click', function (e) {
        e.preventDefault();
        if ($(this).attr("data-mode") == "new") {
          var nRow = $(this).parents('tr')[0];
          oTable.fnDeleteRow(nRow);
        } else {
          restoreRow(oTable, nEditing);
          nEditing = null;
        }
      });

      $('#sample_editable_1 a.edit').live('click', function (e) {
        e.preventDefault();

        /* Get the row as a parent of the link that was clicked on */
        var nRow = $(this).parents('tr')[0];

        if (nEditing !== null && nEditing != nRow) {
          /* Currently editing - but not this row - restore the old before continuing to edit mode */
          restoreRow(oTable, nEditing);
          editRow(oTable, nRow);
          nEditing = nRow;
        } else if (nEditing == nRow && this.innerHTML == "Save") {
          /* Editing this row and want to save it */
          saveRow(oTable, nEditing);
          nEditing = null;
          alert("Updated! Do not forget to do some ajax to sync with backend :)");
        } else {
          /* No edit in progress - let's start one */
          editRow(oTable, nRow);
          nEditing = nRow;
        }
      });
    }

  };

}();