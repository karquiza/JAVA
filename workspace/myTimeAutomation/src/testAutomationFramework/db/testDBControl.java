package testAutomationFramework.db;

import java.sql.*;
import java.util.*;

public class testDBControl {
	private java.sql.Connection con;
	private static ArrayList<testDBStruct> dbArray = new ArrayList<testDBStruct>();
	
	public testDBControl() {
		// constructor
		if(this.openDB() == true) {
			this.initTestDB();
			this.closeDB();
		}
	}
	
	private boolean openDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jlogindb", "root","");		
			if(con != null) {
				return true;
			} else {
				System.out.println("cannot connect to DB");
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("class not found or exception cannot connect to DB");
			return false;
		}		
	}
	
	private void closeDB() {
		try{
			if(con != null) {
				con.close();
			} 
		} catch ( SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());				
		}
	}
	
	private void initTestDB() {
		try {
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from jlogin_users");
			
			while(rs.next()) {
				testDBStruct entry = new testDBStruct();
				entry.setUser(rs.getString(1));
				entry.setPassword(rs.getString(2));
				entry.setFirstName(rs.getString(3));
				entry.setLastName(rs.getString(4));
				
				dbArray.add(entry);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getUserIdAtIndex(int index) {
		String uid = "";
		
		
		if(dbArray.isEmpty()){
			System.out.println("[ERROR] Empty DB!");
			return uid;
		}
		if(index< 0 || index >= dbArray.size()){
			System.out.println("[ERROR] invalid index");
			return uid;
		}		
		uid = dbArray.get(index).getUser();
		
		return uid;
	}
	
	public String getPasswordAtIndex(int index) {
		String pwd = "";		
		
		if(dbArray.isEmpty()){
			System.out.println("[ERROR] Empty DB!");
			return pwd;
		}
		if(index< 0 || index >= dbArray.size()){
			System.out.println("[ERROR] invalid index");
			return pwd;
		}		
		pwd = dbArray.get(index).getPassword();
		
		return pwd;
	}
	
	public String getFullNameAtIndex(int index) {
		String fullname = "";		
		
		if(dbArray.isEmpty()){
			System.out.println("[ERROR] Empty DB!");
			return fullname;
		}
		if(index< 0 || index >= dbArray.size()){
			System.out.println("[ERROR] invalid index");
			return fullname;
		}		
		fullname = dbArray.get(index).getFirstName() + " " + dbArray.get(index).getLastName();
		
		return fullname;
	}
	
	
	/* FOR DEBUG ONLY
	public static void main(String[] args) {		
		testDBControl testDB = new testDBControl();

		for(testDBStruct entry: dbArray)
		{
			System.out.println(entry.getUser() + "\t" + entry.getPassword() + "\t" + entry.getFirstName() + "\t" + entry.getLastName());
		}
	
	}
	*/
}
