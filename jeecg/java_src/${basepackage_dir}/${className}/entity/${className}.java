<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${className}.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
/**
 * ${className}实体对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
@Entity
@Table(name = "${table.sqlName}", schema = "")
@SuppressWarnings("serial")
public class ${className} implements java.io.Serializable {

    <@generateFields/>

    <@generateProperties/>
}

<#macro generateFields>
    <#list table.columns as column>
    /**
     * ${column.columnAlias}
     */
    @Excel(name = "${column.columnAlias}")
    private ${column.javaType} ${column.columnNameLower} = null;
    </#list>
</#macro>

<#macro generateProperties>
    <#list table.columns as column>
    <#if "id" == column.columnNameLower>
    /**
     * @return the ${column.columnNameLower}
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "${column.sqlName}", nullable = false, length = 36)
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

    <#if "id" != column.columnNameLower>
    /**
     * @return the ${column.columnNameLower}
     */
    @Column(name = "${column.sqlName}", nullable = false)
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
