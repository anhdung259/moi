<%-- 
    Document   : viewbooking
    Created on : Dec 5, 2019, 4:43:28 PM
    Author     : Pham Anh Dung
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Report Booking</title>
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
            <c:if test="${sessionScope.ROLE ne 'admin'}">
            <jsp:forward page="login.jsp"/>
            </c:if>
    <%@include file="headerAdmin.jsp" %>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav hidden-xs">
      <h2>Welcome ,${sessionScope.USER}</h2>
      <ul class="nav nav-pills nav-stacked">
        <li ><a href="managerRoom.jsp">Manager Room</a></li>
        <li class="active"><a href="ReportController">Report Booking</a></li>
        <li><a href="ListUserController">Manager User</a></li>
      </ul><br>
    </div>
    <br>
    
    <div class="col-sm-9">
      <div class="well">
              <c:if test="${sessionScope.ROLE ne 'admin'}">
            <jsp:forward page="index.jsp"/>
        </c:if>
        <h1>Booking report</h1>
    <c:set var="list" value="${requestScope.LIST}"></c:set>
    <table border="1" class="table table-striped">
        <thead>
            <tr>
                <th>No.</th>
                <th>Username</th>
                <th>Room ID</th>
                <th>Booking Date and Time</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Totals bill</th>
                <th>Status</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}" varStatus="counter">

            <tr>
                <td>${counter.count}</td>
                <td>${dto.username}</td>
                <td>${dto.roomId}</td>
                <td>${dto.dateBook}</td>
                <td> ${dto.dateCheckIn}</td>
                <td>${dto.dateCheckOut} </td>   
                <td>${dto.totalCost}</td>
                <td>${dto.status}</td>
            </tr>

        </c:forEach>
    </tbody>
</table>
  </div>
</div>

</body>
</html>