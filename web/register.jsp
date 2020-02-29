<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : register
    Created on : Dec 7, 2019, 12:11:20 PM
    Author     : Pham Anh Dung
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        <title>Bootstrap Classic Sign Up Form with Blue Background</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style type="text/css">
            body {
                color: #fff;
                background: #fff;
                font-family: 'Roboto', sans-serif;
            }
            .form-control {
                min-height: 41px;
                box-shadow: none;
                border-color: #3598dc;
            }
            .form-control, .btn {        
                border-radius: 3px;
            }
            .signup-form {
                width: 390px;
                margin: 0 auto;
                padding: 30px 0;
            }
            .signup-form form {
                color: #999;
                border-radius: 3px;
                margin-bottom: 15px;
                background: #fff;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .signup-form h2 {
                color: #3598dc;
                font-weight: bold;
                margin-top: 0;
            }
            .signup-form hr {
                margin: 0 -30px 20px;
            }
            .signup-form .form-group {
                margin-bottom: 20px;
            }
            .signup-form label {
                font-weight: normal;
                font-size: 13px;
            }
            .signup-form input[type="checkbox"] {
                margin-top: 2px;
            }    
            .signup-form .btn {        
                font-size: 16px;
                font-weight: bold;
                background: #3598dc;
                border: none;
                min-width: 140px;
            }
            .signup-form .btn:hover, .signup-form .btn:active {
                background: #ddd;
                outline: none !important;
            }
            .signup-form a {
                color: #fff;
                text-decoration: underline;
            }
            .signup-form a:hover {
                text-decoration: none;
            }
            .signup-form form a {
                color: #3598dc;
                text-decoration: none;
            }
            .signup-form form a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div class="signup-form">
            <form action="MainController" method="POST">
                <h2>Sign Up</h2>
                <p>Please fill in this form to create an account!</p>
                <hr>
                <c:set var="error" value="${requestScope.INVALID}"/>
                Username : <input type="text" name="txtUsername" class="form-control"   value="${param.txtUsername}"autofocus maxlength="20" required=""> <br/><font color="red">${error.usernameErr}</font>  
                <font color="red">${error.usernameDuplicate}</font>  <br/>
                Password: <input type="password" class="form-control" name="txtPassword" maxlength="20"  value=""required=""> <br/>   <font color="red"> ${error.passwordErr}</font> <br/>
                Password comfirm : <input type="password" class="form-control" name="txtPasswordcomfirm" maxlength="20"required="" > <br/> <font color="red"> ${error.passwordcomfirmErr}</font> <br/>
                Address    : <input type="text" name="txtAddress" class="form-control" maxlength="20" value="${param.txtAddress}"required=""> <br/>  <font color="red">${error.addressErr}</font><br/>
                Number Phone: <input type="text" name="txtNumberPhone" class="form-control" maxlength="20" value="${param.txtNumberPhone}" required=""> <br/> <font color="red">${error.phonenoErr}</font> <br/>
                Email  : <input type="email" name="txtEmail" class="form-control" maxlength="30" value="${param.txtEmail}"required=""> <br/>	 <font color="red">${error.emailErr}</font> <br/>
                Fullname: <input type="text" name="txtFullname" class="form-control" maxlength="20" value="${param.txtFullname}"required=""> <br/> <font color="red">${error.fullnameErr}</font>   <br/>
                <button type="submit"  name="action" value="Register" class="btn btn-primary btn-lg">Sign Up</button>
                <button type="reset"  name="action" value="Reset" class="btn btn-danger" >Reset</button>
            </form>
        </div>
        <div class="text-center">Already have an account? <a href="login.jsp">Login here</a></div>
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>       



