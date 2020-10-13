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
            System.out.println("0. Cancelar.");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                pruebaSinInforme();
                return;
            }
            else if (seleccion.equals("2")){
                pruebaSinDispositivo();
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

    public static void pruebaSinInforme() throws IOException {
        System.out.println("Una Prueba debe tener asociado un Informe,");
        System.out.println("se mostrarán las Pruebas que no tengan ninguno:");
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
        System.out.println("se mostrarán todas las Pruebas que no tengan ninguno:");
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
            System.out.println("correspondientes al ID de la Prueba a la cual desea agregar el dispositivo:");
            int contador=0;
            System.out.println("Número     ID");
            for (String ID : pruebasSinDispositivo){
                System.out.println(contador+1+"          "+ID);
                contador++;
            }
            while (true){
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
                    String refdispositivo="";
                    while (true) {
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
                                System.out.print("Referencia: ");
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
                                System.out.print("Referencia: ");
                                continue;
                            }
                        }
                        Dispositivos.add(refdispositivo);
                    }
                    if(Dispositivos.isEmpty()){
                        System.out.println("No ha agregado ningún dispositivo\n");
                        return;
                    }
                    else {
                        int indice = Collections.binarySearch(Main.pruebas,new Prueba(ID,"","","",new ArrayList<>()),new ComparadoresPrueba.ComparadorIDPrueba());
                        for(String referenciaNueva : Dispositivos){
                            Main.pruebas.get(indice).RefDispositivos.add(referenciaNueva);
                        }
                    }
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
            System.out.println("Todas las Pruebas tienen al menos un Dispositivo asociado\n");
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