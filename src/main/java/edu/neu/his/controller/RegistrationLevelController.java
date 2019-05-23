package edu.neu.his.controller;

import edu.neu.his.bean.Registration_level;
import edu.neu.his.service.RegistrationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationLevelController {
    @Autowired
    private RegistrationLevelService registrationLevelService;

    @GetMapping("/find/name/{name}")
    public List<Registration_level> registrationFindByName(@PathVariable("name")  String name){
        return registrationLevelService.findByName(name);
    }

    @GetMapping("/list")
    public List<Registration_level> listAllRegistration_level(){
        return registrationLevelService.findAll();
    }

    @PostMapping("/update")
    public List<Registration_level>  updateRegistration_level(Registration_level registration_level){
        registrationLevelService.updateDepartment(registration_level);
        return registrationLevelService.findAll();
    }

    @PostMapping("/insert")
    public List<Registration_level>  insertRegistration_level(Registration_level registration_level){
        registrationLevelService.insertRegistration_level(registration_level);
        return registrationLevelService.findAll();
    }

    @PostMapping("/delete")
    public List<Registration_level>  deleteRegistration_level(int id){
        registrationLevelService.deleteRegistration_level(id);
        return registrationLevelService.findAll();
    }
}

