package edu.neu.his.dao;

import edu.neu.his.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoDao {
    @Select("SELECT * FROM user_info WHERE user_id = #{userId} ")
    public List<UserInfo> findByUserId(@Param("userId")int userId);

    @Select("SELECT * FROM user_info WHERE id = #{id} ")
    public List<UserInfo> find(@Param("id") int id);

}
