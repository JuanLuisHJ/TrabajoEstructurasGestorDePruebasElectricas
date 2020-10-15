import Clases.Clase;
import Clases.Norma;
import Clases.TipoPrueba;
import Comparadores.ComparadoresNorma.*;


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
                OrganizarPorAtributo(normas);
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
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : normas) {
                    if (norma.Referencia.equalsIgnoreCase(ref)) {
                       System.out.println(norma);
                        editareliminarUK(norma);
                        System.out.println("Operación realizada con éxito.\n ");
                        normasquenoson.clear();
                        break;

                    } else {
                        normasquenoson.add(norma);
                    }
                }
                if (!normasquenoson.isEmpty()) {
                    System.out.println("No se encontro ninguna norma con la referencia ingresada.\n");
                    normasquenoson.clear();
                    return;
                }

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : normas) {
                    if (norma.Referencia.equalsIgnoreCase(ref)) {
                        System.out.println(norma);
                        editareliminarUK(norma);
                        System.out.println("Operación realizada con éxito.\n ");
                        normasquenoson.clear();
                        break;

                } else {
                    normasquenoson.add(norma);
                }
            }
                if (!normasquenoson.isEmpty()) {
                    System.out.println("No se encontro ninguna norma con la referencia ingresada.\n");
                    normasquenoson.clear();
                    return;
                }

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
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : normas) {
                    if (norma.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println(norma);
                        editareliminarUK(norma);
                        System.out.println("Operación realizada con éxito.\n ");
                        normasquenoson.clear();
                        break;

                    } else {
                        normasquenoson.add(norma);
                    }
                }
                if (!normasquenoson.isEmpty()) {
                    System.out.println("No se encontro ninguna norma con el nombre ingresado.\n");
                    normasquenoson.clear();
                    return;
                }

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : normas) {
                    if (norma.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println(norma);
                        editareliminarUK(norma);
                        System.out.println("Operación realizada con éxito.\n ");
                        normasquenoson.clear();
                        break;

                    } else {
                        normasquenoson.add(norma);
                    }
                }
                if (!normasquenoson.isEmpty()) {
                    System.out.println("No se encontro ninguna norma con el nombre ingresado.\n");
                    normasquenoson.clear();
                    return;
                }

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
            for (TipoPrueba tipoprueba : Main.tipopruebas) {
                if (tipoprueba.RefNorma.equalsIgnoreCase(norma.Referencia)) {
                    tipoprueba.RefNorma = nuevaref;
                    break;
                }
            }
            for (Clase clase : Main.clases) {
                if (clase.Norma.equalsIgnoreCase(norma.Referencia)) {
                    clase.Norma = nuevaref;
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
            }
        }
        Main.normas.remove(norma);
        System.out.println("Operación realizada con éxito.\n");
    }

    public static void OrganizarPorAtributo(ArrayList<Norma> normas) throws IOException {
        while (true) {
            System.out.println("Seleccione el atributo por el que desea organizar la lista para impresión. ");
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        normas.sort(new ComparadorNombreNorma());
                        for (int i = 0; i < normas.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(normas);
                        }
                        editareliminarlistas(normas);
                        return;

                    } else if (opc.equals("2")) {
                        normas.sort(new ComparadorNombreNorma().reversed());
                        for (int i = 0; i < normas.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(normas);
                        }
                        editareliminarlistas(normas);
                        return;

                    } else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("2")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        normas.sort(new ComparadorReferenciaNorma());
                        for (int i = 0; i < normas.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(normas);
                        }
                        editareliminarlistas(normas);
                        return;

                    } else if (opc.equals("2")) {
                        normas.sort(new ComparadorReferenciaNorma().reversed());
                        for (int i = 0; i < normas.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(normas);
                        }
                        editareliminarlistas(normas);
                        return;

                    } else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }


    public static void editareliminarlistas(ArrayList<Norma> normas) throws IOException {

        while (true) {
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar. ");
            System.out.println("0. Cancelar. ");
            String opc = input.readLine();
            if (opc.equals("1")) {
                System.out.println("Ingrese el indice del elemento que desea modificar: ");
                String indice = input.readLine();
                double indicer = Double.parseDouble(indice);
                if ((indicer - 1) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                for (int i = 0; i < normas.size(); i++) {
                    if ((indicer - 1) == i) {
                        editar(normas.get(i));
                        break;
                    }
                }

            } else if (opc.equals("2")) {
                System.out.println("Ingrese el indice del elemento que desea modificar: ");
                String indice = input.readLine();
                double indicer = Double.parseDouble(indice);
                if ((indicer - 1) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                for (int i = 0; i < normas.size(); i++) {
                    if ((indicer - 1) == i) {
                        eliminar(normas.get(i));
                        break;
                    }
                }
            } else if (opc.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }
}

