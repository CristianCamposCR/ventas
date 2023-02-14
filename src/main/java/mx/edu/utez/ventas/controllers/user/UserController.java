package mx.edu.utez.ventas.controllers.user;

import mx.edu.utez.ventas.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-ventas/user")
@CrossOrigin({"*"})
public class UserController {
    @Autowired
    private UserService service;
}
