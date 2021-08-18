package com.pokemon.pokeapi.service;

import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.repository.PokemonModelRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class LoadDatabaseService implements CommandLineRunner {

    @Autowired
    private PokemonModelRepository repository;

    private Set<PokemonModel> pokemons = new HashSet<>();

    @Override
    public void run(String... args) throws Exception {
        setPokemons();
    }

    private void setPokemons() {
        log.info("Iniciando load do banco");
        pokemons.addAll(repository.findAll());
        log.info("Load finalizado, tamanho da lista: " + pokemons.size());
    }

    public Set<PokemonModel> getPokemons() {
        return pokemons;
    }
}
