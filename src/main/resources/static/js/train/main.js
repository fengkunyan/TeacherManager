
function openWin()
{
    //alert("weinf");
    layui.use('layer', function() { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
        var win=layer.open(
            {
                type:2,
                title:'信息',
                content:"add.jsp",
                area: ['1000px', '600px']
                ,offset: [
                       50,
                       80
                     ]
                ,shade: 0
                ,maxmin: true
                ,btn: ['继续弹出', '全部关闭']
                     ,yes: function(){

                    }
                     ,btn2: function(){
                        layer.closeAll();
                    }

            })
       // layer.full(win);
        }
        )

    }


//}


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
