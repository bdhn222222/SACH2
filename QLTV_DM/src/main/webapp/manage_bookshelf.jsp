<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.BookShelf" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <title>List Of BookShelf</title>
</head>
<body style="background-color: #343541;">

<section class="content my-3">
    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-around">
                <form action="ManageBookShelf" class="bg-black text-light col-md-7 bg-light p-3 my-3">
                   <%-- Hiển thị thông báo lỗi nếu có --%>
							    <% String errorString = (String)request.getAttribute("errorString"); %>
							    <% if(errorString != null && !errorString.isEmpty()) { %>
							        <div class="alert alert-danger">
							            <strong>Error:</strong> <%= errorString %>
							        </div>
							    <% } %>
                    <div class="row">
                        <div class="col-md-8">
                            <h1 class=" tex-uppercase h3 py-2">List of bookshelf</h1>
                        </div>

                        <div class="col-md-4 d-flex justify-content-end ">
                            <button type="button" class="btn btn-success mt-6" id="edit"
                                    onclick="location.href='AddBookShelf'">
                                <h6>Add BookShelf</h6><i class="fa-solid fa-plus"></i>
                            </button>
                        </div>
                    </div>

                    <div class="container mt-3">
                        <table class="table table-sm table-dark text-light">
                            <thead>
                            <tr class="">
                                <th class="col-1">STT</th>
                                <th class="">BookShelf's Name</th>
                                <th class="col-1">Edit</th>
                                <th class="col-1">Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% 
                            List<BookShelf> bookshelfList = (List<BookShelf>) request.getAttribute("BookShelfList");
                            if (bookshelfList != null) {
                                int stt=1;
                                for (BookShelf bookshelf : bookshelfList) {
                            %>
                            <tr>
                                <td><%=stt++%></td>
                                <td><%= bookshelf.getNameBookShelf() %></td>
                                <td>
                                    <a href="EditBookShelf?idBookShelf=<%= bookshelf.getIdBookShelf() %>&idBookShelf=<%= bookshelf.getIdBookShelf() %>">
                                        <i class="fa-solid fa-pen-to-square"></i>
                                    </a>
                                </td>
                                <td>
                                    <a href="DeleteBookShelf?idBookShelf=<%= bookshelf.getIdBookShelf() %>&idBookShelf=<%= bookshelf.getIdBookShelf() %>">
                                        <i class="fa-solid fa-trash"></i>
                                    </a>
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
