package com.spring.pojo;

import java.io.Serializable;
import java.util.Date;

//RBAC权限管理用户资源信息
public class UsersResource implements Serializable {
    private static final long serialVersionUID = 10002121L;

    private Integer id;   //用户资源Id

    private Integer authId;   //权限中心资源Id

    private String name;   //资源名称

    private String description;   //资源描述

    private String url;  //链接地址

    private Integer type;  //资源类型：0-URL资源，1-组件资源

    private Integer status;  //状态：0-隐藏，1-展示

    private String code;  //标识码

    private String configuration;  //配置项

    private String moduleName;  //模块名称

    private Date gmtCreate;  //创建时间

    private Date gmtModified;  //最后修改时间

    private String createBy;  //创建人

    private String lastModifedBy;  //最后修改人

    private Integer orderIndex;   //排序号

    private Integer parentId;  //父资源

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration == null ? null : configuration
                .trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getLastModifedBy() {
        return lastModifedBy;
    }

    public void setLastModifedBy(String lastModifedBy) {
        this.lastModifedBy = lastModifedBy == null ? null : lastModifedBy
                .trim();
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
