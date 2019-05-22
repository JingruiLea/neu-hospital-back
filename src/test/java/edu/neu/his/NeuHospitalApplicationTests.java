package edu.neu.his;

import edu.neu.his.dao.UserDao;
import edu.neu.his.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NeuHospitalApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    UserDao userMapper;

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        User user = new User();
        user.setUsername("abc");
        user.setPassword("10086");
        userMapper.insert(user);
    }
}
