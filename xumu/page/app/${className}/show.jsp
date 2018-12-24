<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查看汉字业务名</title>
</head>
<body>
<div id="sidebar">
	<hgf:VerticalSingleLevelNavigation rootCode="修改成实际的菜单的根编号"/>
</div>
<div id="content">
	<table width="100%" class="tableEditMore">
		<tbody>
			<tr>
				<th colspan="2" class="tabcaption">汉字业务名</th>
			</tr>
			<@generateFields/>
			
		</tbody>
	</table>
	<div class="btnArea">
		<input id="cancel" class="button" type="button" value="返回" onclick="javascript:history.back();" />
	</div>
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
			<tr>
				<th class="leftLabel">${column.columnNameLower}</th>
				<td class="leftField">${"$"}{voModel.${column.columnNameLower}}</td>
			</tr>
	</#if>
	</#list>
</#macro>