package mx.edu.utez.ventas.services.user;

import mx.edu.utez.ventas.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepository repository;
}
