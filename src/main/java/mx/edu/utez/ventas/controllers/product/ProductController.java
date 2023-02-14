package mx.edu.utez.ventas.controllers.product;

import jdk.jfr.Category;
import mx.edu.utez.ventas.models.product.Product;
import mx.edu.utez.ventas.services.product.ProductService;
import mx.edu.utez.ventas.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-ventas/product")
@CrossOrigin({"*"})
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Product>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Product>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Product>> insert(@RequestBody Product product, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.insert(product), HttpStatus.CREATED);
    }

    @PutMapping ("/")
    public ResponseEntity<CustomResponse<Product>> update(@RequestBody Product product , @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.update(product), HttpStatus.CREATED);
    }

    @PatchMapping  ("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody Product product, @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.service.changeStatus(product), HttpStatus.OK);
    }

}
