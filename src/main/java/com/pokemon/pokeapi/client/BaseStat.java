package com.pokemon.pokeapi.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseStat {
    private Integer base_stat;
    private Stat stat;
}
