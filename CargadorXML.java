package JuegoDeRol;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class CargadorXML {

    public static void cargarPersonajesDesdeXML(String archivo, Gestion gestion) {
        try {
            // Se carga y normaliza el archivo XML
            File inputFile = new File(archivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("personatge");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String nombre = obtenerValorElemento(eElement, "nom");
                    int nivel = Integer.parseInt(obtenerValorElemento(eElement, "nivell"));
                    int puntosDeVida = Integer.parseInt(obtenerValorElemento(eElement, "puntsDeVida"));
                    int puntosDeMana = Integer.parseInt(obtenerValorElemento(eElement, "puntsDeMana"));
                    String arma = obtenerValorElemento(eElement, "arma");
                    String armadura = obtenerValorElemento(eElement, "armadura");

                    // Se crean instancias de Personaje y Elemento y se agregan a Gestion
                    Personaje personaje = new Personaje(nombre, nivel, puntosDeVida, puntosDeMana);
                    gestion.agregarPersonaje(personaje);

                    Elemento elemento = new Elemento(nombre, arma, armadura, "");
                    gestion.agregarElemento(elemento);
                }
            }
        } catch (ParserConfigurationException e) {
            System.err.println("Error en la configuración del parser XML: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("Error al parsear el archivo XML: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al leer el archivo XML: " + e.getMessage());
        } catch (DOMException e) {
            System.err.println("Error al procesar el documento XML: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número del XML: " + e.getMessage());
        }
    }

    /**
     * Método para obtener el valor de un elemento XML por su nombre.
     *
     * @param eElement El elemento XML.
     * @param tagName  El nombre del tag.
     * @return El valor del elemento, o una cadena vacía si no se encuentra.
     */
    private static String obtenerValorElemento(Element eElement, String tagName) {
        NodeList nodeList = eElement.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node != null) {
                return node.getTextContent();
            }
        }
        return "";
    }
}
