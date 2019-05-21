package edu.neu.his.newtype.user;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE name = #{name}")
    List<User> findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name,age) VALUES(#{name}, #{age})")
    void insert(User user);

    @Update("UPDATE user SET name = #{name}, age = #{age} WHERE id = #{id}")
    void update(User user);
}
