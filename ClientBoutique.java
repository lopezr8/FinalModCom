import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class ClientBoutique {
    public static void main(String[] args) {
        try {
            int numPuertoRMI;
            String nombreNodo;
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr); 
            System.out.println("Introducir el nombre del nodo del registro RMI");
            nombreNodo = br.readLine(); 
            System.out.println("Introducir el numero de puerto del registro RMI:");
            String numPuerto = br.readLine(); 
            numPuertoRMI = Integer.parseInt(numPuerto); 
            String URLRegistro = "rmi://"+nombreNodo+":"+numPuertoRMI+"/helloworldRMI";
            InterfaceBoutique h = (InterfaceBoutique)Naming.lookup(URLRegistro); 
            System.out.println("Busqueda completa");
            
            String mensaje = h.decirHola("Edgar R.");
            System.out.println("Hola mundo Cliente "+mensaje);



        } catch (Exception e) {
            System.out.println("Excepcion en hola mundo cliente"+e);
        }
    }
    
}
