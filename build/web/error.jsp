<%-- 
    Document   : errorPage
    Created on : Nov 28, 2019, 9:23:52 AM
    Author     : Pham Anh Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR World!</h1>
        <h2 <font color="red">
            ${requestScope.ERROR} </font>
        </h2>
        </h2>
    </body>
</html>
