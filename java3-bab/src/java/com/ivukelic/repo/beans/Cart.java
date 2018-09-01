package com.ivukelic.repo.beans;

public class Cart {

    private CartItem[] items;

    public Cart(CartItem[] items) {
        this.items = items;
    }

    public CartItem[] getItems() {
        return items;
    }

    public void setItems(CartItem[] items) {
        this.items = items;
    }
    
    private class CartItem {
        
        private String id;
        private int amount;

        public CartItem(String id, int amount) {
            this.id = id;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
        
    }
    
    
}
