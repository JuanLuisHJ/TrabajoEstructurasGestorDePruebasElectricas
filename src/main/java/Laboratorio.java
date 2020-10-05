import java.util.ArrayList;

public class Laboratorio {
    public int ID;
    public String Nombre;
    public String Direccion;
    public ArrayList<Integer> Pruebas;
    public ArrayList<Integer> Zonas;

    public Laboratorio(int ID, String nombre, String direccion) {
        this.ID = ID;
        Nombre = nombre;
        Direccion = direccion;
        Pruebas = new ArrayList<>();
        Zonas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Laboratotio{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Pruebas=" + Pruebas +
                '}';
    }
}
