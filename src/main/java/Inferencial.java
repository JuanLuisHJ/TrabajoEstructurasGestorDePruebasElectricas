import sun.net.www.content.text.plain;

public class Inferencial {
    
    public Descriptiva Descriptiva;
    public Modelo Modelo;
    public String[][] Pruebas;
    public String[][] Estimaciones;


    public Inferencial(Descriptiva Descriptiva, Modelo Modelo, String[][] Pruebas, String[][] Estimaciones) {
        this.Descriptiva = Descriptiva;
        this.Modelo = Modelo;
        this.Pruebas = Pruebas;
        this.Estimaciones = Estimaciones;
    }

}