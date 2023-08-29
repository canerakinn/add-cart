package canerakin.addcart.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


// basketId, products liste seklinde, customerId
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity

public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int basketId;
    @Column(name = "customer_id")
    private int customerId;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;


}
