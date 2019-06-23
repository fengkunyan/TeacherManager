layui.use('layer', function () { //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
    window.openWin=function(title, url, buttonText,callback,width, height) {
    //如果是移动端，就使用自适应大弹窗
    if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
        width = 'auto';
        height = 'auto';
    };
    if ($.common.isEmpty(title)) {
        title = false;
    }
    ;
    if ($.common.isEmpty(url)) {
        url = "/404.html";
    };
    if ($.common.isEmpty(buttonText)) {
        buttonText = "确定";
    }
    ;
    if ($.common.isEmpty(width)) {
        width = 800;
    }
    ;
    if ($.common.isEmpty(height)) {
        height = ($(window).height() - 50);
    }
    ;
    if ($.common.isEmpty(callback)) {
        callback =function (index,layero) {
            var frameId=document.getElementById('owin').getElementsByTagName("iframe")[0].id;
            $('#'+frameId)[0].contentWindow.submitHandler();

        }
    };

        layer.open({
            id:"owin",
            type: 2,
            area: [width + 'px', height + 'px'],

            fix: false,
            //不固定
            maxmin: true,
            shade: 0.3,
            title: title,
            content: url,
            btn: [buttonText, '关闭'],
            // 弹层外区域关闭
            shadeClose: true,
            yes: callback,
            cancel: function (index) {
                layer.closeAll();
            }
        });

};
    window.closeWin=function()
    {
         layer.closeAll();
    }
    window.delRow=function (id) {
        layer.confirm('真的删除行么', function(index){
             layer.close(index);
            var uri = $.common.isEmpty(id) ? option.remove : option.remove.replace("{id}", id);
            alert(uri);
            var config = {
                url:uri ,
                type: "delete",
                dataType: "json",
                success: function(result) {

                    $("#dg").datagrid("reload");

                }
            };
            $.ajax(config);
            //向服务端发送删除指令
        });
    }
});


 function saveTab(url, data) {
     alert(url);
    var config = {
        url: url,
        type: "post",
        dataType: "json",
        data: data,
        success: function(result) {
           closeWin();
                 }
    };
    $.ajax(config);
}

function openAdd() {
    openWin(option.modalTitle+"增加",option.createUrl,"保存");
}
function deleteRow(id)
{
   delRow(id);

  }
  function  openEditDiag(id) {
      var uri = $.common.isEmpty(id) ? option.updateUrl : option.updateUrl.replace("{id}", id);
      openWin(option.modalTitle+"编辑",uri,"保存");

  }

