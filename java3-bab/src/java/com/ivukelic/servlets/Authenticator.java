
package com.ivukelic.servlets;

import com.google.gson.Gson;
import com.ivukelic.repo.WebShopDb;
import com.ivukelic.repo.beans.User;
import com.ivukelic.repo.beans.UserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Authenticator extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        
        if (user != null)
        {
            if (user.getUserType() == 1) {
                getServletContext().getRequestDispatcher("/Signed/Customer").forward(request, response);
            }
            else if (user.getUserType() == 0) {
                getServletContext().getRequestDispatcher("/Signed/Administrator").forward(request, response);
            }
        }
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        Gson gs = new Gson();
        UserLogin login = gs.fromJson(request.getReader(), UserLogin.class);
        
        User user = WebShopDb.getInstance().getUser(login.getEmail(), login.getPassword());
        
        request.getSession().setAttribute("user", user);

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) 
        {
            out.write(gs.toJson(user==null));
        }
       
    }
}
