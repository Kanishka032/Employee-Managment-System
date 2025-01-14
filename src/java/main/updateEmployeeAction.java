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

@WebServlet("/updateEmployeeAction")
public class updateEmployeeAction extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
	        throws ServletException, IOException
	    {
		

	    String name = request.getParameter("name");
	    String role = request.getParameter("role");
	    String password = request.getParameter("password");
	    long phone = Long.parseLong(request.getParameter("phone"));
	    double salary = Double.parseDouble(request.getParameter("salary"));
	    int id = Integer.parseInt(request.getParameter("id"));

	    employee emp = new employee();
	    emp.setId(id);
	    emp.setName(name);
	    emp.setRole(role);
	    emp.setPassword(password);
	    emp.setPhone(phone);
	    emp.setSalary(salary);

	    employeeDao dao = new employeeDao();
	    boolean isUpdated = dao.UpdateById(emp);  

	    if (isUpdated) {
	    	 request.setAttribute("errorMessage", "Updated Successfully.");
	            RequestDispatcher rd = request.getRequestDispatcher("GetAllEmployee.jsp");
	            rd.forward(request, resp);
	    }
	    }
}
