package com.tienda.tienda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.tienda.model.CartItem;
import com.tienda.tienda.model.Product;

@Service
public interface CartService {
    List<CartItem> getCartItems();
    void addProduct(Product product, int quantity);
    void removeProduct(String name);
    void clearCart();
    double getTotalPrice();
}
