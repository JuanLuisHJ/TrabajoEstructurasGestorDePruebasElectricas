import Clases.Clase;
import Clases.Norma;
import Clases.TipoPrueba;
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
                        System.out.println("No ingreso la referencia de la norma.\n");
                        return;
                    }
                    ArrayList<Norma> normasquenoson = new ArrayList<>();
                    for (Norma norma : Main.normas) {
                        if (norma.Referencia.equalsIgnoreCase(ref)) {
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
                                    }
                                }
                                for (Clase clase : Main.clases) {
                                    if (clase.Norma.equalsIgnoreCase(norma.Referencia)) {
                                        clase.Norma = nuevaref;
                                        break;
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
                            normasquenoson.clear();
                            break;

                        } else {
                            normasquenoson.add(norma);
                        }
                    }

                    if (!normasquenoson.isEmpty()) {
                        System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                        normasquenoson.clear();
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
                                    }
                                }
                                for (Clase clase : Main.clases) {
                                    if (clase.Norma.equalsIgnoreCase(norma.Referencia)) {
                                        clase.Norma = nuevaref;
                                        break;
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
                            normasquenoson.clear();
                            break;

                        } else {
                            normasquenoson.add(norma);
                        }
                    }

                    if (!normasquenoson.isEmpty()) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma.\n");
                        normasquenoson.clear();
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
                        for (Clase clase : Main.clases) {
                            if (clase.Norma.equalsIgnoreCase(ref)) {
                                clase.Norma = null;
                                break;
                            }
                        }
                        for (TipoPrueba tipoprueba : Main.tipopruebas) {
                            if (tipoprueba.RefNorma.equalsIgnoreCase(ref)) {
                                tipoprueba.RefNorma = null;
                            }
                        }
                        Main.normas.remove(norma);
                        System.out.println("Operación realizada con éxito.\n");
                        normasquenoson.clear();
                        break;

                    } else {
                        normasquenoson.add(norma);
                    }
                }

                if (!normasquenoson.isEmpty()) {
                    System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                    normasquenoson.clear();
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
                        String referenciaxnombre = norma.Referencia;
                        for (TipoPrueba tipoprueba : Main.tipopruebas) {
                            if (tipoprueba.RefNorma.equalsIgnoreCase(referenciaxnombre)) {
                                tipoprueba.RefNorma = null;
                            }
                        }
                        for (Clase clase : Main.clases) {
                            if (clase.Norma.equalsIgnoreCase(referenciaxnombre)) {
                                clase.Norma = null;
                                break;
                            }
                        }
                        Main.normas.remove(norma);
                        normasquenoson.clear();
                        break;

                    }else {
                        normasquenoson.add(norma);
                    }
                }

                    if (!normasquenoson.isEmpty()) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma.\n");
                        normasquenoson.clear();
                        return;
                    }
                }
            }
        }
    }
