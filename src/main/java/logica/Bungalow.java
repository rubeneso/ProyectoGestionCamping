package logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Parcela de camping de tipo bungalow
 * @author Rubén Abellón
 * @version 1.0
 */
public class Bungalow extends Parcela{

    /**
     * Almacena el número de huéspedes de la parcela
     */
    private int nHuepedes;
    
    /**
     * Almacena el número de menores de edad de una parcela
     */
    private int numeroMenoresEdad;
    
    /**
     * Constructor por defecto, llama al constructor padre.
     */
    public Bungalow() {
        super();
    }
    
    /**
     * Realiza un check in como el heredado, y además almacena los parámetros añadidos de esta subclase
     * @param dni DNI del huésped principal
     * @param nH Número de huéspedes
     * @param nME Número de huéspedes que son menores de edad
     * @return <ul>
     * <li>true: el check in se hizo correctamente</li>
     * <li>false: el check in no se pudo hacer</li>
     * </ul>
     */
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
