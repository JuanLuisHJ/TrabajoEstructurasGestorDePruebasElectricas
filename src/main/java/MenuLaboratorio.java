import Clases.Laboratorio;
import Clases.TipoPrueba;
import Comparadores.ComparadorNITLaboratorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class MenuLaboratorio {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void munuLaboratorio() throws IOException {
        while(true){
            System.out.println("1. Ver Laboratorio.");
            System.out.println("2. Crear Laboratorio.");
            System.out.println("3. Editar Laboratorio.");
            System.out.println("4. Eliminar Laboratorio.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            boolean comparador;
            if (opcionA.equals("1")){
                comparador = VerLaboratorio();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("2")){
                comparador = CrearLaboratorio();
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("3")){
                while (true){
                    System.out.println("1. Seleccionar por nombre.");
                    System.out.println("2. Seleccionar por ID.");
                    System.out.println("0. Cancelar.");
                    String opcionAE = input.readLine();
                    if(opcionAE.equals("1")){
                        comparador = EditarLaboratorioN();
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("2")) {
                        comparador = EditarLaboratorioID();
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("0")){
                        return;
                    }else{
                        System.out.println("La opción ingresada no es válida");
                    }
                }
            }else if(opcionA.equals("4")){
                while (true){
                    System.out.println("1. Seleccionar por nombre.");
                    System.out.println("2. Seleccionar por ID.");
                    System.out.println("0. Cancelar.");
                    String opcionAE = input.readLine();
                    if(opcionAE.equals("1")){
                        comparador = EliminarLaboratorioN();
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("2")) {
                        comparador = EliminarLaboratorioID();
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("0")){
                        return;
                    }else{
                        System.out.println("La opción ingresada no es válida");
                    }
                }
            }else if(opcionA.equals("0")){
                return;
            }else{
                System.out.println("La opción ingresada no es válida");
            }
        }
    }

     public static boolean VerLaboratorio(){
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en el sistema");
            return false;
        }else{
            for (Laboratorio laboratorio : Main.laboratorios) {
                System.out.println(laboratorio);
            }
            return true;
        }
     }

    public static boolean CrearLaboratorio() throws IOException {
        int comparador;
        System.out.println("Ingrese el nombre del laboratorio");
        String nombre = input.readLine();
        if (nombre.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }else{
            boolean comparadorN = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.Nombre.equals(nombre)){
                    comparadorN = true;
                    break;
                }
            }
            if (comparadorN){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese el NIT del laboratorio");
        String NIT = input.readLine();
        int nNIT;
        if (NIT.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }else{
            NIT.replace('.',' ');
            NIT.trim();
            nNIT = Integer.parseInt(NIT);
            comparador = Collections.binarySearch(Main.laboratorios,new Laboratorio(nNIT,"",""),new ComparadorNITLaboratorio());
            if (comparador>=0){
                System.out.println("El NIT ya se encuentra en la base de datos");
                return false;
            }
        }
        System.out.println("Ingrese la direccion del laboratorio");
        String Direccion = input.readLine();
        if (Direccion.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
        Laboratorio nuevoLab = new Laboratorio(nNIT,nombre,Direccion);
        if (Main.laboratorios.isEmpty()){
            Main.laboratorios.add(nuevoLab);
        }else{
            for (int i=0;i<Main.laboratorios.size();i++){
                if (nNIT<Main.laboratorios.get(i).NIT){
                    Main.laboratorios.add(i,nuevoLab);
                    break;
                }
            }
        }
        return true;
    }

    public static boolean EditarLaboratorioN() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return true;
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
        int nuevoNIT = Integer.parseInt(nuevonit);
        if (nuevonit.equals("")){
            nuevoNIT = Main.laboratorios.get(index).NIT;
        }else{
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
            if (confir.equals("Y")){
                break;
            }else if(confir.equals("N")){
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
            return true;
        }
        boolean comparador;
        System.out.println("Ingrese el ID del laboratorio");
        String nitb = input.readLine();
        if (nitb.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
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
        int nuevoNIT = Integer.parseInt(nuevonit);
        if (nuevonit.equals("")){
            nuevoNIT = Main.laboratorios.get(index).NIT;
        }else{
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
            if (confir.equals("Y")){
                break;
            }else if(confir.equals("N")){
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
            return true;
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
            if (confir.equals("Y")){
                break;
            }else if(confir.equals("N")){
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
            return true;
        }
        System.out.println("Ingrese el ID del laboratorio");
        String nitb = input.readLine();
        if (nitb.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
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
            if (confir.equals("Y")){
                break;
            }else if(confir.equals("N")){
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
