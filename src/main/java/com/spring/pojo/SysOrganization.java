package com.spring.pojo;


import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 *
 */
public class SysOrganization implements Serializable { //extends Entities
    public SysOrganization() {


    }

    private String id;


    private Date createTime;


    private Date modifyTime;


    private Integer version;


    private Integer status;


    private String name;


    private String parentId;


    private String address;


    private String phone;


    private String postCode;


    private String fax;


    private Byte type;


    private Integer orderNo;


    private String code;


    private String principalId;


    private String path;

    @Transient//注解可以忽略字段,添加该注解的字段不会作为表字段使用.
    private String children;

    @Transient
    private String checked;

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

     public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getModifyTime() {
        return modifyTime;
    }


    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getParentId() {
        return parentId;
    }


    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }


    public String getFax() {
        return fax;
    }


    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }


    public Byte getType() {
        return type;
    }


    public void setType(Byte type) {
        this.type = type;
    }


    public Integer getOrderNo() {
        return orderNo;
    }


    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }


    public String getPrincipalId() {
        return principalId;
    }


    public void setPrincipalId(String principalId) {
        this.principalId = principalId == null ? null : principalId.trim();
    }


    public String getPath() {
        return path;
    }


    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}