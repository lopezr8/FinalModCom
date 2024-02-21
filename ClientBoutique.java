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
            System.out.println("----------------------------------------------");
            iniciarSesion(br,h);


            h.createGarment(10, "pantalon", 100000);


            String mensaje = h.showGarments();
            System.out.println("Hola mundo Cliente "+mensaje);

        } catch (Exception e) {
            System.out.println("Excepcion en hola mundo cliente"+e);
        }
    }

    private static void iniciarSesion(BufferedReader br, InterfaceBoutique h) {
        try {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("Bienvenido al cliente");
                System.out.println("si es un cliente regular presione 1\n si es miembro de la empresa presione 2");
                
                String opcion = br.readLine().trim();

                switch (opcion) {
                    case "1":
                        menuCliente(br,h);
                        salir = true;
                        break;
                    case "2":
                        menuMiembro(br,h);
                        salir = true;
                        break;
                    
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    private static void menuMiembro(BufferedReader br, InterfaceBoutique h) throws Exception{
        validarCedula(br,2,h);    
    }

    private static void menuCliente(BufferedReader br, InterfaceBoutique h) throws Exception{
        validarCedula(br,1,h);

        try {
            boolean salir = false;
    
            while (!salir) {
                System.out.println("Menú Cliente:");
                System.out.println("1. Comprar Ropa");
                System.out.println("2. Listar Stock de la Boutique");
                System.out.println("3. Reporte de Compra");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
    
                String opcion = br.readLine().trim();
    
                switch (opcion) {
                    case "1":
                        comprarRopa(br, h);
                        break;
                    case "2":
                        listarStockBoutique(h);
                        break;
                    case "3":
                        generarReporteCompra(br, h);
                        break;
                    case "4":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    //metodos para el menú clinete 

    private static void comprarRopa(BufferedReader br, InterfaceBoutique h) throws Exception {
        System.out.println("Stock actual de la boutique:");
        for (Garment garment : garments) {
            System.out.println(garment.getNombre() + " - Unidades disponibles: " + garment.getUnidades());
        }
    }
    
    private static void listarStockBoutique(InterfaceBoutique h) throws Exception {
        
    }
    
    private static void generarReporteCompra(BufferedReader br, InterfaceBoutique h) throws Exception {
        
    }

    //fin de los metodos para el menú cliente 



    
    private static void validarCedula(BufferedReader br, int i, InterfaceBoutique h) throws Exception {
        String cedula = obtenerInputNoVacio(br, "Digite su cedula");
        if(i ==1){
            if (!h.existeCliente(cedula) ){
                createMember(cedula,1,h,br );
            }else{

            }
        }else{
            if (!h.existeMiembro(cedula) ){
                createMember(cedula, 2,h,br);
            }else{
                
            }
        }

    }

    private static void createMember(String cedula, int i, InterfaceBoutique h, BufferedReader br) throws Exception {
       System.out.println("Crear cuenta ");
       String nombre = obtenerInputNoVacio(br, "Digite su nombre"); 
       h.addMember(nombre, cedula, i);
    }

    private static String obtenerInputNoVacio(BufferedReader br, String string) throws Exception{
        boolean b = true;
        String input = "";
        
        while (b) {
            System.out.println(string);
            input = br.readLine();
            
            if (input.length() > 0) {
                b = false;
            }
        }
        return input;
    }
}
