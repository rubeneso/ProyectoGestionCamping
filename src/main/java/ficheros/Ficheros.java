package ficheros;

import java.io.*;
import java.util.Properties;
import logica.Camping;
import logica.Param;
import logica.Parcela;
import java.nio.file.Files;

/**
 * Clase que dispone de los métodos estáticos necesarios para la gestión de ficheros
 * @author Rubén Abellón
 * @version 1.0
 */
public class Ficheros {
    
    /**
     * Carga en la clase Parametros los valores almacenados en el archivo "data/parametros.txt"
     * @see logica.Param
     * @return <ul>
     * <li>true: Los parámetros se cargaron correctamente</li>
     * <li>false: Los parámetros no se han podido cargar</li>
     * </ul>
     */
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
            return false;
        }
        
        return true;
    }
    
    /**
     * Guarda el ArrayList "parcelas" de la clase Camping en el fichero "data/parcelas.dat"
     * @see logica.Camping
     */
    public static void guardarEstado() {
        try (FileOutputStream fos = new FileOutputStream("data"+File.separator+"parcelas.dat", false);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            for (int cont = 0; cont < Camping.parcelas.size(); cont++) {
                oos.writeObject(Camping.parcelas.get(cont));
            }
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
    }
    
    /**
     * Carga en el ArrayList "parcelas" de la clase Camping el ArrayList guardado en el fichero "data/parcelas.dat"
     * Si el fichero no existe se hace una copia del fichero "data/parcelasCopiaEnBlanco.dat" y se carga la copia.
     */
    public static void cargarEstado() {
        boolean eof = false;
        File fichero = new File("data"+File.separator+"parcelas.dat");
        if(!fichero.exists()){
            File fb = new File("data"+File.separator+"parcelasCopiaEnBlanco.dat");
            try{
                Files.copy(fb.toPath(), fichero.toPath());
            }
            catch(IOException ex){
                System.err.printf("Error:%s",ex.getMessage());
            }
        }
        try (FileInputStream fis = new FileInputStream(fichero);
                BufferedInputStream bufis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bufis)) 
        {
            while (!eof) { //while(bufis.available()>0
                Camping.parcelas.add((Parcela)ois.readObject());
            }
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
    }
    
    /**
     * Guarda en el archivo "data/facturas.csv" los datos del check out
     * @param str Cadena que contenga los datos del chek out separados por punto y coma
     */
    public static void facturar(String str){
        File f = new File("data"+File.separator+"facturas.csv");
        
        try(FileWriter fw = new FileWriter(f, true); BufferedWriter bfw = new BufferedWriter(fw)){
            bfw.write(str);
            bfw.newLine();
        }
        catch(IOException ex){
            System.err.println("Error: "+ex.getMessage());
        }
    }
}
