import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplementacionBoutique extends UnicastRemoteObject implements InterfaceBoutique {
    
    private ArrayList<Garment> garments = new ArrayList<Garment>();
    private ArrayList<Member> clientes = new ArrayList<Member>();
    private ArrayList<Member> miembros = new ArrayList<Member>();
    
    public ImplementacionBoutique() throws RemoteException {
        super();
    } 
    

    public void createGarment(int unidades, String nombre, int precio,int id) throws RemoteException{
        Garment garment = new Garment(unidades, nombre, precio,id);
        garments.add(garment);
    }

    public void editGarment(int unidades, String nombre, int precio,int id) throws RemoteException {
        Garment g = searchGarment(id);
        g.setUnidades(unidades);
        g.setNombre(nombre);
        g.setPrecio(precio);
    }

    public Garment searchGarment(int id) throws RemoteException  {
        for (int i = 0; i < garments.size(); i++) {
            if(garments.get(i).getId()==id) return garments.get(i);
        }
        return null;
    }

    public int searchGarmentIndex(int id)   {
        for (int i = 0; i < garments.size(); i++) {
            if(garments.get(i).getId()==id) return i;
        }
        return -1;
    }

    public void deleteGarment(int id) throws RemoteException {
        int index = searchGarmentIndex(id);
        if(index != -1) this.garments.remove(index);
    }



    public String showGarments() throws RemoteException{
        String mensaje="";
        if(garments.size()==0) return mensaje="No hay productos agregados";
        for (int i = 0; i < garments.size(); i++) {
            mensaje +="id: "+garments.get(i).getId()  +" -- "+ "Nombre: "+ garments.get(i).getNombre()+ "--"+"Precio: "+garments.get(i).getPrecio()+"--"+"Unidades: "+garments.get(i).getUnidades() + "\n";
        }
        return mensaje;
    }

    public boolean existeCliente(String c) throws RemoteException {

        for (int i = 0; i < clientes.size(); i++) {
            if(c.equalsIgnoreCase(clientes.get(i).getCedula()) ){
                return true;
            }
        }
        return false;
    }
    public boolean existeMiembro(String c) throws RemoteException {
        
        for (int i = 0; i < miembros.size(); i++) {
            if(c.equalsIgnoreCase(miembros.get(i).getCedula()) ){
                return true;
            }
        }
        return false;
    }

    public void addMember(String nombre, String cedula, int type) throws RemoteException {
        Member c = new Member(nombre, cedula, type);
        if(type == 1){
            this.clientes.add(c);
        }else{
            this.miembros.add(c);
        }
    }



    
}
