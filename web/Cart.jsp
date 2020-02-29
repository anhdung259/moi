<%-- 
    Document   : reviewbook
    Created on : Dec 7, 2019, 10:31:11 PM
    Author     : Pham Anh Dung
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HomeStay Cart</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
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
                        <li class="active"><a href="booking.jsp">Booking Room</a></li>
                        <li ><a href="ProfileController">My Profile</a></li>
                        <li ><a href="MyBookingController">My Bookings</a></li>
                    </ul><br>
                </div>
                <br>

                <div class="col-sm-9">
                    <div class="well">

                        <c:set var="cart" value="${sessionScope.CART}"/>
                        <div class="row">
                            <div class="col-sm-12 col-md-10 col-md-offset-1">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Room Details</th>
                                            <th>Number days</th>
                                            <th class="text-center">Cost/per night</th>
                                            <th class="text-center">Total</th>
                                            <th> </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${cart.items}" varStatus="counter"> 
                                            <tr>
                                                <td class="col-sm-8 col-md-6">
                                                    <div class="media">
                                                        <div class="media-body">
                                                            <img src="${item.value.image}" class="img-rounded" width="200" height="200"> </br>
                                                            Type: ${item.value.type}<br/>
                                                            RoomID: ${item.key}  </br>
                                                        </div>
                                                    </div></td>
                                                <td class="col-sm-1 col-md-1" style="text-align: center">
                                                    <input type="text" class="form-control" id="exampleInputEmail1" value="${item.value.numDate}">
                                                </td>
                                                <td class="col-sm-1 col-md-1 text-center"><strong>$ ${item.value.costs}</strong></td>
                                                <td class="col-sm-1 col-md-1 text-center"><strong> ${item.value.pay} $</strong></td>
                                                <td class="col-sm-1 col-md-1">
                                                    <form action="MainController" method="POST">

                                                        <input type="submit" class="btn btn-primary" value="Remove" name="action" />
                                                        <input type="hidden" name="id" value="${item.key}"
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <td>   </td>
                                            <td>   </td>
                                            <td>   </td>
                                            <td><h5>Subtotal</h5></td>
                                            <td class="text-right"><h5><strong> $ ${cart.total}</strong></h5></td>
                                        </tr>
                                        <tr>
                                            <td>   </td>
                                            <td>   </td>
                                            <td>   </td>

                                    <form action="MainController" method="POST">
                                        <td class="col-sm-4 col-md-3" style="text-align: center">
                                        Discount code:<input type="text" class="form-control" name="txtCode" value="" />
                                            <input type="submit" class="btn btn-primary" value="Apply discount code" name="action" /> <br/>
                                            <font color="green"> ${requestScope.CODE}</font>
                                             <font color="red"> ${requestScope.CODEFAIL}</font>
                                             <font color="red"> ${requestScope.FAIL}</font>
                                              <font color="red"> ${requestScope.EXIST}</font>

                                    </form>
                                    </td>
                                    <td class="text-right"><h5><strong></strong></h5></td>
                                    </tr>
                                    <tr>
                                        <td>   </td>
                                        <td>   </td>
                                        <td>   </td>
                                        <td><h3>Total</h3></td>
                                        <td class="text-right"><h3><strong>$ ${cart.total}</strong></h3></td>
                                    </tr>
                                    <tr>
                                        <td>   </td>
                                        <td>   </td>
                                        <td>   </td>
                                        <td>
                                            <a href="booking.jsp"> 
                                                <button type="button" class="btn btn-default">
                                                    <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping 
                                                </button></a></td>
                                        <td>
                                            <form action="MainController" method="POST">

                                                <input type="submit" class="btn btn-danger" value="Book Now" name="action" />
                                            </form>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                </body>
                </html>