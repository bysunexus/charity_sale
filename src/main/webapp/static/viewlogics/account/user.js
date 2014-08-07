var Account = function () {
  var checkedRadio = function(radio,isChecked){
    if(isChecked){
      radio.attr('checked', 'checked');
      $(radio.parent()).addClass("checked");
    }else{
      radio.attr('checked', '');
      $(radio.parent()).removeClass("checked");
    }
  };
  var initTree = function (treeId, mouseFn, data, check) {
    var tree = $.fn.zTree.init($("#" + treeId), {
      data: {
        simpleData: {
          enable: true,
          idKey: "pkid",
          pIdKey: "pid",
          rootPId: ""
        }
      },
      callback: {
        onMouseDown: mouseFn
      },
      check: check
    }, data);
    tree.expandAll(true);
  };

  var loadTreeData = function () {
    $.ajax({
      type: "GET",
      url: ctx + "/user/menu",
      contentType: "application/json; charset=UTF-8",
      beforeSend: function () {
        //AJAX请求完成时显示提示，防止表单重复提交
        App.blockUI($("body"));
      },
      complete: function () {
        //AJAX请求完成时隐藏loading提示
        App.unblockUI($("body"));
      },
      success: function (resp) {
        if (resp.success) {
          initTree("menuTreeDiv", function (event, treeId, treeNode) {
            if (treeNode && treeNode.pkid)
              $("#menu_pid").val(treeNode.pkid);
          }, resp.data);
          initTree("userMenuTreeDiv", function () {
          }, resp.data, {
            chkboxType: { "Y": "ps", "N": "ps" },
            enable: true

          });
        } else {
          bootbox.alert((data?data.msg:0) || "操作失败,请重试或联系管理员!");
        }
      }
    });
  };

  return {
    saveUser: function () {
      $.ajax({
        type: "POST",
        url: ctx + "/user",
        data: $('#userForm').serializeForm(),
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
            COMMONS.resetForm("userForm");
            checkedRadio($("#userForm :radio"));
            bootbox.alert("保存成功");
          } else {
            bootbox.alert((data?data.msg:0)  || "操作失败,请重试或联系管理员!");
          }
        }
      });
    },
    loadTree: function () {
      loadTreeData();
    },
    saveMenu: function () {
      $.ajax({
        type: "POST",
        url: ctx + "/user/menu",
        data: $('#MenuForm').serializeForm(),
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
            COMMONS.resetForm("MenuForm");
            loadTreeData();
            bootbox.alert("保存成功");
          } else {
            bootbox.alert((data?data.msg:0)  || "操作失败,请重试或联系管理员!");
          }
        }
      });
    },
    saveUserMenu: function () {
      var menuIds = [];
      $.each($.fn.zTree.getZTreeObj("userMenuTreeDiv").getCheckedNodes(),
        function (idx, n) {
          menuIds.push(n.pkid);
        }
      );


      $.ajax({
        type: "POST",
        traditional:true,
        url: ctx + "/user/userMenu",
        data: {
          userName: $("#umf_userName").val(),
          menuIds: menuIds
        },
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
            COMMONS.resetForm("UserMenuForm");
            bootbox.alert("保存成功");
          } else {
            bootbox.alert((data?data.msg:0)  || "操作失败,请重试或联系管理员!");
          }
        }
      });
    }
  };
}();

$(function () {
  Account.loadTree();
});