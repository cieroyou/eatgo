package kr.co.fastcompus.eatgo.application;

import kr.co.fastcompus.eatgo.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {
    RestaurantService restaurantService;

    RestaurantRepository restaurantRepository;

    MenuItemRepository menuItemRepository;
    @BeforeEach
    public void setUp(){
        restaurantRepository = new RestaurantRepositoryImpl();
        menuItemRepository = new MenuItemRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        assertEquals(restaurants.get(0).getId(), 1004L);

    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertEquals(restaurant.getId(),1004L);
        assertEquals(restaurant.getMenuItems().get(0).getName(), "Kimchi");
    }



}