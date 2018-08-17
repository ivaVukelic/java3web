
package com.ivukelic.servlets;

import com.google.gson.Gson;
import com.ivukelic.repo.WebShopDb;
import com.ivukelic.repo.beans.UserLogin;
import com.ivukelic.repo.beans.UserStatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Authenticator extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException 
    {
        Gson gs = new Gson();
        UserLogin login = gs.fromJson(request.getReader(), UserLogin.class);
        
        UserStatus status = WebShopDb
                .getInstance()
                .checkUser(login.getEmail(), login.getPassword());
        
        if (status.isIsGud())
        {
            request.getSession().setAttribute("UserLogin", login);
        }
        
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) 
        {
            out.write(gs.toJson(status));
        }
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
