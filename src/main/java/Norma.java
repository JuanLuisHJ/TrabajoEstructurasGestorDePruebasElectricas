import java.util.ArrayList;

public class Norma {
    public int ID;
    public String Nombre;
    public String Referencia;
    public int Prueba;
    public ArrayList<Integer> Clases;

    public Norma(int ID, String nombre, String referencia, int prueba) {
        this.ID = ID;
        Nombre = nombre;
        Referencia = referencia;
        Prueba = prueba;
        Clases = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Norma{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Referencia='" + Referencia + '\'' +
                ", Prueba=" + Prueba +
                ", Clases=" + Clases +
                '}';
    }
}
