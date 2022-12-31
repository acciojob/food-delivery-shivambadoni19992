package com.driver.convertor;

import com.driver.io.entity.UserEntity;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import com.driver.shared.dto.UserDto;

public class UserConvertor {
    public static UserDto userRequestDto(UserDetailsRequestModel userDetailsRequestModel){
        UserDto userdto=new UserDto();
        userdto.setEmail(userDetailsRequestModel.getEmail());
        userdto.setFirstName(userDetailsRequestModel.getFirstName());
        userdto.setLastName(userDetailsRequestModel.getLastName());
        return userdto;
    }

    public static UserEntity userDtoEntity(UserDto userDto){
        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        return userEntity;
    }

    public static UserDto userEntityDto(UserEntity userEntity){
        UserDto userdto=new UserDto();
        userdto.setEmail(userEntity.getEmail());
        userdto.setFirstName(userEntity.getFirstName());
        userdto.setLastName(userEntity.getLastName());
        userdto.setId(userEntity.getId());
        userdto.setUserId(userEntity.getUserId());
        return userdto;
    }
    public static UserResponse userDtResponse(UserDto userDto){
        UserResponse userresponse=new UserResponse();
        userresponse.setEmail(userDto.getEmail());
        userresponse.setFirstName(userDto.getFirstName());
        userresponse.setLastName(userDto.getLastName());
        userresponse.setUserId(userDto.getUserId());
        return userresponse;
    }
    
}
