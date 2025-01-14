package model.dao;
import java.io.*;
import model.entity.*;
import java.sql.*;
import java.util.*;

public class employeeDao {
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
		System.out.println("Connection Done..");
		
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
	
	public boolean validateAdmin(employee emp)
	{
		String query="select password,role from employee where id =? ";
		
		try{
		 ps= con.prepareStatement(query);
		 ps.setInt(1,emp.getId());
		 rs=ps.executeQuery();
		 
		 if(rs.next()) {
			 if(emp.getPassword().equals(rs.getString("password"))&& rs.getString("role").equalsIgnoreCase("admin")){
				return true;
			 }
		 }
			
		}
		catch(SQLException e)
		
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean Addemploye(employee emp)
	
	{	
		String query="Insert into employee(name,salary,phone,password,role) values (?,?,?,?,?)";
		
		
		
			
			
			try {
			    ps = con.prepareStatement(query);

			    ps.setString(1, emp.getName());
			    ps.setDouble(2, emp.getSalary());
			    ps.setLong(3, emp.getPhone());
			    ps.setString(4, emp.getPassword());
			    ps.setString(5, emp.getRole());

			    int result = ps.executeUpdate();
			    System.out.println(result + " rows affected.");
			    return true;

			} catch (SQLException e) {
			    
			    e.printStackTrace();
			}

		
		return false;
	}
	
	public employee GetEmployeeById(int id) {
	    try {
	        String query = "SELECT * FROM employee WHERE id = ?";
	        ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new employee(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getDouble("salary"),
	                rs.getLong("phone"),
	                rs.getString("password"),
	                rs.getString("role")
	            );
	        } else {
	            System.out.println("No employee found with ID: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public List<employee> GetAllEmployee()
	{
		
		List<employee> data=new ArrayList<employee>();
		
		String query="select * from employee";
		try {
			rs=stm.executeQuery(query);
			
			if(rs.next())
			{
				do {
			
					data.add(new employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getLong("Phone"), rs.getString("password"), rs.getString("role")));
			
				}
				while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	

		
		

public boolean GetDeleteById(int id) {
	String query="delete from employee where id=?";
	try {
		ps=con.prepareStatement(query);
		ps.setInt(1, id);
		
		if(ps.executeUpdate()>0)
		{
			System.out.println("Deleted Sucessfuly..");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return false;
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
public static void main(String args[])
{
	employeeDao e=new employeeDao();
}
}
