<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
   
<link rel="icon" href="path/to/your/favicon.ico" type="image/x-icon">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px 30px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h1 {
        text-align: center;
        color: #4CAF50;
        font-size: 1.5rem;
        margin-bottom: 20px;
    }

    img {
        display: block;
        margin: 0 auto 20px;
        width: 80px;
        height: auto;
    }

    label, input[type="number"], input[type="text"], input[type="submit"] {
        display: block;
        width: 100%;
        margin-bottom: 15px;
    }

    input[type="number"], input[type="text"] {
        padding: 10px;
        font-size: 1rem;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="number"]:focus, input[type="text"]:focus {
        outline: none;
        border-color: #4CAF50;
        box-shadow: 0 0 4px rgba(76, 175, 80, 0.5);
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        font-size: 1rem;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
        transform: scale(1.05);
    }

    p {
        margin-top: 15px;
        color: red;
        text-align: center;
        font-weight: bold;
    }
</style>
</head>
<body>

<form action="EmployeeServlet" method="post">
  <img src="https://thumbs.dreamstime.com/b/customer-support-service-agent-headset-flat-vector-icon-design-designs-153069456.jpg" alt="Admin Profile" style="width: 80px; height: auto; border:0.5px solid beige; border-radius:50%; background-coor:grey;">
  
   
    <h1>Employee Login</h1>
    <label for="id"><i class="fas fa-user"></i> Enter your ID:</label>
    <input type="number" id="id" name="id" placeholder="Enter your admin ID" required>
    
    <label for="password"><i class="fas fa-lock"></i> Enter your Password:</label>
    <input type="text" id="password" name="password" placeholder="Enter your password" required>
    
    <input type="submit" value="Login">
</form>

<%
String message = (String) request.getAttribute("message");
if (message != null) {
%>
    <p><%= message %></p> 
<%
}
%>

</body>
</html>
