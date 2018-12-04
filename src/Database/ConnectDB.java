package Database;
import java.sql.*;
import java.util.ArrayList;

import Model.User;

public class ConnectDB {

//	private DataSource datasource;
	Connection conn = null;
	
	public ConnectDB() {
		createConnection();
	}
	
	private static Connection createConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:AcademyDB.db");

			System.out.println("DATABASE NAME IS:" + conn.getMetaData().getDatabaseProductVersion());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// connection is closed here.
	public void killConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection not created!");
		}
	}

	// Get Users.
	public ArrayList<User> userCollection() throws SQLException {

		ArrayList<User> UsersCollection = new ArrayList<User>();
		Statement state = createConnection().createStatement();
		String query = "select * from Users";
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			User user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("role"), rs.getString("password"));

			UsersCollection.add(user);
		}

		rs.close();
		state.close();
		return UsersCollection;
	}
	
	//User login.
	public User userLogin(String username,String password) throws SQLException {
		System.out.println("Login");
		User user =null;
		Statement state = createConnection().createStatement();
		String query = "select * from Users  where   userName = '"+username+"' and password = '"+password+"';";
		      
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("role"), rs.getString("password"));
		}

		rs.close();
		state.close();
		
		if(user == null) {
			 user = new User(0,"login Failed", "","","", "");
		}
		return user;
	}
	
	// Get User login.
	public User getstudent(String username) throws SQLException {

		User user =null;
		Statement state = createConnection().createStatement();
		String query = "select * from Users  where   userName = '"+username+"';";
		      
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			System.out.println(rs.getString("password"));
			 user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("role"), rs.getString("password"));
		}

		rs.close();
		state.close();
		
		if(user == null) {
			 user = new User(0,"login Failed", "","","", "");
		}
		return user;
	}
	// User register.
	public String Register(User user) throws SQLException {

		System.out.println("Register");
		Statement state = createConnection().createStatement();
		String query = "INSERT INTO Users (userName,firstName,lastName,studentID,password,role) "
			       	+ "VALUES ('"+user.getUserName()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"',"+
			       		user.getUserID()+", '"+user.getPassword()+"', '"+user.getRole()+"' );";

		ResultSet rs = state.executeQuery(query);		

		state.executeQuery(query);
		rs.close();
		state.close();
		
		return "Registered";
	}
}