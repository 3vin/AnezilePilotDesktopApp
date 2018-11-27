package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import javax.sql.DataSource;
import Model.User;

public class ConnectDB {

//	private DataSource datasource;
	private Connection conn;

	/**
	 * {@CreditToolDatabase} Connection to the Credit Monitoring Database is created
	 */
	public ConnectDB() {
		createConnection();
	}

	/**
	 * @return the created connection
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * @return the created JNDIconnection
	 * 
	 *         /**
	 * @exception Class
	 *                not Found Exception for the driver can be thrown here
	 * @exception SQLException
	 *                is catched here for incorrect details for the sqlserver or
	 *                details of the server
	 */
	private void createConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:AcademyDB.db");

			System.out.println("DATABASE NAME IS:" + conn.getMetaData().getDatabaseProductVersion());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@conn} connection is closed here.
	 */
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

	/**
	 * Get Users.
	 * 
	 * @throws SQLException
	 */
	public ArrayList<User> userCollection() throws SQLException {

		ArrayList<User> UsersCollection = new ArrayList<User>();
		Statement state = getConnection().createStatement();
		String query = "select * from Users";
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			System.out.println(rs.getString("password"));
			User user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("role"), rs.getInt("studentID"), rs.getString("password"));

			UsersCollection.add(user);
		}

		rs.close();
		state.close();
		return UsersCollection;
	}
	/**
	 * User login.
	 * 
	 * @throws SQLException
	 */
	public User userLogin(String username,String password) throws SQLException {

		User user =null;
		Statement state = getConnection().createStatement();
		String query = "select * from Users  where   userName = '"+username+"' and password = '"+password+"';";
		      
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			System.out.println(rs.getString("password"));
			user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("role"), rs.getInt("studentID"), rs.getString("password"));

		}

		rs.close();
		state.close();
		
		if(user == null) {
			 user = new User(0,"login Failed", "","","", 0, "");
		}
		return user;
	}
	
	/**
	 * User login.
	 * 
	 * @throws SQLException
	 */
	public User getstudent(String username) throws SQLException {

		User user =null;
		Statement state = getConnection().createStatement();
		String query = "select * from Users  where   userName = '"+username+"';";
		      
		ResultSet rs = state.executeQuery(query);
		// Create connection

		while (rs.next()) {
			System.out.println(rs.getString("password"));
			 user = new User(rs.getInt("userID"), rs.getString("userName"), rs.getString("firstName"),
					rs.getString("lastName"),rs.getString("roole"), rs.getInt("studentID"), rs.getString("password"));
		}

		rs.close();
		state.close();
		
		if(user == null) {
			 user = new User(0,"login Failed", "","","", 0, "");
		}
		return user;
	}
	/**
	 * User register.
	 * 
	 * @throws SQLException
	 */
	public String Register(String username,String password,String firstName,String lastName,String role,String Studentusername) throws SQLException {

		
		Statement state = getConnection().createStatement();
		String query = "INSERT INTO Users (userName,firstName,lastName,studentID,password,role) "
			       	+ "VALUES ('"+username+"', '"+firstName+"', '"+lastName+"',"+getstudent(Studentusername).getUserID()+", '"+password+"', '"+role+"' );";
		      
		state.executeQuery(query);
		// Create connection

		
		state.close();
		
		return "Registered";
	}

	public static void main(String[] Args) throws SQLException {
		ConnectDB SQLite = new ConnectDB();

		for (User item : SQLite.userCollection()) {
			System.out.println(item.toString());
		}

	}

}