import Clases.Informe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InconsistenciasDeInforme {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeInforme() throws IOException {
        System.out.println("En caso de eliminar una Prueba, el Informe queda invalidado,");
        System.out.println("se mostrarán los Informes que no están asociados a ninguna Prueba:\n");
        boolean informeSinPrueba = false;
        for (Informe informe : Main.informes){
            if(informe.IDPrueba==-1){
                System.out.println(informe);
                informeSinPrueba = true;
            }
        }
        if (informeSinPrueba){
            System.out.println("Es necesario eliminar todos los Informes inválidos desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Informes\n");
            while (true){
                System.out.println("¿Desea eliminar el/los Informe/s ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.informes.size();borrador++){
                        if(Main.informes.get(borrador).IDPrueba==-1){
                            System.out.println("Borrando...   "+Main.informes.get(borrador));
                            Main.informes.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en los Informes");
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
            System.out.println("Todos los Informes están asociados a una Prueba.\n");
        }
    }
}