package com.example.lojavirtual.service;

import com.example.lojavirtual.entity.*;
import com.example.lojavirtual.entity.builder.CreditCardEntityBuilder;
import com.example.lojavirtual.entity.builder.OrderEntityBuilder;
import com.example.lojavirtual.entity.builder.OrderItemEntityBuilder;
import com.example.lojavirtual.repository.CartRepository;
import com.example.lojavirtual.repository.GiftRepository;
import com.example.lojavirtual.repository.OrderRepository;
import com.example.lojavirtual.repository.UserRepository;
import com.example.lojavirtual.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private OrderRepository orderRepository;
//
    public Long registerOrder(Long userId, OrderRequest orderRequest) {

        UserEntity user = userRepository.getById(userId);
        CartEntity userCart = cartRepository.getByUser(user);

        GiftEntity gift = null;

        if (orderRequest.getCoupon() != null) {
            Optional<GiftEntity> giftEntity = giftRepository.findByNameIgnoreCase(orderRequest.getCoupon());

            if (giftEntity.isPresent()) {
                gift = giftEntity.get();
            }
        }

        OrderEntity order = OrderEntityBuilder.builder()
                .withUser(user)
                .withDeliveryAddress(orderRequest.getDeliveryAddress())
                .withGift(gift)
                .withOrderDate(LocalDateTime.now())
                .withBillingAddress(orderRequest.getBillingAddress())
                .build();
        List<OrderItemEntity> items = getOrderItems(userCart.getItems(), order);

        CreditCardEntity card = CreditCardEntityBuilder.builder()
                .withNumber(orderRequest.getCard().getNumber())
                .withName(orderRequest.getCard().getName())
                .withCvv(orderRequest.getCard().getCvv())
                .withValidateDate(orderRequest.getCard().getValidateDate())
                .withOrder(order)
                .build();

        order.setItems(items);
        order.setCard(card);
        order.setTotalAmount(getOrderTotalAmount(items));

        orderRepository.save(order);

        // Esvaziar o carrihno
        userCart.getItems().clear();
        cartRepository.save(userCart);

        return order.getId();
    }


    private BigDecimal getOrderTotalAmount(List<OrderItemEntity> items) {
        double totalAmount = 0;
        for (OrderItemEntity item: items) {
            totalAmount += item.getQuantity().doubleValue() * item.getProduct().getPrice().doubleValue();
        }

        return BigDecimal.valueOf(totalAmount);
    }

    private List<OrderItemEntity> getOrderItems(List<CartItemEntity> items, OrderEntity order) {
        List<OrderItemEntity> orderItems = new ArrayList<>();

        for (CartItemEntity item: items) {
            OrderItemEntity orderItem = OrderItemEntityBuilder.builder()
                    .withOrder(order)
                    .withProduct(item.getProduct())
                    .withQuantity(item.getQuantity())
                    .build();
            orderItems.add(orderItem);
        }

        return orderItems;
    }
}
