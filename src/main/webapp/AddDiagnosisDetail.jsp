<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="competition.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 body{
  background-image: url('hospital2.png');
   background-repeat: repeat;
  background-attachment: fixed;
  background-size: cover;
}
.data{
	margin-top:-25px;


}
#loginbox {
width: 30%;
border-radius: 40px;
padding-top: 5%;
padding-bottom: 5%;
background-color: rgb(142, 184, 165) ;
}
  </style>
</head>
<body>
<div class="form1"align="center">
 <h2>Enter Detail to add</h2><br><br>
   <div class="login-modal-div" id="loginbox">
 
    <table style="with: 1%" class="data">
       <form action="AddDiagnosis" method="post" >
    
   <tr>
    <td>Enter Test </td>
     <td><input type="text" name="test" /><br><br></td>
   </tr>
    
    <tr>
        <td>Enter Patient Name </td>
     <td><input type="text" name="pname" /><br><br></td>
    </tr>
            <tr><td>Enter Surgeon Name </td>    
         <td><input type="text" name="sname" /><br><br></td>
             </tr>
             <tr>
                     <td><label for="email">Enter Order date</label> </td>             
         <td><input type="date" name="ordate" id="start"  required  /><br><br></td>
                      </tr>
             <tr>
              <td><label for="email">Enter Result date </label></td>             
          <td><input type="date" name="resdate" id="end"  required /><br><br></td>
                          </tr>
    
   </table>
    
    <input type="submit" value="Submit" />
 </form>
   <a href="Diagnosis.html"><button class ="button" >Back</button></a>
   </div>
  </div>
</body>
</html>