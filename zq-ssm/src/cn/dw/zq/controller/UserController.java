package cn.dw.zq.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.dw.zq.model.User;
import cn.dw.zq.services.RoleServices;
import cn.dw.zq.services.UserServices;

@Controller  
@RequestMapping("/user")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private UserServices userServices;
	
	
	
	@RequestMapping("/page")
	public String page(User user) {
		return "user/add";
		
	} 
	
	@RequestMapping("/add")
	@ResponseBody  /*指定返回数据*/
	public String add(User user) {
//		System.out.println("进入方法。。。。");
		
		userServices.add(user);
		JSONObject json = new JSONObject();
		json.put("result", user);
		json.put("resultCode", "200");
//		return "{\"result\":\"success\"}";
//		System.out.println("方法调用结束。。。。");
		
		return json.toJSONString();
	} 
	
	@RequestMapping("/update")
	@ResponseBody  
	public String update(User user) {
		userServices.update(user);
		JSONObject json = new JSONObject();
		json.put("result", user);
		return json.toJSONString();
	} 
	
	@RequestMapping("/delete")
	@ResponseBody  
	public String delete(User user) {
		
		
		userServices.delete(user);
		JSONObject json = new JSONObject();
		json.put("result", "success");
		return json.toJSONString();
	} 
	
	@RequestMapping("/query")
	@ResponseBody  
	public String query(User user) {
//		int i = 1/0;
		if(log.isDebugEnabled()) {
			
		}
		
		log.debug("debug===========");
		
		log.info("info===========");
		
		log.error("error===========");
		
		List<User> lists = userServices.query(user);
		JSONObject json = new JSONObject();
		json.put("result", lists);
		return json.toJSONString();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
