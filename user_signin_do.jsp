<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.ysu.lius.factory.*,cn.ysu.lius.vo.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>  <!--- 使用系统时间--->
<html>
<head><title>my书签</title></head>
<%request.setCharacterEncoding("GBK");// 解决乱码%>
<body>
<h1>welcome</h1>
<%
	User user=new User();
	user.setUserno(DAOFactory.getIUserDAOInstance().getCurMaxno());
	user.setUsername(request.getParameter("username"));
	user.setUserpsd(request.getParameter("userpsd"));
	user.setAddate(Calendar.getInstance().getTime() );
	try{
		if(DAOFactory.getIUserDAOInstance().doCreate(user)){
	%> 
		<h3>账户添加成功</h3>
	<%
		}else{
	%>
		<h3>账户添加失败</h3>
	<%
		}
	}catch (Exception e){
		e.printStackTrace();
	%>	
		<h3>进入异常</h3>
		<%=Integer.parseInt(request.getParameter("deluserno"))%>
		<%=e%>
	<%
	}
%>
</body>
</html>