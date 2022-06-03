package am.reverse.controller;

import am.reverse.dto.UserDto;
import am.reverse.entities.User;
import am.reverse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        Assert.notNull(userDto, "Given user is null!");
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(
                "User was created", HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        UserDto user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(
                "User was deleted ", HttpStatus.OK
        );
    }

}
