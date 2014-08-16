/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/8/7
 * Time: 20:09
 */
var PaddedPost = function () {

  var paddedPostRadiosListener = function () {

    $("input[name='paddedPostRadios']").click(function () {
      bulidVw($(this).val());
    });

  };

  var bulidVw = function (selectVal) {
    // 金额
    if (selectVal == 0) {
      $("#paddedPostDiv").find("label").html('补差金额:<span class="required">*</span>');
    }

    // 件数
    if (selectVal == 1) {
      $("#paddedPostDiv").find("label").html('补差件数:<span class="required">*</span>');
    }
  };

  var handleValidation = function () {
    // for more info visit the official plugin documentation:
    // http://docs.jquery.com/Plugins/Validation

    var form = $('#paddedPost');
    var err = $('.alert-danger', form);
    var success = $('.alert-success', form);

    //noinspection JSUnusedLocalSymbols
    form.validate({
      focusCleanup: true,
      errorElement: 'span',
      errorClass: 'help-block',
      focusInvalid: false,
      ignore: "",
      rules: {
        goodsNum: {
          minlength: 1,
          maxlength: 4,
          required: true
        },
        paddedPostValue: {
          required: true
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

  var jsresetform = function () {
    $("input").val("");
  };

  return {

    save: function () {
      if (!$("#paddedPost").valid())
        return;

      var dataForm = $('#paddedPost').serializeForm();
      var vStr = Number(dataForm.paddedPostValue) > 0 ?"增加":"减少";
      vStr += Math.abs(Number(dataForm.paddedPostValue));

      bootbox.confirm("确认对捐品["+dataForm.goodsNum+"]进行"+(dataForm.paddedPostRadios=="1"?"补件:<h3>"+vStr+"件":"补价:<h3>"+vStr+"元")+"</h3>", function (result) {
        if (result) {
          //noinspection JSUnresolvedVariable
          var saveUrl = ctx + "/paddedPost/save";
          $.ajax({
            type: "POST",
            url: saveUrl,
            data: dataForm,
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
                jsresetform();

                $("input[name='paddedPostRadios']").removeAttr("checked");
                $("#dftRadio").attr("checked");
                $("#paddedPostDiv").find("label").html('补差金额:<span class="required">*</span>');

              } else {
                if(!$.isEmptyObject(data.data)) {
                  bootbox.alert(data.data.paddedPostDto[0]);
                  App.unblockUI($("body"));
                }else {
                  bootbox.alert(data.msg);
                  App.unblockUI($("body"));
                }
              }
            }
          });
        }
      });
    },

    init: function () {
      paddedPostRadiosListener();
      handleValidation();
    }

  };

}();


$(function () {
  PaddedPost.init();
  CameraBarcodeResolve.init("#goodsNum");
});
