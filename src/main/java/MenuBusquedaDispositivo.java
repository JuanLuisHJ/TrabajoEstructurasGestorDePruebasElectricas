import Clases.Dispositivo;
import Clases.Prueba;
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
                    for (int i = 0; i < dispositivos.size(); i++) {
                        System.out.println("Indice: " + i + ".\n");
                        System.out.println(dispositivos.get(i));
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
                editareliminarUK(dispositivos.get(indiceref));
                System.out.println("Operación realizada con éxito.\n ");
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese la referencia del dispositivo: ");
                String ref = input.readLine();
                int indiceref = Collections.binarySearch(dispositivos, new Dispositivo(ref, null, 0, 0), new ComparadorReferenciaDispositivo());
                System.out.println(dispositivos.get(indiceref));
                editareliminarUK(dispositivos.get(indiceref));
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
                        editareliminarUK(dispositivo);
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
                        editareliminarUK(dispositivo);
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
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        dispositivos.sort(new ComparadorReferenciaDispositivo());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    } else if (opc.equals("2")) {
                        dispositivos.sort(new ComparadorReferenciaDispositivo().reversed());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    }
                }
            } else if (opcionA.equals("2")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        dispositivos.sort(new ComparadorNombreDispositivo());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    } else if (opc.equals("2")) {
                        dispositivos.sort(new ComparadorNombreDispositivo().reversed());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    }
                }

            } else if (opcionA.equals("3")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        dispositivos.sort(new ComparadorPotenciaNominalDispositivo());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    } else if (opc.equals("2")) {
                        dispositivos.sort(new ComparadorPotenciaNominalDispositivo().reversed());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    }
                }

            } else if (opcionA.equals("4")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        dispositivos.sort(new ComparadorVoltajeNominalDispositivo());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    } else if (opc.equals("2")) {
                        dispositivos.sort(new ComparadorVoltajeNominalDispositivo().reversed());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    }
                }

            } else if (opcionA.equals("5")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        dispositivos.sort(new ComparadorCorrienteNominalDispositivo());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    } else if (opc.equals("2")) {
                        dispositivos.sort(new ComparadorCorrienteNominalDispositivo().reversed());
                        for (int i = 0; i < dispositivos.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(dispositivos);
                        }
                        editareliminarlistas(dispositivos);
                        return;
                    }
                }

            }  else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }

        }
    }

    public static void editareliminarlistas(ArrayList<Dispositivo> dispositivos) throws IOException {

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
                for (int i = 0; i < dispositivos.size(); i++) {
                    if (indicer == i) {
                        editar(dispositivos.get(i));
                        break;
                    }
                }

            } else if (opc.equals("2")) {
                System.out.println("Ingrese el indice del elemento que desea modificar: ");
                String indice = input.readLine();
                double indicer = Double.parseDouble(indice);
                for (int i = 0; i < dispositivos.size(); i++) {
                    if (indicer == i) {
                        eliminar(dispositivos.get(i));
                        break;
                    }
                }
            } else if (opc.equals("0")) {
                break;

            }
        }
    }

    public static void editareliminarUK(Dispositivo dispositivo) throws IOException {

        while (true) {
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar. ");
            System.out.println("0. Cancelar. ");
            String opc = input.readLine();
            if (opc.equals("1")) {
                editar(dispositivo);
                return;

            } else if (opc.equals("2")) {
                eliminar(dispositivo);
                return;

            } else if (opc.equals("0")) {
                break;

            }
        }
    }

    public static void editar(Dispositivo dispositivo) throws IOException {
        System.out.println("La referencia del dispositivo seleccionado es: " + dispositivo.Refetencia + ".");
        System.out.println("¿Desea modificar la referencia? (Y/N)");
        String opcionref = input.readLine();
        if (opcionref.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva referencia: ");
            String nuevaref = input.readLine();
            if (nuevaref.equals("")) {
                System.out.println("No ingreso una nueva referencia.\n");
            }
            for (Dispositivo dispositivo2 : Main.dispositivos) {
                if (dispositivo2.Refetencia.equalsIgnoreCase(nuevaref)) {
                    System.out.println("La referencia ingresada ya se encuentra asignada a otro dispositivo.\n ");
                    return;
                }
            }
            for (Prueba prueba : Main.pruebas) {
                for (int h = 0; h < prueba.RefDispositivos.size(); h++) {
                    if (prueba.RefDispositivos.get(h).equalsIgnoreCase(dispositivo.Refetencia)) {
                        prueba.RefDispositivos.set(h, nuevaref);
                        break;
                    }
                }
                break;
            }
            dispositivo.Refetencia = nuevaref;
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("El nombre del dispositivo seleccionado es: " + dispositivo.Nombre + ".");
        System.out.println("¿Desea modificar el nombre? (Y/N)");
        String opcionnombre = input.readLine();
        if (opcionnombre.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevonombre = input.readLine();
            if (nuevonombre.equals("")) {
                System.out.println("No ingreso un nuevo nombre.\n");
            }
            for (Dispositivo dispositivo1 : Main.dispositivos) {
                if (dispositivo1.Nombre.equalsIgnoreCase(nuevonombre)) {
                    System.out.println("El nombre ingresado ya se encuentra asignado a otro dispositivo.\n");
                    return;
                }
            }
            dispositivo.Nombre = nuevonombre;
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("La potencia nominal del dispositivo seleccionado es: " + dispositivo.PotenciaNominal + " [VA].");
        System.out.println("¿Desea modificar la potencia nominal? (Y/N)");
        String opcionpotnom = input.readLine();
        if (opcionpotnom.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva potencia nominal [VA]: ");
            String nuevapotnom = input.readLine();
            if (nuevapotnom.equals("")) {
                System.out.println("No ingreso una nueva potencia nominal.\n");
            } else if (Double.parseDouble(nuevapotnom) < 0) {
                System.out.println("No se permiten valores negativos.\n");
                return;
            }
            dispositivo.PotenciaNominal = Double.parseDouble(nuevapotnom);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("El voltaje nominal del dispositivo seleccionado es: " + dispositivo.VoltajeNominal + " [V].");
        System.out.println("¿Desea modificar el voltaje nominal? (Y/N)");
        String opcionvolnom = input.readLine();
        if (opcionvolnom.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo voltaje nominal [V]: ");
            String nuevavolnom = input.readLine();
            if (nuevavolnom.equals("")) {
                System.out.println("No ingreso un nuevo voltaje nominal.\n");
            } else if (Double.parseDouble(nuevavolnom) < 0) {
                System.out.println("No se permiten valores negativos.\n");
                return;
            }
            dispositivo.PotenciaNominal = Double.parseDouble(nuevavolnom);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("La corriente nominal del dispositivo seleccionado es: " + dispositivo.CorrienteNominal + " [A].\n");
    }

    public static void eliminar(Dispositivo dispositivo) {
        for (Prueba prueba : Main.pruebas) {
            for (int i = 0; i < prueba.RefDispositivos.size(); i++) {
                if (prueba.RefDispositivos.get(i).equalsIgnoreCase(dispositivo.Refetencia)) {
                    prueba.RefDispositivos.remove(i);
                    break;
                }
            }
        }
        Main.dispositivos.remove(dispositivo);
        System.out.println("Operación realizada con éxito. \n");

    }
}

