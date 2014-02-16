<%-- 
    Document   : index
    Created on : Feb 12, 2014, 6:35:49 PM
    Author     : Machi
--%>

<%@page import="restaurant.model.MenuItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Menu</title>
	
	<style>
	    form h3 { padding: 0; margin: .5em 0;}
	</style>
    </head>
    <body>
	<form>
        <h1>Our Awesome Menu</h1>
	
	 <%
	    List recs = (List)request.getAttribute("menu");
	   // Iterator it = recs.iterator();
	    //while(it.hasNext()) {
	    for (Object item: recs) {
	%>
	
	    <h3><%=item %></h3>
	<%
	    }
	%>
	
	</form>
	  
    </body>
</html>
