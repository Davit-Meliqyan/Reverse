package am.reverse.mappers;

import am.reverse.dto.UserDto;
import am.reverse.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    AddressMapper addressMapper;

    public User toUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setAddress(addressMapper.toAddress(userDto.getAddress()));

        return user;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(addressMapper.toAddressDto(user.getAddress()));

        return userDto;
    }

    public List<UserDto> mapAllToUserDto(List<User> users) {
        return users.stream()
                .map(this::toUserDto)
                .collect(Collectors.toList());
    }
}
