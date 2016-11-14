<%-- 
    Document   : guessNumber
    Created on : Nov 6, 2016, 10:49:03 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess Number</title>
    </head>
    <body>
        
        <% int randNum,input;%>
        <% randNum=(int) (Math.random() * 10); %>
        <%  if(session.getAttribute("num")==null)
            session.setAttribute("num",randNum);  %>
        <% String userInput=(String)request.getParameter("input"); 
            if(userInput!=null){
               int str=(Integer) session.getAttribute("num");
                int actualGuess=Integer.valueOf(str);
                input=Integer.valueOf(userInput);
                if(actualGuess==input)
                 out.println("<p>Correct Congratulation</p>");
                else {
                    if(actualGuess>input)  
                     out.println("Too low Try Again");
                    else{
                        out.println("Too High Try Again");
                    }%>
                    <form action="guessNumber.jsp">  
        <input type="text" name="input"><br/>  
        <input type="submit" value="Submit">  
        </form>  <%
                    
                }
            }else{%>
                    <form action="guessNumber.jsp">  
        <input type="text" name="input"><br/>  
        <input type="submit" value="Submit">  
        </form>  <%
            }
        %>
        

    </body>
</html>
