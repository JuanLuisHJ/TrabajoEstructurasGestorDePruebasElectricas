import Clases.Laboratorio;
import Clases.Norma;
import Clases.Prueba;
import Clases.TipoPrueba;
import Comparadores.ComparadorNITLaboratorio;
import Comparadores.ComparadorNombreTipoPrueba;
import Comparadores.ComparadorReferenciaNorma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class MenuPrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void munuPrueba() throws IOException {
        while (true) {
            System.out.println("1. Ver Prueba.");
            System.out.println("2. Crear Prueba.");
            System.out.println("3. Editar Prueba.");
            System.out.println("4. Eliminar Prueba.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            boolean comparador;
            if (opcionA.equals("1")) {
                comparador = VerPrueba();
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("2")) {
                comparador = CrearPrueba();
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("3")) {
                comparador = EditarPrueba();
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("4")) {
                comparador = EliminarPrueba();
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("0")) {
                return;
            } else {
                System.out.println("La opción ingresada no es válida");
            }
        }
    }

    public static boolean VerPrueba() {
        if (Main.pruebas.isEmpty()) {
            System.out.println("No hay prueba en el sistema");
            return false;
        } else {
            for (Prueba prueba : Main.pruebas) {
                System.out.println(prueba);
            }
            return true;
        }
    }

    public static boolean CrearPrueba() throws IOException {
        int indexN;
        int indexL;
        int indexT;
        int indexC;
        System.out.println("Ingrese el nombre la prueba");
        String nombre = input.readLine();
        if (nombre.equals("")) {
            System.out.println("No se ingreso ningun nombre");
            return false;
        }
        System.out.println("Ingrese el NIT del laboratorio");
        String NIT = input.readLine();
        int nNIT;
        if (NIT.equals("")){
            System.out.println("No se ingreso ninguna NIT");
            return false;
        }else{
            NIT = NIT.replaceAll("[.]","");
            nNIT = Integer.parseInt(NIT);
            indexL = Collections.binarySearch(Main.laboratorios,new Laboratorio(nNIT,"",""),new ComparadorNITLaboratorio());
            if (indexL<0){
                System.out.println("El NIT no se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese el nombre del tipo de prueba");
        String nombretipoprueba = input.readLine() ;
        if (nombretipoprueba.equals("")) {
            System.out.println("No se ingreso ningun nombre");
            return false;
        } else {
            nombretipoprueba = nombretipoprueba + " - "+ Main.laboratorios.get(indexL).Nombre;
            indexT = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nombretipoprueba, "", 0), new ComparadorNombreTipoPrueba());
            if (indexT < 0) {
                System.out.println("El Nombre no se encuentra en la base de datos");
                return false;
            }
        }

        /*System.out.println("Ingrese el nombre de la clase");
        String nombreclase = input.readLine();
        if (RefNorma.equals("")) {
            System.out.println("No se ingreso ninguna nombre");
            return false;
        } else {
            indexN = Collections.binarySearch(Main.normas, new Norma("", RefNorma, ""), new ComparadorReferenciaNorma());
            if (indexN < 0) {
                System.out.println("La clase no se encuentra en la base de datos");
                return false;
            }
        }*/

        System.out.println("Ingrese la referencia de los dispositivos");
        String nombreclase = input.readLine();
        if (RefNorma.equals("")) {
            System.out.println("No se ingreso ninguna nombre");
            return false;
        } else {
            indexN = Collections.binarySearch(Main.normas, new Norma("", RefNorma, ""), new ComparadorReferenciaNorma());
            if (indexN < 0) {
                System.out.println("La clase no se encuentra en la base de datos");
                return false;
            }
        }

        TipoPrueba nuevoTipoprueba = new TipoPrueba(nombre, RefNorma, NITLab);
        if (Main.tipopruebas.isEmpty()) {
            Main.tipopruebas.add(nuevoTipoprueba);
        } else {
            boolean lista = true;
            for (int i = 0; i < Main.tipopruebas.size(); i++) {
                if (nombre.toLowerCase().compareTo(Main.tipopruebas.get(i).Nombre.toLowerCase()) < 0) {
                    Main.tipopruebas.add(i, nuevoTipoprueba);
                    lista = false;
                    break;
                }
            }
            if (lista) {
                Main.tipopruebas.add(nuevoTipoprueba);
            }
        }
        return true;
    }

    public static boolean EditarTipoPrueba() throws IOException {
        int comparador;
        int indexN = -1;
        int indexL = -1;
        if (Main.laboratorios.isEmpty()) {
            System.out.println("No hay tipos de prueba en la base de datos");
            return false;
        }
        int index;
        System.out.println("Ingrese el nombre del tipo de prueba y en nombre del laboratorio de la siguiente forma\n" + "Nombre del tipo de prueba - Nombre del laboratorio");
        String nombreb = input.readLine();
        if (nombreb.equals("")) {
            System.out.println("No se ingreso ningun nombre");
            return false;
        } else {
            index = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nombreb, "", 0), new ComparadorNombreTipoPrueba());
            if (index < 0) {
                System.out.println("El Nombre no se encuentra en la base de datos");
                return false;
            }
        }
        String viejoNombre = Main.tipopruebas.get(index).Nombre;
        System.out.println("Es suficiente con ingresdar el nombre de la prueba");
        System.out.println("Nombre: " + Main.tipopruebas.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")) {
            nuevoNombre = Main.tipopruebas.get(index).Nombre;
        } else {
            comparador = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nuevoNombre, "", 0), new ComparadorNombreTipoPrueba());
            if (comparador >= 0) {
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }

        System.out.println("Referencia norma: " + Main.tipopruebas.get(index).RefNorma);
        String nuevaRefNorma = input.readLine();
        if (nuevaRefNorma.equals("")) {
            nuevaRefNorma = Main.tipopruebas.get(index).RefNorma;
        } else {
            indexN = Collections.binarySearch(Main.normas, new Norma("", nuevaRefNorma, ""), new ComparadorReferenciaNorma());
            if (indexN < 0) {
                System.out.println("La norma no se encuentra en la base de datos");
                return false;
            }
        }

        System.out.println("NIT del laboratorio: " + Main.tipopruebas.get(index).NitLaboratorio);
        String nuevonitLab = input.readLine();
        int nuevoNITlab;
        if (nuevonitLab.equals("")) {
            nuevoNITlab = Main.tipopruebas.get(index).NitLaboratorio;
        } else {
            nuevonitLab = nuevonitLab.replaceAll("[.]", "");
            nuevoNITlab = Integer.parseInt(nuevonitLab);
            indexL = Collections.binarySearch(Main.laboratorios, new Laboratorio(nuevoNITlab, "", ""), new ComparadorNITLaboratorio());
            if (indexL < 0) {
                System.out.println("No se encuentra el laboratorio con ese NIT");
                return false;
            }
        }

        while (true) {
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")) {
                break;
            } else if (confir.equalsIgnoreCase("N")) {
                return true;
            }
        }
        nuevoNombre = nuevoNombre + Main.laboratorios.get(index).Nombre;
        Main.tipopruebas.get(index).RefNorma = nuevaRefNorma;
        Main.tipopruebas.get(index).NitLaboratorio = nuevoNITlab;

        if (!nuevoNombre.equalsIgnoreCase(Main.tipopruebas.get(index).Nombre)) {
            Main.tipopruebas.get(index).Nombre = nuevoNombre;
            Collections.sort(Main.tipopruebas, new ComparadorNombreTipoPrueba());
            if (!Main.laboratorios.get(indexL).TipoPruebas.isEmpty()) {
                for (int j = 0; j < Main.laboratorios.get(indexL).TipoPruebas.size(); j++) {
                    if (Main.laboratorios.get(indexL).TipoPruebas.get(j).equalsIgnoreCase(viejoNombre)) {
                        Main.laboratorios.get(indexL).TipoPruebas.set(j, nuevaRefNorma);
                        break;
                    }
                }
            }
            if (Main.normas.get(indexN).TipoPrueba.equalsIgnoreCase(viejoNombre)) {
                Main.normas.get(indexN).TipoPrueba = nuevoNombre;
            }
        }
        return true;

    }

    public static boolean EliminarTipoPrueba() throws IOException {
        if (Main.laboratorios.isEmpty()) {
            System.out.println("No hay tipos de prueba en la base de datos");
            return false;
        }
        int index;
        System.out.println("Ingrese el nombre del tipo de prueba y en nombre del laboratorio de la siguiente forma\n" + "Nombre del tipo de prueba - Nombre del laboratorio");
        String nombreb = input.readLine();
        if (nombreb.equals("")) {
            System.out.println("No se ingreso ningun nombre");
            return false;
        } else {
            index = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nombreb, "", 0), new ComparadorNombreTipoPrueba());
            if (index < 0) {
                System.out.println("El Nombre no se encuentra en la base de datos");
                return false;
            }
        }

        while (true) {
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")) {
                break;
            } else if (confir.equalsIgnoreCase("N")) {
                return true;
            }
        }

        Main.tipopruebas.remove(index);
        String viejoNombre = Main.tipopruebas.get(index).Nombre;
        int NITlab = Main.tipopruebas.get(index).NitLaboratorio;
        String RefNorma = Main.tipopruebas.get(index).RefNorma;
        int indexL = Collections.binarySearch(Main.laboratorios, new Laboratorio(NITlab, "", ""), new ComparadorNITLaboratorio());
        for (int j = 0; j < Main.laboratorios.get(indexL).TipoPruebas.size(); j++) {
            if (viejoNombre.equalsIgnoreCase(Main.laboratorios.get(indexL).TipoPruebas.get(j))) {
                Main.laboratorios.get(indexL).TipoPruebas.remove(j);
                break;
            }
        }
        int indexN = Collections.binarySearch(Main.normas, new Norma("", RefNorma, ""), new ComparadorReferenciaNorma());
        Main.normas.get(indexN).TipoPrueba = null;
        return true;
    }
}
