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
@WebServlet("/Operation")
public class AdminOperations  extends HttpServlet{
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		     String option=req.getParameter("choose");
		     employee e=new employee();
		     employeeDao edao=new  employeeDao();
		     switch (option) {
             case "add":
             {
            	 RequestDispatcher rd=req.getRequestDispatcher("AddEmployee.jsp");
            	 edao.Addemploye(e);
		    	   rd.forward(req, resp);
             }
             case "byId":
             {
            	 RequestDispatcher rd=req.getRequestDispatcher("GetEmployee.jsp");
            	 edao.GetEmployeeById(0); 
		    	   rd.forward(req, resp);
             }
             case "all":
             {
            	 RequestDispatcher rd=req.getRequestDispatcher("GetAllEmployee.jsp");
            	 edao.GetAllEmployee();
		    	   rd.forward(req, resp);
             }
             case "delete":
             {
            	RequestDispatcher rd=req.getRequestDispatcher("DeleteEmployee.jsp");
            	edao.GetDeleteById(0); 
		    	   rd.forward(req, resp);
             }
             case "update":
             {
            	 RequestDispatcher rd=req.getRequestDispatcher("UpdateEmployee.jsp");
            	edao.UpdateById(e); 
		    	   rd.forward(req, resp);
             }
             case "LogOut":
             {
            	 RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
            	 rd.forward(req, resp);
             }
		     }
		    }
}
