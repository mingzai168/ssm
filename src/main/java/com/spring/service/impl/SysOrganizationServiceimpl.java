package com.spring.service.impl;

import com.spring.mapper.SysOrganizationMapper;
import com.spring.pojo.SysOrganization;
import com.spring.pojo.UsersResource;
import com.spring.service.SysOrganizationService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service//("SysOrganizationServiceimpl")
public  class SysOrganizationServiceimpl implements SysOrganizationService {

    @Autowired
    SysOrganizationMapper sysOrganizationMapper ;

    @Override
    public int getUsersResourceTotalNumBySQL(SysOrganization usersRes) {

        int count = sysOrganizationMapper.selectCount(usersRes);
        return  count ;
    }

    @Override
    public List<SysOrganization> searchUsersResourceBySQL(Map<String, Object> paramMap) {
        List<SysOrganization> list = sysOrganizationMapper.selectAll();
        return list;
    }

    @Override
    public void deleteObject(Map<String, Object> params) {
        sysOrganizationMapper.deleteByPrimaryKey(params);
    }
}
