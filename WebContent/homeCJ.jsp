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
	<link href="css/business-casual.css" rel="stylesheet">
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
                <li class="nav-item active px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="homeCJ.jsp">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="busqueda.jsp">Busqueda</a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="expediente.html">Expedientes</a>
                </li>
                </ul>
            </div>
        </div>
    </nav>
    <br/>
<!--Carousel Wrapper-->
<center>
<!--<div id="col-live-preview"  class="row mx-0 horizontal">-->
<div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel" style="width: calc(70% - 5px)">
    <!--Indicators-->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-1z" data-slide-to="1"></li>
        <li data-target="#carousel-example-1z" data-slide-to="2"></li>
    </ol>
    <!--/.Indicators-->
    <!--Slides-->
    <div class="carousel-inner" role="listbox">
    <!--First slide-->
        <div class="carousel-item active">
            <img class="d-block w-100" src="images/2.jpg" alt="First slide">
        </div>
    <!--/First slide-->
    <!--Second slide-->
        <div class="carousel-item">
            <img class="d-block w-100" src="images/1.jpg" alt="Second slide">
        </div>
    <!--/Second slide-->
    <!--Third slide-->
        <div class="carousel-item">
            <img class="d-block w-100" src="images/3.jpg" alt="Third slide">
        </div>
    <!--/Third slide-->
    </div>
    <!--/.Slides-->

    <!--Controls-->
    <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
    <!--/.Controls-->
</div>
<!--/.Carousel Wrapper-->
</center>

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
    
        </div>
    </section>

    <section class="page-section">
    <div class="container">
      <div class="product-item">
        <div class="product-item-title d-flex">
          <div class="bg-faded p-5 d-flex ml-auto rounded">
            <h2 class="section-heading mb-0">
              <span class="section-heading-upper">Generation México, 31/05/19</span>
              <span class="section-heading-lower">Cohort 13 se gradua</span>
            </h2>
          </div>
        </div>
        <img class="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src="images/noticia1.jpeg" alt="">
        <div class="product-item-description d-flex mr-auto">
          <div class="bg-faded p-5 rounded">
            <p class="mb-0">Llegó el día tan esperado para el cohort 13 de Generation pues Lorem ipsum dolor sit amet consectetur adipisicing elit. Ea aspernatur quibusdam odit non laudantium autem dolores quia quisquam quae debitis!</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="page-section">
    <div class="container">
      <div class="product-item">
        <div class="product-item-title d-flex">
          <div class="bg-faded p-5 d-flex mr-auto rounded">
            <h2 class="section-heading mb-0">
              <span class="section-heading-upper">El Universal, Juan Arvizu</span>
              <span class="section-heading-lower">Senadores y Diputados han pedido protección</span>
            </h2>
          </div>
        </div>
        <img class="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src="images/noticia2.JPG" alt="">
        <div class="product-item-description d-flex ml-auto">
          <div class="bg-faded p-5 rounded">
            <p class="mb-0">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Assumenda necessitatibus accusamus iste molestiae eos ad quas reiciendis, iusto eveniet doloribus accusantium, ullam, minima facilis incidunt vel debitis cumque dolores commodi.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="page-section">
    <div class="container">
      <div class="product-item">
        <div class="product-item-title d-flex">
          <div class="bg-faded p-5 d-flex ml-auto rounded">
            <h2 class="section-heading mb-0">
              <span class="section-heading-upper">MILENIO DIGITAL
Ciudad de México / 30.05.2019</span>
              <span class="section-heading-lower">PRI expulsa a César Duarte</span>
            </h2>
          </div>
        </div>
        <img class="product-item-img mx-auto d-flex rounded img-fluid mb-3 mb-lg-0" src="images/products-03.jpg" alt="">
        <div class="product-item-description d-flex mr-auto">
          <div class="bg-faded p-5 rounded">
            <p class="mb-0">La Comisión Nacional de Justicia Partidaria del PRI avaló este jueves la expulsión de César Duarte Jáquez, ex gobernador de Chihuahua, por lo que dejará de formar parte del PRI y “por ningún motivo podrá reafiliarse”. Te recomendamos: Corral: SRE alista solicitud de extradición de César Duarte El oficio, de siete puntos, señala en el primero de ello que “es fundado el procedimiento sancionador, por las razones jurídicas debidamente fundamentadas en los considerandos relativas a esta resolución” https://www.milenio.com/politica/cesar-duarte-pri-expulsa-gobernador-chihuahua</p>
          </div>
        </div>
      </div>
    </div>
  </section>
        
    
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