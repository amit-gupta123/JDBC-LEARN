import com.amit.jdbc_practice.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJDBC {

    public static void main(String[] args) {
        try{
            Connection conn = ConnectionProvider.getConnection();
            if(conn==null){
                System.out.println("Connection to database failed");
            }
            else{
                System.out.println("Connection to database is established");
            }

            String q = "select * from table1";
            Statement stmt = conn.createStatement();
            ResultSet set =  stmt.executeQuery(q);

            while(set.next()){
                System.out.println(
                        "Id: "+set.getInt(1)+" "+
                        "Name: "+set.getString(2)+" "+
                        "City: "+set.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
