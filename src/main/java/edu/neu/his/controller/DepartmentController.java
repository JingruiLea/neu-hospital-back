package edu.neu.his.controller;

import edu.neu.his.bean.Department;
import edu.neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/find/name/{name}")
    public List<Department> departmentFindByName(@PathVariable("name")  String name){
        return departmentService.findDepartmentByName(name);
    }

    @GetMapping("/list")
    public List<Department> listAllDepartment(){
        return departmentService.findAll();
    }

    @PostMapping("/update")
    public List<Department>  updateDepartment(Department department){
        departmentService.updateDepartment(department);
        return departmentService.findAll();
    }

    @PostMapping("/insert")
    public List<Department>  insertDepartment(Department department){
        departmentService.insertDepartment(department);
        return departmentService.findAll();
    }

    @PostMapping("/delete")
    public List<Department>  deleteDepartment(int id){
        departmentService.deleteDepartment(id);
        return departmentService.findAll();
    }

}
