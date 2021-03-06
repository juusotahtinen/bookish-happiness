<!-- 
Author Juho

Tassa JSP ohjelmassa luodaan graafinen nakyma vaalikoneeseen rekisteroitymista varten

 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add new account</title>
<script>

<!-- funktio joka lahettaa tiedot Accountservice.javalle-->
function sendData() {
	//Luodaan uusi Javascript -olio joka saa arvot email ja password
	var account=new Object();
	account.email=document.getElementById("email").value;
	account.password=document.getElementById("password").value;
	
	var jsonAccount=JSON.stringify(account);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	   document.getElementById("responseView").innerHTML = this.responseText;
	   var returned=JSON.parse(this.responseText);
	   document.getElementById("inparts").innerHTML="ID="+returned.id+" Email="+returned.email+" Password="+returned.password;
	  }
	};
	
	xhttp.open("POST","/rest/accountservice/addaccount",true);
	xhttp.setRequestHeader("Content-type","application/json");
	xhttp.send(jsonAccount);
	
	document.getElementById("submitted").innerHTML = "Registered successfully!";
}
</script>
</head>

<body>
<h2>Registration</h2>
<!-- formi jossa kaksi tekstinsyöttökenttää kayttajatunnukselle ja salasanalle sekä submit painike jota painettaessa kututaan sendData -funktiota -->
<form action="#" method='post' onsubmit='return false;'>
Email: <input id='email' type='text' name='email' autocomplete="off" value='' placeholder='New account email'><br>
Password: <input id='password' type='password' name='password' autocomplete="off" value='' placeholder='New account password' ><br>
<input type='button' name='ok' value='Send' onclick='sendData();'><br>
</form>
<p><a href='/jsp/login.jsp'>Kirjaudu sisään</a></p>

<p id="submitted"></p>



</body>
</html>