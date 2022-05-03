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
		<form action='/rest/candidatesservice/add' method='post'>
			<input type='hidden' name='EHDOKAS_ID' value=''readonly><br>
 			Sukunimi: <input type='text' name='SUKUNIMI' size="100" value=''><br>
 			Etunimi: <input type='text' name='ETUNIMI' size="100" value=''><br>
			Puolue: <input type='text' name='puolue' size="100" value=''><br>
			Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="100" value=''><br>
			Ikä: <input type='text' name='ika' size="100" value=''><br>
			Miksi eduskuntaan: <input type='text' name='miksi_eduskuntaan' size="200" value=''><br>
			Mita asioita haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' size="200" value=''><br>
			Ammatti: <input type='text' name='ammatti' size="100" value=''><br>
			<input type='submit' name='ok' value='Send'> 
		</form>
	</body>
</html>