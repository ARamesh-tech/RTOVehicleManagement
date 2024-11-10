<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.rto.vehicleregistration.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="icon" href="images/rto1.png" type="image/icon">
    </head>
    <body>

        <%@include file="normal_nav.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                <% 
                    Integer loginP = (Integer) request.getAttribute("loginP");
                    if (loginP != null && loginP == 1) {
                %><%@ include file="successinfo.jsp" %><script>alert("Loggedin Successfully!")</script><%
                    }
                %>
                <% 
                    Integer signupP = (Integer) request.getAttribute("signupP");
                    if (signupP != null && signupP == 1) {
                %><%@ include file="successinfo.jsp" %><script>alert("Registered Successfully!")</script><%
                    }
                %>
            </div>
            <div class="row">
                <div class="col">
                    <button type="button" class="btn btn-success">Vehicle Registation</button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-info">Vehicle Licensing</button>
                </div>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script> 

    </body>
</html>