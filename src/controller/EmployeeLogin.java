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

@WebServlet("/EmployeeServlet")
public class EmployeeLogin extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		       int id=Integer.parseInt(req.getParameter("id"));
		       String pass=req.getParameter("password");
		       
		       employee e=new employee();
		       e.setId(id);
		       e.setPassword(pass);
		       
		   
		       employeedaomanage edao=new  employeedaomanage();
		   
		       if(edao.validateemployee(e)==true) {
		    	   req.setAttribute("message", "Login successful!");
		    	   RequestDispatcher rd=req.getRequestDispatcher("EmployeeOperation.jsp");
		    	   rd.forward(req, resp);
		       }
		       else
		       {
		    	   req.setAttribute("message", "Login failed!");
		    	   RequestDispatcher rd=req.getRequestDispatcher("EmployeeLogin.jsp");
		    	   rd.forward(req, resp);
		       }
		    		 
		    }
	
}
