package edu.neu.his.mapper;

import edu.neu.his.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "DepartmentMapper")
public interface DepartmentMapper {
    @Select("SELECT * FROM DEPARTMENT WHERE name = #{name}")
    List<Department> findByName(@Param("name") String name);

    @Select("SELECT name FROM department_classification")
    List<String> findAllClassification();

    @Insert("INSERT INTO department(code, name, classification) VALUES(#{code}, #{name}, #{classification})")
    void insert(Department department);

    @Update("UPDATE department SET code = #{code}, name = #{name}, classification = #{classification} WHERE id = #{id}")
    void update(Department department);

    @Select("SELECT * FROM DEPARTMENT")
    List<Department> findAll();

    @Delete("DELETE FROM DEPARTMENT WHERE id=#{id}")
    void deleteDepartment(int id);
}
