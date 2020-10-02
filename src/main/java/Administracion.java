import java.util.*;
import java.io.*;

public class Administracion {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void administrar(ArrayList<Experimento> experimentos,ArrayList<Muestra> muestras,ArrayList<Modelo> modelos,ArrayList<Informe> informes,ArrayList<Priori> distribucionesapriori,ArrayList<Posterior> distribucionposterior,ArrayList<Descriptiva> descriptivas,ArrayList<Inferencial> inferenciales) throws IOException {
        boolean condicionA = true;
        while (condicionA){
            System.out.println("1. Experimento.");
            System.out.println("2. Muestra.");
            System.out.println("3. Modelo.");
            System.out.println("4. Informe.");
            System.out.println("5. Distribución a-priori.");
            System.out.println("6. Distribución posterior.");
            System.out.println("7. Descriptiva.");
            System.out.println("8. Inferencial.");
            System.out.println("0. Salir");
            String opcionA =input.readLine();


        }
    }
}
