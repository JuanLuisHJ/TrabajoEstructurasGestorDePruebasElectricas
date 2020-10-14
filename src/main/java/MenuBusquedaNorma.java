import Clases.Clase;
import Clases.Norma;
import Clases.TipoPrueba;
import Comparadores.ComparadoresNorma;


import java.io.*;
import java.util.*;

public class MenuBusquedaNorma {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void BusquedaNorma() throws IOException {
        ArrayList<Norma> normas = Main.normas;
        while (true) {
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia.");
            System.out.println("3. Mostrar todas las normas. ");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                Nombre();
                return;

            } else if (opcionA.equals("2")) {
                Referencia();
                return;

            } else if (opcionA.equals("3")) {
                for (int i = 0; i < normas.size(); i++) {
                    System.out.println("Indice: " + i + ".\n");
                    System.out.println(normas.get(i));
                }
                return;

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void Referencia() throws IOException {
        ArrayList<Norma> normas = Main.normas;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor sin considerar mayusculas. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                int indiceref = Collections.binarySearch(normas, new Norma(null, ref), new ComparadoresNorma.ComparadorReferenciaNorma());
                System.out.println(normas.get(indiceref));
                editareliminarUK(normas.get(indiceref));
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                int indiceref = Collections.binarySearch(normas, new Norma(null, ref), new ComparadoresNorma.ComparadorReferenciaNorma());
                System.out.println(normas.get(indiceref));
                editareliminarUK(normas.get(indiceref));
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("0")) {
                break;

            }else {
                System.out.println("La opción ingresada no es válida.\n");

            }
        }
    }

    public static void Nombre() throws IOException {
        ArrayList<Norma> normas = Main.normas;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor sin considerar mayusculas. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                for (Norma norma : normas) {
                    if (norma.Nombre.equals(nombre)) {
                        System.out.println(norma);
                        editareliminarUK(norma);
                        break;
                    }
                }
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                for (Norma norma : normas) {
                    if (norma.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println(norma);
                        editareliminarUK(norma);
                        break;
                    }
                }
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");

            }
        }
    }

    public static void editareliminarUK(Norma norma) throws IOException {

        while (true) {
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar. ");
            System.out.println("0. Cancelar. ");
            String opc = input.readLine();
            if (opc.equals("1")) {
                editar(norma);
                return;

            } else if (opc.equals("2")) {
                eliminar(norma);
                return;

            } else if (opc.equals("0")) {
                break;

            }
        }
    }

    public static void editar(Norma norma) throws IOException {
        System.out.println("La referencia de la norma seleccionada es: " + norma.Referencia + ".");
        System.out.println("¿Desea modificar la referencia? (Y/N)");
        String opcionref = input.readLine();
        if (opcionref.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva referencia: ");
            String nuevaref = input.readLine();
            if (nuevaref.equals("")) {
                System.out.println("No ingreso una nueva referencia.\n");
            }
            for (Norma norma1 : Main.normas) {
                if (norma1.Referencia.equalsIgnoreCase(nuevaref)) {
                    System.out.println("La referencia ingresada ya se encuentra asignada a otra norma.\n");
                    return;
                }
            }
            norma.Referencia = nuevaref;
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("El nombre de la norma seleccionada es: " + norma.Nombre + ".");
        System.out.println("¿Desea modificar el nombre? (Y/N)");
        String opcionnombre = input.readLine();
        if (opcionnombre.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevonombre = input.readLine();
            if (nuevonombre.equals("")) {
                System.out.println("No ingreso un nuevo nombre.\n");
            }
            for (Norma norma2 : Main.normas) {
                if (norma2.Nombre.equalsIgnoreCase(nuevonombre)) {
                    System.out.println("El nombre ingresado ya se encuentra asignado a otra norma.\n");
                    return;
                }
            }
            norma.Nombre = nuevonombre;
            System.out.println("Operación realizada con éxito.\n");
        }
    }

    public static void eliminar(Norma norma) {
        for (Clase clase : Main.clases) {
            if (clase.Norma.equalsIgnoreCase(norma.Referencia)) {
                clase.Norma = null;
                break;
            }
        }
        for (TipoPrueba tipoprueba : Main.tipopruebas) {
            if (tipoprueba.RefNorma.equalsIgnoreCase(norma.Referencia)) {
                tipoprueba.RefNorma = null;
                break;
            }
        }
        Main.normas.remove(norma);
        System.out.println("Operación realizada con éxito.\n");
    }
}

