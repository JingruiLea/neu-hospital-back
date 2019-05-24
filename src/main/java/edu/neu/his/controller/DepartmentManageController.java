package edu.neu.his.controller;

import edu.neu.his.bean.Department;
import edu.neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departmentManage")
public class DepartmentManageController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/findByName")
    @ResponseBody
    public Map departmentFindByName(@RequestBody Map req){
        String name = (String)req.get("name");
        Map res = new HashMap();
        res.put("code",200);
        res.put("msg","");
        res.put("data",departmentService.findDepartmentByName(name));
        return res;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Map listAllDepartment(){
        Map res = new HashMap();
        List<Department> list = departmentService.findAll();
        int len = list.size();
        int[] keys = new int[len];
        for(int i=0; i<len; i++){
            keys[i]=list.get(i).getId();
        }
        res.put("code",200);
        res.put("msg","");
        res.put("key", keys);
        res.put("data",list);
        return res;
    }

    @GetMapping("/getAllClassification")
    @ResponseBody
    public Map listAllClassification(){
        Map res = new HashMap();
        res.put("code",200);
        res.put("msg","");
        res.put("data",departmentService.findAllClassification());
        return res;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map updateDepartment(@RequestBody Map req){
        Map res = new HashMap();
        int id = (int)req.get("id");
        String code = (String)req.get("code");
        String name = (String)req.get("name");
        String classification = (String)req.get("classification");

        if(canUpdate(id,name,code,classification)) {
            Department department = new Department(id, code, name, classification, isClinical(name));
            departmentService.updateDepartment(department);
            res.put("code", 200);
            res.put("msg", "");
            res.put("data", department);
        }else{
            res.put("code", 500);
            res.put("msg", "The code/name has existed," +
                    "or there isn't such a classification in the department_classification table.");
            res.put("data", null);
        }

        return res;
    }

    @PostMapping("/add")
    @ResponseBody
    public Map insertDepartment(@RequestBody Map req){
        String code = (String)req.get("code");
        String name = (String)req.get("name");
        String classification = (String)req.get("classification");
        Department department = new Department();
        department.setCode(code);
        department.setName(name);
        department.setClassification(classification);
        Map res = new HashMap();

        if(canOperate(name,code,classification)){
            department.setIs_clinical(isClinical(name));
            departmentService.insertDepartment(department);
            res.put("code", 200);
            res.put("msg", "");
            res.put("data", department);
        }else {
            res.put("code", 500);
            res.put("msg", "The code/name has existed," +
                    "or there isn't such a classification in the department_classification table.");
            res.put("data", null);
        }

        return res;
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map  deleteDepartment(@RequestBody Map req){
        String[] strings = (String[])req.get("data");
        for(int i=0; i<strings.length; i++) {
            int id = Integer.parseInt(strings[i]);
            departmentService.deleteDepartment(id);
        }
        Map res = new HashMap();
        res.put("code",200);
        res.put("msg","");
        res.put("data",departmentService.findAll());
        return res;
    }

    private boolean isClinical(String name){
        if(name.equals("超声科")||name.equals("检验科")||name.equals("手术室")
                ||name.equals("核医学科")||name.equals("放射科"))
            return false;
        else
            return true;
    }

    private boolean canOperate(String name, String code, String classification){
        List<Department> list = departmentService.findAll();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getName().equals(name)||list.get(i).getCode().equals(code))
                return false;
        }

        List<String> cla = departmentService.findAllClassification();
        for(int i=0; i<cla.size(); i++){
            if(cla.get(i).equals(classification))
                return true;
        }

        return false;
    }

    private boolean canUpdate(int id, String name, String code, String classification){
        List<Department> list = departmentService.findAll();
        for(int i=0; i<list.size(); i++){
            if((list.get(i).getName().equals(name)||list.get(i).getCode().equals(code))
                    && list.get(i).getId()!=id)
                return false;
        }

        List<String> cla = departmentService.findAllClassification();
        for(int i=0; i<cla.size(); i++){
            if(cla.get(i).equals(classification))
                return true;
        }

        return false;
    }

}
