package com.spring.dao;

import com.spring.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminMapper {

    void save(Admin admin);

    boolean update(Admin admin);

    boolean delete(int id);

    Admin findById(int id);

    List<Admin> findAll();

    Admin login(Admin admin);
}
