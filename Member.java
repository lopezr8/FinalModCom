import java.util.ArrayList;

public class Member {
    private String nombre;
    private String cedula;
    private int type;
    private ArrayList<Garment> garments = new ArrayList<Garment>();

    

    public Member(String nombre, String cedula, int type) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.type = type;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    
}
