package cn.dw.zq.utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class JdbcUtils {
	
	private static final String url = "jdbc:mysql://localhost:3306/zq-ssm?characterEncoding=utf8";
	private static final String user = "root";
	private static final String password = "123456";
	private static final String driver = "com.mysql.jdbc.Driver";
	
	/*确保驱动只被执行一次 静态块*/
	static {
		//1.加载驱动类
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	/*获取jdbc数据库连接*/
	private static Connection getConnection() throws SQLException {
		/*2.获取连接*/
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
	/*释放jdbc数据库连接*/
	private static void release(Statement statement,Connection conn) throws SQLException {
		/*6.释放资源*/
		if(statement !=null)statement.close();
		if(conn != null)conn.close();
	}
	
	/*执行查询相关的sql语句，然后把查询结果转换为bean*/
	public static List  executeQuery(String sql,Class clazz){
		Statement statement = null;
		Connection conn =null;
		ResultSet results = null;
		ResultSetMetaData metaData = null;
		int count = 0;
		List list = new ArrayList<>();
		try {
			/*获取连接*/
			conn = getConnection();
			/*获取会话*/
			statement = conn.createStatement();
			/*执行查询sql语句*/
			results = statement.executeQuery(sql);
			/*拿到表的元数据信息*/
			metaData = results.getMetaData();
			/*获取表有多少个字段*/
			count = metaData.getColumnCount();
			//判断是否是查询相关语句，是否有结果集要处理
			while(results.next()) {
				//获取需要转换的对象的实体
				Object obj = clazz.newInstance();
				Map map = new HashMap<>();
				for(int i = 1; i <= count ; i++) {
					map.put(metaData.getColumnName(i), results.getString(i));
				}
				/*把map对象转换为bean*/
				BeanUtils.populate(obj, map);
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			try {
				release(statement, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	
		
	}
	
	
	

	
	/*执行sql语句（比如：新增，修改，删除）*/
	public static void  execute(String sql) {
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn.setAutoCommit(false);/*设置手动提交事务*/
			conn = getConnection();
			statement = conn.createStatement();
			statement.execute(sql);
			conn.commit();  /*手动提交*/
		} catch (SQLException e) {
			try {
				conn.rollback(); /*回滚*/
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				release(statement, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
