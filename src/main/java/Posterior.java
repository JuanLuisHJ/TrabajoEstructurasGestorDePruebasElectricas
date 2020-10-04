public class Posterior {
    public int ID;
    public int Priori;
    public int Modelo;
    public String[] Parametros;

    public Posterior(int ID, int Priori, int Modelo, String[] Parametros) {
        this.ID = ID;
        this.Priori = Priori;
        this.Modelo = Modelo;
        this.Parametros = Parametros;
    }
    
}