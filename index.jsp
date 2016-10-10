<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Showing Headers<br><br>
<%@page import="java.util.Enumeration" %>
<%! HttpServletRequest request ;//can be declared here because it defines class variables and not local variables of the function

PrintWriter out ;

%>
<% Enumeration e =request.getHeaderNames() ;
	while(e.hasMoreElements())
	{
		String name=(String)e.nextElement() ;
		out.println(" Header Name - "+name+" Header Vale - "+request.getHeader(name)) ;
		out.println() ;
	}
%>
<br><br>

</h2>
</body>
</html>