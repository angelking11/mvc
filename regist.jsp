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
	#btnReg{
		margin-left:80px;
	}
</style>
<title>注册</title>
</head>
<body>
	<form action="reg.do" method="post">
		<div><h1>欢迎注册</h1></div>
		<div>用户名: <input name="username"/></div>
		<div>密&nbsp;&nbsp;&nbsp;码: <input type="password" name="password"/></div>
		<div>手&nbsp;&nbsp;&nbsp;机: <input name="phone"/></div>
		<div>地&nbsp;&nbsp;&nbsp;址: <input name="address"/></div>
		<div><input type="submit" value="注册" id="btnReg"/></div>
	</form>
</body>
</html>