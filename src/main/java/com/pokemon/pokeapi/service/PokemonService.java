package com.pokemon.pokeapi.service;

import com.pokemon.pokeapi.dto.RotinaDTO;
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

    public boolean deleteById(String id) {
        findById(id);
        try {
            pokemonStoreRepository.deleteById(id);
            if(pokemonStoreRepository.existsById(id)){
                return false;
            }
            return true;
        }catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    public boolean deleteByName(String name) {
        PokemonStoreModel  model = pokemonStoreRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        try {
            pokemonStoreRepository.delete(model);
            if(pokemonStoreRepository.existsById(model.getId())){
                return false;
            }
            return true;
        }catch (RuntimeException e) {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }


    public PokemonStoreModel upate(RotinaDTO rotinaDTO) {
        PokemonStoreModel pokemonModel = pokemonStoreRepository.findById(rotinaDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        pokemonModel.setRating(rotinaDTO.getRating());
        return pokemonStoreRepository.save(pokemonModel);
    }
//    public PokemonStoreModel update(PokemonStoreModel pokemonStoreModel, String id) {
//        PokemonStoreModel ifExists = findById(id);
//        if(ifExists != null )
//
//
//        return pokemonStoreRepository.save(toUpdate);
//    }


}
