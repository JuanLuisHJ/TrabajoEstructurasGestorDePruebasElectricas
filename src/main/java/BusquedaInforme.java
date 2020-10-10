import Clases.Informe;
import Comparadores.ComparadorDeInformes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BusquedaInforme {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void BusquedaInforme() throws IOException{
        boolean volver = false;
        while(!volver){
            System.out.println("1. Número de informe");
            System.out.println("2. Resultado");
            System.out.println("3. Comentarios");
            System.out.println("4. Temperatura");
            System.out.println("5. Humedad");
            System.out.println("6. Presión");
            System.out.println("7. Mostrar todos los informes");
            System.out.println("0. Salir ");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                char opcion = atributoNumerico();
                if (opcion=='1'){

                }

            }
            else if (seleccion.equals("2")){

            }
            else if (seleccion.equals("3")){

            }
            else if (seleccion.equals("4")){

            }
            else if (seleccion.equals("5")){

            }
            else if (seleccion.equals("6")){

            }
            else if (seleccion.equals("7")){

            }
            else if (seleccion.equals("0")){
                volver=true;
            }
            else {
                System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\" o \"0\"\n");
            }
        }
    }
    // ESTE PARÁMETRO LO PONGO YO SEGÚN SEA EL ATRIBUTO QUE SE HAYA ESCOGIDO
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
                        System.out.println("¿Desea cancelar la búsqueda?");
                        System.out.println("1. SÍ");
                        System.out.println("2. NO");
                        String cancelar = input.readLine();
                        if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                            return;
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico mayor que cero \n");
                    System.out.println("¿Desea cancelar la búsqueda?");
                    System.out.println("1. SÍ");
                    System.out.println("2. NO");
                    String cancelar = input.readLine();
                    if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                        return;
                    }
                }
            }
            int indice = Collections.binarySearch(Main.informes, new Informe(IDPruebaExacto,false,"",0,0,0), new ComparadorDeInformes("IDPrueba"));
            if (indice<0){
                System.out.println("No se encuentra el informe con el número \""+IDPruebaExacto+"\"");
            }
            else{
                System.out.println("El número de informe es una clave única, solamente se mostrará un informe con el valor "+IDPruebaExacto+":");
                System.out.println(Main.informes.get(indice));
            }
        }
        else if (parametro.equalsIgnoreCase("Resultado")){
            while (true){
                System.out.println("Ingrese el resultado exacto:");
                System.out.println("1. Pasó");
                System.out.println("2. No Pasó");
                System.out.println("0. Volver");
                String ingreso = input.readLine();
                if(ingreso.equals("1")){
                    for (Clases.Informe informe : Main.informes){
                        if (informe.Resultado){
                            System.out.println(informe);
                            // AQUÍ FALTA PREGUNTAR POR ATRIBUTO PARA ORDENAR
                        }
                    }
                }
                else if (ingreso.equals("2"))
                    for (Clases.Informe informe : Main.informes){
                        if (!informe.Resultado){
                            System.out.println(informe);
                            // AQUÍ FALTA PREGUNTAR POR ATRIBUTO PARA ORDENAR
                        }
                    }
                else if (ingreso.equals("0")){
                    break;
                }
                else{
                    System.out.println("Por favor, ingrese una de las opciones válidas, \"1\", \"2\" o \"0\"\n");
                    System.out.println("¿Desea cancelar la búsqueda?");
                    System.out.println("1. SÍ");
                    System.out.println("2. NO");
                    String cancelar = input.readLine();
                    if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                        return;
                    }
                }
            }
        }
        else if (parametro.equalsIgnoreCase("Temperatura")){
            int temperaturaExacta=-1;
            while (true){
                System.out.print("Ingrese la temperatura exacta: ");
                String ingreso = input.readLine();
                try{
                    temperaturaExacta=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de temperatura \n");
                    System.out.println("¿Desea cancelar la búsqueda?");
                    System.out.println("1. SÍ");
                    System.out.println("2. NO");
                    String cancelar = input.readLine();
                    if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                        return;
                    }
                }
            }
            for (Clases.Informe informe : Main.informes){
                if (informe.Temperatura==temperaturaExacta){
                    System.out.println(informe);
                    // AQUÍ FALTA PREGUNTAR POR ATRIBUTO PARA ORDENAR
                }
            }
        }
        else if (parametro.equalsIgnoreCase("Humedad")){
            int humedadExacta=-1;
            while (true){
                System.out.print("Ingrese la humedad relativa exacta en (% de 0-100): ");
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
                    System.out.println("¿Desea cancelar la búsqueda?");
                    System.out.println("1. SÍ");
                    System.out.println("2. NO");
                    String cancelar = input.readLine();
                    if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                        return;
                    }
                }
            }
            for (Clases.Informe informe : Main.informes){
                if (informe.Humedad==humedadExacta){
                    System.out.println(informe);
                    // AQUÍ FALTA PREGUNTAR POR ATRIBUTO PARA ORDENAR
                }
            }
        }
        else if (parametro.equalsIgnoreCase("Presion")){
            int presionExacta=-1;
            while (true){
                System.out.print("Ingrese la presión exacta en (mmHg): ");
                String ingreso = input.readLine();
                try{
                    presionExacta=Integer.parseInt(ingreso);
                    break;
                } catch (Exception exc) {
                    System.out.println("Ingrese un valor numérico de presión \n");
                    System.out.println("¿Desea cancelar la búsqueda?");
                    System.out.println("1. SÍ");
                    System.out.println("2. NO");
                    String cancelar = input.readLine();
                    if (cancelar.equals("1") || cancelar.equalsIgnoreCase("si")){
                        return;
                    }
                }
            }
            for (Clases.Informe informe : Main.informes){
                if (informe.Presion==presionExacta){
                    System.out.println(informe);
                    // AQUÍ FALTA PREGUNTAR POR ATRIBUTO PARA ORDENAR
                }
            }
        }
    }
    public static void ordenarPorIDPrueba() throws IOException {
        char opcion = ascendenteODescendente();

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
}
