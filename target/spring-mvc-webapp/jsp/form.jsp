<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
       <div class="container">
            <h1>Address Book</h1>
            <hr/>  
        </div>

        <div class="container">
            <h1>Form Template</h1>

            <!--will put in a link that will reference our list -->
            <a href="#">Form</a><br/>
            <hr/>

            <!--we are using a special form taglib -- this is the sf springform library that we added above -->
            <!-- we are using the spring library because Spring will help us pre-populate these fields with our current Data -->
            <sf:form class="form-horizontal" role="form" modelAttribute="contact" 
                     action="editContactNoAjax" method="post">   <!--abovve is how we tell it the name of the model we are using -->  
                
                
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name"></sf:input>
                     <!--now we will put in all of our errors in the view, and we will need indicate all of the "paths" - why is the param called a path?-->   
                        <sf:errors path="firstName" cssclass="error"></sf:errors>
                        
                    </div>
                    </div>

                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-last-name" path="lastName" placeholder="Last Name"></sf:input>
                        <sf:errors path="lastName" cssclass="error"></sf:errors>
                    </div>
                    </div>

                    <div class="form-group">
                        <label for="add-company" class="col-md-4 control-label">Company:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-company" path="company" placeholder="Company"></sf:input>
                       <sf:errors path="company" cssclass="error"></sf:errors>
                    </div>
                    </div>

              
                        <div class="form-group">
                        <label for="add-email" class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-email" path="email" placeholder="Email"></sf:input>
                        <sf:errors path="email" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8"><!--this div is just to create spacing in the grid -->   <!--this placeholder is just in case we don't have a value already  -->                       
                        <sf:input type="text" class="form-control" id="add-phone" path="phone" placeholder="Phone"></sf:input>
                        <sf:errors path="phone" cssclass="error"></sf:errors>
   <!--!!!!!! DO NOT FORGET THIS!!! we forgot to add an id to this -- should be a hidden field-- but can go anywhere bc it will not display-->                      
                        <sf:hidden path="contactId"/>
                        </div>
                    </div>
    
                       
                        <!-- now neeed a button to submit the input abouve -->
                        
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Edit Contact:</button>
                            </div>
                        </div>
                        
                       
            </sf:form>


        </div>


<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>

