package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.driver.convertor.OrderConvertor;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto order) {

        OrderEntity orderEntity = OrderConvertor.orderDtoEntity(order);
        orderRepository.save(orderEntity);
        orderEntity.setOrderId(String.valueOf(orderEntity.getId()));
        orderRepository.save(orderEntity);
        OrderDto orderDto = OrderConvertor.orderEntityDto(orderEntity);

        return orderDto;
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
        orderRepository.delete(orderRepository.findByOrderId(orderId));

    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {

        OrderDto orderDto = OrderConvertor.orderEntityDto(orderRepository.findByOrderId(orderId));
        return orderDto;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderDto> list = new ArrayList<>();
        List<OrderEntity> orderEntities = (List<OrderEntity>) orderRepository.findAll();
        for (OrderEntity f : orderEntities) {
            list.add(OrderConvertor.orderEntityDto(f));
        }
        return list;
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        OrderEntity orderEntity = OrderConvertor.orderDtoEntity(order);
        orderEntity.setOrderId(orderId);
        orderRepository.save(orderEntity);

        OrderDto orderDto = OrderConvertor.orderEntityDto(orderEntity);

        return orderDto;
    }

}