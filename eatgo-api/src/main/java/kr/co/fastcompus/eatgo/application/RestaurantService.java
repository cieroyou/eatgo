package kr.co.fastcompus.eatgo.application;

import kr.co.fastcompus.eatgo.domain.MenuItem;
import kr.co.fastcompus.eatgo.domain.MenuItemRepository;
import kr.co.fastcompus.eatgo.domain.Restaurant;
import kr.co.fastcompus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private final RestaurantRepository restaurantRepository;
    @Autowired
    private final MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    public Restaurant getRestaurant(Long id){
        Restaurant restaurant =  restaurantRepository.findById(id).orElse(null);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return  restaurant;

    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
