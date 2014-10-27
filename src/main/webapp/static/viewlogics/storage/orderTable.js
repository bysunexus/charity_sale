/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/19
 * Time: 20:15
 */
var OrderTable = function () {

  var initTable = function () {
    $("#salesTable").html(
      ich.initTable({
        goods: SALES_DATA,
        price: function () {
          return this.saleCount * this.goods.goodsPrice;
        },
        stock:function(){
          var total = this.goods.goodsCount || 0;
          //noinspection JSUnresolvedVariable
          $.each(this.goods.saleInfos || [], function (idx, item) {
            total -= item.saleCount || 0;
          });
          return total;
        }
      })
    );

    $("#salesTable .sale_count").keyup(function(){

      $($(this).parent()).next().find(".sale_price")[0].value = $(this).val()*$(this).prev().val();
      OrderTable.calculateTotal();
    });

    $("#salesTable .sale_price").keyup(function(){
      OrderTable.calculateTotal();
    });
  };

  return {

    //main function to initiate the module
    init: function () {
      initTable();
      OrderTable.calculateTotal();
    },
    calculateTotal: function () {
      var total = 0;
      $("#salesTable .sale_price").each(function(){
        total+=parseFloat($(this).val()||0);
      });

      $("#totalPrice").text("合计金额:"+total);
    },
    sale:function(){
      var datas = [];
      $("#salesTable tr").each(function(){
        var tr = $(this);
        var data = {
          id:tr.find(".sale_id")[0].value,
          saleCount:tr.find(".sale_count")[0].value,
          saleMoney:tr.find(".sale_price")[0].value
        };
        datas.push(data);
      });

      var saveUrl = ctx + "/order";
      $.ajax({
        type: "PUT",
        url: saveUrl,
        data: JSON.stringify(datas),
        contentType:"application/json; charset=UTF-8",
        beforeSend: function () {
          //AJAX请求完成时显示提示，防止表单重复提交
          App.blockUI($("body"));
        },
        complete: function () {
          //AJAX请求完成时隐藏loading提示
          App.unblockUI($("body"));
        },
        success: function (data) {
          if (data.success) {
            bootbox.alert(data.msg, function (){
              OrderTable.back();
            });
          } else {
            bootbox.alert("操作失败,请重试或联系管理员!");
          }
        }
      });

    },
    back:function(){
      window.location.href = ctx+"/storage";
    }
  };

}();