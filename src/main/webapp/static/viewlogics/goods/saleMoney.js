/**
 * Created with IntelliJ IDEA.
 * User: bysun
 * Date: 2014/8/5
 * Time: 14:13
 */
(function($){

  var getPrefix = function(goodsType){
    return goodsType=="ALL"?"总销售额":(goodsType+"组销售额");
  };

  var _ajax = function (target, opts) {

    function task() {
      $.ajax({
        type: "GET",
        url: ctx + "/saleMoney/" + opts.goodsType,
        success: function (data) {
          if (data.success)
            if(opts.goodsType=="ALL"){
              var result = [];
              $.each(data.data,function(k,v){
                if("NULL" == k || "ALL" == k)
                  return;
                result.push(getPrefix(k)+(v?v:0)+"元");
              });
              result.push(getPrefix("ALL")+(data.data["ALL"]?data.data["ALL"]:0)+"元");
              var resultStr = result.join("|");
              $(target).each(function () {
                $(this).text(resultStr);
              });
            }else{
              $(target).each(function () {
                $(this).text(getPrefix(opts.goodsType)+(data.data?data.data:0)+"元");
              });
            }
        },
        complete: function (jqXHR, textStatus) {
          window.setTimeout(task, opts.period);
        }
      });
    }

    task();
  };

  $.fn.showSaleMoney = function(options){
    var opts = $.extend({}, $.fn.showSaleMoney.default, options);
    _ajax(this,opts);
    return this;
  };

  $.fn.showSaleMoney.default = {
    goodsType: "ALL",// 默认获取全部销售额
    period: 10000// 默认刷新时间10s
  };

})(jQuery);