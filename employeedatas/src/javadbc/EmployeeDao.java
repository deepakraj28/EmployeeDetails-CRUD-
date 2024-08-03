package javadbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class EmployeeDao {
	 Connection con;
	   PreparedStatement pst;
	public EmployeeDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.registerDriver(new Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails","root","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public  void create()
	{
		String str="create table Employeedet(id int,ename varchar(20),city varchar(20),dept varchar(20),designation varchar(20),doj varchar(20),dob varchar(20),salary double)";
		try {
			Statement st=con.createStatement();
			st.execute(str);
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void insert(int id, String ename, String city, String dept, String designation, String doj, String dob,double salary)//saveEmp
	{
		 String stri="insert into employeedet(id,ename,city,dept,designation,doj,dob,salary) values(?,?,?,?,?,?,?,?)";
		 
			try {
				pst = con.prepareStatement(stri);
				pst.setInt(1,id);
				pst.setString(2, ename);
				pst.setString(3, city);
				pst.setString(4, dept);
				pst.setString(5, designation);
				pst.setString(6, doj);
				pst.setString(7, dob);
				pst.setDouble(8, salary);
				 pst.executeBatch();//return type in array
				   int r= pst.executeUpdate();
				
				    System.out.println("no of statement executed: "+r);
				   		    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   
	}
	public void select(int i)//getEMP(id)
	{
		String str="select * from employeedet where id="+i;
		 try {
			pst = con.prepareStatement(str);
			ResultSet rs=pst.executeQuery(str);
			System.out.println("id   ename  city   dept   designation    doj   dob   salary");
            rs.next();
			System.out.println(rs.getInt("id")+" "+rs.getString("ename")+" "+rs.getString("city")+" "+rs.getString("dept")+" "+rs.getString("designation")+" "+rs.getString("doj")+" "+rs.getString("dob")+" "+rs.getDouble("salary"));
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void selectAll()//getEMP
	{
		String str="select * from employeedet";
		 try {
			pst = con.prepareStatement(str);
			ResultSet rs=pst.executeQuery(str);
			System.out.println("id   ename  city   dept    designation     doj    dob    salary");
            while(rs.next())
            {
			System.out.println(rs.getInt("id")+" "+rs.getString("ename")+" "+rs.getString("city")+" "+rs.getString("dept")+" "+rs.getString("designation")+" "+rs.getString("doj")+" "+rs.getString("dob")+" "+rs.getDouble("salary"));
            }
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void delete(int i) 
		{
			String str="delete from employeedet where id="+i;
			try {
				pst=con.prepareStatement(str);
				pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		public void update(int i,double salary)
		{
			String str="update employeedet set salary ="+salary+" where id="+i;
			try {
				pst=con.prepareStatement(str);
				pst.executeUpdate();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

}
