/**
 * Created with IntelliJ IDEA.
 * User: bysun
 * Date: 2014/8/5
 * Time: 14:13
 */
(function($){
  var _ajax = function (target, opts) {
    var prefix = opts.goodsType=="ALL"?"总销售额":(opts.goodsType+"组销售额");
    function task() {
      $.ajax({
        type: "GET",
        url: ctx + "/saleMoney/" + opts.goodsType,
        success: function (data) {
          if (data.success)
            $(target).each(function () {
              $(this).text(prefix+(data.data?data.data:0)+"元");
            });
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