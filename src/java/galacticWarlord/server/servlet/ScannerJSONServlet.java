/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galacticWarlord.server.servlet;

import galacticWarlord.entities.GalacticEntity;
import galacticWarlord.entities.Vector2D;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

/**
 *
 * @author shadl
 */
public class ScannerJSONServlet extends HttpServlet
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
        JSONArray arr = new JSONArray();

        {
            GalacticEntity myShip = new GalacticEntity();
            myShip.setId(0);
            myShip.setName("20198");
            myShip.setType("Yellow Star");
            myShip.setLocation(new Vector2D());
            myShip.setHeading(new Vector2D());
            arr.put(myShip.toJSON());
        }
        {
            GalacticEntity myShip = new GalacticEntity();
            myShip.setId(1);
            myShip.setName("Earth");
            myShip.setType("E Class Planet");
            myShip.setLocation(new Vector2D(10,0));
            myShip.setHeading(new Vector2D());
            arr.put(myShip.toJSON());
        }
        {
            GalacticEntity myShip = new GalacticEntity();
            myShip.setId(2);
            myShip.setName("Enterprise");
            myShip.setType("Cruiser");
            myShip.setLocation(new Vector2D(0,10));
            myShip.setHeading(new Vector2D());
            arr.put(myShip.toJSON());
        }
        {
            GalacticEntity myShip = new GalacticEntity();
            myShip.setId(3);
            myShip.setName("Intrepid");
            myShip.setType("Carrier");
            myShip.setLocation(new Vector2D(10, 10));
            myShip.setHeading(new Vector2D(0, 0));
            arr.put(myShip.toJSON());
        }

        {
            GalacticEntity myShip = new GalacticEntity();
            myShip.setId(4);
            myShip.setName("Hornet");
            myShip.setType("Corvette");
            myShip.setLocation(new Vector2D(-10, -10));
            myShip.setHeading(new Vector2D(1, 1));
            arr.put(myShip.toJSON());
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(arr.toString());

        response.getWriter().flush();
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
