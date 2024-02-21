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


            //h.createGarment(10, "pantalon", 100000);


            //String mensaje = h.showGarments();
            //System.out.println("Hola mundo Cliente "+mensaje);

        } catch (Exception e) {
            System.out.println("Excepcion en hola mundo cliente"+e);
        }
    }

    private static void iniciarSesion(BufferedReader br, InterfaceBoutique h) {
        try {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("Bienvenido a FashionBoutique");
                System.out.println("-------------------------------");
                System.out.println("si es un cliente regular presione 1\n si es miembro de la empresa presione 2 \n si desea salir presione 3");
                
                String opcion = br.readLine().trim();

                switch (opcion) {
                    case "1":
                        menuCliente(br,h);
                        break;
                    case "2":
                        menuMiembro(br,h);
                        break;
                    case "3":
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
        try {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("Bienvenido al menu de miembros de la empresa ");
                System.out.println("---------------------------------------------");
                System.out.println("1. Agregar producto ");
                System.out.println("2. Editar producto ");
                System.out.println("3. Eliminar producto ");
                System.out.println("4. Salir ");
                System.out.println("---------------------------------------------");
                System.out.println("Digite una opción valida: ");
    
                String opcion = br.readLine().trim();

                switch (opcion) {
                    case "1":
                        agregaProducto(br,h);
                        
                        break;
                    case "2":
                        editaProducto(br,h);
                        
                        break;

                    case "3":
                        eliminaProducto(br,h);
                        
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

    private static void eliminaProducto(BufferedReader br, InterfaceBoutique h) throws Exception {

        boolean b = true;
        while(b){
            System.out.println(h.showGarments());
            System.out.println("-----------------------------");
            String id = obtenerInputNoVacio(br, "digite el id del producto que desea eliminar(solo numeros), o si desea salir digite -1");
            int idn = Integer.parseInt(id.trim());

            if(idn == -1 ){
               b = false;
               continue;
            }
            if (h.searchGarment(idn) != null){
                h.deleteGarment(idn);
                System.out.println("Eliminado con exito");
            }
            else{
                System.out.println("Producto no existe");
            }    

        }     
        
    }

    private static void editaProducto(BufferedReader br, InterfaceBoutique h) throws Exception {
        boolean b = true;
        while(b){
            System.out.println(h.showGarments());
            System.out.println("-----------------------------");
            String id = obtenerInputNoVacio(br, "digite el id del producto que desea editar(solo numeros), o si desea salir digite -1");
            int idn = Integer.parseInt(id.trim());

            if(idn == -1 ){
               b = false;
               continue;
            }
                

            if (h.searchGarment(idn) != null){
                boolean c = true;
                while(c){
                    System.out.println("EDITAR PRODUCTO");
                    System.out.println("---------------------");
                    System.out.println("1. editar nombre");
                    System.out.println("2. editar precio");
                    System.out.println("3. editar cantidad de unidades");
                    System.out.println("4. salir");

                    String opcion = br.readLine().trim();
                    switch (opcion) {
                        case "1":
                        String nombre = obtenerInputNoVacio(br, "nuevo nombre");
                            h.editGarment(h.searchGarment(idn).getUnidades(), nombre, h.searchGarment(idn).getPrecio(), idn);
                            break;
                        case "2":
                            String precio = obtenerInputNoVacio(br, "Precio del producto");
                            h.editGarment(h.searchGarment(idn).getUnidades(),h.searchGarment(idn).getNombre(),Integer.parseInt(precio.trim()), idn);
                            break;
    
                        case "3":
                            String unidades = obtenerInputNoVacio(br, "cantidad de unidades");
                            h.editGarment(Integer.parseInt(unidades.trim()), h.searchGarment(idn).getNombre(), h.searchGarment(idn).getPrecio(), idn);
                            break;
                        case "4":
                            c = false;
                            break;
                        
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }

                }
                
            }else{
                System.out.println("Producto no existe");
            }

        }
    }

    private static void agregaProducto(BufferedReader br, InterfaceBoutique h) throws Exception {
        boolean b = true;
        while(b){
            System.out.println(h.showGarments());
            System.out.println("-----------------------------");
            String id = obtenerInputNoVacio(br, "digite el id del nuevo producto(solo numeros), o si desea salir digite -1");
            int idn = Integer.parseInt(id.trim());

            if(idn == -1 ){
               b = false;
               continue;
            }
                

            if (h.searchGarment(idn) == null ){
                String nombre = obtenerInputNoVacio(br, "digite el nombre del nuevo producto");
                String unidades = obtenerInputNoVacio(br, "cantidad de unidades");
                String precio = obtenerInputNoVacio(br, "Precio del producto");
                int ud = Integer.parseInt(unidades.trim());
                int pd = Integer.parseInt(precio.trim());
                h.createGarment(ud, nombre, pd, idn);
                System.out.println("Producto creado con exito!");
                b = false;
            }else{
                System.out.println("Producto ya existe");
            }

        }


        
    }

    private static void menuCliente(BufferedReader br, InterfaceBoutique h) throws Exception{
        validarCedula(br,1,h);
    }
    
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
