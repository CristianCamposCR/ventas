package mx.edu.utez.ventas.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ventas.models.transaction.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String category;
    @Column(nullable = false)
    private Float price;
    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean availability;

    @OneToMany(mappedBy="product")
    @JsonIgnore
    private List<Transaction> transactions;





}
