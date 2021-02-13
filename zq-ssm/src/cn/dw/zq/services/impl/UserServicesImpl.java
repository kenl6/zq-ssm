package cn.dw.zq.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dw.zq.mapper.UserMapper;
import cn.dw.zq.model.User;
import cn.dw.zq.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserMapper userMapper;
	
	

	@Override
	@Transactional  /*开启事务*/ 
	public void add(User user) {
		userMapper.add(user);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);

	}

	@Override
	public void delete(User user) {
		userMapper.delete(user);
	}

	@Override
	public List<User> query(User user) {
		return userMapper.query(user);
	}

}
