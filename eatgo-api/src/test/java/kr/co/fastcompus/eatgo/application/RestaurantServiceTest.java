package kr.co.fastcompus.eatgo.application;

import kr.co.fastcompus.eatgo.domain.*;
import kr.co.fastcompus.eatgo.domain.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {
    RestaurantService restaurantService;

    // @MockBean을 쓰지 않는다.
    @Mock
    RestaurantRepository restaurantRepository;

    @Mock
    MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
        mockRestaurantRepository();
        mockMenuItemRepository();

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

    public void mockRestaurantRepository(){
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurants.add(restaurant);
        BDDMockito.given(restaurantRepository.findAll()).willReturn(restaurants);
        BDDMockito.given(restaurantRepository.findById(1004L)).willReturn(restaurant);
    }

    public void mockMenuItemRepository(){
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));
        BDDMockito.given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);

    }

}