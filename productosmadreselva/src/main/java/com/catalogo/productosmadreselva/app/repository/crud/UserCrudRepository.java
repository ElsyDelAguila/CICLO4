/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.catalogo.productosmadreselva.app.repository.crud;

import com.catalogo.productosmadreselva.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marina Del Águila
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    public Optional<User> findByName(String name);
    public Optional<User> findByEmail(String email);
    public List<User> findByNameOrEmail(String name, String email);
    public Optional<User> findByEmailAndPassword(String email, String password);    
}
