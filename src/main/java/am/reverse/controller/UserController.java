package am.reverse.controller;

import am.reverse.dto.UserDto;
import am.reverse.entities.User;
import am.reverse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
//        Optional<EmployeeDto> emp = employeeService.getEmployee(id);
//        if (emp.isPresent()) {
//            return new EmployeeLookupResponse(emp.get()).onSuccess();
//        }
//        return new EmployeeLookupResponse(null).onFailure();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(
                "User was deleted ", HttpStatus.OK
        );
    }

}
