<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>汉字业务名</title>
<h:base type="jquery-hp,hplus,hplisttools"></h:base>
<style>
    .col-sm-12{
        padding-right: 0;
        padding-left: 0;
    }
    .fixed-table-toolbar .columns{
        margin-top: 0;
        margin-bottom: 0;
    }
</style>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <h:datagrid name="${classNameLower}List" checkbox="true" fitColumns="false" title="" actionUrl="${classNameLower}Controller.do?datagrid" pagination="true" pageSize="10" idField="id" fit="true" queryMode="group">
            <h:dgCol title="主键" field="id" hidden="true" queryMode="single" width="120"></h:dgCol>
            <@generateFields/>
            <h:dgCol title="操作" field="opt" width="100"></h:dgCol>
            <h:dgDelOpt title="删除" url="${classNameLower}Controller.do?doDel&id={id}" />
            <h:dgFunOpt funname="dodetail(id,{'查看'},{'${classNameLower}Controller.do?goView'},{'800px'},{'500px'})" title="查看"></h:dgFunOpt>
            <h:dgToolBar title="新增" icon="icon-add" url="${classNameLower}Controller.do?goAdd" funname="add" styleClass="btn-primary" width="800px" height="520px"></h:dgToolBar>
            <h:dgToolBar title="编辑" icon="icon-edit" url="${classNameLower}Controller.do?goUpdate" funname="update" styleClass="btn-success" width="800px" height="520px"></h:dgToolBar>
            <h:dgToolBar title="批量删除" icon="icon-remove" url="${classNameLower}Controller.do?doBatchDel" funname="deleteALLSelect" styleClass="btn-warning" width="800px" height="520px"></h:dgToolBar>
        </h:datagrid>
    </div>
<script type="text/javascript">
/**
* 页面初始化方法
*/
$(document).ready(function() {
    $("#${classNameLower}List").on('click-row.bs.table', function (e, row, element){
        $('#${classNameLower}List tr.info').removeClass('info');//去除之前选中的行的，选中样式
        $(element).addClass('info');//添加当前选中的 info样式用于区别
    });
})
</script>
</body>
</html>
<#macro generateFields>
    <#list table.columns as column>
    <#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "deleteFlag" != column.columnNameLower>
            <h:dgCol title="${column.columnAlias}" field="${column.columnNameLower}" query="false" queryMode="single" width="120"></h:dgCol>
    </#if>
    </#list>
</#macro>