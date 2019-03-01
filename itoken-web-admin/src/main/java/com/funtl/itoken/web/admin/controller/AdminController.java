package com.funtl.itoken.web.admin.controller;

import com.funtl.itoken.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Swang
 * Date: 2019-01-26
 * Time: 14:40
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
