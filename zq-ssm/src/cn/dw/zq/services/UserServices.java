package cn.dw.zq.services;

import java.util.List;

import cn.dw.zq.model.User;

public interface UserServices {
	
	public void add(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public List<User>  query(User user);
}
