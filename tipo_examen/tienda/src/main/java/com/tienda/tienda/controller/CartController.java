package com.tienda.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.tienda.model.Product;
import com.tienda.tienda.service.CartService;

@Controller
@Scope("session") 
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam int quantity) {
        Product product = new Product(name, description, price);
        cartService.addProduct(product, quantity);
        return "redirect:/cart";
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalPrice", cartService.getTotalPrice());
        return "cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam String name) {
        cartService.removeProduct(name);
        return "redirect:/cart";
    }    

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(Model model) {
        double totalPrice = cartService.getTotalPrice();
        cartService.clearCart();

        model.addAttribute("message", String.format(
            "Compra procesada correctamente por un total de %.2f a las %s",
            totalPrice,
            java.time.LocalDateTime.now()
        ));
        return "cart";
    }
}
