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
	    form ul li {list-style: none;}
	</style>
    </head>
    <body>
	<header>
	    <h3><%=getServletContext().getInitParameter("author") %></h3>
	</header>
	<form>
        <h1>Our Awesome Menu</h1>
	<ul>
	
	 <%
	    List<MenuItem> recs = (List)request.getAttribute("menu");
	    
	   /* Iterator it = recs.iterator();
	   while(it.hasNext()) {
	     it.next()
	    }*/
	    
	    for (MenuItem item: recs) {
	%>
	
	    <li>
		<h3><%=item%></h3>				    
		<input type="submit" id="<%=item.getItemId()%>" name="<%=item.getItemId()%>" value="EDIT" />
		<input type="submit" id="<%=item.getItemId()%>" name="<%=item.getItemId()%>" value="DELETE" />		 
	    </li>
	<%
	    }
	%>
	
	    </ul>
	</form>
	  
    </body>
</html>
