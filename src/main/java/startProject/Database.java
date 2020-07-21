package startProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

	public boolean checkValidLogin(String email, String password) {
		boolean isavailable = hm.containsValue(password);
		if (!isavailable) {
			System.out.println("Your email or password is invalid ");
			return false;
		} else {
			Start start = new Start();
			if (password.equals(hm.get(email))) {
				System.out.println("you have  successfully log in ");
				return true;
			}
			System.out.println("Your email or password is invalid ");
			return false;
		}
	}
	
	
	
	public void connectDB() {
		 try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "inchinch1992")) {
			 
	     	if(connection != null) {
	     		System.out.println("Connection to PostgreSQL server successfully ");
	     	}else {
	     		System.out.println("Failed to connect PostgreSQL server");
	     	}
	     }

	     catch (SQLException e) {
	         System.out.println("Connection failure.");
	         e.printStackTrace();
	     }
	 }
	
	
	 public boolean CheckUsernameExists(String username)
	 {
	     boolean emailExists = false;

	     try
	     {
	    	 Class.forName("org.postgresql.Driver");
	         Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "inchinch1992");

	         PreparedStatement st = connection.prepareStatement("select * from LoginTable order by Email desc");
	         ResultSet r1=st.executeQuery();
	         String usernameCounter;
	          if(r1.next()) 
	          {
	            usernameCounter =  r1.getString("username");
	            if(usernameCounter == username) //this part does not happen even if it should
	            {
	                System.out.println("It already exists");
	               emailExists = true;
	            }
	          }
	      }

	      catch (SQLException e) 
	      {
	         System.out.println("SQL Exception: "+ e.toString());
	      } 
	      catch (ClassNotFoundException cE) 
	      {
	         System.out.println("Class Not Found Exception: "+ cE.toString());
	      }

	  return emailExists;
	  }
}