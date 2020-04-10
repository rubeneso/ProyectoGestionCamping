package logica;

import java.time.LocalDate;


public abstract class Parcela implements iAlquilable{

    protected boolean ocupada;
    protected String dniHuesped;
    protected LocalDate fEntrada;
    
    public Parcela() {
        ocupada = false;
    }
    
    @Override
    public boolean checkIn(String dni){
        if(this.ocupada) return false;
        dniHuesped = dni;
        fEntrada = LocalDate.now();
        
        return false;
    }
    
    @Override
    public abstract double checkOut();
}
