package com.pokemon.pokeapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(value = "pokemons_bought")
public class PokemonStoreModel extends PokemonModel {
    public PokemonStoreModel(String id, @NotNull String image, @NotNull String name, @NotNull Double price, @NotNull Integer hp, @NotNull Integer attack, @NotNull Integer defense) {
        super(id, image, name, price, hp, attack, defense);
    }
}
