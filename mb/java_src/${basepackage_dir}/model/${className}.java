<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

import ${basepackage}.model.base.Base${className};
/**
 * ${className} Model
 * 
 * @author 史俊宝
 * @version 1.0
 */
public class ${className} extends Base${className}<${className}>{
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = ${randomGen.nextLong()}L;

    public static final ${className} dao = new ${className}();

    @Override
    public String getSqlNamespace() {
        return "mb.${classNameLower}";
    }
}
