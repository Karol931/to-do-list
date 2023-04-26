package com.kahder.rest.webservice.todolist.repository;

import com.kahder.rest.webservice.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
