var GoodsMain = function () {
  return {
    init: function () {
      $('#sample_1').dataTable({
        "bProcessing": true,
        "bServerSide": true,
        "sAjaxSource": "demo/table_ajax.php",
        "iDisplayLength": 20,
        "sPaginationType": "bootstrap",
        "oLanguage": {
          "sProcessing": '<i class="fa fa-coffee"></i>&nbsp;载入中...',
          "sLengthMenu": "_MENU_ 条记录",
          "oPaginate": {
            "sPrevious": "上页",
            "sNext": "下页"
          }
        },
        "aoColumnDefs": [
          {
            'bSortable': false,
            'aTargets': [0]
          }
        ]
      });
    }
  };
}();
