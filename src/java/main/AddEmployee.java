package controller;

import model.dao.employeeDao;
import model.entity.employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddEmploy")
public class AddEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        long phone = Long.parseLong(req.getParameter("phone"));
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        employee e = new employee(name,salary,phone,password,role);

        employeeDao edao = new employeeDao();
      

        boolean success = edao.Addemploye(e);

        if (success) {
            req.setAttribute("employee", e);
            RequestDispatcher rd = req.getRequestDispatcher("AddEmployeeSucess.jsp");
            rd.forward(req, resp);
        } else {
            
            req.setAttribute("errorMessage", "Failed to add employee.");
            RequestDispatcher rd = req.getRequestDispatcher("AddEmployee.jsp");
            rd.forward(req, resp);
        }
    }
}
