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
    		value = "/name", 
    		method = RequestMethod.GET)
    @ResponseBody
    public String daoExample(
    		@RequestParam("str") String _name) {
    	logger.info(_name);
    	List<Float> numberList= service.selectNumberByName(_name);
    	String strResult="";
    	for(int i=0; i<numberList.size(); i++) {
    		if(i!=0 || i!=numberList.size()-1) {
    			strResult += ", ";
    		}
    		strResult += Float.toString(numberList.get(i));
    	}
    	return new String("select return size()" + Integer.toString(numberList.size()) + ", " + strResult);
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
    		method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRecord() {
//    		@RequestParam("tableName") String _tablename//,
//    		@RequestParam("leftOperand") String _leftOperand,
//    		@RequestParam("operand") String _operand,
//    		@RequestParam("rightOperand") String _rightOperand
//    		) {
    	int count = service.deleteRecord();//_tablename);//,_leftOperand, _operand, _rightOperand);
        return new String("delete, " + Integer.toString(count));
    }
}
