/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catalogo.productosmadreselva.app.controller;

import com.catalogo.productosmadreselva.app.model.User;
import com.catalogo.productosmadreselva.app.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Marina Del Águila
 */
@RestController  //Define como controlador
@RequestMapping("user") //Define la ruta
@CrossOrigin(origins = "*") //Habilita el acceso desde cualquier origen
public class UserController {

    @Autowired //Inyección de dependencias
    private UserService service;

    @GetMapping("/all") //Permite generar los Get
    public List<User> getUsers() {
        return service.getAll();
    }

    @PostMapping("/new") //Permite generar los Post
    @ResponseStatus(HttpStatus.CREATED) // Responde código de creado al navegador
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return service.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
