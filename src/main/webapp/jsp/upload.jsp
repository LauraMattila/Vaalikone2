<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.util.List" %>  
<%@ page import="data.Ehdokkaat" %>   
    
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
        <link rel="stylesheet" type="text/css" href="/index.css">
    </head>
    
    <body>
    

<h1>Select file to upload</h1>
<form action="./rest/uploadservice/fileupload" method="post" enctype="multipart/form-data">
    Select a file : <input type="file" name='${ehdokkaat.EHDOKAS_ID}' accept=".png" /><br>
    <input type="submit" value="Upload" />
</form>

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