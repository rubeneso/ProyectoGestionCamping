package logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Parcela de camping de tipo tienda de campaña
 * @author Rubén Abellón
 * @version 1.0
 */
public class TiendaCampanha extends Parcela{

    /**
     * Constructor por defecto, llama al constructor padre.
     */
    public TiendaCampanha() {
        super();
    }
    
    @Override
    public double checkOut(){
        if(!this.ocupada) return -1;
        this.ocupada = false;
        long dias = ChronoUnit.DAYS.between(fEntrada, LocalDate.now());
        if(dias < Param.getEstadiaMinimaTiendaParaDescuento()){
            float precio = (float)dias * (Param.getPrecioEstadiaDiaTienda() + Param.getPrecioElectricidadDiaTienda());
            return Math.round(precio * 100)/100;
        }
        else{
            float precio = (float)dias * (Param.getPrecioEstadiaDiaTienda() + Param.getPrecioElectricidadDiaTienda());
            float precioFinal = precio - (precio * Param.getPorcentajeDescuentoTiendas() / 100);
            return Math.round(precioFinal * 100)/100;
        }
    }
    
}
