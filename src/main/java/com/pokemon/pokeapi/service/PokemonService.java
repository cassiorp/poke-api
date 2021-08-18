package com.pokemon.pokeapi.service;

import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.model.PokemonStoreModel;
import com.pokemon.pokeapi.repository.PokemonStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class PokemonService {

    @Autowired
    private PokemonStoreRepository pokemonStoreRepository;

    public PokemonStoreModel save(PokemonModel pokemonModel) {
        Optional<PokemonStoreModel> optional = pokemonStoreRepository.findByName(pokemonModel.getName());
        if(optional.isPresent()) throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Você ja possui esse pokemon");
        try {
            PokemonStoreModel toSave = (PokemonStoreModel) pokemonModel;
            return pokemonStoreRepository.save(toSave);
        }catch (RuntimeException e){
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Erro ao salvar no banco store", e.getCause());
        }
    }

    public List<PokemonStoreModel> findAll() {
        return pokemonStoreRepository.findAll();
    }

    public PokemonStoreModel findById(String id) {
        return pokemonStoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não encontrado"));
    }

    public void deleteById(String id) {
        try {
            pokemonStoreRepository.deleteById(id);
        }catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

//    public PokemonStoreModel update(PokemonStoreModel pokemonStoreModel, String id) {
//        PokemonStoreModel ifExists = findById(id);
//        if(ifExists != null )
//
//
//        return pokemonStoreRepository.save(toUpdate);
//    }


}
