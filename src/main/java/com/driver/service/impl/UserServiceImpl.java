package com.driver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.driver.convertor.UserConvertor;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) throws Exception {
        UserEntity userEntity=UserConvertor.userDtoEntity(user);
        userRepository.save(userEntity);
        userEntity.setUserId(String.valueOf(userEntity.getId()));
        userRepository.save(userEntity);
        UserDto userDto=UserConvertor.userEntityDto(userEntity);
        
        return userDto;
        
    }

    @Override
    public void deleteUser(String userId) throws Exception {
        userRepository.delete(userRepository.findByUserId(userId));
        
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        UserDto userDto=UserConvertor.userEntityDto(userRepository.findByEmail(email));
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        UserDto userDto=UserConvertor.userEntityDto(userRepository.findByUserId(userId));
        return userDto;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> list=new ArrayList<>();
        List<UserEntity> userEntities=(List<UserEntity>) userRepository.findAll();
        for(UserEntity f:userEntities){
            list.add(UserConvertor.userEntityDto(f));
        }
        return list;
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        UserEntity userEntity=UserConvertor.userDtoEntity(user);
        userEntity.setUserId(userId);
        userRepository.save(userEntity);
        
        UserDto userDto=UserConvertor.userEntityDto(userEntity);
        return userDto;
        
    }
    
}