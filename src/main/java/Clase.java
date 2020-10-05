import java.util.ArrayList;

public class Clase {
    public int ID;
    public String Nombre;
    public ArrayList<Integer> ElementosPrueba;
    public int Norma;
    public double VoltajePrueba;
    public double CorrientePrueba;
    public double VoltajeMaximo;
    public double CorrienteMaxima;
    public double Tiempo;

    public Clase(int ID, String nombre, int norma, double voltajePrueba, double corrientePrueba, double voltajeMaximo, double corrienteMaxima, double tiempo) {
        this.ID = ID;
        Nombre = nombre;
        Norma = norma;
        VoltajePrueba = voltajePrueba;
        CorrientePrueba = corrientePrueba;
        VoltajeMaximo = voltajeMaximo;
        CorrienteMaxima = corrienteMaxima;
        Tiempo = tiempo;
        ElementosPrueba = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Clase{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", ElementosPrueba=" + ElementosPrueba +
                ", Norma=" + Norma +
                ", VoltajePrueba=" + VoltajePrueba +
                ", CorrientePrueba=" + CorrientePrueba +
                ", VoltajeMaximo=" + VoltajeMaximo +
                ", CorrienteMaxima=" + CorrienteMaxima +
                ", Tiempo=" + Tiempo +
                '}';
    }
}
