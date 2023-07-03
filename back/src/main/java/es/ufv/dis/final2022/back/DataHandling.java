package es.ufv.dis.final2022.back;

import java.util.ArrayList;

public class DataHandling {

    ////////////////// PARA BUSCAR UN USUARIO POR NOMBRE Y MOSTRARLO POR PANTALLA ////////////////////////
    User getUserInfo (String name){
        User foundUser = null;
        JsonReader reader = new JsonReader();
        ArrayList<User> usersList = reader.leeFicheroJson();
        for (User user : usersList){
            if (user.getName().equalsIgnoreCase(name)){
                foundUser = user;
            }
        }
        return foundUser;
    }

    ////////////////// PARA AÑADIR UN USUARIO NUEVO A UN JSON ////////////////////////
    public ArrayList<User> addUser(User newUser){
        JsonReader reader = new JsonReader();
        ArrayList<User> userList = reader.leeFicheroJson();
        userList.add(newUser);
        reader.writeJsonFile("ejemploJSON.json", userList); // Cambio aquí: no es necesario obtener la ruta del recurso a través de getClass().getClassLoader().getResource()
        return userList;
    }


    ////////////////// PARA BUSCAR UN POKEMON POR NOMBRE Y MOSTRARLO POR PANTALLA ////////////////////////
    Pokemon getPokemonInfo (String name){
        Pokemon foundPokemon = null;
        JsonReader reader = new JsonReader();
        ArrayList<Pokemon> listaPokemons = reader.leeFicheroJson2();
        for (Pokemon pokemon : listaPokemons){
            if (pokemon.getName().equalsIgnoreCase(name)){
                foundPokemon = pokemon;
            }
        }
        return foundPokemon;
    }

}
