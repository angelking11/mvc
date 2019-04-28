package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserService;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 4249780684684026453L;
	/*
	 * 成员变量 userServcie
	 * LoginServlet需要依赖UserService对象才能完成登录的请求
	 */
	private UserService userService=new UserService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=
				request.getParameter("username");
		String password=request.getParameter("password");
		String message=
				userService.login(username, password);
		if(message==null){ //登录成功
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("index.jsp");//重定向到主页
		}else{
			request.setAttribute("message", message);
			//转发到错误页面
			request.getRequestDispatcher("error.jsp").
				forward(request, response);
		}
	}
	
	
	
}
