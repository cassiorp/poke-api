package com.pokemon.pokeapi.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PokemonResponse {
    private List<InfoForm> forms;
    private List<BaseStat> stats;
    private Sprites sprites;
}
