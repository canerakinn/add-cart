package canerakin.addcart.business.concretes;

import canerakin.addcart.business.abstracts.BasketService;
import canerakin.addcart.dataAcces.abstracts.BasketRepository;
import canerakin.addcart.entities.Basket;
import canerakin.addcart.entities.Product;
import canerakin.addcart.models.response.BasketResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Configuration

public class BasketManager implements BasketService {

    BasketRepository basketRepository;

    public BasketManager(BasketRepository basketRepository) {
        super();
        this.basketRepository = basketRepository;
    }


    @Override
    public BasketResponse setBasket(int customerId, int productId, int productCount) {
        //Business kurallarının yazılacağı yer//

        if (customerId == 0 || productId == 0 || productCount == 0) {
            System.out.println("Tüm alanları yeniden doldurunuz");

        }

        var customerBasket = basketRepository.getBasketByCustomerId(customerId);

        if (customerBasket == null) {
            //Customer için yeni bir basket oluştur

            Basket basket = new Basket();
            basket.setCustomerId(customerId);

            List<Product> products = new ArrayList<>();

            for (int i = 0; i < productCount; i++) {
                Product product = new Product();
                product.setProductId(productId);
                products.add(product);
            }

            basket.setProducts(products);
            basketRepository.setBasket(basket);

            BasketResponse basketResponse = new BasketResponse();
            basketResponse.setBasketId(basket.getBasketId());
            basketResponse.setCustomerId(basket.getCustomerId());
            basketResponse.setProducts(basket.getProducts());

            return basketResponse;
        }

        //Baskete product ekle

        for (int i = 0; i < productCount; i++) {
            List<Product> productList = new ArrayList<>();
            Product product = new Product();

            product.setProductId(productId);
            productList.add(product);
            customerBasket.setProducts(productList);

        }

        basketRepository.updateBasket(customerBasket);

        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setBasketId(customerBasket.getCustomerId());
        basketResponse.setCustomerId(customerBasket.getCustomerId());
        basketResponse.setProducts(customerBasket.getProducts());
        return basketResponse;


    }

    @Override
    public BasketResponse getBasketByCustomerId(int customerId) {
        return null;
    }
}
