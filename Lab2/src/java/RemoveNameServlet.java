/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import names.Person;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/RemoveNameServlet"})
public class RemoveNameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            
            HashMap<String,Person> listPerson=(HashMap<String,Person>) session.getAttribute("names");
            String key=request.getParameter("key2");
            if(listPerson.containsKey(key)){
                listPerson.remove(key);
            }
            session.setAttribute("names", listPerson);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AllNameServlet</title>");            
           out.println("<style type=\"text/css\">");
            out.println(".nameForm{");
            out.println("display:inline");
            out.println("}");
            out.println("</style>");

            out.println("</head>");
      
            out.println("<body>");
           out.println("List of Names <br>");
            for (Map.Entry<String, Person> entry : listPerson.entrySet())
            {
                out.println(entry.getValue()+"<br>");
            }

            out.println("<form method=GET action=AllNameServlet>");
            out.println("<input type=submit value='Show all Names'><br>");
            out.println("</form>");
            out.println("<form method=GET class=nameForm action=AddNameServlet>");
            out.println("Key= <input type=text name=key>");
            out.println("First Name=<input type=text name=fName>");
            out.println("Last Name=<input type=text name=lName>");
            out.println("<input type=submit value='Add'>");
            out.println("</form>");
            
            out.println("<form method=GET action=RemoveNameServlet>");
            out.println("Key= <input type=text name=key2>");
            out.println("<input type=submit value='Remove'>");
            out.println("</form>");
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
