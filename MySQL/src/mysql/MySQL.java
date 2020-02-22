package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {

    public static void main(String[] args) {
        
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");)
        {
            System.out.println(conn.isClosed());
            updateUser(conn, "newMail", "newPassword", 1);
            readUsers(conn);
            
            
        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }
        public static void insertUser(Connection conn, String email, String password) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("insert into users(email, password) values (?,?)");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, email);
        preparedStatement.execute();
    }
    public static void updateUser(Connection conn, String email, String password, int id) throws SQLException
    {
        PreparedStatement preparedStatement = conn.prepareStatement("update users set password=?, email=? where user id=?");
        
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, email);
        preparedStatement.setInt(3, id);
        preparedStatement.execute();
    }
    public static void readUsers(Connection conn) throws SQLException
    {
        Statement st = conn.createStatement();
        st.executeQuery("select = from users");
        
        ResultSet rs = st.getResultSet();
        while(rs.next())
        {
            System.out.println("User: " + "Email: " + rs.getString("email") + "Password: " + rs.getString("password"));
        }
    }
    public static void deleteUser(Connection conn, int id) throws SQLException
    {
        CallableStatement cstmt = conn.prepareCall("{call DeleteUserByID(?)}");
        
        cstmt.setInt(1, id);
        cstmt.execute();
        
        
    }
    
}
   

