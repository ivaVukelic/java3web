package com.ivukelic.servlets;

import com.google.gson.Gson;
import com.ivukelic.repo.beans.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartItems extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Gson gson = new Gson();
        
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) 
        {
            out.write(gson.toJson(request.getSession().getAttribute("items")));
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Gson gson = new Gson();
        
        Cart items = gson.fromJson(request.getReader(), Cart.class);
        
        request.getSession().setAttribute("items", items);

        response.setContentType("application/json");

        String error = "No error senior";
        
        try {
            items.getItems();
        } catch (Exception ex){
            error = ex.getMessage();
        }
        
        try (PrintWriter out = response.getWriter()) 
        {
            out.write(gson.toJson(items));
        }
        
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
