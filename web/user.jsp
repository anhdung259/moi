
<%-- 
    Document   : newjsp
    Created on : Dec 13, 2019, 5:04:35 PM
    Author     : Pham Anh Dung
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:if test="${sessionScope.ROLE ne 'user'}">
            <jsp:forward page="login.jsp"/>
        </c:if>
      <%@include file="booking.jsp" %>
    </body>
</html>
