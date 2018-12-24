<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import com.hangutech.three.dao.entity.BaseEntity;
/**
 * ${className}实体对象
 * 
 * @author 李显锋
 * @version 1.0
 */
public class ${className} extends BaseEntity {
    /** 序列化ID */
    private static final long serialVersionUID = ${randomGen.nextLong()}L;
	<@generateFields/>

	<@generateProperties/>
}

<#macro generateFields>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createdBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
	/** ${column.columnAlias} */
	private ${column.javaType} ${column.columnNameLower} = null;
    </#if>
	</#list>
</#macro>

<#macro generateProperties>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createdBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
	/**
     * @return the ${column.columnNameLower}
     */
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	/**
     * @param ${column.columnNameLower} the ${column.columnNameLower} to set
     */
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	</#if>	
	</#list>
</#macro>



