package canerakin.addcart.models.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data


public class SetBasketRequest {


    private int customerId;

    private int productId;

    private int productCount;


}
