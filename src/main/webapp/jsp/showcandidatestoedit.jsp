<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page import="data.Ehdokkaat" %> 
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vaalikone</title>
		<script>

</script>
	</head>
	
	<body>
		<h2>Edit candidates</h2>
		<form action='/rest/candidatesservice/update' method='post'>
			ID: <input type='text' name='EHDOKAS_ID' value='${ehdokkaat.EHDOKAS_ID}'readonly><br>
 			Sukunimi: <input type='text' name='SUKUNIMI' size="100" value='${ehdokkaat.SUKUNIMI}'><br>
 			Etunimi: <input type='text' name='ETUNIMI' size="100" value='${ehdokkaat.ETUNIMI}'><br>
<%-- 			Kysymys: <input type='text' name='KYSYMYS' size="100" value='${requestScope.kysymykset.question}'><br> --%>
<%-- 			Kysymys: <input type='text' name='KYSYMYS' size="100" value='${requestScope.kysymykset.question}'><br> --%>
<%-- 			Kysymys: <input type='text' name='KYSYMYS' size="100" value='${requestScope.kysymykset.question}'><br> --%>
			<input type='submit' name='ok' value='Send'> 
		</form>
	</body>
</html>