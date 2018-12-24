<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

<#include "/java_imports.include">

public class ${className}ServiceTest extends AbstractServiceTest{

    @Autowired
    private ${className}Service ${classNameLower}Service;
	
	@Test
	public void crud() {

		${className} obj = new${className}();
		${classNameLower}Service.create(obj);
		
		${classNameLower}Service.modify(obj);
		
		${classNameLower}Service.remove(obj.getId());
		
		${classNameLower}Service.getAll();
		
		${classNameLower}Service.search(obj);
	}
	
	public static ${className} new${className}() {
		${className} obj = new ${className}();
		<#list table.columns as column>
	  		<#if column.isNotIdOrVersionField>
	  			<#if column.isDateTimeColumn>
	  	obj.set${column.columnName}(new ${column.javaType}(System.currentTimeMillis()));
	  			<#else>
	  	obj.set${column.columnName}(new ${column.javaType}("1"));
	  			</#if>
			</#if>
		</#list>
		return obj;
	}
}
