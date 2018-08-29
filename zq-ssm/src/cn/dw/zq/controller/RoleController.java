package cn.dw.zq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

@Controller  //@Service @Repository @Component
//@RestController
@RequestMapping("/role")
public class RoleController {
	
//	@Qualifier("rolerService1") 配合Autowired注解使用
//	@Resource(name="rolerService1")
	@Autowired 
	private RoleServices roleService;
	
	@Autowired
	private HttpServletRequest req;
	
	
	@RequestMapping("/page")
	public String page(Role role) {
		return "role/add";
		
	} 
	
	@RequestMapping("/add")
	@ResponseBody  /*指定返回数据*/
	public String add(Role role) {
		roleService.add(role);
		JSONObject json = new JSONObject();
		json.put("result", role);
//		return "{\"result\":\"success\"}";
		return json.toJSONString();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
