<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<style>
	.info {
	font-family: Roboto, sans-serif;
 	text-align: center;
 	font-size: 20px;
 	margin: auto;
	width: 70%;
	background-color: rgba(124, 198, 198, 0.4);
    border-radius: 10px;
    position: relative;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	padding: 20px;
    text-align: center;
    margin-bottom: 20px;
    margin-top: 50px;
	}
	
	.infobox{
	width: 70%;
	padding: 20px;
    margin-bottom: 20px;
	}
</style>
</head>
<body>

	<header>
        <h1>Ehdokkaan tiedot</h1>
        <h3><a href = "${pageContext.request.contextPath}/showcandidates">Takaisin ehdokkaisiin</a></h3>
    </header>

  <div class="startbox">
		
	
	
		
		
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Sukunimi</th>
				<th>Etunimi</th>
				<th>Puolue</th>
				<th>Ikä</th>
				<th>Ammatti</th>
				<th>Kotipaikkakunta</th>
			</tr>

			<c:forEach var="ehdokas" items="${requestScope.ehdokas}" >
				<tr>
					<td>${ehdokas.sukunimi}</td>
					<td>${ehdokas.etunimi}</td>
					<td>${ehdokas.puolue}</td>
					<td>${ehdokas.ika}</td>
					<td>${ehdokas.ammatti}</td>
					<td>${ehdokas.kotipaikkakunta}</td>
				</tr>
			<div class="info">
				<h4><a href = "${pageContext.request.contextPath}/jsp/editcandidates.jsp?ehdokas_id=${ehdokas.ehdokas_id}">Muokkaa ehdokkaan tietoja</a></h4>
			</div>
			</c:forEach>
		</table>
		<div class="infobox">
		   <div class="info">
  				<h2>Miksi minut pitäisi valita eduskuntaan</h2>
  					<c:forEach var="ehdokas" items="${requestScope.ehdokas}" >
					<td>- ${ehdokas.miksi_eduskuntaan}</td>
			</div>
			<div class="info">
						<h2>Mitä asioita haluan edistää</h2>
					<td>- ${ehdokas.mita_asioita_haluat_edistaa}</td>
			</div>	
		  </c:forEach>
		</div>
</div>
</body>
<footer>
	<h4>Vaalikone by TeamTeam3.0</h4>
</footer>
</html>