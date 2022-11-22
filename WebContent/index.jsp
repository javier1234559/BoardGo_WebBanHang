<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	if(session.getAttribute("name")==null){
		response.sendRedirect("login.jsp");
	}else{
		 response.sendRedirect("HomeServlet");
	}
%>
