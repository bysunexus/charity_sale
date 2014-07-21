/**
 * Created with IntelliJ IDEA.
 * User: Watson
 * Date: 2014/7/21
 * Time: 17:28
 */
var Login = function () {

  var handleLogin = function() {
    //noinspection JSUnusedLocalSymbols
    $('.login-form').validate({
      errorElement: 'span', //default input error message container
      errorClass: 'help-block', // default input error message class
      focusInvalid: false, // do not focus the last invalid input
      rules: {
        username: {
          required: true
        },
        password: {
          required: true
        }
      },

      messages: {
        username: {
          required: "用户名不能为空."
        },
        password: {
          required: "密码不能为空."
        }
      },

      invalidHandler: function (event, validator) { //display error alert on form submit
        $('.alert-danger', $('.login-form')).show();
      },

      highlight: function (element) { // hightlight error inputs
        $(element)
          .closest('.form-group').addClass('has-error'); // set error class to the control group
      },

      success: function (label) {
        label.closest('.form-group').removeClass('has-error');
        label.remove();
      },

      errorPlacement: function (error, element) {
        error.insertAfter(element.closest('.input-icon'));
      },

      submitHandler: function (form) {
        form.submit();
      }
    });

    $('.login-form input').keypress(function (e) {
      if (e.which == 13) {
        //noinspection JSJQueryEfficiency
        if ($('.login-form').validate().form()) {
          $('.login-form').submit();
        }
        return false;
      }
    });
  };

  return {
    //main function to initiate the module
    init: function () {
      handleLogin();

      $.backstretch([
          ctx + "/static/assets/img/bg/1.jpg",
          ctx + "/static/assets/img/bg/2.jpg",
          ctx + "/static/assets/img/bg/3.jpg",
          ctx + "/static/assets/img/bg/4.jpg"
      ], {
        fade: 1000,
        duration: 8000
      });
    }

  };

}();

$(function () {
  Login.init();
});