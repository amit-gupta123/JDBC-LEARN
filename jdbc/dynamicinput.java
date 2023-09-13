import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
class DynamicInput {
    public static void main(String[] args) {
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // making connection to database

            Connection conn = null;
            String username = "root";
            String password = "system123";
            String url = "jdbc:mysql://localhost:3306/test";

            conn = DriverManager.getConnection(url, username, password);

            if(conn.isClosed()){
                System.out.println("connection is closed");
            }
            else{
                System.out.println("connection established");
            }

            // now make query to execute

            String q = "insert into table1(name,city) values(?,?)";

            // using prepared statement interface to insert data;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter name: ");
            String name = bufferedReader.readLine();
            
            System.out.println("Enter City: ");
            String city = bufferedReader.readLine();


            PreparedStatement pStatement = conn.prepareStatement(q);
            pStatement.setString(1,name);
            pStatement.setString(2,city);

            pStatement.executeUpdate();
            System.out.println("value inserted");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
