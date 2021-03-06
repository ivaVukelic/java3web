
package com.ivukelic.servlets;

import com.google.gson.Gson;
import com.ivukelic.repo.WebShopDb;
import com.ivukelic.repo.beans.Item;
import com.ivukelic.repo.beans.ItemType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        
        ItemType itemType = gson.fromJson(request.getReader(), ItemType.class);
        
        response.setContentType("text/json");

        response.getWriter()
                .write(gson.toJson(WebShopDb.getInstance().getItem(itemType.getType())));
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
