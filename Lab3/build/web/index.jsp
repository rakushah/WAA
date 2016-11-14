<%-- 
    Document   : HelloWorld
    Created on : Nov 6, 2016, 10:36:45 AM
    Author     : Owner
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <%! int i; %> 
   <% for(i = 1; i <=10; i+=1){ %>
        <tr>      
            <td><%= i %><br></td>
        </tr>
    <% } %>
    
    </body>
</html>
