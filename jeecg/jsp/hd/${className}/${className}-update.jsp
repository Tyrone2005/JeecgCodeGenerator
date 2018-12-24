<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>汉字业务名</title>
<h:base type="jquery-hp,hplus"></h:base>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="plug-in/hplus/css/bootstrap.min.css" rel="stylesheet" />
<link href="plug-in/hplus/css/font-awesome.min.css" rel="stylesheet" />
<link href="plug-in/hplus/css/animate.css" rel="stylesheet" />
<link href="plug-in/hplus/css/style.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/summernote/summernote.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/summernote/summernote-bs3.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/clockpicker/clockpicker.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/chosen/chosen.css" rel="stylesheet" />
<link href="plug-in/hplus/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css" />
<link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css" />
</head>
<body class="add-dis">
    <form id="formobj" class="form-horizontal m-t" role="form" action="${classNameLower}Controller.do?doUpdate" name="formobj" method="post">
        <input type="hidden" id="btn_sub" class="btn_sub" />
        <input id="id" name="id" type="hidden" value="${"$"}{${classNameLower}Page.id }">
        <div class="wrapper wrapper-content animated">
            <div class="row">
            <@generateFields/>
            </div>
        </div>
        <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
    </form>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js"></script>
<script src="plug-in/hplus/js/bootstrap.min.js"></script>
<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>
<!--时间-->
<script src="plug-in/hplus/js/plugins/layer/laydate/laydate.js"></script>
<!--编辑器-->
<script src="plug-in/hplus/js/plugins/summernote/summernote.min.js"></script>
<script src="plug-in/hplus/js/plugins/summernote/summernote-zh-CN.js"></script>
<!-- 下拉列表 -->
<script src="plug-in/hplus/js/plugins/chosen/chosen.jquery.js"></script>
<!--固定格式-->
<script src="plug-in/hplus/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<script type="text/javascript" src="plug-in/tools/layertools_zh-cn.js"></script>
<script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
<script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
<script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
<script type="text/javascript">
$(function() {
    $("#formobj").Validform({
        tiptype: 1,
        btnSubmit: "#btn_sub",
        btnReset: "#btn_reset",
        ajaxPost: true,
        beforeSubmit: function(curform) {
            var tag = true;
            //提交前处理
            return tag;
        },
        usePlugin: {
        },
        callback: function(data) {
            if (data.success == true) {
                parent.reloadTable();
                layer.alert(data.msg, {icon: 1},
                function() {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                });
            } else {
                if (data.responseText == '' || data.responseText == undefined) {
                    layer.alert(data.msg, {icon: 2});
                } else {
                    try {
                        var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
                        layer.alert(emsg, {icon: 2});
                    } catch(ex) {
                        layer.alert(data.responseText, {icon: 2});
                    }
                }
                return false;
            }
        }
    });
});
</script>
</body>
</html>
<#macro generateFields>
    <#list table.columns as column>
    <#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "deleteFlag" != column.columnNameLower>
                <div class="form-group draggable">
                    <label class="col-sm-2 control-label"><font color="red">*</font>${column.columnAlias}</label>
                    <div class="col-sm-4">
                        <input id="${column.columnNameLower}" name="${column.columnNameLower}" type="text" class="form-control input-sm" value='${"$"}{${classNameLower}Page.${column.columnNameLower}}'>
                        <span class="Validform_checktip" style="float: left; height: 0px;"></span>
                        <label class="Validform_label" style="display: none">${column.columnAlias}</label>
                    </div>
                </div>
    </#if>
    </#list>
</#macro>