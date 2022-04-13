<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.myDiv {
  padding:200px;
 
  text-align: center;
  }
  .button {
border-radius: 12px;
background-color: #4CAF50; /* Green */
border: none;
color: white;
padding: 15px 32px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 16px;
margin: 4px 2px;
cursor: pointer;
-webkit-transition-duration: 0.4s; /* Safari */
transition-duration: 0.4s;
}
.button2:hover {
box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
  body{
  background-image: url('hospital2.png');
   background-repeat: repeat;
  background-attachment: fixed;
  background-size: cover;
}
  </style>
</head>

<body>

<p id="p1"></p>
<p id="p2"></p>

<script>

var today = new Date();

var date = '<b>Date : 0'+today.getDate()+'/0'+(today.getMonth()+1)+'/'+today.getFullYear()+'</b>';
document.getElementById("p1").innerHTML=date;


</script>
<script>
var today = new Date();
var time = '<b>Time : '+today.getHours() + ":" + today.getMinutes()+'   </b>' ;
document.getElementById("p2").innerHTML=time;

</script>

<div align="center">
 <h1 style="background-color:#5C9ADA;">WELCOME TO HEALTH CARE</h1>	
  <tr><td><a href="Patient.html"><button class ="button" style="width: 20%;" >Patient</button></a><br><br></tr></td>
  <tr><td><a href="Surgeon.html"> <button class ="button"style="width: 20%;" >Surgeon</button><br><br></tr></td>
  <tr><td> <a href="Diagnosis.html"><button class ="button"  style="width: 20%;">Diagnosis</button><br><br></tr></td>	
    <tr><td><a href="Login.html"><button  class ="button" style="width: 20%;">logout</button><br><br></tr></td>
 
 </div>
 
</body>
</html>