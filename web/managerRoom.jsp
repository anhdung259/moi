<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="headerAdmin.jsp" %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ManagerBook</title>
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
        <div class="col-sm-15 text-left"> 


            <div class="col-sm-3 sidenav hidden-xs">
                <h2>Welcome ,${sessionScope.USER}</h2>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="managerRoom.jsp">Manager Room</a></li>
                    <li><a href="ReportController">Report Booking</a></li>
                    <li><a href="ListUserController">Manager User</a></li>
                </ul><br>
            </div>
            <br>

            <div class="col-sm-7 text-center">
                <div class="well">
                    <form action="MainController" method="POST">
                        Search Room (by RoomId)
                        <input type="text" name="txtSearch">
                        <input type="submit" class="btn btn-primary" value="Search" name="action"/>
                    </form>


                    <c:set var="searchValue" value="${param.txtSearch}"></c:set>
                    <c:set var="results" value="${requestScope.RESULT}"></c:set>  
                    <c:if test="${results!=null}">

                        <c:if test="${not empty results}">  
                            <div class="table-wrapper">
                                <a href="addNewRoom.jsp"> <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button> </a>
                                <table  class="table table-striped table-hover">
                                    <tr>
                                        <th class="text-center">No.</th>
                                        <th class="text-center">RoomId</th>
                                        <th class="text-center">Type</th>
                                        <th class="text-center">No.People</th>
                                        <th class="text-center">Image</th>
                                        <th class="text-center">Costs/per night</th>
                                        <th class="text-center"> Delete </th>
                                        <th class="text-center"> Edit </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${results}" varStatus="counter">

                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${dto.roomid}</td>
                                                <td>${dto.type}</td>
                                                <td>${dto.noPeople}</td>
                                                <td> <img src="${dto.image}" class="img-rounded" width="200" height="150"/></td>
                                                <td>${dto.costs} $</td>
                                                <td>
                                                    <c:url var="deleteLink" value="MainController">
                                                        <c:param name="action" value="Delete"/>
                                                        <c:param name="id" value="${dto.roomid}"/>
                                                        <c:param name="txtSearch" value="${param.txtSearch}"/>

                                                    </c:url>
                                                    <a href="${deleteLink}"> <font color="red"> Delete </font> </a>
                                                </td>
                                                <td>
                                                    <form action="MainController" method="POST">
                                                        <input type="submit" class="btn-primary" value="Edit" name="action" />
                                                        <input type="hidden" name ="id" value="${dto.roomid}" >
                                                        <input type="hidden" name ="txtSearch" value="${param.txtSearch}" >
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>

                        <c:if test="${empty results}">
                            No found record
                        </c:if>
                    </c:if>  
                </div>
            </div>
        </div>

    </body>

</html>