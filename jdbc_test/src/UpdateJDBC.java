import com.amit.jdbc_practice.ConnectionProvider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;

public class UpdateJDBC {
    public static void main(String[] args) {
        try{
            Connection conn = ConnectionProvider.getConnection();
            if(conn == null){
                System.out.println("Connection to database failed");
            }else{
                System.out.println("Connection Established to database");
            }

            String q = "update table1 set name=? where id =?";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter new name: ");
            String name = bufferedReader.readLine();

            System.out.println("Enter id of the user: ");
            //String id = bufferedReader.readLine(); // below line may give error that value may may not be initialized
            int id = Integer.parseInt(bufferedReader.readLine());
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(2,id);
            pstmt.setString(1,name);
            // parameterindexes are given here according to indexes in query string not acording to actual databse table

            pstmt.executeUpdate();
            System.out.println("Value updated");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
