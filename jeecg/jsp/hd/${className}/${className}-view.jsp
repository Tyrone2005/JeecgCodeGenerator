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
<style>
    tr>th{width: 20%;text-align: right;background: #F9F9F9;}
    tr>th>label{margin-bottom: 0;}
    tr>td{width: 80%;}
    tr>td>span{word-break: break-all;}
    .mar-t{margin-top: 15px;}
</style>
</head>
<body>
    <div class="wrapper wrapper-content animated mar-t">
        <table class="table table-bordered">
            <tbody>
            <@generateFields/>
            </tbody>
        </table>
    </div>
    <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js"></script>
<script src="plug-in/hplus/js/bootstrap.min.js"></script>
<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>
<!-- 下拉列表 -->
<script src="plug-in/hplus/js/plugins/chosen/chosen.jquery.js"></script>
<!--固定格式-->
<script src="plug-in/hplus/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
<script type="text/javascript" src="plug-in/tools/layertools_zh-cn.js"></script>
</body>
</html>
<#macro generateFields>
    <#list table.columns as column>
    <#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "deleteFlag" != column.columnNameLower>
                <tr>
                    <th><label>${column.columnAlias}</label></th>
                    <td><span>${"$"}{${classNameLower}Page.${column.columnNameLower}}</span></td>
                </tr>
    </#if>
    </#list>
</#macro>