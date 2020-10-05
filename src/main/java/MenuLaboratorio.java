import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println("Ingrese el nombre del laboratorio");
        String nombre = input.readLine();
        if (nombre.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }else{
            boolean comparador = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.Nombre.equals(nombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int ID = Main.IDs[0];
        System.out.println("Ingrese la direccion del laboratorio");
        String Direccion = input.readLine();
        if (Direccion.equals("")){
            System.out.println("No se ingreso ninguna direccion");
            return false;
        }
        Laboratorio nuevoLab = new Laboratorio(ID,nombre,Direccion);
        Main.laboratorios.add(nuevoLab);
        Main.IDs[0] = Main.IDs[0] + 1;
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
        int index = -1;
        int index2 = -1;
        int indexf;
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
        int viejoID = Main.laboratorios.get(index).ID;
        System.out.println("ID: "+ Main.laboratorios.get(index).ID);
        String nuevoid = input.readLine();
        int nuevoID = Integer.parseInt(nuevoid);
        if (nuevoid.equals("")){
            nuevoID = Main.laboratorios.get(index).ID;
        }else{
            comparador = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.ID == nuevoID){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El ID ya se encuentra en la base de datos");
                for(int i=1;i<Main.laboratorios.get(Main.laboratorios.size()-1).ID;i++){
                    if (Main.laboratorios.get(i).ID != i){
                        index2 = i;
                        break;
                    }
                }
                nuevoID = index2;
                System.out.println("Se asigno el ID: "+index2);
            }
        }
        System.out.println("Direccion del laboratorio: "+ Main.laboratorios.get(index).Direccion);
        String nuevaDireccion = input.readLine();
        if (nuevaDireccion.equals("")){
            nuevaDireccion = Main.laboratorios.get(index).Direccion;
        }
        Laboratorio nuevoLab = new Laboratorio(nuevoID,nuevoNombre,nuevaDireccion);

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

        if (nuevoID == Main.laboratorios.get(index).ID){
            Main.laboratorios.get(index).Nombre = nuevoNombre;
            Main.laboratorios.get(index).Direccion = nuevaDireccion;
            return true;
        }else{
            if(index2 >= 0 && index > index2){
                Main.laboratorios.add(index2,nuevoLab);
                Main.laboratorios.remove(index+1);
                indexf = index2;
            }else if(index2 >= 0 && index < index2){
                Main.laboratorios.add(index2,nuevoLab);
                Main.laboratorios.remove(index);
                indexf = index2 -1;
            }else{
                int index3 = -1;
                for(int j=0; j<Main.laboratorios.size();j++){
                    if(nuevoID<Main.laboratorios.get(j).ID){
                        index3 = j;
                        break;
                    }
                }
                if (index3 < 0){
                    Main.laboratorios.add(nuevoLab);
                    Main.laboratorios.remove(index);
                    indexf = Main.laboratorios.size()-1;
                }else if(index3>index){
                    Main.laboratorios.add(index3,nuevoLab);
                    Main.laboratorios.remove(index);
                    indexf = index3-1;
                }else {
                    Main.laboratorios.add(index3,nuevoLab);
                    Main.laboratorios.remove(index+1);
                    indexf = index3;
                }
            }
            if(!Main.pruebas.isEmpty()){
                for (TipoPrueba prueba : Main.pruebas) {
                    if (prueba.Laboratorio == viejoID){
                        prueba.Laboratorio = nuevoID;
                        Main.laboratorios.get(indexf).Pruebas.add(prueba.ID);
                    }
                }
            }
            if(!Main.zonas.isEmpty()){
                for (Zona zona : Main.zonas) {
                    if (zona.Laboratorio == viejoID){
                        zona.Laboratorio = nuevoID;
                        Main.laboratorios.get(indexf).Zonas.add(zona.ID);
                    }
                }
            }
            return true;
        }
    }

    public static boolean EditarLaboratorioID() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return true;
        }
        boolean comparador;
        System.out.println("Ingrese el ID del laboratorio");
        int IDb = Integer.parseInt(input.readLine());
        int index = -1;
        int index2 = -1;
        int indexf;
        for (int i=0;i<Main.laboratorios.size();i++){
            if (IDb == Main.laboratorios.get(i).ID) {
                index = i;
                break;
            }
        }
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
        int viejoID = Main.laboratorios.get(index).ID;
        System.out.println("ID: "+ Main.laboratorios.get(index).ID);
        String nuevoid = input.readLine();
        int nuevoID = Integer.parseInt(nuevoid);
        if (nuevoid.equals("")){
            nuevoID = Main.laboratorios.get(index).ID;
        }else{
            comparador = false;
            for (Laboratorio laboratorio : Main.laboratorios) {
                if (laboratorio.ID == nuevoID){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El ID ya se encuentra en la base de datos");
                for(int i=1;i<Main.laboratorios.get(Main.laboratorios.size()-1).ID;i++){
                    if (Main.laboratorios.get(i).ID != i){
                        index2 = i;
                        break;
                    }
                }
                nuevoID = index2;
                System.out.println("Se asigno el ID: "+index2);
            }
        }
        System.out.println("Direccion del laboratorio: "+ Main.laboratorios.get(index).Direccion);
        String nuevaDireccion = input.readLine();
        if (nuevaDireccion.equals("")){
            nuevaDireccion = Main.laboratorios.get(index).Direccion;
        }
        Laboratorio nuevoLab = new Laboratorio(nuevoID,nuevoNombre,nuevaDireccion);

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

        if (nuevoID == Main.laboratorios.get(index).ID){
            Main.laboratorios.get(index).Nombre = nuevoNombre;
            Main.laboratorios.get(index).Direccion = nuevaDireccion;
            return true;
        }else{
            if(index2 >= 0 && index > index2){
                Main.laboratorios.add(index2,nuevoLab);
                Main.laboratorios.remove(index+1);
                indexf = index2;
            }else if(index2 >= 0 && index < index2){
                Main.laboratorios.add(index2,nuevoLab);
                Main.laboratorios.remove(index);
                indexf = index2 -1;
            }else{
                int index3 = -1;
                for(int j=0; j<Main.laboratorios.size();j++){
                    if(nuevoID<Main.laboratorios.get(j).ID){
                        index3 = j;
                        break;
                    }
                }
                if (index3 < 0){
                    Main.laboratorios.add(nuevoLab);
                    Main.laboratorios.remove(index);
                    indexf = Main.laboratorios.size()-1;
                }else if(index3>index){
                    Main.laboratorios.add(index3,nuevoLab);
                    Main.laboratorios.remove(index);
                    indexf = index3-1;
                }else {
                    Main.laboratorios.add(index3,nuevoLab);
                    Main.laboratorios.remove(index+1);
                    indexf = index3;
                }
            }
            if(!Main.pruebas.isEmpty()){
                for (TipoPrueba prueba : Main.pruebas) {
                    if (prueba.Laboratorio == viejoID){
                        prueba.Laboratorio = nuevoID;
                        Main.laboratorios.get(indexf).Pruebas.add(prueba.ID);
                    }
                }
            }
            if(!Main.zonas.isEmpty()){
                for (Zona zona : Main.zonas) {
                    if (zona.Laboratorio == viejoID){
                        zona.Laboratorio = nuevoID;
                        Main.laboratorios.get(indexf).Zonas.add(zona.ID);
                    }
                }
            }
            return true;
        }
    }

    public static boolean EliminarLaboratorioN() throws IOException {
        if (Main.laboratorios.isEmpty()){
            System.out.println("No hay laboratorios en la base de datos");
            return true;
        }
        System.out.println("Ingrese el nombre del laboratorio");
        String nombreb = input.readLine();
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

        int viejoID = Main.laboratorios.get(index).ID;
        Main.laboratorios.remove(index);
        if(!Main.pruebas.isEmpty()){
            for (TipoPrueba prueba : Main.pruebas) {
                if (prueba.Laboratorio == viejoID){
                    prueba.Laboratorio = -1;
                }
            }
        }
        if(!Main.zonas.isEmpty()){
            for (Zona zona : Main.zonas) {
                if (zona.Laboratorio == viejoID){
                    zona.Laboratorio = -1;
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
        int IDb = Integer.parseInt(input.readLine());
        int index = -1;
        for (int i=0;i<Main.laboratorios.size();i++){
            if (IDb == Main.laboratorios.get(i).ID) {
                index = i;
                break;
            }
        }
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

        int viejoID = Main.laboratorios.get(index).ID;
        Main.laboratorios.remove(index);
        if(!Main.pruebas.isEmpty()){
            for (TipoPrueba prueba : Main.pruebas) {
                if (prueba.Laboratorio == viejoID){
                    prueba.Laboratorio = -1;
                }
            }
        }
        if(!Main.zonas.isEmpty()){
            for (Zona zona : Main.zonas) {
                if (zona.Laboratorio == viejoID){
                    zona.Laboratorio = -1;
                }
            }
        }
        return true;
    }
}
