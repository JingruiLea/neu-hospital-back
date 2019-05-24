package edu.neu.his.controller;

import edu.neu.his.bean.UserInfo;
import edu.neu.his.dao.UserInfoDao;
import edu.neu.his.exception.NoSuchUserException;
import edu.neu.his.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/**")
public class UserController {

    @Autowired
    UserInfoDao userInfoDao;

    @GetMapping("/{id}")
    public Map getUserInfo(@PathVariable("id") int id){
        List<UserInfo> l = userInfoDao.findByUserId(id);
        if(l.size() == 0){
            return new ResponseMessage(400, "UserInfo(user_id = "+ id +") is not found").getResponse();
        }
        if(l.size() > 1){
            return new ResponseMessage(400, "UserInfo(user_id = "+ id +") is duplicated").getResponse();
        }
        return new ResponseMessage(200, "OK", l.get(0)).getResponse();
    }

    @PutMapping("/{id}")
    public Map updateUserInfo(@PathVariable("id") int id, @RequestBody UserInfo userInfo){
        List<UserInfo> l = userInfoDao.findByUserId(id);
        
    }
}
