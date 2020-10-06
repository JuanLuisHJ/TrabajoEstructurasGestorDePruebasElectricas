import Clases.Laboratorio;
import Clases.Norma;
import Clases.TipoPrueba;
import Comparadores.ComparadorNITLaboratorio;
import Comparadores.ComparadorNombreTipoPrueba;
import Comparadores.ComparadorReferenciaNorma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class MenuTipoPrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void munuTipoPrueba() throws IOException {
        while(true){
            System.out.println("1. Ver Tipos de prueba.");
            System.out.println("2. Crear Tipos de prueba.");
            System.out.println("3. Editar Tipos de prueba.");
            System.out.println("4. Eliminar Tipos de prueba.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            boolean comparador;
            if (opcionA.equals("1")){
                comparador = VerTipoPrueba();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("2")){
                comparador = CrearTipoPrueba();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("3")){
                comparador = EditarTipoPrueba();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("4")){
                comparador = EliminarTipoPrueba();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("0")){
                return;
            }else{
                System.out.println("La opción ingresada no es válida");
            }
        }
    }

    public static boolean VerTipoPrueba(){
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay tipos de prueba en el sistema");
            return false;
        }else{
            for (TipoPrueba tipoprueba : Main.tipopruebas) {
                System.out.println(tipoprueba);
            }
            return true;
        }
    }

    public static boolean CrearTipoPrueba() throws IOException {
        int comparador;
        int indexN;
        int indexL;
        System.out.println("Ingrese el nombre del tipo de prueba");
        String nombre = input.readLine();
        if (nombre.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }else{
            comparador = Collections.binarySearch(Main.tipopruebas,new TipoPrueba(nombre,"",0),new ComparadorNombreTipoPrueba());
            if (comparador>=0){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese la referencia de la norma utilizada en el tipo de prueba");
        String RefNorma = input.readLine();
        if (RefNorma.equals("")){
            System.out.println("No se ingreso ninguna referencia");
            return false;
        }else{
            indexN = Collections.binarySearch(Main.normas,new Norma("",RefNorma,""),new ComparadorReferenciaNorma());
            if (indexN<0){
                System.out.println("La norma no se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese el ID del laboratorio");
        String nitLab = input.readLine();
        int NITLab;
        if (nitLab.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }else{
            nitLab = nitLab.replaceAll("[.]","");
            NITLab = Integer.parseInt(nitLab);
            indexL = Collections.binarySearch(Main.laboratorios,new Laboratorio(NITLab,"",""),new ComparadorNITLaboratorio());
            if (indexL<0){
                System.out.println("No se encuentra el laboratorio con ese NIT");
                return false;
            }
        }
        nombre = nombre + " - " + Main.laboratorios.get(indexL).Nombre;
        TipoPrueba nuevoTipoprueba = new TipoPrueba(nombre,RefNorma,NITLab);
        if (Main.tipopruebas.isEmpty()){
            Main.tipopruebas.add(nuevoTipoprueba);
        }else{
            boolean lista = true;
            for (int i=0;i<Main.tipopruebas.size();i++){
                if (nombre.toLowerCase().compareTo(Main.tipopruebas.get(i).Nombre.toLowerCase())<0){
                    Main.tipopruebas.add(i,nuevoTipoprueba);
                    lista = false;
                    break;
                }
            }
            if(lista){
                Main.tipopruebas.add(nuevoTipoprueba);
            }
        }
        return true;
    }

    public static boolean EditarLaboratorioN() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return false;
        }
        boolean comparador;
        System.out.println("Ingrese el nombre del laboratorio");
        String nombreb = input.readLine();
        if (nombreb.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }
        int index = -1;
        for (int i=0;i<Main.laboratorios.size();i++){
            if (nombreb.equalsIgnoreCase(Main.laboratorios.get(i).Nombre)) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el laboratorio con ese nombre");
            return false;
        }
        System.out.println("Nombre: "+ Main.laboratorios.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")){
            nuevoNombre = Main.laboratorios.get(index).Nombre;
        }else{
            comparador = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.Nombre.equals(nuevoNombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int viejoNIT = Main.laboratorios.get(index).NIT;
        System.out.println("NIT: "+ Main.laboratorios.get(index).NIT);
        String nuevonit = input.readLine();
        int nuevoNIT;
        if (nuevonit.equals("")){
            nuevoNIT = Main.laboratorios.get(index).NIT;
        }else{
            nuevonit = nuevonit.replaceAll("[.]","");
            nuevoNIT = Integer.parseInt(nuevonit);
            int comparadorN = Collections.binarySearch(Main.laboratorios,new Laboratorio(nuevoNIT,"",""),new ComparadorNITLaboratorio());
            if (comparadorN >= 0){
                System.out.println("El NIT ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Direccion del laboratorio: "+ Main.laboratorios.get(index).Direccion);
        String nuevaDireccion = input.readLine();
        if (nuevaDireccion.equals("")){
            nuevaDireccion = Main.laboratorios.get(index).Direccion;
        }

        while(true){
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")){
                break;
            }else if(confir.equalsIgnoreCase("N")){
                return true;
            }
        }

        Main.laboratorios.get(index).Nombre = nuevoNombre;
        Main.laboratorios.get(index).Direccion = nuevaDireccion;
        if (nuevoNIT != viejoNIT){
            Main.laboratorios.get(index).NIT = nuevoNIT;
            Collections.sort(Main.laboratorios,new ComparadorNITLaboratorio());
            if (!Main.tipopruebas.isEmpty()){
                for (TipoPrueba tipoprueba : Main.tipopruebas) {
                    if (tipoprueba.NitLaboratorio==viejoNIT){
                        tipoprueba.NitLaboratorio = nuevoNIT;
                    }
                }
            }
        }
        return true;

    }

    public static boolean EditarLaboratorioID() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return false;
        }
        boolean comparador;
        System.out.println("Ingrese el ID del laboratorio");
        String nitb = input.readLine();
        if (nitb.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
        nitb = nitb.replaceAll("[.]","");
        int NITb = Integer.parseInt(nitb);
        int index = Collections.binarySearch(Main.laboratorios,new Laboratorio(NITb,"",""),new ComparadorNITLaboratorio());
        if (index<0){
            System.out.println("No se encuentra el laboratorio con ese ID");
            return false;
        }
        System.out.println("Nombre: "+ Main.laboratorios.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")){
            nuevoNombre = Main.laboratorios.get(index).Nombre;
        }else{
            comparador = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.Nombre.equalsIgnoreCase(nuevoNombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int viejoNIT = Main.laboratorios.get(index).NIT;
        System.out.println("NIT: "+ Main.laboratorios.get(index).NIT);
        String nuevonit = input.readLine();
        int nuevoNIT;
        if (nuevonit.equals("")){
            nuevoNIT = Main.laboratorios.get(index).NIT;
        }else{
            nuevonit = nuevonit.replaceAll("[.]","");
            nuevoNIT = Integer.parseInt(nuevonit);
            int comparadorN = Collections.binarySearch(Main.laboratorios,new Laboratorio(nuevoNIT,"",""),new ComparadorNITLaboratorio());
            if (comparadorN >= 0){
                System.out.println("El NIT ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Direccion del laboratorio: "+ Main.laboratorios.get(index).Direccion);
        String nuevaDireccion = input.readLine();
        if (nuevaDireccion.equals("")){
            nuevaDireccion = Main.laboratorios.get(index).Direccion;
        }

        while(true){
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")){
                break;
            }else if(confir.equalsIgnoreCase("N")){
                return true;
            }
        }

        Main.laboratorios.get(index).Nombre = nuevoNombre;
        Main.laboratorios.get(index).Direccion = nuevaDireccion;
        if (nuevoNIT != viejoNIT){
            Main.laboratorios.get(index).NIT = nuevoNIT;
            Collections.sort(Main.laboratorios,new ComparadorNITLaboratorio());
            if (!Main.tipopruebas.isEmpty()){
                for (TipoPrueba tipoprueba : Main.tipopruebas) {
                    if (tipoprueba.NitLaboratorio==viejoNIT){
                        tipoprueba.NitLaboratorio = nuevoNIT;
                    }
                }
            }
        }
        return true;
    }

    public static boolean EliminarLaboratorioN() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return false;
        }
        System.out.println("Ingrese el nombre del laboratorio");
        String nombreb = input.readLine();
        if (nombreb.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }
        int index = -1;
        for (int i=0;i<Main.laboratorios.size();i++){
            if (nombreb.equalsIgnoreCase(Main.laboratorios.get(i).Nombre)) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el laboratorio con ese nombre");
            return false;
        }

        while(true){
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")){
                break;
            }else if(confir.equalsIgnoreCase("N")){
                return true;
            }
        }

        int viejoNIT = Main.laboratorios.get(index).NIT;
        Main.laboratorios.remove(index);
        if(!Main.pruebas.isEmpty()){
            for (TipoPrueba tipoprueba : Main.tipopruebas) {
                if (tipoprueba.NitLaboratorio== viejoNIT){
                    tipoprueba.NitLaboratorio = -1;
                }
            }
        }
        return true;
    }

    public static boolean EliminarLaboratorioID() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return false;
        }
        System.out.println("Ingrese el ID del laboratorio");
        String nitb = input.readLine();
        if (nitb.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
        nitb = nitb.replaceAll("[.]","");
        int NITb = Integer.parseInt(nitb);
        int index = Collections.binarySearch(Main.laboratorios,new Laboratorio(NITb,"",""),new ComparadorNITLaboratorio());
        if (index<0){
            System.out.println("No se encuentra el laboratorio con ese ID");
            return false;
        }

        while(true){
            System.out.println("Desea guardar los cambios.");
            System.out.println("Y. Confirmar");
            System.out.println("N. Cancelar");
            String confir = input.readLine();
            if (confir.equalsIgnoreCase("Y")){
                break;
            }else if(confir.equalsIgnoreCase("N")){
                return true;
            }
        }

        int viejoNIT = Main.laboratorios.get(index).NIT;
        Main.laboratorios.remove(index);
        if(!Main.pruebas.isEmpty()){
            for (TipoPrueba tipoprueba : Main.tipopruebas) {
                if (tipoprueba.NitLaboratorio== viejoNIT){
                    tipoprueba.NitLaboratorio = -1;
                }
            }
        }
        return true;
    }
}
