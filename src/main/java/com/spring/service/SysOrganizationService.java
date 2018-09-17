package com.spring.service;

import com.spring.pojo.SysOrganization;


import java.util.List;
import java.util.Map;

public interface SysOrganizationService {
    int getUsersResourceTotalNumBySQL(SysOrganization usersRes);

    List<SysOrganization> searchUsersResourceBySQL(Map<String, Object> paramMap);

    public  void deleteObject(Map<String, Object> params);
}
