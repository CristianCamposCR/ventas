package mx.edu.utez.ventas.services.transaction;

import mx.edu.utez.ventas.models.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

}
