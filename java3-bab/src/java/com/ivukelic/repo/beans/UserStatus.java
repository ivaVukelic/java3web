
package com.ivukelic.repo.beans;


public class UserStatus
{
    private boolean isGud;
    private String path;
    
    public UserStatus(boolean isGud, String path)
    {
        this.isGud = isGud;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isIsGud() {
        return isGud;
    }

    public void setIsGud(boolean isGud) {
        this.isGud = isGud;
    }

    @Override
    public String toString() {
        return String.format("isGud:%s", isGud);
    }
}
