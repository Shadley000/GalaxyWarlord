/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.servlet;

import galacticWarlord.common.ParameterConstants;
import galacticWarlord.common.SessionConstants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shadl
 */
public class LoginServlet extends HttpServlet
{

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
            throws ServletException, IOException
    {

        String email = request.getParameter(ParameterConstants.KEY_EMAIL);
        String password = request.getParameter(ParameterConstants.KEY_PASSWORD);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.KEY_AUTHENTICATED, null);

        Integer loginFailedCount = (Integer) session.getAttribute(SessionConstants.KEY_LOGIN_FAILED_COUNT);
        if (loginFailedCount == null)
        {
            loginFailedCount = new Integer(0);
            session.setAttribute(SessionConstants.KEY_LOGIN_FAILED_COUNT, loginFailedCount);
        }
        Boolean authenticated = authenticateUser(email, password);

        session.setAttribute(SessionConstants.KEY_AUTHENTICATED, authenticated);

        String jspURL;

        if (authenticated!=null && authenticated)
        {
            loginFailedCount = new Integer(0);
            jspURL = "/gwc.jsp";
        } else
        {
           if(email!=null) loginFailedCount++;
            jspURL = "/login.jsp";
        }
        session.setAttribute(SessionConstants.KEY_LOGIN_FAILED_COUNT, loginFailedCount);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspURL);
        dispatcher.forward(request, response);
    }

    private boolean authenticateUser(String email, String password)
    {
        if (email != null && password != null)
        {
            return (email.equals("admin") && password.equals("supersecret"));
        }
        return false;
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
