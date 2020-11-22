package kr.co.fastcompus.eatgo.interfaces;

import kr.co.fastcompus.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
       List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004l, "Bob zip" , "Seoul");
        restaurants.add(restaurant);
       return restaurants;
    }
}
