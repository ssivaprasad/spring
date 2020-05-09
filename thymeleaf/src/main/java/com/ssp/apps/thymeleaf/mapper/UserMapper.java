package com.ssp.apps.thymeleaf.mapper;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.ssp.apps.thymeleaf.dto.UserDto;
import com.ssp.apps.thymeleaf.entity.User;

@Component
public class UserMapper {

    public UserDto convert2Dto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getAge(),
                user.getDateOfBirth());
    }

    public User convert2Entity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(),
                userDto.getAge(), userDto.getDateOfBirth());
    }

    public List<UserDto> conver2UserDtoList(List<User> users) {
        return users.stream().map(user -> convert2Dto(user)).collect(Collectors.toList());
    }

}
