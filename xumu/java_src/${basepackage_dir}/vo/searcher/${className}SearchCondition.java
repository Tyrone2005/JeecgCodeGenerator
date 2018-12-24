<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.vo.searcher;

import com.hangutech.three.vo.SearchCondition;

/**
 * ${className}查询条件对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public class ${className}SearchCondition extends SearchCondition {
    /** 序列化ID */
    private static final long serialVersionUID = ${randomGen.nextLong()}L;
	<@generateFields/>

	<@generateProperties/>
}

<#macro generateFields>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
	<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
	/** ${column.columnNameLower}Begin */
    private ${column.javaType} ${column.columnNameLower}Begin = null;
    /** ${column.columnNameLower}End */
    private ${column.javaType} ${column.columnNameLower}End = null;
    <#else>
	/** ${column.columnAlias} */
	private ${column.javaType} ${column.columnNameLower} = null;
	</#if>
	</#if>
	</#list>
</#macro>

<#macro generateProperties>
	<#list table.columns as column>
	<#if "id" != column.columnNameLower && "createBy" != column.columnNameLower && "createDate" != column.columnNameLower && "updateBy" != column.columnNameLower && "updateDate" != column.columnNameLower && "status" != column.columnNameLower && "version" != column.columnNameLower>
	<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
	/**
     * @return the ${column.columnNameLower}Begin
     */
	public ${column.javaType} get${column.columnName}Begin() {
        return this.${column.columnNameLower}Begin;
    }
	/**
     * @param ${column.columnNameLower}Begin the ${column.columnNameLower}Begin to set
     */
    public void set${column.columnName}Begin(${column.javaType} ${column.columnNameLower}Begin) {
        this.${column.columnNameLower}Begin = ${column.columnNameLower}Begin;
    }   
    /**
     * @return the ${column.columnNameLower}End
     */
    public ${column.javaType} get${column.columnName}End() {
        return this.${column.columnNameLower}End;
    }
    /**
     * @param ${column.columnNameLower}End the ${column.columnNameLower}End to set
     */
    public void set${column.columnName}End(${column.javaType} ${column.columnNameLower}End) {
        this.${column.columnNameLower}End = ${column.columnNameLower}End;
    }
    <#else>
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
	</#if>
	</#list>
</#macro>



