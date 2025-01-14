<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entity.employee" %>
<%@ page import="model.dao.employeeDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
            padding: 20px;
        }
        form {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        label {
            font-size: 18px;
            color: #333;
        }
        input[type="text"], input[type="password"], input[type="number"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Update Employee Details</h1>
    
    <%
        employee emp = (employee) request.getAttribute("employee");  
        if (emp != null) {
    %>
    <form method="post" action="updateEmployeeAction">
        <input type="hidden" name="id" value="<%= emp.getId() %>">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= emp.getName() %>" required><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" value="<%= emp.getRole() %>" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= emp.getPassword() %>" required><br>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" value="<%= emp.getPhone() %>" required><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" value="<%= emp.getSalary() %>" required><br>

        <input type="submit" value="Update Employee">
    </form>
    <%
        } else {
            out.println("<p>Employee not found!</p>");
        }
    %>
</body>
</html>
