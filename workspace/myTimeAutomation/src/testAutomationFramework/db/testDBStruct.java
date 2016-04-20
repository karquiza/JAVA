package testAutomationFramework.db;

public class testDBStruct {
	private String user_id;
	private String password;
	private String firstname;
	private String lastname;
	
	public void setUser(String uid) {
		user_id = uid;
	}
	
	public String getUser() {
		return user_id;
	}
	
	public void setPassword(String pword) {
		password = pword;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setFirstName(String fname) {
		firstname = fname;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public void setLastName(String lname) {
		lastname = lname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
}
