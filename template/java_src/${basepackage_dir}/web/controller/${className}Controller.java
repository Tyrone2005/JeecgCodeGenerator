<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.vo.searcher.${className}SearchCondition;
import ${basepackage}.vo.${className}Vo;

import com.hangutech.three.web.controller.AjaxEntityController;
import ${basepackage}.web.validator.${className}Validator;

/**
 * ${className}Controller对象
 * 
 * @author 李显锋
 * @version 1.0
 */
@Controller
@RequestMapping("/${classNameLower}/*")
public class ${className}Controller extends AjaxEntityController<${className}Vo, ${className}SearchCondition> {
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
    /**
     * @param service the service to set
     */
    @Autowired
    public void set${className}Service(${className}Service service) {
        setEntityService(service);
    }
    
    public ${className}Controller() {
        super();
        addValidator = new ${className}Validator();
        editValidator = addValidator;
    }
}
