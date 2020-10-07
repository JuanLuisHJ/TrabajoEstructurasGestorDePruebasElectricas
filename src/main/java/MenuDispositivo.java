import Clases.Dispositivo;
import Comparadores.ComparadorReferenciaDispositivo;
import Comparadores.ComparadorNombreDispositivo;

import java.io.*;
import java.util.*;

public class MenuDispositivo {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void MenuDispositivo() throws IOException {
        while (true) {
            System.out.println("1. Ver Dispositivos.");
            System.out.println("2. Crear Dispositivo.");
            System.out.println("3. Editar Dispositivo.");
            System.out.println("4. Eliminar Dispositivo.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if (Main.dispositivos.isEmpty()) {
                    System.out.println("No hay dispositivos guardados en la base de datos. ");
                } else {
                    for (Dispositivo dispositivo : Main.dispositivos) {
                        System.out.println(dispositivo);
                    }
                }

            } else if (opcionA.equals("2")) {
                System.out.println("Para crear una dispositivo, por favor ingrese en orden los datos solicitados:");
                System.out.println("Ingrese la referencia del dispositivo: ");
                String ref = input.readLine();
                if (ref.equals("")) {
                    System.out.println("No ingreso la referencia.");
                    return;
                }
                for (Dispositivo dispositivo : Main.dispositivos) {
                    if (dispositivo.Refetencia.equalsIgnoreCase(ref)) {
                        System.out.println("La referencia ingresada ya se encuentra registrada para otro dispositivo.\n");
                        return;
                    }
                }
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                if (nombre.equals("")) {
                    System.out.println("No ingreso el nombre.");
                    return;
                }
                    for (Dispositivo dispositivo1 : Main.dispositivos) {
                        if (dispositivo1.Nombre.equalsIgnoreCase(nombre)) {
                            System.out.println("El nombre ingresado ya se encuentra registrado para otro dispositivo.\n ");
                            return;
                        }
                    }
                System.out.print("Ingrese la potencia nominal en [VA] del dispositivo: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                System.out.print("Ingrese el voltaje nominal del dispositivo [V]: ");
                String volnom = input.readLine();
                double volnomr = Double.parseDouble(volnom);
                Dispositivo dispositivonuevo = new Dispositivo(ref, nombre, potnomr, volnomr);
                Main.dispositivos.add(dispositivonuevo);
                Collections.sort(Main.dispositivos, new ComparadorReferenciaDispositivo());
                System.out.println("Operacion realizada con exito. ");
                return;

            } else if (opcionA.equals("3")) {
                if (Main.dispositivos.isEmpty()) {
                    System.out.println("No hay dispositivos guardados en la base de datos. ");
                    return;
                } else {
                    while (true) {
                        System.out.println("Menu de edición de dispositivos: ");
                        System.out.println("1. Editar por referencia. ");
                        System.out.println("2. Editar por nombre. ");
                        System.out.println("0. Salir. ");
                        String opcion = input.readLine();
                        if (opcion.equals("1")) {
                            System.out.println("Ingrese la referencia del dispositivo: ");
                            String ref = input.readLine();
                            if (ref.equals("")) {
                                System.out.println("No ingreso la referencia. ");
                                return;
                            }
                            for (Dispositivo dispositivo : Main.dispositivos) {
                                if (!dispositivo.Refetencia.equalsIgnoreCase(ref)) {
                                    System.out.println("La referencia ingresada no se encuentra asignada a ningun dispositivo. ");
                                    return;
                                }
                            }
                            Main.dispositivos.sort(new ComparadorReferenciaDispositivo());
                            int indicedispositivoedit = Collections.binarySearch(Main.dispositivos, new Dispositivo(ref, null, 0, 0), new ComparadorReferenciaDispositivo());
                            Dispositivo dispositivoedit = Main.dispositivos.get(indicedispositivoedit);
                            System.out.println("La referencia del dispositivo seleccionado es: " + dispositivoedit.Refetencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingreso la referencia. ");
                                    return;
                                }
                                for (Dispositivo dispositivo : Main.dispositivos) {
                                    if (dispositivo.Refetencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otro dispositivo.\n ");
                                        return;
                                    }
                                }
                                dispositivoedit.Refetencia = nuevaref;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("El nombre del dispositivo seleccionado es: " + dispositivoedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingreso el nombre. ");
                                    return;
                                }
                                for (Dispositivo dispositivo : Main.dispositivos) {
                                    if (dispositivo.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otro dispositivo. ");
                                        return;
                                    }
                                }
                                dispositivoedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("La potencia nominal del dispositivo seleccionado es: " + dispositivoedit.PotenciaNominal + " [VA].");
                            System.out.println("¿Desea modificar la potencia nominal? (Y/N)");
                            String opcionpotnom = input.readLine();
                            if (opcionpotnom.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva potencia nominal [VA]: ");
                                String nuevapotnom = input.readLine();
                                if (nuevapotnom.equals("")) {
                                    System.out.println("No ingreso la potencia nominal. ");
                                    return;
                                }
                                dispositivoedit.PotenciaNominal = Double.parseDouble(nuevapotnom);
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("El voltaje nominal del dispositivo seleccionado es: " + dispositivoedit.VoltajeNominal + " [V].");
                            System.out.println("¿Desea modificar el voltaje nominal? (Y/N)");
                            String opcionvolnom = input.readLine();
                            if (opcionvolnom.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo voltaje nominal [V]: ");
                                String nuevavolnom = input.readLine();
                                if (nuevavolnom.equals("")) {
                                    System.out.println("No ingreso el voltaje nominal. ");
                                    return;
                                }
                                dispositivoedit.PotenciaNominal = Double.parseDouble(nuevavolnom);
                                System.out.println("Operación realizada con éxito. ");
                            }
                            System.out.println("La corriente nominal del dispositivo seleccionado es: " + dispositivoedit.CorrienteNominal + " [A].");
                            return;

                        } else if (opcion.equals("2")) {
                            System.out.println("Ingrese el nombre del dispositivo: ");
                            String nombre = input.readLine();
                            if (nombre.equals("")) {
                                System.out.println("No ingresó el nombre. \n");
                                return;
                            }
                            for (Dispositivo dispositivo : Main.dispositivos) {
                                if (!dispositivo.Nombre.equalsIgnoreCase(nombre)) {
                                    System.out.println("El nombre ingresado no se encuentra asignado a ningun dispositivo.\n ");
                                    return;
                                }
                            }
                            Main.dispositivos.sort(new ComparadorNombreDispositivo());
                            int indicedispositivoedit = Collections.binarySearch(Main.dispositivos, new Dispositivo(null, nombre, 0, 0), new ComparadorNombreDispositivo());
                            Dispositivo dispositivoedit = Main.dispositivos.get(indicedispositivoedit);
                            System.out.println("La referencia del dispositivo seleccionado es: " + dispositivoedit.Refetencia + ".");
                            System.out.println("¿Desea modificar la referencia? (Y/N)");
                            String opcionref = input.readLine();
                            if (opcionref.equalsIgnoreCase("Y")) {
                                System.out.print("Ingrese la nueva referencia: ");
                                String nuevaref = input.readLine();
                                if (nuevaref.equals("")) {
                                    System.out.println("No ingresó la referencia. \n");
                                    return;
                                }
                                for (Dispositivo dispositivo : Main.dispositivos) {
                                    if (dispositivo.Refetencia.equalsIgnoreCase(nuevaref)) {
                                        System.out.println("La referencia ingresada ya se encuentra asignada a otro dispositivo.\n ");
                                        return;
                                    }
                                }
                                dispositivoedit.Refetencia = nuevaref;
                                System.out.println("Operación realizada con éxito. \n");
                            }
                            System.out.println("El nombre del dispositivo seleccionado es: " + dispositivoedit.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnombre = input.readLine();
                            if (opcionnombre.equalsIgnoreCase("Y")) {
                                System.out.print("Ingrese el nuevo nombre: ");
                                String nuevonombre = input.readLine();
                                if (nuevonombre.equals("")) {
                                    System.out.println("No ingresó el nombre. \n");
                                    return;
                                }
                                for (Dispositivo dispositivo : Main.dispositivos) {
                                    if (dispositivo.Nombre.equalsIgnoreCase(nuevonombre)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otro dispositivo. \n");
                                        return;
                                    }
                                }
                                dispositivoedit.Nombre = nuevonombre;
                                System.out.println("Operación realizada con éxito. \n");
                            }
                            System.out.println("La potencia nominal del dispositivo seleccionado es: " + dispositivoedit.PotenciaNominal + " [VA].");
                            System.out.println("¿Desea modificar la potencia nominal? (Y/N)");
                            String opcionpotnom = input.readLine();
                            if (opcionpotnom.equalsIgnoreCase("Y")) {
                                System.out.print("Ingrese la nueva potencia nominal [VA]: ");
                                String nuevapotnom = input.readLine();
                                if (nuevapotnom.equals("")) {
                                    System.out.println("No ingresó la potencia nominal.\n");
                                    return;
                                }
                                dispositivoedit.PotenciaNominal = Double.parseDouble(nuevapotnom);
                                System.out.println("Operación realizada con éxito. \n");
                            }
                            System.out.println("El voltaje nominal del dispositivo seleccionado es: " + dispositivoedit.VoltajeNominal + " [V].");
                            System.out.println("¿Desea modificar el voltaje nominal? (Y/N)");
                            String opcionvolnom = input.readLine();
                            if (opcionvolnom.equalsIgnoreCase("Y")) {
                                System.out.print("Ingrese el nuevo voltaje nominal [V]: ");
                                String nuevavolnom = input.readLine();
                                if (nuevavolnom.equals("")) {
                                    System.out.println("No ingresó el voltaje nominal. \n");
                                    return;
                                }
                                dispositivoedit.PotenciaNominal = Double.parseDouble(nuevavolnom);
                                System.out.println("Operación realizada con éxito. \n");
                            }
                            System.out.println("La corriente nominal del dispositivo seleccionado es: " + dispositivoedit.CorrienteNominal + " [A].");
                            return;

                        } else if (opcion.equals("0")) {
                            break;
                        } else {
                            System.out.println("Los datos ingresados no son válidos \n");
                        }
                    }
                }

            } else if (opcionA.equals("4")) {
                while (true) {
                    System.out.println("Menu de borrado de dispositivos: ");
                    System.out.println("1. Borrar por referencia. ");
                    System.out.println("2. Borrar por nombre. ");
                    System.out.println("0. Salir. ");
                    String opcion = input.readLine();
                    if (opcion.equals("1")) {
                        System.out.print("Ingrese la referencia del dispositivo: ");
                        String ref = input.readLine();
                        if (ref.equals("")) {
                            System.out.println("No ingresó la referencia. ");
                            return;
                        }
                        for (Dispositivo dispositivo : Main.dispositivos) {
                            if (!dispositivo.Refetencia.equalsIgnoreCase(ref)) {
                                System.out.println("La referencia ingresada no se encuentra asignada a ningun dispositivo.\n ");
                                return;
                            }
                        }
                        Main.dispositivos.sort(new ComparadorReferenciaDispositivo());
                        int indicedispositivoborrado = Collections.binarySearch(Main.dispositivos, new Dispositivo(ref, null, 0, 0), new ComparadorReferenciaDispositivo());
                        Main.dispositivos.remove(indicedispositivoborrado);
                        System.out.println("Operación realizada con éxito. \n");
                        return;

                    } else if (opcion.equals("2")) {
                        System.out.print("Ingrese el nombre del dispositivo: ");
                        String nombre = input.readLine();
                        if (nombre.equals("")) {
                            System.out.println("No ingreso el nombre. \n");
                            return;
                        }
                        for (Dispositivo dispositivo : Main.dispositivos) {
                            if (!dispositivo.Nombre.equalsIgnoreCase(nombre)) {
                                System.out.println("El nombre ingresado no se encuentra asignado a ningun dispositivo.\n ");
                                return;
                            }
                        }
                        Main.dispositivos.sort(new ComparadorNombreDispositivo());
                        int indicedispositivoborrado = Collections.binarySearch(Main.dispositivos, new Dispositivo(null, nombre, 0, 0), new ComparadorNombreDispositivo());
                        Main.dispositivos.remove(indicedispositivoborrado);
                        System.out.println("Operación realizada con éxito. \n");
                        return;

                    } else if (opcion.equals("0")) {
                        break;

                    } else {
                        System.out.println("Los datos ingresados no son validos\n");
                    }
                }

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida\n");
            }
        }
    }
}
