package es.ufv.dis.final2022.front;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class API {

    ////////////  POKEMONS  ///////////////

    private static final String urlPrefix = "http://localhost:8080/%s/%s";

    public String getPokemons() throws URISyntaxException, IOException, InterruptedException {
        String fullUrl = String.format(urlPrefix, "Pokemons","");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public String getPokemonPorNombre(String nombre) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "Pokemons/porNombre", nombre);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
                        System.out.println(response.body());
        return response.body();
    }

    ///////  SI SIMPLEMENTE ES UN STRING EN EL CAMPO UTILIZA ESTE //////////////

    public String getPokemonPorTipo(String tipo) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "Pokemons/porTipo", tipo);
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(fullUrl))
                        .GET()
                        .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    /////////////////////    SI QUIERES UNO QUE VAYA POR INT UTILIZA ESTE  /////////////////////

    public String getPokemonPorAtk(String atk) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "Pokemons/porAtk", atk);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }


    ////////////  USUARIOS  ///////////////

    public String getUsers() throws URISyntaxException, IOException, InterruptedException {
        String fullUrl = String.format(urlPrefix, "Users","");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public String getUserPorNombre(String nombre) throws URISyntaxException, IOException, InterruptedException {
        String fullUrl = String.format(urlPrefix, "Users/porNombre", nombre);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }


    /////////// SI TIENES UN ARRAY CON VARIOS STRINGS DENTRO ESTA ES LA OPCION QUE TIENES QUE COGER ///////////////////////

    public String getUserPorRol(String rol) throws URISyntaxException, IOException,
            InterruptedException {
        String fullUrl = String.format(urlPrefix, "Users/porRol", rol);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

}
