package cn.dw.zq.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.dw.zq.dao.RoleDao;
import cn.dw.zq.model.Role;
import cn.dw.zq.utils.JdbcUtils;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	
	public static void main(String[] args) {
		Role r = new Role();
		r.setName("张三");
		r.setRemarks("测试添加备注");
		RoleDao roleDao = new RoleDaoImpl();
//		roleDao.add(r);
//		System.out.println("新增成功");
		List<Role> results = roleDao.query(r);
		for(Role role : results) {
			System.out.println(role);
		}
	}

	@Override
	public void add(Role role) {
		String sql = "insert into role(name,remarks) "
				+ "values('"+ role.getName() +"','"+role.getRemarks()+"')";
		JdbcUtils.execute(sql);
		
	}

	@Override
	public void update(Role role) {
		String sql = "update role set name = '"+
				role.getName()+"' where id = " + role.getId();
		JdbcUtils.execute(sql);
		
	}

	@Override
	public void delete(Role role) {
		String sql = "delete from role where id = " + role.getId();
		JdbcUtils.execute(sql);
		
	}

	@Override
	public List<Role> query(Role role) {
		String sql = "select * from role where";
		if(role.getName() != null && !role.getName().equals("")) {
			sql+=" and name = '" + role.getName() +"'";
		}
		List<Role> result = JdbcUtils.executeQuery(sql,Role.class);
		return result;
	}

}
