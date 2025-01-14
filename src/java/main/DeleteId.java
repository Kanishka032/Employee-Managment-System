package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.employeeDao;
import model.entity.employee;

@WebServlet("/Delete")
public class DeleteId extends HttpServlet {
	
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("empid");
        

        if (idParam == null || idParam.isEmpty()) {
            req.setAttribute("errorMessage", "Employee ID is required.");
            RequestDispatcher rd = req.getRequestDispatcher("DeleteEmployee.jsp");
            rd.forward(req, resp);
            return; 
        }

        try {
        	
            int id = Integer.parseInt(idParam);
       
            employeeDao edao = new employeeDao();
            
            boolean e = edao.GetDeleteById(id);
            if (e != true) {
            	req.setAttribute("errorMessage", "Deleted Successfully.");
                RequestDispatcher rd = req.getRequestDispatcher("DeleteEmployee.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Employee not found.");
                RequestDispatcher rd = req.getRequestDispatcher("DeleteEmployee.jsp");
                rd.forward(req, resp);
            }


        } catch (NumberFormatException e) {
           
            req.setAttribute("errorMessage", "Invalid Employee ID.");
            RequestDispatcher rd = req.getRequestDispatcher("DeleteEmployee.jsp");
            rd.forward(req, resp);
        }
    }
}
