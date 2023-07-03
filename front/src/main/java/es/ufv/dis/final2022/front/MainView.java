package es.ufv.dis.final2022.front;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@PageTitle("Examen Final DIS ")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     */
    //VerticalLayout option1Cont;
    //VerticalLayout option2Cont;
    /**
     * Clase empleada para la creación de la vista principal de la aplicación.
     */


    public MainView(@Autowired ParamsService service) {

//        Label Title = new Label("Examen DIS ");
//        Title.addClassName("title");
//        Title.addClassName("centered-content");
//        add(Title);


        HorizontalLayout inputs = new HorizontalLayout();
        VerticalLayout results = new VerticalLayout();
        ComboBox<String> comboBox = new ComboBox<>("Selecciona uno...");
        comboBox.setAllowCustomValue(false);
        comboBox.setItems("Todos los pokemons", "Por Nombre", "Por tipo");
        comboBox.setHelperText("Selecciona el tipo de petición");
        Grid<Pokemon> grid = new Grid<>(Pokemon.class, true);
        grid.addColumn(Pokemon::getName).setHeader("Nombre");
        grid.addColumn(Pokemon::getAttack).setHeader("Ataque");
        grid.addColumn(Pokemon::getDefense).setHeader("Defensa");
        grid.addColumn(Pokemon::getTipo1).setHeader("Tipo1");
        grid.addColumn(Pokemon::getSpeedDefense).setHeader("Tipo2");
        inputs.add(comboBox);
        Button boton1 = new Button("Lee caracter",
                e -> {
                    String tipoPeticion = comboBox.getValue();
                    try {
                        results.removeAll();
                        results.add(service.leePokemon(tipoPeticion));
                    } catch (Exception ex) {
                    }
                });
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton1.addClickShortcut(Key.ENTER);
        addClassName("centered-content");
        add(inputs, boton1, results);
    }

}
