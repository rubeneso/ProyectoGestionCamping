package logica;

import ficheros.Ficheros;

public class pruebas {

    public static void main(String[] args) {
        Ficheros.cargarParametros();
        Camping.llenarArray();
        
        Bungalow c = new Bungalow();
        c.checkIn("1", 2, 1);
        System.out.println(c.checkOut());
        Camping.parcelas.get(0).checkIn("2");
//        for (int i = 0; i < Camping.parcelas.size(); i++) {
//            System.out.println(Camping.parcelas.get(i).toString());
//        }
        System.out.println(Camping.parcelas.get(0).toString());
        System.out.println(Camping.parcelas.get(0).checkOut());
        System.out.println(Camping.parcelas.get(0).toString());
    }
    
}
