package Model;

public class User {
       private int userID;
       private String userName;
       private String firstName;
       private String lastName;
       private String role;
       private int studentID;
       private String password;
    
    public User() {
   		
   		
   	}
	public User(int userID, String userName,String lastName ,String firstName, String role, String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.role = role;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", studentID=" + studentID + ", password=" + password + "]";
	}
	
	
	
	
       
       
}
