import Clases.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

///////////////////////////// FALTA RELACIONAR LOS INFORMES CON EL LABORATORIO MEDIANTE EL NUMERO DE INFORME

public class MenuInformes {
    public static BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    public static void CRUDinforme() throws IOException {
        boolean menuinformes = false;
        while (!menuinformes){
            System.out.println("1. Ver informes");
            System.out.println("2. Crear Informe");
            System.out.println("3. Editar informe");
            System.out.println("4. Eliminar informe");
            System.out.println("0. Volver");
            String seleccion = input.readLine();
            if (seleccion.equals("1")){
                if (Main.informes.size()==0){
                    System.out.println("No hay informes registrados todavía");
                }
                else{
                    for (Clases.Informe informe : Main.informes){
                        System.out.println(informe);
                    }
                }
            }
            else if (seleccion.equals("2")){
                System.out.print("Ingrese el identificador (ID) de la prueba a la cual desea generar el informe:");
                String ingreso = input.readLine();
                int identificador=-1;
                boolean identificadoraprobado=false;
                boolean cancelarregistro=false;
                while (!cancelarregistro && !identificadoraprobado){
                    try{
                        identificador=Integer.parseInt(ingreso);
                        if(identificador<0){
                            System.out.println("Ingrese un identificador numérico mayor que cero\n");
                            identificadoraprobado=false;
                            cancelarregistro=Main.CancelarRegistro();
                            System.out.println("Las pruebas sin informe son: ");
                            for(Clases.Prueba prueba : Main.pruebas){
                                if (prueba.NumInforme<0){
                                    System.out.println(prueba);
                                }
                            }
                        }
                        else{
                            int contador=0;
                            for (Clases.Prueba prueba : Main.pruebas){
                                if (prueba.NumInforme==identificador){
                                    System.out.println("La prueba registrada con este idetificador ya tiene un informe\n");
                                    cancelarregistro=Main.CancelarRegistro();
                                    break;
                                }
                                contador++;
                            }
                            if (contador==Main.pruebas.size()){
                                identificadoraprobado=true;
                            }
                        }
                    }catch (Exception exc){
                        System.out.println("Ingrese un identificador numérico mayor que cero\n");
                        cancelarregistro=Main.CancelarRegistro();
                        System.out.println("Las pruebas sin informe son: \n");
                        for(Clases.Prueba prueba : Main.pruebas){
                            if (prueba.NumInforme<0){
                                System.out.println(prueba);
                            }
                        }
                    }
                }
                if (cancelarregistro){
                    continue;
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
                        resultado=false;
                        resultadoaprovado=true;
                    }
                    else {
                        System.out.println("Por favor, ingrese un resultado válido \"1\" o \"2\"\n");
                        cancelarregistro=Main.CancelarRegistro();
                    }
                }
                if (cancelarregistro){
                    continue;
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
                Clases.Informe nuevoinforme = new Clases.Informe(identificador,resultado,comentarios,temperatura,humedad,presion);
                Main.informes.add(nuevoinforme);
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Writer writer = Files.newBufferedWriter(Paths.get("Informes.json"));
                    gson.toJson(Main.informes, writer);
                    System.out.println("El informe se ha generado satisfactoriamente\n");
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if (seleccion.equals("3")){

            }
        }
    }
}
