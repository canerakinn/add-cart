package canerakin.addcart.models.response;

import canerakin.addcart.entities.Product;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class BasketResponse {
    private int basketId;
    private int customerId;
    private List<Product> products;
}
