package com.pokemon.pokeapi.api;

import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("v1/pokeapi")
@CrossOrigin("*")
public class PokeApiController {

    @Autowired
    private PokeApiService pokeApiService;

    @GetMapping
    public Set<PokemonModel> findAll() {
        return pokeApiService.findAll();
    }

}