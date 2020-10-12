import Clases.Laboratorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InconsistenciasDeLaboratorio {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeLaboratorio() throws IOException {
        System.out.println("Un laboratorio debe tener al menos un tipo de prueba asociado,");
        System.out.println("se mostrarán los laboratorios que no tengan ninguno:");
        boolean laboratorioSinTipoPrueba = false;
        ArrayList<Integer> NITsinTipoPruebas = new ArrayList<>();
        for (Laboratorio laboratorio : Main.laboratorios){
            if(laboratorio.TipoPruebas.isEmpty()){
                System.out.println(laboratorio);
                NITsinTipoPruebas.add(laboratorio.NIT);
                laboratorioSinTipoPrueba = true;
            }
        }
        if (laboratorioSinTipoPrueba){
            System.out.println("Para agregar un tipo de prueba, acceda al menú:\n");
            System.out.println("Administración--->Tipos de Prueba--->Crear Tipos de prueba.\n");
            System.out.println("Cree un tipo de prueba ingresando alguno de los NIT de ");
            System.out.println("laboratorio existente que se muestra a continuación o ");
            System.out.println("seleccionelo directamente:");
            int contador=0;
            System.out.println("Número     NIT");
            for (Integer NIT : NITsinTipoPruebas){
                System.out.println(contador+1+"          "+NIT);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar tipo de prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    int NIT;
                    while (true){
                        System.out.println("Seleccione el número correspondiente al NIT de laboratorio al cual desea agregar el tipo de prueba:");
                        String ingreso = input.readLine();
                        int indice=-1;
                        try{
                            indice=Integer.parseInt(ingreso);
                            NIT=NITsinTipoPruebas.get(indice-1);
                            break;
                        } catch (Exception exc){
                            System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                            if(cancelarCreacion()){
                                return;
                            }
                        }
                    }
                    MenuTipoPrueba.CrearTipoPrueba("Inconsistencias",NIT);
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
