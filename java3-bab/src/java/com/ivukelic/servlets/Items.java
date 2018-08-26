
package com.ivukelic.servlets;

import com.google.gson.Gson;
import com.ivukelic.repo.beans.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Items extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        Gson gson = new Gson();
        
        response.setContentType("text/json");
        Item[] items = new Item[]{
            new Item("Grahovica/images/items/pile_256.jpg", "Grahovica/images/icons/cart_64.png", "thing", 22.33),
            new Item("Grahovica/images/items/pile_256.jpg", "Grahovica/images/icons/cart_64.png", "bab", 28.93),
            new Item("Grahovica/images/items/bab_256.jpg", "Grahovica/images/icons/cart_64.png", "bae", 67.98)
        };
        
        response.getWriter().write(gson.toJson(items));
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
