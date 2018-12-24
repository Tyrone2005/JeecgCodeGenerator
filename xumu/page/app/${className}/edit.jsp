<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑汉字业务名</title>
<jsp:include page="/static/jquery-validation/1.9.0/validate.jsp" flush="false" />
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#第一个输入框的ID").focus();
		// 输入验证
		$("#addForm").validate({
			rules : {
			/*
			在此加入验证代码
			*/
			},
			messages : {
			/*
			在此加入验证消息
			*/
			}
		});
	});
</script>
</head>
<body>
<div id="sidebar">
	<hgf:VerticalSingleLevelNavigation rootCode="修改成实际的菜单的根编号"/>
</div><div id="content">
<form:form id="editForm"  modelAttribute="voModel" action="${"$"}{ctx}/app/业务模块名称/${classNameLower}/update.do" method="post">
	<form:hidden id="id" path="id" />
	<form:hidden id="version" path="version" />
	<table width="100%" class="tableEditMore">
		<tbody>
	<@generateFields/>
		</tbody>
	</table>
	<div class="btnArea">
		<input id="submit" class="button" type="submit" value="提交" />
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
</form:form>
</div>
<div class="clear"></div>
</body>
</html>
<#macro generateFields>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
			<tr>
				<th class="leftLabel"><label for="${column.columnNameLower}"><font class="highlight">*</font>${column.columnNameLower}:</label></th>
				<td class="leftField"><input type="text" id="${column.columnNameLower}" name="${column.columnNameLower}" maxlength="20" class="textbox"/><form:errors path="${column.columnNameLower}" cssClass="error"/></td>
			</tr>
	</#if>
	</#list>
</#macro>