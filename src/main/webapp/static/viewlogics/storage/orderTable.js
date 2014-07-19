/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/19
 * Time: 20:15
 */
var OrderTable = function () {

  var initTable = function () {

  }

  return {

    //main function to initiate the module
    init: function () {

      initTable();

      $("#salesTable").html(
        ich.initTable({
          goods: SALES_DATA,
          price: function () {
            return this.saleCount * this.goods.goodsPrice;
          }
        })
      );
      $("#salesTable input").blur(function(){

      });
    },
    calculateTotal: function () {

    }
  };

}();