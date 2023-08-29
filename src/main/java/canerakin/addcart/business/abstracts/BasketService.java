package canerakin.addcart.business.abstracts;

import canerakin.addcart.models.response.BasketResponse;

public interface BasketService {

    BasketResponse setBasket(int customerId, int productId, int productCount);

    BasketResponse getBasketByCustomerId(int customerId);
}
