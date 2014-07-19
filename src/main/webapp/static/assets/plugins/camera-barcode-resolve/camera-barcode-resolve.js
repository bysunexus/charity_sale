//noinspection JSUnusedGlobalSymbols
/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/27
 * Time: 10:30
 */

/**
 * 标签id
 * @type {null}
 */
var elementId = null;

var CameraBarcodeResolve = function () {

  //noinspection JSUnusedGlobalSymbols
  return {
    /**
     * as回调方法
     * @param msg 返回值(解码后的code)
     */
    cameraDecodeCallback: function (msg) {
      if($(elementId) != undefined && $(elementId).val() != "" && $(elementId).val() != null) {
        bootbox.confirm("是否确定更新商品编号?", function () {
          //TODO:这里看下需不需要清空表单
          $(elementId).val(msg);
        });
      }else {
        $(elementId).val(msg);
      }
    },

    init: function (elId) {
      //noinspection JSUnusedAssignment,SillyAssignmentJS
      elementId = elId;

    }
  };

}();
