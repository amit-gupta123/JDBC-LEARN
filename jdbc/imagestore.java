import java.io.FileInputStream;
import java.sql.*;
class StoreImage {
    public static void main(String[] args) {
        // LOAD THE DRIVER
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "system123";
            
            conn = DriverManager.getConnection(url,username,password);
            
            if(conn.isClosed()){
                System.out.println("Connection failed");
            }else{
                System.out.println("Connection established");
            }

            String q = "insert into images(pic) values(?)";
            PreparedStatement pStatement = conn.prepareStatement(q);

            FileInputStream fs= new FileInputStream("myphoto.png");
            pStatement.setBinaryStream( 1,fs, fs.available());
            pStatement.executeUpdate();
            System.out.println("Uploaded");



        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
