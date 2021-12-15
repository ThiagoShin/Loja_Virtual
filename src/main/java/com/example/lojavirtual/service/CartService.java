package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.CartEntity;
import com.example.lojavirtual.entity.CartItemEntity;
import com.example.lojavirtual.entity.ProductEntity;
import com.example.lojavirtual.entity.UserEntity;
import com.example.lojavirtual.entity.builder.CartEntityBuilder;
import com.example.lojavirtual.entity.builder.CartItemEntityBuilder;
import com.example.lojavirtual.repository.CartItemRepository;
import com.example.lojavirtual.repository.CartRepository;
import com.example.lojavirtual.repository.ProductRepository;
import com.example.lojavirtual.repository.UserRepository;
import com.example.lojavirtual.request.CartRequest;
import com.example.lojavirtual.util.FunctionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private PermissionService permissionService;

    private UserEntity userLogged = null;

    public int add(CartRequest cartRequest, Long userId) {
        Optional<ProductEntity> product = productRepository.findById(cartRequest.getProductId());

        if (product.isEmpty()) {
            return 1; //Produto não existe
        }


        if (permissionService.isLogged(userId)) {
            Optional<UserEntity> user = userRepository.findById(userId);
            if (user.isPresent()) {
                userLogged = user.get();
            }
        }

        CartEntity cart = getUserCart(userLogged);
        Optional<CartItemEntity> cartItemEntity = cartItemRepository.findByCartAndProduct(cart, product.get());

        if (cartItemEntity.isPresent()) {
            return 2; // Produto já existente no carrinho
        }

        CartItemEntity newItem = CartItemEntityBuilder.builder()
                .withCart(cart)
                .withProduct(product.get())
                .withQuantity(cartRequest.getQuantity())
                .build();
        cart.getItems().add(newItem);
        cartRepository.save(cart);

        return 0;
    }

    public int update(CartRequest cartRequest, Long userId) {

        if (permissionService.isLogged(userId)) {
            Optional<UserEntity> user = userRepository.findById(userId);
            if (user.isPresent()) {
                userLogged = user.get();
            }
        }

        Optional<ProductEntity> product = productRepository.findById(cartRequest.getProductId());

        if (product.isEmpty()) {
            return 1; // Nao existe dentro da lista do produto
        }

        CartEntity cart = getUserCart(userLogged);

        Optional<CartItemEntity> item = cartItemRepository.findByCartAndProduct(cart, product.get());

        if (item.isEmpty()) {
            return 2; // Não existe o produto dentro do carrinho
        }

        CartItemEntity itemToUpdate = item.get();
        itemToUpdate.setQuantity(cartRequest.getQuantity());
        cart.getItems().add(itemToUpdate);
        cartRepository.save(cart);

        return 0;
    }

    public int delete(CartRequest cartRequest, Long userId) {

        if (permissionService.isLogged(userId)) {
            Optional<UserEntity> user = userRepository.findById(userId);
            if (user.isPresent()) {
                userLogged = user.get();
            }
        }

        Optional<ProductEntity> product = productRepository.findById(cartRequest.getProductId());

        if (product.isEmpty()) {
            return 1; // Nao existe dentro da lista do produto
        }

        CartEntity cart = getUserCart(userLogged);

        Optional<CartItemEntity> item = cartItemRepository.findByCartAndProduct(cart, product.get());

        if (item.isEmpty()) {
            return 2; // Não existe o produto dentro do carrinho
        }

        cartItemRepository.delete(item.get());

        return 0;
    }

    private CartEntity getUserCart(UserEntity userLogged) {
        String ip = FunctionsUtils.getUserRemoteIpAddress();
        CartEntity cart;

        if (userLogged == null) {
            Optional<CartEntity> userCart = cartRepository.findByRemoteIp(ip);
            if (userCart.isPresent()) {
                cart = userCart.get();
            } else {
                CartEntity newUserCart = CartEntityBuilder.builder()
                        .withUser(null)
                        .withRemoteIp(ip)
                        .build();
                cart = cartRepository.save(newUserCart);
            }
        } else {
            cart = cartRepository.getByUser(userLogged);
        }

        return cart;
    }
}
