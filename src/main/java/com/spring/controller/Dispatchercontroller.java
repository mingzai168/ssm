package com.spring.controller;

import com.google.gson.Gson;
import com.spring.pojo.SysOrganization;
import com.spring.service.SysOrganizationService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Dispatchercontroller {

    @Autowired
    SysOrganizationService sysOrganizationService;


    //存放转换后数据的集合
    List<Map<String,Object>> treeGridList  =new ArrayList<Map<String,Object>>();

    //初始化list列表
    @RequestMapping("List")
    @ResponseBody
    private List<SysOrganization> test(Map<String, Object> paramMap) {

        //得到所有组织机构数据
        List<SysOrganization> list  = sysOrganizationService.searchUsersResourceBySQL(paramMap);

        //调用方法实现角色树
        createTreeGridTree(list ,"0");

        //将集合转换为json输出到页面
        Gson gson = new Gson();
        String json = gson.toJson(treeGridList);
        System.out.println(json);

        return list ;
    }


    /**
     * 封装成树
     * @param *list
     * @param  *parentId  父id
     */
    private void createTreeGridTree(List<SysOrganization> list, String fid) {
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = null;
            SysOrganization role =  list.get(i);
            if (role.getParentId().equals("0")) {
                map = new HashMap<String, Object>();
                //这里无所谓怎么转都行，因为在页面easyUI插件treeGrid提供了数据转换的columns属性，具体看相关的js代码
                map.put("id", list.get(i).getId());         //id
                map.put("name", list.get(i).getName());     //角色名
                map.put("children", createTreeGridChildren(list, role.getId()));
            }
            if (map != null)
                treeGridList.add(map);
        }
    }

    /**
     * 递归设置role树
     * @param list
     * @param fid
     * @return
     */
    private List<Map<String, Object>> createTreeGridChildren(List<SysOrganization> list, String fid) {
        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();
        for (int j = 0; j < list.size(); j++) {
            Map<String, Object> map = null;
            SysOrganization treeChild =  list.get(j);
            if (treeChild.getParentId().equals(fid)) {
                map = new HashMap<String, Object>();
                //这里无所谓怎么转都行，因为在页面easyUI插件treeGrid提供了数据转换的columns属性，具体看相关的js代码
                map.put("id", list.get(j).getId());
                map.put("name", list.get(j).getName());
                map.put("children", createTreeGridChildren(list, treeChild.getId()));
            }

            if (map != null)
                childList.add(map);
        }
        return childList;
    }














    //添加某一行
    @RequestMapping(value = "/saveSysOrganization", method = RequestMethod.POST)
    @ResponseBody
    public int saveSysOrganization(HttpServletRequest httpServletRequest) {
        return 0;
    }

/*     //删除某一行
      //Map<String, Object>
       @RequestMapping(value = "/deleteSysOrganization")
       @ResponseBody
     public void deleteSysOrganization(HttpServletRequest request) throws Exception {
        String id= ConvertUtils.cStr(request.getParameter("id"));
        Map<String,Object> result = new HashMap<String, Object>();
        Map<String, Object> params = CommonUtil.getNewSqlMap();
        params.put("id",id);
        sysOrganizationService.deleteObject(params);
       // return result;
    }*/

    //更新某一行


}

