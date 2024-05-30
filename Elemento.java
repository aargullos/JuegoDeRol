package JuegoDeRol;

import java.util.Objects;

/**
 * Clase que representa un elemento en un juego de rol.
 */
public class Elemento {
    // Atributos
    private String nombre;
    private String arma;
    private String armadura;
    private String pociones;

    /**
     * Constructor para inicializar un objeto Elemento con valores específicos.
     *
     * @param nombre   Nombre del elemento.
     * @param arma     Arma del elemento.
     * @param armadura Armadura del elemento.
     * @param pociones Pociones del elemento.
     */
    public Elemento(String nombre, String arma, String armadura, String pociones) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.arma = arma;
        this.armadura = armadura;
        this.pociones = pociones;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getArma() {
        return arma;
    }

    public String getArmadura() {
        return armadura;
    }

    public String getPociones() {
        return pociones;
    }

    // Setters con validaciones
    public void setNombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    public void setPociones(String pociones) {
        this.pociones = pociones;
    }

    // Método toString para representar como una cadena de texto
    @Override
    public String toString() {
        return "Elemento{" +
                "nombre='" + nombre + '\'' +
                ", arma='" + arma + '\'' +
                ", armadura='" + armadura + '\'' +
                ", pociones='" + pociones + '\'' +
                '}';
    }
}
