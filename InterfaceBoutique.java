import java.rmi.Remote;



public interface InterfaceBoutique extends Remote {
    String showGarments() throws java.rmi.RemoteException;
    void createGarment(int unidades, String nombre, int precio,int id) throws java.rmi.RemoteException;
    void addMember(String nombre, String cedula, int type) throws java.rmi.RemoteException;
    boolean existeMiembro(String c) throws java.rmi.RemoteException;
    boolean existeCliente(String c) throws java.rmi.RemoteException;
    Garment searchGarment(int id)throws java.rmi.RemoteException;
    void editGarment(int unidades, String nombre, int precio,int id) throws java.rmi.RemoteException; 
    void deleteGarment(int id)  throws java.rmi.RemoteException; 
    
}
