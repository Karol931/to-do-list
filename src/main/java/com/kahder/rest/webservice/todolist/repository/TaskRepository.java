package com.kahder.rest.webservice.todolist.repository;

import com.kahder.rest.webservice.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
