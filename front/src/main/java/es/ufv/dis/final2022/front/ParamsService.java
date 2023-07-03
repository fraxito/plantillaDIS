package es.ufv.dis.final2022.front;

import java.io.Serializable;
import org.springframework.stereotype.Service;

@Service
public class ParamsService implements Serializable{

    public String leePokemon(String tipoPeticion) {
        return "Hello " + tipoPeticion;
    }

}
