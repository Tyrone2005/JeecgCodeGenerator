<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model.base;

import com.hengyun.fw.model.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Base${className} Bean
 * 
 * @author 史俊宝
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Base${className}<M extends Base${className}<M>> extends BaseModel<M> implements IBean {

    <@generateFields/>

    <@generateProperties/>

<#macro generateFields>
    <#list table.columns as column>
    /**
     * ${column.columnAlias}
     */
    private ${column.javaType} ${column.columnNameLower} = null;
    </#list>
</#macro>

<#macro generateProperties>
    <#list table.columns as column>
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
    </#list>
</#macro>
}
