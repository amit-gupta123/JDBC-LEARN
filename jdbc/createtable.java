import java.sql.*;
class CreateTABLE {
    public static void main(String[] args) {
    // load the driver
        try{
           // load the driver
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            String user = "root";
            String password = "system123";
            String url = "jdbc:mysql://localhost:3306/test";
            conn = DriverManager.getConnection(url, user,password);
            if(conn.isClosed()){
                System.out.println("Connection not established");
            }else {
                System.out.println("connection established successfully");
            }

            // creating the query to create table in database;

            String q = "create table table1(id int(10) primary key auto_increment, name varchar(50) not null, city varchar(20))";
            //  it will return our an statement object
            
            Statement stmt = null; 
            stmt = conn.createStatement();
            // now fire query
            // since we are creating the table but not getting or querying any data ,so we write 
            stmt.executeUpdate(q);

            System.out.println("table created in the database");
            // we are sure because if not so then the execution would have been terminated from above statement

            // closing the connection.
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }    
}
