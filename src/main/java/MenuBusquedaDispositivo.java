import Clases.Dispositivo;
import Comparadores.ComparadoresDispositivo.*;

import java.io.*;
import java.util.*;


public class MenuBusquedaDispositivo {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void BusquedaDispositivo() throws IOException {
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
            while (true) {
                System.out.println("1. Referencia.");
                System.out.println("2. Nombre.");
                System.out.println("3. Potencia Nominal.");
                System.out.println("4. Voltaje Nominal.");
                System.out.println("5. Corriente Nominal.");
                System.out.println("6. Mostrar todos los dispositivos. ");
                System.out.println("0. Cancelar");
                String opcionA = input.readLine();
                if (opcionA.equals("1")) {
                    Referencia();
                    return;

                } else if (opcionA.equals("2")) {
                    Nombre();
                    return;

                } else if (opcionA.equals("3")) {
                    PotenciaNominal();
                    return;

                } else if (opcionA.equals("4")) {
                    VoltajeNominal();
                    return;

                } else if (opcionA.equals("5")) {
                    CorrienteNominal();
                    return;

                } else if (opcionA.equals("6")) {
                    for (Dispositivo dispositivo : dispositivos) {
                        System.out.println(dispositivo);
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
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor sin considerar mayusculas. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la referencia del dispositivo: ");
                String ref = input.readLine();
                int indiceref = Collections.binarySearch(dispositivos, new Dispositivo(ref, null, 0, 0), new ComparadorReferenciaDispositivo());
                System.out.println(dispositivos.get(indiceref));
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese la referencia del dispositivo: ");
                String ref = input.readLine();
                int indiceref = Collections.binarySearch(dispositivos, new Dispositivo(ref, null, 0, 0), new ComparadorReferenciaDispositivo());
                System.out.println(dispositivos.get(indiceref));
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
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor sin considerar mayusculas. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.Nombre.equals(nombre)) {
                        System.out.println(dispositivo);
                        break;
                    }
                }
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el nombre del dispositivo: ");
                String nombre = input.readLine();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.Nombre.equalsIgnoreCase(nombre)) {
                        System.out.println(dispositivo);
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

    public static void PotenciaNominal() throws IOException {
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la potencia nominal del dispositivo: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.PotenciaNominal == potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;
                
            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo de potencia: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.PotenciaNominal >= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo de potencia: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.PotenciaNominal <= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango de potencias: ");
                String potnommin = input.readLine();
                double potnomminr = Double.parseDouble(potnommin);
                System.out.println("Ingrese el valor máximo del rango de potencias: ");
                String potnommax = input.readLine();
                double potnommaxr = Double.parseDouble(potnommax);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.PotenciaNominal >= potnomminr && dispositivo.PotenciaNominal <= potnommaxr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void VoltajeNominal() throws IOException {
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la voltaje nominal del dispositivo: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.VoltajeNominal == potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo de voltaje: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.VoltajeNominal >= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo de voltaje: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.VoltajeNominal <= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango de voltajes: ");
                String potnommin = input.readLine();
                double potnomminr = Double.parseDouble(potnommin);
                System.out.println("Ingrese el valor máximo del rango de voltajes: ");
                String potnommax = input.readLine();
                double potnommaxr = Double.parseDouble(potnommax);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.VoltajeNominal >= potnomminr && dispositivo.VoltajeNominal <= potnommaxr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }

    }

    public static void CorrienteNominal() throws IOException {
        ArrayList<Dispositivo> dispositivos = Main.dispositivos;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la corriente nominal del dispositivo: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.CorrienteNominal == potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo de corriente: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.CorrienteNominal >= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo de corriente: ");
                String potnom = input.readLine();
                double potnomr = Double.parseDouble(potnom);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.CorrienteNominal <= potnomr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango de corrientes: ");
                String potnommin = input.readLine();
                double potnomminr = Double.parseDouble(potnommin);
                System.out.println("Ingrese el valor máximo del rango de corrientes: ");
                String potnommax = input.readLine();
                double potnommaxr = Double.parseDouble(potnommax);
                ArrayList<Dispositivo> dispositivos1 = new ArrayList<>();
                for (Dispositivo dispositivo : dispositivos) {
                    if (dispositivo.CorrienteNominal >= potnomminr && dispositivo.CorrienteNominal <= potnommaxr) {
                        dispositivos1.add(dispositivo);
                    }
                }
                OrganizarPorAtributo(dispositivos1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }

    }

    public static void OrganizarPorAtributo(ArrayList<Dispositivo> dispositivos) throws IOException {
        while(true) {
            System.out.println("Seleccione el atributo por el que desea organizar la lista para impresión. ");
            System.out.println("1. Referencia.");
            System.out.println("2. Nombre.");
            System.out.println("3. Potencia Nominal.");
            System.out.println("4. Voltaje Nominal.");
            System.out.println("5. Corriente Nominal.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                dispositivos.sort(new ComparadorReferenciaDispositivo());
                for (Dispositivo dispositivo : dispositivos) {
                    System.out.println(dispositivo);
                }
                return;

            } else if (opcionA.equals("2")) {
                dispositivos.sort(new ComparadorNombreDispositivo());
                for (Dispositivo dispositivo : dispositivos) {
                    System.out.println(dispositivo);
                }
                return;

            } else if (opcionA.equals("3")) {
                dispositivos.sort(new ComparadorPotenciaNominalDispositivo());
                for (Dispositivo dispositivo : dispositivos) {
                    System.out.println(dispositivo);
                }
                return;

            } else if (opcionA.equals("4")) {
                dispositivos.sort(new ComparadorVoltajeNominalDispositivo());
                for (Dispositivo dispositivo : dispositivos) {
                    System.out.println(dispositivo);
                }
                return;

            } else if (opcionA.equals("5")) {
                dispositivos.sort(new ComparadorCorrienteNominalDispositivo());
                for (Dispositivo dispositivo : dispositivos) {
                    System.out.println(dispositivo);
                }
                return;

            }  else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }

        }
    }
}

