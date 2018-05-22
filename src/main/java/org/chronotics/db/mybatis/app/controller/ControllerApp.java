package org.chronotics.db.mybatis.app.controller;

import org.chronotics.db.mybatis.app.service.ServiceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerApp {
	@Autowired
    private ServiceApp service;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
    	float result = service.selectNumberByName("user0");
    	System.out.println(result);
    	
        return "select done";
    }
}
