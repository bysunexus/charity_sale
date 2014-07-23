var Account = function(){

  var initTree = function(treeId,inpId,data){
    var tree = $.fn.zTree.init($("#"+treeId), {
      data: {
        simpleData: {
          enable: true,
          idKey: "pkid",
          pIdKey: "pid",
          rootPId: ""
        }
      },
      callback: {
        onMouseDown: function(event, treeId, treeNode){
          $("#"+inpId).val(treeNode.pkid);
        }
      }
    }, data);
    tree.expandAll(true);
  }

  var loadTreeData = function(){
    $.ajax({
      type: "GET",
      url: ctx+"/user/menu",
      contentType:"application/json; charset=UTF-8",
      beforeSend: function () {
        //AJAX请求完成时显示提示，防止表单重复提交
        App.blockUI($("body"));
      },
      complete: function () {
        //AJAX请求完成时隐藏loading提示
        App.unblockUI($("body"));
      },
      success: function (resp) {
        if(resp.success){
          initTree("menuTreeDiv","menu_pid",resp.data);
          initTree("userMenuTreeDiv","MenuForm_menuId",resp.data);
        }else{
          bootbox.alert(data.msg||"操作失败,请重试或联系管理员!");
        }
      }
    });
  };

  return {
    saveUser:function(){
      $.ajax({
        type: "POST",
        url: ctx+"/user",
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
            bootbox.alert("保存成功");
          } else {
            bootbox.alert(data.msg||"操作失败,请重试或联系管理员!");
          }
        }
      });
    },
    loadTree:function(){
      loadTreeData();
    },
    saveMenu:function(){
      $.ajax({
        type: "POST",
        url: ctx+"/user/menu",
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
            bootbox.alert(data.msg||"操作失败,请重试或联系管理员!");
          }
        }
      });
    },
    saveUserMenu:function(){
      $.ajax({
        type: "POST",
        url: ctx+"/user/userMenu",
        data: $('#UserMenuForm').serializeForm(),
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
            bootbox.alert(data.msg||"操作失败,请重试或联系管理员!");
          }
        }
      });
    }
  };
}();

$(function(){
  Account.loadTree();
});