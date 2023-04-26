package com.kahder.rest.webservice.todolist.controler;

import com.kahder.rest.webservice.todolist.exception.UserNotFoundException;
import com.kahder.rest.webservice.todolist.model.Task;
import com.kahder.rest.webservice.todolist.model.User;
import com.kahder.rest.webservice.todolist.repository.TaskRepository;
import com.kahder.rest.webservice.todolist.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControler {

    private UserRepository userRepository;

    public UserControler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public  User getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: " + id);
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User addedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(addedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
