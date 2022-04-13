<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 body{
  background-image: url('hospital2.png');
   background-repeat: repeat;
  background-attachment: fixed;
  background-size: cover;
}
.form1{
 margin-top: 25px;

}
#loginbox {
width: 30%;
border-radius: 40px;
padding-top: 3%;
padding-bottom: 5%;
background-color: rgb(142, 184, 165) ;
}

  </style>
</head>
<body>
<div align="center">
 <h2>Enter Detail to add</h2>
 <div class="form1"align="center">
   <div class="login-modal-div" id="loginbox">
 
 <table style="with: 100%">
  
      <form action="AddPatient" method="post" >
   
    <tr>
     <td>Enter Patient Name </td>
     <td><input type="text" name="name" required/><br><br></td>
   
    <tr>
     <td>Date of Birth </td>
     <td><input type="date" name="dob" required/><br><br></td>
    </tr>
    <tr>
    <tr>
     <td>Date of Admission </td>
     <td><input type="date" name="doa" required/><br><br></td>
    </tr>
    <tr>
     <td>Enter Gender </td>
     <td><input type="text" name="gender" required /><br><br></td>
    </tr>

   </table>
   <input type="submit" value="Submit" /></form>
   
   <a href="Patient.html"><button  class ="button" >Back</button></a>
  
</body>
</html>