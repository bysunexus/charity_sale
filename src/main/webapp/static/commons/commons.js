/**
 * 全屏loading层
 */
(function ($) {
  $.fn.easyMask = function (method, options) {
    return $.easyMask(this, method, options);
  };

  $.easyMask = function (method, options) {
    var tar = 'body';
    var $targ = $(tar);
    var opt = $.extend({}, $.easyMask.options, options);
    var method = $.easyMask.methods[method];
    if (method) {
      return method(tar, opt);
    }
    return $targ;
  };
  $.easyMask.methods = {
    show: function (target, options) {
      return $(target).each(function () {
        var $targ = $(this);
        if ($targ.css('position') != 'relative') {
          $targ.data('position', $targ.css('position'));
          $targ.css('position', 'relative');
        }
        $('<div class=\'datagrid-mask\' style=\"display:block;z-index:9999;\"></div>').appendTo($targ);
        var msg = $('<div class=\'datagrid-mask-msg\' style=\"display:block;left:50%;z-index:9999;\"></div>')
          .html(options.msg).appendTo($targ);
        msg.css("marginLeft", -msg.outerWidth() / 2);
      });
    },
    hide: function (target, options) {
      return $(target).each(function () {
        $here = $(this);
        $here.children('.datagrid-mask').remove();
        $here.children('.datagrid-mask-msg').remove();
        if ($here.data().position != undefined) {
          $here.css("position", $here.data().position);
          $here.removeData('position');
        }
      });
    }
  };

  $.easyMask.options = {
    msg: 'Loading...'
  };

})(jQuery);

var COMMONS = function(){
  var colors = ["bg-blue","bg-red","bg-green","bg-purple","bg-yellow"];
  return {
    validFail:function(formId,data){
      if(data.validResult){
        var errs = {};
        $(data.data).each(function(k,v){
          errs[k]= v.join(",");
        });
        $( "#"+formId ).validate().showErrors(errs);
      }
    },
    randomEle:function(arr){
      var len = arr.length;
      var idx = Math.floor(Math.random()*len); //0-len

      return arr[idx];
    },
    randomColorStyle:function(){
      return COMMONS.randomEle(colors);
    },
    resetForm:function(formId){
      $(':input',"#"+formId)
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
    }
  };
}();