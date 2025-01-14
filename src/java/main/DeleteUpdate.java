package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.employeeDao;

@WebServlet("/DeleteUpdate")
public class DeleteUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String idParam = req.getParameter("id");
        
       
        try {
           
            int id = Integer.parseInt(idParam);
            
            employeeDao edao = new employeeDao();
            
            
            if (edao.GetDeleteById(id)) {
            	  RequestDispatcher rd = req.getRequestDispatcher("GetAllEmployee.jsp");
                req.setAttribute("errorMessage", " Not Found.");
                rd.forward(req, resp);
               
            } else {
            	  RequestDispatcher rd = req.getRequestDispatcher("GetAllEmployee.jsp");
                req.setAttribute("errorMessage", "Deleted Succesfully.");
                rd.forward(req, resp);
               
            }
        ;
        } catch (NumberFormatException ex) {
            
            req.setAttribute("errorMessage", "Invalid employee ID format.");
            RequestDispatcher rd = req.getRequestDispatcher("GetAllEmployee.jsp");
            rd.forward(req, resp);
          
        }
        
    }
}
