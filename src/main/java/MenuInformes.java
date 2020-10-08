import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MenuInformes {
    public static BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    public static void CRUDinforme() throws IOException {
        boolean volver = false;
        while (!volver){
            System.out.println("1. Ver informes");
            System.out.println("2. Crear Informe");
            System.out.println("3. Editar informe");
            System.out.println("4. Eliminar informe");
            System.out.println("0. Volver");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                VerInformes();
                return;
            }
            else if (seleccion.equals("2")){
                CrearInforme();
                return;
            }
            else if (seleccion.equals("3")){
                EditarInforme();
                return;
            }
            else if(seleccion.equals("4")){
                EliminarInforme();
                return;

            }
            else if(seleccion.equals("0")){
                volver=true;
            }
            else{
                System.out.println("Por favor, ingrese unaopción válida \"1\", \"2\", \"3\", \"4\" o \"0\" \n");
            }
        }
    }
    public static void VerInformes(){
        if (Main.informes.size()==0){
            System.out.println("No hay informes registrados todavía");
        }
        else{
            for (Clases.Informe informe : Main.informes){
                System.out.println(informe);
            }
        }
    }
    public static void CrearInforme() throws IOException{
        System.out.print("Ingrese el identificador (ID) de la prueba a la cual desea generar el informe: ");
        String ingreso= input.readLine();
        int IDPrueba=-1;
        boolean identificadoraprobado=false;
        boolean cancelarregistro=false;
        while (!cancelarregistro && !identificadoraprobado){
            ingreso = input.readLine();
            ingreso=ingreso.replaceAll("\\s","");
            ingreso=ingreso.replaceAll("[.]","");
            ingreso=ingreso.replaceAll("[,]","");
            int indice = Collections.binarySearch(Main.pruebas, new Clases.Prueba(ingreso,"","","",new ArrayList<>()), new Comparadores.ComparadorIDPrueba());
            if (indice>=0){
                Clases.Prueba prueba = Main.pruebas.get(indice);
                if (prueba.NumInforme<0){
                    System.out.print("Ingrese el numero de informe que desea asignar: ");
                    String entrada = input.readLine();
                    try{
                        IDPrueba=Integer.parseInt(entrada);
                        if(IDPrueba<0) {
                            System.out.println("Ingrese un identificador numérico mayor que cero\n");
                            cancelarregistro=Main.CancelarRegistro();
                            identificadoraprobado = false;
                        }
                        else{
                            int contador=0;
                            for (Clases.Prueba pruebacon : Main.pruebas){
                                if (pruebacon.NumInforme==IDPrueba){
                                    System.out.println("Este número de informe ya ha sido asignado a otra prueba, por favor, digite uno diferente\n");
                                }
                                contador++;
                            }
                            if (contador==Main.pruebas.size()){
                                prueba.NumInforme=IDPrueba;
                                identificadoraprobado=true;
                                System.out.println("El número identificador se asignó correctamente\n");
                            }
                        }
                    } catch (Exception exc){
                        System.out.println("Ingrese un identificador numérico mayor que cero\n");
                        cancelarregistro=Main.CancelarRegistro();
                    }
                }
                else{
                    System.out.println("La prueba registrada con este idetificador (ID) ya tiene un informe\n");
                    System.out.println("Las pruebas sin informe son: \n");
                    for(Clases.Prueba pruebasin : Main.pruebas){
                        if (prueba.NumInforme<0){
                            System.out.println(pruebasin);
                        }
                    }
                    cancelarregistro=Main.CancelarRegistro();
                }
            }
            else{
                System.out.println("No existe una prueba realizada que tenga este identificador (ID): "+ingreso);
            }
        }
        if (cancelarregistro){
            return;
        }
        boolean resultado=false;
        boolean resultadoaprovado=false;
        while(!resultadoaprovado && !cancelarregistro){
            System.out.println("Ingrese el resultado de la prueba: ");
            System.out.println(" 1. Pasó");
            System.out.println(" 2. No Pasó");
            ingreso= input.readLine();
            if (ingreso.equals("1")){
                resultado=true;
                resultadoaprovado=true;
            }
            else if (ingreso.equals("2")){
                resultadoaprovado=true;
            }
            else {
                System.out.println("Por favor, ingrese un resultado válido \"1\" o \"2\"\n");
                cancelarregistro=Main.CancelarRegistro();
            }
        }
        if (cancelarregistro){
            return;
        }
        System.out.println("Escriba un comentario o frase acerca de la prueba, si lo desea (por ej: perforado, flameado, quemado, etc.) o presione enter.\n");
        String comentarios = input.readLine();
        double temperatura=0;
        boolean temperaturaaprovada=false;
        while(!temperaturaaprovada){
            System.out.print("Digite la temperatura en (°C) a la cual se realizó la prueba: ");
            ingreso = input.readLine();
            try{
                temperatura = Double.parseDouble(ingreso);
                temperaturaaprovada=true;
            } catch (Exception exc){
                System.out.println("Por favor, ingrese un valor numérico de temperatura");
            }
        }
        double humedad=0;
        boolean humedadaprovada=false;
        while(!humedadaprovada){
            System.out.print("Digite la humedad en (% de 0-100) a la cual se realizó la prueba: ");
            ingreso = input.readLine();
            try{
                humedad = Double.parseDouble(ingreso);
                if (humedad<0 || humedad>100){
                    System.out.println("Por favor, ingrese un númerico de humedad entre 0-100\n");
                }
                else{
                    humedadaprovada=true;
                }
            } catch (Exception exc){
                System.out.println("Por favor, ingrese un valor numérico de humedad\n");
            }
        }
        double presion=0;
        boolean presionaprovada=false;
        while(!presionaprovada){
            System.out.print("Digite la presión en (mmHg) a la cual se realizó la prueba: ");
            ingreso = input.readLine();
            try{
                presion = Double.parseDouble(ingreso);
                presionaprovada=true;
            } catch (Exception exc){
                System.out.println("Por favor, ingrese un valor numérico de presión");
            }
        }
        Clases.Informe nuevoinforme = new Clases.Informe(IDPrueba,resultado,comentarios,temperatura,humedad,presion);
        int enelquevoy=Main.informes.size();
        Main.informes.add(nuevoinforme);
        if (enelquevoy != 0) {
            while (enelquevoy > 0 && Main.informes.get(enelquevoy).IDPrueba < Main.informes.get(enelquevoy - 1).IDPrueba) {
                Clases.Informe buffer = Main.informes.get(enelquevoy);
                Main.informes.set(enelquevoy, Main.informes.get(enelquevoy - 1));
                Main.informes.set(enelquevoy - 1, buffer);
                enelquevoy--;
            }
        }
        System.out.println("El informe se ha generado satisfactoriamente\n");
    }
    public static void EditarInforme() throws IOException{
        boolean salir = false;
        while (!salir){
            System.out.println("Seleccionar por:");
            System.out.println(" 1. Identificador número de informe de prueba ");
            System.out.println(" 0. Cancelar");
            String seleccion = input.readLine();
            if (seleccion.equals("1")) {
                System.out.print("Ingrese el número de informe de la prueba a la cual desea editar el informe: ");
                int identificador;
                String ingreso = input.readLine();
                try{
                    ingreso=ingreso.replaceAll("[.]","");
                    ingreso=ingreso.replaceAll("[,]","");
                    identificador=Integer.parseInt(ingreso);
                    if(identificador<0) {
                        System.out.println("Por favor, ingrese un identificador numérico mayor que cero\n");
                    }
                    else{
                        int contador;
                        int indice = Collections.binarySearch(Main.informes, new Clases.Informe(identificador,false,"",0,0,0), new Comparadores.ComparadorNumInforme());
                        Clases.Informe informe = Main.informes.get(indice);
                        if (indice>=0){
                            System.out.println("Se mostrarán todos los campos del informe de la prueba, ");
                            System.out.println("si desea modificarlo, digite el valor, de lo contrario, presione enter:\n");
                            boolean cambiovalido = false;
                            int IDPruebacambiado=informe.IDPrueba;
                            int bufferIDPrueba=informe.IDPrueba;
                            while(!cambiovalido){
                                System.out.print("Identificador del informe de la prueba: "+informe.IDPrueba+": ");
                                String cambio=input.readLine();
                                if (cambio.equals("")){
                                    break;
                                }
                                else{
                                    try{
                                        IDPruebacambiado=Integer.parseInt(cambio);
                                        if(IDPruebacambiado<0){
                                            System.out.println("Por favor, ingrese un identificador numérico mayor que cero \n");
                                        }
                                        else{
                                            contador = 0;
                                            for(Clases.Prueba prueba : Main.pruebas){
                                                if (prueba.NumInforme==IDPruebacambiado){
                                                    System.out.println("Este identificador ya ha sido asignado al informe de una prueba\n");
                                                    break;
                                                }
                                                contador++;
                                            }
                                            if (contador == Main.pruebas.size()){
                                                cambiovalido=true;
                                            }
                                        }
                                    } catch (Exception exc){
                                        System.out.println("Por favor, ingrese un identificador numérico mayor que cero\n");
                                    }
                                }
                            }
                            cambiovalido=false;
                            boolean informecambiado=informe.Resultado;
                            while (!cambiovalido){
                                System.out.print("Resultado de la prueba: "+informe.PasoNoPaso()+": ");
                                String cambio = input.readLine();
                                if (cambio.equals("")){
                                    break;
                                }
                                else{
                                    cambio=cambio.replaceAll("\\s","");
                                    cambio=cambio.replaceAll("[.]","");
                                    cambio=cambio.replaceAll("[,]","");
                                    if (cambio.equalsIgnoreCase("paso")){
                                        informecambiado=true;
                                        cambiovalido=true;
                                    }
                                    else if (cambio.equalsIgnoreCase("nopaso")){
                                        informecambiado=false;
                                        cambiovalido=true;
                                    }
                                    else{
                                        System.out.println("Por favor, digite \"paso\" o \"no paso\", en el caso que desee modificar el resultado\n");
                                    }
                                }
                            }
                            String comentarioscambiados = informe.Comentarios;
                            System.out.print("Comentarios de la prueba: "+informe.Comentarios+": ");
                            String cambio = input.readLine();
                            if (!cambio.equals("")){
                                comentarioscambiados=cambio;
                            }
                            double temperaturacambiada=informe.Temperatura;
                            cambiovalido=false;
                            while(!cambiovalido){
                                System.out.print("Temperatura de la prueba en (°C): "+informe.Temperatura+": ");
                                cambio = input.readLine();
                                double temperaturabuffer;
                                try{
                                    if(cambio.equals("")){
                                        break;
                                    }
                                    else{
                                        temperaturabuffer=Double.parseDouble(cambio);
                                        temperaturacambiada=temperaturabuffer;
                                        cambiovalido=true;
                                    }
                                } catch (Exception exc){
                                    System.out.println("Por favor, ingrese un valor numérico de temperatura");
                                }
                            }
                            double humedadcambiada=informe.Humedad;
                            cambiovalido=false;
                            while(!cambiovalido){
                                double humedad;
                                System.out.print("Humedad de la prueba en (% de 0-100): "+informe.Humedad+": ");
                                cambio = input.readLine();
                                try{
                                    if(cambio.equals("")){
                                        break;
                                    }
                                    else{
                                        humedad = Double.parseDouble(ingreso);
                                        if (humedad<0 || humedad>100){
                                            System.out.println("Por favor, ingrese un númerico de humedad entre 0-100\n");
                                        }
                                        else{
                                            humedadcambiada=humedad;
                                            cambiovalido=true;
                                        }
                                    }
                                } catch (Exception exc){
                                    System.out.println("Por favor, ingrese un valor numérico de humedad\n");
                                }
                            }
                            double presioncambiada = informe.Presion;
                            cambiovalido=false;
                            while(!cambiovalido){
                                double presion;
                                System.out.print("Presión de la prueba: "+informe.Presion+": ");
                                cambio = input.readLine();
                                try{
                                    if(cambio.equals("")){
                                        break;
                                    }
                                    else{
                                        presion = Double.parseDouble(cambio);
                                        presioncambiada=presion;
                                        cambiovalido=true;
                                    }
                                } catch (Exception exc){
                                    System.out.println("Por favor, ingrese un valor numérico de presión");
                                }
                            }
                            boolean guardadovalido=false;
                            while (!guardadovalido){
                                System.out.println("¿Desea guardar los cambios?");
                                System.out.println(" Y <---> SI");
                                System.out.println(" N <---> NO");
                                seleccion=input.readLine();
                                if (seleccion.equalsIgnoreCase("y") || seleccion.equalsIgnoreCase("si")) {
                                    informe.IDPrueba=IDPruebacambiado;
                                    informe.Resultado=informecambiado;
                                    informe.Comentarios=comentarioscambiados;
                                    informe.Temperatura=temperaturacambiada;
                                    informe.Humedad=humedadcambiada;
                                    informe.Presion=presioncambiada;
                                    for(Clases.Prueba prueba : Main.pruebas){
                                        if(prueba.NumInforme==bufferIDPrueba){
                                            prueba.NumInforme=IDPruebacambiado;
                                        }
                                    }
                                    Collections.sort(Main.informes, new Comparadores.ComparadorNumInforme());
                                    salir=true;
                                }
                                else if(seleccion.equalsIgnoreCase("n") || seleccion.equalsIgnoreCase("no")){
                                    guardadovalido=true;
                                    salir=true;
                                }
                                else{
                                    System.out.println("Por favor, ingrese la opción \"Y\" o \"N\" para confirmar los cambios\n");
                                }
                            }
                        }
                        else {
                            System.out.println("La prueba con número de informe \""+identificador+"\" no se encuentra en la base de datos\n");
                        }
                    }
                } catch(Exception exc){
                    System.out.println("Por favor, ingrese un identificador numérico mayor que cero\n");
                }
            }
            else if (seleccion.equals("0")){
                salir=true;
            }
            else{
                System.out.println("La opción de búsqueda única para informes es \"Identificador de prueba (ID)\", por favor digite \"1\" o \"0\"");
            }
        }
    }
    public static void EliminarInforme() throws IOException{
        boolean salir = false;
        while (!salir) {
            System.out.println("Seleccionar por:");
            System.out.println(" 1. Identificador de prueba (ID)");
            System.out.println(" 0. Cancelar");
            String seleccion = input.readLine();
            if (seleccion.equals("1")) {
                System.out.print("Ingrese el identificador de informe de la prueba que desea eliminar: ");
                int identificador;
                String ingreso = input.readLine();
                try {
                    ingreso=ingreso.replaceAll("[.]", "");
                    ingreso=ingreso.replaceAll("[,]", "");
                    identificador = Integer.parseInt(ingreso);
                    if (identificador < 0) {
                        System.out.println("Por favor, ingrese un identificador numérico mayor que cero\n");
                    } else {
                        int indice = Collections.binarySearch(Main.informes,new Clases.Informe(identificador,false,"",0,0,0), new Comparadores.ComparadorNumInforme());
                        if (indice>=0){
                            if (Main.informes.get(indice).IDPrueba==identificador){
                                System.out.println("¿Está seguro de eliminar el informe?");
                                System.out.println(" Y <---> SI");
                                System.out.println(" N <---> NO");
                                seleccion=input.readLine();
                                if (seleccion.equalsIgnoreCase("y") || seleccion.equalsIgnoreCase("si")) {
                                    for(Clases.Prueba prueba : Main.pruebas){
                                        if (prueba.NumInforme==identificador){
                                            prueba.NumInforme=-1;
                                            break;
                                        }
                                    }
                                    Main.informes.remove(indice);
                                    salir=true;
                                }
                                else if(seleccion.equalsIgnoreCase("n") || seleccion.equalsIgnoreCase("no")){
                                    salir=true;
                                }
                                else{
                                    System.out.println("Por favor, ingrese la opción \"Y\" o \"N\" para confirmar la eliminación\n");
                                }
                            }
                        }
                        else {
                            System.out.println("El informe con el identificador dado no se encuentra en la base de datos\n");
                        }
                    }
                } catch (Exception exc) {
                    System.out.println("Por favor, ingrese un identificador numérico mayor que cero\n");
                }
            }
            else if (seleccion.equals("0")){
                salir=true;
            }
            else{
                System.out.println("La opción de búsqueda única para informes es \"Identificador de prueba (ID)\", por favor digite \"1\" o \"0\"");
            }
        }
    }
}
