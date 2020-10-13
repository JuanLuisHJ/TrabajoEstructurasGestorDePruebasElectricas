import Clases.TipoPrueba;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InconsistenciasDeTipoDePrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeTipoDePrueba() throws IOException  {
        System.out.println("Un Tipo de Prueba debe tener al menos una Prueba asociada,");
        System.out.println("se mostrarán todos los Tipos que no tengan ninguna:");
        boolean tipodepruebasinpruebas = false;
        ArrayList<String> tiposDePruebaSinPruebas = new ArrayList<>();
        for (TipoPrueba tipoprueba : Main.tipopruebas){
            if(tipoprueba.Pruebas.isEmpty()){
                System.out.println(tipoprueba);
                tiposDePruebaSinPruebas.add(tipoprueba.Nombre);
                tipodepruebasinpruebas = true;
            }
        }
        if (tipodepruebasinpruebas){
            System.out.println("Para agregar una Prueba a un Tipo de Prueba, acceda al menú:\n");
            System.out.println("Administración--->Pruebas--->Crear Prueba.\n");
            System.out.println("Cree una Prueba ingresando alguno de los nombres de");
            System.out.println("tipo de prueba existente que se muestra a continuación o ");
            System.out.println("seleccionelo directamente:");
            int contador = 0;
            System.out.println("Número     Nombre Tipo de Prueba");
            for(String nombre : tiposDePruebaSinPruebas){
                System.out.println(contador+1+"          "+nombre);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar Prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    String nombreTipoDePrueba;
                    while (true){
                        System.out.print("Seleccione el número correspondiente al Nombre del Tipo de Prueba al cual desea agregar la Prueba: ");
                        String ingreso = input.readLine();
                        int indice;
                        try{
                            indice=Integer.parseInt(ingreso);
                            nombreTipoDePrueba=tiposDePruebaSinPruebas.get(indice-1);
                            break;
                        } catch (Exception exc){
                            System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                            if(cancelarCreacion()){
                                return;
                            }
                        }
                    }
                    MenuPrueba.CrearPrueba("InconsistenciasTipoPrueba",nombreTipoDePrueba,"");
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
            System.out.println("Todos los Tipos de Prueba tienen al menos una Prueba asociada\n");
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