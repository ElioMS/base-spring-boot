package com.elioms.cambioymoneda.controllers;

import com.elioms.cambioymoneda.models.entity.Privilege;
import com.elioms.cambioymoneda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/privileges")
public class PrivilegeController {

    private UserService userService;

    public PrivilegeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Privilege> index() {
        return userService.findPrivileges();
    }


}
