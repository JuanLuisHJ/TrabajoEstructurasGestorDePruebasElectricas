import java.util.ArrayList;

public class TipoPrueba {
    public int ID;
    public String Nombre;
    public int Norma;
    public ArrayList<Integer> ElementosPrueba;
    public int Laboratorio;
    public int Seccion;

    public TipoPrueba(int ID, String nombre, int norma, int laboratorio, int seccion) {
        this.ID = ID;
        Nombre = nombre;
        Norma = norma;
        Laboratorio = laboratorio;
        Seccion = seccion;
        ElementosPrueba = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TipoPrueba{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Norma=" + Norma +
                ", ElementosPrueba=" + ElementosPrueba +
                ", Laboratorio=" + Laboratorio +
                ", Seccion=" + Seccion +
                '}';
    }
}
