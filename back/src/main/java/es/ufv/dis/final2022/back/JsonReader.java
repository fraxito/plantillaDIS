package es.ufv.dis.final2022.back;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonReader {

    /////////////////////// LECTURA DE FICHERO JSON //////////////////////////////


    public ArrayList<User> leeFicheroJson() {
        try{
            Reader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("ejemploJSON.json")));
            ArrayList<User> listaUsuarios = new Gson().fromJson(reader, new TypeToken<ArrayList<User>>(){}.getType());
            reader.close();
            return listaUsuarios;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    public ArrayList<Pokemon> leeFicheroJson2() {
        try{
            Reader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("pokemonConId.json")));
            ArrayList<Pokemon> listaPokemons = new Gson().fromJson(reader, new TypeToken<ArrayList<Pokemon>>(){}.getType());
            reader.close();
            return listaPokemons;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }

    }

    /////////////////////// ESCRITURA EN FICHERO JSON //////////////////////////////

    public boolean writeJsonFile(String fichero, ArrayList<User> users){
        try {
            Path filePath = Paths.get(fichero);
            Writer writer = Files.newBufferedWriter(filePath);
            writer.write(new Gson().toJson(users));
            writer.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
