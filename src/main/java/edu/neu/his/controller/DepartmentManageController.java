package edu.neu.his.controller;

import edu.neu.his.bean.Department;
import edu.neu.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/departmentManage")
public class DepartmentManageController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findByName")
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
        res.put("code",200);
        res.put("msg","");
        res.put("data",departmentService.findAll());
        return res;
    }

    @GetMapping("/classification")
    @ResponseBody
    public Map listAllClassification(){
        Map res = new HashMap();
        res.put("code",200);
        res.put("msg","");
        res.put("data",departmentService.findAllClassification());
        return res;
    }

  //  @PostMapping("/update")
  //  @ResponseBody
  //  public Map updateDepartment(@RequestBody Map req){
   //     departmentService.updateDepartment(department);
   // }

    @PostMapping("/add")
    @ResponseBody
    public Map insertDepartment(@RequestBody Map req){
        int id = (int)req.get("code");
        String name = (String)req.get("name");
        String classification = (String)req.get("classification");
        Department department = new Department();
        department.setId(id);
        department.setName(name);
        department.setClassification(classification);
        if(isClinical(name))
            department.setIs_clinical(true);
        else
            department.setIs_clinical(false);

        Map res = new HashMap();
        try {
            departmentService.insertDepartment(department);
            res.put("code",200);
            res.put("msg","");
            res.put("data",department);
        }catch(Exception ex){
            res.put("code",500);
            res.put("msg","The code or name has existed.");
            res.put("data",null);
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
        if(name.equals("超声科")||name.equals("检验科")||name.equals("手术室")||name.equals("核医学科")||name.equals("放射科"))
            return false;
        else
            return true;
    }

}
