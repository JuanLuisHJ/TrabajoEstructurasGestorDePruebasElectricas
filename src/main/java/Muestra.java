import java.util.ArrayList;
public class Muestra {
    public int ID;
    public ArrayList<Integer> Modelos;
    public int Descriptiva;
    public int Priori;
    public int Experimento;
    public boolean Independencia;

    public Muestra(int ID,int Descriptiva, int Priori, int experimento, boolean Independencia) {
        this.ID = ID;
        Modelos = new ArrayList<>();
        this.Descriptiva = Descriptiva;
        this.Priori = Priori;
        Experimento = experimento;
        this.Independencia = Independencia;
    }
}