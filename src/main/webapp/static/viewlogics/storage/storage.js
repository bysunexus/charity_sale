/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/23
 * Time: 20:25
 */
var Storage = function () {

  return {
    check: function () {
      //noinspection JSUnresolvedVariable
      var checkUrl = ctx + "/storage/check/" + $("#goodsNum").val();
      $.ajax({
        type: "POST",
        url: checkUrl,
        data: $('#storage').serializeForm(),
        beforeSend: function () {
          //AJAX请求完成时显示提示，防止表单重复提交
          App.blockUI($("body"));
        },
        complete: function () {
          //AJAX请求完成时隐藏loading提示
          App.unblockUI($("body"));
        },
        success: function (data) {
          if(data.data) {
            //noinspection JSUnresolvedVariable
            $("#pkid").val(data.data.pkid);
            bootbox.confirm("此商品信息已存在,是否要更新?", function() {
              Storage.save();
            });
          }else {
            Storage.save();
          }
        }
      });
    },

    save: function () {
      //noinspection JSUnresolvedVariable
      var saveUrl = ctx + "/storage/save";
      $.ajax({
        type: "POST",
        url: saveUrl,
        data: $('#storage').serializeForm(),
        beforeSend: function () {
          //AJAX请求完成时显示提示，防止表单重复提交
          App.blockUI($("body"));
        },
        complete: function () {
          //AJAX请求完成时隐藏loading提示
          App.unblockUI($("body"));
        },
        success: function (data) {
          if(data.success) {
            bootbox.alert("保存成功");
            $('#storage')[0].reset();
          }
          if(data.data == null) {
            bootbox.alert(data.msg);
          }else {
            bootbox.alert(data.msg);
          }
        }
      });
    }

  };
}();