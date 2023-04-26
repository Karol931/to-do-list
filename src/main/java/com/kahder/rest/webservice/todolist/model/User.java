package com.kahder.rest.webservice.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_details")
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2, message = "First name should have at least 2 characters")
    private String fname;
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lname;
    @NotNull
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    protected User () {

    }
    public User(int id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFName(String name) {
        this.fname = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isTaskOfUser(int id) {
        if(tasks.contains(Integer.valueOf(id)))
            return true;
        else
            return false;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
