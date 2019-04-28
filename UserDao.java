package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtil;

/**
 * 对数据库表User进行各种访问（如增、删、改、查）的类
 * @author dewen
 * DAO：Data Access Object，数据访问对象，通常是指
 * 对数据库表进行各种访问（如增、删、改、查）。
 * 一般命名为XxxDao，就是表示对数据库表Xxx进行各种
 * 访问操作的类。
 */
public class UserDao {
	/**
	 * 按用户名username查找记录
	 * @param username 要查找的用户名
	 * @return 若找到，将查找到的记录构造成一个
	 * User对象返回；若未找到，返回null
	 */
	public User findByUsername(String username){
		User user=null;
		//1.建立连接
		Connection conn=DBUtil.getConnection();
		try {
			//2.在连接上准备要执行的语句对象
			String sql="select username,password,phone,address"
					+ " from user where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置sql语句中第1个?号参数的值取自于形参变量username的值
			ps.setString(1, username);
			//执行查询，返回结果集
			ResultSet rs=ps.executeQuery();
			/*
			 * 查询刚返回结果集时，结果集内部指针指向第一条
			 * 条记录的前面。
			 * next():使结果集内部指针向下移动一条记录，
			 * 并返回此次移动是否成功，若成功，返回true；
			 * 否则，返回false。
			 */
			if(rs.next()){
				user=new User();
				user.setUsername(username);
				/*
				 * rs.getString("password")：
				 * 取结果集内部指针所指向那条记录password列的值
				 */
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("user表按username查询失败");
		} finally{
			DBUtil.close(conn);
		}
		return user;
	}
	
	/**
	 * 往表中插入一条记录
	 * @param user 要写入的数据
	 */
	public void insert(User user){
		Connection conn=DBUtil.getConnection();
		String sql="insert into user(username,password,phone,address) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getAddress());
			ps.executeUpdate();//执行更新
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("往表中插入记录失败");
		} finally{
			DBUtil.close(conn);
		}
	}
	
	
	
	
	
	
	
	
}
