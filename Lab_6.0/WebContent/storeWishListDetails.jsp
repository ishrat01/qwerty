<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Strore Wishlist</title>
</head>
<body>

<%-- TODO:1 Use standard action (jsp:usebean) to obtain scoped variable "wishList" from session scope--%>
<jsp:useBean id="wishList" class="com.seed.beans.ShoppingCart" scope="session"/>


<%-- TODO:2 set "productList" property of "wishList"with request parameter "bookID"--%>
<jsp:setProperty name="wishList" property="productList" param="bookID" />

<%-- TODO:3 forward current request to "categories.html" if user clicks on "Add to Wish List & shop more?" button--%>
<%
		if(request.getParameter("addToList")!=null)
		{
			response.sendRedirect("categories.html") ;
		}

		else
			response.sendRedirect("displayWishListDetails.jsp") ;
%>
<%-- TODO:4 forward current request to "displayWishListDetails.jsp" if user clicks on "check out" button--%>

</body>
</html>