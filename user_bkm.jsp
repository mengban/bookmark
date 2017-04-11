<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="cn.ysu.lius.factory.*,cn.ysu.lius.vo.*"%>
<%@ page import="java.util.*"%>
<html>
<head><title>my书签</title></head>
<%request.setCharacterEncoding("GBK");%>
<body>
<%
	try{
		String Keyword=request.getParameter("kw");
		if(Keyword==null){
			Keyword="";
		}
		List<Bkm> all=DAOFactory.getIBkmDAOInstance().findAll(Keyword);
		Iterator<Bkm> iter=all.iterator();
%>
<center>
<h1>Welcome</h1>
<hr>
<form action="bkm_list.jsp" method="post">
		请输入关键字进行查询<input type="text" name="kw">
		<input type="submit" value="查询">
</form>

<form action="bkm_insert.jsp" method="post">
		<input type="submit" value="继续添加">
</form>

<form action="bkm_list.jsp" method="post">
		<input type="button" value="删除" onclick="DAOFactory.getIBkmDAOInstance().doDelete(77))">
</form>
<table border="1" width="80%">
	<tr>
		<td>添加序号</td>
		<td>关键字</td>
		<td>URL</td>
		<td>添加时间</td>
	</tr>
<%
	while(iter.hasNext()){
		Bkm bkm=iter.next();
%>
	<tr>
		<td><%=bkm.getBkmno()%></td>
		<td><%=bkm.getBkmname()%></td>
		<td><%=bkm.getBkmurl()%></td>
		<td><%=bkm.getAddate()%></td>
	</tr>
<%
	}
%>
</table>
</center>
<%
 	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>










