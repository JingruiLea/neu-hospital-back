package edu.neu.his.oldtype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @PostMapping("/user/login")
    public Map userLogin() {
        HashMap res = new HashMap();
        res.put("msg","hello");
        return res;
    }

   @PostMapping("/post")
   public Map userRegister(@RequestBody Map req) {
        String data = (String)req.get("data");
        boolean ok = (boolean)req.get("ok");
        Map res = new HashMap();
        res.put("data",data);
        res.put("ok",ok);
        return res;
   }

   @GetMapping("/sql")
   public Map sqlDemo() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        for(Map obj: list) {
            System.out.println(obj.get("name")+"/"+obj.get("password"));
        }
        return new HashMap();
   }

}
