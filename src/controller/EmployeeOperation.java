package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.employeeDao;
import model.dao.employeedaomanage;
import model.entity.employee;
@WebServlet("/EOperation")
public class EmployeeOperation extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String option = req.getParameter("choose");

        if (idParam == null || option == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException ex) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
            return;
        }

        employee e = new employee();
        employeedaomanage edao = new employeedaomanage();

        switch (option) {
            case "ViewData":
                edao.GetEmployeeById(id, e);
                req.setAttribute("employee", e); 
                req.getRequestDispatcher("ViewEmployee.jsp").forward(req, resp);
                break;

            case "updatePassword":
            
                req.getRequestDispatcher("UpdatePassword.jsp").forward(req, resp);
                break;

            case "updateEmployeeData":
            	 req.getRequestDispatcher("UpdateEmpId").forward(req, resp);
                 break;

            case "LogOut":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

           
        }
    }
}
