import Clases.Dispositivo;
import Clases.Prueba;
import Comparadores.ComparadoresDispositivo;
import Comparadores.ComparadoresPrueba;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class InconsistenciasDePrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void InconsistenciasDePrueba() throws IOException {
        while (true){
            System.out.println("Inconsistencias en Prueba de:");
            System.out.println("1. Informe.");
            System.out.println("2. Dispositivos.");
            System.out.println("3. Tipo de Prueba.");
            System.out.println("4. Clase.");
            System.out.println("0. Cancelar.");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                pruebaSinInforme();
            }
            else if (seleccion.equals("2")){
                pruebaSinDispositivo();
            }
            else if (seleccion.equals("3")){
                pruebaSinTipoPrueba();
            }
            else if (seleccion.equals("4")){
                pruebaSinClase();
            }
            else if (seleccion.equals("0")){
                return;
            }
            else {
                System.out.println("Por favor, ingrese una opción válida: \"1\", \"2\", \"3\", \"4\" o \"0\"\n");
            }
        }
    }

    public static void pruebaSinInforme() throws IOException {
        System.out.println("Una Prueba debe tener asociado un Informe,");
        System.out.println("se mostrarán las Pruebas que no tengan ninguno:\n");
        boolean pruebaSinInforme = false;
        ArrayList<String> pruebasSinInforme = new ArrayList<>();
        for (Prueba prueba : Main.pruebas){
            if(prueba.NumInforme==-1){
                System.out.println(prueba);
                pruebasSinInforme.add(prueba.ID);
                pruebaSinInforme = true;
            }
        }
        if (pruebaSinInforme){
            System.out.println("Para agregar un Informe a una Prueba, acceda al menú:\n");
            System.out.println("Administración--->Informes--->Crear Informe.\n");
            System.out.println("Cree una Informe ingresando alguno de los ID de ");
            System.out.println("Prueba existente que se muestra a continuación o ");
            System.out.println("seleccionelo directamente:");
            int contador=0;
            System.out.println("Número     ID");
            for (String ID : pruebasSinInforme){
                System.out.println(contador+1+"          "+ID);
                contador++;
            }
            while (true){
                System.out.println("¿Desea agregar Informe ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    String ID;
                    while (true){
                        System.out.print("Seleccione el número correspondiente al ID de Prueba a la cual desea agregar el Informe: ");
                        String ingreso = input.readLine();
                        int indice;
                        try{
                            indice=Integer.parseInt(ingreso);
                            ID=pruebasSinInforme.get(indice-1);
                            break;
                        } catch (Exception exc){
                            System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                            if(cancelarCreacion()){
                                return;
                            }
                        }
                    }
                    MenuInforme.CrearInforme("Inconsistencias",ID);
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
            System.out.println("Todas las Pruebas tienen un Informe asociado.\n");
        }
    }

    public static void pruebaSinDispositivo() throws IOException {
        System.out.println("Una Prueba debe tener al menos un Dispositivo asociado,");
        System.out.println("se mostrarán todas las Pruebas que no tengan ninguno:\n");
        boolean pruebaSinDispositivo = false;
        ArrayList<String> pruebasSinDispositivo = new ArrayList<>();
        for (Prueba prueba : Main.pruebas){
            if(prueba.RefDispositivos.isEmpty()){
                System.out.println(prueba);
                pruebasSinDispositivo.add(prueba.ID);
                pruebaSinDispositivo = true;
            }
        }
        if (pruebaSinDispositivo){
            System.out.println("Para agregar un Dispositivo a una Prueba, seleccione uno de los números ");
            System.out.println("correspondientes al ID de la Prueba a la cual desea agregar el Dispositivo:");
            int contador=0;
            System.out.println("Número     ID");
            for (String ID : pruebasSinDispositivo){
                System.out.println(contador+1+"          "+ID);
                contador++;
            }
            System.out.println("¿Desea agregar Dispositivos ahora?");
            System.out.println("1. SÍ");
            System.out.println("2. NO");
            String opcion = input.readLine();
            if (opcion.equals("1")){
                String ID;
                while (true){
                    System.out.print("Seleccione el número correspondiente al ID de Prueba a la cual desea agregar Dispositivos: ");
                    String ingreso = input.readLine();
                    int indice;
                    try{
                        indice=Integer.parseInt(ingreso);
                        ID=pruebasSinDispositivo.get(indice-1);
                        break;
                    } catch (Exception exc){
                        System.out.println("Por favor, ingrese uno de los números de la lista anterior.\n");
                        if(cancelarCreacion()){
                            return;
                        }
                    }
                }
                ArrayList<String> Dispositivos = new ArrayList<>();
                System.out.println("Ingrese las referencias de los dispositivos, cuando haya ingresado todos los dispositivos ingrese fin:");
                String refdispositivo;
                while (true) {
                    System.out.print("referencia: ");
                    refdispositivo = input.readLine();
                    if (refdispositivo.equals("fin")){
                        break;
                    }
                    if(refdispositivo.equals("")){
                        System.out.println("No se ingresó ninguna referencia");
                        if(cancelarCreacion()){
                            return;
                        }
                        else{
                            continue;
                        }
                    }
                    int indexD = Collections.binarySearch(Main.dispositivos,new Dispositivo(refdispositivo,"",0,0), new ComparadoresDispositivo.ComparadorReferenciaDispositivo());
                    if (indexD<0){
                        System.out.println("El dispositivo no se encuentra en la base de datos\n");
                        if(cancelarCreacion()){
                            return;
                        }
                        else{
                            continue;
                        }
                    }
                    Dispositivos.add(refdispositivo);
                }
                if(Dispositivos.isEmpty()){
                    System.out.println("No se agregó ningún dispositivo\n");
                    return;
                }
                else {
                    int indice = Collections.binarySearch(Main.pruebas,new Prueba(ID,"","","",new ArrayList<>()),new ComparadoresPrueba.ComparadorIDPrueba());
                    for(String referenciaNueva : Dispositivos){
                        Main.pruebas.get(indice).RefDispositivos.add(referenciaNueva);
                    }
                    System.out.println("Se han agregado los dispositivos.\n");
                    return;
                }
            }
            else if(opcion.equals("2")){
                return;
            }
            else{
                System.out.println("Por favor, ingrese una opción válida: \"1\" o \"2\"\n");
            }
        }
        else {
            System.out.println("No se encontraron inconsistencias:");
            System.out.println("Todas las Pruebas tienen al menos un Dispositivo asociado\n");
        }
    }

    public static void pruebaSinTipoPrueba() throws IOException {
        System.out.println("En caso de eliminar un Tipo de Prueba, las Pruebas asociadas con este Tipo de Prueba quedan");
        System.out.println("invalidadas, se mostrarán las Pruebas que no tienen ningún Tipo de Prueba asociado:\n");
        boolean pruebaSinTipoDePrueba = false;
        for (Prueba prueba : Main.pruebas){
            if(prueba.TipoPrueba==null){
                System.out.println(prueba);
                pruebaSinTipoDePrueba = true;
            }
        }
        if (pruebaSinTipoDePrueba){
            System.out.println("Es necesario eliminar todas las Pruebas inválidas desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Pruebas--->Tipo de Prueba\n");
            while (true){
                System.out.println("¿Desea eliminar la/las Prueba/s ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.pruebas.size();borrador++){
                        if(Main.pruebas.get(borrador).TipoPrueba==null){
                            System.out.println("Borrando...   "+Main.pruebas.get(borrador));
                            Main.pruebas.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en las Pruebas por Tipo de Prueba\n");
                    System.out.println("Recuerde revisar las inconsistencias de Informes, dado que se han eliminado Pruebas\n");
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
            System.out.println("Todas las Pruebas tienen un Tipo de Prueba asociado.\n");
        }
    }

    public static void pruebaSinClase() throws IOException {
        System.out.println("En caso de eliminar una Clase, las Pruebas asociadas con esta Clase quedan");
        System.out.println("invalidadas, se mostrarán las Pruebas que no tienen ninguna Clase asociada:\n");
        boolean pruebaSinClase = false;
        for (Prueba prueba : Main.pruebas){
            if(prueba.Clase==null){
                System.out.println(prueba);
                pruebaSinClase = true;
            }
        }
        if (pruebaSinClase){
            System.out.println("Es necesario eliminar todas las Pruebas inválidas desde este menú:\n");
            System.out.println("Diagnóstico de inconsistencias--->Pruebas--->Clase\n");
            while (true){
                System.out.println("¿Desea eliminar la/las Prueba/s ahora?");
                System.out.println("1. SÍ");
                System.out.println("2. NO");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    for (int borrador=0;borrador< Main.pruebas.size();borrador++){
                        if(Main.pruebas.get(borrador).Clase==null){
                            System.out.println("Borrando...   "+Main.pruebas.get(borrador));
                            Main.pruebas.remove(borrador);
                        }
                    }
                    System.out.println("Se han eliminado las inconsistencias en las Pruebas por Clase\n");
                    System.out.println("Recuerde revisar las inconsistencias de Informes, dado que se han eliminado Pruebas\n");
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
            System.out.println("Todos las Pruebas tienen una Clase asociada.\n");
        }
    }

    public static boolean cancelarCreacion() throws IOException {
        while (true){
            System.out.println("¿Desea cancelar la adición?");
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