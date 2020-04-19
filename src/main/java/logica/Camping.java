package logica;

import java.util.ArrayList;

/**
 * Clase que almacena las distintas parcelas que se administran en la interfaz gráfica en un ArrayList
 * @author Rubén Abellón
 * @version 1.0
 */
public class Camping {

    /**
     * ArrayList de Parcela que almacena las parcelas y sus atributos
     */
    public static ArrayList <Parcela> parcelas = new ArrayList<>();
    
    /**
     * Llena el ArrayList "parcelas"
     */
    public static void llenarArray(){
        for (int i = 0; i < 10; i++) {
            parcelas.add(new TiendaCampanha());
        }
        for (int i = 0; i < 20; i++) {
            parcelas.add(new Caravana());
        }
        for (int i = 0; i < 50; i++) {
            parcelas.add(new Bungalow());
        }
        
    }
}
