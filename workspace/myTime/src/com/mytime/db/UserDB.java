package com.mytime.db;

import java.sql.*;

public class UserDB {
	private java.sql.Connection con;
	
	public UserDB() {
       // TODO : constructor
    }
	
	public boolean openDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jlogindb", "root","");		
			if(con != null) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}		
	}

	public void closeDB() {
		try{
			if(con != null) {
				con.close();
			} 
		} catch ( SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());				
		}
	}
	
	
	public String getUserName(String uname, String pword) {
		String retUser = "";
		String first = "";
		String last = "";
		
		try {			
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from jlogin_users where username='"+uname+"'");
			if(rs.next())
			{
				if(rs.getString("password").equals(pword))
				{
					System.out.println("found: " + uname);
					first = rs.getString("firstname");
					last = rs.getString("lastname");
					if(first != "" && last != "") {
						retUser = first + " " + last;
					} 	
					System.out.println("welcome "+ retUser);
				}
				else
				{
					System.out.println("Invalid password try again");
				}
			} 
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retUser;
	}

}
