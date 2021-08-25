package com.pokemon.pokeapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(value = "pokemons_api")
@Builder
@Data
public class PokemonModel {
    @Id
    private String id;
    @NotNull
    private String image;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer hp;
    @NotNull
    private Integer attack;
    @NotNull
    private Integer defense;
    @NotNull
    private float rating;
}
