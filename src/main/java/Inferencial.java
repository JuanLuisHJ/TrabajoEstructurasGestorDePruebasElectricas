
public class Inferencial {
    public int ID;
    public int Descriptiva;
    public int Modelo;
    public String[][] Pruebas;
    public String[][] Estimaciones;


    public Inferencial(int ID,int Descriptiva, int Modelo, String[][] Pruebas, String[][] Estimaciones) {
        this.ID = ID;
        this.Descriptiva = Descriptiva;
        this.Modelo = Modelo;
        this.Pruebas = Pruebas;
        this.Estimaciones = Estimaciones;
    }

}