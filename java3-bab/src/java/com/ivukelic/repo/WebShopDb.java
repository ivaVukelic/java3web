
package com.ivukelic.repo;

import com.ivukelic.repo.beans.UserLogin;
import com.ivukelic.repo.beans.UserStatus;
import java.util.Arrays;


public class WebShopDb implements WebShopRepo
{
    private UserLogin[] logins;
    
    private WebShopDb() 
    {
        logins = new UserLogin[] {
            new UserLogin("buh@buhomail.muh", "buh123"),
            new UserLogin("buhelic4lyf@salad.net", "smrd.meh"),
            new UserLogin("bae@aeb.prd", "buholada")
        };
    };
    
    private static WebShopDb instance;
    
    public static WebShopDb getInstance()
    {
        if (instance == null)
        {
            instance = new WebShopDb();
        }
        
        return instance;
    }
    
    @Override
    public UserStatus checkUser(String email, String password) 
    {
        UserStatus status = new UserStatus(false, "/Customer");
        
        UserLogin login = Arrays.asList(logins)
              .stream()
              .filter(l -> l.getEmail().equals(email) && l.getPassword().equals(password))
              .findFirst()
              .get();
        
        if (login != null)
        {
            status.setIsGud(true);
        }
        
        return status;
    }
}
