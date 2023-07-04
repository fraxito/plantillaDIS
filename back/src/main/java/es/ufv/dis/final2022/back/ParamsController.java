package es.ufv.dis.final2022.back;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

@RestController
public class ParamsController {

    ////////////////////////////////   GET  //////////////////////////////

    ////////////  USUARIOS  ///////////////
    @GetMapping("/Users")
    public ArrayList<User> getUsers(){
        ArrayList<User> listaUsuarios = new JsonReader().leeFicheroJson();
        return listaUsuarios;
    }


    @GetMapping("/Users/porNombre/{nombre}")
    public ResponseEntity<User> getUserPorNombre(@PathVariable String nombre){
        ArrayList<User> listaUsuarios = new JsonReader().leeFicheroJson();
        //ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2("./src/main/resources/pokemonConId.json");

        User encontrado = null;
        for (User user : listaUsuarios) {
            if(user.getName().equalsIgnoreCase(nombre)){
                encontrado = user;
            }
        }
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }

    @GetMapping("/Users/porRol/{rol}")
    public List<User> getUserPorRol(@PathVariable String rol) {
        List<User> listaUsuarios = new JsonReader().leeFicheroJson();
        List<User> usuariosEncontrados = new ArrayList<>();

        for (User user : listaUsuarios) {
            if (Arrays.asList(user.getRoles()).contains(rol)) {
                usuariosEncontrados.add(user);
            }
        }

        return usuariosEncontrados;
    }


//    @GetMapping("/users/{name}")
//    public ResponseEntity<User> getUserByName(@PathVariable String name){
//        DataHandling dataHandling = new DataHandling();
//        User foundUser = dataHandling.getUserInfo(name);
//        return new ResponseEntity<>(foundUser, HttpStatus.OK);
//    }


    ////////////  POKEMONS  ///////////////
    @GetMapping("/Pokemons")
    public ArrayList<Pokemon> getPokemons(){
        ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2();
        return listaPokemons;
    }

    @GetMapping("/Pokemons/porNombre/{nombre}")
    public ResponseEntity<Pokemon> getPokemonPorNombre(@PathVariable String nombre){
        ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2();
        //ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2("./src/main/resources/pokemonConId.json");

        Pokemon encontrado = null;
        for (Pokemon pokemon : listaPokemons) {
            if(pokemon.getName().equalsIgnoreCase(nombre)){
                encontrado = pokemon;
            }
        }
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }


    @GetMapping("/Pokemons/porTipo/{tipo}")
    public ArrayList<Pokemon> getPokemonPorTipo(@PathVariable String tipo){
        ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2();
        //ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2("./src/main/resources/pokemonConId.json");

        ArrayList<Pokemon> listaEncontrados = new ArrayList<>();
        for (Pokemon pokemon : listaPokemons) {
            if(pokemon.getTipo1().equalsIgnoreCase(tipo) || pokemon.getTipo2().equalsIgnoreCase(tipo)){
                listaEncontrados.add(pokemon);
            }
        }
        return listaEncontrados;
    }

    /////////////////////    SI QUIERES UNO QUE VAYA POR INT UTILIZA ESTE  /////////////////////

    @GetMapping("/Pokemons/porAtk/{atk}")
    public ArrayList<Pokemon> getPokemonPorAtk(@PathVariable String atk){
        ArrayList<Pokemon> listaPokemons = new JsonReader().leeFicheroJson2();

        ArrayList<Pokemon> listaEncontrados = new ArrayList<>();
        for (Pokemon pokemon : listaPokemons) {
            if (pokemon.getAttack() == Integer.parseInt(atk)) {
                listaEncontrados.add(pokemon);
            }
        }
        return listaEncontrados;
    }

    ///////// GET POR NOMBRE CUANDO TODAVIA NO TIENES EL FRONT HECHO /////////////////

//    @GetMapping("/Pokemons/{name}")
//    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String name){
//        DataHandling dataHandling = new DataHandling();
//        Pokemon foundPokemon = dataHandling.getPokemonInfo(name);
//        return new ResponseEntity<>(foundPokemon, HttpStatus.OK);
//    }


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
