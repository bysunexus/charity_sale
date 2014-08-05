/**
 * Created with IntelliJ IDEA.
 * User: bysun
 * Date: 2014/8/5
 * Time: 14:13
 */

(function ($) {

  var _ajax = function (target, opts) {

    var prefix = opts.goodsType=="ALL"?"全部销售额":(opts.goodsType+"组销售额");

    setTimeout(task, 1000);
    function task() {
      $.ajax({
        type: "POST",
        url: ctx + "/saleMoney/" + opts.goodsType,
        success: function (data) {
          if (data.success)
            $(target).each(function () {
              $(this).text(prefix+data.data+"元");
            });
        },
        complete: function (jqXHR, textStatus) {
          window.setTimeout(task, opts.period);
        }
      });
    }
  };

  $.fn.saleMoney = function (options) {
    var opts = $.extend({}, $.fn.saleMoney.default, options);
    _ajax(this,opts);
  };

  $.fn.saleMoney.default = {
    goodsType: "ALL",// 默认获取全部销售额
    period: 10000// 默认刷新时间10s
  };
})(jQuery);