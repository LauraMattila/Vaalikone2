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
			Puolue: <input type='text' name='puolue' size="100" value='${ehdokkaat.PUOLUE}'><br>
			Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="100" value='${ehdokkaat.KOTIPAIKKAKUNTA}'><br>
			Ikä: <input type='text' name='ika' size="100" value='${ehdokkaat.IKA}'><br>
			Miksi eduskuntaan: <input type='text' name='miksi_eduskuntaan' size="200" value='${ehdokkaat.MIKSI_EDUSKUNTAAN}'><br>
			Mita asioita haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' size="200" value='${ehdokkaat.MITA_ASIOITA_HALUAT_EDISTAA}'><br>
			Ammatti: <input type='text' name='ammatti' size="100" value='${ehdokkaat.AMMATTI}'><br>
			<input type='submit' name='ok' value='Send'> 
		</form>
	</body>
</html>