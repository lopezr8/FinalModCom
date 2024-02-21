import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionBoutique extends UnicastRemoteObject implements InterfaceBoutique {
    
    public ImplementacionBoutique() throws RemoteException {
        super();
    }

    public String decirHola(String nombre) throws RemoteException {
        return "Hola mundo " + nombre;
    }
}
