<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.employee" %>
<%@ page import="model.dao.employeeDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #4CAF50;
            padding: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border: 1px solid #ddd;
            background-color: #fff;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        p {
            text-align: center;
            font-size: 18px;
            color: #ff6347;
        }

        button {
            padding: 8px 16px;
            background-color: #ff6347;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #e03d28;
        }

        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
      <script>
      function confirmDelete() {
    	    return confirm("Are you sure you want to delete this employee?");
    	}

</script>
</head>
<body>
    <h1>All Employees</h1>
    
    <%
        employeeDao dao = new employeeDao();
        List<employee> employees = dao.GetAllEmployee();
        
        if (employees != null && !employees.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Role</th>
                <th>Password</th>
                <th>Salary</th>
                <th>Operations</th>
            </tr>
            <%
                for (employee emp : employees) {
            %>
            <tr>
                <td><%= emp.getId() %></td>
                <td><%= emp.getName() %></td>
                <td><%= emp.getRole() %></td>
                <td><%= emp.getPassword() %></td>
                <td><%= emp.getSalary() %></td>
                <td>
                   
                    <form action="editUpdate" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="<%= emp.getId() %>">
                        <button type="submit">Edit</button>
                    </form>
                    
                   <form action="DeleteUpdate" method="post" style="display:inline;" onsubmit="return confirmDelete();">
    <input type="hidden" name="id" value="<%= emp.getId() %>">
    <button type="submit">Delete</button>
</form>
                   
                </td>
            </tr>
            <%
                }
            %>
        </table>
      
    <%
        } else {
    %>
        <p>No employees found.</p>
    <%
        }
    %>
    <%
    String message = (String) request.getAttribute("errorMessage");
    if (message != null) {
    %>
        <p><%= message %></p> 
    <%
    }
    %>
</body>
</html>
