import java.sql.*;

public class SQLiteUpdate {
    
    public static void showAll(Result rs) {
         while (rs.next()) {
                int id = rs.getInt("_id");
                String  name = rs.getString("name");
                String  description = rs.getString("description");
                float price = rs.getFloat("price");
                System.out.println("_id = " + id); 
                System.out.println("name = " + name);
                System.out.println("description = " + description);
                System.out.println("price = " + price);   
                System.out.println("************************************************");
            }
        }
        
    
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:shop.sqlite");
            // c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Products;" );
            System.out.println("try UPDATE");
            showAll(rs);
            rs = stmt.executeQuery( "UPDATE Products SET name = \"briciole\" WHERE _id = 1" );
            System.out.println("try UPDATE");
            showAll(rs);
            rs = stmt.executeQuery( "DELETE FROM Products WHERE _id = 1" );
            System.out.println("try DELETE");
            showAll(rs);
            
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
       }
       System.out.println("Operation done successfully");
    }
}
