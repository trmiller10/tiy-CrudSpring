package com.theironyard;

import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TiyCrudSpringApplication.class)
@WebAppConfiguration
public class TiyCrudSpringApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WebApplicationContext wap;

    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
    }


    @Test
    public void testAddUser() throws Exception{
        MultiValueMap<String, String> testParams = new LinkedMultiValueMap<>();
        testParams.set("userName", "testUser");
        testParams.set("password", "testPass");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/login")
                        .params(testParams)
        );

        Assert.assertTrue(userRepository.findByUserName("testUser").getuserName().equals("testUser"));
    }

    @After
    public void after() {
        User testUser = userRepository.findByUserName("testUser");
        userRepository.delete(testUser);
    }
}

