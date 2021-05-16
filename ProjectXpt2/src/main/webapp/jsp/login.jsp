<!-- 
Author Juho

Tassa JSP ohjelmassa luodaan graafinen nakyma vaalikoneeseen kirjautumista varten

 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<!-- formi jossa kaksi tekstinsyöttökenttää kayttajatunnukselle ja salasanalle sekä submit painike -->
<form action='/checkuser' method='post'>
Käyttäjätunnus <input type='text' name='user' value=''><br>
Salasana <input type='password' name='pass' value=''><br>
<input type='submit' name='ok' value='OK'><br>
</form>
<p>Jos sinulla ei viela ole tunnuksia niin</p>
<a href='/jsp/register.jsp'>Rekisteröidy tästä</a>
</body>
</html>