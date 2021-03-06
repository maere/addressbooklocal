<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/customtransitions.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>

            <!-- nav bar-->
            <!--    commenting out parts of the nav bar, but keeping underlying functionality for JSTL version--to use the JSTL version, 
                    just uncomment the links need to make the navigation available         -->
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/createAddressForm">Add</a></li>-->
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/searchAddressForm">Search</a></li>-->
                    <!--<li role="presentation"><a href="${pageContext.request.contextPath}/displayAllAddresses">List</a></li>-->
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                </ul>    
            </div>


            <!--main content-->
            <div class="container">
                <div class="row">   
                    
                      <div class="col-md-6">
                        <h2> Search Addresses</h2>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="search-first-name" class="col-md-4 control-label">
                                    First Name
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-first-name" placeholder="First Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-last-name" class="col-md-4 control-label">
                                    Last Name
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-last-name" placeholder="Last Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-street" class="col-md-4 control-label">
                                    Street
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-street" placeholder="Street" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-city" class="col-md-4 control-label">
                                    City
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-city" placeholder="City" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-state" class="col-md-4 control-label">
                                    State
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-state" placeholder="State" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-zip" class="col-md-4 control-label">
                                    Zip
                                </label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="search-zip" placeholder="Zip" />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" id="search-button" class="btn btn-default">Search Contact</button>
                                </div> 
                            </div>
                        </form>

                    </div> <!-- end of add form div -->


                    <div class="col-md-6">

                        <div class="search-book-cover">
                            <img src="img/searchindex.jpg" class="img-responsive" alt="Responsive image" />
                        </div>

                        <div class="address-list-main"> <!--this has a custom  class display; none --> 
                            <h2>Search Results</h2>
                            <table id="addressTable" class="table table-hover">
                                <tr>
                                    <th width="30%">First Name</th>
                                    <th width="30%">Last Name</th>
                                    <th width="20%"></th>
                                    <th width="20%"></th>
                                </tr>
                                <tbody id="contentRows"></tbody>

                            </table>
                            <div class="col-md-10"></div>
                            <div class="col-md-2"><button class="btn btn-default btn-sm" id="close-list-button">Close</button></div>      
                        </div><!--this is the end of our hide/show div for our list-->  

                    </div>

                  

                </div>
            </div> <!-- end row-->
        </div><!--end container-->

        <!-- MODALS - don't need to be in container-->

        <!-- Details Modal -->
        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
             aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Details</h4>
                    </div>
                    <div class="modal-body">
                        <!---->            <h3 id="address-id"></h3><!--is this kosher, or should it just be "id" -->
                        <table class="table table-bordered">
                            <tr>
                                <th>First Name</th>
                                <td id="details-first"></td>
                            </tr>
                            <tr>
                                <th>Last Name</th>
                                <td id="details-last"></td>
                            </tr>
                            <tr>
                                <th>Street</th>
                                <td id="details-street"></td>
                            </tr>
                            <tr>
                                <th>City</th>
                                <td id="details-city"></td>
                            </tr>
                            <tr>
                                <th>State</th>
                                <td id="details-state"></td>
                            </tr>
                            <tr>
                                <th>Zip</th>
                                <td id="details-zip"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- end details modal -->
        <!-- edit modal -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Edit Address</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="address-id"></h3><!--this doesn't do anything except display the id # on the modal view -->
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-first" class="col-md-4 control-label">First</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-first" placeholder="First Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-last" class="col-md-4 control-label">Last</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-last" placeholder="Last Name" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-street" class="col-md-4 control-label">Street</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-street" placeholder="Street" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-city" class="col-md-4 control-label">City</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-city" placeholder="City" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-state" class="col-md-4 control-label">State</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-state" placeholder="State" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-zip" class="col-md-4 control-label">Zip</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-zip" placeholder="Zip" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8"> <!--why does it need an id for both? one for hte button, one for the form? or edit-object-method? -->
                                    <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Address</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    <input type="hidden" id="edit-address-id" /><!--this hidden button is what allows us to send this info to the server and allows us to grab the object to edit -->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>




        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/addressBookCustomSearch.js"></script>

    </body>
</html>