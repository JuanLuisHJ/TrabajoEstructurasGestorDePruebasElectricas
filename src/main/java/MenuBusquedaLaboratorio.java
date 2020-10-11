import Clases.Laboratorio;
import Comparadores.ComparadoresLaboratorio.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MenuBusquedaLaboratorio {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Laboratorio> Listatemporal = new ArrayList<>();
    public static void menubusquedaLaboratorio() throws IOException {
        if(Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en el sistema");
            return;
        }
        while (true) {
            System.out.println("1. NIT.");
            System.out.println("2. Nombre.");
            System.out.println("3. Direccion.");
            System.out.println("4. Mostrar todos los laboratorios.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if(busquedaNit()){
                    return;
                }
            } else if (opcionA.equals("2")) {
                if(busquedaNombre()){
                    return;
                }
            } else if (opcionA.equals("3")) {
                if(busquedaDireccion()){
                    return;
                }
            } else if (opcionA.equals("4")) {
                MostrarTodo();
                return;
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static boolean busquedaNit() throws IOException {
        String opcion = MenuInt();
        if (opcion.equals("1")){
            System.out.println("Ingrese el ID del laboratorio");
            String nitb = input.readLine();
            if (nitb.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitb = nitb.replaceAll("[.]","");
            int NITb = Integer.parseInt(nitb);
            int index = Collections.binarySearch(Main.laboratorios,new Laboratorio(NITb,"",""),new ComparadorNITLaboratorio());
            if (index<0){
                System.out.println("No se encuentra el laboratorio con ese NIT");
                return false;
            }
            System.out.println(Main.laboratorios.get(index));
            opcion = MenuEoE();
            if(opcion.equals("1")){
                MenuLaboratorio.EditarLaboratorioID();
            }else if(opcion.equals("2")){
                MenuLaboratorio.EliminarLaboratorioID();
            }else {
                return true;
            }
            return true;
        }else if (opcion.equals("2")){
            System.out.println("Ingrese el valor minimo de NIT del laboratorio");
            String nitm = input.readLine();
            if (nitm.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitm = nitm.replaceAll("[.]","");
            int NITm = Integer.parseInt(nitm);
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).NIT>=NITm){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else if (opcion.equals("3")){
            System.out.println("Ingrese el valor maximo de NIT del laboratorio");
            String nitm = input.readLine();
            if (nitm.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitm = nitm.replaceAll("[.]","");
            int NITm = Integer.parseInt(nitm);
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).NIT<=NITm){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else if (opcion.equals("4")){
            System.out.println("Ingrese el valor minimo de NIT del laboratorio");
            String nitmin = input.readLine();
            if (nitmin.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            System.out.println("Ingrese el valor maximo de NIT del laboratorio");
            String nitmax = input.readLine();
            if (nitmax.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitmin = nitmin.replaceAll("[.]","");
            int NITmin = Integer.parseInt(nitmin);
            nitmax = nitmax.replaceAll("[.]","");
            int NITmax = Integer.parseInt(nitmax);
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).NIT>=NITmin && Main.laboratorios.get(i).NIT<=NITmax){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else {
            return true;
        }
    }

    public static boolean busquedaNombre() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese el nombre del laboratorio");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun nombre\n");
                return false;
            }
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).Nombre.equals(nombre)){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el nombre del laboratorio");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun nombre\n");
                return false;
            }
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).Nombre.equalsIgnoreCase(nombre)){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else {
            return true;
        }
    }

    public static boolean busquedaDireccion() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese la direccion del laboratorio");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ninguna direccion\n");
                return false;
            }
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).Direccion.equals(nombre)){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese la direccion del laboratorio");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ninguna direccion\n");
                return false;
            }
            for(int i=0;i<Main.laboratorios.size();i++){
                if(Main.laboratorios.get(i).Direccion.equalsIgnoreCase(nombre)){
                    Listatemporal.add(Main.laboratorios.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun laboratorio que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else {
            return true;
        }
    }

    public static void MostrarTodo() throws IOException {
        Listatemporal = (ArrayList) Main.laboratorios.clone();
        organizar();
    }

    public static void organizar() throws IOException {
        if (Listatemporal.size()==1){
            System.out.println(Listatemporal.get(0));
            String opcion = MenuEoE();
            if(opcion.equals("1")){
                MenuLaboratorio.EditarLaboratorioID();
            }else if(opcion.equals("2")){
                MenuLaboratorio.EliminarLaboratorioID();
            }else {
                return;
            }
        }
        String opcion = MenuOrganizar();
        if (opcion.equals("1")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorDireccionLaboratorio());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorDireccionLaboratorio().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("2")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorNombreLaboratorio());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorNombreLaboratorio().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("3")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorDireccionLaboratorio());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorDireccionLaboratorio().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    MenuLaboratorio.EditarLaboratorioID();
                }else if(opcion.equals("2")){
                    MenuLaboratorio.EliminarLaboratorioID();
                }else {
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public static String MenuString () throws IOException {
        while (true) {
            System.out.println("1. Valor Exacto.");
            System.out.println("2. Valor sin considerar mayusculas.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuOrganizar() throws IOException {
        while (true) {
            System.out.println("Selecione el atributo por el cual desea organizar");
            System.out.println("1. NIT.");
            System.out.println("2. Nombre.");
            System.out.println("3. Direccion.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("3")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuEoE() throws IOException {
        while (true) {
            System.out.println("Desea editar o eliminar algun laboratorio");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar.");
            System.out.println("0. No realizar cambios");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuAoD() throws IOException {
        while (true) {
            System.out.println("Seleccione la forma como desea organizar los laboratorios");
            System.out.println("1. Ascendente.");
            System.out.println("2. Descendente.");
            System.out.println("0. No realizar cambios");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static String MenuInt() throws IOException {
        while (true) {
            System.out.println("1. Valor exacto.");
            System.out.println("2. Valor minimo.");
            System.out.println("3. Valor maximo.");
            System.out.println("4. Rango.");
            System.out.println("0. Cancelar");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                return opcion;
            } else if (opcion.equals("2")) {
                return opcion;
            } else if (opcion.equals("3")) {
                return opcion;
            } else if (opcion.equals("4")) {
                return opcion;
            }else if (opcion.equals("0")) {
                return opcion;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }
}
