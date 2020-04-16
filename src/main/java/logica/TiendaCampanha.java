package logica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TiendaCampanha extends Parcela{

    public TiendaCampanha() {
        super();
    }
    
    @Override
    public double checkOut(){
        if(!this.ocupada) return -1;
        this.ocupada = false;
        long dias = ChronoUnit.DAYS.between(fEntrada, LocalDate.now());
        if(dias < Param.getEstadiaMinimaTiendaParaDescuento()){
            return (float)dias * (Param.getPrecioEstadiaDiaTienda() + Param.getPrecioElectricidadDiaTienda());
        }
        else{
            float precio = (float)dias * (Param.getPrecioEstadiaDiaTienda() + Param.getPrecioElectricidadDiaTienda());
            return precio - (precio * Param.getPorcentajeDescuentoTiendas() / 100);
        }
    }
    
}
