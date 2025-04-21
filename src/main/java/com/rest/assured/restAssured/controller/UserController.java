package com.rest.assured.restAssured.controller;


import com.rest.assured.restAssured.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> userList = new ArrayList<>();
    private int currentId = 1;

    // POST - Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(currentId++);
        userList.add(user);
        return user;
    }

    // GET - Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                return user;
            }
        }
        return null;
    }

    // DELETE - Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean removed = userList.removeIf(user -> user.getId() == id);
        return removed ? "User deleted successfully" : "User not found";
    }

    // PATCH - Partially Update User
    @PatchMapping("/{id}")
    public User partiallyUpdateUser(@PathVariable int id, @RequestBody User partialUser) {
        for (User user : userList) {
            if (user.getId() == id) {
                if (partialUser.getName() != null) {
                    user.setName(partialUser.getName());
                }
                if (partialUser.getEmail() != null) {
                    user.setEmail(partialUser.getEmail());
                }
                return user;
            }
        }
        return null;
    }

}