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

@WebServlet("/AdminServlet")
public class LoginServletAdmin extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		       int id=Integer.parseInt(req.getParameter("id"));
		       String pass=req.getParameter("password");
		       
		       employee e=new employee();
		       e.setId(id);
		       e.setPassword(pass);
		       
		   
		       employeeDao edao=new  employeeDao();
		   
		       if(edao.validateAdmin(e)==true) {
		    	   req.setAttribute("message", "Login successful!");
		    	   RequestDispatcher rd=req.getRequestDispatcher("AdminOperation.jsp");
		    	   rd.forward(req, resp);
		       }
		       else
		       {
		    	   req.setAttribute("message", "Login failed!");
		    	   RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.jsp");
		    	   rd.forward(req, resp);
		       }
		    		 
		    }
	
}
