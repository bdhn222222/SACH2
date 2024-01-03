<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Reader" %>
<%@ page import="model.bean.Book" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add ticket</title>
</head>
<body style="background-color: #343541;">
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="AddTicket" method="post" class="bg-black text-light col-md-5 bg-light p-3 my-3">
                        <h1 class=" tex-uppercase h3">Add Ticket</h1>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <label for="reader">Full name</label>
                            <select class="form-control bg-dark" style="color: white;" id="reader" name="reader" required>
                                <option value="" disabled selected>Choose option</option>
                                <c:forEach var="reader" items="${readerList}">
                                    <option value="${reader.idReader}">${reader.nameReader}</option>
                                </c:forEach>
                            </select>
                        </div>
 
                        <div class="form-group">
                            <label for="book">Title Book</label>
							<select class="form-control bg-dark" style="color: white;" id="book" name="book" required>
                                <option value="" disabled selected>Choose option</option>
                                <c:forEach var="book" items="${bookList}">
                                    <option value="${book.idBook}">${book.nameBook}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                        <label for="status">Status</label>
                        		<div class="form-check">
								   <input class="form-check-input" type="radio" name="status" id="status" value ="1">
									  <label class="form-check-label" for="flexRadioDefault1">
									    Borrowing
									  </label>
								</div>
								<div class="form-check">
								  <input class="form-check-input" type="radio" name="status" id="status" value = "0" checked>
									  <label class="form-check-label" for="flexRadioDefault2">
									    Rent
									  </label>
						</div>
                        </div>
                        
						<div class="form-group">
						    <label for="pd">Borrow date</label>
						    <input type="date" name="returnday" id="returnday" class="form-control bg-dark" style="color:white;" value="${ticket.returnday != null ? ticket.returnday : ''}" required>
						</div>
						<div class="form-group">
						    <label for="bd">Payment date</label>
						    <input type="date" name="rentday" id="rentday" class="form-control bg-dark" style="color:white;" value="${ticket.rentday != null ? ticket.rentday : ''}" required>
						</div>
						<div class="form-group">
						    <label for="pd">Imperative Payment date</label>
						    <input type="date" name="imreturnday" id="imreturnday" class="form-control bg-dark" style="color:white;" value="${ticket.imperativeday != null ? ticket.imperativeday : ''}" required>
						</div>
                        
                        <hr style="border-top: 1px solid white; margin-bottom: 20px;">
                        
                        <div class="form-group">
                            <div class="d-grid gap-2">
                                <input type="submit" value="Add" class=" btn btn-primary mt-1" >
                            </div>
    
                            <div class="d-grid gap-2">
                                <input type="button" value="Cancel" class="btn btn-secondary mt-1" onclick="location.href='/QLTV/ManageTicket'">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
