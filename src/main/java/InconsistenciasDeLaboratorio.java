import Clases.Laboratorio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InconsistenciasDeLaboratorio {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeLaboratorio() throws IOException {
        while (true){
            System.out.println("Inconsistencias en Laboratorio de:");
            System.out.println("1. Tipo de Prueba.");
            System.out.println("2. Prueba.");
            System.out.println("0. Cancelar.");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                laboratorioSinTipoDePrueba();
                return;
            }
            else if (seleccion.equals("2")){
                laboratorioSinPruebas();
                return;
            }
            else if (seleccion.equals("0")){
                return;
            }
            else {
                System.out.println("Por favor, ingrese una opción válida: \"1\", \"2\" o \"0\"\n");
            }
        }
    }

    public static void laboratorioSinTipoDePrueba() throws IOException {
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
            System.out.println("Para agregar un Tipo de Prueba a un Laboratorio, acceda al menú:\n");
            System.out.println("Administración--->Tipos de Prueba--->Crear Tipos de Prueba.\n");
            System.out.println("Cree un Tipo de Prueba ingresando alguno de los NIT de ");
            System.out.println("Laboratorio existente que se muestra a continuación o ");
            System.out.println("seleccionelo directamente:");
            int contador=0;
            System.out.println("Número     NIT");
            for (Integer NIT : NITsinTipoPruebas){
                System.out.println(contador+1+"          "+NIT);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar Tipo de Prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    int NIT;
                    while (true){
                        System.out.println("Seleccione el número correspondiente al NIT de laboratorio al cual desea agregar el Tipo de Prueba:");
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
        else {
            System.out.println("No se encontraron inconsistencias:");
            System.out.println("Todos los Laboratorios tienen al menos un Tipo de Prueba asociado.\n");
        }
    }

    public static void laboratorioSinPruebas() throws IOException {
        System.out.println("Un laboratorio debe haber realizado al menos una Prueba,");
        System.out.println("se mostrarán los laboratorios que no hayan realizado ninguna:");
        boolean laboratorioSinPrueba = false;
        ArrayList<Integer> NITsinPruebas = new ArrayList<>();
        for (Laboratorio laboratorio : Main.laboratorios){
            if(laboratorio.IDprueba==1){
                System.out.println(laboratorio);
                NITsinPruebas.add(laboratorio.NIT);
                laboratorioSinPrueba = true;
            }
        }
        if (laboratorioSinPrueba){
            System.out.println("Para agregar una Prueba a un laboratorio, acceda al menú:\n");
            System.out.println("Administración--->Pruebas--->Crear Prueba.\n");
            System.out.println("Cree una Prueba ingresando alguno de los NIT de ");
            System.out.println("Laboratorio existente que se muestra a continuación o ");
            System.out.println("seleccionelo directamente:");
            int contador=0;
            System.out.println("Número     NIT");
            for (Integer NIT : NITsinPruebas){
                System.out.println(contador+1+"          "+NIT);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar Prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    int NIT;
                    while (true){
                        System.out.println("Seleccione el número correspondiente al NIT de laboratorio al cual desea agregar la Prueba:");
                        String ingreso = input.readLine();
                        int indice;
                        try{
                            indice=Integer.parseInt(ingreso);
                            NIT=NITsinPruebas.get(indice-1);
                            break;
                        } catch (Exception exc){
                            System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                            if(cancelarCreacion()){
                                return;
                            }
                        }
                    }
                    MenuPrueba.CrearPrueba("InconsistenciasPrueba","",Integer.toString(NIT));
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
            System.out.println("Todos los Laboratorios han realizado al menos una Prueba.\n");
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