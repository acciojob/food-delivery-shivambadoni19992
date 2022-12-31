package com.driver.convertor;

import com.driver.io.entity.FoodEntity;
import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;


public class FoodConverter {
    public static FoodDto foodrequestToDto(FoodDetailsRequestModel foodDetailsRequestModel){
        FoodDto foodDto=new FoodDto();
        foodDto.setFoodCategory(foodDetailsRequestModel.getFoodCategory());
        foodDto.setFoodName(foodDetailsRequestModel.getFoodName());
        foodDto.setFoodPrice(foodDetailsRequestModel.getFoodPrice());
        return foodDto;
    }

    public static FoodEntity foodDtoEntity(FoodDto foodDto){
        FoodEntity foodEntity=new FoodEntity();
        foodEntity.setFoodCategory(foodDto.getFoodCategory());
        foodEntity.setFoodName(foodDto.getFoodName());
        foodEntity.setFoodPrice(foodDto.getFoodPrice());
        return foodEntity;
    }

    public static FoodDto foodEntityDto(FoodEntity foodEntity){
        FoodDto foodDto=new FoodDto();
        foodDto.setFoodCategory(foodEntity.getFoodCategory());
        foodDto.setFoodName(foodEntity.getFoodName());
        foodDto.setFoodPrice(foodEntity.getFoodPrice());
        foodDto.setId(foodEntity.getId());
        foodDto.setFoodId(foodEntity.getFoodId());
        return foodDto;
    }

    public static FoodDetailsResponse foodDtoTOfoodresponse(FoodDto foodDto){
        FoodDetailsResponse foodDetailsResponse=new FoodDetailsResponse();
        foodDetailsResponse.setFoodCategory(foodDto.getFoodCategory());
        foodDetailsResponse.setFoodName(foodDto.getFoodName());
        foodDetailsResponse.setFoodPrice(foodDto.getFoodPrice());
        foodDetailsResponse.setFoodId(foodDto.getFoodId());
        return foodDetailsResponse;
    }




}
