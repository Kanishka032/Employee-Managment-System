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

@WebServlet("/getEmpId")
public class GetEmpId extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idP = req.getParameter("empid");
        

        if (idP == null || idP.isEmpty()) {
            req.setAttribute("errorMessage", "Employee ID is required.");
            RequestDispatcher rd = req.getRequestDispatcher("GetEmployee.jsp");
            rd.forward(req, resp);
            return; 
        }

        	 employee e=new employee();
            int id = Integer.parseInt(idP);
       
            employeeDao edao = new employeeDao();
            
            e = edao.GetEmployeeById(id);
            if (e != null) {
                req.setAttribute("employee", e);  
                RequestDispatcher rd = req.getRequestDispatcher("EmployeeIdDetail.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Employee not found.");
                RequestDispatcher rd = req.getRequestDispatcher("GetEmployee.jsp");
                rd.forward(req, resp);
            }


       
    }
}
