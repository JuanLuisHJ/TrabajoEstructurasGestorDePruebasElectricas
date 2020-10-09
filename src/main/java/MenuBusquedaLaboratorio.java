import Clases.Laboratorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuBusquedaLaboratorio {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Laboratorio> Listatemporal = new ArrayList<>();
    public static void menubusquedaLaboratorio() throws IOException {

        Listatemporal.clear();
        while (true) {
            System.out.println("1. NIT.");
            System.out.println("2. Nombre.");
            System.out.println("3. Direccion.");
            System.out.println("4. Mostrar todos los laboratorios.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                busquedaNit();
                return;
            } else if (opcionA.equals("2")) {
                busquedaNombre();
                return;
            } else if (opcionA.equals("3")) {
                busquedaDireccion();
                return;
            } else if (opcionA.equals("4")) {
                MostrarTodo();
                return;
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static void busquedaNit(){

    }

    public static void busquedaNombre(){

    }

    public static void busquedaDireccion(){

    }

    public static void MostrarTodo(){

    }

    public static void organizar(){

    }

    public static String MenuString () throws IOException {
        while (true) {
            System.out.println("1. Valor Exacto.");
            System.out.println("2. Valor sin considerar mayusculas.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuOrganizar() throws IOException {
        while (true) {
            System.out.println("Selecione el atributo por el cual desea organizar");
            System.out.println("1. NIT.");
            System.out.println("2. Nombre.");
            System.out.println("3. Direccion.");
            System.out.println("4. Mostrar todos los laboratorios.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("3")) {
                return opcion;
            } else if (opcion.equals("4")) {
                return opcion;
            }else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuEoE() throws IOException {
        while (true) {
            System.out.println("Desea editar o eliminar algun laboratorio");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar.");
            System.out.println("0. No realizar cambios");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuAoD() throws IOException {
        while (true) {
            System.out.println("Seleccione la forma como desea organizar los laboratorios");
            System.out.println("1. Ascendente.");
            System.out.println("2. Descendente.");
            System.out.println("0. No realizar cambios");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuInt() throws IOException {
        while (true) {
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor minimo.");
            System.out.println("3. Valor maximo.");
            System.out.println("4. Rango.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("3")) {
                return opcion;
            } else if (opcion.equals("4")) {
                return opcion;
            }else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }
}
