package com.kahder.rest.webservice.todolist.model;

import java.util.List;

public class User {

    private Integer id;
    private String fname;
    private String lname;
    private List<Task> tasks;

    public User(int id, String fname, String lname, List<Task> tasks) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.tasks = tasks;
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
}
