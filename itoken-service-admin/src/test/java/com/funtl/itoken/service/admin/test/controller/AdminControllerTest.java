package com.funtl.itoken.service.admin.test.controller;

import com.funtl.itoken.service.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: Swang
 * Date: 2019-01-25
 * Time: 15:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = "prod")
public class AdminControllerTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void register() {

    }

}