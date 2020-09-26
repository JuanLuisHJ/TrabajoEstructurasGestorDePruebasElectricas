import java.util.*;

public class Priori {
    public ArrayList<Muestra> Muestras;
    public Posterior Posterior;
    public boolean Informativa;
    public String[] Parametros;

    public Priori(ArrayList<Muestra> Muestras, Posterior Posterior, boolean Informativa, String[] Parametros) {
        this.Muestras = Muestras;
        this.Posterior = Posterior;
        this.Informativa = Informativa;
        this.Parametros = Parametros;
    }

}