/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/GuessNumber"})
public class GuessNumber extends HttpServlet {
    private int randNum=ranndomInteger(1,10);
    
    private int ranndomInteger(int min,int max){
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       
         PrintWriter out = response.getWriter();
         String input=request.getParameter("inputNumber");
        
         out.println("<html>");
         out.println("<body>");
         if(input!=null){
             try{
                 int userNum = Integer.parseInt(input);
                 if(userNum==randNum){
                    out.println("Correct Congratulation");
                    out.println("</body>");
                    out.println("</html>");
                    out.close();
                    return;
                }else if(userNum<randNum){
                    out.println("Too low Try Again");
                }else{
                    out.println("Too High Try Again");
                }
             }catch(NumberFormatException e){
                    out.println("Please Enter Number between 1 to 10");
             }
        }
          out.println("<form method=GET action=GuessNumber>");
          out.println("Guess a Number =<input type=text name=inputNumber> <br>");
          out.println("<input type=submit value='submit'>");
          out.println("</form>");
          out.println("</body>");
          out.println("</html>");
          out.close();
        }
  }
