package cn.dw.zq.mapper;



import java.util.List;

import cn.dw.zq.model.Role;

public interface RoleMapper {
	
	public void add(Role role);
	
	public void update(Role role);
	
	public void delete(Role role);
	
	public List<Role>  query(Role role);
	
}
