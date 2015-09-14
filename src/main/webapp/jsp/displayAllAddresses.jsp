<%-- 
    Document   : displayAllAddresses
    Created on : Jul 16, 2015, 12:03:28 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Display Your Addresses</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/searchAddressForm">Search</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>
                </ul>    
            </div>

            <!--main content-->


            <div class="row row-eq-height">
                <div class="col-md-6">
                    <div class="col-md-10">

                        <c:forEach var="address" items ="${addressList}">  

                            <!-- bc we don't have JS, important to map the route and create a handshake here and then pass the param to our URL-->
                            <s:url value="deleteAddress" var="deleteAddress_url"><!--fomatted here -->
                                <s:param name="idNumber" value="${address.idNumber}" /><!--passed here --><!--  beer.com?param=beer&value=malt -->
                            </s:url>

                            <s:url value="editAddressForm" var="editAddress_url">
                                <s:param name="idNumber" value="${address.idNumber}" />
                            </s:url>

                          
                            ${address.firstName} ${address.lastName}  |
                            <!--our URL did not carry the ID necessary for tje request bc we never formatted the URL to carry the id parameter --->
                            <!--so when we tried to get the int param in our controller function, it didn't know what to give so it made it null, and the compiler threw the error -->
                            <a href="${deleteAddress_url}">Delete</a> |  
                            <a href="${editAddress_url}">Edit</a><br/>
                            ${address.street}<br/>
                            ${address.city}, ${address.state}<br/>
                            ${address.zipCode}<br/>
                            <hr>



                        </c:forEach>

                    </div>

                </div>
                <div class="col-md-6 "><img src="img/ponytailinsidelook_720.jpg" class="img-responsive"></div>
            </div>



            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>



