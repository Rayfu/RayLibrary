<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title>Library Management</title>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
        <spring:url value="/resources/css/site.css" var="siteCSS" />
        
        <spring:url value="/resources/js/jquery-3.1.0.min.js" var="jqueryJS" />
        <spring:url value="/resources/js/app.js" var="appJS" />
        
        <link href="${bootstrapCSS}" rel="stylesheet" />
        <link href="${siteCSS}" rel="stylesheet" />
        
        <script src="${jqueryJS}"></script>
        <script src="${appJS}"></script>
</head>

<body>
    <div class="container" >
        <br/>
	<h2>Library Management Application Demo</h2>
        <br/>
	<div class="panel panel-default">
        <div class="panel-heading"><spring:message code="lbl.page.personlist" text="lbl.page.personlist" /></div>
        <div class="panel-body">
            <table id="listOfPersons" class="table table-bordered table-striped table-responsive">
                <tr>
                    <th>Person ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                    <th>Lent Books</th>
                  </tr>
                <c:forEach items="${persons}" var="person">    
                  <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.phoneNumber}</td>
                    <td>${person.emailAddress}</td>
                    <td><a href="#" class="btn btn-success" onclick="searchViaAjax(${person.id})" >Display Books Lent</a></td>
                  </tr>
                </c:forEach>
            </table>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><spring:message code="lbl.page.booklist" text="lbl.page.booklist" /></div>
            <div class="panel-body">
                <table id="listOfBooks" class="table table-striped table-bordered table-responsive">
                    <tr>
                        <th>Book ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>ISBN</th>
                      </tr>
                    <c:forEach items="${books}" var="book">    
                      <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.isbn}</td>
                      </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div id="personModal" class="modal fade" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">The books have been lent:</h4>
          </div>
          <div class="modal-body">
            <p>Some text in the modal.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>

      </div>
    </div>
	<br/>
</body>
</html>