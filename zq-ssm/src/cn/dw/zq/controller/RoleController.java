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

import cn.dw.zq.model.Role;
import cn.dw.zq.services.RoleServices;


@RequestMapping("/role")
public class RoleController {
	
	Logger log = LoggerFactory.getLogger(RoleController.class);
	
	private RoleServices roleService;
	
	private HttpServletRequest req;
	
	
	@RequestMapping("/page")
	public String page(Role role) {
		return "role/add";
		
	} 
	
	@RequestMapping("/add")
	@ResponseBody  /*指定返回数据*/
	public String add(Role role) {
//		System.out.println("进入方法。。。。");
		
		roleService.add(role);
		JSONObject json = new JSONObject();
		json.put("result", role);
		json.put("resultCode", "200");
//		return "{\"result\":\"success\"}";
//		System.out.println("方法调用结束。。。。");
		
		return json.toJSONString();
	} 
	
	@RequestMapping("/update")
	public String update(Role role) {
		roleService.update(role);
		JSONObject json = new JSONObject();
		json.put("result", role);
		return json.toJSONString();
	} 
	
	@RequestMapping("/delete")
	@ResponseBody  
	public String delete(Role role) {
		
		
		roleService.delete(role);
		JSONObject json = new JSONObject();
		json.put("result", "success");
		return json.toJSONString();
	} 
	
	@RequestMapping("/query")
	public String query(Role role) {
//		int i = 1/0;
		if(log.isDebugEnabled()) {
			
		}
		
		log.debug("debug===========");
		
		log.info("info===========");
		
		log.error("error===========");
		
		List<Role> lists = roleService.query(role);
		JSONObject json = new JSONObject();
		json.put("result", lists);
		return json.toJSONString();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
