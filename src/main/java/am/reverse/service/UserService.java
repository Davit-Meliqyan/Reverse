package am.reverse.service;

import am.reverse.dto.UserDto;
import am.reverse.entities.Address;
import am.reverse.entities.User;
import am.reverse.exception.ResourceAlreadyExistsException;
import am.reverse.exception.ResourceNotFoundException;
import am.reverse.mappers.AddressMapper;
import am.reverse.mappers.UserMapper;
import am.reverse.repository.AddressRepository;
import am.reverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, AddressMapper addressMapper, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }


    public UserDto createUser(UserDto userDto) {

        if (userRepository.existsByName(userDto.getName())) {
            System.out.println("Barlus");
            throw new ResourceAlreadyExistsException(
                    "User with name " + userDto.getName() + " already exists");

        }
        Address address = addressRepository.save(addressMapper.toAddress(userDto.getAddress()));
        User userToSave = this.userMapper.toUser(userDto);
        userToSave.setAddress(address);
        User savedUser = this.userRepository.save(userToSave);
        return userMapper.toUserDto(savedUser);

    }

    public UserDto getUser(Long id) {

        Optional<User> user = this.userRepository.findById(id);
        return userMapper.toUserDto(user.get());
    }

    public UserDto updateUser(Long id, UserDto userDto) {

        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }

        Address address = addressRepository.save(addressMapper.toAddress(userDto.getAddress()));
        user.get().setPhoneNumber(userDto.getPhoneNumber());
        user.get().setName(userDto.getName());
        user.get().setAddress(address);



        userRepository.save(user.get());
        return userDto;
    }

    public void deleteUser(Long id) {

        Optional<User> card = this.userRepository.findById(id);
        if (card.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.delete(card.get());
    }

}
