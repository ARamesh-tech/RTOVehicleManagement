package com.rto.vehicleregistration;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleRegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Success Vehicle Registraion</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                    + "        <link rel=\"icon\" href=\"images/rto1.png\" type=\"image/icon\">");
            out.println("</head>");
            out.println("<body>");
            String owner = request.getParameter("ownername");
            String vehicleregno = request.getParameter("vehicleregno");
            String vehicledetails = request.getParameter("vehicleDetails");
            VehicleRegistration v1 = new VehicleRegistration(owner, vehicleregno, vehicledetails);
            try {
                int result = v1.registerVehicle();
                request.setAttribute("vehicleregresult", result);
                if (result == 1) {
//                    VehiclePermit vp=new VehiclePermit();
//                    vp.permit();
                    out.println("<script>");
                    out.println("alert('Vehicle Registered & Permitted Successfully');");
                    out.println("window.location.href = 'vehiclereg.jsp';"); // Redirect after alert
                    out.println("</script>");
                }
            } catch (Exception ex) {
                Logger.getLogger(VehicleRegServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<h1>Servlet VehicleRegServlet at " + request.getContextPath() + "</h1>");
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
