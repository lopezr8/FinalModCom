import java.rmi.Remote;
import java.util.ArrayList;


public interface InterfaceBoutique extends Remote {
    String showGarments() throws java.rmi.RemoteException;
    void createGarment(int unidades, String nombre, int precio) throws java.rmi.RemoteException;
    void addMember(String nombre, String cedula, int type) throws java.rmi.RemoteException;
    boolean existeMiembro(String c) throws java.rmi.RemoteException;
    boolean existeCliente(String c) throws java.rmi.RemoteException;
    
}
