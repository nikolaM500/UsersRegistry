package com.nikola.nikola.controller;

import com.nikola.nikola.models.User;
import com.nikola.nikola.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class Controller {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPages(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> getSingleUser(@PathVariable long id){
        return userRepo.findById(id) ;
    }

    @GetMapping(value = "/users/{id1}/{id2}/{id3}")
    public List<User> getUsers(@PathVariable Long id1,@PathVariable Long id2,@PathVariable Long id3){
        ArrayList ids = new ArrayList();
        ids.addAll(Arrays.asList(id1,id2,id3));
        return userRepo.findAllById(ids);
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return user.getId() + "\nsuccess";
    }

    @PostMapping(value = "/create")
    public Optional<User> createUser(@RequestBody User user){
        String message="";
        if(user.getName().equals("")||user.getLastname().equals("")||user.getOccupation().equals("")){
            message= "Must Provide Full Name And Occupation!";
        }else {
            userRepo.save(user);
        }
        return userRepo.findById(user.getId());
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.getById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "saved...";
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deletedUser = userRepo.getById(id);
        userRepo.delete(deletedUser);
        return "deleted user id: "+id+"\n" +
                "was: "+deletedUser.getName()+" "+deletedUser.getLastname();
    }

    @GetMapping("/count")
    public String getCount(){
        return "Total users: "+ userRepo.count();
    }








}
