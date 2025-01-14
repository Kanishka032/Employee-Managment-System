package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.*;
import model.entity.*;

public class employeedaomanage {
	FileInputStream fis;
	Properties property=new Properties();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;

	{
		try {
			fis= new FileInputStream("D:\\advance java\\jdbc\\ems\\src\\main\\resources\\Data.properties");
		property.load(fis);
		
		 Class.forName(property.getProperty("driver"));
		    
		con=DriverManager.getConnection(property.getProperty("url"), property);
//		System.out.println("Connection Done..");
		
		stm=con.createStatement();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean validateemployee(employee emp) {
	    String query = "SELECT password, role FROM employee WHERE id = ?";

	    try {
	        ps = con.prepareStatement(query);
	        ps.setInt(1, emp.getId());

	        rs = ps.executeQuery();
	        System.out.println("Employee ID: " + emp.getId());
	        System.out.println("Employee Password: " + emp.getPassword());

	        if (rs.next()) {
	            if (emp.getPassword().equals(rs.getString("password"))) {
	                System.out.println("Password match successful.");
	                return true;
	            } else {
	                System.out.println("Password does not match.");
	            }
	        } else {
	            System.out.println("No employee found with the given ID.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	
	public employee GetEmployeeById(int id, employee emp) {
	    try {
	        String query = "SELECT * FROM employee WHERE id = ?";
	        ps = con.prepareStatement(query);
	        ps.setInt(1, id);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            // Populate the employee object with data from the database
	            emp.setId(rs.getInt("id"));
	            emp.setName(rs.getString("name"));
	            emp.setSalary(rs.getDouble("salary"));
	            emp.setPhone(rs.getLong("phone"));
	            emp.setPassword(rs.getString("password")); // Set the password
	            emp.setRole(rs.getString("role"));

	            // Check if the password matches (if required)
	            if (emp.getPassword() != null && emp.getPassword().equals(rs.getString("password"))) {
	                System.out.println("Password match successful for Employee ID: " + emp.getId());
	            } else {
	                System.out.println("Password does not match for Employee ID: " + emp.getId());
	            }
	        } else {
	            System.out.println("No employee found with the given ID: " + id);
	            emp = null; // Set emp to null if no employee is found
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return emp;
	}

public boolean UpdateById(employee emp)
{
	String query="update employee set name=?,salary=?,phone=?,password=?,role= ? where id= ?";
	
	try {
	
		ps=con.prepareStatement(query);
		ps.setString(1, emp.getName());
		System.out.println("Current name of id : "+emp.getId() +" is : "+ emp.getName() );
	    ps.setDouble(2, emp.getSalary());
	    System.out.println("Current Salary of id : "+ emp.getId() +" is : "+ emp.getSalary() );
	    ps.setLong(3, emp.getPhone());
	    System.out.println("Current phone number of id : "+emp.getId() +" is : "+ emp.getPhone() );
	    ps.setString(4, emp.getPassword());
	    System.out.println("Current password of id : "+emp.getId() +" is : "+ emp.getPassword() );
	    ps.setString(5, emp.getRole());
	    System.out.println("Current role of id : "+emp.getId() +" is : "+ emp.getRole() );
	    ps.setInt(6, emp.getId()); 

	    
	    ps.executeUpdate();
//	    System.out.println(  ps.executeUpdate());
	    if(ps.executeUpdate()>0)
	    {
	    	
	    	return true;
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
	
	
	return false;
	
}
	

public boolean ChangePassword(int id, String password, employee emp, String new_password) {
    String query = "SELECT * FROM employee WHERE id = ?";
    String query1 = "UPDATE employee SET password=? WHERE id=?";
    
    try {
        ps = con.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            String currentPassword = rs.getString("password");
            System.out.println("Current password from DB: " + currentPassword);

            if (currentPassword != null && currentPassword.equals(password)) {
                System.out.println("Old password matched, proceeding to update.");
                ps = con.prepareStatement(query1);
                ps.setString(1, new_password);
                ps.setInt(2, id);
                int rowsUpdated = ps.executeUpdate();
                
                if (rowsUpdated > 0) {
                    System.out.println("Password Updated Successfully...");
                    return true;
                } else {
                    System.out.println("No rows updated, check if password field was actually changed.");
                    return false;
                }
            } else {
                System.out.println("Wrong old password");
                return false;
            }
        } else {
            System.out.println("Employee not found with ID: " + id);
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}










	
}