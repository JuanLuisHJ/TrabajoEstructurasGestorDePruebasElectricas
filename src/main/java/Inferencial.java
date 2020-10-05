import java.util.ArrayList;
import java.util.Arrays;

public class Inferencial {
    public int ID;
    public ArrayList<Integer> Descriptiva;
    public ArrayList<Integer> Modelo;
    public String[][] Pruebas;
    public String[][] Estimaciones;


    public Inferencial(int ID, String[][] Pruebas, String[][] Estimaciones) {
        this.ID = ID;
        Descriptiva = new ArrayList<>();
        Modelo = new ArrayList<>();
        this.Pruebas = Pruebas;
        this.Estimaciones = Estimaciones;
    }

    public String toString(){
        String salida = "ID Inferencial:" + ID + "{\n";
        salida += "  Cantidad de Desceiptivas = "+ Descriptiva.size() + "\n";
        salida += "  Cantidad de modelos = " + Modelo.size() + "\n";
        salida += "  Pruebas = "+ Arrays.toString(Pruebas) + "\n";
        salida += "  Estimaciones = " + Arrays.toString(Estimaciones) + "\n";
        salida += "}\n";
        return salida;
    }
}