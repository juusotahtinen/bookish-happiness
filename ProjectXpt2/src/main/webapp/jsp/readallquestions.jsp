<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One kid read, not fish even they exist</title>
</head>
<body>
<ol>
<c:forEach var="question" items="${requestScope.questionlist }">
<li>${question.kysymys_id}: ${question.kysymys}
		
</c:forEach>
</ol>
</body>
</html>