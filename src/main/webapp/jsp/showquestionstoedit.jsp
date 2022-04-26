<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vaalikone</title>
	</head>
	
	<body>
		<h2>Edit question</h2>
		<form action='update' method='post'>
			ID: <input type='text' name='KYSYMYS_ID' value='${requestScope.kysymykset.id}'readonly><br>
			Kysymys: <input type='text' name='KYSYMYS' size="100" value='${requestScope.kysymykset.question}'><br>
			<input type='submit' name='ok' value='Send'> 
		</form>
	</body>
</html>