/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/16
 * Time: 15:32
 */
var TotalReport = function () {

  var initTable2 = function() {
    var oTable = $('#sample_2').dataTable( {
      "aoColumnDefs": [
        { "aTargets": [ 0 ] }
      ],
      "aaSorting": [[1, 'asc']],
      "aLengthMenu": [
        [5, 15, 20, -1],
        [5, 15, 20, "All"] // change per page values here
      ],
      // set the initial value
      "iDisplayLength": 10,
    });

    jQuery('#sample_2_wrapper .dataTables_filter input').addClass("form-control input-small"); // modify table search input
    jQuery('#sample_2_wrapper .dataTables_length select').addClass("form-control input-small"); // modify table per page dropdown
    jQuery('#sample_2_wrapper .dataTables_length select').select2(); // initialize select2 dropdown

    $('#sample_2_column_toggler input[type="checkbox"]').change(function(){
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

      initTable2();
    }

  };

}();