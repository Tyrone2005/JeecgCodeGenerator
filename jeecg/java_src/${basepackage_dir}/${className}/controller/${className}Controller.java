<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${className}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hengyun.common.util.DataDictUtil;
import ${basepackage}.${className}.entity.${className};
import ${basepackage}.${className}.service.${className}Service;

/**
 * ${className}Controller对象
 * 
 * @author 修改成自己的名字
 * @version 1.0
 */
@Scope("prototype")
@Controller
@RequestMapping("/${classNameLower}Controller")
public class ${className}Controller extends BaseController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(${className}Controller.class);

    @SuppressWarnings("unused")
    @Autowired
    private Validator validator;

    @Autowired
    private SystemService systemService;

    private String message;

    @SuppressWarnings("unused")
    private DataDictUtil dataDictUtil = new DataDictUtil();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 列表页面跳转
     * @param request
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("hd/configuration/${className}/${className}-list");
    }

    /**
     * List页面AJAX请求数据
     * 
     * @param ${classNameLower}
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(${className} ${classNameLower}, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery criteriaQuery = new CriteriaQuery(${className}.class, dataGrid);
        // 查询条件组装器
        HqlGenerateUtil.installHql(criteriaQuery, ${classNameLower}, request.getParameterMap());
        try {
            // 自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        criteriaQuery.add();
        this.${classNameLower}Service.getDataGridReturn(criteriaQuery, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 单个删除
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(${className} ${classNameLower}, HttpServletRequest request) {
        AjaxJson json = new AjaxJson();
        ${classNameLower} = systemService.getEntity(${className}.class, ${classNameLower}.getId());
        message = "删除成功";
        try {
            // 删除操作
            ${classNameLower}Service.delete(${classNameLower});
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "删除失败";
            throw new BusinessException(e.getMessage());
        }
        json.setMsg(message);
        return json;
    }

    /**
     * 批量删除
     * @param ids
     * @param request
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        AjaxJson json = new AjaxJson();
        message = "批量删除成功";
        try {
            for (String id : ids.split(",")) {
                ${className} ${classNameLower} = systemService.getEntity(${className}.class, id);
                // 删除操作
                ${classNameLower}Service.delete(${classNameLower});
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "批量删除失败";
            throw new BusinessException(e.getMessage());
        }
        json.setMsg(message);
        return json;
    }

    /**
     * 新增
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(${className} ${classNameLower}, HttpServletRequest request) {
        AjaxJson json = new AjaxJson();
        message = "新增成功";
        try {
            // 添加相关验证

            // 保存对象
            ${classNameLower}Service.save(${classNameLower});
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "新增失败";
            throw new BusinessException(e.getMessage());
        }
        json.setMsg(message);
        return json;
    }

    /**
     * 更新
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(${className} ${classNameLower}, HttpServletRequest request) {
        AjaxJson json = new AjaxJson();
        message = "更新成功";
        ${className} ${classNameLower}New = ${classNameLower}Service.get(${className}.class, ${classNameLower}.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(${classNameLower}, ${classNameLower}New);
            ${classNameLower}Service.saveOrUpdate(${classNameLower}New);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "更新失败";
            throw new BusinessException(e.getMessage());
        }
        json.setMsg(message);
        return json;
    }

    /**
     * 新增页面跳转
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(${className} ${classNameLower}, HttpServletRequest request) {
        if (StringUtil.isNotEmpty(${classNameLower}.getId())) {
            ${classNameLower} = ${classNameLower}Service.getEntity(${className}.class, ${classNameLower}.getId());
            request.setAttribute("${classNameLower}Page", ${classNameLower});
        }
        return new ModelAndView("hd/configuration/${className}/${className}-add");
    }

    /**
     * 编辑页面跳转
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(${className} ${classNameLower}, HttpServletRequest request) {
        if (StringUtil.isNotEmpty(${classNameLower}.getId())) {
            ${classNameLower} = ${classNameLower}Service.getEntity(${className}.class, ${classNameLower}.getId());
            request.setAttribute("${classNameLower}Page", ${classNameLower});
        }
        return new ModelAndView("hd/configuration/${className}/${className}-update");
    }

    /**
     * 查看页面跳转
     * @param ${classNameLower}
     * @param request
     * @return
     */
    @RequestMapping(params = "goView")
    public ModelAndView goView(${className} ${classNameLower}, HttpServletRequest request) {
        if (StringUtil.isNotEmpty(${classNameLower}.getId())) {
            ${classNameLower} = ${classNameLower}Service.getEntity(${className}.class, ${classNameLower}.getId());
            request.setAttribute("${classNameLower}Page", ${classNameLower});
        }
        return new ModelAndView("hd/configuration/${className}/${className}-view");
    }
}
