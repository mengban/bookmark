<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>书签er</title>
<body>
<center>
<h1>登陆入口</h1>
<hr>
<form action="user_login_do.jsp" method="post">
	<TABLE BORDER="1">
	<tr>
		<td colspan="2">用户登录</td>          
	</tr>
	<!---<tr>
	<td>User编号:</td>
	<td><input type="text" name="userno"></td>
	</tr>--->
	<tr>
	<td>用户名</td>
	<td><input type="text" name="username"></td>
	</tr>
	<tr>
	<td>密码:</td>
	<td><input type="password" name="userpsd"></td>
	</tr>
	<!---<tr>
	<td>添加时间:</td>
	<td><input type="text" name="useraddate"></td>
	</tr>--->
	</table>
	</br>
	<tr>
	<input type="submit" value="登录">
	<input type="reset" value="重置">
	</tr>
<!---</form>
<form action="user_list.jsp" method="post">
	<input type="submit" value="查询">
</form>--->
</center>
</body>
</head>
</html>