<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vaalikone</title>
</head>
<body>

<div class="startbox">
 <table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<form action='/readtoupdatequestions' method='get'>
					<h2><input type='hidden' name='kysymys_id' value=<%=request.getParameter("kysymys_id") %>><br></h2> 
						<h2>Ehdokkaan uusi sukunimi: <input type='text' name='sukunimi'><br></h2> 
						<h2>Ehdokkaan uusi etunimi: <input type='text' name='etunimi'><br></h2> 
						<h2>Ehdokkaan uusi puolue: <input type='text' name='puolue' ><br></h2> 
					<input type='submit' name='ok' value='Päivitä tiedot'> 
    			</form>
    		</tr>
    	</table>
</div>