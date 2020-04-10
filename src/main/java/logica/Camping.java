package logica;

import java.util.ArrayList;

public class Camping {
    public static ArrayList <Parcela> parcelas = new ArrayList<>();
    
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
