import java.util.*;
import java.io.*;



public class Main {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Experimento> experimentos = new ArrayList<>();
    public static ArrayList<Muestra> muestras = new ArrayList<>();
    public static ArrayList<Modelo> modelos = new ArrayList<>();
    public static ArrayList<Informe> informes = new ArrayList<>();
    public static ArrayList<Priori> distribucionesapriori = new ArrayList<>();
    public static ArrayList<Posterior> distribucionposterior = new ArrayList<>();
    public static ArrayList<Descriptiva> descriptivas = new ArrayList<>();
    public static ArrayList<Inferencial> inferenciales = new ArrayList<>();
    public static int [] IDs = new int[8];
    public static void main(String[] args) throws IOException {

        boolean condicion = true;
        while(condicion){
            System.out.println("1. Administración.");
            System.out.println("2. Búsqueda.");
            System.out.println("3. Diagnóstico de inconsistencias.");
            System.out.println("4. Guardar.");
            System.out.println("0. Salir");
            String opcion = input.readLine();
            if (opcion.equals("1")){
                Administracion.administrar(experimentos,muestras,modelos,informes,distribucionesapriori,distribucionposterior,descriptivas,inferenciales,IDs);
            }else if(opcion.equals("2")){

            }else if(opcion.equals("3")){

            }else if(opcion.equals("4")){

            }else if(opcion.equals("0")){
                while(true){
                    System.out.println("Al seleccionar esta opcion se perderan los cambios si no ha guardado");
                    System.out.println("Y. Salir del programa");
                    System.out.println("N. Permanecer en el programa");
                    opcion = input.readLine();
                    if (opcion.equals("Y")){
                        condicion = false;
                        break;
                    }else if (opcion.equals("N")){
                        break;
                    }else{
                        System.out.println("Por favor, inregese 'Y' o 'N' para continuar");
                    }
                }
            }
        }
    }

    public static void Ingresar(){
        System.out.println("Ingrese por favor su correo o contraseña");
    }
    public static void DistribucionAPriori(){
        
    }


}