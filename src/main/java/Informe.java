import java.util.ArrayList;

public class Informe {
    public int ID;
    public int Elemento;
    public boolean Resultado;
    public String Comentarios;
    public double Temperatura;
    public double Humedad;

    public Informe(int ID, int elemento, boolean resultado, String comentarios, double temperatura, double humedad) {
        this.ID = ID;
        Elemento = elemento;
        Resultado = resultado;
        Comentarios = comentarios;
        Temperatura = temperatura;
        Humedad = humedad;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "ID=" + ID +
                ", Elemento=" + Elemento +
                ", Resultado=" + Resultado +
                ", Comentarios='" + Comentarios + '\'' +
                ", Temperatura=" + Temperatura +
                ", Humedad=" + Humedad +
                '}';
    }
}