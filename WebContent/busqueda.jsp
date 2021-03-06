<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 , shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
    <!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom fonts for this template -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	
	<!-- Custom styles for this template -->
	<link href="css/style2.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <title>Consejo de la Judicatura del Estado de Jalisco</title>
</head>
<body>
     <div style="float:right">
    <c:out value="${user.nameSQL}"></c:out>
    	<a href="LogOutServlet">
    		Cerrar Sesión
    	</a>
    </div>          
	<div class ="container">
		<header>
			<img src="images/banner_superior.jpg" id="banner">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
					<h2></h2>
				</div>
			</div>
		</header>
    </div>
    <br/>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
        <div class="container">
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none">Menu</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav mx-auto">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="homeCJ.jsp">Home</a>
                </li>
                <li class="nav-item active px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="busqueda.jsp">Busqueda
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="expediente.html">Expedientes</a>
                </li>
                </ul>
            </div>
        </div>
    </nav>
    <br/>
    <!-- Search Section -->
    <section id="search" class="search-section">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto text-center">
                    <form class="form-inline d-flex" action="BusquedaServlet" method="POST">
                        <input type="text" name="txtExp" class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0 fas" id="txtExp" placeholder="&#xF002; Buscar expediente...">
                        <button type="submit" class="btn btn-primary mx-auto">Buscar</button>
                    </form>
                    <br/>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Filter Section -->
    <section class="filter-section">
        <div class="container">
    
            <div class="row">
    
                <div class="col-md-4 mb-3 mb-md-0">
                    <div class="card py-4 h-100">
                        <div class="card-body text-center">
                            <i class="fas fa-file-invoice text-primary mb-2"></i>
                            <h4 class="text-uppercase m-0">Expediente</h4>
                            <hr class="my-4">
                            <div class="small text-black-50">Realiza una busqueda utilizando el ID del expediente</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3 mb-md-0">
                    <div class="card py-4 h-100">
                        <div class="card-body text-center">
                            <i class="fas fa-user text-primary mb-2"></i>
                            <h4 class="text-uppercase m-0">Nombre</h4>
                            <hr class="my-4">
                            <div class="small text-black-50">Realiza una busqueda por medio del nombre de actor o demandado
                            </div>
                        </div>
                    </div>
                </div>
    
                <div class="col-md-4 mb-3 mb-md-0">
                    <div class="card py-4 h-100">
                        <div class="card-body text-center">
                            <i class="fas fa-gavel text-primary mb-2"></i>
                            <h4 class="text-uppercase m-0">Juicio</h4>
                            <hr class="my-4">
                            <div class="small text-black-50">Realiza una busqueda por medio de la clase de juicio</div>
                        </div>
                    </div>
                </div>
            </div>
    
            
    
        </div>
    </section>
    <br/>
    <section class="contact-section">
        <div class="container">
			<div id="resultados" class="row">
				<table class="table table-bordered table-dark">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">ApellidoP</th>
							<th scope="col">ApellidoM</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="myValue" items="${list}">
							<tr>
								<td scope="row"><c:out value="${myValue.nombre}"></c:out></td>
								<td scope="row"><c:out value="${myValue.apellidoP}"></c:out></td>
								<td scope="row"><c:out value="${myValue.apellidoM}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
            </div>
        </div>
    </section>
        
    <div class="social d-flex justify-content-center">
                <a href="#" class="mx-2">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="#" class="mx-2">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="#" class="mx-2">
                    <i class="fab fa-github"></i>
                </a>
            </div>
    <!-- Footer -->
    <footer class="bg-black small text-center text-white-50">
        <div class="container">
            Copyright &copy; iTecno 2019
        </div>
    </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="scripts/script.js"></script>
</body>
</html>