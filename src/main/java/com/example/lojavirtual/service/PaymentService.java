package com.example.lojavirtual.service;

import com.example.lojavirtual.dto.GiftDTO;
import com.example.lojavirtual.dto.UserDTO;
import com.example.lojavirtual.dto.order.OrderDTO;
import com.example.lojavirtual.dto.order.OrderItemDTO;
import com.example.lojavirtual.entity.OrderEntity;
import com.example.lojavirtual.entity.OrderItemEntity;
import com.example.lojavirtual.entity.ProductEntity;
import com.example.lojavirtual.repository.OrderRepository;
import com.example.lojavirtual.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO payment(Long OrderId){
        Optional<OrderEntity> orderEntity = orderRepository.findById(OrderId);
        if(orderEntity.isEmpty()){
            return new OrderDTO();
        }

        OrderDTO orderDTO = new OrderDTO();
        OrderEntity order = orderEntity.get();
        UserDTO userDTO = new UserDTO();
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        GiftDTO giftDTO = new GiftDTO();

        userDTO.setName(order.getUser().getName());
        userDTO.setCPF(order.getUser().getCpf());
        userDTO.setCellPhone(order.getUser().getCellPhone());
        userDTO.setEmail(order.getUser().getEmail());
        userDTO.setResidencialAddress(order.getUser().getResidencialAddress());

        giftDTO.setName(order.getGift().getName());
        giftDTO.setValue(order.getGift().getValue());

        for (OrderItemEntity orderItemEntity : order.getItems()){
            Optional<ProductEntity> product = productRepository.findById(order.getItems().stream().count());
            orderItemDTO.setProductName(product.get().getProductName());
            orderItemDTO.setPrice(product.get().getPrice());
            orderItemDTO.setQuantity(product.get().getQuantity());
            orderItemDTOList.add(orderItemDTO);
        }

        orderDTO.setUser(userDTO);
        orderDTO.setBillingAddress(order.getBillingAddress());
        orderDTO.setDeliveryAddress(order.getDeliveryAddress());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setItems(orderItemDTOList);
        orderDTO.setGift(giftDTO);


        return orderDTO;
    }
}
