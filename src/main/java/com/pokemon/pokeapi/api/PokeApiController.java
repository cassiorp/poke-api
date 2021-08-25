package com.pokemon.pokeapi.api;

import com.pokemon.pokeapi.dto.RotinaDTO;
import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.service.PokeApiService;
import com.pokemon.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/pokeapi")
@CrossOrigin("*")
public class PokeApiController {

    @Autowired
    private PokeApiService pokeApiService;
    @Autowired
    private PokemonService pokemonService;
    @GetMapping
    public List<PokemonModel> findAll() {
        return pokeApiService.findAll();
    }

    @PutMapping
    public PokemonModel update(@RequestBody RotinaDTO rotina) {
        pokemonService.upate(rotina);
        return pokeApiService.upate(rotina);
    }


}