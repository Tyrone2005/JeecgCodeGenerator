<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basepackage}.dao.${className}DAO;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.vo.searcher.${className}SearchCondition;
import com.hangutech.three.service.EntityServiceImpl;
/**
 * ${className} service实现类
 * 
 * @author 修改成自己的名字
 * @version 1.0
 * 
 */
@Service(value = "${classNameLower}Service")
public class ${className}ServiceImpl extends EntityServiceImpl<${className}, ${className}SearchCondition> implements ${className}Service {
    /**
     * ${className} DAO
     */
    private ${className}DAO ${classNameLower}Dao;
    
    @Autowired
    public void set${className}Dao(${className}DAO ${classNameLower}DAO) {
        this.${classNameLower}Dao = ${classNameLower}DAO;
        this.baseDao = ${classNameLower}DAO;
    }
}
