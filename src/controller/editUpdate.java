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

@WebServlet("/editUpdate")
public class editUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		String eid=req.getParameter("id");
	      int id = Integer.parseInt(eid);
		employeeDao edao = new employeeDao();
        employee emp = edao.GetEmployeeById(id);  
        
        if (emp != null) {
            req.setAttribute("employee", emp);  
            RequestDispatcher rd = req.getRequestDispatcher("DataEditUpdate.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Employee not found.");
            RequestDispatcher rd = req.getRequestDispatcher("UpdateEmployee.jsp");
            rd.forward(req, resp);
		
	    }

	    }
}