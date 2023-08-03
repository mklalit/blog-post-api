package com.lalitblog.services;

import java.util.List;

import com.lalitblog.payload.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto userDto, Integer userId);

	UserDto getByUserId(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
}
