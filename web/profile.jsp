

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : viewbooking
    Created on : Dec 5, 2019, 4:43:28 PM
    Author     : Pham Anh Dung
--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>New Room</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style type="text/css">
            body {
                color: #666;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px;
                margin: 30px 0;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .pagination {
                margin: 10px 0 5px;
            }
            .pagination li a {
                border: none;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 4px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background: #59bdb3;
            }
            .pagination li.active a:hover {        
                background: #45aba0;
            }
            .pagination li:first-child a, .pagination li:last-child a {
                padding: 0 10px;
            }
            .pagination li.disabled a {
                color: #ccc;
            }
            .pagination li i {
                font-size: 17px;
                position: relative;
                top: 1px;
                margin: 0 2px;
            }
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
        
    /* On small screens, set height to 'auto' for the grid */
    @media screen and (max-width: 767px) {
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
            <c:if test="${sessionScope.ROLE ne 'user'}">
            <jsp:forward page="login.jsp"/>
            </c:if>
    <%@include file="headerUser.jsp" %>
    <div class="container-fluid">
            <div class="row content">
                <div class="col-sm-3 sidenav hidden-xs">
                    <h2>Welcome ,${sessionScope.USER}</h2>
                    <ul class="nav nav-pills nav-stacked">
                        <li ><a href="booking.jsp">Booking Room</a></li>
                        <li class="active" ><a href="ProfileController">My Profile</a></li>
                        <li><a href="MyBookingController">My Bookings</a></li>
                    </ul><br>
                </div>
    <br>
    
    <div class="col-sm-4">
      <div class="well">
         <div class="signup-form">
             <font color="green"> ${requestScope.OK}</font>
        <h1>Profile </h1>
        
         <c:set var="dto" value="${requestScope.DTO}"/>
            <form action="MainController" method="POST">

            <c:set var="error" value="${requestScope.INVALID}"/>
            Fullname: <input type="text" class="form-control" name="txtFullname" maxlength="20" value="${dto.fullname}" > <br/> <font color="red"required="">${error.fullnameErr}</font>   <br/>
            Username : <input type="text" class="form-control" name="txtUsername"   value="${dto.username}"autofocus maxlength="20" readonly="false" required=""> <br/><font color="red">${error.usernameErr}</font>  
            <font color="red">${error.usernameDuplicate}</font>  <br/>
            Password: <input type="text"   class="form-control" name="txtPassword" maxlength="20" value="${dto.password}"required=""> <br/>   <font color="red"> ${error.passwordErr}</font> <br/>
            PASSWORD comfirm : <input type="password"  class="form-control" name="txtPasswordcomfirm" maxlength="20" required=""> <br/> <font color="red"> ${error.passwordcomfirmErr}</font> <br/>
            Address    : <input type="text" name="txtAddress"  class="form-control" maxlength="20" value="${dto.address}"required=""> <br/>  <font color="red">${error.addressErr}</font><br/>
            PhoneNo: <input type="text" name="txtNumberPhone"  class="form-control" maxlength="20" value="${dto.numberPhone}" required=""> <br/> <font color="red">${error.phonenoErr}</font> <br/>
            Email  : <input type="text" name="txtEmail"  class="form-control" maxlength="30" value="${dto.email}" required=""> <br/>	 <font color="red">${error.emailErr}</font> <br/>


            <input type="submit" name="action" class="btn btn-primary" value="Update Profile" ></div>
        </form>
         </div>
  </div>
</div>
</body>
</html>