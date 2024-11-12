
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.rto.vehicleregistration.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="icon" href="images/rto1.png" type="image/icon">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <form id="myForm"><br>
                <h1 style="text-align:center">Vehicle Registration</h1><br><br> 
                <div class="mb-3 row">
                    <label for="staticName" class="col-sm-2 col-form-label">Owner Name</label>
                    <div class="col-sm-10">
                        <input type="text"  class="form-control" id="staticOwner" name="ownername" required>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Vehicle Registration number</label>
                    <div class="col-sm-10">
                        <input type="text"  class="form-control" id="staticRegno" name="vehicleregno" required>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputPassword" class="col-sm-2 col-form-label">Vehicle Details(Brand, Year, Model, Price)</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputDetails" name="vehicleDetails" required>
                    </div>
                </div>
                <input type="submit" value="Register Vehicle" class="btn btn-success" onclick="myForm.action = 'VehicleRegServlet';myForm.target = '_self'">
<!--                <input type="submit" value="Goback" class="btn btn-success" onclick="myForm.action = 'index.jsp';myForm.target = '_self'">-->

                <input type="button" value="GetDetails & Verify" class="btn btn-info" onclick="myFunction()">
            </form>
        </div>
        <script>
            function myFunction() {
                let vehicleno = prompt("Please enter your vehicle regno:");
                if (vehicleno == null || vehicleno == "") {
                    alert("User cancelled the prompt.");
                } else {
                    window.location.href = "http://localhost:9494/VehicleRegistration/VehileDetialsNVerifyServlet?vehicleRegNo=" + vehicleno;
                }
            }
        </script>


    </body>
</html>
