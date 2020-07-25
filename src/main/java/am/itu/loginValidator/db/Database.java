package am.itu.loginValidator.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	Map<String, String> hm = new HashMap<String, String>();
	{
		hm.put("user1@gmail.com", "Password1!");
		hm.put("user2@gmail.com", "Password2!");
		hm.put("user3@gmail.com", "Password3!");
		hm.put("user4@gmail.com", "Password4!");
		hm.put("user5@gmail.com", "Password5!");

	}

	public boolean checkEmailInDatabase(String email) {
		boolean isavailable = hm.containsKey(email);
		if (isavailable) {
			System.out.println();
			return true;
		} else {
			System.out.println("your email is not registered ");
			return false;
		}
	}

//	public boolean checkValidLogin(String email, String password) {
//		boolean isavailable = hm.containsValue(password);
//		if (!isavailable) {
//			System.out.println("Your email or password is invalid ");
//			return false;
//		} else {
//			Start start = new Start();
//			if (password.equals(hm.get(email))) {
//				System.out.println("you have  successfully log in ");
//				return true;
//			}
//			System.out.println("Your email or password is invalid ");
//			return false;
//		}
//	}

	public Connection connectDB() {

		String url = "jdbc:postgresql://localhost:5432/myProjectDB";
		String user = "postgres";
		String password = "inchinch1992";
		Connection con = null;

		try {

			con = DriverManager.getConnection(url, user, password);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT VERSION()");

			return con;

		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return con;
	}

	public boolean isLoginValid(String username, String password) {
		boolean emailExists = false;
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean userExists = false;
		try {
			Class.forName("org.postgresql.Driver");
			connection = connectDB();

			String query = "select count(*) from users where email = '" + username + "' and password = '" + password
					+ "' ;";
			st = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery();
			rs.last();
			int size = rs.getInt("count");
			if (size == 1) {
				userExists = true;
				rs.close();
				st.close();

				return userExists;
			}
		}

		catch (NullPointerException e) {
			System.out.println("Result set was not created");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: " + cE.toString());
		} finally {

			try {
				rs.close();
				st.close();

			} catch (NullPointerException e) {
				System.out.println("Result set was not created");
			} catch (SQLException e) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			}

		}

		return userExists;
	}
}