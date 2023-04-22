package com.kahder.rest.webservice.todolist.controler;

import com.kahder.rest.webservice.todolist.model.Task;
import com.kahder.rest.webservice.todolist.model.User;
import com.kahder.rest.webservice.todolist.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControler {

    private UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public  User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }


}
