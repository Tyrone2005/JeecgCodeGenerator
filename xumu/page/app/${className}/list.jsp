<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="${"$"}{ctx}/static/script/PageList.js" type="text/javascript"></script>
<title>汉字业务名列表</title>
<script type="text/javascript">
	var pageList = new $.PageList();
	var parameter = {
		// 全选checkbox的id
		selectAllId: 'chkAll',
		// 列表中行选择的checkbox的名称
		rowCheckboxName: 'rowCheckBox',
		// 模块URL
		moduleUrl: '${"$"}{ctx}/app/业务模块名称/${classNameLower}'
	};
	pageList.init(parameter);
	//单行删除
	function deleteBtn(id){
		var form = $("#controlForm");
		var confirm = function (v, h, f) {
			if (v == 'ok') {
				form.attr("action", '${"$"}{ctx}/app/业务模块名称/${classNameLower}/delete/'+id).submit();
				return true;
			}else if (v == 'cancel') {
				return true;
			}
			return true;
		};
		$.jBox.confirm("确定要删除吗？", "提示", confirm, {top:'35%'});
	}
	function callbackHandlerRegion(name,code){
		document.getElementById("regionName").value = name;
		document.getElementById("regionCode").value = code;
	}
	function cleanDataRegion(v, h, f){
		if(v == 0){
			$('#regionName').val('');
			$('#regionCode').val('');
		}
	}
</script>
</head>
<body>
<div id="sidebar">
	<hgf:VerticalSingleLevelNavigation rootCode="修改成实际的菜单的根编号"/>
</div>
<div id="content">
	<form id="controlForm" action="" method="post">
		<input type="hidden" id="selectedItemIds" name="ids" />
	</form>
	<div class="search">
		<form:form id="searchForm" modelAttribute="breedingCompanySearchCondition" action="${"$"}{ctx}/app/业务模块名称/${classNameLower}/list.do" method="post">
			<form:hidden id="pageNumber" path="pageNumber" />
			<form:hidden id="pageSize" path="pageSize" />
			<!-- 在此自己添加查询条件 -->
			<span>
				<input type="submit" class="button" value="查询" />
			</span>
		</form:form>
	</div>
	<div class="tool">
		<input type="button" class="button" value="新增" onclick="pageList.gotoAddPage();" />
		<input type="button" class="button" value="删除" onclick="pageList.gotoDeletePage();" />
		<input type="button" class="button" value="导入" onclick="pageList.gotoImportPage('/Three/fileTemplet/${classNameLower}.xls');"/>
		<input type="button" class="button" value="导出" onclick="pageList.gotoExportPage();"/>
	</div>
	<c:if test="${"$"}{not empty message}">
		<div id="message" class="success">${"$"}{message}</div>
	</c:if>
	<table width="100%" class="tableUI">
		<thead>
			<tr>
				<th class="checkType">
					<input type="checkbox" name="checkbox" id="chkAll" value="off" onclick="pageList.selectAll()" />
				</th>
					<@generateHeadFields/>
				<th class="serialnoType">序号</th>
				<th class="toolIcoType">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${"$"}{records}" var="object" varStatus="c">
				<tr>
					<td class="alignCenter">
						<input type="checkbox" name="rowCheckBox" id="chk${"$"}{c.count}" value="${"$"}{object.id}" />
					</td>
					<td class="alignCenter">
						${"$"}{c.count}
					</td>
					<@generateFields/>
					<td class="alignCenter">
						<div class="toolIcoArea">
							<a href="show/${"$"}{object.id}" class="showIco" title="查看"></a>
							<a href="edit/${"$"}{object.id}" class="editIco" title="编辑"></a>
							<a href="javascript:deleteBtn('${"$"}{object.id}')" class="delIco" title="删除"></a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hgf:PagingNavigation />
</div>
<div style="display: none">
	<input id="messageDisplay" type="text" value=""/>
</div>
<div class="clear"></div>
</body>
</html>
<#macro generateHeadFields>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
				<th>${column.columnNameLower}</th>
	</#if>
	</#list>
</#macro>
<#macro generateFields>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
		<#if "java.lang.Boolean" = column.javaType>
					<td class="alignCenter">
						<hgf:BooleanValueTag value="${"$"}{object.${column.columnNameLower}}"/>
					</td>
		<#else>
					<#if "java.lang.Long" = column.javaType || "java.lang.Double" = column.javaType || "java.lang.Integer" = column.javaType>
					<td class="alignRight">
					</#if>
					<#if "java.lang.Object" = column.javaType>
					<td class="alignCenter">
					</#if>
					<#if "java.lang.String" = column.javaType>
					<td class="alignLeft">
					</#if>
					${"$"}{object.${column.columnNameLower}}
					</td>
		</#if>
	</#if>
	</#list>
</#macro>
