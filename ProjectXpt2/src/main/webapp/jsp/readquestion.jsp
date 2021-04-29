<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="java.util.List" %> 
<%@ page import="data.Kysymykset" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">


</head>
<body>
	<header>
        <h1>Ehdokasluettelo</h1>
        <h2>
            <a href="index.html" class="class1">Palaa etusivulle</a>
        </h2>
        <h2>
            <a href="/addcandidates" class="class1">Lisää uusi ehdokas</a>
        </h2>
    </header>
<div class="startbox">
		
	
	<hr/>
		
		
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">

				<th>Sukunimi</th>
				<th>Etunimi</th>
				<th>Puolue</th>
				<th>Toiminnot</th>
			</tr>

			<c:forEach var="readQuestion" items="${readQuestion}" >
				<tr>

					<td>${readQuestion.kysymys_id}</td>
					
				</tr>
			</c:forEach>
		</table>
		
</div>
<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer> 

</body>
</html>