import java.io.*;

public class Administracion {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void administrar() throws IOException {
        while (true) {
            System.out.println("Administrar:");
            menuDeClases();
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                MenuLaboratorio.munuLaboratorio();
                return;
            } else if (opcionA.equals("2")) {
                MenuTipoPrueba.munuTipoPrueba();
                return;
            } else if (opcionA.equals("3")) {
                MenuPrueba.munuPrueba();
                return;
            } else if (opcionA.equals("4")) {
                MenuInforme.MenuInforme();
                return;
            } else if (opcionA.equals("5")) {
                MenuDispositivo.MenuDispositivo();
                return;
            } else if (opcionA.equals("6")) {
                MenuNorma.MenuNorma();
                return;
            } else if (opcionA.equals("7")) {
                MenuClase.MenuClase();
                return;
            }else if (opcionA.equals("0")) {
                return;
            } else {
                System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\" o \"0\"\n");
            }
        }
    }
    public static void busqueda() throws IOException {
        while (true) {
            System.out.println("Buscar:");
            menuDeClases();
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                MenuBusquedaLaboratorio.menubusquedaLaboratorio();
                return;
            } else if (opcionA.equals("2")) {
                MenuBusquedaTipoPrueba.menubusquedaTipoPrueba();
                return;
            } else if (opcionA.equals("3")) {
                MenuBusquedaPrueba.menubusquedaPrueba();
                return;
            } else if (opcionA.equals("4")) {
                MenuBusquedaInforme.BusquedaInforme();
                return;
            } else if (opcionA.equals("5")) {
                MenuBusquedaDispositivo.BusquedaDispositivo();
                return;
            } else if (opcionA.equals("6")) {
                MenuBusquedaNorma.BusquedaNorma();
                return;
            } else if (opcionA.equals("7")) {
                MenuBusquedaClase.BusquedaClase();
                return;
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\" o \"0\"\n");
            }
        }
    }
    public static void diagnosticoDeInconsistencias() throws IOException {
        while(true){
            System.out.println("Mostrar inconsistencias de:");
            menuDeClases();
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                InconsistenciasDeLaboratorio.InconsistenciasDeLaboratorio();
                return;
            }
            else if (seleccion.equals("2")){
                InconsistenciasDeTipoDePrueba.InconsistenciasDeTipoDePrueba();
                return;
            }
            else if (seleccion.equals("3")){
                InconsistenciasDePrueba.InconsistenciasDePrueba();
                return;
            }
            else if (seleccion.equals("4")){
                InconsistenciasDeInforme.InconsistenciasDeInforme();
                return;
            }
            else if (seleccion.equals("5")){
                System.out.println("La clase \"Dispositivos\" no presenta posibles inconsistencias\n");
                return;
            }
            else if (seleccion.equals("6")){
                InconsistenciasDeNorma.InconsistenciasDeNorma();
                return;
            }
            else if (seleccion.equals("7")){
                InconsistenciasDeClase.InconsistenciasDeClase();
                return;
            }
            else if (seleccion.equals("0")){
                return;
            }
            else {
                System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\" o \"0\"\n");
            }
        }
    }
    public static void menuDeClases(){
        System.out.println("1. Laboratorios.");
        System.out.println("2. Tipos de Prueba.");
        System.out.println("3. Pruebas.");
        System.out.println("4. Informes.");
        System.out.println("5. Dispositivos.");
        System.out.println("6. Normas.");
        System.out.println("7. Clases.");
        System.out.println("0. Volver");
    }
}

