<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            font-size: 16px;
            margin-bottom: 8px;
            display: block;
            color: #333;
        }
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            font-size: 16px;
            margin-top: 20px;
        }
        .message.success {
            color: green;
        }
        .message.error {
            color: red;
        }
    </style>
    <script>
        function validateForm() {
            const oldPass = document.forms["passwordForm"]["old"].value;
            const newPass = document.forms["passwordForm"]["new"].value;
            if (!oldPass || !newPass) {
                alert("Both fields must be filled out.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Change Password</h2>
    <%
        String idParam = request.getParameter("id");
        int id = 0;
        try {
            if (idParam != null && !idParam.isEmpty()) {
                id = Integer.parseInt(idParam);
            }
        } catch (NumberFormatException e) {
            out.println("<p class='message error'>Invalid ID format.</p>");
        }
    %>
    <form name="passwordForm" action="passwordemployee" method="post" onsubmit="return validateForm();">
        <input type="hidden" name="id" value="<%= id %>">
    
        <label for="old">Old Password:</label>
        <input type="password" id="old" name="old" required>
    
        <label for="new">New Password:</label>
        <input type="password" id="new" name="new" required>
    
        <input type="submit" value="Submit">
    </form>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
            String messageClass = message.equals("Password Changed") ? "success" : "error";
    %>
        <div class="message <%= messageClass %>"><%= message %></div>
    <%
        }
    %>
</div>
</body>
</html>
