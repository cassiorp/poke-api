package com.pokemon.pokeapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "starwarsapi", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokeApiClient {
    @GetMapping("/{id}")
    PokemonResponse getPokemon(@PathVariable("id") Integer id);
}
