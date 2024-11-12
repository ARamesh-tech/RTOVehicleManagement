package com.rto.vehicleregistration;

import java.sql.*;

public class VehiclePermit {
    String vehicleregno;
    int rf;
    Connection con;
    public void permit() throws ClassNotFoundException, SQLException{
        LoginSignUp conn = new LoginSignUp("admin", "admin@gmail.com", "root");
        con = conn.getConnection();
        PreparedStatement ps=con.prepareStatement("select vehicleregno from vehiclereg where permitted is null");
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            vehicleregno=rs.getString("vehicleregno");
            PreparedStatement ps2=con.prepareStatement("update vehiclereg set permitted=1 where vehicleregno=?");
            ps2.setString(1,vehicleregno);
            rf=ps2.executeUpdate();
            if(rf>0){
                System.out.println("Successfully Vehicle Permitted!");
            }
        }
    }
}
