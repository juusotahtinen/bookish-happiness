<!-- 
Author Juho Hämäläinen

Tassa JSP ohjelmassa luodaan graafinen nakyma sopivimmista ehdokkaista käyttäjälle hänen vastattuaan vaalikoneen kysymyksiin.

 -->

<!-- Alussa tarpeelliset asiat sivun muotoa varten -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>  
<%@ page import="data.Candidates" %>
 
   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
  <HEAD>
    <TITLE>Vaalikone</TITLE>
  </HEAD>

  <BODY>
  	<div class="container">
  	<div class="row">
  	<div class="col-sm-12">
  	<fieldset>
  	<!-- Haetaan sopivaEhdokas listaan ehdokkaat  -->
  	    <h1>Sinulle sopivimmat ehdokkaat sopivuus järjestyksessä:</h1>

  	<%
  	ArrayList<Candidates> sopivaEhdokas = (ArrayList<Candidates>)request.getAttribute("parhaatEhdokkaat");
  	
  	
  	for ( int i=0;i <sopivaEhdokas.size();i++){
		
		Candidates k=sopivaEhdokas.get(i);

	%>
	
	<!--  Muotoillaan sivulle näkyviin kolmen parhaan ehdokkaan äänestysnumero, ehdokkaan nimi ja puolue -->
		<div class="row justify-content-md-center">
		<div class="col">
		<br>
		Ehdokas nro: <% out.println(k.getEhdokas_id()); %> <br>
		Nimi: <% out.println(k.getSukunimi() +" " + k.getEtunimi()); %> <br>
		Puolue: <% out.println(k.getPuolue()); %> <br>
		</div>
		</div>
		
  
  	<% } %>
  	</fieldset>
  	</div>
    </div>
	</div>
  </BODY>
</HTML>