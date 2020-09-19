import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SqlCode {
	Connection conn;
	String[] itemname=null;
	String[] drinkname=null;
	int[] price=null;
	int[] priceofdrinks=null;
	int i=0;
	int j=0;
	int count=0;
	public void connections() {
		try {
			String url="jdbc:mysql://localhost:3366/restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username1="root";
			String password1="";
			conn= (Connection) DriverManager.getConnection(url,username1,password1);
		}catch(SQLException s) {
			
		}
	}
	
	public String[] fooditems() {
		Statement stmt1=null;
		Statement stmt=null;
		connections();
		try {
			String sql1="Select count(*) from fooditems";
			stmt1=(Statement) conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(sql1);
			while(rs1.next()) {
				count=rs1.getInt(1);
				
			}
			itemname=new String[count];
			String sql="Select foodname from fooditems";
			stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				itemname[i]=rs.getString(1);
				i++;
			}
		}catch(SQLException sr) {
			
		}
		try {
			stmt1.close();
			stmt.close();
			conn.close();
			}catch(SQLException sql) {
				
			}
		return itemname;
	}
	public int[] pricename() {
		Statement stmt1=null;
		Statement stmt=null;
		connections();
		int l=0;
		try {
			String sql1="Select count(*) from fooditems";
			stmt1=(Statement) conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(sql1);
			while(rs1.next()) {
				count=rs1.getInt(1);
				
			}
			price=new int[count];
			String sql="Select price from fooditems";
			stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				price[l]=(int)rs.getInt(1);
				
				l++;
			}
		}catch(SQLException sr) {
			
		}
		try {
		stmt1.close();
		stmt.close();
		conn.close();
		}catch(SQLException sql) {
			
		}
		return price;
	}
	

	public static void main(String[] args) {
		Login_Window win=new Login_Window();
		win.windowlayout();
		

	}
	public Boolean registeraccount(String username,String password) {
		connections();
		Boolean insert=false;
		try {
			String sql="Insert into users(username,passwords) values(?,?)";
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.executeUpdate();
			insert=true;
			stmt.close();
			conn.close();
		}catch(SQLException sql) {
			
		}
		return insert;
	}
	
	public Boolean userlogin(String usernames,String password) {
		connections();
		Boolean register=false;
		String passwordofsql="";
		try {
			String sql="Select  passwords from users where username='"+usernames+"'";
			Statement stmt=(Statement) conn.createStatement();
			ResultSet results=stmt.executeQuery(sql);
			while(results.next()) {
				passwordofsql=results.getString(1);
			}
			if(password.equals(passwordofsql)) {
				register=true;
			}
			
		}catch(SQLException sqls) {
			
		}
		return register;
	}
	
	public int[] priceofdrinks() {
		Statement stmt1=null;
		Statement stmt=null;
		connections();
		try {
			String sql1="Select count(*) from drinkitems";
			stmt1=(Statement) conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(sql1);
			while(rs1.next()) {
				count=rs1.getInt(1);
				
			}
			priceofdrinks=new int[count];
			String sql="Select prices from drinkitems";
			stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				priceofdrinks[j]=(int)rs.getInt(1);
				
				j++;
			}
		}catch(SQLException sr) {
			
		}
		try {
		stmt1.close();
		stmt.close();
		conn.close();
		}catch(SQLException sql) {
			
		}
		return priceofdrinks;
	}
	
	public String[] drinkitems() {
		Statement stmt1=null;
		Statement stmt=null;
		int m=0;
		connections();
		try {
			String sql1="Select count(*) from drinkitems";
			stmt1=(Statement) conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(sql1);
			while(rs1.next()) {
				count=rs1.getInt(1);
				
			}
			drinkname=new String[count];
			String sql="Select drinkname from drinkitems";
			stmt=(Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				drinkname[m]=rs.getString(1);
				m++;
			}
		}catch(SQLException sr) {
			
		}
		try {
			stmt1.close();
			stmt.close();
			conn.close();
			}catch(SQLException sql) {
				
			}
		return drinkname;
	}
	
	public int getCount() 
	{
		return count;
	}

}
