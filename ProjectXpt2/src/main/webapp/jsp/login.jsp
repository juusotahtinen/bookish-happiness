<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<h2>Log in</h2>
<form action='/checkuser' method='post'>
Email: <input id='email' type='text' name='user' autocomplete="off" value='' placeholder='Account email'><br>
Password: <input id='password' type='password' name='pass' autocomplete="off" value='' placeholder='Account password' ><br>
<input type='submit' name='ok' value='OK'><br>
</form>
</body>
</html>