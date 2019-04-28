package entity;

import java.io.Serializable;

/**
 * 实体类，与数据库中User表相对应
 * @author dewen
 * 实体类：所谓实体类，就是与数据库表中相对应的类，
 * 它里面没有复杂业务的逻辑，通常具备以下特征：
 * 1）提供无参构造方法
 * 2）拥有私有属性，且私有属性名与表中列名一一对应
 * 3）提供私有属性的get、set方法以供外界访问
 * 4）实现序列化接口Serializable，以便在网络上传输
 */
public class User implements Serializable{
	private static final long serialVersionUID = 5386276983462770394L;
	public User(){
		
	}

	private String username;
	private String password;
	private String phone;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
	
	
	
}
