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

@WebServlet("/UpdateEmpId")
public class EditUpdateYourData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            req.setAttribute("errorMessage", "Employee ID is required.");
            RequestDispatcher rd = req.getRequestDispatcher("EmployeeOperation.jsp");
            rd.forward(req, resp);
            return; 
        }

        try {
            int id = Integer.parseInt(idParam);
            employee emp = new employee();
            employeedaomanage edao = new employeedaomanage();
            edao.GetEmployeeById(id, emp);
            if (emp != null) {
                req.setAttribute("employee", emp); 
              
                RequestDispatcher rd = req.getRequestDispatcher("employeeManagmentUpdatedata.jsp");
                rd.forward(req, resp);
            } 
            else {
            	req.setAttribute("errorMessage", "Employee not found.");
                RequestDispatcher rd = req.getRequestDispatcher("EmployeeOperation.jsp");
                rd.forward(req, resp);
            }

        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid Employee ID.");
            RequestDispatcher rd = req.getRequestDispatcher("UpdateEmployee.jsp");
            rd.forward(req, resp);
        }
    }
}

