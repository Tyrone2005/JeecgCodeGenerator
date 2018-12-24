<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import java.util.HashMap;
import java.util.Map;

import com.hengyun.fw.controller.BaseController;
import com.hengyun.fw.jfinal.plugins.sqlinxml.SqlXml;
import ${basepackage}.Constants;
import ${basepackage}.model.QbTjwjqkMbZmb;
import com.jfinal.plugin.activerecord.Page;

/**
 * ${className} Controller 
 * 
 * @author shijunbao
 * @version 1.0
 */
public class ${className}Controller extends BaseController {
    // 业务编码
    public static String BIZ_CODE = "${classNameLower}";
    // 查询条件session key (${classNameLower}SearchCondition)
    public static String SESSION_KEY_SC = BIZ_CODE + Constants.SESSION_KEY_SC_SUFFIX;

    /**
     * 默认列表
     */
    public void index() {
        Map<String, Object> searchMap = getSessionAttr(SESSION_KEY_SC);
        if (searchMap == null) {
            searchMap = new HashMap<String, Object>();
            searchMap.put("pageNum", getParaToInt("pageNum", 1));
            searchMap.put("pageSize", getParaToInt("pageSize", 10));
            setSessionAttr(SESSION_KEY_SC, searchMap);
        }
        Integer pageNum = (Integer) searchMap.get("pageNum");
        Integer pageSize = 10;
        String select = SqlXml.getSql(${className}.dao.getSqlNamespace() + ".searchResult");
        String sqlExceptSelect = SqlXml.getSql(${className}.dao.getSqlNamespace() + ".search", searchMap);
        Page<${className}> page = ${className}.dao.paginate(pageNum, pageSize, select, sqlExceptSelect);
        setAttr("page", page);
        render("list.html");
    }

    /**
     * 默认列表
     */
    public void search() {
        // 设置查询条件
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("pageNum", getParaToInt("pageNum", 1));
        searchMap.put("pageSize", getParaToInt("pageSize", 10));
        // 将查询条件写入session中
        setSessionAttr(SESSION_KEY_SC, searchMap);
        // 查询数据
        Integer pageSize = 10;
        String select = SqlXml.getSql(${className}.dao.getSqlNamespace() + ".searchResult");
        String sqlExceptSelect = SqlXml.getSql(${className}.dao.getSqlNamespace() + ".search", searchMap);
        Page<${className}> page = ${className}.dao.paginate(pageNum, pageSize, select, sqlExceptSelect);
        setAttr("page", page);
        render("search_result.html");
    }

    /**
     * 准备添加
     */
    public void add() {
        // 设置默认参数
        ${className} ${classNameLower} = new ${className}();
        setAttr("${classNameLower}", ${classNameLower});
        render("add.html");
    }

    /**
     * 添加
     */
    public void save() {
        logger.debug("submit data={}", getParaMap());
        ${className} ${classNameLower} = getModel(${className}.class);
        ${classNameLower}.save();
        redirect("/${classNameLower}");
    }

    /**
     * 准备更新
     */
    public void edit() {
        ${className} ${classNameLower} = ${className}.dao.findById(getPara());
        setAttr("${classNameLower}", ${classNameLower});
        render("edit.html");
    }

    /**
     * 更新
     */
    public void update() {
        logger.debug("submit data={}", getParaMap());
        ${className} ${classNameLower} = getModel(${className}.class);
        ${classNameLower}.update();
        redirect("/${classNameLower}");
    }

    /**
     * 查看
     */
    public void view() {
        ${className} ${classNameLower} = ${className}.dao.findById(getPara());
        setAttr("${classNameLower}", ${classNameLower});
        render("view.html");
    }

    /**
     * 删除
     */
    public void delete() {
        ${className}.dao.deleteById(getPara());
        redirect("/${classNameLower}");
    }
}
