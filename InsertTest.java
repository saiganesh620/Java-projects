import java.sql.*;
import java.util.Scanner;

public class  InsertTest
{
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement st = null;
		try
		{			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter student number");
			int sno = s.nextInt();
			System.out.println("Enter student name");
			String sname = s.next();
			System.out.println("Enter course duration");
			String duration = s.next();
			System.out.println("Enter course name");
			String scourse = s.next();
			// Database code...
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class is loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			System.out.println("Connection is established");
			//String query="insert into java930batch1 values("+sno+",'"+sname+"','"+duration+"','"+scourse+"');";
			st=con.createStatement();
			String query="insert into student(sno,sname,saddress) values(3,'Prasad','kphb')";
			String update ="update student set saddress='miyapur' where sno=2";
			System.out.println(query);
			int result = st.executeUpdate(query);
			if(result == 0)
				System.out.println("record not inserted");
			else
				System.out.println("record Inserted");
		}//try
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(NullPointerException ne)
		{
			ne.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}//finally		
	}//main
}//class