package es.ufv.dis.final2022.back;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ParamsController {

    ////////////////////////////////   GET  //////////////////////////////


    @GetMapping("/users")
    public ArrayList<User> getUsers(){
        ArrayList<User> listaUsuarios = new JsonReader().leeFicheroJson();
        return listaUsuarios;
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        DataHandling dataHandling = new DataHandling();
        User foundUser = dataHandling.getUserInfo(name);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("/Pokemons")
    public ArrayList<Pokemon> getPokemons(){
        ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2();
        return listaPokemons;
    }

    @GetMapping("/Pokemons/{name}")
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String name){
        DataHandling dataHandling = new DataHandling();
        Pokemon foundPokemon = dataHandling.getPokemonInfo(name);
        return new ResponseEntity<>(foundPokemon, HttpStatus.OK);
    }


    ////////////////////////////////   POST  //////////////////////////////


    @PostMapping(path = "users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        DataHandling dataHandling = new DataHandling();
        ArrayList<User> userList = dataHandling.addUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
