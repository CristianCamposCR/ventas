package mx.edu.utez.ventas.services.product;

import jdk.jfr.Category;
import mx.edu.utez.ventas.models.product.Product;
import mx.edu.utez.ventas.models.product.ProductRepository;
import mx.edu.utez.ventas.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public CustomResponse<List<Product>> getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"ok");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Product> getOne(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),
                false,
                200,
                "ok");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> insert(Product product){
        if (!this.repository.existsByName(product.getName())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El producto ya se ha registrado"
            );
        }
       return new CustomResponse<>(this.repository.saveAndFlush(product),
               false,
               200,
               "Registrado correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> update(Product product){
        if (!this.repository.existsById(product.getId())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El producto no existe"
            );
        }
        return new CustomResponse<>(this.repository.saveAndFlush(product),
                false,
                200,
                "Registrado correctamente");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Product product){
        if (!this.repository.existsById(product.getId())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El producto no existe"
            );
        }
        return new CustomResponse<>(this.repository.updateStatusById(product.getAvailability(), product.getId()),
                false,
                200,
                "disponibilidad cambiada correctamente correctamente");
    }

}
