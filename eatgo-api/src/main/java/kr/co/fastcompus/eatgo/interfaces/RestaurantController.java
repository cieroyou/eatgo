package kr.co.fastcompus.eatgo.interfaces;

import kr.co.fastcompus.eatgo.domain.Restaurant;
import kr.co.fastcompus.eatgo.domain.RestaurantRepository;
import kr.co.fastcompus.eatgo.domain.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;


    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
