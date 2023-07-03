package es.ufv.dis.final2022.front;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

@Service
public class ParamsService implements Serializable{

    public Pokemon leePokemonPorNombre(String nombre) throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        String pokemonJson = api.getPokemonPorNombre(nombre);
        Gson gson = new Gson();
        return gson.fromJson(pokemonJson, Pokemon.class);
    }


    public List<Pokemon> leePokemonPorTipo(String tipo) throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        String pokemonsJson = api.getPokemonPorTipo(tipo);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Pokemon>>() {}.getType();
        return gson.fromJson(pokemonsJson, listType);
    }


    public ArrayList<Pokemon> leePokemons() throws URISyntaxException, IOException,
            InterruptedException {
        API api = new API();
        String resultsAPI = api.getPokemons();
        Gson gson = new Gson();
        ArrayList<Pokemon> lista = gson.fromJson(resultsAPI,new
                TypeToken<ArrayList<Pokemon>>(){}.getType());
        return lista;
    }

}
