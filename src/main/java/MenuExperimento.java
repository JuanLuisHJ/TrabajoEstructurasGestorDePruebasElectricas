import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuExperimento {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void munuExperiento(ArrayList<Experimento> experimentos, int[]Ids) throws IOException {
        while(true){
            System.out.println("1. Ver Experimento.");
            System.out.println("2. Crear Experimento.");
            System.out.println("3. Editar Experimento.");
            System.out.println("4. Eliminar Experimento.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            boolean comparador;
            if (opcionA.equals("1")){
                comparador = VerExperimento(experimentos);
                if (comparador){
                    return;
                }
            }else if(opcionA.equals("2")){
                comparador = CrearExperimentos(experimentos,Ids);
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
                        comparador = EditarExperimentosN(experimentos);
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("2")) {
                        comparador = EditarExperimentosID(experimentos);
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
                        comparador = EliminarExperimentosN(experimentos);
                        if (comparador){
                            return;
                        }
                    }else if(opcionAE.equals("2")) {
                        comparador = EliminarExperimentosID(experimentos);
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

     public static boolean VerExperimento(ArrayList<Experimento> experimentos){
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos en el sistema");
            return false;
        }else{
            for (Experimento experimento : experimentos) {
                System.out.println(experimento);
            }
            return true;
        }
     }

    public static boolean CrearExperimentos(ArrayList<Experimento> experimentos, int [] Ids) throws IOException {
        System.out.println("Ingrese el nombre del experimento");
        String nombre = input.readLine();
        if (nombre.equals("")){
            System.out.println("No se ingreso ningun nombre");
            return false;
        }else{
            boolean comparador = false;
            for (Experimento experimento : experimentos) {
                if (experimento.Nombre.equals(nombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int ID = Ids[0] ;
        System.out.println("Ingrese el tipo de experimento");
        String Tipo = input.readLine();
        if (Tipo.equals("")){
            System.out.println("No se ingreso ningun tipo de experimento");
            return false;
        }
        System.out.println("Ingrese el metodo del experimento");
        String metodo = input.readLine();
        if (metodo.equals("")){
            System.out.println("No se ingreso ningun metodo");
            return false;
        }
        Experimento nuevoExperimento = new Experimento(nombre,ID,Tipo,metodo);
        experimentos.add(nuevoExperimento);
        Ids[0] = Ids[0] + 1;
        return true;
    }

    public static boolean EditarExperimentosN(ArrayList<Experimento> experimentos) throws IOException {
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos en la base de datos");
            return true;
        }
        boolean comparador;
        System.out.println("Ingrese el nombre del experimento");
        String nombreb = input.readLine();
        int index = -1;
        int index2 = -1;
        int indexf;
        for (int i=0;i<experimentos.size();i++){
            if (nombreb.equalsIgnoreCase(experimentos.get(i).Nombre)) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el experimento con ese nombre");
            return false;
        }
        System.out.println("Nombre: "+ experimentos.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")){
            nuevoNombre = experimentos.get(index).Nombre;
        }else{
            comparador = false;
            for (Experimento experimento : experimentos) {
                if (experimento.Nombre.equals(nuevoNombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int viejoID = experimentos.get(index).ID;
        System.out.println("ID: "+ experimentos.get(index).ID);
        String nuevoid = input.readLine();
        int nuevoID = Integer.parseInt(nuevoid);
        if (nuevoNombre.equals("")){
            nuevoID = experimentos.get(index).ID;
        }else{
            comparador = false;
            for (Experimento experimento : experimentos) {
                if (experimento.ID == nuevoID){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El ID ya se encuentra en la base de datos");
                for(int i=1;i<experimentos.get(experimentos.size()-1).ID;i++){
                    if (experimentos.get(i).ID != i){
                        index2 = i;
                        break;
                    }
                }
                nuevoID = index2;
                System.out.println("Se asigno el ID: "+index2);
            }
        }
        System.out.println("Tipo de experimento: "+ experimentos.get(index).TipoDeExperimento);
        String nuevoTipo = input.readLine();
        if (nuevoTipo.equals("")){
            nuevoTipo = experimentos.get(index).TipoDeExperimento;
        }
        System.out.println("Metodo: "+ experimentos.get(index).Metodo);
        String nuevoMetodo = input.readLine();
        if (nuevoTipo.equals("")){
            nuevoMetodo = experimentos.get(index).Metodo;
        }
        Experimento nuevoExperimento = new Experimento(nuevoNombre,nuevoID,nuevoTipo,nuevoMetodo);
        //Falta confirmar cambio
        if (nuevoID == experimentos.get(index).ID){
            experimentos.get(index).Nombre = nuevoNombre;
            experimentos.get(index).TipoDeExperimento = nuevoTipo;
            experimentos.get(index).Metodo = nuevoMetodo;
            return true;
        }else{
            if(index2 >= 0 && index > index2){
                experimentos.add(index2,nuevoExperimento);
                experimentos.remove(index+1);
                indexf = index2;
            }else if(index2 >= 0 && index < index2){
                experimentos.add(index2,nuevoExperimento);
                experimentos.remove(index);
                indexf = index2 -1;
            }else{
                int index3 = -1;
                for(int j=0; j<experimentos.size();j++){
                    if(nuevoID>experimentos.get(j).ID){
                        index3 = j;
                        break;
                    }
                }
                if (index3 < 0){
                    experimentos.add(nuevoExperimento);
                    experimentos.remove(index);
                    indexf = experimentos.size()-1;
                }else if(index3>index){
                    experimentos.add(index3,nuevoExperimento);
                    experimentos.remove(index);
                    indexf = index3-1;
                }else {
                    experimentos.add(index3,nuevoExperimento);
                    experimentos.remove(index+1);
                    indexf = index3;
                }
            }
            if(!Main.muestras.isEmpty()){
                for (Muestra muestra : Main.muestras) {
                    if (muestra.Experimento == viejoID){
                        muestra.Experimento = nuevoID;
                        experimentos.get(indexf).Muestras.add(muestra.ID);
                    }
                }
            }
            return true;
        }
    }

    public static boolean EditarExperimentosID(ArrayList<Experimento> experimentos) throws IOException {
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos en la base de datos");
            return true;
        }
        boolean comparador;
        System.out.println("Ingrese el ID del experimento");
        int IDb = Integer.parseInt(input.readLine());
        int index = -1;
        int index2 = -1;
        int indexf;
        for (int i=0;i<experimentos.size();i++){
            if (IDb == experimentos.get(i).ID) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el experimento con ese nombre");
            return false;
        }
        System.out.println("Nombre: "+ experimentos.get(index).Nombre);
        String nuevoNombre = input.readLine();
        if (nuevoNombre.equals("")){
            nuevoNombre = experimentos.get(index).Nombre;
        }else{
            comparador = false;
            for (Experimento experimento : experimentos) {
                if (experimento.Nombre.equals(nuevoNombre)){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El Nombre ya se encuentra en la base de datos");
                return false;
            }
        }
        int viejoID = experimentos.get(index).ID;
        System.out.println("ID: "+ experimentos.get(index).ID);
        String nuevoid = (input.readLine());
        int nuevoID = Integer.parseInt(nuevoid);
        if (nuevoNombre.equals("")){
            nuevoID = experimentos.get(index).ID;
        }else{
            comparador = false;
            for (Experimento experimento : experimentos) {
                if (experimento.ID == nuevoID){
                    comparador = true;
                    break;
                }
            }
            if (comparador){
                System.out.println("El ID ya se encuentra en la base de datos");
                for(int i=1;i<experimentos.get(experimentos.size()-1).ID;i++){
                    if (experimentos.get(i).ID != i){
                        index2 = i;
                        break;
                    }
                }
                nuevoID = index2;
                System.out.println("Se asigno el ID: "+index2);
            }
        }
        System.out.println("Tipo de experimento: "+ experimentos.get(index).TipoDeExperimento);
        String nuevoTipo = input.readLine();
        if (nuevoTipo.equals("")){
            nuevoTipo = experimentos.get(index).TipoDeExperimento;
        }
        System.out.println("Metodo: "+ experimentos.get(index).Metodo);
        String nuevoMetodo = input.readLine();
        if (nuevoTipo.equals("")){
            nuevoMetodo = experimentos.get(index).Metodo;
        }
        Experimento nuevoExperimento = new Experimento(nuevoNombre,nuevoID,nuevoTipo,nuevoMetodo);
        // falta confirmar cambio
        if (nuevoID == experimentos.get(index).ID){
            experimentos.get(index).Nombre = nuevoNombre;
            experimentos.get(index).TipoDeExperimento = nuevoTipo;
            experimentos.get(index).Metodo = nuevoMetodo;
            return true;
        }else{
            if(index2 >= 0 && index > index2){
                experimentos.add(index2,nuevoExperimento);
                experimentos.remove(index+1);
                indexf = index2;
            }else if(index2 >= 0 && index < index2){
                experimentos.add(index2,nuevoExperimento);
                experimentos.remove(index);
                indexf = index2 -1;
            }else{
                int index3 = -1;
                for(int j=0; j<experimentos.size();j++){
                    if(nuevoID>experimentos.get(j).ID){
                        index3 = j;
                        break;
                    }
                }
                if (index3 < 0){
                    experimentos.add(nuevoExperimento);
                    experimentos.remove(index);
                    indexf = experimentos.size()-1;
                }else if(index3>index){
                    experimentos.add(index3,nuevoExperimento);
                    experimentos.remove(index);
                    indexf = index3-1;
                }else {
                    experimentos.add(index3,nuevoExperimento);
                    experimentos.remove(index+1);
                    indexf = index3;
                }
            }
            if(!Main.muestras.isEmpty()){
                for (Muestra muestra : Main.muestras) {
                    if (muestra.Experimento == viejoID){
                        muestra.Experimento = nuevoID;
                        experimentos.get(indexf).Muestras.add(muestra.ID);
                    }
                }
            }
            return true;
        }
    }

    public static boolean EliminarExperimentosN(ArrayList<Experimento> experimentos) throws IOException {
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos en la base de datos");
            return true;
        }
        System.out.println("Ingrese el nombre del experimento");
        String nombreb = input.readLine();
        int index = -1;
        for (int i=0;i<experimentos.size();i++){
            if (nombreb.equalsIgnoreCase(experimentos.get(i).Nombre)) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el experimento con ese nombre");
            return false;
        }
        //falta confirmar cambio
        int viejoID = experimentos.get(index).ID;
        experimentos.remove(index);
        if(!Main.muestras.isEmpty()){
            for (Muestra muestra : Main.muestras) {
                if (muestra.Experimento == viejoID){
                    muestra.Experimento = -1;
                }
            }
        }
        return true;
    }

    public static boolean EliminarExperimentosID(ArrayList<Experimento> experimentos) throws IOException {
        if (experimentos.isEmpty()){
            System.out.println("No hay experimentos en la base de datos");
            return true;
        }
        System.out.println("Ingrese el ID del experimento");
        int IDb = Integer.parseInt(input.readLine());
        int index = -1;
        for (int i=0;i<experimentos.size();i++){
            if (IDb == experimentos.get(i).ID) {
                index = i;
                break;
            }
        }
        if (index<0){
            System.out.println("No se encuentra el experimento con ese nombre");
            return false;
        }
        //falta confirmar cambio
        int viejoID = experimentos.get(index).ID;
        experimentos.remove(index);
        if(!Main.muestras.isEmpty()){
            for (Muestra muestra : Main.muestras) {
                if (muestra.Experimento == viejoID){
                    muestra.Experimento = -1;
                }
            }
        }
        return true;
    }
}
