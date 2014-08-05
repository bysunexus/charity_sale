/**
 * 捐品信息显示
 * 依赖:jQuery BlockUI Plugin
 * 依赖:ICH
 * User: bysun
 * Date: 2014/8/2
 * Time: 11:53
 */

(function ($) {
  ich.addTemplate(
    "GOODS_INFO_TMPLATE",
    [
      '<div class="tile double {{color}}"><div class="tile-body">',
      '  <h3>{{data.goodsNum}}-{{data.goodsName}}</h3>',
      '  <p>由 <i>{{data.personName}}</i> 捐献</p>',
      '  <p>已售 <i>{{salesCount}}</i> 件,营收 <i>{{salesMoney}}</i> 元</p>',
      '  <p>总数量 <i>{{data.goodsCount}}</i> 件,单价 <i>{{data.goodsPrice}}</i> 元</p>',
      '  <p>{{data.remark}}</p>',
      '</div>'
    ].join('')
  );

  $.goodsInfo = function (options) {
    var opts = $.extend({}, $.goodsInfo.defaults, options);
    $.blockUI({
      message: ich.GOODS_INFO_TMPLATE({
        data: opts.data,
        salesCount: function () {
          var saleCount = 0;
          $(this.data.saleInfos).each(function (idx, item) {
            saleCount += item.saleCount;
          });
          return saleCount;
        },
        salesMoney: function () {
          var saleMoney = 0;
          $(this.data.saleInfos).each(function (idx, item) {
            saleMoney += item.saleMoney;
          });
          return saleMoney;
        },
        color: "bg-blue"//COMMONS.randomColorStyle()
      }),
      css: {
        border: 'none',
        backgroundColor: 'none',
        cursor: 'default'
      }
    });
    $('.blockOverlay').attr('title', 'Click to unblock').click($.unblockUI);
  };

  $.goodsInfo.defaults = {
    data: {}
  };
})(jQuery);