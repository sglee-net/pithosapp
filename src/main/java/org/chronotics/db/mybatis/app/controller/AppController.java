package org.chronotics.db.mybatis.app.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.chronotics.db.mybatis.MapperMySql;
import org.chronotics.db.mybatis.app.service.AppService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(AppController.class);
	@Autowired
    private AppService service;

	@Resource(name = "mapperSimpleMySql")
	private MapperMySql mapper;
	
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET)
    @ResponseBody
    public String home() {
    	return "welcome home";
    }
	
    @RequestMapping(
    		value = "/selectCustom", 
    		method = RequestMethod.GET)
    @ResponseBody
    public String daoExample(
    		@RequestParam("tableName") String _tableName,
    		@RequestParam("c1") String _c1,
    		@RequestParam("c2") String _c2,
    		@RequestParam("c3") String _c3) {
    	logger.info(_tableName);
    	JSONObject jsonObject = 
    			service.selectCustom(_tableName, _c1, _c2, _c3);
    	if(jsonObject != null) {
    		return jsonObject.toString();
    	} else {
    		return "no records";
    	}
    }
    
    @RequestMapping(
    		value = "/record", 
    		method = RequestMethod.GET)
    @ResponseBody
    public String readRecord(
    		@RequestParam("tableName") String _tableName) {
    	JSONObject jsonObject = service.selectAllRecords(_tableName);
    	if(jsonObject != null) {
    		return jsonObject.toString();
    	} else {
    		return "no records";
    	}
    }
    
    @RequestMapping(
    		value = "/record", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"})
    @ResponseBody
    public String insertRecord(
    		@RequestBody String _json) {
    	int count = service.insertRecord(_json);
        return new String("insert, " + Integer.toString(count));
    }
    
    @RequestMapping(
    		value = "/records", 
    		method = RequestMethod.POST, 
    		consumes = {"application/json"})
    @ResponseBody
    public String insertRecords(
    		@RequestBody String _json) {
    	int count = service.insertRecords(_json);
        return new String("insert, " + Integer.toString(count));
    }
    
    @RequestMapping(
    		value = "/record", 
    		method = RequestMethod.PUT)
    @ResponseBody
    public String updateRecord(
    		@RequestBody String _json) {
    	int count = service.updateRecord(_json);
        return new String("update, " + Integer.toString(count));
    }
    
    @RequestMapping(
    		value = "/record", 
    		method = RequestMethod.DELETE,
    		consumes = {"application/json"})
    @ResponseBody
    public String deleteRecord(
    		@RequestBody String _json) {
    	int count = service.deleteRecord(_json);
        return new String("delete, " + Integer.toString(count));
    }
}
