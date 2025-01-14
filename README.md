

# Employee Management System

This is a simple **Employee Management System** built using **Core Java**, **Servlets**, **JDBC**, and **PostgreSQL**. The system provides separate login functionality for **Admin** and **Employee** roles with different operations for each.

---

## Features

### 1. **Admin Operations**
   - **Add Employee**: Admin can add new employee records to the system.
   - **Update Employee**: Admin can update employee details.
   - **Get Employee by ID**: Admin can view specific employee details by their ID.
   - **Get All Employees**: Admin can view all employee records in the system.
   - **Delete Employee**: Admin can delete an employee record from the system.
   - **Logout**: Admin can log out of their session.

### 2. **Employee Operations**
   - **View Data**: Employees can view their own details.
   - **Change Password**: Employees can update their password for security.
   - **Update Details**: Employees can update their profile details.
   - **Logout**: Employees can log out of their session.

---

## Technologies Used

- **Programming Language**: Core Java
- **Database**: PostgreSQL
- **Frameworks**: Servlet
- **Database Connection**: JDBC

---

## Database Schema

### Employee Table

| Column Name    | Data Type        | Description                          |
|----------------|------------------|--------------------------------------|
| `id`           | `INTEGER`        | Unique ID for each employee (Primary Key). |
| `name`         | `CHARACTER VARYING` | Employee's name.                    |
| `phone`        | `BIGINT`         | Contact number.                     |
| `role`         | `CHARACTER VARYING` | Role of the user (`Admin` or `Employee`). |
| `salary`       | `DOUBLE`         | Salary of the employee.             |
| `password`     | `VARCHAR`        | Encrypted password for employee.    |

---

## Setup Instructions

1. **Database Setup**:
   - Install PostgreSQL and create a database (e.g., `employee_management`).
   - Execute the SQL script to create the `employee` table:
     ```sql
     CREATE TABLE employee (
         id SERIAL PRIMARY KEY,
         name CHARACTER VARYING(100) NOT NULL,
         phone BIGINT NOT NULL,
         role CHARACTER VARYING(10) NOT NULL,
         salary DOUBLE PRECISION NOT NULL,
         password VARCHAR(100) NOT NULL
     );
     ```

2. **Project Setup**:
   - Clone the repository and import it into your preferred IDE.
   - Configure the database connection in the `DatabaseConnection` class (update the JDBC URL, username, and password):
     ```java
     private static final String URL = "jdbc:postgresql://localhost:5432/employee_management";
     private static final String USER = "your_username";
     private static final String PASSWORD = "your_password";
     ```

3. **Deploy Application**:
   - Build and deploy the project on a servlet-compatible server like Apache Tomcat.
   - Access the application through your browser.

---

## Endpoints

### Admin
- **Login**: `/admin/login`
- **Add Employee**: `/admin/add`
- **Update Employee**: `/admin/update`
- **Get Employee by ID**: `/admin/get/{id}`
- **Get All Employees**: `/admin/get-all`
- **Delete Employee**: `/admin/delete/{id}`
- **Logout**: `/admin/logout`

### Employee
- **Login**: `/employee/login`
- **View Data**: `/employee/view`
- **Change Password**: `/employee/change-password`
- **Update Details**: `/employee/update`
- **Logout**: `/employee/logout`

---

## Security Features

- Passwords are stored in an encrypted format.
- Role-based access control ensures that only admins can perform admin-specific actions.

---

## Contributing

1. Fork the repository.
2. Create a new branch for your feature.
3. Commit and push your changes.
4. Open a pull request for review.


