<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head><title>书签er</title>
<body>
<form action="bkm_insert_do.jsp" method="post">
	书签编号:<input type="text" name="bkmno"><br>
	书签内容:<input type="text" name="bkmname"><br>
	书签URL : <input type="text" name="bkmurl"><br>
	添加时间:<input type="text" name="bkmaddate"><br>
	删    除:<input type="text" name="delbkmno"><br>
	<input type="submit" value="sign in">
	<input type="submit" value="rewrite">
</form>
<form action="bkm_list.jsp" method="post">
	<input type="submit" value="查询">
</form>
</body>
</head>
</html>