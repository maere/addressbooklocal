<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchAddressForm">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                    
                </ul>    
            </div>

            <!--main content-->
            <div class="container">
                <div class="col-md-6"><img src="img/rolodex.jpg" class="img-responsive" alt="Responsive image" /></div>
                <div class="col-md-6">
            <h1>Edit Contact Form</h1>
            <a href="displayAllAddresses">Address List</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="address" action="editAddressForm" method="POST">
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name" />
                        <sf:errors path="firstName" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-last-name" class="col-md-4 control-label">Last Name</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name" />
                        <sf:errors path="lastName" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-street" class="col-md-4 control-label">Street</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-street" path="street" placeholder="Street" />
                        <sf:errors path="street" cssclass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-city" class="col-md-4 control-label">City</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-city" path="city" placeholder="City" />
                        <sf:errors path="city" cssclass="error"></sf:errors>
                    </div>
                </div>  
                <div class="form-group">
                    <label for="add-state" class="col-md-4 control-label">State</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-state" path="state" placeholder="State" />
                        <sf:errors path="state" cssclass="error"></sf:errors>
                    </div>
                </div>
                    
                    <div class="form-group">
                    <label for="add-zipCode" class="col-md-4 control-label">Zip Code</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-zipCode" path="zipCode" placeholder="Zip Code" />
                        <sf:errors path="zipCode" cssclass="error"></sf:errors>
                        <sf:hidden path="idNumber" />
                    </div>
                </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-default">Edit Contact</button>
                        </div>
                    </div>
            </sf:form>
        </div>
           
    </div>
            
            
        <!-- now neeed a button to submit the input abouve -->
