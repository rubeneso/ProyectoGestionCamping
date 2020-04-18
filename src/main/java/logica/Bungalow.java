package logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bungalow extends Parcela{

    private int nHuepedes;
    private int numeroMenoresEdad;
    
    public Bungalow() {
        super();
    }
    
    public boolean checkIn(String dni, int nH,int nME){
        if(!super.checkIn(dni)) return false;
        //Se llama al metodo padre. Si no se puede hacer el checkIn devuelde falso
        if(nME > nH) {
            ocupada = false;
            return false;
        } //Si el numero de menores de edad es mayor que el numero de huespedes no se hace checkIn
        nHuepedes = nH;
        numeroMenoresEdad = nME;
        
        return true;
    }
    
    @Override
    public double checkOut() {
        if(!this.ocupada) return -1;
        this.ocupada = false;
        long dias = ChronoUnit.DAYS.between(fEntrada, LocalDate.now());
        if(dias < Param.getEstadiaMinimaBungalow()){
            float precio = (float)dias * (Param.getPrecioAdultoDiaBungalow() * (nHuepedes - numeroMenoresEdad));
            float precioFinal = precio + (precio * Param.getPorcentajeRecargoBungalow() / 100);
            return Math.round(precioFinal * 100)/100;
        }
        else{
            float precio =  (float)dias * (Param.getPrecioAdultoDiaBungalow() * (nHuepedes - numeroMenoresEdad));
            return Math.round(precio * 100)/100;
        }
    }

    @Override
    public String toString() {
        if(ocupada){
            return "Parcela{" + "ocupada=" + ocupada + ", dniHuesped=" + dniHuesped + ", fEntrada=" + fEntrada + "nHuepedes=" + nHuepedes + ", numeroMenoresEdad=" + numeroMenoresEdad + '}';
        }
        else{
            return "Parcela{" + "ocupada=" + ocupada+ '}';
        }
    }
    
    
}
