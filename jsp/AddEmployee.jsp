<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
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
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"], input[type="number"], input[type="password"], input[type="submit"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        label i {
            margin-right: 8px;  
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="container">
      <center>  <h2>Add Employee</h2></center>
        <form action="AddEmploy" method="post">
            <input type="hidden" name="choose" value="add" />
            
            <div class="form-group">
                <label for="name"> Employee Name :<i class="fas fa-user"></i></label>
                <input type="text" id="name" name="name" required />
            </div>

            <div class="form-group">
                <label for="salary">Salary: <i class="fas fa-dollar-sign"></i> </label>
                <input type="number" id="salary" name="salary" required />
            </div>

            <div class="form-group">
                <label for="phone">Phone Number:<i class="fas fa-phone"></i> </label>
                <input type="number" id="phone" name="phone" required />
            </div>

            <div class="form-group">
                <label for="password">Password:<i class="fas fa-lock"></i> </label>
                <input type="password" id="password" name="password" required />
            </div>

            <div class="form-group">
                <label for="role">Role:<i class="fas fa-briefcase"></i> </label>
                <select id="role" name="role" required>
                    <option value="admin">Admin</option>
                    <option value="employee">Developer</option>
                    <option value="employee">Tester</option>
                </select>
            </div>

            <input type="submit" value="Add Employee">
        </form>
    </div>
</body>
</html>
