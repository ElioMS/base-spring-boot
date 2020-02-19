package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.exceptions.InvalidRequest;
import com.elioms.cambioymoneda.models.entity.User;
import com.elioms.cambioymoneda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {})
@RestController
@RequestMapping("/api/v1")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> index() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> store(@Valid @RequestBody User user, Errors errors) {
        InvalidRequest.check(errors);

        User newUser = userService.save(user);

        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/users/{id}")
    public User update(@Valid @RequestBody User user, Errors errors, @PathVariable Long id) {
        InvalidRequest.check(errors);

        User currentUser = userService.findById(id);
        currentUser.setName(user.getName());

        return userService.save(currentUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
