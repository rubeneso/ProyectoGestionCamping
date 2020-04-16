package ficheros;

import java.io.*;
import java.util.Properties;
import logica.Param;

public class Ficheros {
    
    public static boolean cargarParametros(){
        File f = new File("data"+File.separator+"parametros.txt");
        if(!f.exists()) return false;
        
        Properties config = new Properties();
        try{
            config.load(new FileInputStream(f));
            Param.setPrecioEstadiaDiaTienda(Float.parseFloat(config.getProperty("PrecioEstadiaDiaTienda")));
            Param.setPrecioElectricidadDiaTienda(Float.parseFloat(config.getProperty("PrecioElectricidadDiaTienda")));
            Param.setPrecioDiaCaravana(Float.parseFloat(config.getProperty("PrecioDiaCaravana")));
            Param.setPrecioDiaCaravanaAgosto(Float.parseFloat(config.getProperty("PrecioDiaCaravanaAgosto")));
            Param.setPrecioAdultoDiaBungalow(Float.parseFloat(config.getProperty("PrecioAdultoDiaBungalow")));
            Param.setPorcentajeDescuentoTiendas(Float.parseFloat(config.getProperty("PorcentajeDescuentoTiendas")));
            Param.setEstadiaMinimaTiendaParaDescuento(Float.parseFloat(config.getProperty("EstadiaMinimaTiendaParaDescuento")));
            Param.setEstadiaMinimaCaravana(Float.parseFloat(config.getProperty("EstadiaMinimaCaravana")));
            Param.setEstadiaMinimaBungalow(Float.parseFloat(config.getProperty("EstadiaMinimaBungalow")));
            Param.setPorcentajeRecargoBungalow(Float.parseFloat(config.getProperty("PorcentajeRecargoBungalow")));
            
        }
        catch(IOException ex){
            System.err.println("Error: "+ex.getMessage());
        }
        
        return true;
    }
}
