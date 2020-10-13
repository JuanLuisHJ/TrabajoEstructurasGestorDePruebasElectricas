import Clases.Clase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InconsistenciasDeClase {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeClase() throws IOException {
        System.out.println("En caso de eliminar una Norma, las Clases asociadas quedan invalidadas,");
        System.out.println("se mostrarán las Clases que no están asociadas a ninguna Norma:");
        boolean claseSinNorma = false;
        for (Clase clase : Main.clases){
            if(clase.Norma==null){
                System.out.println(clase);
                claseSinNorma = true;
            }
        }
        if (claseSinNorma){
            System.out.println("Es necesario eliminar todas las Clases inválidas desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Clases\n");
            while (true){
                System.out.println("¿Desea eliminar la/las Clase/s ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.clases.size();borrador++){
                        if(Main.clases.get(borrador).Norma==null){
                            System.out.println("Borrando...   "+Main.clases.get(borrador));
                            Main.clases.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en las Clases");
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
            System.out.println("Todos las Clases están asociados a una Norma.\n");
        }
    }
}