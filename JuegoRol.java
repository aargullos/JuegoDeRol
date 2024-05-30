package JuegoDeRol;

import java.io.File;

public class JuegoRol {
    public static void main(String[] args) {
        // Crear una instancia de Gestion
        Gestion gestion = new Gestion();

        // Ruta del archivo XML
        String archivoXML = "personatges.xml";

        // Comprobar si el archivo XML existe
        File file = new File(archivoXML);
        if (file.exists() && !file.isDirectory()) {
            // Cargar personajes desde el XML
            try {
                CargadorXML.cargarPersonajesDesdeXML(archivoXML, gestion);

                // Listar personajes cargados
                System.out.println("Personajes cargados desde XML:");
                listarPersonajes(gestion);

                // Listar elementos cargados
                System.out.println("Elementos cargados desde XML:");
                listarElementos(gestion);

            } catch (Exception e) {
                System.err.println("Error al cargar los personajes desde el archivo XML: " + e.getMessage());
            }
        } else {
            System.err.println("El archivo XML no existe o no es un archivo válido: " + archivoXML);
        }
    }


     //Método para listar los personajes cargados en la gestión.

    private static void listarPersonajes(Gestion gestion) {
        for (Personaje personaje : gestion.listarPersonajes()) {
            System.out.println(personaje);
        }
    }


    private static void listarElementos(Gestion gestion) {
        for (Elemento elemento : gestion.listarElementos()) {
            System.out.println(elemento);
        }
    }
}
