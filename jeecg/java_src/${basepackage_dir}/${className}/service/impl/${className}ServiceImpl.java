<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
package ${basepackage}.${className}.service.impl;

import java.io.Serializable;
import java.util.UUID;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.${className}.dao.${className}MiniDao;
import ${basepackage}.${className}.entity.${className};
import ${basepackage}.${className}.service.${className}Service;

/**
 * ${className} service实现类
 * 
 * @author 修改成自己的名字
 * @version 1.0
 * 
 */
@Service("${classNameLower}Service")
@Transactional
public class ${className}ServiceImpl extends CommonServiceImpl implements ${className}Service {

    @SuppressWarnings("unused")
    private SystemService systemService;

    @Autowired
    private ${className}MiniDao ${classNameLower}MiniDao;

    public <T> void delete(T entity) {
        super.delete(entity);
        // 执行删除操作配置的sql增强
        this.doDelSql((${className}) entity);
    }

    public <T> Serializable save(T entity) {
        Serializable t = super.save(entity);
        // 执行新增操作配置的sql增强
        this.doAddSql((${className}) entity);
        return t;
    }

    public <T> void saveOrUpdate(T entity) {
        super.saveOrUpdate(entity);
        // 执行更新操作配置的sql增强
        this.doUpdateSql((${className}) entity);
    }

    /**
     * 默认按钮-sql增强-新增操作
     * 
     * @param id
     * @return
     */
    public boolean doAddSql(${className} ${classNameLower}) {
        return true;
    }

    /**
     * 默认按钮-sql增强-更新操作
     * 
     * @param id
     * @return
     */
    public boolean doUpdateSql(${className} ${classNameLower}) {
        return true;
    }

    /**
     * 默认按钮-sql增强-删除操作
     * 
     * @param id
     * @return
     */
    public boolean doDelSql(${className} ${classNameLower}) {
        return true;
    }

    /**
     * 替换sql中的变量
     * 
     * @param sql
     * @return
     */
    public String replaceVal(String sql, ${className} ${classNameLower}) {
        <#list table.columns as column>
        sql = sql.replace("<@mapperEl column.columnNameFirstLower />", String.valueOf(${classNameLower}.get${column.columnName}()));
        </#list>
        sql = sql.replace("<@mapperEl 'UUID' />", UUID.randomUUID().toString());
        return sql;
    }
}
