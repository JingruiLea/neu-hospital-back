package edu.neu.his.dao;

import edu.neu.his.bean.Permission;

import java.util.List;

public interface PermissionDao {

    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
