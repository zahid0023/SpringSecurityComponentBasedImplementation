package com.example.tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/design")
@SessionAttributes("order")
public class DesignTacoController {
    private final IngredientRepository ingredientRepository;
    private final TacoRepository designRepository;
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository designRepository){
        this.ingredientRepository = ingredientRepository;
        this.designRepository = designRepository;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }
    @GetMapping
    public ResponseEntity<List<Ingredient>> showDesigns() {
        log.info("initiated");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        Ingredient.Type[] types = Ingredient.Type.values();
        log.info("sent");
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> processDesign(@RequestBody Taco design, @RequestBody @ModelAttribute Order order) {
        Taco saved = designRepository.save(design);
        order.addDesign(saved);
        return new ResponseEntity<>("saved", HttpStatus.OK);
    }

}
