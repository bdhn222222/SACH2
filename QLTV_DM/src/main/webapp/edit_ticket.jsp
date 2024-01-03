<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Ticket Information</title>
</head>
<body>
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                <c:if test="${not empty ticket}">
                    <c:set var="readerList" value="${readerList}" />
                    <c:set var="bookList" value="${bookList}" />
                    <c:set var="ticketList" value="${ticketList}" />
                    
                    <form action="EditTicket" method="post"  class="col-md-5 bg-light p-3 my-3">
                    <%-- Hiển thị thông báo lỗi nếu có --%>
							    <% String errorString = (String)request.getAttribute("errorString"); %>
							    <% if(errorString != null && !errorString.isEmpty()) { %>
							        <div class="alert alert-danger">
							            <strong>Error:</strong> <%= errorString %>
							        </div>
							    <% } %>
                        <h1 class="text-uppercase h3 py-3">Edit Ticket Information</h1>
                        <input type="hidden" name="idTicket" value="${ticket.idTicket}" />
                        <div class="form-group">
                            <label for="reader">Change Reader's Name</label>
                            <select name="reader">
                                <c:forEach var="reader" items="${readerList}">
                                    <option value="${reader.idReader}" <c:if test="${reader.idReader == ticket.reader.idReader}">selected</c:if>>
                                        ${reader.nameReader}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                                            
                        
                                                            
                        <div class="form-group">
                            <label for="book">Change Book</label>
                            <select name="book">
                                <c:forEach var="book" items="${bookList}">
                                    <option value="${book.idBook}" <c:if test="${book.idBook == ticket.book.idBook}">selected</c:if>>
                                        ${book.nameBook}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div>
                            <label for="status">Status</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="status" id="status1" value="1" <c:if test="${ticket.status == '1'}">checked</c:if>>
                                <label class="form-check-label" for="status1">Borrowing</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="status" id="status0" value="0" <c:if test="${ticket.status == '0'}">checked</c:if>>
                                <label class="form-check-label" for="status0">Rent</label>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="rentday">Rent date</label>
                            <input type="date" name="rentday" id="rentday" class="form-control bg-dark" style="color:white;" value="${ticket.rentDay}" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="returnday">Return date</label>
                            <input type="date" name="returnday" id="returnday" class="form-control bg-dark" style="color:white;" value="${ticket.returnDay}" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="imreturnday">Imperative Payment date</label>
                            <input type="date" name="imperativeReturnDay" id="imperativeReturnDay" class="form-control bg-dark" style="color:white;" value="${ticket.imperativeReturnDay}" required>
                        </div>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                                         
                        <div class="form-group py-3">
                            <div class="d-grid gap-2">
                                <input type="submit" value="Save" class="btn btn-primary mt-1">
                            </div>

						
						     	<div class="d-grid gap-2">
						         	<input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManageTicket'">
						     	</div>
						    </div>
		            </form>
		            </c:if>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>