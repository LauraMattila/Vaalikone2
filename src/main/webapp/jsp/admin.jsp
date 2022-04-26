<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Questions" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!-- Admin site -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Vaalikone - Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../index.css">
    </head>
    
    <body>
    
<!-- Header -->
    	<div class="sticky-top bg-primary">
      		<nav class="navbar navbar-expand-md">
          		<a class="navbar-brand" href="#">Logo</a>
          		<button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse" data-target="#main-navigation">
            		<span class="navbar-toggler-icon"></span>
          		</button>
          	<div class="collapse navbar-collapse" id="main-navigation">
            	<ul class="navbar-nav">
            		<li class="nav-item">
                		<a class="nav-link" href="/index.html">Home</a>
             		</li>
             		<li class="nav-item">
                		<a class="nav-link" href="#">Contact</a>
              		</li>
              		<li class="nav-item">
                		<form action="../index.html">
               				<button type="submit" class="btn btn-dark" data-toggle="modal" data-target="#exampleModalCenter">Log off</button>
                		</form>
              		</li>
            	</ul>
         	</div>
      		</nav>
		</div>

		<header class="page-header header container-fluid">
        	<div class="overlay">
        	</div>
     	</header>
     	
<!-- Question list -->
		<div class="modal fade" id="hallinnoiKysymys" tabindex="-1" role="dialog" aria-labelledby="hallinnoiKysymys" aria-hidden="true">
  			<div class="modal-dialog modal-dialog-centered" role="document">
  				<div class="modal-content">
     				<div class="modal-header">
        				<h5 class="modal-title" id="exampleModalLongTitle">Hallinnoi kysymyksiä</h5>
       					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
       					</button>
      				</div>
      				<div class="modal-body">
						<c:forEach var="Questions" items="${requestScope.kysymykset}" >
							<li>${Questions.id}: ${Questions.question} <a href='/delete?KYSYMYS_ID=${Questions.id}'>delete</a> <a href='/readtoupdate?KYSYMYS_ID=${Questions.id}'>update</a> 
						</c:forEach>
						<br><a href='/readtoadd' class="btn btn-primary">Add question</a>
      				</div>
    			</div>
  			</div>
		</div>

<!-- Site content -->
   	<div class="description">
    	<div class="container features">
        	<div class="row">
            	<div class="col-lg-12 col-md-12 col-sm-12">
       				<h1>Admin management</h1>
      				<p>Edit site content.</p>
      		 		<a class="btn btn-primary">Hallinnoi ehdokkaita</a>
       		 		<a class="btn btn-primary" type="button" data-toggle="modal" data-target="#hallinnoiKysymys">Hallinnoi kysymyksiä</a>
      			</div>
   			</div>
  		</div>
	</div>

<!-- Footer -->
    <footer class="page-footer">
    	<div class="container">
        	<div class="row">
            	<div class="col-lg-12 col-md-12 col-sm-8">
                	<h6 class="text-uppercase font-weight-bold">Additional Information</h6>
                    <p>Authors: Niklas Sundell, Niko Rantala, Laura Mattila</p>
                    <address>Hämeen ammattikorkeakoulu HAMK PL 230 13101 Hämeenlinna</address>
            	</div>
          	</div>
        </div>
    </footer>
    
<!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    <script src="../index.js"></script>

    </body>
</html>