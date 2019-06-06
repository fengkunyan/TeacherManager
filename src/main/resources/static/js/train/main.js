function  openWin(title, url, buttonText,width, height, callback) {
    //如果是移动端，就使用自适应大弹窗
    if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
        width = 'auto';
        height = 'auto';
    }
    if ($.common.isEmpty(title)) {
        title = false;
    }
    ;
    if ($.common.isEmpty(url)) {
        url = "/404.html";
    }
    ;
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
        callback = function (index, layero) {
            var iframeWin = layero.find('iframe')[0];
            iframeWin.contentWindow.submitHandler();
        }
    }
    ;
    layui.use('layer', function () { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        layer.open({
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
    });
}

function openAdd() {
    openWin(option.modalTitle+"增加","add.jsp","保存");
}

function  opedAddDialog() {
    alert("win");
    $('#win').dialog({
        title: option.modalTitle,
        width: 950,
        height: 500,
        closed: false,
        cache: false,
        href: 'add.jsp',
        modal: true,
        buttons: [{
            text: '保存',
             handler: function ()
             {
                 alert("windows");
             }
         }, {
             text: '关闭',
             handler: function () {
                 win.dialog('close');
             }
         }],

    });
// }
//     var win = $("#win"); // 创建form表单元素
//     win.dialog({
//         title: option.modalTitle,
//         width: 950,
//         height: 500,
//         closed: false,
//         cache: false,
//         href: 'add.jsp',
//         modal: true,
//         buttons: [{
//             text: '保存',
//             handler: submit // 调用下面自定义方法ajaxSubmit()
//         }, {
//             text: '关闭',
//             handler: function () {
//                 win.dialog('close');
//             }
//         }],
//
//     });
}
