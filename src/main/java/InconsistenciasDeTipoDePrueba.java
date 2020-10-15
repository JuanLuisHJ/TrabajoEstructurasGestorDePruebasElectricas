import Clases.TipoPrueba;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InconsistenciasDeTipoDePrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDeTipoDePrueba() throws IOException  {
        while (true){
            System.out.println("Inconsistencias en Tipo de Prueba de:");
            System.out.println("1. Pruebas.");
            System.out.println("2. Norma.");
            System.out.println("3. Laboratorio.");
            System.out.println("0. Cancelar.");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                tipoDePruebaSinPruebas();
            }
            else if (seleccion.equals("2")){
                tipoDePruebaSinNorma();
            }
            else if (seleccion.equals("3")){
                tipoDePruebaSinLaboratorio();
            }
            else if (seleccion.equals("0")){
                return;
            }
            else {
                System.out.println("Por favor, ingrese una opción válida: \"1\", \"2\", \"3\" o \"0\"\n");
            }
        }
    }

    public static void tipoDePruebaSinPruebas() throws IOException {
        System.out.println("Un Tipo de Prueba debe tener al menos una Prueba asociada,");
        System.out.println("se mostrarán todos los Tipos que no tengan ninguna:\n");
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
                        System.out.print("Seleccione el número de la lista anterior correspondiente al Nombre del Tipo de Prueba al cual desea agregar la Prueba: ");
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

    public static void tipoDePruebaSinNorma() throws IOException {
        System.out.println("En caso de eliminar una Norma, los Tipos de Prueba asociados con esta Norma quedan");
        System.out.println("invalidados, se mostrarán los Tipos de Prueba que no tengan ninguna Norma asociada:\n");
        boolean tipoDePruebaSinNorma = false;
        for (TipoPrueba tipoprueba : Main.tipopruebas){
            if(tipoprueba.RefNorma==null){
                System.out.println(tipoprueba);
                tipoDePruebaSinNorma = true;
            }
        }
        if (tipoDePruebaSinNorma){
            System.out.println("Es necesario eliminar todas los Tipos de Prueba inválidos desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Tipos de Prueba--->Norma\n");
            while (true){
                System.out.println("¿Desea eliminar el/los Tipo/s de Prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.tipopruebas.size();borrador++){
                        if(Main.tipopruebas.get(borrador).RefNorma==null){
                            System.out.println("Borrando...   "+Main.tipopruebas.get(borrador));
                            Main.tipopruebas.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en los Tipos de Prueba por Norma\n");
                    System.out.println("Recuerde revisar las inconsistencias de Pruebas, dado que se han eliminado Tipos de Prueba\n");
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
            System.out.println("Todos los Tipos de Prueba tienen una Norma asociada.\n");
        }
    }

    public static void tipoDePruebaSinLaboratorio() throws IOException {
        System.out.println("En caso de eliminar un Laboratorio, el Tipo de Prueba asociado al Laboratorio queda");
        System.out.println("invalidado, se mostrarán los Tipos de Prueba que no están asociados a un Laboratorio:\n");
        boolean tipoPruebasinLaboratorio = false;
        for (TipoPrueba tipoprueba : Main.tipopruebas){
            if(tipoprueba.NitLaboratorio==-1){
                System.out.println(tipoprueba);
                tipoPruebasinLaboratorio = true;
            }
        }
        if (tipoPruebasinLaboratorio){
            System.out.println("Es necesario eliminar todos los Tipos de Prueba inválidos desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Tipos de Prueba--->Laboratorio\n");
            while (true){
                System.out.println("¿Desea eliminar el/los Tipo/s de Prueba ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.tipopruebas.size();borrador++){
                        if(Main.tipopruebas.get(borrador).NitLaboratorio==-1){
                            System.out.println("Borrando...   "+Main.tipopruebas.get(borrador));
                            Main.tipopruebas.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en los Tipos de Prueba por Laboratorio\n");
                    System.out.println("Recuerde revisar las inconsistencias de Prueba, dado que se han eliminado Tipos de Prueba\n");
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
            System.out.println("Todos los Tipos de Prueba están asociados a un Laboratorio.\n");
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