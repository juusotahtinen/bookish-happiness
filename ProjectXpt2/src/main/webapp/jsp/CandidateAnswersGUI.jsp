<!-- 
Author Leevi Palo

Tassa JSP ohjelmassa luodaan graafinen nakyma vaalikoneen kysymyksiin vastaamista varten

 -->

<!-- Alussa tarpeelliset asiat skandi merkkeja ja sivun muotoa varten -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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
<style>
	.questionbox{
	margin: auto;
	width: 70%;
	background-color: rgba(124, 198, 198, 0.2);
    border-radius: 10px;
    position: relative;
    box-shadow: rgb(0 0 0 / 19%) 0px 2px 4px 0px;
	padding: 20px;
    text-align: center;
    margin-bottom: 20px;
	}
</style>

    <TITLE>Vaalikone</TITLE>

</head>
  <BODY>
  <header>
  	<h1> VAALIKONE</h1>
  	<h2>Vastaa seuraaviin kysymyksiin niin saat tietää itsellesi parhaiten sopivan ehdokkaan</h2>
  	<h2>
            <a href="index.html" class="class1">Palaa etusivulle</a>
        </h2>
  </header>




<div class="startbox">
  <div class="col-sm-12">
  	<form NAME="vastaukset" ACTION="/rest/candidatesanswersservice/addanswers" METHOD="POST" >
  		<fieldset>
  		<!-- For Looppi jolla saadaan loopattua jokainen kysymys niin etta saadaan kysymys ja viisi radio painiketta vastaamiseen -->
  		<% 
		ArrayList<Kysymykset> kysymykset = (ArrayList<Kysymykset>)request.getAttribute("kysymykset");
		

  		
  		for ( int i=0;i < kysymykset.size();i++){
  		
  		Kysymykset k=kysymykset.get(i);

  		%>
  	<div class="questionbox">
  		<h3><% out.println(k.getId()+"/"+kysymykset.size()); %></h3>
  		<h4><% out.println(k.getKysymys());%></h4>
	</div>	
		<div class="row justify-content-md-center">
		<div class="col-md-2">
  		<label> Täysin eri mieltä</label>
  		</div>
  		<div class="col-md-2">
  		<label>En osaa sanoa</label>
  		</div>
  		<div class="col-md-2">
  		<label>Täysin samaa mieltä</label>
  		</div>
  		</div>
  		<input type="text" name="kysymys_id" value="<%=k.getId() %>">
  		<div class="row justify-content-md-center">
		<div class="col-sm-1">
  		<input type = "radio" name = "vastaus" value = "1">
  		</div>
  		<div class="col-sm-1">
  		<input type = "radio" name = "vastaus" value = "2">
  		</div>
  		<div class="col-sm-1">
  		<input type = "radio" name = "vastaus" value = "3">
  		</div>
  		<div class="col-sm-1">
  		<input type = "radio" name = "vastaus" value = "4"> 
  		</div>
  		<div class="col-sm-1">
  		<input type = "radio" name = "vastaus" value = "5"> 
  		</div>
  		<br>
  		<br>


		</div>
		
  		<input type = "submit" value="Tallenna vastaus" >

  		<% 

  		}
		
  		%>

  		
	</fieldset>	
  	</form>
	</div>
	</div>
    


  </BODY>
<footer>
	<h2>Vaalikone by TeamTeam3.0</h2>
</footer> 

</HTML>