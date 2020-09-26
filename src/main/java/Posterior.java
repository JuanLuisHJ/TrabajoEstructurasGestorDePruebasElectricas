public class Posterior {
    public Priori Priori;
    public Modelo Modelo;
    public String[] Parametros;

    public Posterior(Priori Priori, Modelo Modelo, String[] Parametros) {
        this.Priori = Priori;
        this.Modelo = Modelo;
        this.Parametros = Parametros;
    }
    
}