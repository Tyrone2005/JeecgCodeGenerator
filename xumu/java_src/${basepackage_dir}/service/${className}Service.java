<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.stereotype.Service;

import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.vo.searcher.${className}SearchCondition;
import com.hangutech.three.service.EntityService;

/**
 * ${className} service接口
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public interface ${className}Service extends EntityService<${className}, ${className}SearchCondition>{
}
