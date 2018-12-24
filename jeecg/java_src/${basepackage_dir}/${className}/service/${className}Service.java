<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${className}.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;

import ${basepackage}.${className}.entity.${className};

/**
 * ${className} service接口
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
public interface ${className}Service extends CommonService {

    public <T> void delete(T entity);

    public <T> Serializable save(T entity);

    public <T> void saveOrUpdate(T entity);

    /**
     * 默认按钮-sql增强-新增操作
     * 
     * @param ${classNameLower}
     * @return
     */
    public boolean doAddSql(${className} ${classNameLower});

    /**
     * 默认按钮-sql增强-更新操作
     * 
     * @param ${classNameLower}
     * @return
     */
    public boolean doUpdateSql(${className} ${classNameLower});

    /**
     * 默认按钮-sql增强-删除操作
     * 
     * @param ${classNameLower}
     * @return
     */
    public boolean doDelSql(${className} ${classNameLower});
}
