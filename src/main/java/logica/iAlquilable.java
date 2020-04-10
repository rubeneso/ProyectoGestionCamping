package logica;

public interface iAlquilable {

    //checkIn marca la parcela como ocupada
    boolean checkIn(String dniHuesped);
    
    //checkOut marca la parcela como libre y
    //calcula el importe a pagar en función de los parámetros del camping
    double checkOut();
}
