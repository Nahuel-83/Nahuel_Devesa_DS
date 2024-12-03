package com.tienda.tienda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.CartItem;
import com.tienda.tienda.model.Product;

@Service
@Scope("session")
public class CartServiceImpl implements CartService{

    private final List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addProduct(Product product, int quantity) {
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeProduct(String name) {
        cartItems.removeIf(item -> item.getProduct().getName().equals(name));
    }
    

    public void clearCart() {
        cartItems.clear();
    }

    public double getTotalPrice() {
        return cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
