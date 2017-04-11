<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.ysu.lius.factory.*,cn.ysu.lius.vo.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<html>
<head><title>my书签</title></head>
<%request.setCharacterEncoding("GBK");// 解决乱码%>
<body>
<h1>welcome</h1>
<%
	User user=new User();
	user.setUserno(1);
	user.setUsername(request.getParameter("username"));
	user.setUserpsd(request.getParameter("userpsd"));
	user.setAddate(Calendar.getInstance().getTime() );    //get current systime
	try{
		if(DAOFactory.getIUserDAOInstance().doCheck(user)){
		//if(DAOFactory.getIUserDAOInstance().doDelete(Integer.parseInt(request.getParameter("deluserno")))){
	%> 
		<h3>书签添加成功</h3>
		<jsp:forward page="user_bkm.jsp">
			<jsp:param name="uname" value="lius"/>
		</jsp:forward>
	<%
		}else{
	%>
		<h3>书签添加失败</h3>
		<jsp:forward page="user_loginfailed.htm">
			<jsp:param name="uname" value="lius"/>
		</jsp:forward>
	<%
		}
	}catch (Exception e){
		e.printStackTrace();
	%>	
		<h3>进入异常</h3>
		<%=e%>
	<%
	}
%>
</body>
</html>