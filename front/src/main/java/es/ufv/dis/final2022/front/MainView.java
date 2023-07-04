package es.ufv.dis.final2022.front;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    private final VerticalLayout content1;
    private final Tab userTab;
    private final Tab rolTab;
    private final Tab nombreTab1;

    Grid<User> grid1;
    VerticalLayout inputsTipoV1;
    VerticalLayout inputsNombreV1;


    private final VerticalLayout content;
    private final Tab pokemonTab;
    private final Tab tipoTab;
    private final Tab nombreTab;
    private final Tab atkTab;

    Grid<Pokemon> grid;
    VerticalLayout inputsTipoV;
    VerticalLayout inputsNombreV;
    VerticalLayout inputsAtkV;



    public MainView(@Autowired ParamsService service) {


        VerticalLayout layout = new VerticalLayout();
        inputsTipoV = new VerticalLayout();
        inputsNombreV = new VerticalLayout();
        inputsAtkV = new VerticalLayout();
        HorizontalLayout inputsTipo = new HorizontalLayout();
        HorizontalLayout inputsNombre = new HorizontalLayout();
        HorizontalLayout inputsAtk = new HorizontalLayout();
        VerticalLayout titulos = new VerticalLayout();
        content = new VerticalLayout();


        H1 titulo = new H1("Pokedex");
        H2 subtitulo = new H2("Seleccione una pestaña para ver todos los Pokemons, buscar por nombre o por tipo");
        titulo.getStyle().set("align-self", "center").set("margin", "10px");
        subtitulo.getStyle().set("align-self", "center").set("margin","2px");
        titulos.add(titulo, subtitulo);

        ArrayList<Pokemon> listaPokemonsNombre = new ArrayList<Pokemon>();


        grid = new Grid<>(Pokemon.class, false);
        grid.addColumn(Pokemon::getName).setHeader("Nombre").setSortable(true);
        grid.addColumn(Pokemon::getAttack).setHeader("Ataque").setSortable(true);
        grid.addColumn(Pokemon::getDefense).setHeader("Defensa").setSortable(true);
        grid.addColumn(Pokemon::getTipo1).setHeader("Tipo 1").setSortable(true);
        grid.addColumn(Pokemon::getTipo2).setHeader("Tipo 2").setSortable(true);
        grid.getStyle().set("margin", "10px");
        grid.setHeight("700px");

        Grid<Pokemon> gridTipo = new Grid<>(Pokemon.class, false);
        gridTipo.addColumn(Pokemon::getName).setHeader("Nombre").setSortable(true);
        gridTipo.addColumn(Pokemon::getAttack).setHeader("Ataque").setSortable(true);
        gridTipo.addColumn(Pokemon::getDefense).setHeader("Defensa").setSortable(true);
        gridTipo.addColumn(Pokemon::getTipo1).setHeader("Tipo 1").setSortable(true);
        gridTipo.addColumn(Pokemon::getTipo2).setHeader("Tipo 2").setSortable(true);
        gridTipo.getStyle().set("margin", "10px");
        gridTipo.setHeight("700px");

        Grid<Pokemon> gridNombre = new Grid<>(Pokemon.class, false);
        gridNombre.addColumn(Pokemon::getName).setHeader("Nombre").setSortable(true);
        gridNombre.addColumn(Pokemon::getAttack).setHeader("Ataque").setSortable(true);
        gridNombre.addColumn(Pokemon::getDefense).setHeader("Defensa").setSortable(true);
        gridNombre.addColumn(Pokemon::getTipo1).setHeader("Tipo 1").setSortable(true);
        gridNombre.addColumn(Pokemon::getTipo2).setHeader("Tipo 2").setSortable(true);
        gridNombre.getStyle().set("margin", "10px");
        gridNombre.setHeight("700px");

        Grid<Pokemon> gridAtk = new Grid<>(Pokemon.class, false);
        gridAtk.addColumn(Pokemon::getName).setHeader("Nombre").setSortable(true);
        gridAtk.addColumn(Pokemon::getAttack).setHeader("Ataque").setSortable(true);
        gridAtk.addColumn(Pokemon::getDefense).setHeader("Defensa").setSortable(true);
        gridAtk.addColumn(Pokemon::getTipo1).setHeader("Tipo 1").setSortable(true);
        gridAtk.addColumn(Pokemon::getTipo2).setHeader("Tipo 2").setSortable(true);
        gridAtk.getStyle().set("margin", "10px");
        gridAtk.setHeight("700px");

        try{
            grid.setItems(service.leePokemons());

        } catch (Exception ex) {
            Notification.show("Error al leer el Pokémon");
        }

        TextField datosTipo = new TextField("Introduce el Tipo");
        Button botonTipo = new Button("Buscar", e -> {
            String dato = datosTipo.getValue();
            try{
                gridTipo.setItems(service.leePokemonPorTipo(dato));
            } catch (Exception ex) {
                Notification.show("Error al leer el tipo del Pokémon");
            }
        });
        botonTipo.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonTipo.addClickShortcut(Key.ENTER);
        //addClassName("centered-content");

        TextField datosNombre = new TextField("Introduce el Nombre");
        Button botonNombre = new Button("Buscar", e -> {
            String dato = datosNombre.getValue();
            try{
                listaPokemonsNombre.clear(); // Limpiar la lista antes de agregar los resultados del filtro
                listaPokemonsNombre.add(service.leePokemonPorNombre(dato));
                gridNombre.setItems(listaPokemonsNombre);
            } catch (Exception ex) {
                Notification.show("Error al leer el nombre del Pokémon");
            }
        });
        botonNombre.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonNombre.addClickShortcut(Key.ENTER);
        addClassName("stretch");

        /////////////////////    SI QUIERES UNO QUE VAYA POR INT UTILIZA ESTE  /////////////////////

        TextField datosAtk = new TextField("Introduce el Ataque");
        Button botonAtk = new Button("Buscar", e -> {
            String dato = datosAtk.getValue();
            try {
                listaPokemonsNombre.clear(); // Limpiar la lista antes de agregar los resultados del filtro
                List<Pokemon> pokemonsEncontrados = service.leePokemonPorAtk(dato);
                listaPokemonsNombre.addAll(pokemonsEncontrados);
                gridAtk.setItems(listaPokemonsNombre);
            } catch (Exception ex) {
                ex.printStackTrace(); // Imprimir la pila de excepciones en la consola
                Notification.show("Error al leer el ataque del pokemon: " + ex.getMessage());
            }
        });
        botonAtk.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonAtk.addClickShortcut(Key.ENTER);

        inputsTipo.add(datosTipo, botonTipo);
        inputsNombre.add(datosNombre, botonNombre);
        inputsAtk.add(datosAtk, botonAtk);
        inputsTipoV.add(inputsTipo,gridTipo);
        inputsNombreV.add(inputsNombre,gridNombre);
        inputsAtkV.add(inputsAtk,gridAtk);


        pokemonTab = new Tab("General");
        tipoTab = new Tab("Buscar Por Tipo");
        nombreTab = new Tab("Buscar Por Nombre");
        atkTab = new Tab("Buscar Por Ataque");
        Tabs tabSheet = new Tabs(pokemonTab, tipoTab, nombreTab, atkTab);
        pokemonTab.getStyle().set("width", "34%");
        tipoTab.getStyle().set("width", "33%");
        nombreTab.getStyle().set("width", "33%");
        atkTab.getStyle().set("width", "33%");
        tabSheet.getStyle().set("width", "100%");
        tabSheet.addSelectedChangeListener(event ->
                setContent(event.getSelectedTab())
        );
        setContent(tabSheet.getSelectedTab());

        layout.add(titulos, tabSheet, content);
        add(layout);




        /////////////////////////////////////////////////////////////////////////////////////////




        VerticalLayout layout1 = new VerticalLayout();
        inputsTipoV1 = new VerticalLayout();
        inputsNombreV1 = new VerticalLayout();
        HorizontalLayout inputsRol = new HorizontalLayout();
        HorizontalLayout inputsNombre1 = new HorizontalLayout();
        VerticalLayout titulos1 = new VerticalLayout();
        content1 = new VerticalLayout();


        H1 titulo1 = new H1("Usuarios");
        H2 subtitulo1 = new H2("Seleccione una pestaña para ver todos los usuarios, buscar por nombre o por rol");
        titulo1.getStyle().set("align-self", "center").set("margin", "10px");
        subtitulo1.getStyle().set("align-self", "center").set("margin","2px");
        titulos1.add(titulo1, subtitulo1);

        ArrayList<User> listaUsersNombre = new ArrayList<User>();


        grid1 = new Grid<>(User.class, false);
        grid1.addColumn(User::getName).setHeader("Nombre").setSortable(true);
        grid1.addColumn(User::getEmail).setHeader("Email").setSortable(true);
        grid1.addColumn(user -> String.join(", ", user.getRoles())).setHeader("Roles").setSortable(true);
        grid1.addColumn(User::isAdmin).setHeader("Admin").setSortable(true);
        grid1.getStyle().set("margin", "10px");
        grid1.setHeight("700px");

        Grid<User> gridRol = new Grid<>(User.class, false);
        gridRol.addColumn(User::getName).setHeader("Nombre").setSortable(true);
        gridRol.addColumn(User::getEmail).setHeader("Email").setSortable(true);
        gridRol.addColumn(user -> String.join(", ", user.getRoles())).setHeader("Roles").setSortable(true);
        gridRol.addColumn(User::isAdmin).setHeader("Admin").setSortable(true);
        gridRol.getStyle().set("margin", "10px");
        gridRol.setHeight("700px");

        Grid<User> gridNombre1 = new Grid<>(User.class, false);
        gridNombre1.addColumn(User::getName).setHeader("Nombre").setSortable(true);
        gridNombre1.addColumn(User::getEmail).setHeader("Email").setSortable(true);
        gridNombre1.addColumn(user -> String.join(", ", user.getRoles())).setHeader("Roles").setSortable(true);
        gridNombre1.addColumn(User::isAdmin).setHeader("Admin").setSortable(true);
        gridRol.getStyle().set("margin", "10px");
        gridRol.setHeight("700px");

        try{
            grid1.setItems(service.leeUsers());

        } catch (Exception ex) {
            Notification.show("Error al leer el usuario");
        }


        TextField datosRol = new TextField("Introduce el Rol");
        Button botonRol = new Button("Buscar", e -> {
            String dato = datosRol.getValue();
            try{
                gridRol.setItems(service.leeUserPorRol(dato));
            } catch (Exception ex) {
                Notification.show("Error al leer el rol del usuario");
            }
        });
        botonRol.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonRol.addClickShortcut(Key.ENTER);
        //addClassName("centered-content");

        TextField datosNombre1 = new TextField("Introduce el Nombre");
        Button botonNombre1 = new Button("Buscar", e -> {
            String dato = datosNombre1.getValue();
            try{
                listaUsersNombre.clear(); // Limpiar la lista antes de agregar los resultados del filtro
                listaUsersNombre.add(service.leeUserPorNombre(dato));
                gridNombre1.setItems(listaUsersNombre);
            } catch (Exception ex) {
                Notification.show("Error al leer el nombre del usuario");
            }
        });
        botonNombre1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        botonNombre1.addClickShortcut(Key.ENTER);
        addClassName("stretch");

        inputsRol.add(datosRol, botonRol);
        inputsNombre1.add(datosNombre1, botonNombre1);
        inputsTipoV1.add(inputsRol,gridRol);
        inputsNombreV1.add(inputsNombre1,gridNombre1);


        userTab = new Tab("General");
        rolTab = new Tab("Buscar Por Rol");
        nombreTab1 = new Tab("Buscar Por Nombre");
        Tabs tabSheet1 = new Tabs(userTab, rolTab, nombreTab1);
        userTab.getStyle().set("width", "34%");
        rolTab.getStyle().set("width", "33%");
        nombreTab1.getStyle().set("width", "33%");
        tabSheet1.getStyle().set("width", "100%");
        tabSheet1.addSelectedChangeListener(event ->
                setContent1(event.getSelectedTab())
        );
        setContent1(tabSheet1.getSelectedTab());

        layout1.add(titulos1, tabSheet1, content1);
        add(layout1);
    }

    private void setContent(Tab tab) {
        content.removeAll();

        if (tab.equals(pokemonTab)) {
            content.add(grid);
        } else if (tab.equals(tipoTab)) {
            content.add(inputsTipoV);
        } else if (tab.equals(nombreTab)){
            content.add(inputsNombreV);
        } else if (tab.equals(atkTab)) {
            content.add(inputsAtkV);
        } else {
            content.add(new Paragraph("Seleccione una Pestaña."));
        }
    }

    private void setContent1(Tab tab) {
        content1.removeAll();

        if (tab.equals(userTab)) {
            content1.add(grid1);
        } else if (tab.equals(rolTab)) {
            content1.add(inputsTipoV1);
        } else if (tab.equals(nombreTab1)){
            content1.add(inputsNombreV1);
        } else {
            content1.add(new Paragraph("Seleccione una Pestaña."));
        }
    }

}
