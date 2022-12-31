package com.driver.convertor;

import com.driver.io.entity.OrderEntity;
import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.shared.dto.OrderDto;

public class OrderConvertor {
    public static OrderDto orderRequestDto(OrderDetailsRequestModel orderDetailsRequestModel){
        OrderDto orderDto=new OrderDto();
        orderDto.setCost(orderDetailsRequestModel.getCost());
        orderDto.setItems(orderDetailsRequestModel.getItems());
        orderDto.setUserId(orderDetailsRequestModel.getUserId());
        return orderDto;
    }
    public static OrderEntity orderDtoEntity(OrderDto orderDto){
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setCost(orderDto.getCost());
        orderEntity.setItems(orderDto.getItems());
        orderEntity.setUserId(orderDto.getUserId());
        return orderEntity;
    }
    public static OrderDto orderEntityDto(OrderEntity orderEntity){
        OrderDto orderDto=new OrderDto();
        orderDto.setCost(orderEntity.getCost());
        orderDto.setItems(orderEntity.getItems());
        orderDto.setUserId(orderEntity.getUserId());
        orderDto.setId(orderEntity.getId());
        orderDto.setOrderId(orderDto.getOrderId());
        return orderDto;
    }
    public static OrderDetailsResponse orderDtoResEntity(OrderDto orderDto){
        OrderDetailsResponse orderDetailsResponse=new OrderDetailsResponse();
        orderDetailsResponse.setCost(orderDto.getCost());
        orderDetailsResponse.setItems(orderDto.getItems());
        orderDetailsResponse.setUserId(orderDto.getUserId());
        orderDetailsResponse.setOrderId(orderDto.getOrderId());
        return orderDetailsResponse;
    }
}
