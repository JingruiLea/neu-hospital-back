package edu.neu.his.dao;

import edu.neu.his.bean.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {

    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
