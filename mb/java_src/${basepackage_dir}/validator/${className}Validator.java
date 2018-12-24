<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.validator;

import ${basepackage}.model.${className};
import com.hengyun.fw.validator.BaseValidator;
import com.jfinal.core.Controller;

/**
 * ${className}验证对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public class ${className}Validator extends BaseValidator {

    @Override
    protected void validate(Controller controller) {
        // 验证方法
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepModel(${className}.class);
        String actionKey = getActionKey();
        if (actionKey.equals("/${classNameLower}/save")) {
            controller.render("add.html");
        } else if (actionKey.equals("/${classNameLower}/update")) {
            controller.render("edit.html");
        }
    }
}
