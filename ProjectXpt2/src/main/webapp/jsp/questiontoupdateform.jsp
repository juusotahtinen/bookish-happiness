<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
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
	<h1>Muokkaa ehdokkaan tietoja</h1>
	<h3><a href = "${pageContext.request.contextPath}/readquestions">Takaisin kysymyksiin</a></h3>
</header>

<div class="startbox">
	<table class = "table table-striped table-bordered">
		<tr class = "thead-dark">
			<form action='/updatequestions' method='post'>
			<h2><input type='hidden' name='kysymys_id' value=<%=request.getParameter("kysymys_id") %>><br></h2> 
			<h2>Muokkaa kysymystä: <input type='text' name='kysymys'><br></h2> 
			<input type='submit' name='ok' value='Päivitä kysymys'> 
    		</form>
    	</tr>
    </table>
</div>



</body>
<footer class="ins">
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer>

</html>