<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Address</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>
            <!-- nav bar-->
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchAddressForm">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                </ul>    
            </div>

            <!--main content-->


            <div class="row row-eq-height">
                <div class="col-md-6">
                    <form class="form-horizontal" role="form" action="addNewAddressToModel" method="post">

                        <div class="form-group">
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="add-first-name" name="firstName" placeholder="First Name" />
                            </div>
                        </div>

                     

                            <div class="form-group" >
                                <div class="col-md-10"><input type="text" class="form-control" id="add-last-name" name="lastName" placeholder="Last Name" /></div></div>

                            <div class="form-group" >
                                <div class="col-md-10"><input type="text" class="form-control" id="add-street" name="street" placeholder="Street Name" /></div></div>

                            <div class="form-group" >
                                <div class="col-md-10"><input type="text" class="form-control" id="add-city" name="city" placeholder="City" /></div></div>

                            <div class="form-group" >
                                <div class="col-md-10"><input type="text" class="form-control" id="add-state" name="state" placeholder="State" /></div></div>

                            <div class="form-group" >
                                <div class="col-md-10"><input type="text" class="form-control" id="add-zipCode" name="zipCode" placeholder="Zipcode" /></div></div>


                            <div class="form-group">
                                <div class="col-md-offset-6 col-md-6">
                                    <button type="submit" id="add-button" class="btn btn-default">Add New Address</button>
                                </div>

                            </div>
                       
                    </form>

                </div>
                <div class="col-md-6 "><img src="img/pearladdressbook_720.jpg" class="img-responsive"></div>
            </div>



            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

