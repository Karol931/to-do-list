package com.kahder.rest.webservice.todolist.controler;

import com.kahder.rest.webservice.todolist.exception.TaskNotFoundException;
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
public class TaskControler {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskControler(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/users/{id}/tasks")
    public  List<Task> getUserTasks(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: " + id);

        return user.get().getTasks();
    }

    @GetMapping("/users/{userId}/tasks/{id}")
    public Task getUserTaskById(@PathVariable int userId, @PathVariable int id) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new UserNotFoundException("User with this id wasn't found id=" + userId);
        List<Task> tasks = user.get().getTasks();
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty())
            throw new TaskNotFoundException("This database doesn't contain task with id=" + id);
        if(!tasks.contains(task.get()))
            throw new TaskNotFoundException("This user doesn't contain task with id=" + id);

        return task.get();
    }

    @PostMapping("/users/{userId}/tasks")
    public ResponseEntity<Task> addTask(@PathVariable int userId, @Valid @RequestBody Task task) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty())
            throw new UserNotFoundException("id: " + userId);

        task.setUser(user.get());

        Task addedTask = taskRepository.save(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedTask.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}/tasks/{id}")
    public void deleteTaskById(@PathVariable int userId, @PathVariable int id) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty())
            throw new UserNotFoundException("id: " + userId);
        List<Task> tasks = user.get().getTasks();
        Optional<Task> task = taskRepository.findById(id);
        if(task.isEmpty())
            throw new TaskNotFoundException("This database doesn't contain task with id=" + id);
        if(!tasks.contains(task.get()))
            throw new TaskNotFoundException("This user doesn't contain task with id=" + id);
        taskRepository.deleteById(id);
    }


}
