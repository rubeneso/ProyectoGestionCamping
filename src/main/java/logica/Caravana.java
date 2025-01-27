package logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Parcela de camping de tipo caravana
 * @author Rubén Abellón
 * @version 1.0
 */
public class Caravana extends Parcela{

    /**
     * Constructor por defecto, llama al constructor padre.
     */
    public Caravana() {
        super();
    }
    
    @Override
    public double checkOut() {
        if(!this.ocupada) return -1;
        long dias = ChronoUnit.DAYS.between(fEntrada, LocalDate.now());
        if(dias < Param.getEstadiaMinimaCaravana()){
            return -2;
        }
        else{
            this.ocupada = false;
            if(LocalDate.now().getMonthValue() == 8) return (float)dias * Param.getPrecioDiaCaravanaAgosto();
            else {
                float precio = (float)dias * Param.getPrecioDiaCaravana();
                return Math.round(precio * 100)/100;
            }
        }
    }
    
}
