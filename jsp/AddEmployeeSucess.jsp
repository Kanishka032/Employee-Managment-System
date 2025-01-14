<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Added Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #4CAF50;
        }
        p {
            font-size: 16px;
        }
    </style>
</head>
<body>
<%
String name=request.getParameter("name");
double salary = Double.parseDouble(request.getParameter("salary"));
long phone = Long.parseLong(request.getParameter("phone"));
String password = request.getParameter("password");
String role = request.getParameter("role");
%>
    <div class="container">
        <h2>Employee Added Successfully!</h2>
        <p>Employee Name: <%= name %></p>
        <p>Employee Salary: <%= salary %></p>
        <p>Employee Phone: <%= phone %></p>
        <p>Employee Role: <%= role %></p>
        <a href="AddEmployee.jsp">Add Another Employee</a>
    </div>
</body>
</html>
