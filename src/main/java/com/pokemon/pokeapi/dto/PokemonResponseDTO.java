package com.pokemon.pokeapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class PokemonResponseDTO {
    private String image;
    private String name;
    private String price;
    private String hp;
    private String attack;
    private String defense;
}
