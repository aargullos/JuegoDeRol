package JuegoDeRol;


 // Clase que representa un personaje en un juego de rol.

public class Personaje {
    // Atributos
    private String nombre;
    private int nivel;
    private int puntosDeVida;
    private int puntosDeMana;

    // Constantes para los límites de los atributos
    private static final int NIVEL_MINIMO = 1;
    private static final int NIVEL_MAXIMO = 100;
    private static final int PUNTOS_DE_VIDA_MINIMOS = 0;
    private static final int PUNTOS_DE_VIDA_MAXIMOS = 1000;
    private static final int PUNTOS_DE_MANA_MINIMOS = 0;
    private static final int PUNTOS_DE_MANA_MAXIMOS = 500;

    /**
     * Constructor para inicializar un objeto Personaje con valores específicos.
     *
     * @param nombre        Nombre del personaje.
     * @param nivel         Nivel del personaje.
     * @param puntosDeVida  Puntos de vida del personaje.
     * @param puntosDeMana
     */
    public Personaje(String nombre, int nivel, int puntosDeVida, int puntosDeMana) {
        this.nombre = nombre;
        setNivel(nivel);
        setPuntosDeVida(puntosDeVida);
        setPuntosDeMana(puntosDeMana);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getPuntosDeMana() {
        return puntosDeMana;
    }

    // Setters con validaciones
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        if (nivel >= NIVEL_MINIMO && nivel <= NIVEL_MAXIMO) {
            this.nivel = nivel;
        } else {
            throw new IllegalArgumentException("El nivel debe estar entre " + NIVEL_MINIMO + " y " + NIVEL_MAXIMO);
        }
    }

    public void setPuntosDeVida(int puntosDeVida) {
        if (puntosDeVida >= PUNTOS_DE_VIDA_MINIMOS && puntosDeVida <= PUNTOS_DE_VIDA_MAXIMOS) {
            this.puntosDeVida = puntosDeVida;
        } else {
            throw new IllegalArgumentException("Los puntos de vida deben estar entre " + PUNTOS_DE_VIDA_MINIMOS + " y " + PUNTOS_DE_VIDA_MAXIMOS);
        }
    }

    public void setPuntosDeMana(int puntosDeMana) {
        if (puntosDeMana >= PUNTOS_DE_MANA_MINIMOS && puntosDeMana <= PUNTOS_DE_MANA_MAXIMOS) {
            this.puntosDeMana = puntosDeMana;
        } else {
            throw new IllegalArgumentException("Los puntos de maná deben estar entre " + PUNTOS_DE_MANA_MINIMOS + " y " + PUNTOS_DE_MANA_MAXIMOS);
        }
    }

    // Métodos adicionales
    public void incrementarPuntosDeVida(int cantidad) {
        setPuntosDeVida(this.puntosDeVida + cantidad);
    }

    public void decrementarPuntosDeVida(int cantidad) {
        setPuntosDeVida(this.puntosDeVida - cantidad);
    }

    public void incrementarPuntosDeMana(int cantidad) {
        setPuntosDeMana(this.puntosDeMana + cantidad);
    }

    public void decrementarPuntosDeMana(int cantidad) {
        setPuntosDeMana(this.puntosDeMana - cantidad);
    }

    // Método toString para representar como una cadena de texto
    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosDeVida=" + puntosDeVida +
                ", puntosDeMana=" + puntosDeMana +
                '}';
    }
}
