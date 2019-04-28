# mvc
it is useful for us to learn JavaEE




javaEE是指java 企业级开发


jdk
eclipse、idea
数据库厂商提供的jar包   ---》mysql (oracle)
tomcat服务器软件
maven

编写web应用程序，常采用MVC设计模式
MVC，其中V代表视图view，展现给用户的界面（一般就是指jsp或html），M代表模型Model（实际就是指业务逻辑及对数据的存取访问），C代表Controller控制器，扮演一个中间者的角色，它一方面接收视图V的请求，交给模型M进行处理；另一方面，它也获取模型M处理的结果，交给视图V去显示。这样设计的好处是，V和M相互独立，当它们采用新的技术实现时，相互之间不受影响，耦合度低。

例：设计一个MVC模式的应用程序，实现用户的注册与登录。
V视图涉及到 regist.jsp（注册页面）、login.jsp（登录页面）、error.jsp（注册或登录失败的页面）、index.jsp(登录成功后的主页面）
C控制器涉及到对reg.do请求的接收与响应（利用RegServlet类处理）、login.do登录的接收与响应（利用LoginServlet类处理）
M模型涉及到如何具体注册regist、如何具体登录的login业务逻辑（用UserService类实现），在处理业务逻辑时，具体的涉及对数据库操作由UserDao类实现。






