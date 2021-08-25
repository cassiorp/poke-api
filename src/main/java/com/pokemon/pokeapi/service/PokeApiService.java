package com.pokemon.pokeapi.service;

import com.pokemon.pokeapi.client.PokeApiClient;
import com.pokemon.pokeapi.client.PokemonResponse;
import com.pokemon.pokeapi.dto.RotinaDTO;
import com.pokemon.pokeapi.model.PokemonModel;
import com.pokemon.pokeapi.model.PokemonStoreModel;
import com.pokemon.pokeapi.repository.PokemonModelRepository;
import com.pokemon.pokeapi.repository.PokemonStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PokeApiService {
    //@Autowired
    //private LoadDatabaseService loadDatabaseService;

    @Autowired
    private PokemonModelRepository repository;
    @Autowired
    private PokemonStoreRepository storeRepository;
    @Autowired
    PokeApiClient client;

    public List<PokemonModel> findAll() {
        return repository.findAll();
    }

    public PokemonModel upate(RotinaDTO rotinaDTO) {
        PokemonModel pokemonModel = repository.findById(rotinaDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        pokemonModel.setRating(rotinaDTO.getRating());
        return repository.save(pokemonModel);
    }

//    public PokemonResponse getPokemon(Integer id) {
//        try {
//            PokemonResponse pokemonResponse = client.getPokemon(id);
////            Optional<PokemonModel> model = repository.findByName(pokemonResponse.getForms().get(0).getName());
////            PokemonModel model1 = model.get();
////            model1.setRating(0);
//            PokemonModel pokemonModel = toModel(pokemonResponse);
//            repository.save(pokemonModel);
//            System.out.println(pokemonModel.getName());
//            return pokemonResponse;
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Erro ao pegar pokemon:", e.getCause());
//        }
//
//    }
//
//    public void getAllPokemons() {
//        //repository.deleteAll();
//        try {
//            for (int i = 1; i <= 898; i++) {
//                getPokemon(i);
//            }
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private PokemonModel toModel(PokemonResponse pokemonResponse) {
//        return PokemonModel.builder()
//                .name(pokemonResponse.getForms().get(0).getName())
//                .image(pokemonResponse.getSprites().getOther().getOfficial_artwork().getFront_default())
//                .price(getPrice(pokemonResponse))
//                .hp(pokemonResponse.getStats().get(0).getBase_stat())
//                .attack(pokemonResponse.getStats().get(1).getBase_stat())
//                .defense(pokemonResponse.getStats().get(2).getBase_stat())
//                .rating(0)
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
