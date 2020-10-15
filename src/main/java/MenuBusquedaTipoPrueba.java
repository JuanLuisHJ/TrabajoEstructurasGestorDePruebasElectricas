import Clases.TipoPrueba;
import Comparadores.ComparadoresTipoPrueba.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MenuBusquedaTipoPrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<TipoPrueba> Listatemporal = new ArrayList<>();
    public static void menubusquedaTipoPrueba() throws IOException {
        if(Main.tipopruebas.isEmpty()){
            System.out.println("No hay tipos de prueba en el sistema");
            return;
        }
        while (true) {
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia de norma.");
            System.out.println("3. NIT de laboratorio.");
            System.out.println("4. Mostrar todos los tipos de prueba.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if(busquedaNombre()){
                    return;
                }
            } else if (opcionA.equals("2")) {
                if(busquedaRefNorma()){
                    return;
                }
            } else if (opcionA.equals("3")) {
                if(busquedaNitLab()){
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

    public static boolean busquedaNitLab() throws IOException {
        String opcion = MenuInt();
        if (opcion.equals("1")){
            System.out.println("Ingrese el NIT del laboratorio correspondiente al tipo de prueba");
            String nitb = input.readLine();
            if (nitb.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitb = nitb.replaceAll("[.]","");
            int NITb = Integer.parseInt(nitb);
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).NitLaboratorio==NITb){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        }else if (opcion.equals("2")){
            System.out.println("Ingrese el valor minimo de NIT del laboratorio correspondiente al tipo de prueba");
            String nitm = input.readLine();
            if (nitm.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitm = nitm.replaceAll("[.]","");
            int NITm = Integer.parseInt(nitm);
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).NitLaboratorio>=NITm){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        }else if (opcion.equals("3")){
            System.out.println("Ingrese el valor maximo de NIT del laboratorio correspondiente al tipo de prueba");
            String nitm = input.readLine();
            if (nitm.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitm = nitm.replaceAll("[.]","");
            int NITm = Integer.parseInt(nitm);
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).NitLaboratorio<=NITm){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        }else if (opcion.equals("4")){
            System.out.println("Ingrese el valor minimo de NIT del laboratorio correspondiente al tipo de prueba");
            String nitmin = input.readLine();
            if (nitmin.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            System.out.println("Ingrese el valor maximo de NIT del laboratorio correspondiente al tipo de prueba");
            String nitmax = input.readLine();
            if (nitmax.equals("")){
                System.out.println("No se ingreso ningun NIT\n");
                return false;
            }
            nitmin = nitmin.replaceAll("[.]","");
            int NITmin = Integer.parseInt(nitmin);
            nitmax = nitmax.replaceAll("[.]","");
            int NITmax = Integer.parseInt(nitmax);
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).NitLaboratorio>=NITmin && Main.tipopruebas.get(i).NitLaboratorio<=NITmax){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        }else {
            System.out.println("La operacion fue cancelada");
            return true;
        }
    }

    public static boolean busquedaNombre() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese el nombre del tipo de prueba");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun tipo de prueba\n");
                return false;
            }
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).Nombre.equals(nombre)){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el nombre del tipo de prueba");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun tipo de prueba\n");
                return false;
            }
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).Nombre.equalsIgnoreCase(nombre)){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        } else {
            System.out.println("La operacion fue cancelada");
            return true;
        }
    }

    public static boolean busquedaRefNorma() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese la referencia de la norma del tipo de prueba");
            String norma = input.readLine();
            if (norma.equals("")){
                System.out.println("No se ingreso ninguna norma\n");
                return false;
            }
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).RefNorma.equals(norma)){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese la referencia de la norma del tipo de prueba");
            String norma = input.readLine();
            if (norma.equals("")){
                System.out.println("No se ingreso ninguna norma\n");
                return false;
            }
            for(int i=0;i<Main.tipopruebas.size();i++){
                if(Main.tipopruebas.get(i).RefNorma.equalsIgnoreCase(norma)){
                    Listatemporal.add(Main.tipopruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ningun tipo de prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            System.out.println("La operacion fue exitosa");
            return true;
        } else {
            System.out.println("La operacion fue cancelada");
            return true;
        }
    }

    public static void MostrarTodo() throws IOException {
        Listatemporal = (ArrayList) Main.tipopruebas.clone();
        organizar();
    }

    public static void organizar() throws IOException {
        if (Listatemporal.size()==1){
            System.out.println(Listatemporal.get(0));
            String opcion = MenuEoE();
            if(opcion.equals("1")){
                MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(0).Nombre);
            }else if(opcion.equals("2")){
                MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(0).Nombre);
            }else {
                return;
            }
        }
        String opcion = MenuOrganizar();
        if (opcion.equals("1")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorNombreTipoPrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorNombreTipoPrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("2")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorRefNormaTipoPrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorRefNormaTipoPrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("3")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorNitLaboratorioTipoPrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorNitLaboratorioTipoPrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EditarTipoPrueba(Listatemporal.get(Indice).Nombre);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice del tipo de prueba que desea eliminar");
                    String indice = input.readLine();
                    if (indice.equals("")){
                        System.out.println("No se ingreso ningun indice\n");
                        return;
                    }
                    indice = indice.replaceAll("[.]","");
                    int Indice = Integer.parseInt(indice);
                    if (Indice >= Listatemporal.size()){
                        System.out.println("El indice ingresado no es valido");
                        return;
                    }
                    MenuTipoPrueba.EliminarTipoPrueba(Listatemporal.get(Indice).Nombre);
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
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia norma.");
            System.out.println("3. NIT Laboratorio.");
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
