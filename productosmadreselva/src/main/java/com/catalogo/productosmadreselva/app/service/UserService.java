
package com.catalogo.productosmadreselva.app.service;

import com.catalogo.productosmadreselva.app.model.User;
import com.catalogo.productosmadreselva.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Marina Del Águila
 */
@Service
public class UserService {

    @Autowired  //Inyección de dependencias
    private UserRepository repository;

    /*
    *
    * @return
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    public User save(User user) {
        if (user.getId() == null) {
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if (existUsers.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            Optional<User> existUsers = repository.getUserById(user.getId());
            if (existUsers.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        }
    }

    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()){
            return user.get();
        }else{
            return new User(null, email, password, "NO DEFINIDO");
        }
    }
}