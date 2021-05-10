<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
</head>
<body>
	<header>
        <h1>Kysymysluettelo</h1>
        <h2>
            <a href="index.html" class="class1">Palaa etusivulle</a>
        </h2>
    </header>

<div class="infobox">
	<div class="info">
  		<h2>Lisää uusi kysymys tietokantaan</h2>
  			<form action="../addquestions" method='post'>
			<input type='text' name='kysymys' value=''>
			<input type='submit' name='OK' value='OK'>
			</form>
	</div>
</div>
    
<div class="startbox">
	<hr/>
		<table class = "table table-striped table-bordered">
			<tr class = "thead-dark">
				<th>Kysymyksen numero</th>
				<th>Kysymys</th>
				<th>Toiminnot</th>
			</tr>
				<c:forEach var="kysymykset" items="${requestScope.kysymyslista }">
				<tr>

					<td>${kysymykset.kysymys_id}</td>
					<td>${kysymykset.kysymys}</td>
					
					<td> 
					<a href='../deletequestions?kysymys_id=${kysymykset.kysymys_id }'>Poista</a>
					| 
 					<a href='../readtoupdatequestions?kysymys_id=${kysymykset.kysymys_id }'>Muokkaa</a>
					</td>
				</tr>	
				
				</c:forEach>
		</table>
	</div>


<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer> 


	
</body>
</html>