package com.task.mc_user.controller;

import com.task.mc_user.entity.User;
import com.task.mc_user.repositroy.UserRepository;
import com.task.mc_user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@PathVariable User user){
        return userService.createUser(user);
    }


    @GetMapping ("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List <User> getAllUsers (){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser (@RequestBody User updatedUser,  @PathVariable Long id){
        return userService.updateUser(updatedUser, id);
    }

     @DeleteMapping
    public void deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
     }

     @PostMapping
    public String loginUser (@RequestBody String username, @RequestBody String password){
        return userService.login(username, password);
     }
}
