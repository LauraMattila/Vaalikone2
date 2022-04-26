<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Show candidates site -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Vaalikone</title>
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
            			<button type="button" class="btn btn-dark" data-toggle="modal" data-target="#exampleModalCenter">Admin Login</button>
          			</li>
          		</ul>
      		</div>
    		</nav>
 		</div>

    	

<!-- Question list -->
    <div class="description-card mt-5">
    	<div class="container features">
        	<div class="row">
            	<div class="col-lg-12 col-md-12 col-sm-12">
					<h1>Find Your Candidates!</h1>
					<!-- Loop -->
					<%
					ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("ehdokkaat");

					for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
						
					Candidates q=candidatesList.get(i);
					out.print("<div class='guestion-card mt-5'><div class='text-center guestion'><p><strong>"+q.getLastName()+"</strong></p><p><strong>"+q.getFirstName()+"</strong></p><p><strong>"+q.getAge()+"</strong></p></div></div>");
					}
					%>
  					<div class="text-center mt-5">
    					<button type="button" class="btn btn-primary mx-auto my-2">Submit</button>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  				
<!-- Login modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
 		<div class="modal-dialog modal-dialog-centered" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
        			<form action="/showadmin">
          				<label for="fname">Username:</label><br>
          				<input type="text" id="username" value=""><br>
          				<label for="lname">Password:</label><br>
          				<input type="password" id="password" value=""><br><br>
          				<input type="submit" value="Submit">
        			</form> 
      			</div>
      			<div class="modal-footer text-center">
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