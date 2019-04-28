<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
	*{
		font-size:24px;
	}
	div{
		margin-top:10px;
	}
	#btnLogin{
		margin-left:80px;
	}
</style>
<title>登录</title>
</head>
<body>
	<form action="login.do" method="post">
		<div><h1>欢迎登录</h1></div>
		<div>用户名: <input name="username"/></div>
		<div>密&nbsp;&nbsp;&nbsp;码: <input type="password" name="password"/></div>
		<div><input type="submit" value="登录" id="btnLogin"/></div>
	</form>
</body>
</html>