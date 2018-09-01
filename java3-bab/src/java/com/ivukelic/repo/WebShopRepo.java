
package com.ivukelic.repo;

import com.ivukelic.repo.beans.Item;
import com.ivukelic.repo.beans.User;

import java.util.ArrayList;

public interface WebShopRepo 
{
    
    public ArrayList<Item> getItem(String filter);
    public User getUser(String email, String password);
    
}
