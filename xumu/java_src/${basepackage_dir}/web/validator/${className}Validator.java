<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ${basepackage}.entity.${className};
import com.hangutech.three.web.validator.BaseValidator;

/**
 * ${className}验证对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public class ${className}Validator extends BaseValidator<${className}> {
    /** 序列化ID */
    private static final long serialVersionUID = ${randomGen.nextLong()}L;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.hangutech.smartwork.web.validator.BaseValidator#validate(java.lang
     * .Object, org.springframework.validation.Errors)
     */
    public void validate(Object target, Errors errors) {
        ${className} ${classNameLower} = (${className}) target;
    }
}
