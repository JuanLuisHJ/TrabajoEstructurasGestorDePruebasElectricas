import Clases.Norma;
import Clases.Clase;
import Clases.Prueba;
import Comparadores.ComparadoresClase.*;
import Comparadores.ComparadoresNorma.*;
import java.io.*;
import java.util.*;

public class MenuClase{
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void MenuClase() throws IOException {
        while (true) {
            System.out.println("1. Ver Clase.");
            System.out.println("2. Crear Clase.");
            System.out.println("3. Editar Clase.");
            System.out.println("4. Eliminar Clase.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if (Main.clases.isEmpty()) {
                    System.out.println("No hay clases guardadas en la base de datos.\n");
                } else {
                    for (Clase clase : Main.clases) {
                        System.out.println(clase);
                    }
                }

            } else if (opcionA.equals("2")) {
                Crear("","");
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

    public static void Crear(String llamadoEn, String ReferenciaDeInconsistencias) throws IOException {
        System.out.println("Para crear una clase, por favor ingrese en orden los datos solicitados:");
        System.out.println("Ingrese el nombre de la clase: ");
        String nombre = input.readLine();
        if (nombre.equals("")) {
            System.out.println("No ingreso el nombre.\n");
            return;
        }
        for (Clase clase : Main.clases) {
            if (clase.Nombre.equalsIgnoreCase(nombre)) {
                System.out.println("El nombre ingresado ya se encuentra registrado para otra clase.\n");
                return;
            }
        }

        String nombrenorm;
        if (llamadoEn.equals("Inconsistencias")){
            nombrenorm=ReferenciaDeInconsistencias;
            System.out.println("La Referencia de Norma asignada a esta Clase corresponde a \""+ReferenciaDeInconsistencias+"\"\n");
        }
        else {
            System.out.print("Ingrese la referencia de la norma asociada a la clase: ");
            nombrenorm = input.readLine();
        }
        if (nombrenorm.equals("")) {
            System.out.println("No ingreso la referencia de la norma.\n");
            return;
        }
        ArrayList<Norma> normasquenoson = new ArrayList<>();
        for (Norma norma1 : Main.normas) {
            if (!norma1.Referencia.equalsIgnoreCase(nombrenorm)) {
                normasquenoson.add(norma1);

            } else {
                System.out.println("Ingrese el voltaje de la prueba [V]: ");
                String voltaje = input.readLine();
                if (Double.parseDouble(voltaje) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                double voltajer = Double.parseDouble(voltaje);
                System.out.println("Ingrese la corriente de la prueba [A]: ");
                String corriente = input.readLine();
                if (Double.parseDouble(corriente) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                double corrienter = Double.parseDouble(corriente);
                System.out.println("Ingrese el voltaje máximo de la prueba [V]: ");
                String voltajem = input.readLine();
                if (Double.parseDouble(voltajem) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                double voltajemr = Double.parseDouble(voltajem);
                System.out.println("Ingrese la corriente máxima de la prueba [A]: ");
                String corrientem = input.readLine();
                if (Double.parseDouble(corrientem) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                double corrientemr = Double.parseDouble(corrientem);
                System.out.println("Ingrese el tiempo de la prueba [s]: ");
                String tiempo = input.readLine();
                if (Double.parseDouble(tiempo) < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                double tiempor = Double.parseDouble(tiempo);
                Clase clasenueva = new Clase(nombre, nombrenorm, voltajer, corrienter, voltajemr, corrientemr, tiempor);
                Main.clases.add(clasenueva);
                int indicenorma = Collections.binarySearch(Main.normas, new Norma(null, nombrenorm), new ComparadorReferenciaNorma());
                Norma normadelaclase = Main.normas.get(indicenorma);
                normadelaclase.Clases.add(nombre);
                Main.clases.sort(new ComparadorNombreClase());
                System.out.println("Operación realizada con éxito.\n");
                normasquenoson.clear();
                break;
            }
        }

        if (!normasquenoson.isEmpty()) {
            System.out.println("No hay normas con esa referencia guardadas en la base de datos.\n");
            normasquenoson.clear();
        }
    }

    public static void Editar() throws IOException {
        if (Main.clases.isEmpty()) {
            System.out.println("No hay clases guardadas en la base de datos.\n");
        } else {
            while (true) {
                System.out.println("Menu de edición de clases: ");
                System.out.println("1. Editar por nombre. ");
                System.out.println("0. Salir. ");
                String opcion = input.readLine();
                if (opcion.equals("1")) {
                    System.out.println("Ingrese el nombre de la clase: ");
                    String nombre = input.readLine();
                    if (nombre.equals("")) {
                        System.out.println("No ingreso el nombre.\n");
                        return;
                    }
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : Main.clases) {
                        if (clase.Nombre.equalsIgnoreCase(nombre)) {
                            System.out.println("El nombre de la clase seleccionada es: " + clase.Nombre + ".");
                            System.out.println("¿Desea modificar el nombre? (Y/N)");
                            String opcionnom = input.readLine();
                            if (opcionnom.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevonom = input.readLine();
                                if (nuevonom.equals("")) {
                                    System.out.println("No ingreso el nombre.\n");
                                }
                                for (Clase clase1 : Main.clases) {
                                    if (clase1.Nombre.equalsIgnoreCase(nuevonom)) {
                                        System.out.println("El nombre ingresado ya se encuentra asignado a otra clase.\n");
                                        return;
                                    }
                                }
                                for (Norma norma : Main.normas) {
                                    for (int i = 0; i < norma.Clases.size(); i++) {
                                        if (norma.Clases.get(i).equalsIgnoreCase(clase.Nombre)) {
                                            norma.Clases.set(i, nuevonom);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                for (Prueba prueba : Main.pruebas) {
                                    if (prueba.Clase.equalsIgnoreCase(clase.Nombre)) {
                                    prueba.Clase = nuevonom;
                                    }
                                }
                                clase.Nombre = nuevonom;
                                System.out.println("Operación realizada con éxito.\n");
                            }
                            System.out.println("La referencia de la norma asociada a la clase es: " + clase.Norma + ".");
                            System.out.println("¿Desea modificar la referencia de la norma asociada? (Y/N)");
                            String opcionnombrenorm = input.readLine();
                            if (opcionnombrenorm.equalsIgnoreCase("Y")) {
                                System.out.println("Ingrese la nueva referencia de la norma asociada: ");
                                String nuevonombrenorm = input.readLine();
                                if (nuevonombrenorm.equals("")) {
                                    System.out.println("No ingreso una nueva referencia.\n");
                                }
                                ArrayList<Norma> normasquenoson = new ArrayList<>();
                                for (Norma norma : Main.normas) {
                                    if (!norma.Referencia.equalsIgnoreCase(nuevonombrenorm)) {
                                        normasquenoson.add(norma);
                                    } else {
                                        clase.Norma = nuevonombrenorm;
                                        normasquenoson.clear();
                                        System.out.println("Operación realizada con éxito.\n");
                                        break;
                                    }
                                }
                                    if (!normasquenoson.isEmpty()) {
                                        System.out.println("La referencia para la norma asociada no se encuentra guardada en la base de datos.\n ");
                                        normasquenoson.clear();
                                        return;
                                    }
                              }
                                System.out.println("El voltaje nominal de prueba de la clase seleccionada es: " + clase.VoltajePrueba + " [V].");
                                System.out.println("¿Desea modificar el voltaje nominal de prueba de la clase? (Y/N)");
                                String opcionvol = input.readLine();
                                    if (opcionvol.equalsIgnoreCase("Y")) {
                                        System.out.println("Ingrese el nuevo voltaje nominal de prueba [V]: ");
                                        String nuevovol = input.readLine();
                                        if (nuevovol.equals("")) {
                                            System.out.println("No ingreso un nuevo voltaje nominal de prueba.\n");
                                        }
                                        clase.VoltajePrueba = Double.parseDouble(nuevovol);
                                        System.out.println("Operación realizada con éxito.\n");
                                    }
                                    System.out.println("La corriente nominal de prueba de la clase seleccionada es: " + clase.CorrientePrueba + " [A].");
                                    System.out.println("¿Desea modificar la corriente nominal de prueba de la clase? (Y/N)");
                                    String opcioncorr = input.readLine();
                                    if (opcioncorr.equalsIgnoreCase("Y")) {
                                        System.out.println("Ingrese la nueva corriente nominal de prueba [A]: ");
                                        String nuevocorr = input.readLine();
                                        if (nuevocorr.equals("")) {
                                            System.out.println("No ingreso una nueva corriente nominal de prueba.\n");
                                        }
                                        clase.CorrientePrueba = Double.parseDouble(nuevocorr);
                                        System.out.println("Operación realizada con éxito.\n");
                                    }
                                    System.out.println("El voltaje máximo de prueba de la clase seleccionada es: " + clase.VoltajeMaximo + " [V].");
                                    System.out.println("¿Desea modificar el voltaje máximo de prueba de la clase? (Y/N)");
                                    String opcionvolm = input.readLine();
                                    if (opcionvolm.equalsIgnoreCase("Y")) {
                                        System.out.println("Ingrese el nuevo voltaje máximo de prueba [V]: ");
                                        String nuevovolm = input.readLine();
                                        if (nuevovolm.equals("")) {
                                            System.out.println("No ingreso un nuevo voltaje máximo de prueba.\n");
                                        }
                                        clase.VoltajeMaximo = Double.parseDouble(nuevovolm);
                                        System.out.println("Operación realizada con éxito.\n");
                                    }
                                    System.out.println("La corriente máxima de prueba de la clase seleccionada es: " + clase.CorrienteMaxima + " [A].");
                                    System.out.println("¿Desea modificar la corriente máxima de prueba de la clase? (Y/N)");
                                    String opcioncorrm = input.readLine();
                                    if (opcioncorrm.equalsIgnoreCase("Y")) {
                                        System.out.println("Ingrese la nueva corriente máxima de prueba [A]: ");
                                        String nuevocorrm = input.readLine();
                                        if (nuevocorrm.equals("")) {
                                            System.out.println("No ingreso una nueva corriente máxima de prueba.\n");
                                        }
                                        clase.CorrienteMaxima = Double.parseDouble(nuevocorrm);
                                        System.out.println("Operación realizada con éxito.\n");
                                    }
                                    System.out.println("El tiempo de prueba de la clase seleccionada es: " + clase.Tiempo + " [s].");
                                    System.out.println("¿Desea modificar el tiempo de prueba de la clase? (Y/N)");
                                    String opciontiem = input.readLine();
                                    if (opciontiem.equalsIgnoreCase("Y")) {
                                        System.out.println("Ingrese el nuevo tiempo de prueba [s]: ");
                                        String nuevotiem = input.readLine();
                                        if (nuevotiem.equals("")) {
                                            System.out.println("No ingreso un nuevo tiempo de prueba.\n");
                                        }
                                        clase.Tiempo = Double.parseDouble(nuevotiem);
                                        System.out.println("Operación realizada con éxito.\n");
                                    }
                                    clasesquenoson.clear();
                                    break;
                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("La clase ingresada no se encuentra guardada en la base de datos.\n ");
                        clasesquenoson.clear();
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
            System.out.println("Menu de borrado de clases: ");
            System.out.println("1. Borrar por nombre. ");
            System.out.println("0. Salir. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre de la clase: ");
                String nombre = input.readLine();
                if (nombre.equals("")) {
                    System.out.println("No ingreso el nombre.\n");
                    return;
                }
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : Main.clases) {
                    if (clase.Nombre.equalsIgnoreCase(nombre)) {
                        for (Norma norma : Main.normas) {
                            for (String s : norma.Clases) {
                                if (s.equalsIgnoreCase(nombre)) {
                                    norma.Clases.remove(s);
                                    break;
                                }
                            }
                            break;
                        }
                        for (Prueba prueba : Main.pruebas) {
                            if (prueba.Clase.equalsIgnoreCase(nombre)) {
                                prueba.Clase = null;
                                break;
                            }
                        }
                        Main.clases.remove(clase);
                        System.out.println("Operación realizada con éxito.\n");
                        clasesquenoson.clear();
                        break;

                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El nombre ingresado no se encuentra asignado a ninguna clase.\n");
                    clasesquenoson.clear();
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
