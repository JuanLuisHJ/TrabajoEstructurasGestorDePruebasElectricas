import Clases.Norma;
import Comparadores.ComparadoresNorma.*;

import java.io.*;
import java.util.*;

public class MenuNorma {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void MenuNorma() throws IOException {
        while (true) {
            System.out.println("1. Ver Norma.");
            System.out.println("2. Crear Norma.");
            System.out.println("3. Editar Norma.");
            System.out.println("4. Eliminar Norma.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if (Main.normas.isEmpty()) {
                    System.out.println("No hay normas guardadas en la base de datos.\n");
                } else {
                    for (Norma norma : Main.normas) {
                        System.out.println(norma);
                    }
                }

            } else if (opcionA.equals("2")) {
                Crear();
                return;

            } else if (opcionA.equals("3")) {
                Editar();
                return;

            } else if (opcionA.equals("4")) {
                Borrar();
                return;

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void Crear() throws IOException {
        System.out.println("Para crear una norma, por favor ingrese en orden los datos solicitados:");
        System.out.println("Ingrese la referencia de la norma: ");
        String ref = input.readLine();
        if (ref.equals("")) {
            System.out.println("No ingreso la referencia.\n");
            return;
        }
        for (Norma norma : Main.normas) {
            if (norma.Referencia.equalsIgnoreCase(ref)) {
                System.out.println("La referencia ingresada ya se encuentra registrada para otra norma.\n");
                return;
            }
        }
        System.out.println("Ingrese el nombre de la norma: ");
        String nombre = input.readLine();
        if (nombre.equals("")) {
            System.out.println("No ingreso el nombre.\n");
            return;
        }
        for (Norma norma1 : Main.normas) {
            if (norma1.Nombre.equalsIgnoreCase(nombre)) {
                System.out.println("El nombre ingresado ya se encuentra registrado para otra norma.\n");
                return;
            }
        }
        Norma normanueva = new Norma(nombre, ref);
        Main.normas.add(normanueva);
        Main.normas.sort(new ComparadorReferenciaNorma());
        System.out.println("Operación realizada con éxito.\n");
    }

    public static void Editar() throws IOException {

        if (Main.normas.isEmpty()) {
            System.out.println("No hay normas guardadas en la base de datos.\n");
        } else {
            while (true) {
                System.out.println("Menu de edición de normas: ");
                System.out.println("1. Editar por referencia. ");
                System.out.println("2. Editar por nombre. ");
                System.out.println("0. Salir. ");
                String opcion = input.readLine();
                if (opcion.equals("1")) {
                    System.out.println("Ingrese la referencia de la norma: ");
                    String ref = input.readLine();
                    if (ref.equals("")) {
                        System.out.println("No ingreso la referencia.\n");
                        return;
                    }
                    ArrayList<Norma> normasquenoson = new ArrayList<>();
                    for (Norma norma : Main.normas) {
                        if (norma.Referencia.equalsIgnoreCase(ref)) {
                            int indicenormaedit = Collections.binarySearch(Main.normas, new Norma(null, ref), new ComparadorReferenciaNorma());
                            Norma normaedit = Main.normas.get(indicenormaedit);
                            System.out.println("La referencia de la norma seleccionada es: " + normaedit.Referencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingreso la referencia.\n");
                                    return;
                                }
                                for (Norma norma1 : Main.normas) {
                                    if (norma1.Referencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otra norma.\n");
                                        return;
                                    }
                                }
                                normaedit.Referencia = nuevaref;
                                System.out.println("Operación realizada con éxito.\n");
                            }
                            System.out.println("El nombre de la norma seleccionada es: " + normaedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingreso el nombre.\n");
                                    return;
                                }
                                for (Norma norma2 : Main.normas) {
                                    if (norma2.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otra norma.\n");
                                        return;
                                    }
                                }
                                normaedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito.\n");
                            }
                            return;

                        } else {
                            normasquenoson.add(norma);
                        }
                    }

                    if (!normasquenoson.isEmpty()) {
                        System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                        return;
                    }

                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese el nombre de la norma: ");
                    String nombre = input.readLine();
                    if (nombre.equals("")) {
                        System.out.println("No ingreso el nombre.\n");
                        return;
                    }
                    ArrayList<Norma> normasquenoson = new ArrayList<>();
                    for (Norma norma : Main.normas) {
                        if (norma.Nombre.equalsIgnoreCase(nombre)) {
                            Norma normaedit = null;
                            for (int i = 0; i < Main.normas.size(); i++) {
                                if (Main.normas.get(i).Nombre.equalsIgnoreCase(nombre)) {
                                    normaedit = Main.normas.get(i);
                                    break;
                                }
                            }
                            System.out.println("La referencia de la norma seleccionada es: " + normaedit.Referencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingreso la referencia.\n");
                                    return;
                                }
                                for (Norma norma1 : Main.normas) {
                                    if (norma1.Referencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otra norma.\n");
                                        return;
                                    }
                                }
                                normaedit.Referencia = nuevaref;
                                System.out.println("Operación realizada con éxito.\n");
                            }
                            System.out.println("El nombre de la norma seleccionada es: " + normaedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingreso el nombre.\n");
                                    return;
                                }
                                for (Norma norma2 : Main.normas) {
                                    if (norma2.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otra norma.\n");
                                        return;
                                    }
                                }
                                normaedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito.\n");
                            }
                            return;

                        } else {
                            normasquenoson.add(norma);
                        }
                    }

                    if (!normasquenoson.isEmpty()) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma.\n");
                        return;
                    }

                } else if (opcion.equals("0")) {
                    break;

                } else {
                    System.out.println("Los datos ingresados no son validos.\n");
                }
            }
        }
    }

    public static void Borrar() throws IOException {
        while (true) {
            System.out.println("Menu de borrado de normas: ");
            System.out.println("1. Borrar por referencia. ");
            System.out.println("2. Borrar por nombre. ");
            System.out.println("0. Salir. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                if (ref.equals("")) {
                    System.out.println("No ingreso la referencia.\n");
                    return;
                }
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : Main.normas) {
                    if (norma.Referencia.equalsIgnoreCase(ref)) {
                        int indicenormaborrado = Collections.binarySearch(Main.normas, new Norma(null, ref), new ComparadorReferenciaNorma());
                        Main.normas.remove(indicenormaborrado);

                        // IR A LAS "CLASES" Y ESTABLECER EN NULL EL ATRIBUTO "NORMA"

                        System.out.println("Operación realizada con éxito.\n");
                        return;

                    } else {
                        normasquenoson.add(norma);
                    }
                }

                if (!normasquenoson.isEmpty()) {
                    System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                    return;
                }

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el nombre de la norma: ");
                String nombre = input.readLine();
                if (nombre.equals("")) {
                    System.out.println("No ingreso el nombre.\n");
                    return;
                }
                ArrayList<Norma> normasquenoson = new ArrayList<>();
                for (Norma norma : Main.normas) {
                    if (norma.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma.\n");
                        return;
                    }
                }
                for (int i = 0; i < Main.normas.size(); i++) {
                    if (Main.normas.get(i).Nombre.equalsIgnoreCase(nombre)) {
                        Main.normas.remove(i);


                        // IR A LAS "CLASES" Y ESTABLECER EN NULL EL ATRIBUTO "NORMA"


                        break;
                    } else {
                        normasquenoson.add(Main.normas.get(i));
                    }
                }

                if (!normasquenoson.isEmpty()) {
                    System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma.\n");
                    return;
                }
            }
        }
    }
}
