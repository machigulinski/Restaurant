<%-- 
    Document   : edit
    Created on : Feb 16, 2014, 11:17:07 PM
    Author     : Machi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Menu Item</title>
    </head>
    <body>
        <h1>YOU CAN EDIT HERE</h1>
	
	<%
	    //for testing
	    String suc = "";	    
	    Object result = request.getAttribute("success");
	    suc = result == null? suc : result.toString();
	    
	%>
	
	<h2><%=suc%></h2>
    </body>
</html>
