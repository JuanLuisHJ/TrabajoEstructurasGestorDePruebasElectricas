import Clases.Prueba;
import Comparadores.ComparadoresPrueba.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MenuBusquedaPrueba {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Prueba> Listatemporal = new ArrayList<>();
    public static void menubusquedaPrueba() throws IOException {
        if(Main.pruebas.isEmpty()){
            System.out.println("No hay prueba en el sistema");
            return;
        }
        while (true) {
            System.out.println("1. ID.");
            System.out.println("2. Nombre.");
            System.out.println("3. Tipo de prueba.");
            System.out.println("4. Clase.");
            System.out.println("5. Numero de informe.");
            System.out.println("6. Mostrar todos las prueba.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                if(busquedaID()){
                    return;
                }
            } else if (opcionA.equals("2")) {
                if(busquedaNombre()){
                    return;
                }
            } else if (opcionA.equals("3")) {
                if(busquedaTipoprueba()){
                    return;
                }
            }else if (opcionA.equals("4")) {
                if(busquedaClase()){
                    return;
                }
            }else if (opcionA.equals("5")) {
                if(busquedaNumInfor()){
                    return;
                }
            } else if (opcionA.equals("6")) {
                MostrarTodo();
                return;
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static boolean busquedaNumInfor() throws IOException {
        String opcion = MenuInt();
        if (opcion.equals("1")){
            System.out.println("Ingrese el numero de informe de la prueba");
            String ninforme = input.readLine();
            if (ninforme.equals("")){
                System.out.println("No se ingreso ningun numero de informe\n");
                return false;
            }
            ninforme = ninforme.replaceAll("[.]","");
            int ninformeb = Integer.parseInt(ninforme);
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).NumInforme==ninformeb){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else if (opcion.equals("2")){
            System.out.println("Ingrese el valor minimo del nuemero de informe de la prueba");
            String ninformem = input.readLine();
            if (ninformem.equals("")){
                System.out.println("No se ingreso ningun numero de informe\n");
                return false;
            }
            ninformem = ninformem.replaceAll("[.]","");
            int NInformem = Integer.parseInt(ninformem);
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).NumInforme>=NInformem){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else if (opcion.equals("3")){
            System.out.println("Ingrese el valor maximo del numero de informe de la prueba");
            String ninformem = input.readLine();
            if (ninformem.equals("")){
                System.out.println("No se ingreso ningun numero de informe\n");
                return false;
            }
            ninformem = ninformem.replaceAll("[.]","");
            int NInformem = Integer.parseInt(ninformem);
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).NumInforme<=NInformem){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        }else if (opcion.equals("4")){
            System.out.println("Ingrese el valor minimo de numero de informe");
            String ninformemin = input.readLine();
            if (ninformemin.equals("")){
                System.out.println("No se ingreso ningun numero de informe\n");
                return false;
            }
            System.out.println("Ingrese el valor maximo de numero de informe");
            String ninformemax = input.readLine();
            if (ninformemax.equals("")){
                System.out.println("No se ingreso ningun numero de informe\n");
                return false;
            }
            ninformemin = ninformemin.replaceAll("[.]","");
            int NInformemin = Integer.parseInt(ninformemin);
            ninformemax = ninformemax.replaceAll("[.]","");
            int NInformemax = Integer.parseInt(ninformemax);
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).NumInforme>=NInformemin && Main.pruebas.get(i).NumInforme<=NInformemax){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
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
            System.out.println("Ingrese el nombre de la prueba");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun nombre\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).Nombre.equals(nombre)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el nombre de la de prueba");
            String nombre = input.readLine();
            if (nombre.equals("")){
                System.out.println("No se ingreso ningun nombre\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).Nombre.equalsIgnoreCase(nombre)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else {
            return true;
        }
    }

    public static boolean busquedaTipoprueba() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese el tipo de prueba");
            String tipoprueba = input.readLine();
            if (tipoprueba.equals("")){
                System.out.println("No se ingreso ningun tipo de prueba\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).TipoPrueba.equals(tipoprueba)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el tipo de prueba");
            String tipoprueba = input.readLine();
            if (tipoprueba.equals("")){
                System.out.println("No se ingreso ningun tipo de prueba\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).TipoPrueba.equalsIgnoreCase(tipoprueba)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else {
            return true;
        }
    }

    public static boolean busquedaClase() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese la clase del ala prueba");
            String clase = input.readLine();
            if (clase.equals("")){
                System.out.println("No se ingreso ninguna clase\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).Clase.equals(clase)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese la clase de la prueba");
            String clase = input.readLine();
            if (clase.equals("")){
                System.out.println("No se ingreso ninguna clase\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).Clase.equalsIgnoreCase(clase)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else {
            return true;
        }
    }

    public static boolean busquedaID() throws IOException {
        String opcion = MenuString();
        if (opcion.equals("1")) {
            System.out.println("Ingrese el ID de la prueba");
            String id = input.readLine();
            if (id.equals("")){
                System.out.println("No se ingreso ningun ID\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).ID.equals(id)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
                return false;
            }
            organizar();
            Listatemporal.clear();
            return true;
        } else if (opcion.equals("2")) {
            System.out.println("Ingrese el ID de la prueba");
            String id = input.readLine();
            if (id.equals("")){
                System.out.println("No se ingreso ningun ID\n");
                return false;
            }
            for(int i=0;i<Main.pruebas.size();i++){
                if(Main.pruebas.get(i).ID.equalsIgnoreCase(id)){
                    Listatemporal.add(Main.pruebas.get(i));
                }
            }
            if(Listatemporal.isEmpty()){
                System.out.println("No se encontro ninguna prueba que cumpla la condicion");
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
        Listatemporal = (ArrayList) Main.pruebas.clone();
        organizar();
    }

    public static void organizar() throws IOException {
        if (Listatemporal.size()==1){
            System.out.println(Listatemporal.get(0));
            String opcion = MenuEoE();
            if(opcion.equals("1")){
                MenuPrueba.EditarPrueba(Listatemporal.get(0).ID);
            }else if(opcion.equals("2")){
                MenuPrueba.EliminarPrueba(Listatemporal.get(0).ID);
            }else {
                return;
            }
        }
        String opcion = MenuOrganizar();
        if (opcion.equals("1")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorIDPrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorIDPrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("2")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorNombrePrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorNombrePrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else {
                return;
            }
        } else if (opcion.equals("3")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorTipopruebaPrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorTipopruebaPrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else {
                return;
            }
        }  else if (opcion.equals("4")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorClasePrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorClasePrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else {
                return;
            }
        }  else if (opcion.equals("5")) {
            opcion = MenuAoD();
            if (opcion.equals("1")) {
                Collections.sort(Listatemporal,new ComparadorNumInformePrueba());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
                }else {
                    return;
                }
            } else if (opcion.equals("2")) {
                Collections.sort(Listatemporal,new ComparadorNumInformePrueba().reversed());
                for (int i=0;i<Listatemporal.size();i++){
                    System.out.println(i+" - "+Listatemporal.get(i));
                }
                opcion = MenuEoE();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EditarPrueba(Listatemporal.get(Indice).ID);
                }else if(opcion.equals("2")){
                    System.out.println("Ingrese el indice de la prueba que desea eliminar");
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
                    MenuPrueba.EliminarPrueba(Listatemporal.get(Indice).ID);
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
            System.out.println("1. ID.");
            System.out.println("2. Nombre.");
            System.out.println("3. Tipo de prueba.");
            System.out.println("4. Clase.");
            System.out.println("5. Numero de informe.");
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
            } else if (opcion.equals("5")) {
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