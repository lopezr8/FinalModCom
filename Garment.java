public class Garment {
    private int unidades;
    private String nombre;
    private int precio;
    private int id;

    public Garment(int unidades, String nombre, int precio, int id) {
        this.unidades = unidades;
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }
    

    
    
}
