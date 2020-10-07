import Clases.Norma;
import Comparadores.ComparadorReferenciaNorma;
import Comparadores.ComparadorNombreNorma;

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
                    System.out.println("No hay normas guardadas en la base de datos. ");
                } else {
                    for (Norma norma : Main.normas) {
                        System.out.println(norma);
                    }
                }

            } else if (opcionA.equals("2")) {
                System.out.println("Para crear una norma, por favor ingrese en orden los datos solicitados:");
                System.out.println("Ingrese la referencia de la norma: ");
                String ref = input.readLine();
                if (ref.equals("")) {
                    System.out.println("No ingreso la referencia.");
                    return;
                }
                for (Norma norma : Main.normas) {
                    if (norma.Referencia.equalsIgnoreCase(ref)) {
                        System.out.println("La referencia ingresada ya se encuentra registrada para otra norma.");
                        return;
                    }
                }
                System.out.println("Ingrese el nombre de la norma: ");
                String nombre = input.readLine();
                if (nombre.equals("")) {
                    System.out.println("No ingreso el nombre.");
                    return;
                }
                for (Norma norma1 : Main.normas) {
                    if (norma1.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println("El nombre ingresado ya se encuentra registrado para otra norma. ");
                        return;
                    }
                }
                Norma normanueva = new Norma(nombre, ref);
                Main.normas.add(normanueva);
                Collections.sort(Main.normas, new ComparadorReferenciaNorma());
                System.out.println("Operación realizada con éxito");
                return;

            } else if (opcionA.equals("3")) {
                if (Main.normas.isEmpty()) {
                    System.out.println("No hay normas guardadas en la base de datos. ");
                    return;
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
                                System.out.println("No ingreso la referencia. ");
                                return;
                            }
                            for (Norma norma : Main.normas) {
                                if (!norma.Referencia.equalsIgnoreCase(ref)) {
                                    System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma. ");
                                    return;
                                }
                            }
                            Main.normas.sort(new ComparadorReferenciaNorma());
                            int indicenormaedit = Collections.binarySearch(Main.normas, new Norma(null, ref), new ComparadorReferenciaNorma());
                            Norma normaedit = Main.normas.get(indicenormaedit);
                            System.out.println("La referencia de la norma seleccionada es: " + normaedit.Referencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingreso la referencia. ");
                                    return;
                                }
                                for (Norma norma : Main.normas) {
                                    if (norma.Referencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otra norma. ");
                                        return;
                                    }
                                }
                                normaedit.Referencia = nuevaref;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("El nombre de la norma seleccionada es: " + normaedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingreso el nombre. ");
                                    return;
                                }
                                for (Norma norma : Main.normas) {
                                    if (norma.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otra norma. ");
                                        return;
                                    }
                                }
                                normaedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            return;

                        } else if (opcion.equals("2")) {
                            System.out.println("Ingrese el nombre de la norma: ");
                            String nombre = input.readLine();
                            if (nombre.equals("")) {
                                System.out.println("No ingreso el nombre. ");
                                return;
                            }
                            for (Norma norma : Main.normas) {
                                if (!norma.Nombre.equalsIgnoreCase(nombre)) {
                                    System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma. ");
                                    return;
                                }
                            }
                            Main.normas.sort(new ComparadorNombreNorma());
                            int indicenormaedit = Collections.binarySearch(Main.normas, new Norma(nombre, null), new ComparadorNombreNorma());
                            Norma normaedit = Main.normas.get(indicenormaedit);
                            System.out.println("La referencia de la norma seleccionada es: " + normaedit.Referencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingreso la referencia. ");
                                    return;
                                }
                                for (Norma norma : Main.normas) {
                                    if (norma.Referencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otra norma. ");
                                        return;
                                    }
                                }
                                normaedit.Referencia = nuevaref;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("El nombre de la norma seleccionada es: " + normaedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingreso el nombre. ");
                                    return;
                                }
                                for (Norma norma : Main.normas) {
                                    if (norma.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otra norma. ");
                                        return;
                                    }
                                }
                                normaedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            return;

                        } else if (opcion.equals("0")) {
                            break;

                        } else {
                            System.out.println("Los datos ingresados no son validos");
                        }
                    }
                }

            } else if (opcionA.equals("4")) {
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
                            System.out.println("No ingreso la referencia. ");
                            return;
                        }
                        for (Norma norma : Main.normas) {
                            if (!norma.Referencia.equalsIgnoreCase(ref)) {
                                System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma. ");
                                return;
                            }
                        }
                        Main.normas.sort(new ComparadorReferenciaNorma());
                        int indicenormaborrado = Collections.binarySearch(Main.normas, new Norma(null, ref), new ComparadorReferenciaNorma());
                        Main.normas.remove(indicenormaborrado);
                        System.out.println("Operación realizada con éxito. ");
                        return;

                    } else if (opcion.equals("2")) {
                        System.out.println("Ingrese el nombre de la norma: ");
                        String nombre = input.readLine();
                        if (nombre.equals("")) {
                            System.out.println("No ingreso el nombre. ");
                            return;
                        }
                        for (Norma norma : Main.normas) {
                            if (!norma.Nombre.equalsIgnoreCase(nombre)) {
                                System.out.println("El nombre ingresado no se encuentra asignado a ninguna norma. ");
                                return;
                            }
                        }
                        Main.normas.sort(new ComparadorNombreNorma());
                        int indicenormaborrado = Collections.binarySearch(Main.normas, new Norma(nombre, null), new ComparadorNombreNorma());
                        Main.dispositivos.remove(indicenormaborrado);
                        System.out.println("Operación realizada con éxito. ");
                        return;

                    } else if (opcion.equals("0")) {
                        break;

                    } else {
                        System.out.println("Los datos ingresados no son validos");
                    }
                }

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida");
            }
        }
    }
}
