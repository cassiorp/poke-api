package com.pokemon.pokeapi.api;

import com.pokemon.pokeapi.model.PokemonStoreModel;
import com.pokemon.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/store")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<PokemonStoreModel> getAllPokemons() {
        return pokemonService.findAll();
    }

    @GetMapping("/{id}")
    public PokemonStoreModel getPokemon(@PathVariable String id) {
        return pokemonService.findById(id);
    }

    @PostMapping
    public PokemonStoreModel save(@RequestBody PokemonStoreModel pokemonStoreModel) {
        return pokemonService.save(pokemonStoreModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        pokemonService.deleteById(id);
    }

}
