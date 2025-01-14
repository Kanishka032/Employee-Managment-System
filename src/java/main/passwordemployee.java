package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.employeedaomanage;
import model.entity.employee;

@WebServlet("/passwordemployee")
public class passwordemployee extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Pid = req.getParameter("id");
        int ids = 0;
        System.out.println("Received id parameter: " + Pid);

        if (Pid != null && !Pid.isEmpty()) {
            try {
                ids = Integer.parseInt(Pid);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Pid format: " + Pid);
            }
        } else {
            System.out.println("Pid parameter is missing or empty");
        }

        String oldP = req.getParameter("old");
        String NewP = req.getParameter("new");

        System.out.println("Old Password: " + oldP);
        System.out.println("New Password: " + NewP);

        employee emp = new employee();
        employeedaomanage edao = new employeedaomanage();

        boolean changed = edao.ChangePassword(ids, oldP, emp, NewP);

        System.out.println("Password change result: " + changed);

        if (changed) {
            req.setAttribute("message", "Password Changed");
        } else {
            req.setAttribute("message", "Password Not Changed");
        }

        RequestDispatcher rd = req.getRequestDispatcher("UpdatePassword.jsp");
        rd.forward(req, resp);
    }
}
