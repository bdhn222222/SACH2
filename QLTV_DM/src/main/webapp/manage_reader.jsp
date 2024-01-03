<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách hội viên</title>
</head>
<body class="bg-dark">
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="ManageReader" method="post" class="bg-black text-light col-md-10 bg-light p-3 my-3">
                    <%-- Hiển thị thông báo lỗi nếu có --%>
							    <% String errorString = (String)request.getAttribute("errorString"); %>
							    <% if(errorString != null && !errorString.isEmpty()) { %>
							        <div class="alert alert-danger">
							            <strong>Error:</strong> <%= errorString %>
							        </div>
							    <% } %>
                        <div class="row">
                            <div class="col-md-9">
                                <h1 class=" tex-uppercase h3 py-2">List of Readers</h1>
                            </div>
                            
                            <div class="col-md-3 d-flex justify-content-end ">                                    
                                <button type="button" class="btn btn-success mt-6" id="edit" onclick="location.href='AddReader'">
                                    <h6>Add Reader</h6><i class="fa-solid fa-plus"></i> 
                                </button>
                            </div>
                        </div>
                    
                        <div class="container mt-3">          
                            <table class="table table-dark text-light">
                              <thead>
                                <tr class="">
                                  <th>STT</th>
                                  <th>Member's Name</th>
                                  <th>Identity</th>
                                  <th>Telephone</th>
                                  <th>Edit</th>
                                  <th>Delete</th>
                                </tr>
                              </thead>
                              <tbody>
                               <%int stt=1; %>
                                <c:forEach var="reader" items="${readerList}">
                                    <tr>
                                        <td><%=stt++%></td>
                                        <td><c:out value="${reader.nameReader}" /></td>
                                        <td><c:out value="${reader.identity}" /></td>
                                        <td><c:out value="${reader.telReader}" /></td>
                                        <td>
                                            <a href="EditReader?idReader=${reader.idReader}">
                                                <i class="fa-solid fa-pen-to-square"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="DeleteReader?idReader=${reader.idReader}">
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
