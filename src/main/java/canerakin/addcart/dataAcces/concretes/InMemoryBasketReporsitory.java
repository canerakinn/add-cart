package canerakin.addcart.dataAcces.concretes;

import canerakin.addcart.dataAcces.abstracts.BasketRepository;
import canerakin.addcart.entities.Basket;
import canerakin.addcart.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryBasketReporsitory implements BasketRepository {
    List<Basket> baskets;

    public InMemoryBasketReporsitory(){
        baskets = new ArrayList<Basket>();
        List<Product> products = new ArrayList<>();

        baskets.add(new Basket(10,999,products));
        baskets.add(new Basket(9,998,products));

    }

    @Override
    public void setBasket(Basket basket){
         baskets.add(basket);
    }

    @Override
    public Basket getBasketByCustomerId(int customerId){
        return baskets.stream().filter(basket -> basket.getCustomerId() == customerId).findFirst().orElse(null);
    }

    @Override
    public void updateBasket(Basket customerBasket) {

    }
}
