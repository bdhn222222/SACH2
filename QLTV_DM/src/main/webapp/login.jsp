<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.User"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="row bg-black">
		<div class="col-md-6">
			<section class="header">
		        <div class="container d-flex justify-content-center my-3 ">
                	<img src="img/logo.jpg" alt="logo">
		        </div>
		    </section>
		
			<section class="login">
				<div class="container-wrapper my-3">
				  <div class="row justify-content-center">
				    <div class="col-md-6">
				      <div class="card card-primary bg-dark text-light">
				        <div class="card-header">
				          <h3 class="card-title">Login</h3>
				        </div>
				        <div class="card-body">
				          <form role="form" action="Login" method="post">
				          <%-- Hiển thị thông báo lỗi nếu có --%>
							    <% String errorString = (String)request.getAttribute("errorString"); %>
							    <% if(errorString != null && !errorString.isEmpty()) { %>
							        <div class="alert alert-danger">
							            <strong>Error:</strong> <%= errorString %>
							        </div>
							    <% } %>
				            <div class="form-group">
				              <label for="exampleInputEmail1">Username</label>
				              <input type="text" class="form-control" name="username" placeholder="Tên tài khoản" required="required">
				            </div>
				            <div class="form-group">
				              <label for="exampleInputPassword1">Password</label>
				              <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required="required">
				            </div>
				            <div class="form-check">
				              <input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberMe" value="Y">
				              <label class="form-check-label" for="exampleCheck1">Lưu mật khẩu</label>
				            </div>
				            <!-- <div style="margin-top: 20px;">
				              <small><b>Note:</b> Username: <b>sa</b>, Password: <b>123456</b></small>
				            </div>-->
				            <div class="d-grid gap-2">
				            	<input type="submit" value="login" class="btn btn-primary mt-1" onclick="location.href='home.jsp'">
				            </div>
				          </form>
				        </div>
				      </div>
				    </div>
				  </div>
				</div> 
			</section>
				<!-- /.content -->
				<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		</div>
		<div class="col-md-6">
				<div class="content-wrapper my-5">
				<!-- Main content -->
				<section class="content">
					<div class="container-fluid">
						<div class="row">
							<div class=""></div>
							<div class="col-md-12">
								<div class="card card-primary bg-dark text-light" style="margin-top: 12px;">
									<div class="card-header">
										<h3 class="card-title">Hướng dẫn sử dụng trang web</h3>
									</div>
									<div style="margin-top: 12px; margin-left: 12px;">
										<%
											if (request.getSession().getAttribute("User") == null) {
										%>
										
										<%
											} else {
												/* User user = (User) request.getSession().getAttribute("User");
												String username = user.getUsername(); */
										%>
										
										<%
											}
										%>
										
										
											<b>I. Quản lý sách.</b>
										</p>
										<p>
											- Muốn xem danh sách trong thư viện chọn <b>Quản lý sách
												-&gt; Danh sách.</b>
										</p>
										<p>
											<b>-&nbsp; </b>Trong mục danh sách:&nbsp;
										</p>
										<p></p>
										<ol style="text-align: left;">
											<li>Muốn tìm kiếm sách trong danh sách thì gõ vào ô Tìm
												kiếm và nhấn enter.</li>
											<li>Muốn chỉnh sửa thông tin sách nào thì nút <b>Chỉnh
													sửa</b>-&gt; Chỉnh sửa những thông tin cần thiết-&gt; Nhấn <b>Lưu-</b>&gt;
												nhấn <b>Hủy</b> để trở lại danh sách.
											</li>
											<li>Muốn xóa sách nào thì bạn chọn nút <b>Xóa</b> tương ứng
												của sách đó . Có thông báo xác nhận hiện ra. Chọn <b>Xóa</b> để
												xóa vĩnh viễn hoặc chọn <b>Hủy</b> để hủy thao tác xóa.
											</li>
											<li>Muốn xóa tất cả thì chọn nút <b>Xóa tất cả</b>.
											</li>
										</ol>
										<p>
											- Muốn thêm sách thì chọn&nbsp;<b>Quản lý sách -&gt; Thêm
												sách -&gt; </b>Điền những thông tin cần thiết , chọn thể loại sách
											và hình ảnh tương ứng-&gt; Nhấn <b>Lưu</b> để lưu lại và nhấn <b>Hủy</b>
											để trở lại danh sách.
										</p>
										<p>
											-Muốn xem thể loại sách thì chọn&nbsp;<b>Quản lý sách -&gt;
												Thể loại.</b>
										</p>
										<p>-Trong mục thể loại, muốn thêm thể loại thì chọn thêm thể
											loại, muốn chỉnh sửa chọn chỉnh sửa, muốn xóa thì chọn nút Xóa.</p>
										<p>
											<b>II. Quản lý mượn sách.</b>
										</p>
										<p>
											- Muốn thêm người mượn thì chọn <b>Quản lý mượn
												sách-&gt;Thêm người mượn sách.</b>
										</p>
										<p>
											-Muốn xem danh sách đang mượn sách thì chọn <b>Quản lý mượn
												sách-&gt;Danh sách đang mượn.</b> Ở mục này bạn có thể tìm kiếm,
											quản lý xác nhận đã đã sách hay chưa. Nếu người đó đến trả thì
											bạn chọn <b>Đã trả.</b>
										</p>
										<p>
											- Muốn xem danh sách đang mượn sách thì chọn<b> Quản lý mượn
												sách-&gt;Danh sách đang mượn.&nbsp;</b>
										</p>
									</div>
								</div>
			
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	
</body>
</html>