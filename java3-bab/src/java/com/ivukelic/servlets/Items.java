
package com.ivukelic.servlets;

import com.google.gson.Gson;
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
        List<Item> items = new ArrayList<>();
        
        items.add(new Item("Grahovica/images/items/pile_256.jpg", "Grahovica/images/icons/cart_64.png", "thing", 22.33, "Plushies", "1"));
        items.add(new Item("Grahovica/images/items/pile_256.jpg", "Grahovica/images/icons/cart_64.png", "bab", 28.93, "Other", "2"));
        items.add(new Item("Grahovica/images/items/bab_256.jpg", "Grahovica/images/icons/cart_64.png", "bae", 67.98, "Figures", "3"));

        if (!itemType.getType().equals("All")) {
            items = items.stream().filter(i->i.getType().equals(itemType.getType())).collect(Collectors.toList());
        }
        
        response.getWriter()
                .write(gson.toJson(items));
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
