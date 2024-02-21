import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class ServerBoutique {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in); 
        BufferedReader br = new BufferedReader(isr); 
        String numPuerto, URLRegistro;
        try {
            System.out.println("Introducir el numero de puerto del registro RMI: ");
            numPuerto = br.readLine();
            int numPuertoRMI = Integer.parseInt(numPuerto);
            arrancarRegistro(numPuertoRMI);
            ImplementacionBoutique objExportado = new ImplementacionBoutique(); 
            URLRegistro = "rmi://localhost:"+numPuerto+"/helloworldRMI"; 
            Naming.rebind(URLRegistro, objExportado);
            System.out.println("Servidor registrado. El registro contiene actualmente: ");
            listaRegistro(URLRegistro);
            System.out.println("Servidor hola mundo preparado");

        } catch (Exception e) {
            System.out.println("Excepcion en hola mundo servidor.main: " +e);
        }
    }

    private static void listaRegistro(String uRLRegistro) throws RemoteException, MalformedInputException, MalformedURLException{
        System.out.println("Registro"+uRLRegistro+"contiene:");
        String[] nombres = Naming.list(uRLRegistro);
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
        
    }

    private static void arrancarRegistro(int numPuertoRMI) throws RemoteException{
        try {
            Registry registro = LocateRegistry.getRegistry(numPuertoRMI); 
            registro.list();
        } catch (Exception e) {
            System.out.println("El registro RMI no se puede localizar en el puerto"+numPuertoRMI);
            @SuppressWarnings("unused")
            Registry registro = LocateRegistry.createRegistry(numPuertoRMI); 
            System.out.println("Registro RMI creado en el puerto"+numPuertoRMI); 

        }

        
    }

    
    
}