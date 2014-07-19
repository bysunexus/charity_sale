/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/6/23
 * Time: 20:25
 */
var Storage = function () {

  var handleValidation = function () {
    // for more info visit the official plugin documentation:
    // http://docs.jquery.com/Plugins/Validation

    var form = $('#storage');
    var err = $('.alert-danger', form);
    var success = $('.alert-success', form);

    form.validate({
      errorElement: 'span',
      errorClass: 'help-block',
      focusInvalid: false,
      ignore: "",
      rules: {
        goodsNum: {
          minlength: 2,
          maxlength: 4,
          required: true
        },
        goodsCount: {
          required: true,
          digits: true
        },
        goodsPrice: {
          required: true,
          digits: true
        }
      },

      invalidHandler: function (event, validator) { //display error alert on form submit
        success.hide();
        err.show();
        App.scrollTo(err, -200);
      },

      errorPlacement: function (error, element) { // render error placement for each input type
        var icon = $(element).parent('.input-icon').children('i');
        icon.removeClass('fa-check').addClass("fa-warning");
        icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
      },

      highlight: function (element) { // hightlight error inputs
        $(element)
          .closest('.form-group').addClass('has-error'); // set error class to the control group
      },

      unhighlight: function (element) { // revert the change done by hightlight

      },

      success: function (label, element) {
        var icon = $(element).parent('.input-icon').children('i');
        $(element).closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
        icon.removeClass("fa-warning").addClass("fa-check");
      },

      submitHandler: function (form) {
        success.show();
        err.hide();
      }
    });
  };

  var handleWysihtml5 = function () {
    if (!jQuery().wysihtml5) {

      return;
    }

    if ($('.wysihtml5').size() > 0) {
      $('.wysihtml5').wysihtml5({
        "stylesheets": [ctx + "/static/assets/plugins/bootstrap-wysihtml5/wysiwyg-color.css"]
      });
    }
  };

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
          if (data.data) {
            //noinspection JSUnresolvedVariable
            $("#pkid").val(data.data.pkid);
            bootbox.confirm("此商品信息已存在,是否要更新?", function (result) {
              if(result) {
                Storage.save();
              }else {
                $("#goodsCount").val(data.data.goodsCount);
                $("#goodsPrice").val(data.data.goodsPrice);
              }
            });
          } else {
            Storage.save();
          }
        }
      });
    },

    save: function () {
      if (!$("#storage").valid())
        return;

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
          if (data.success) {
            bootbox.alert("保存成功");
            $('#storage')[0].reset();
          }else{
            bootbox.alert("数据错误保存失败");
            COMMONS.validFail("storage",data);
          }
        }
      });
    },

    init: function () {
      handleWysihtml5();
      handleValidation();
    }

  };
}();

/**
 * 创建摄像头解码监听
 * @param msg
 */
function callfromAs (msg) {
  alert($("#goodsNum").length);
  if($("#goodsNum").length) {
    bootbox.confirm("是否确定更新商品编号?", function () {
      //TODO:这里看下需不需要清空表单
      $("#goodsNum").val(msg);
    });
  }
}

$(function () {
  Storage.init();
  CameraBarcodeResolve.init("#goodsNum");
});