import com.amit.jdbc_practice.ConnectionProvider;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {

        System.out.println("testing");
        try{
            Connection conn = ConnectionProvider.getConnection();
            if(conn == null){
                System.out.println("Connection to database failed");
            }else{
                System.out.println("Connection Established to database");
            }

            String q = "insert into images(pic) values(?)";
            PreparedStatement pstmt = conn.prepareStatement(q);

            // lets use a swing component to choose file from dir dynamcallly
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showOpenDialog(null);// null indicates that dialog will show up in center
            File file = jFileChooser.getSelectedFile();

            // now to save in dtaabse;
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1,fis,fis.available());

            pstmt.executeUpdate();
            //System.out.println("image saved successfully in database");
            JOptionPane.showMessageDialog(null,"sucessfuly uploaded");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}