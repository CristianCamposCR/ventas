package mx.edu.utez.ventas.controllers.transaction;

import mx.edu.utez.ventas.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-ventas/transaction")
@CrossOrigin({"*"})
public class TransactionController {
    @Autowired
    private TransactionService service;
}
