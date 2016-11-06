/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {

    private  boolean checkLoginCredentials(String userName,String password){

      if (userName.equals("user")&&password.equals("pass"))
          return  true;

    return  false;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);]
       String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        if (!(userName == null && password == null)) {
            if (checkLoginCredentials(userName, password)) {
                out.println("Welcome User\n");
                out.println("</body>");
                out.println("</html>");
                out.close();
                return;
            } else {
                out.println("Wrong userName or password! Please try again\n");
            }

        }
        out.println("<html>");
        out.println("<body>");
        out.println("<form method=GET action=LogonServlet>");
        out.println("Username=<input type=text name=userName> <br>");
        out.println("Password=<input type=text name=password>");
        out.println("<input type=submit value='Logon'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }


}
