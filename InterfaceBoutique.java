import java.rmi.Remote;


public interface InterfaceBoutique extends Remote {
    String showGarments() throws java.rmi.RemoteException;
    void createGarment(int unidades, String nombre, int precio) throws java.rmi.RemoteException;
    
}
