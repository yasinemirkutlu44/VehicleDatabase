package project;

import java.util.*;
import java.sql.*;

public class Program {

    static LinkedList<Vehicle> vehicles = new LinkedList<>();

    public static Vehicle getVehicleFromDB(String query)
    {
        try
        {
            String[] dbReturn = new String[9];
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                for (int i = 1; i <= 8; i++) {
                    System.out.print(String.format("%-9s",rs.getString(i)));
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    
    public static void main(String[] args) {
        //ALL TEST WILL UPDATE
        System.out.println("id       brand    speed    capacity wheel    price    date     colour");
        getVehicleFromDB("select * from automobile");
    }
    
}
