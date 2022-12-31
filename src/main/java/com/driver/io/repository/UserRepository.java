package com.driver.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.driver.io.entity.UserEntity;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
}
