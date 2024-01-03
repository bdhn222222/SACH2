<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.bean.BookShelf" %>
<%@ page import="model.bean.Category" %>
<%@ page import="model.bean.Authors" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
	 <section class="content my-3">
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
    <c:if test="${not empty book}">
        <c:set var="bookShelfList" value="${bookShelfList}" />
        <c:set var="authorsList" value="${authorsList}" />
    
        <form action="EditBook" method="post" class="col-md-5 bg-light p-3 my-3 rounded">
        <h1 class="tex-uppercase h3 py-3">Edit Book</h1>
            <input type="hidden" name="idBook" value="${book.idBook}" />
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="nameBook" value="${book.nameBook}" /></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <select name="category">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.idCategory}" <c:if test="${category.idCategory == book.category.idCategory}">selected</c:if>>
                                    ${category.nameCategory}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Bookshelf:</td>
                    <td>
                        <select name="bookShelf">
                            <c:forEach var="bookShelf" items="${bookShelfList}">
                                <option value="${bookShelf.idBookShelf}" <c:if test="${bookShelf.idBookShelf == book.bookShelf.idBookShelf}">selected</c:if>>
                                    ${bookShelf.nameBookShelf}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Authors:</td>
                    <td>
                        <select name="authors">
                            <c:forEach var="authors" items="${authorsList}">
                                <option value="${authors.idAuthors}" <c:if test="${authors.idAuthors == book.authors.idAuthors}">selected</c:if>>
                                    ${authors.nameAuthors}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="text" name="amount" value="${book.amount}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form>
    </c:if>
</body>
</html>