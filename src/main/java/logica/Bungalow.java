package logica;

public class Bungalow extends Parcela{

    private int nHuepedes;
    private int numeroMenoresEdad;
    
    public Bungalow() {
        super();
    }
    
    public boolean checkIn(String dni, int nH,int nME){
        if(!super.checkIn(dni)) return false; //Se llama al metodo padre. Si no se puede hacer el checkIn devuelde falso
        if(nME > nH) return false; //Si el numero de menores de edad es mayor que el numero de huespedes no se hace checkIn
        nHuepedes = nH;
        numeroMenoresEdad = nME;
        
        return true;
    }
    
    @Override
    public double checkOut() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
