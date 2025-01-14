<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<title>Choose Operation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        color: #333;
    }

    h1 {
        color: #4CAF50;
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px 30px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }

    input[type="radio"] {
        margin: 14px 5px;
        cursor: pointer;
        background-color: #ff9200;
    }

    label {
        display: block;
        margin: 2px 10px;
        font-size: 1rem;
        cursor: pointer;
        color: cadetblue;
        font-weight: 700;
    }

    p {
        color: red;
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
    }
</style>
<script>
    function confirmDelete() {
         var s = document.querySelector('input[name="choose"]:checked');
        if (s && s.value === "LogOut") {
            return confirm("Are you sure you want to LogOut?");
        }
        return true;
    }
</script>
</head>
<body>
<%
String message = (String) request.getAttribute("message");
if (message != null) {
%>
    <p><%= message %></p> 
<%
}
%>
<h1>Choose Your Operation...</h1>
<form action="Operation" method="post" onsubmit="return confirmDelete();">
    <label><input type="radio" name="choose" value="add"> <i class="fas fa-user-plus"></i> Add Employee</label>
    <label><input type="radio" name="choose" value="byId"> <i class="fas fa-id-badge"></i> Employee by ID</label>
    <label><input type="radio" name="choose" value="all"> <i class="fas fa-users"></i> All Employees</label>
    <label><input type="radio" name="choose" value="delete"> <i class="fas fa-user-times"></i> Delete Employee</label>
    <label><input type="radio" name="choose" value="update"> <i class="fas fa-user-edit"></i> Update Employee</label>
    <label><input type="radio" name="choose" value="LogOut"> <i class="fas fa-id-badge"></i> LogOut</label>
    <input type="submit" value="Submit" style="
        margin: 10px 153px;
        width: 115px;
        height: 38px;
        background-color: #56ee56;
        border: 0.5px solid #56ee56;
        border-radius: 20px;">
</form>
</body>
</html>
