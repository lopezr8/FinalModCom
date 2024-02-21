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
    

    public void createGarment(int unidades, String nombre, int precio) throws RemoteException{
        Garment garment = new Garment(unidades, nombre, precio);
        garments.add(garment);
    }

    public String showGarments() throws RemoteException{
        String mensaje="";
        for (int i = 0; i < garments.size(); i++) {
            mensaje += garments.get(i).getNombre();
        }
        return mensaje;
    }


    public ArrayList<Garment> getGarments() {
        return garments;
    }

    public void setGarments(ArrayList<Garment> garments) {
        this.garments = garments;
    }

    public boolean existeCliente(String c) {

        for (int i = 0; i < clientes.size(); i++) {
            if(c == clientes.get(i).getCedula()){
                return true;
            }
        }
        return false;
    }
    public boolean existeMiembro(String c) {
        for (int i = 0; i < miembros.size(); i++) {
            if(c == miembros.get(i).getCedula()){
                return true;
            }
        }
        return false;
    }




    public void addMember(String nombre, String cedula, int type) {
        Member c = new Member(nombre, cedula, type);
        if(type == 1){
            this.clientes.add(c);
        }else{
            this.miembros.add(c);
        }
    }



    
}
