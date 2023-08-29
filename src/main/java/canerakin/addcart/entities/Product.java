package canerakin.addcart.entities;

import lombok.*;

import javax.persistence.*;


// productId , productName, unitPrice
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private int productName;
    @Column(name = "unit_price")
    private int unitPrice;


}