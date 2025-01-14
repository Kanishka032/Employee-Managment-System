<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entity.employee" %>
<%@ page import="model.dao.employeedaomanage" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #0056b3;
        }
        .error {
            color: red;
        }
        .employee-table {
            margin-top: 20px;
            border-collapse: collapse;
            width: 50%;
            margin: auto;
            background-color: #fff;
            border: 1px solid #ddd;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .employee-table th, .employee-table td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ddd;
        }
        .employee-table th {
            background-color: #f4f4f9;
            font-weight: bold;
        }
        .employee-table tr:hover {
            background-color: #f1f1f1;
        }
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
 <center><h1>Employee Details</h1></center>
    <%
        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
    %>
                <p class="error">Error: ID parameter is missing.</p>
    <%
            } else {
                int id = Integer.parseInt(idParam);

                employee emp = new employee();
                employeedaomanage edao = new employeedaomanage();

                if (edao.GetEmployeeById(id, emp) != null) {
    %>
                <table class="employee-table">
                    <tr>
                        <th>ID</th>
                        <td><%= emp.getId() %></td>
                    </tr>
                    <tr>
                        <th>Phone</th>
                        <td><%= emp.getPhone() %></td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td><%= emp.getName() %></td>
                    </tr>
                    <tr>
                        <th>Salary</th>
                        <td><%= emp.getSalary() %></td>
                    </tr>
                    <tr>
                        <th>Role</th>
                        <td><%= emp.getRole() %></td>
                    </tr>
                </table>
    <%
                } else {
    %>
                <p class="error">No employee found with ID: <%= id %></p>
    <%
                }
            }
        } catch (NumberFormatException e) {
    %>
            <p class="error">Error: Invalid ID format. Please provide a numeric ID.</p>
    <%
        } catch (Exception e) {
    %>
            <p class="error">Error: <%= e.getMessage() %></p>
    <%
        }
    %>
</body>
</html>
