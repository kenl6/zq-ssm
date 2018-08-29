package cn.dw.zq.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.dw.zq.model.Role;
import cn.dw.zq.services.RoleServices;
import cn.dw.zq.services.impl.RoleServicesImpl;

@WebServlet("/role")
public class RoleServlet extends HttpServlet{
	
	
	private RoleServices roleService = new RoleServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Role role = new Role();
//		String name = req.getParameter("name");
//		String remarks = req.getParameter("remarks");
		Map map = req.getParameterMap();
		try {
			BeanUtils.populate(role, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		roleService.add(role);
	}
	
	
	
	
	
	
	
	
	
}
