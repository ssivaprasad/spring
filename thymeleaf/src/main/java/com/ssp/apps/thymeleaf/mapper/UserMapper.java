package com.ssp.apps.thymeleaf.mapper;


import com.ssp.apps.thymeleaf.dto.UserDto;
import com.ssp.apps.thymeleaf.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto convert2Dto(User user);

    User convert2Entity(UserDto userDto);

    List<UserDto> conver2UserDtoList(List<User> users);

}
