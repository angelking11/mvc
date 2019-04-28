package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import model.UserService;
/**
 * 接收注册请求，分发给相应的model处理后，并返回注册结果
 * @author dewen
 */
public class RegServlet extends HttpServlet{
	private static final long serialVersionUID = 2568932435947076244L;
	/*
	 * 成员变量 userServcie
	 * RegServlet需要依赖UserService对象才能完成注册的请求
	 */
	private UserService userService=new UserService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		/*System.out.println("注册资料如下：");
		System.out.println(username);
		System.out.println(password);
		System.out.println(phone);
		System.out.println(address);*/
		User newUser=new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setPhone(phone);
		newUser.setAddress(address);
		String message=userService.regist(newUser);
		if(message==null){ //若没有（错误）消息，表示注册成功
			//重定向到登录页
			response.sendRedirect("login.jsp");
		}else{ 
			//转发（错误）消息到错误页面显示
			request.setAttribute("message", message);
			request.getRequestDispatcher("error.jsp")
			.forward(request, response);
		}
	}
	
	
}
