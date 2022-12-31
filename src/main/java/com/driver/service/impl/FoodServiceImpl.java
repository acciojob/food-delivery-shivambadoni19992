package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.driver.convertor.FoodConverter;
import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;

public class FoodServiceImpl implements FoodService{

    @Autowired
    FoodRepository foodRepository;

    @Override
    public FoodDto createFood(FoodDto food) {
       
        FoodEntity foodEntity=FoodConverter.foodDtoEntity(food);
        foodRepository.save(foodEntity);
        foodEntity.setFoodId(String.valueOf(foodEntity.getId()));
        foodRepository.save(foodEntity);
        FoodDto foodDto=FoodConverter.foodEntityDto(foodEntity);
        return foodDto;
    }

    @Override
    public void deleteFoodItem(String id) throws Exception {
        
        foodRepository.delete(foodRepository.findByFoodId(id));
        
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception {
        
        FoodDto foodDto=FoodConverter.foodEntityDto(foodRepository.findByFoodId(foodId));
        return foodDto;
    }

    @Override
    public List<FoodDto> getFoods() {
        List<FoodDto> list=new ArrayList<>();
        List<FoodEntity> foodEntities=(List<FoodEntity>) foodRepository.findAll();
        for(FoodEntity f:foodEntities){
            list.add(FoodConverter.foodEntityDto(f));
        }
        return list;
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {
        
        FoodEntity foodEntity=FoodConverter.foodDtoEntity(foodDetails);
        foodEntity.setFoodId(foodId);
        foodRepository.save(foodEntity);
        
        FoodDto foodDto=FoodConverter.foodEntityDto(foodEntity);
        return foodDto;
    }
    
}