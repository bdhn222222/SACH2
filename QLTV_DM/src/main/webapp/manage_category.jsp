<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Category" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Danh sách thể lọai</title>
</head>
<body class="bg-dark">
    <section class="content my-3">
        <div id="wrapper">
            <div class="container">
            
                <div class="row justify-content-around">
                <form action="<%= request.getContextPath()%>/ManageCategory" method="POST" class="bg-black text-light col-md-6 bg-light p-3 my-3">
                        <%-- Hiển thị thông báo lỗi nếu có --%>
							    <% String errorString = (String)request.getAttribute("errorString"); %>
							    <% if(errorString != null && !errorString.isEmpty()) { %>
							        <div class="alert alert-danger">
							            <strong>Error:</strong> <%= errorString %>
							        </div>
							    <% } %>
							    <div class="row">
                            <div class="col-md-8">
                                <h1 class=" tex-uppercase h3 py-2">List of Category</h1>
                            </div>
                            
                             <div class="col-md-4 d-flex justify-content-end ">			                            	
	                           	<button type="button" class="btn btn-success mt-6" id="edit" onclick="location.href='AddCategory'">
							        <h6>Add Category</h6><i class="fa-solid fa-plus"></i> 
							    </button>
	                    	</div>
                        </div>
                        
                        <div class="container mt-3">          
                            <table class="table table-dark">
                                <thead>
                                    <tr class="">
                                        <th>STT</th>
                                        <th>Category Name</th>
                                        <th class="col-2">Edit</th>
                                        <th class="col-2">Delete</th>
                                    </tr>
                                </thead>
                              <tbody>
                                <% 
                                List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
                                if (categoryList != null) {
                                	int stt = 1;
                                    for (Category category : categoryList) {
                                    	
                                %>
                                    <tr>
                                        <td><%= stt++ %></td>
                                        <td><%= category.getNameCategory() %></td>
                                        <td>
                                            <a href="EditCategory?idCategory=<%= category.getIdCategory() %>&id=<%= category.getIdCategory() %>"><i class="fa-solid fa-pen-to-square"></i></a>
                                        </td>
                                        <td>
                                            <a href="DeleteCategory?idCategory=<%= category.getIdCategory() %>&idCategory=<%= category.getIdCategory() %>"><i class="fa-solid fa-trash"></i></a>
                                        </td>
                                    </tr>
                                <% 
                                    }
                                }
                                %>
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