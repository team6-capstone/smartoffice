
public class UserDTO {
	private String id, department, rank, name, phone, email, pw;
	private int statement;
	
	// getter
	public String getId() { return id; }
	public String getDepartment() { return department; }
	public String getRank() { return rank; }
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public String getPw() { return pw; }
	public int getStatement() { return statement; }
	
	// setter
	public void setLoginInfo(String id, String pw) { 
		this.id = id;
		this.pw = pw;
	}
}
