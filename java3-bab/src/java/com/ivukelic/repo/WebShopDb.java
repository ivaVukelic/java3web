
package com.ivukelic.repo;

import com.ivukelic.repo.beans.Item;
import com.ivukelic.repo.beans.User;
import java.util.ArrayList;
import java.util.Arrays;


public class WebShopDb implements WebShopRepo {
    
    private final User[] users;
    private final Item[] items;
    
    
    private WebShopDb() 
    {

        users = new User[] {
            new User("miro@mirich.com", "pass123", "Miro Miric", "Ilica 242", 0),
            new User("buha@buhic.com", "heck123", "Buha Buhic", "Ulica 123", 1),
            new User("loop@cat.com", "tummy123", "Fits Many Loops", "L00pland 3.14", 1)
        };
        
        items = new Item[] {
            new Item("Grahovica/images/items/bab_256.jpg", "D.va nendoroid", 50.00, "Figures", "1"),
            new Item("Grahovica/images/items/babtue_256.jpg", "D.va statue", 250.00, "Figures", "2"),
            new Item("Grahovica/images/items/badges_256.jpg", "Badges set", 15.00, "Other", "3"),
            new Item("Grahovica/images/items/badges2_256.jpg", "Basget set 2", 15.00, "Other", "4"),
            new Item("Grahovica/images/items/beekuma_256.jpg", "Bee rilakkuma", 30.00, "Plushies", "5"),
            new Item("Grahovica/images/items/bottle_256.jpg", "Water bottle", 40.00, "Other", "6"),
            new Item("Grahovica/images/items/kuma_256.jpg", "Rilakkuma", 40.00, "Plushies", "7"),
            new Item("Grahovica/images/items/mercy_256.jpg", "Mercy nendoroid", 50.00, "Figures", "8"),
            new Item("Grahovica/images/items/pile_256.jpg", "Kiroiitori sushi", 25.00, "Plushies", "9"),
            new Item("Grahovica/images/items/reaper_256.jpg", "Reaper figure", 80.00, "Figures", "10"),
            new Item("Grahovica/images/items/sombra_256.jpg", "Sombra nendoroid", 50.00, "Figures", "11"),
            new Item("Grahovica/images/items/straps_256.jpg", "Straps set", 10.00, "Other", "12"),
            new Item("Grahovica/images/items/vader_256.jpg", "Vader statue", 300.00, "Figures", "13")
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
    public ArrayList<Item> getItem(String filter) {

        ArrayList<Item> filteredItems = new ArrayList<>();
        
        if (filter.equals("All")) {
            filteredItems.addAll(Arrays.asList(items));
        }
        
        for (int i = 0; i < items.length; i++) {
            if (items[i].getType().equals(filter)) {
                filteredItems.add(items[i]);
            }
        }

        return filteredItems;
        
    }

    @Override
    public User getUser(String email, String password) {  
        
        User user = null;
        User temp;
        
        for (int i = 0; i < users.length; i++) {
            
            temp = users[i];
            
            if (temp.getEmail().equals(email) && temp.getPassword().equals(password)) {
                user = temp;
                break;
            }
            
        }
        
        return user;
    }

}
