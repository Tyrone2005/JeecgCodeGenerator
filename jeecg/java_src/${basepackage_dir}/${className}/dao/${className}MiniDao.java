<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${className}.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;

import ${basepackage}.${className}.entity.${className};

/**
 * ${className} MiniDao
 * 
 * @author 修改成自己的名字
 * @version 1.0
 * 
 */
@MiniDao
public interface ${className}MiniDao {

    /**
     * 根据对象获取记录数
     * 
     * @param ${classNameLower}
     * @return
     */
    @Arguments("${classNameLower}")
    public long getCountBy${className}(${className} ${classNameLower});
}
