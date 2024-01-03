<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Book" %>
<%@ page import="model.bean.Ticket" %>
<%@ page import="model.bean.Reader" %>
<%@ page import="model.bean.Authors" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of tickets</title>
</head>
<body style="background-color: #343541;">
	<section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="ManageTicket" class="bg-black text-light col-md-12 bg-light p-3 my-3">
                    	<div class="row">
                    		<div class="col-md-9">
		                    	<h1 class=" tex-uppercase h3 py-2">List of tickets</h1>
		                    </div>
		                    
		                    <div class="col-md-3 d-flex justify-content-end ">			                            	
	                           	<button type="button" class="btn btn-success mt-6" id="edit" onclick="location.href='AddTicket'">
							        <h6>Add tickets</h6><i class="fa-solid fa-plus"></i> 
							    </button>
	                    	</div>
                    	</div>
                    	
                    	<hr style="border-top: 1px solid white; margin-bottom: 20px;">
                    	
                        <div class="container mt-3">          
                            <table class="table table-dark">
                              <thead>
                                <tr class="">
                                  <th class="col-1">No.</th>
                                  <th>Fullname</th>
                                  <th>Identification</th>
                                  <th>Title</th>
                                  <th>Status</th>
                                  <th>Borrow day</th>
                                  <th>Payment day</th>
                                  <th >Imperative Day</th>
                                  <th class="col-1 text-center">Editing</th>
                                  <th class="col-1 text-center">Delete</th>
                                </tr>
                              </thead>
                              <tbody>
                              <%int stt=1; %>
                                    <c:forEach var="ticket" items="${ticketList}">
                                        <tr>
                                            <td><%=stt++%></td>
                                            <td><c:out value="${ticket.reader.nameReader}" /></td>
                                            <td><c:out value="${ticket.reader.identity}" /></td>
                                            <td><c:out value="${ticket.book.nameBook}" /></td>
                                            <td><c:out value="${ticket.status}" /></td>
                                            <td><c:out value="${ticket.rentDay}" /></td>
                                            <td><c:out value="${ticket.returnDay}" /></td>
                                            <td><c:out value="${ticket.imperativeReturnDay}" /></td>
                                            
                                            <td>
                                                <a href="EditTicket?idTicket=${ticket.idTicket}&id=${ticket.idTicket}"><i class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                            <td>
                                                <a href="DeleteTicket?idTicket=${ticket.idTicket}&idTicket=${ticket.idTicket}">
                                                    <i class="fa-solid fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
