import java.sql.*;
class FirstJDBC{
	public static void main(String[] args) {
		try{
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create or establishing a connection 
			// use DriverManager to get connection with getConnection() method.

			Connection conn = null;
			String userName = "root";
			String password = "system123";
			String url = "jdbc:mysql://localhost:3306/test";
			// DriverManager.getConnection(url,userName,password);
			conn = DriverManager.getConnection(url,userName,password);
			if(conn.isClosed()){
					System.out.println("Connection establishment failed");
			}
			else{
				System.out.println("Connection is established");
			}
			conn.close();
		} catch(Exception e){
			e.printStackTrace();  
		}
	}
}