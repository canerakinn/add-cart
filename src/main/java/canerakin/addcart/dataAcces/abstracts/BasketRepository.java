package canerakin.addcart.dataAcces.abstracts;

import canerakin.addcart.entities.Basket;

public interface BasketRepository {

    void setBasket(Basket basket);

    public Basket getBasketByCustomerId(int customerId);

    void updateBasket(Basket customerBasket);
}
