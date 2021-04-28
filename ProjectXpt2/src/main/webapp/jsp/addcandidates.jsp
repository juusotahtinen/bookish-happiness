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
      <h1>Syötä ehdokkaan tiedot</h1>
        <h2>
            <a href='/showcandidates' class="class1">Listaa kaikki ehdokkaat</a>
        </h2>
</header>

<div class="addbox">

  <div class="container">
    <div class="row">
     
      <div class="col-lg-12" align="center">
        <div class="card shadow-sm">
          
     
          <div class="card-body pt-0"><form action='/inserted' method='post'>
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Sukunimi</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='sukunimi' value='${requestScope.added.sukunimi}'><br></td>
			 </tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Etunimi</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='etunimi' value='${requestScope.added.etunimi}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Puolue</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='puolue' value='${requestScope.added.puolue}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Kotipaikkakunta</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='kotipaikkakunta' value='${requestScope.added.kotipaikkakunta}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Ikä</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='ika' value='${requestScope.added.ika}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Miksi haluat eduskuntaan</th>
                <td width="2%">:</td>
                <td align="center">
				<textarea rows="10" cols="40" input type='text' name='miksi_eduskuntaan' value='${requestScope.added.miksi_eduskuntaan}'></textarea>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Mitä asioita haluat edistää</th>
                <td width="2%">:</td>
                <td align="center" height="300px">
                <textarea rows="10" cols="40" input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.added.mita_asioita_haluat_edistaa}'></textarea>	
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">
                <th align="center" width="50%" height="30px">Ammatti</th>
                <td width="2%">:</td>
                <td align="center">
				<input type='text' name='ammatti' value='${requestScope.added.ammatti}'><br></td>
			</tr>
           </table>
          </div>
          
          <div class="card-body pt-0">
            <table class="table table-bordered">
              <tr align="center">


                <td align="center">
				<input type='submit' name='ok' value='Lisää ehdokas'> 
			</tr>
           </table>
          </div>
         </tr>
           </table>
          </div>
        </div> 
         </form>
    </div>
    </div>
    </div>
<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer>              
              
   
</body>
</html>