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
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/searchAddressForm">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                </ul>    
            </div>

            <!--main content-->
            <div class="container">
                 <div class="col-md-6">
                    <img src="img/oldaddressbook.jpg" class="img-responsive" alt="Responsive image" />
                </div>
                <div class="col-md-6">

                    
                        <h1>Search</h1>
                        <a href="displayAllAddresses">Search Addresses</a><br />
                        <hr />                                       <!--if we write modelAtt address, this page expects to get a model called address, 
                        and when we .addattribute in java, it will be looking for the path on that model, see path="lastName" --it's looking for this in this instance
                        of the model-->
                        <sf:form class="form-horizontal" role="form" modelAttribute="address" action="searchAddressForm" method="POST">
                            <div class="form-group">
                                <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                                <div class="col-md-6">
                                    <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name" />
                                    <sf:errors path="lastName" cssclass="error"></sf:errors>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-city" class="col-md-4 control-label">City</label>
                                    <div class="col-md-6">
                                    <sf:input type="text" class="form-control" id="add-city" path="city" placeholder="City" />
                                    <sf:errors path="city" cssclass="error"></sf:errors>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-zipCode" class="col-md-4 control-label">Zip Code</label>
                                    <div class="col-md-6">
                                        <input type="text" class = "form-control" id="add-zipCode" name="zipCode" placeholder="zipCode" />
                                        <!-- sf input tells Spring you want to build an input and the path prop will tell you which property of the object to set as the name-- >
                                        <!-- this allows to bypass, but name="" is still what gets passed-->
                                    <sf:errors path="zipCode" cssclass="error"></sf:errors>
                                    <sf:hidden path="idNumber" />
                                </div>
                            </div>  
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-6">
                                    <button type="submit" id="search-button" class="btn btn-default">Search</button>
                                </div>
                            </div>
                        </sf:form>
                    

                </div>
               


                <!-- now neeed a button to submit the input abouve -->







            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>


