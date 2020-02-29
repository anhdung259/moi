<%-- 
    Document   : booking
    Created on : Dec 7, 2019, 11:53:43 AM
    Author     : Pham Anh Dung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Booking</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <script>
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
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
       
        <%@include file="headerUser.jsp" %>
        <c:set var="numdate" value="${requestScope.NumDate}"/> 
        <div class="container-fluid">
            <div class="row content">
                <div class="col-sm-3 sidenav hidden-xs">
                    <h2>Welcome ,${sessionScope.USER}</h2>
                   <h1>Search room</h1> 
                    <form action="MainController" method="POST">
                        <div class="col-sm-5">
                            Form Date: 
                            <input type="text" name="txtDate" id="datepicker"  class="form-control" value="${param.txtDate}"  required="">
                            To Date:
                            <input type="text" name="txtTodate" id="datepicker2"  class="form-control" value="${param.txtTodate}" required="">     
                            Type Room : <select  class="form-control" name ="cbTypeS">
                                <c:set var = "Cr" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(Cr, 'Common Room')}"> selected="true" </c:if>>Common Room</option>
                                <c:set var = "Mr" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(Mr, 'Master Room')}"> selected="true" </c:if>>Master Room</option> 
                                <c:set var = "A" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(A, 'Apartment')}"> selected="true" </c:if>>Apartment</option> 

                                </select> </br>
                                No of people: <input  type="text" name="txtNumPeople"  class="form-control" value="${param.txtNumPeople}" pattern="[0-9]" title="Number people is number positite" required=""/>
                            <input type="submit" class="btn btn-primary"  class="form-control" value="Search Room" name="action" />
                        </div>
                    </form>
                </div>
                <br>

                <div class="col-sm-8">
                    <font color="green">${requestScope.OK} </font>
                    <font color="red">${requestScope.ER} </font>  
      

                    <h1>Search room</h1> 
                    <form action="MainController" method="POST">
                        <div class="col-sm-5">
                            Form Date: 
                            <input type="text" name="txtDate" id="datepicker"  class="form-control" value="${param.txtDate}"  required="">
                            To Date:
                            <input type="text" name="txtTodate" id="datepicker2"  class="form-control" value="${param.txtTodate}" required="">     
                            Type Room : <select  class="form-control" name ="cbTypeS">
                                <c:set var = "Cr" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(Cr, 'Common Room')}"> selected="true" </c:if>>Common Room</option>
                                <c:set var = "Mr" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(Mr, 'Master Room')}"> selected="true" </c:if>>Master Room</option> 
                                <c:set var = "A" value="${param.cbTypeS}"/>
                                <option <c:if test="${fn:contains(A, 'Apartment')}"> selected="true" </c:if>>Apartment</option> 

                                </select> </br>
                                No of people: <input  type="text" name="txtNumPeople"  class="form-control" value="${param.txtNumPeople}" pattern="[0-9]" title="Number people is number positite" required=""/>
                            <input type="submit" class="btn btn-primary"  class="form-control" value="Search Room" name="action" />
                        </div>
                    </form>

                    <c:set var="searchValue" value="${param.txtNumPeople}"></c:set>
                    <c:set var="results" value="${requestScope.RESULT}"></c:set>  
                    <c:if test="${results!=null}">

                        <c:if test="${not empty results}">  
                            <div class="table-wrapper">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <td>No.</td>
                                            <th>RoomId</th>
                                            <th>Detail</th>
                                            <th>Booking</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${results}" varStatus="counter">

                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${dto.roomid}</td>                                                                
                                                <td> <img src="${dto.image}"  class="img-rounded" width="280" height="250"> <br/>
                                                    Max people :${dto.noPeople}<br/>    
                                                    Type: ${dto.type}<br/>
                                                    Cost/per night ${dto.costs} $                              
                                                </td>
                                                <td>
                                                    <form action="MainController" method="GET">

                                                        <input type="hidden" name ="id" value="${dto.roomid}" >
                                                        <input type="hidden" name ="txtfromdate" value="${param.txtDate}" >
                                                        <input type="hidden" name ="txttodate" value="${param.txtTodate}" >
                                                        <input type="hidden" name ="NumPeople" value="${param.txtNumPeople}" >   
                                                        <input type="hidden" name ="txtNumDate" value="${requestScope.NumDate}" >   
                                                        <input type="submit" class="btn btn-primary" value="Add To Cart" name="action" />
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </c:if>

                            <c:if test="${empty results}">
                                No found record
                            </c:if>
                        </c:if> 
                     

                    </div>
                </div>

                </body>
                </html>