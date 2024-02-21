import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplementacionBoutique extends UnicastRemoteObject implements InterfaceBoutique {
    
    private ArrayList<Garment> garments = new ArrayList<Garment>();
    
    public ImplementacionBoutique() throws RemoteException {
        super();
    }

    public void createGarment(int unidades, String nombre, int precio) throws RemoteException{
        Garment garment = new Garment(unidades, nombre, precio);
        garments.add(garment);
    }

    public String showGarments() throws RemoteException{
        String mensaje="";
        for (int i = 0; i < garments.size(); i++) {
            mensaje += garments.get(i).getNombre();
        }
        return mensaje;
    }


    
}
