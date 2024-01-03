<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <% String sky = "#009bdd"; %>
    <% String shadow = "#343541"; %>
    <style>
        .bg-sky{
        	background-color: <%= sky %>
        }
    </style>
    <style>
    	.bg-shadow{
    		background-color: <%= shadow %>
    	}
    </style>
</head>
<body>
    <section class="header bg-black">
        <div class="container">
            <div class="row">
                <div class="col-3 px-1">
                	<a class="nav-link" onclick="location.href='home.jsp'">
                		<img src="img/logo.jpg" alt="logo" class="img-fluid" style="max-width: 165px;">
                	</a>
                </div>
                <div class="col-4"></div>
                <div class="col-3 d-flex align-items-center">
                 	<div class="text-light flex-column">
                 		<i class="fa-solid fa-phone" style="color: #f5f5f5;"></i> 0123-456-789<br>
                 		<i class="fa-solid fa-envelope" style="color: #f5f5f5;"></i> Managementlibrary@gmail.com<br>
                 		<i class="fa-solid fa-globe" style="color: #f5f5f5;"></i> www.managementlibrary.com<br>
                 		<i class="fa-solid fa-location-dot" style="color: #f5f5f5;"></i> 459 Tôn Đức Thắng
                 	</div>
                </div>
               	<div class="col-2 d-flex align-items-center">
          			<div class="container d-flex justify-content-end ">			                            	
                      	<button type="button" class="btn btn-secondary fs-5 mt-1" id="login" onclick="location.href='login.jsp'">
	        				<i class="fa-solid fa-right-from-bracket" style="color: #f5f5f5;"></i> Log out
	    				</button>
                   </div>
               	</div>
             </div>
        </div>              
    </section>

    <section class="mymainmenu bg-primary">
        <div class="container">
            <div class="row">
             	<div class="col-md-3 d-flex align-items-center text-light py-3">
            		<div class="row">
              			<div class="col-md-3">
							<div class="fs-6">
								<i class="fa-solid fa-user" style="color: #ffffff;"></i>
							</div>              		
              			</div>
              			
              			<div class="col-md-9 ">
							<div class="fs-6">
								<a class="nav-link active" aria-current="page" href="account.jsp">ACCOUNT</a>
							</div>              		
              			</div>
              		</div>
              	</div>

                <div class="col-md-9 d-flex align-items-center">
                
                  <nav class="navbar navbar-expand-lg bg-primary">
                    <div class="container-fluid">
		                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						    <span class="navbar-toggler-icon"></span>
						  </button>
						  
	                      <div class="collapse navbar-collapse" id="navbarSupportedContent">
	                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	                          
	
							  <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                              Author management
	                            </a>
	                            <ul class="dropdown-menu bg-shadow">
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageAuthors'">List of authors</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddAuthors'">Add authors</a></li>
	                            </ul>
	                          </li>
	                          
	                          <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                              Book management
	                            </a>
	                            <ul class="dropdown-menu bg-shadow">
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageBook'">List of book</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageBookShelf'">List of bookshelf</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageCategory'">List of category</a></li>	                              
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddBook'">Add books</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddBookShelf'">Add bookshelfs</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddCategory'">Add category</a></li>
	                            </ul>
	                          </li>
	
	                          <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                              Ticket management
	                            </a>
	                            <ul class="dropdown-menu bg-shadow">
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageTicket'">List of tickets</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddTicket'" >Add tickets</a></li>
	                            </ul>
	                          </li>
	                          
	                          <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                              Reader of management
	                            </a>
	                            <ul class="dropdown-menu bg-shadow">
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageReader'" >List of reader</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddReader'" >Add reader</a></li>
	                            </ul>
	                          </li>
	                          <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                              Member of management
	                            </a>
	                            <ul class="dropdown-menu bg-shadow">
	                              <li><a class="dropdown-item text-light" onclick="location.href='ManageUser'" >List of members</a></li>
	                              <li><a class="dropdown-item text-light" onclick="location.href='AddUser'" >Add members</a></li>
	                            </ul>
	                          </li>
	                        </ul>
	                      </div>
	                     </div>
	                     </div>
                  </nav>
                </div>
                
            
        </div>
    </section>
</body>
</html>
