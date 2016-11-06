/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(urlPatterns = {"/AddNameServlet"})
public class AddNameServlet extends HttpServlet {
    HashMap<String,Person> listPerson;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        listPerson=(HashMap<String, Person>) session.getAttribute("names");
        if(listPerson==null)
            listPerson=new HashMap<>();
        
        System.out.println("name add list is = "+listPerson.size());

         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddNameServlet</title>");    
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String key = request.getParameter("key");
        if(fName!=null&&lName!=null&&key!=null){
            Person p=new Person(Integer.parseInt(key), fName, lName);
            if(listPerson.containsKey(key)){
              out.println("Duplicate key. Please Try other key....");

            }else{
                
                listPerson.put(key, p);
                        session.setAttribute("names", listPerson);

            out.println("List of Names <br>");
            for (Map.Entry<String, Person> entry : listPerson.entrySet())
            {
                out.println(entry.getValue()+"<br>");
            }

            }
            
        }
       
            out.println("<style type=\"text/css\">");
            out.println(".nameForm{");
            out.println("display:inline");
            out.println("}");
            out.println("</style>");

            out.println("</head>");
      
            out.println("<body>");
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

}
