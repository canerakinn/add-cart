package canerakin.addcart.webApi;


import canerakin.addcart.business.abstracts.BasketService;
import canerakin.addcart.models.request.SetBasketRequest;
import canerakin.addcart.models.response.BasketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// CONTROLLER > SERVİSE > MANAGER > REPOSITORY

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    BasketService basketService;

    @Autowired
    BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @PostMapping("/add-to-cart")
    public BasketResponse setBasket(@RequestBody SetBasketRequest request){
        return basketService.setBasket(request.getCustomerId(),request.getProductId(), request.getProductCount());
    }

    @GetMapping("get-cart")
    public BasketResponse getBasketByCustomerId(@RequestParam int customerId){
        return basketService.getBasketByCustomerId(customerId);
    }


}
