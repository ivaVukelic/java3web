
package com.ivukelic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Administrator extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException 
    {
        request.getRequestDispatcher("/WEB-INF/html/administrator.html")
               .forward(request, response);
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException 
    {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException 
    {
        processRequest(request, response);
    }

}
