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

</head>

<body>
<header>
	<h1>Muokkaa ehdokkaan tietoja</h1>
	<h3><a href = "${pageContext.request.contextPath}/showcandidates">Takaisin ehdokkaisiin</a></h3>
</header>
<div class="startbox">
 <table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<form action='/editcandidates1' method='get'>
					<h2><input type='hidden' name='ehdokas_id' value=<%=request.getParameter("ehdokas_id") %>><br></h2> 
						<h2>Ehdokkaan uusi sukunimi: <input type='text' name='sukunimi'><br></h2> 
						<h2>Ehdokkaan uusi etunimi: <input type='text' name='etunimi'><br></h2> 
						<h2>Ehdokkaan uusi puolue: <input type='text' name='puolue' ><br></h2> 
					<input type='submit' name='ok' value='Päivitä tiedot'> 
    			</form>
    		</tr>
    	</table>
</div>
</body>
<footer class="ins">
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer>

</html>