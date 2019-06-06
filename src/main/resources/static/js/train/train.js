/**
 * 通用js方法封装处理
 * Copyright (c) 2019 wowx
 */
(function ($) {
    $.extend({
    	// 表格封装处理
    	table: {
            _option: {},
            // 初始化表格参数
            init: function (options) {
                var defaults = {
                    id: "dg",
                    striped: true,
                    method: 'post',
                    checkOnSelect: true,
                    pagePosition: 'bottom',
                    sortName: "",
                    sortOrder: "asc",
                    pagination: true,
                    pageSize: 10,
                    toolbar: 'toolbar',
                    showFooter: true,
                    showHeader: true,
                    queryParams: $.table.queryParams,
                };
                var options = $.extend(defaults, options);
                $.table._option = options;
                $('#' + options.id).datagrid({
                    url: options.url,                                   // 请求后台的URL（*）
                    striped: options.striped,                           // 是否显示行间隔色
                    sortName: options.sortName,                         // 排序列名称
                    sortOrder: options.sortOrder,                       // 排序方式  asc 或者 desc
                    pagination: options.pagination,                     // 是否显示分页（*）
                    pageNumber: 1,                                      // 初始化加载第一页，默认第一页
                    pageSize: options.pageSize,                         // 每页的记录行数（*） 
                    pageList: [10, 25, 50],                             // 可供选择的每页的行数（*）
                    //showFooter: options.showFooter,                     // 是否显示表尾
                    toolbar: '#' + options.toolbar,                     // 指定工作栏
                    queryParams: options.queryParams,                   // 传递参数（*）
                    columns: options.columns,							// 显示列信息（*）
                  //  loader: $.table.onLoadSuccess,                       // 当所有数据被加载时触发处理函数

                });
            },
            // 查询条件
            queryParams: function (params) {
                return {
                    // 传递参数查询参数
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    searchValue: params.search,
                    orderByColumn: params.sort,
                    isAsc: params.order
                };
            },


            // 当所有数据被加载时触发
            onLoadSuccess: function (data) {
                // 浮动提示框特效
                $("[data-toggle='tooltip']").tooltip();
            },
            // 表格销毁
            destroy: function (tableId) {
                var currentId = $.common.isEmpty(tableId) ? $.table._option.id : tableId;
                $("#" + currentId).bootstrapTable('destroy');
            },
            // 序列号生成
            serialNumber: function (index) {
                var table = $('#' + $.table._option.id).bootstrapTable('getOptions');
                var pageSize = table.pageSize;
                var pageNumber = table.pageNumber;
                return pageSize * (pageNumber - 1) + index + 1;
            }
        },

        // 通用方法封装处理
    	common: {
    		formatDate:function(value)
			{
				if(this.isEmpty(value))
				{
					return "";
				}
				return  value.split("T")[0];
			},
    		// 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },
            // 判断一个字符串是否为非空串
            isNotEmpty: function (value) {
            	return !$.common.isEmpty(value);
            },
            // 空对象转字符串
            nullToStr: function(value) {
                if ($.common.isEmpty(value)) {
                    return "-";
                }
                return value;
            },
            // 是否显示数据 为空默认为显示
            visible: function (value) {
                if ($.common.isEmpty(value) || value == true) {
                    return true;
                }
                return false;
            },
            // 空格截取
            trim: function (value) {
                if (value == null) {
                    return "";
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            },
            // 字符串格式化(%s )
            sprintf: function (str) {
                var args = arguments, flag = true, i = 1;
                str = str.replace(/%s/g, function () {
                    var arg = args[i++];
                    if (typeof arg === 'undefined') {
                        flag = false;
                        return '';
                    }
                    return arg;
                });
                return flag ? str : '';
            },
            // 指定随机数返回
            random: function (min, max) {
                return Math.floor((Math.random() * max) + min);
            },
            // 判断字符串是否是以start开头
            startWith: function(value, start) {
                var reg = new RegExp("^" + start);
                return reg.test(value)
            },
            // 判断字符串是否是以end结尾
            endWith: function(value, end) {
                var reg = new RegExp(end + "$");
                return reg.test(value)
            },
            // 数组去重
            uniqueFn: function(array) {
                var result = [];
                var hashObj = {};
                for (var i = 0; i < array.length; i++) {
                    if (!hashObj[array[i]]) {
                        hashObj[array[i]] = true;
                        result.push(array[i]);
                    }
                }
                return result;
            }
    	},
        modal: {
            opedAddDialog: function () {
                alert("win");
                $('#win').dialog({
                    title: 'My Dialog',
                    width: 400,
                    height: 200,
                    closed: false,
                    cache: false,
                    href: 'add.jsp',
                    modal: true
                });
            }
        }
        });

})(jQuery);



function openEditDiag(id) {
    var $editDialog = $('<form  id="myDialog" method="get"></form>'); // 创建form表单元素
    $editDialog.iDialog({
        title: '编辑数据',
        width: 950,
        height: 500,
        closed: false,
        cache: false,
        href: _ctx + '/html/complex/dialog_edit.html?uuid=' + uuid,
        modal: true,
        buttons: [{
            text: '保存',
            iconCls: 'fa fa-save',
            btnCls: 'topjui-btn-blue',
            handler:ajaxSubmit // 调用下面自定义方法ajaxSubmit()
        }, {
            text: '关闭',
            iconCls: 'fa fa-close',
            btnCls: 'topjui-btn-red',
            handler: function () {
                $editDialog.iDialog('close');
            }
        }],
        onLoad: function () {
            //加载表单数据
            $.getJSON(_ctx + '/json/datagrid/product-detail.json?uuid=' + uuid, function (data) {
                $editDialog.form('load', data);
            });
        }
    });
}
