
package com.ivukelic.repo;

import com.ivukelic.repo.beans.UserStatus;

public interface WebShopRepo 
{
    public UserStatus checkUser(String email, String password);
}
