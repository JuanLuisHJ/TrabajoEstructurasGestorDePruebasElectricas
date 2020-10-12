import Clases.Informe;
import Comparadores.ComparadorDeInformes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MenuBusquedaInforme {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void BusquedaInforme() throws IOException{
        boolean volver = false;
        while(!volver){
            System.out.println("Buscar por:");
            System.out.println("1. Número de informe");
            System.out.println("2. Resultado");
            System.out.println("3. Comentarios");
            System.out.println("4. Temperatura");
            System.out.println("5. Humedad");
            System.out.println("6. Presión");
            System.out.println("7. Mostrar todos los informes");
            System.out.println("0. Volver ");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                char opcion = atributoNumerico();
                if (opcion=='1'){
                    valorExacto("IDPrueba");
                }
                else if (opcion=='2'){
                    valorMinimo("IDPrueba");
                }
                else if (opcion=='3'){
                    valorMaximo("IDPrueba");
                }
                else if (opcion=='4'){
                    rango("IDPrueba");
                }
            }
            else if (seleccion.equals("2")){
                System.out.println("El resultado del  informe sólo tiene dos posibilidades, \"Pasó\" o \"No Pasó\"");
                valorExacto("Resultado");
            }
            else if (seleccion.equals("3")){
                char opcion = atributoDeTexto();
                if (opcion=='1'){
                    valorExactoDeTexto();
                }
                else if(opcion=='2'){
                    valorDeTexto();
                }
            }
            else if (seleccion.equals("4")){
                char opcion = atributoNumerico();
                if (opcion=='1'){
                    valorExacto("Temperatura");
                }
                else if (opcion=='2'){
                    valorMinimo("Temperatura");
                }
                else if (opcion=='3'){
                    valorMaximo("Temperatura");
                }
                else if (opcion=='4'){
                    rango("Temperatura");
                }
            }
            else if (seleccion.equals("5")){
                char opcion = atributoNumerico();
                if (opcion=='1'){
                    valorExacto("Humedad");
                }
                else if (opcion=='2'){
                    valorMinimo("Humedad");
                }
                else if (opcion=='3'){
                    valorMaximo("Humedad");
                }
                else if (opcion=='4'){
                    rango("Humedad");
                }
            }
            else if (seleccion.equals("6")){
                char opcion = atributoNumerico();
                if (opcion=='1'){
                    valorExacto("Presion");
                }
                else if (opcion=='2'){
                    valorMinimo("Presion");
                }
                else if (opcion=='3'){
                    valorMaximo("Presion");
                }
                else if (opcion=='4'){
                    rango("Presion");
                }
            }
            else if (seleccion.equals("7")){
                ArrayList<Informe> copia = new ArrayList<>();
                if (Main.informes.size()==0){
                    System.out.println("No hay informes registrados");
                }
                else {
                    for (Informe informe : Main.informes){
                        System.out.println(informe);
                        copia.add(informe);
                    }
                    ordenarPor(atributoParaOrdenar(),copia);
                }
            }
            else if (seleccion.equals("0")){
                volver=true;
            }
            else {
                System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\" o \"0\"\n");
            }
        }
    }

    public static void valorExacto(String parametro) throws IOException {
        if (parametro.equalsIgnoreCase("IDPrueba")){
            int IDPruebaExacto=-1;
            while (true){
                System.out.print("Ingrese el valor exacto de número de informe: ");
                String ingreso = input.readLine();
                try{
                    IDPruebaExacto=Integer.parseInt(ingreso);
                    if(IDPruebaExacto>0){
                        break;
                    }
                    else{
                        System.out.println("Ingrese un valor numérico mayor que cero \n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            int indice = Collections.binarySearch(Main.informes, new Informe(IDPruebaExacto,false,"",0,0,0), new ComparadorDeInformes("IDPrueba"));
            if (indice<0){
                System.out.println("No se encuentra el informe con el número \""+IDPruebaExacto+"\"\n");
            }
            else{
                System.out.println("El número de informe es una clave única, solamente se mostrará un informe con el identificador "+IDPruebaExacto+":");
                System.out.println(1+"   "+Main.informes.get(indice));
                ArrayList<Informe> copia = new ArrayList<>();
                copia.add(Main.informes.get(indice));
                EditarEliminar();
                String seleccion = input.readLine();
                if (seleccion.equals("1")){
                    MenuInforme.EditarInformePorID(copia);
                    return;
                }
                else if (seleccion.equals("2")){
                    MenuInforme.EliminarInformePorID(copia);
                    return;
                }
                else if (seleccion.equals("0")){
                    return;
                }
                else{
                    System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
        else if (parametro.equalsIgnoreCase("Resultado")){
            while (true){
                System.out.println("Ingrese el resultado exacto del informe:");
                System.out.println("1. Pasó");
                System.out.println("2. No Pasó");
                System.out.println("0. Volver");
                String ingreso = input.readLine();
                if(ingreso.equals("1")){
                    ArrayList<Informe> copia = new ArrayList<>();
                    boolean nohayregistro=true;
                    for (Clases.Informe informe : Main.informes){
                        if (informe.Resultado){
                            System.out.println(informe);
                            copia.add(informe);
                            nohayregistro=false;
                        }
                    }
                    if (nohayregistro){
                        System.out.println("No hay registros con el resultado \"Pasó\"\n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                    else {
                        ordenarPor(atributoParaOrdenar(),copia);
                        return;
                    }
                }
                else if (ingreso.equals("2")){
                    ArrayList<Informe> copia = new ArrayList<>();
                    boolean nohayregistro=true;
                    for (Clases.Informe informe : Main.informes){
                        if (!informe.Resultado){
                            System.out.println(informe);
                            copia.add(informe);
                            nohayregistro=false;
                        }
                    }
                    if (nohayregistro){
                        System.out.println("No hay registros con el resultado \"No Pasó\"\n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                    else {
                        ordenarPor(atributoParaOrdenar(),copia);
                        return;
                    }
                }
                else if (ingreso.equals("0")){
                    break;
                }
                else{
                    System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
        else if (parametro.equalsIgnoreCase("Temperatura")){
            int temperaturaExacta=-1;
            while (true){
                System.out.print("Ingrese la temperatura exacta del informe: ");
                String ingreso = input.readLine();
                try{
                    temperaturaExacta=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro=true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Temperatura==temperaturaExacta){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro=false;
                }
            }
            if (nohayregistro){
                System.out.println("No se encuentran registros con temperatura \""+temperaturaExacta+"\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Humedad")){
            int humedadExacta=-1;
            while (true){
                System.out.print("Ingrese la humedad relativa exacta del informe en (% de 0-100): ");
                String ingreso = input.readLine();
                try{
                    humedadExacta=Integer.parseInt(ingreso);
                    if (humedadExacta<0 || humedadExacta>100){
                        System.out.println("Ingrese una humedad relativa entre 0-100");
                    }
                    else{
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de humedad relativa entre 0-100 \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Humedad==humedadExacta){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No se encuentran registros con humedad relativa \""+humedadExacta+"\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Presion")){
            int presionExacta=-1;
            while (true){
                System.out.print("Ingrese la presión exacta del informe en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionExacta=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Presion==presionExacta){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No se encuentran registros con presión \""+presionExacta+"\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
    }

    public static void valorMinimo(String parametro) throws IOException{
        if (parametro.equalsIgnoreCase("IDPrueba")){
            int IDPruebaMinimo=-1;
            while (true){
                System.out.print("Ingrese el valor mínimo de número de informe: ");
                String ingreso = input.readLine();
                try{
                    IDPruebaMinimo=Integer.parseInt(ingreso);
                    if(IDPruebaMinimo>0){
                        break;
                    }
                    else{
                        System.out.println("Ingrese un valor numérico mayor que cero \n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Informe informe : Main.informes){
                if (informe.IDPrueba >= IDPruebaMinimo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con identificador numérico (ID) mayor a \""+IDPruebaMinimo+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Temperatura")){
            int temperaturaMinima=-1;
            while (true){
                System.out.print("Ingrese la temperatura mínima del informe: ");
                String ingreso = input.readLine();
                try{
                    temperaturaMinima=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Temperatura>=temperaturaMinima){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con temperatura mayor a \""+temperaturaMinima+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Humedad")){
            int humedadMinima=-1;
            while (true){
                System.out.print("Ingrese la humedad relativa mínima del informe en (% de 0-100): ");
                String ingreso = input.readLine();
                try{
                    humedadMinima=Integer.parseInt(ingreso);
                    if (humedadMinima<0 || humedadMinima>100){
                        System.out.println("Ingrese una humedad relativa entre 0-100");
                    }
                    else{
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de humedad relativa entre 0-100 \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro =  true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Humedad>=humedadMinima){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con humedad relativa mayor a \""+humedadMinima+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Presion")){
            int presionMinima=-1;
            while (true){
                System.out.print("Ingrese la presión mínima del informe en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionMinima=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Presion>=presionMinima){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con presión mayor a \""+presionMinima+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
    }

    public static void valorMaximo(String parametro) throws IOException{
        if (parametro.equalsIgnoreCase("IDPrueba")){
            int IDPruebaMaximo=-1;
            while (true){
                System.out.print("Ingrese el valor máximo de número de informe: ");
                String ingreso = input.readLine();
                try{
                    IDPruebaMaximo=Integer.parseInt(ingreso);
                    if(IDPruebaMaximo>0){
                        break;
                    }
                    else{
                        System.out.println("Ingrese un valor numérico mayor que cero \n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Informe informe : Main.informes){
                if (informe.IDPrueba <= IDPruebaMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informes con número identificador (ID) menor a \""+IDPruebaMaximo+"\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Temperatura")){
            int temperaturaMaximo=-1;
            while (true){
                System.out.print("Ingrese la temperatura máxima del informe: ");
                String ingreso = input.readLine();
                try{
                    temperaturaMaximo=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Temperatura<=temperaturaMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con temperatura menor a \""+temperaturaMaximo+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Humedad")){
            int humedadMaximo=-1;
            while (true){
                System.out.print("Ingrese la humedad relativa máxima del informe en (% de 0-100): ");
                String ingreso = input.readLine();
                try{
                    humedadMaximo=Integer.parseInt(ingreso);
                    if (humedadMaximo<0 || humedadMaximo>100){
                        System.out.println("Ingrese una humedad relativa entre 0-100");
                    }
                    else{
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de humedad relativa entre 0-100 \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Humedad<=humedadMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con humedad relativa menor a \""+humedadMaximo+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Presion")){
            int presionMaximo=-1;
            while (true){
                System.out.print("Ingrese la presión máxima del informe en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionMaximo=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            boolean nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Presion<=presionMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con presión menor a \""+presionMaximo+"\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
    }

    public static void rango(String parametro) throws IOException{
        boolean nohayregistro;
        if (parametro.equalsIgnoreCase("IDPrueba")){
            int IDPruebaMinimo=-1;
            int IDPruebaMaximo=-1;
            while (true){
                System.out.print("Ingrese el valor mínimo de número de informe: ");
                String ingreso = input.readLine();
                try{
                    IDPruebaMinimo=Integer.parseInt(ingreso);
                    if(IDPruebaMinimo>0){
                        break;
                    }
                    else{
                        System.out.println("Ingrese un valor numérico mayor que cero \n");
                        if(cancelarBusqueda()){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            while (true){
                System.out.print("Ingrese el valor máximo de número de informe: ");
                String ingreso = input.readLine();
                try{
                    IDPruebaMaximo=Integer.parseInt(ingreso);
                    if(IDPruebaMaximo>0){
                        break;
                    }
                    else{
                        System.out.println("Ingrese un valor numérico mayor que cero \n");
                        if (cancelarBusqueda()){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            nohayregistro = true;
            for (Informe informe : Main.informes){
                if (informe.IDPrueba >= IDPruebaMinimo && informe.IDPrueba <= IDPruebaMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con identificador numérico (ID) en el rango ["+IDPruebaMinimo+","+IDPruebaMaximo+"]\"\n");
            }
            else {
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Temperatura")){
            int temperaturaMaximo=-1;
            int temperaturaMinima=-1;
            while (true){
                System.out.print("Ingrese la temperatura mínima del informe: ");
                String ingreso = input.readLine();
                try{
                    temperaturaMinima=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            while (true){
                System.out.print("Ingrese la temperatura máxima del informe: ");
                String ingreso = input.readLine();
                try{
                    temperaturaMaximo=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Temperatura>=temperaturaMinima && informe.Temperatura<=temperaturaMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con temperatura en el rango ["+temperaturaMinima+","+temperaturaMaximo+"]\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Humedad")){
            int humedadMinima=-1;
            int humedadMaximo=-1;
            while (true){
                System.out.print("Ingrese la humedad relativa mínima del informe en (% de 0-100): ");
                String ingreso = input.readLine();
                try{
                    humedadMinima=Integer.parseInt(ingreso);
                    if (humedadMinima<0 || humedadMinima>100){
                        System.out.println("Ingrese una humedad relativa entre 0-100");
                    }
                    else{
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de humedad relativa entre 0-100 \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            while (true){
                System.out.print("Ingrese la humedad relativa máxima del informe en (% de 0-100): ");
                String ingreso = input.readLine();
                try{
                    humedadMaximo=Integer.parseInt(ingreso);
                    if (humedadMaximo<0 || humedadMaximo>100){
                        System.out.println("Ingrese una humedad relativa entre 0-100");
                    }
                    else{
                        break;
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de humedad relativa entre 0-100 \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Humedad>=humedadMinima && informe.Humedad<=humedadMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro=false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con humedad relativa en el rango ["+humedadMinima+","+humedadMaximo+"]\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
        else if (parametro.equalsIgnoreCase("Presion")){
            int presionMinima=-1;
            int presionMaximo=-1;
            while (true){
                System.out.print("Ingrese la presión mínima del informe en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionMinima=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            while (true){
                System.out.print("Ingrese la presión máxima del informe en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionMaximo=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    if (cancelarBusqueda()){
                        return;
                    }
                }
            }
            ArrayList<Informe> copia = new ArrayList<>();
            nohayregistro = true;
            for (Clases.Informe informe : Main.informes){
                if (informe.Presion>=presionMinima && informe.Presion<=presionMaximo){
                    System.out.println(informe);
                    copia.add(informe);
                    nohayregistro = false;
                }
            }
            if (nohayregistro){
                System.out.println("No hay registros de informe con presión en el rango ["+presionMinima+","+presionMaximo+"]\"\n");
            }
            else{
                ordenarPor(atributoParaOrdenar(),copia);
            }
        }
    }

    public static char atributoNumerico() throws IOException {
        while (true){
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            System.out.println("0. Volver");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                return '1';
            }
            else if (seleccion.equals("2")){
                return '2';
            }
            else if (seleccion.equals("3")){
                return '3';
            }
            else if (seleccion.equals("4")){
                return '4';
            }
            else if (seleccion.equals("0")){
                return '0';
            }
            else {
                System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\", \"3\", \"4\" o \"0\"\n");
            }
        }
    }

    public static char atributoParaOrdenar() throws IOException {
        while (true) {
            System.out.println("Ordenar resultados de búsqueda por:");
            System.out.println("1. Número de informe");
            System.out.println("2. Resultado");
            System.out.println("3. Comentarios");
            System.out.println("4. Temperatura");
            System.out.println("5. Humedad");
            System.out.println("6. Presión");
            System.out.println("0. Cancelar");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                return '1';
            }
            else if (seleccion.equals("2")){
                return '2';
            }
            else if (seleccion.equals("3")){
                return '3';
            }
            else if (seleccion.equals("4")){
                return '4';
            }
            else if (seleccion.equals("5")){
                return '5';
            }
            else if (seleccion.equals("6")){
                return '6';
            }
            else if (seleccion.equals("0")){
                return '0';
            }
            else {
                System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\" o \"0\"\n");
            }
        }
    }

    public static void ordenarPor(char atributoParaOrdenar, ArrayList<Informe> copia) throws IOException{
        if (atributoParaOrdenar=='1'){
            orden(ascendenteODescendente(),copia,"IDPrueba");
        }
        else if (atributoParaOrdenar=='2'){
            orden('3',copia,"Resultado");
        }
        else if (atributoParaOrdenar=='3'){
            orden('4',copia,"Comentarios");
        }
        else if (atributoParaOrdenar=='4'){
            orden(ascendenteODescendente(),copia,"Temperatura");
        }
        else if (atributoParaOrdenar=='5'){
            orden(ascendenteODescendente(),copia,"Humedad");
        }
        else if (atributoParaOrdenar=='6'){
            orden(ascendenteODescendente(),copia,"Presion");
        }
    }

    public static char ascendenteODescendente() throws IOException {
        while (true){
            System.out.println("1. Ordenar de manera ascendente");
            System.out.println("2. Ordenar de manera descendente");
            System.out.println("0. Volver");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                return '1';
            }
            else if (seleccion.equals("2")){
                return '2';
            }
            else if (seleccion.equals("0")){
                return '0';
            }
            else{
                System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
            }
        }
    }

    public static void orden(char ascendenteODescendente, ArrayList<Informe> copia, String ParametroComparador) throws IOException {
        if (ascendenteODescendente=='1'){
            Collections.sort(copia, new ComparadorDeInformes(ParametroComparador));
            int IDtemporal=0;
            for (Informe informe : copia){
                System.out.println(IDtemporal+1+"   "+informe);
                IDtemporal++;
            }
            while (true) {
                EditarEliminar();
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    MenuInforme.EditarInformePorID(copia);
                    break;
                }
                else if (opcion.equals("2")){
                    MenuInforme.EliminarInformePorID(copia);
                    break;
                }
                else if (opcion.equals("0")){
                    return;
                }
                else {
                    System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
        else if (ascendenteODescendente=='2'){
            Collections.sort(copia, new ComparadorDeInformes(ParametroComparador).reversed());
            int IDtemporal=0;
            for (Informe informe : copia){
                System.out.println(IDtemporal+1+"   "+informe);
                IDtemporal++;
            }
            while (true) {
                EditarEliminar();
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    MenuInforme.EditarInformePorID(copia);
                    break;
                }
                else if (opcion.equals("2")){
                    MenuInforme.EliminarInformePorID(copia);
                    break;
                }
                else if (opcion.equals("0")){
                    return;
                }
                else {
                    System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
        else if (ascendenteODescendente=='3'){
            while (true){
                System.out.println("1. Ordenar por prueba Superada");
                System.out.println("2. Ordenar por prueba No Superada");
                System.out.println("0. Volver");
                String seleccion = input.readLine();
                if (seleccion.equals("1")){
                    Collections.sort(copia, new ComparadorDeInformes(ParametroComparador));
                    int IDtemporal=0;
                    for (Informe informe : copia){
                        System.out.println(IDtemporal+1+"   "+informe);
                        IDtemporal++;
                    }
                    while (true) {
                        EditarEliminar();
                        String opcion = input.readLine();
                        if (opcion.equals("1")){
                            MenuInforme.EditarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("2")){
                            MenuInforme.EliminarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("0")){
                            return;
                        }
                        else {
                            System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                        }
                    }
                }
                else if (seleccion.equals("2")){
                    Collections.sort(copia, new ComparadorDeInformes(ParametroComparador).reversed());
                    int IDtemporal=0;
                    for (Informe informe : copia){
                        System.out.println(IDtemporal+1+"   "+informe);
                        IDtemporal++;
                    }
                    while (true) {
                        EditarEliminar();
                        String opcion = input.readLine();
                        if (opcion.equals("1")){
                            MenuInforme.EditarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("2")){
                            MenuInforme.EliminarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("0")){
                            return;
                        }
                        else {
                            System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                        }
                    }
                }
                else if (seleccion.equals("0")){
                    return;
                }
                else{
                    System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
        else if (ascendenteODescendente=='4'){
            while (true){
                System.out.println("1. Ordenar alfabéticamente ascendente");
                System.out.println("2. Ordenar alfabéticamente descendente");
                System.out.println("0. Volver");
                String seleccion = input.readLine();
                if (seleccion.equals("1")){
                    Collections.sort(copia, new ComparadorDeInformes(ParametroComparador));
                    int IDtemporal=0;
                    for (Informe informe : copia){
                        System.out.println(IDtemporal+1+"   "+informe);
                        IDtemporal++;
                    }
                    while (true) {
                        EditarEliminar();
                        String opcion = input.readLine();
                        if (opcion.equals("1")){
                            MenuInforme.EditarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("2")){
                            MenuInforme.EliminarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("0")){
                            return;
                        }
                        else {
                            System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                        }
                    }
                }
                else if (seleccion.equals("2")){
                    Collections.sort(copia, new ComparadorDeInformes(ParametroComparador).reversed());
                    int IDtemporal=0;
                    for (Informe informe : copia){
                        System.out.println(IDtemporal+1+"   "+informe);
                        IDtemporal++;
                    }
                    while (true) {
                        EditarEliminar();
                        String opcion = input.readLine();
                        if (opcion.equals("1")){
                            MenuInforme.EditarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("2")){
                            MenuInforme.EliminarInformePorID(copia);
                            break;
                        }
                        else if (opcion.equals("0")){
                            return;
                        }
                        else {
                            System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                        }
                    }
                }
                else if (seleccion.equals("0")){
                    return;
                }
                else{
                    System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                }
            }
        }
    }

    public static void EditarEliminar() {
        System.out.println("¿Desea eliminar o editar algún elemento?");
        System.out.println("1. Editar");
        System.out.println("2. Eliminar");
        System.out.println("0. No");
    }

    public static char atributoDeTexto() throws IOException {
        while (true){
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Volver");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                return '1';
            }
            else if (seleccion.equals("2")){
                return '2';
            }
            else if (seleccion.equals("0")){
                return '0';
            }
            else {
                System.out.println("Por favor, seleccione una de las opciones válidas, \"1\", \"2\", o \"0\"\n");
            }
        }
    }

    public static void valorExactoDeTexto() throws IOException {
        System.out.print("Ingrese el comentario que desea buscar, teniendo en cuenta las mayúsculas: ");
        String comentario = input.readLine();
        ArrayList<Informe> copia = new ArrayList<>();
        boolean nohayregistro=true;
        for (Informe informe : Main.informes){
            if (informe.Comentarios.equals(comentario)){
                System.out.println(informe);
                copia.add(informe);
                nohayregistro=false;
            }
        }
        if (nohayregistro){
            System.out.println("No se encontraron registros con este comentario \""+comentario+"\"\n");
        }
        else{
            ordenarPor(atributoParaOrdenar(),copia);
        }
    }

    public static void valorDeTexto() throws IOException {
        System.out.print("Ingrese el comentario que desea buscar, sin considerar las mayúsculas: ");
        String comentario = input.readLine();
        ArrayList<Informe> copia = new ArrayList<>();
        boolean nohayregistro=true;
        for (Informe informe : Main.informes){
            if (informe.Comentarios.equalsIgnoreCase(comentario)){
                System.out.println(informe);
                copia.add(informe);
                nohayregistro=false;
            }
        }
        if (nohayregistro){
            System.out.println("No se encontraron registros con este comentario \""+comentario+"\"\n");
        }
        else{
            ordenarPor(atributoParaOrdenar(),copia);
        }
    }

    public static boolean cancelarBusqueda() throws IOException {
        while (true){
            System.out.println("¿Desea cancelar la búsqueda?");
            System.out.println("1. SÍ");
            System.out.println("2. NO");
            String cancelar = input.readLine();
            if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                return true;
            }
            else if (cancelar.equals("2") || cancelar.equalsIgnoreCase("no")){
                return false;
            }
            else {
                System.out.println("Debe ingresar una opción: \"1\",\"si\" o \"2\",\"no\"");
            }
        }
    }
}