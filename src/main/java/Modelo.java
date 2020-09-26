import java.util.*;

public class Modelo {
    public Muestra Muestra;
    public Arraylist<Inferencial> Inferencias;
    public Posterior Posterior;
    public String TipoDeModelo;
    public Informe Informe;


    public Modelo(Muestra Muestra, Arraylist<Inferencial> Inferencias, Posterior Posterior, String TipoDeModelo, Informe Informe) {
        this.Muestra = Muestra;
        this.Inferencias = Inferencias;
        this.Posterior = Posterior;
        this.TipoDeModelo = TipoDeModelo;
        this.Informe = Informe;
    }

}