import java.sql.*;
class InsertInTable {
    public static void main(String[] args) {

        // use PreparedStatement interface for dynamic query

        //1.  load the driver
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

            PreparedStatement pStatement = conn.prepareStatement(q);
            pStatement.setString(1,"Amit Gupta");
            pStatement.setString(2,"Deoria");

            pStatement.executeUpdate();
            System.out.println("value inserted");
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
