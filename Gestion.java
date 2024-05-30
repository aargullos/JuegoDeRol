package JuegoDeRol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gestion {
    // Atributos
    private List<Personaje> personajes;
    private List<Elemento> elementos;

    // Constructor
    public Gestion() {
        this.personajes = new ArrayList<>();
        this.elementos = new ArrayList<>();
    }

    // Métodos para gestionar personajes
    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public void eliminarPersonaje(String nombre) {
        personajes.removeIf(personaje -> personaje.getNombre().equals(nombre));
    }

    public List<Personaje> listarPersonajes() {
        return new ArrayList<>(personajes);
    }

    public Optional<Personaje> buscarPersonajePorNombre(String nombre) {
        return personajes.stream()
                .filter(personaje -> personaje.getNombre().equals(nombre))
                .findFirst();
    }

    // Métodos para gestionar elementos
    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(String nombre) {
        elementos.removeIf(elemento -> elemento.getNombre().equals(nombre));
    }

    public List<Elemento> listarElementos() {
        return new ArrayList<>(elementos);
    }

    public Optional<Elemento> buscarElementoPorNombre(String nombre) {
        return elementos.stream()
                .filter(elemento -> elemento.getNombre().equals(nombre))
                .findFirst();
    }
}
