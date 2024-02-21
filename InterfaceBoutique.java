import java.rmi.Remote;

public interface InterfaceBoutique extends Remote {
    String decirHola(String nombre) throws java.rmi.RemoteException;
}
