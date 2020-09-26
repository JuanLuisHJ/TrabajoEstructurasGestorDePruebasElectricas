import java.util.ArrayList;
public class Muestra {
    public ArrayList<Modelo> Modelos;
    public Descriptiva Descriptiva;
    public Priori Priori;
    public Experimento Experimento;
    public boolean Independencia;


    public Muestra(ArrayList<Modelo> Modelos, Descriptiva Descriptiva, Priori Priori, Experimento Experimento, boolean Independencia) {
        this.Modelos = Modelos;
        this.Descriptiva = Descriptiva;
        this.Priori = Priori;
        this.Experimento = Experimento;
        this.Independencia = Independencia;
    }
    
}