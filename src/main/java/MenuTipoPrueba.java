import Clases.Laboratorio;
import Clases.Norma;
import Clases.Prueba;
import Clases.TipoPrueba;
import Comparadores.ComparadoresLaboratorio.*;
import Comparadores.ComparadoresTipoPrueba.*;
import Comparadores.ComparadoresNorma.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class MenuTipoPrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void munuTipoPrueba() throws IOException {
        while (true) {
            System.out.println("1. Ver Tipos de prueba.");
            System.out.println("2. Crear Tipos de prueba.");
            System.out.println("3. Editar Tipos de prueba.");
            System.out.println("4. Eliminar Tipos de prueba.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            boolean comparador;
            if (opcionA.equals("1")) {
                comparador = VerTipoPrueba();
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("2")) {
                comparador = CrearTipoPrueba("",0);
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("3")) {
                comparador = EditarTipoPrueba(null);
                if (comparador) {
                    return;
                }
            } else if (opcionA.equals("4")) {
                comparador = EliminarTipoPrueba(null);
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

    public static boolean VerTipoPrueba() {
        if (Main.tipopruebas.isEmpty()) {
            System.out.println("No hay tipos de prueba en el sistema");
            return false;
        } else {
            for (TipoPrueba tipoprueba : Main.tipopruebas) {
                System.out.println(tipoprueba);
            }
            return true;
        }
    }

    public static boolean CrearTipoPrueba(String llamadoEn, int NITdeInconsistencias) throws IOException {
        int comparador;
        int indexN;
        int indexL=-1;
        int NITLab;
        if (llamadoEn.equals("Inconsistencias")){
            NITLab=NITdeInconsistencias;
            System.out.println("El NIT de laboratorio seleccionado corresponde a \""+NITdeInconsistencias+"\"\n");
        }
        else{
            System.out.println("Ingrese el NIT del laboratorio");
            String nitLab = input.readLine();
            if (nitLab.equals("")) {
                System.out.println("No se ingreso ninguna direccion");
                return false;
            } else {
                nitLab = nitLab.replaceAll("[.]", "");
                NITLab = Integer.parseInt(nitLab);
                indexL = Collections.binarySearch(Main.laboratorios, new Laboratorio(NITLab, "", ""), new ComparadorNITLaboratorio());
                if (indexL < 0) {
                    System.out.println("No se encuentra el laboratorio con ese NIT");
                    return false;
                }
            }
        }
        System.out.println("Ingrese el nombre del tipo de prueba");
        String nombre = input.readLine();
        if (nombre.equals("")) {
            System.out.println("No se ingreso ningun nombre");
            return false;
        } else {
            nombre = nombre + "-" + Main.laboratorios.get(indexL).Nombre;
            comparador = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nombre, "", 0), new ComparadorNombreTipoPrueba());
            if (comparador >= 0) {
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese la referencia de la norma utilizada en el tipo de prueba");
        String RefNorma = input.readLine();
        if (RefNorma.equals("")) {
            System.out.println("No se ingreso ninguna referencia");
            return false;
        } else {
            indexN = Collections.binarySearch(Main.normas, new Norma("", RefNorma), new ComparadorReferenciaNorma());
            if (indexN < 0) {
                System.out.println("La norma no se encuentra en la base de datos");
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
        Main.laboratorios.get(indexL).TipoPruebas.add(nombre);
        return true;
    }

    public static boolean EditarTipoPrueba(String bnombre) throws IOException {
        int comparador;
        int indexN = -1;
        int indexL = -1;
        int index;
        String nombreb;
        if (bnombre == null){
            if (Main.tipopruebas.isEmpty()) {
                System.out.println("No hay tipos de prueba en la base de datos");
                return false;
            }
            System.out.println("Ingrese el nombre del tipo de prueba y en nombre del laboratorio de la siguiente forma\n" + "Nombre del tipo de prueba-Nombre del laboratorio");
            nombreb = input.readLine();
        }else{
            nombreb = bnombre;
        }
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
        int indexS = viejoNombre.indexOf('-');
        String nombrelab = viejoNombre.substring(indexS+1);
        System.out.println("Es suficiente con ingresdar el nombre del tipo prueba");
        System.out.println("Nombre: " + Main.tipopruebas.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")) {
            nuevoNombre = Main.tipopruebas.get(index).Nombre;
        } else {
            nuevoNombre = nuevoNombre + "-" + nombrelab;
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
            indexN = Collections.binarySearch(Main.normas, new Norma("", nuevaRefNorma), new ComparadorReferenciaNorma());
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
            indexL = Collections.binarySearch(Main.laboratorios, new Laboratorio(nuevoNITlab, "", ""), new ComparadorNITLaboratorio());
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

        Main.tipopruebas.get(index).RefNorma = nuevaRefNorma;
        Main.tipopruebas.get(index).NitLaboratorio = nuevoNITlab;

        if (!nuevoNombre.equalsIgnoreCase(Main.tipopruebas.get(index).Nombre)) {
            Main.tipopruebas.get(index).Nombre = nuevoNombre;
            Collections.sort(Main.tipopruebas, new ComparadorNombreTipoPrueba());
            if(indexL>=0){
                if (!Main.laboratorios.get(indexL).TipoPruebas.isEmpty()) {
                    for (int j = 0; j < Main.laboratorios.get(indexL).TipoPruebas.size(); j++) {
                        if (Main.laboratorios.get(indexL).TipoPruebas.get(j).equalsIgnoreCase(viejoNombre)) {
                            Main.laboratorios.get(indexL).TipoPruebas.set(j, nuevoNombre);
                            break;
                        }
                    }
                }
            }
            if(!Main.tipopruebas.get(index).Pruebas.isEmpty()){
                for (Prueba prueba : Main.pruebas) {
                    if(prueba.TipoPrueba.equalsIgnoreCase(viejoNombre)){
                        prueba.TipoPrueba = nuevoNombre;
                    }
                }
            }
        }
        return true;
    }

    public static boolean EliminarTipoPrueba(String bnombre) throws IOException {
        int index;
        String nombreb;
        if(bnombre == null){
            if (Main.tipopruebas.isEmpty()) {
                System.out.println("No hay tipos de prueba en la base de datos");
                return false;
            }
            System.out.println("Ingrese el nombre del tipo de prueba y en nombre del laboratorio de la siguiente forma\n" + "Nombre del tipo de prueba-Nombre del laboratorio");
            nombreb = input.readLine();
        }else{
            nombreb = bnombre;
        }
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
        int indexL = Collections.binarySearch(Main.laboratorios, new Laboratorio(NITlab, "", ""), new ComparadorNITLaboratorio());
        if(indexL>=0){
            for (int j = 0; j < Main.laboratorios.get(indexL).TipoPruebas.size(); j++) {
                if (viejoNombre.equalsIgnoreCase(Main.laboratorios.get(indexL).TipoPruebas.get(j))) {
                    Main.laboratorios.get(indexL).TipoPruebas.remove(j);
                    break;
                }
            }
        }
        if(!Main.tipopruebas.get(index).Pruebas.isEmpty()){
            for (Prueba prueba : Main.pruebas) {
                if(prueba.TipoPrueba.equalsIgnoreCase(viejoNombre)){
                    prueba.TipoPrueba = null;
                }
            }
        }
        return true;
    }
}