package logica;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class Parcela implements iAlquilable, Serializable{

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
        ocupada = true;
        
        return true;
    }
    
    @Override
    public abstract double checkOut();
    
    public boolean estaLibre(){
        return !ocupada;
    }

    public String getDniHuesped() {
        return dniHuesped;
    }

    public LocalDate getfEntrada() {
        return fEntrada;
    }
    
    @Override
    public String toString() {
        if(ocupada){
            return "Parcela{" + "ocupada=" + ocupada + ", dniHuesped=" + dniHuesped + ", fEntrada=" + fEntrada + '}';
        }
        else{
            return "Parcela{" + "ocupada=" + ocupada+ '}';
        }
    }
    
}
