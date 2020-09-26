import java.util.ArrayList;

public class Modelo {
    public Muestra Muestra;
    public ArrayList<Inferencial> Inferencias;
    public Posterior Posterior;
    public String TipoDeModelo;
    public Informe Informe;


    public Modelo(Muestra Muestra, ArrayList<Inferencial> Inferencias, Posterior Posterior, String TipoDeModelo, Informe Informe) {
        this.Muestra = Muestra;
        this.Inferencias = Inferencias;
        this.Posterior = Posterior;
        this.TipoDeModelo = TipoDeModelo;
        this.Informe = Informe;
    }

}