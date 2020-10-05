import java.util.ArrayList;

public class Zona {
    public int ID;
    public String Nombre;
    public int Laboratorio;
    public ArrayList<Integer> Pruebas;
    public ArrayList<Integer> Dispositivos;

    public Zona(int ID, String nombre, int laboratorio) {
        this.ID = ID;
        Nombre = nombre;
        Laboratorio = laboratorio;
        Pruebas = new ArrayList<>();
        Dispositivos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Zona{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Laboratorio=" + Laboratorio +
                ", Pruebas=" + Pruebas +
                ", Dispositivos=" + Dispositivos +
                '}';
    }
}
