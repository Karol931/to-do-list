package com.kahder.rest.webservice.todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Entity
public class Task {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Future(message = "Deadline must be in the future")
    private LocalDate deadline;

    protected Task() {

    }

    public Task(Integer id, String title, String description, User user, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
