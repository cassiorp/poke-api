package com.pokemon.pokeapi.repository;

import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.model.PokemonStoreModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonModelRepository extends MongoRepository<PokemonModel, String> {
    Optional<PokemonModel> findByName(String name);
}
