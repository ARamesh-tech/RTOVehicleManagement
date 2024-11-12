package com.rto.vehicleregistration;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehileDetialsNVerifyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection con;
            String vehicleRegNo = request.getParameter("vehicleRegNo");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Vehicle Details</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                    + "        <link rel=\"icon\" href=\"images/rto1.png\" type=\"image/icon\">");
            out.println("</head>");
            out.println("<body>");
            
            try {
                LoginSignUp conn = new LoginSignUp("admin", "admin@gmail.com", "root");
                con = conn.getConnection();
                PreparedStatement ps=con.prepareStatement("select * from vehiclereg where vehicleregno=?");
                ps.setString(1,vehicleRegNo);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    out.println("<h3>Owner name : </h3>");
                    out.print("<h6>"+rs.getString("owner")+"</h6>");
                    out.println("<h3>Vehicle Registration number : </h3>");
                    out.print("<h6>"+rs.getString("vehicleregno")+"</h6>");
                    out.println("<h3>Vehicle Details(Brand, Year, Model, Price) : </h6>");
                    out.print("<h6>"+rs.getString("vehicledetails")+"</h6>");
                }
            } catch (Exception ex) {
                Logger.getLogger(VehileDetialsNVerifyServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
//            out.println("<form action='vehiclereg.jsp'>");
//            out.println("<input type='button' value='Goback' class='btn btn-success' onclick='func()'");
//            
//            out.println("</form>");
//            out.println("<script>function func() {window.location.href = 'http://localhost:9494/VehicleRegistration/vehiclereg.jsp?';}</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
