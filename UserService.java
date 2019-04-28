package model;

import entity.User;

/**
 * 处理用户注册、用户登录服务的业务模型
 * @author dewen
 *
 */
public class UserService {
	/* 成员变量userDao
	 * UserService需要依赖UserDao类对象来完成业务处理
	 */
	private UserDao userDao=new UserDao();
	/**
	 * 完成注册业务逻辑
	 * @param newUser 要注册的用户资料
	 * @return 返回注册状态的消息	 
	 * 若不能注册，返回错误消息；若能注册，返回null
	 */
	public String regist(User newUser){
		String message=null;
		
		/*
		 * 思路如下：
		 * 首先要检查要注册的用户名是否存在，若存在，
		 * 则注册失败；若不存在，则进行注册。
		 */
		User user=userDao.findByUsername(newUser.getUsername());
		if(user!=null){ //若要注册的用户已存在
			message="错误："+newUser.getUsername()+"已注册!<a href='regist.jsp'>重新注册</a>";
		}else{
			userDao.insert(newUser); //进行注册
		}
		return message;
	}
	
	/**
	 * 处理登录业务逻辑
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录的结果信息
	 * 若登录失败，返回错误描述，登录成功，返回null
	 */
	public String login(String username,String password){
		String message=null;
		User user = userDao.findByUsername(username);
		if(user!=null){
			if(!password.equals(user.getPassword())){
				message="登录失败，密码错误! <a href='login.jsp'>重新登录</a>";
			}
		}else{
			message="登录失败，【"+username+"】不存在! <a href='login.jsp'>重新登录</a>";
		}
		return message;
	}

}
