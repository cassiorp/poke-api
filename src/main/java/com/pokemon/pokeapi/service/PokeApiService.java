package com.pokemon.pokeapi.service;

import com.pokemon.pokeapi.client.PokeApiClient;
import com.pokemon.pokeapi.client.PokemonResponse;
import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.model.PokemonStoreModel;
import com.pokemon.pokeapi.repository.PokemonModelRepository;
import com.pokemon.pokeapi.repository.PokemonStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class PokeApiService {

    @Autowired
    private LoadDatabaseService loadDatabaseService;
    @Autowired
    private PokemonModelRepository repository;
    @Autowired
    PokeApiClient client;

    public Set<PokemonModel> findAll() {
        return loadDatabaseService.getPokemons();
    }

//    public PokemonResponse getPokemon(Integer id) {
//        try {
//            PokemonResponse pokemonResponse = client.getPokemon(id);
//            System.out.println(pokemonResponse.getForms().get(0).getName());
//            Optional<PokemonModel> model = repository.findByName(pokemonResponse.getForms().get(0).getName());
//            PokemonModel model1 = model.get();
//            model1.setImage(pokemonResponse.getSprites().getOther().getOfficial_artwork().getFront_default());
//            repository.save(model1);
//            return pokemonResponse;
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Erro ao pegar pokemon:", e.getCause());
//        }
//
//    }
//
//    public void getAllPokemons() {
//        try {
//            for (int i = 1; i <= 898; i++) {
//                getPokemon(i);
//            }
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//
//    }

//    private PokemonModel toModel(PokemonResponse pokemonResponse) {
//        return PokemonModel.builder()
//                .name(pokemonResponse.getForms().get(0).getName())
//                .image(pokemonResponse.getSprites().getOther().getDream_world().getFront_default())
//                .price(getPrice(pokemonResponse))
//                .hp(pokemonResponse.getStats().get(0).getBase_stat())
//                .attack(pokemonResponse.getStats().get(1).getBase_stat())
//                .defense(pokemonResponse.getStats().get(2).getBase_stat())
//                .build();
//    }
//
//    private Double getPrice(PokemonResponse pokemonResponse) {
//        Integer hp = pokemonResponse.getStats().get(0).getBase_stat();
//        Integer attack = pokemonResponse.getStats().get(1).getBase_stat();
//        Integer defense = pokemonResponse.getStats().get(2).getBase_stat();
//        return Double.valueOf((hp + attack + defense) / 3);
//    }

}
