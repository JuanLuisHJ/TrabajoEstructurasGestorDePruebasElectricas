import Clases.*;
import Comparadores.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
                System.out.println("La opción ingresada no es válida\n");
            }
        }
    }

    public static boolean VerPrueba() {
        if (Main.pruebas.isEmpty()) {
            System.out.println("No hay pruebas en el sistema\n");
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
        System.out.print("Ingrese el nombre la prueba: ");
        String nombre = input.readLine();
        if (nombre.equals("")) {
            System.out.println("No se ingresó ningun nombre\n");
            return false;
        }
        System.out.print("Ingrese el NIT del laboratorio: ");
        String NIT = input.readLine();
        int nNIT;
        if (NIT.equals("")){
            System.out.println("No se ingresó ningun NIT\n");
            return false;
        }else{
            NIT = NIT.replaceAll("[.]","");
            nNIT = Integer.parseInt(NIT);
            indexL = Collections.binarySearch(Main.laboratorios,new Laboratorio(nNIT,"",""),new ComparadorNITLaboratorio());
            if (indexL<0){
                System.out.println("El NIT no se encuentra en la base de datos \n");
                return false;
            }
        }
        System.out.print("Ingrese el nombre del tipo de prueba: ");
        String nombretipoprueba = input.readLine() ;
        if (nombretipoprueba.equals("")) {
            System.out.println("No se ingresó ningun nombre\n");
            return false;
        } else {
            nombretipoprueba = nombretipoprueba + "-"+ Main.laboratorios.get(indexL).Nombre;
            indexT = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nombretipoprueba, "", 0), new ComparadorNombreTipoPrueba());
            if (indexT < 0) {
                System.out.println("El Nombre no se encuentra en la base de datos");
                return false;
            }
        }
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreclase = input.readLine();
        if (nombreclase.equals("")) {
            System.out.println("No se ingresó ninguna clase\n");
            return false;
        } else {
            indexC = Collections.binarySearch(Main.clases, new Clase(nombreclase,"",0,0,0,0,0), new ComparadorNombreClase());
            if (indexC < 0) {
                System.out.println("La clase no se encuentra en la base de datos\n");
                return false;
            }
        }
        ArrayList<String> Dispositivos = new ArrayList<>();
        System.out.println("Ingrese las referencias de los dispositivos, cuando haya ingresado todos los dispositivos ingrese fin:");
        String refdispositivo = input.readLine();
        while (!refdispositivo.equalsIgnoreCase("fin")) {
            if(refdispositivo.equals("")){
                System.out.println("No se ingreso ninguna nombre");
                return false;
            }
            int indexD = Collections.binarySearch(Main.dispositivos,new Dispositivo(refdispositivo,"",0,0), new ComparadorReferenciaDispositivo());
            if (indexD<0){
                System.out.println("El dispositivo no se encuentra en la base de datos\n");
                return false;
            }
            Dispositivos.add(refdispositivo);
            refdispositivo = input.readLine();
        }

        String ID = Main.laboratorios.get(indexL).IDprueba + "-" + Main.laboratorios.get(indexL).NIT;
        Main.laboratorios.get(indexL).IDprueba += 1;
        Prueba nuevaPrueba = new Prueba(ID,nombre,nombretipoprueba,nombreclase,Dispositivos);
        if (Main.pruebas.isEmpty()) {
            Main.pruebas.add(nuevaPrueba);
        } else {
            boolean lista = true;
            for (int i = 0; i < Main.pruebas.size(); i++) {
                if (ID.compareTo(Main.pruebas.get(i).ID)<0) {
                    Main.pruebas.add(i, nuevaPrueba);
                    lista = false;
                    break;
                }
            }
            if (lista) {
                Main.pruebas.add(nuevaPrueba);
            }
        }
        Main.tipopruebas.get(indexT).Pruebas.add(ID);
        return true;
    }

    public static boolean EditarPrueba() throws IOException {
        int indexT= -1;
        int indexL = -1;
        int indexC = -1;
        if (Main.pruebas.isEmpty()) {
            System.out.println("No hay tipos de prueba en la base de datos\n");
            return false;
        }
        int index;
        System.out.print("Ingrese el ID de la prueba: ");
        String IDb = input.readLine();
        if (IDb.equals("")) {
            System.out.println("No se ingresó ningun ID\n");
            return false;
        } else {
            IDb = IDb.replaceAll("[.]","");
            index = Collections.binarySearch(Main.pruebas, new Prueba(IDb,"","","",null), new ComparadorIDPrueba());
            if (index < 0) {
                System.out.println("El ID no se encuentra en la base de datos\n");
                return false;
            }
        }

        String viejoID = Main.pruebas.get(index).ID;
        int indexS = viejoID.indexOf('-');
        int NITlab = Integer.parseInt(viejoID.substring(indexS+1));
        System.out.println("ID: "+ Main.pruebas.get(index).ID);
        System.out.print("Ingrese únicamente la primera parate le ID: ");
        String nuevoID = input.readLine();
        if (nuevoID.equals("")){
            nuevoID = Main.pruebas.get(index).ID;
        }else{
            nuevoID = nuevoID.replaceAll("[.]","")+"-"+NITlab;
            int comparadorN = Collections.binarySearch(Main.pruebas,new Prueba(nuevoID,"","","",null),new ComparadorIDPrueba());
            if (comparadorN >= 0){
                System.out.println("El ID ya se encuentra en la base de datos\n");
                return false;
            }
        }

        System.out.println("Nombre: " + Main.pruebas.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")) {
            nuevoNombre = Main.pruebas.get(index).Nombre;
        }

        System.out.println("Nombre Tipo de prueba: " + Main.pruebas.get(index).TipoPrueba);
        System.out.print("Ingrese el nombre del tipo de prueba y en nombre del laboratorio de la siguiente forma\n" + "Nombre del tipo de prueba-Nombre del laboratorio: ");
        String nuevoNombreTP = input.readLine();
        if (nuevoNombreTP.equals("")) {
            nuevoNombreTP = Main.pruebas.get(index).TipoPrueba;
        } else {
            indexT = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(nuevoNombreTP, "", 0), new ComparadorNombreTipoPrueba());
            if (indexT < 0) {
                System.out.println("El Tipo de prueba no se encuentra en la base de datos \n");
                return false;
            }
        }

        System.out.print("Clase: "+ Main.pruebas.get(index).Clase+": ");
        String nuevonombreclase = input.readLine();
        if (nuevonombreclase.equals("")) {
            nuevonombreclase = Main.pruebas.get(index).Clase;
        } else {
            indexC = Collections.binarySearch(Main.clases, new Clase(nuevonombreclase,"",0,0,0,0,0), new ComparadorNombreClase());
            if (indexC < 0) {
                System.out.println("La clase no se encuentra en la base de datos\n");
                return false;
            }
        }

        ArrayList<String> nuevosDispositivos = new ArrayList<>();
        System.out.println("Referencias dispositivos: "+ Main.pruebas.get(index).RefDispositivos);
        System.out.println("Ingrese las referencias de los dispositivos, cuando haya ingresado todos los dispositivos ingrese fin: ");
        String refdispositivo = input.readLine();
        if(refdispositivo.equals("")){
            nuevosDispositivos = Main.pruebas.get(index).RefDispositivos;
        }else{
            while (!refdispositivo.equalsIgnoreCase("fin")) {
                if(refdispositivo.equals("")){
                    System.out.println("No se ingresó ninguna nombre\n");
                    return false;
                }
                int indexD = Collections.binarySearch(Main.dispositivos,new Dispositivo(refdispositivo,"",0,0), new ComparadorReferenciaDispositivo());
                if (indexD<0){
                    System.out.println("El dispositivo no se encuentra en la base de datos\n");
                    return false;
                }
                nuevosDispositivos.add(refdispositivo);
                refdispositivo = input.readLine();
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
        Main.pruebas.get(index).Nombre = nuevoNombre;
        Main.pruebas.get(index).TipoPrueba = nuevoNombreTP;
        Main.pruebas.get(index).Clase = nuevonombreclase;
        Main.pruebas.get(index).RefDispositivos = nuevosDispositivos;

        if (!nuevoID.equalsIgnoreCase(Main.pruebas.get(index).ID)) {
            Main.pruebas.get(index).ID = nuevoID;
            Collections.sort(Main.pruebas, new ComparadorIDPrueba());
            if(indexT>=0){
                if (!Main.tipopruebas.get(indexT).Pruebas.isEmpty()) {
                    for (int j = 0; j < Main.tipopruebas.get(indexT).Pruebas.size(); j++) {
                        if (Main.tipopruebas.get(indexT).Pruebas.get(j).equalsIgnoreCase(viejoID)) {
                            Main.tipopruebas.get(indexL).Pruebas.set(j, nuevoID);
                            break;
                        }
                    }
                }
            }
        }
        return true;

    }

    public static boolean EliminarPrueba() throws IOException {
        if (Main.pruebas.isEmpty()) {
            System.out.println("No hay tipos de prueba en la base de datos\n");
            return false;
        }
        int index;
        System.out.print("Ingrese el ID de la prueba: ");
        String IDb = input.readLine();
        if (IDb.equals("")) {
            System.out.println("No se ingresó ningun ID\n");
            return false;
        } else {
            IDb = IDb.replaceAll("[.]","");
            index = Collections.binarySearch(Main.pruebas, new Prueba(IDb,"","","",null), new ComparadorIDPrueba());
            if (index < 0) {
                System.out.println("El ID no se encuentra en la base de datos\n");
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

        Main.pruebas.remove(index);
        String viejoID = Main.pruebas.get(index).ID;
        int indexT = Collections.binarySearch(Main.tipopruebas, new TipoPrueba(Main.pruebas.get(index).TipoPrueba,"",-1), new ComparadorNombreTipoPrueba());
        if(indexT>=0){
            for (int j = 0; j < Main.tipopruebas.get(indexT).Pruebas.size(); j++) {
                if (viejoID.equalsIgnoreCase(Main.tipopruebas.get(indexT).Pruebas.get(j))) {
                    Main.tipopruebas.get(indexT).Pruebas.remove(j);
                    break;
                }
            }
        }
        for (int j = 0; j < Main.tipopruebas.get(indexT).Pruebas.size(); j++) {
            if (viejoID.equalsIgnoreCase(Main.tipopruebas.get(indexT).Pruebas.get(j))) {
                Main.tipopruebas.get(indexT).Pruebas.remove(j);
                break;
            }
        }
        if(Main.pruebas.get(index).NumInforme!= -1){
            for (Informe informe : Main.informes) {
                if(informe.IDPrueba==Main.pruebas.get(index).NumInforme){
                    informe.IDPrueba = -1;
                }
            }
        }
        return true;
    }
}
