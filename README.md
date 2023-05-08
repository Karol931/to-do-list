# To do list
API for to-do-list with Spring Boot

# How to use it?
First download or clone this repository and open it in your favourite java IDE and run the program.<br />
Application starts at: > localhost:8080.<br />
For other methods than GET u need to use API tester like postman.

# Mehods
GET methods:
- localhost:8080/users - show all users
- localhost:8080/users/{userId} - shows user with this userId
- localhost:8080/users/{userId}/tasks - shows tasks of user
- localhost:8080/users/{userId}/tasks/{taskId} - shows task with this taskId (if owned by user with this userId)

POST methods:
- localhost:8080/users - creates user
  Example input: {"fname":"First Name","lname":"Last Name"}
- localhost:8080/users/{userId}/tasks - creates task for user with userId
  Example input: { "title" : "Task 1", "description" : "Task 1 description", "deadline" : "YYYY-MM-DD"}
 
DELETE methods:
- localhost:8080/users/{userId} - deletes user with userId
- localhost:8080/users/{userId}/tasks/{taskId} - deletes task with taskId (if owned by user with this userId)

# Tech Stack
- Java
- Spring
- SpringBoot
