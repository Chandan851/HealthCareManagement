<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
 body{
  background-image: url('Loginhospital.jpg');
   background-repeat: repeat;
  background-attachment: fixed;
  background-size: cover;
}
#loginbox {
width: 30%;
border-radius: 25px;
padding-top: 3%;
padding-bottom: 3%;
background-color: rgb(142, 184, 165);

}
</style>
</head>
<body>
<div align="center">
 <h3>SIGN UP</h3>
 <p>Please enter your credentials to Register.</p>
  <h1>E-HEALTH CARE MANAGEMENT</h1>
    <div class="login-modal-div" id="loginbox">
  
<form action="Register">
   <table style="with: 100%">
   
   <tr>
     <td>Name</td>
     <td><input type="text" name="name" placeholder="Enter name" /><br><br></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="email" name="username" placeholder="Enter email" required/><br><br></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" placeholder="Enter password" required/><br><br></td>
    </tr>

   </table>
 <input type="submit" value="Register" /></form><br>
 <p class="message">Alredy have an Account? <a href="Login.html">Login</a></p>
   
</body>
</html>