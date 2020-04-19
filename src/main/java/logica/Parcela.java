package logica;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase abstracta que define las propiedades de una parcela de un camping
 * @author Rubén Abellón
 * @version 1.0
 */
public abstract class Parcela implements iAlquilable, Serializable{

    /**
     * Establece si la parcela esta ocupada o no lo está
     */
    protected boolean ocupada;

    /**
     * Almacena el DNI del huésped principal
     */
    protected String dniHuesped;

    /**
     * Almacena la fecha de entrada a la parcela
     */
    protected LocalDate fEntrada;
    
    /**
     *  Crea la parcela marcandola como no ocupada
     */
    public Parcela() {
        ocupada = false;
    }
    
    /**
     * Realiza el check in en una parcela, almacenando el DNI del huésped, fecha de entrada actual y marcando la parcela como ocupada
     * @param dni DNI del huésped principal
     * @return <ul>
     * <li>true: el check in se hizo correctamente</li>
     * <li>false: el check in no se pudo hacer</li>
     * </ul>
     */
    @Override
    public boolean checkIn(String dni){
        if(this.ocupada) return false;
        dniHuesped = dni;
        fEntrada = LocalDate.now();
        ocupada = true;
        
        return true;
    }
    
    /**
     * Realiza el check out de una parcela y la marca como libre
     * @return Devuelve el importe a cobrar al cliente. Devuelve -1 si la parcela está libre, y -2 si no ha transcurrido el tiempo de estadía mínima
     */
    @Override
    public abstract double checkOut();
    
    /**
     * Comprueba si una parcela está libre
     * @return <ul>
     * <li>true: la parcela está libre</li>
     * <li>false: la parcela está ocupada</li>
     * </ul>
     */
    public boolean estaLibre(){
        return !ocupada;
    }

    /**
     * Devuelve el DNI del huésped principal
     * @return Devuelve una String con el DNI del huésped principal
     */
    public String getDniHuesped() {
        return dniHuesped;
    }

    /**
     * Devuelve la fecha de entrada a la parcela
     * @return LocalDate con la fecha de entrada
     */
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
