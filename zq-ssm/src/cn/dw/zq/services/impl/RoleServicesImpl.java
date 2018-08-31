package cn.dw.zq.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dw.zq.dao.RoleDao;
import cn.dw.zq.mapper.RoleMapper;
import cn.dw.zq.model.Role;
import cn.dw.zq.services.RoleServices;

@Service
public class RoleServicesImpl implements RoleServices {

	
	private RoleMapper roleMapper;
	
	

	@Override
	@Transactional  /*开启事务*/ 
	public void add(Role role) {
		roleMapper.add(role);
//		int i = 1/0;
//		roleMapper.add(role);	
	}

	@Override
	public void update(Role role) {
		roleMapper.update(role);

	}

	@Override
	public void delete(Role role) {
		roleMapper.delete(role);
	}

	@Override
	public List<Role> query(Role role) {
		roleMapper.query(role);
		return  null;
	}

}
