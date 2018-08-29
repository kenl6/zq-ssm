package cn.dw.zq.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.zq.dao.RoleDao;
import cn.dw.zq.model.Role;
import cn.dw.zq.services.RoleServices;
import cn.dw.zq.services.impl.RoleServicesImpl;

public class SpringTest {
	public static void main(String[] args) {
		BeanFactory beanfactory = 
				new ClassPathXmlApplicationContext("classpath:application.xml");
		RoleServices roleServices = (RoleServices) beanfactory.getBean("roleService");
//		RoleDao roleDao = (RoleDao) beanfactory.getBean("roleDao");
		
//		RoleServices roleServices2 = new RoleServicesImpl();
		Role role = new Role();
		role.setName("王五");
		role.setRemarks("王五的备注");
		roleServices.add(role);
		System.out.println("新增成功");
	}
}
