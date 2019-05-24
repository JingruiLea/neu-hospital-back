package edu.neu.his;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/info"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListWithUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testBCryptPasswordEncoder() {
        CharSequence rawPassword = "123456";

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(rawPassword);
        boolean isMatch = encoder.matches(rawPassword, encodePasswd);
        System.out.println("encodePasswd:" + encodePasswd);
        System.out.println(isMatch);
    }


}