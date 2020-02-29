

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
    <%@include file="headerAdmin.jsp" %>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>Welcome ,${sessionScope.USER}</h2>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="managerRoom.jsp">Manager Room</a></li>
        <li ><a href="ReportController">Report Booking</a></li>
        <li><a href="#section3">Manager User</a></li>
      </ul><br>
    </div>
    <br>
    
    <div class="col-sm-4">
      <div class="well">
        <h1>Add new room</h1>
        <c:set var="err" value="${requestScope.INVALID}"/>
         <div class="signup-form">
        <form action="MainController" method="POST">
            RoomId : <input type="text" name="txtRoomId" value="${param.txtRoomId}" class="form-control" required>   <font color="red"> ${err.roomidErr} </font>
            <font color="red"> ${err.roomidExist} </font><br/>
            Type : <select name ="cbType">
                <c:set var = "Cr" value="${param.cbType}"/>
                <option <c:if test="${fn:contains(Cr, 'Common Room')}"> selected="true" </c:if>>Common Room</option>
                <c:set var = "Mr" value="${param.cbType}"/>
                <option <c:if test="${fn:contains(Mr, 'Master Room')}"> selected="true" </c:if>>Master Room</option> 
                <c:set var = "A" value="${param.cbType}"/>
                <option <c:if test="${fn:contains(A, 'Apartment')}"> selected="true" </c:if>>Apartment</option> 
            </select> <br/>
            No.People : <input type="text" name="txtNoPeople" class="form-control" value="${param.txtNoPeople}" required/><br/>
            <font color="red"> ${err.noPeopleErr} </font>
            <br/>
            Image : <input type="file" name="txtImage" class="form-control-file border" accept="image/x-png,image/gif,image/jpeg" value="${param.txtImage}"> </br>
            Costs : <input type="text" name="txtCosts" class="form-control"value="${param.txtCosts}" required><br/>
            <font color="red"> ${err.costsErr} </font>
            <br/>
            <input type="submit" value="Add Room" class="btn btn-primary" name="action" />
        </form>
         </div>
  </div>
</div>
</body>
</html>