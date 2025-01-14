<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.dao.employeeDao" %>
<%@ page import="model.entity.employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Updated</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        .error-message {
            color: #e74c3c;
            text-align: center;
            font-size: 18px;
        }

        .success-message {
            color: #2ecc71;
            text-align: center;
            font-size: 18px;
        }

        .employee-details {
            margin-top: 20px;
            padding: 10px;
            background-color: #f1f1f1;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .employee-details p {
            margin: 8px 0;
            font-size: 16px;
            color: #333;
        }

        .employee-details strong {
            color: #4CAF50;
        }
    </style>
</head>
<body>

<%
    String name = request.getParameter("name");
    String role = request.getParameter("role");
    String password = request.getParameter("password");
    long phone = Long.parseLong(request.getParameter("phone"));
    double salary = Double.parseDouble(request.getParameter("salary"));
    int id = Integer.parseInt(request.getParameter("id"));

    employee emp = new employee();
    emp.setId(id);
    emp.setName(name);
    emp.setRole(role);
    emp.setPassword(password);
    emp.setPhone(phone);
    emp.setSalary(salary);

    employeeDao dao = new employeeDao();
    boolean isUpdated = dao.UpdateById(emp);  

    if (isUpdated) {
%>
        <div class="container success-message">
            <h2>Employee updated successfully!</h2>
        </div>

        <div class="container employee-details">
            <h3>Updated Employee Details:</h3>
            <p><strong>Employee ID:</strong> <%= emp.getId() %></p>
            <p><strong>Name:</strong> <%= emp.getName() %></p>
            <p><strong>Role:</strong> <%= emp.getRole() %></p>
            <p><strong>Phone:</strong> <%= emp.getPhone() %></p>
            <p><strong>Salary:</strong> <%= emp.getSalary() %></p>
        </div>

<%
    } else {
%>
        <div class="container error-message">
            <h2>Failed to update employee.</h2>
        </div>
<%
    }
%>

</body>
</html>
