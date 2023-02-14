package mx.edu.utez.ventas.models.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "UPDATE products SET availability = :availability WHERE id = :id",nativeQuery = true)
        //forma de manipular los datos directamente no pasa por jpa ni los metaqueries
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);
    boolean existsByName (String name);
}
