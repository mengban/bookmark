<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.ysu.lius.factory.*,cn.ysu.lius.vo.*"%>
<%@ page import="java.text.*"%>
<html>
<head><title>my书签</title></head>
<%request.setCharacterEncoding("GBK");// 解决乱码%>
<body>
<h1>welcome</h1>
<%
	Bkm bkm=new Bkm();
	bkm.setBkmno(Integer.parseInt(request.getParameter("bkmno")));
	bkm.setBkmname(request.getParameter("bkmname"));
	bkm.setBkmurl(request.getParameter("bkmurl"));
	bkm.setAddate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bkmaddate")));
	try{
		if(DAOFactory.getIBkmDAOInstance().doCreate(bkm)){
		//if(DAOFactory.getIBkmDAOInstance().doDelete(Integer.parseInt(request.getParameter("delbkmno")))){
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
		<%=Integer.parseInt(request.getParameter("delbkmno"))%>
		<%=e%>
	<%
	}
%>
</body>
</html>