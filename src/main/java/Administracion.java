import java.util.*;
import java.io.*;

public class Administracion {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void administrar(ArrayList<Experimento> experimentos,ArrayList<Muestra> muestras,ArrayList<Modelo> modelos,ArrayList<Informe> informes,ArrayList<Priori> distribucionesapriori,ArrayList<Posterior> distribucionposterior,ArrayList<Descriptiva> descriptivas,ArrayList<Inferencial> inferenciales, int[] IDs) throws IOException {
        while (true){
            System.out.println("1. Experimento.");
            System.out.println("2. Muestra.");
            System.out.println("3. Modelo.");
            System.out.println("4. Informe.");
            System.out.println("5. Distribución a-priori.");
            System.out.println("6. Distribución posterior.");
            System.out.println("7. Descriptiva.");
            System.out.println("8. Inferencial.");
            System.out.println("0. Cancelar");
            String opcionA =input.readLine();
            if (opcionA.equals("1")){
                admiExperimentos(experimentos);
                return;
            }else if(opcionA.equals("2")){

            }else if(opcionA.equals("3")){

            }else if(opcionA.equals("4")){

            }else if(opcionA.equals("5")){

            }else if(opcionA.equals("6")){

            }else if(opcionA.equals("7")){

            }else if(opcionA.equals("8")){

            }else if(opcionA.equals("0")){
                break;
            }else{
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static void admiExperimentos(ArrayList<Experimento> experimentos) throws IOException {
        System.out.println("1. Ver Experimento.");
        System.out.println("2. Crear Experimento.");
        System.out.println("3. Editar Experimento.");
        System.out.println("4. Eliminar Experimento.");
        System.out.println("0. Cancelar");
        String opcionA = input.readLine();
        if (opcionA.equals("1")){
            for (Experimento experimento : experimentos) {
                System.out.println(experimento);
            }
        }else if(opcionA.equals("2")){

        }else if(opcionA.equals("3")){

        }else if(opcionA.equals("4")){

        }else if(opcionA.equals("0")){
            return;
        }else{
            System.out.println("La opción ingresada no es válida");
        }
    }
}
