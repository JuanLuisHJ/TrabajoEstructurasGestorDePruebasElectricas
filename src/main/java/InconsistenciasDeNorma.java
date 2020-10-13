import Clases.Norma;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InconsistenciasDeNorma {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeNorma() throws IOException {
        System.out.println("Una Norma debe tener al menos una Clase asociada,");
        System.out.println("se mostrarán todas las Normas que no tengan ninguna:\n");
        boolean normaSinClase = false;
        ArrayList<String> normasSinclase = new ArrayList<>();
        for (Norma norma : Main.normas){
            if(norma.Clases.isEmpty()){
                System.out.println(norma);
                normasSinclase.add(norma.Referencia);
                normaSinClase = true;
            }
        }
        if (normaSinClase){
            System.out.println("Para agregar una Clase a una Norma, acceda al menú:\n");
            System.out.println("Administración--->Clase--->Crear Clase.\n");
            System.out.println("Cree una Clase ingresando alguna de las Referencias de ");
            System.out.println("Norma existente que se muestra a continuación o ");
            System.out.println("seleccionela directamente:");
            int contador=0;
            System.out.println("Número     Referencia");
            for (String referencia : normasSinclase){
                System.out.println(contador+1+"          "+referencia);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar Clase ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    String Referencia;
                    while (true){
                        System.out.print("Seleccione el número correspondiente a la Referencia de la Norma a la cual desea agregar la Clase: ");
                        String ingreso = input.readLine();
                        int indice;
                        try{
                            indice=Integer.parseInt(ingreso);
                            Referencia=normasSinclase.get(indice-1);
                            break;
                        } catch (Exception exc){
                            System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                            if(cancelarCreacion()){
                                return;
                            }
                        }
                    }
                    MenuClase.Crear("Inconsistencias",Referencia);
                    return;
                }
                else if(opcion.equals("2")){
                    return;
                }
                else{
                    System.out.println("Por favor, ingrese una opción válida: \"1\" o \"2\"\n");
                }
            }
        }
        else {
            System.out.println("No se encontraron inconsistencias:");
            System.out.println("Todas las Normas tienen al menos una Clase asociada.\n");
        }
    }
    public static boolean cancelarCreacion() throws IOException {
        while (true){
            System.out.println("¿Desea cancelar la creación?");
            System.out.println("1. SÍ");
            System.out.println("2. NO");
            String cancelar = input.readLine();
            if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                return true;
            }
            else if (cancelar.equals("2") || cancelar.equalsIgnoreCase("no")){
                return false;
            }
            else {
                System.out.println("Debe ingresar una opción: \"1\",\"si\" o \"2\",\"no\"");
            }
        }
    }
}
