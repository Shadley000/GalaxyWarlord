<%-- 
    Document   : login
    Created on : Jan 3, 2018, 10:24:21 AM
    Author     : shadl
--%>

<%@page import="galacticWarlord.common.SessionConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galactic Warlord Login</title>
    </head>
    <body>
<DIV><h1>Please login</h1>
        
        <% 
            {  Integer loginFailedCount = (Integer)request.getSession().getAttribute(SessionConstants.KEY_LOGIN_FAILED_COUNT); 

              if(loginFailedCount!=null && loginFailedCount>0)
              {
                  out.println("<H2>Failed logins " +loginFailedCount.toString() + "</H2>");
              }
            }
        %>
            <form action="login" method="post">
                <ul>

                    <li><input name="Email" type="text"> </li>
                    <li><input name="Password" type="password"></li>
                    <li> <input type="submit" value="login"></li>
                </ul>
            </form>
        </DIV>
    </body>
</html>
