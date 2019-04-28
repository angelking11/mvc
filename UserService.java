package model;

import entity.User;

/**
 * �����û�ע�ᡢ�û���¼�����ҵ��ģ��
 * @author dewen
 *
 */
public class UserService {
	/* ��Ա����userDao
	 * UserService��Ҫ����UserDao����������ҵ����
	 */
	private UserDao userDao=new UserDao();
	/**
	 * ���ע��ҵ���߼�
	 * @param newUser Ҫע����û�����
	 * @return ����ע��״̬����Ϣ	 
	 * ������ע�ᣬ���ش�����Ϣ������ע�ᣬ����null
	 */
	public String regist(User newUser){
		String message=null;
		
		/*
		 * ˼·���£�
		 * ����Ҫ���Ҫע����û����Ƿ���ڣ������ڣ�
		 * ��ע��ʧ�ܣ��������ڣ������ע�ᡣ
		 */
		User user=userDao.findByUsername(newUser.getUsername());
		if(user!=null){ //��Ҫע����û��Ѵ���
			message="����"+newUser.getUsername()+"��ע��!<a href='regist.jsp'>����ע��</a>";
		}else{
			userDao.insert(newUser); //����ע��
		}
		return message;
	}
	
	/**
	 * �����¼ҵ���߼�
	 * @param username �û���
	 * @param password ����
	 * @return ��¼�Ľ����Ϣ
	 * ����¼ʧ�ܣ����ش�����������¼�ɹ�������null
	 */
	public String login(String username,String password){
		String message=null;
		User user = userDao.findByUsername(username);
		if(user!=null){
			if(!password.equals(user.getPassword())){
				message="��¼ʧ�ܣ��������! <a href='login.jsp'>���µ�¼</a>";
			}
		}else{
			message="��¼ʧ�ܣ���"+username+"��������! <a href='login.jsp'>���µ�¼</a>";
		}
		return message;
	}

}
