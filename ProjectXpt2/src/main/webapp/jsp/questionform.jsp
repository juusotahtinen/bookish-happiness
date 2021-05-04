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
	<form action="../addquestions" method='post'>
	<input type='text' name='kysymys' value=''>
	<input type='submit' name='OK' value='OK'>
	</form>
<ol>
	<c:forEach var="kysymykset" items="${requestScope.kysymyslista }">
		<li>${kysymykset} <a href='../deletequestions?kysymys_id=${kysymykset.kysymys_id }'>Poista</a> <a href='../readtoupdatequestions?kysymys_id=${kysymykset.kysymys_id }'>Muokkaa</a>
	</c:forEach>
</ol>
</body>