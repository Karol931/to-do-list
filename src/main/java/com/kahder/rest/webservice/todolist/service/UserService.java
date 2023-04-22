package com.kahder.rest.webservice.todolist.service;

import com.kahder.rest.webservice.todolist.model.Task;
import com.kahder.rest.webservice.todolist.model.User;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


@Component
public class UserService {

    private static List<User> userList = new ArrayList<>();

    private static int nextUserId = 1;

    static {
        User user1 = new User(nextUserId++,"Michal", "Suruwa", null);
        User user2 = new User(nextUserId++,"John", "Doe", null);
        User user3 = new User(nextUserId++,"Michael", "Salad", null);
        User user4 = new User(nextUserId++,"Karol", "Hoerner", null);

        userList.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int userId) {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);
        return userList.stream().filter(predicate).findFirst().get();
    }

    public void addUser(User user) {
        user.setId(nextUserId++);
        userList.add(user);
    }
}
