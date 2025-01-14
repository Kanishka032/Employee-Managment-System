<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.entity.employee" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
      
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .employee-info {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .employee-info p {
            font-size: 16px;
            line-height: 1.6;
            color: #333;
        }

        .employee-info strong {
            color: #007BFF;
        }

        .error-message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Employee Details</h1>

    <div class="employee-info">
        <%
            employee e = (employee) request.getAttribute("employee");

            if (e != null) {
        %>
                <p><strong>Employee ID:</strong> <%= e.getId() %></p>
                <p><strong>Employee Name:</strong> <%= e.getName() %></p>
                <p><strong>Employee Salary:</strong> <%= e.getSalary() %></p>
                <p><strong>Employee Phone:</strong> <%= e.getPhone() %></p>
                <p><strong>Employee Role:</strong> <%= e.getRole() %></p>
        <% 
            } else {
        %>
                <p class="error-message">Employee not found.</p>
        <% 
            }
        %>
    </div>

</body>
</html>
