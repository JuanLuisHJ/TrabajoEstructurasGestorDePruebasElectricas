import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Usuario> Usuarios = new ArrayList<>();
    public static ArrayList<Experimento> experimentos = new ArrayList<>();
    public static ArrayList<Muestra> muestras = new ArrayList<>();
    public static ArrayList<Modelo> modelos = new ArrayList<>();
    public static ArrayList<Informe> informes = new ArrayList<>();
    public static ArrayList<Priori> distribucionesapriori = new ArrayList<>();
    public static ArrayList<Posterior> distribucionposterior = new ArrayList<>();
    public static ArrayList<Descriptiva> descriptivas = new ArrayList<>();
    public static ArrayList<Inferencial> inferenciales = new ArrayList<>();
    public static int [] IDs = new int[8];
    public static void main(String[] args) throws IOException {
        CargarDatos();
        boolean acceso = false;
        while(!acceso) {
            System.out.println("Sistema de gestión en modelado estadístico\n");
            System.out.println("  1. Ingresar");
            System.out.println("  2. Registrarse");
            System.out.println("  0. Salir");
            String seleccion="";
            boolean seleccionsiregistro = false;
            if (!seleccionsiregistro){
                seleccion = input.readLine();
            }
            if (seleccion.equals("1") || seleccionsiregistro) {
                System.out.print("Ingrese correo electrónico o documento: ");
                String ingreso = input.readLine();
                boolean encontrado = false;
                try {
                    int documento = Integer.parseInt(ingreso);
                    int index = -1;
                    for (int indice=0;indice<Usuarios.size();indice++){
                        if (Usuarios.get(indice).Documento==documento){
                            encontrado = true;
                            index=indice;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("Usuario con documento: \""+documento+"\" no econtrado");
                    }
                    else {
                        System.out.print("Ingrese contraseña: ");
                        String contraseña = input.readLine();
                        if (Usuarios.get(index).Contraseña.equals("contraseña")){
                            System.out.println("Bienvenido al sistema de gestión en modelado estadístico\n");
                            acceso=true;
                            seleccionsiregistro=false;
                        }
                        else{
                            System.out.println("Contraseña incorrecta");
                        }
                    }
                } catch (Exception exc){
                    int index = -1;
                    for (int indice=0;indice<Usuarios.size();indice++){
                        if (Usuarios.get(indice).Correo.equals("ingreso")){
                            encontrado = true;
                            index = indice;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("Usuario con correo: \""+ingreso+"\" no econtrado");
                    }
                    else {
                        System.out.print("Ingrese contraseña: ");
                        String contraseña = input.readLine();
                        if (Usuarios.get(index).Contraseña.equals("contraseña")){
                            System.out.println("Bienvenido al sistema de gestión en modelado estadístico\n");
                            acceso=true;
                            seleccionsiregistro=false;
                        }
                        else{
                            System.out.println("Contraseña incorrecta");
                        }
                    }
                }
            }
            else if (seleccion.equals("2")){
                int documento = -1;
                boolean documentoexitoso=false;
                boolean cancelarregistro=false;
                while(!documentoexitoso && !cancelarregistro){
                    System.out.print("Ingresar documento: ");
                    String doc = input.readLine();
                    boolean documentovalido = false;
                    try{
                        documento = Integer.parseInt(doc);
                        if(documento<0){
                            System.out.println("Ingrese un documento válido: Valor numérico entero mayor que cero\n");
                        }
                        else{
                            documentovalido=true;
                        }
                    } catch (Exception exc){
                        System.out.println("Ingrese un documento válido: Valor numérico entero mayor que cero\n");
                        System.out.println("¿Cancelar registro?");
                        System.out.println("Y <---> SI");
                        System.out.println("N <---> NO");
                        String cancelar = input.readLine();
                        if (cancelar.equalsIgnoreCase("Y") || cancelar.equalsIgnoreCase("SI")){
                            cancelarregistro=true;
                        }
                    }
                    if (documentovalido){
                        int contador = 0;
                        for(Usuario usuario : Usuarios){
                            if(usuario.Documento==documento){
                                System.out.println("El documento ingresado ya se encuentra regstrado con el correo: \""+usuario.Correo+"\"\n");
                                System.out.println("¿Cancelar registro?");
                                System.out.println("Y <---> SI");
                                System.out.println("N <---> NO");
                                String cancelar = input.readLine();
                                if (cancelar.equalsIgnoreCase("Y") || cancelar.equalsIgnoreCase("SI")){
                                    cancelarregistro=true;
                                }
                                break;
                            }
                            contador++;
                        }
                        if (contador==Usuarios.size()){
                            documentoexitoso=true;
                        }
                    }
                }
                String correo = "";
                boolean correoexitoso = false;
                cancelarregistro = false;
                while(!correoexitoso && !cancelarregistro){
                    System.out.print("Ingresar correo: ");
                    correo = input.readLine();
                    int contador = 0;
                    for(Usuario usuario : Usuarios){
                        if (usuario.Correo.equalsIgnoreCase(correo)){
                            System.out.println("El correo ingresado ya se encuentra registrado con el documento: \""+usuario.Documento+"\"\n");
                            System.out.println("¿Cancelar registro?");
                            System.out.println("Y <---> SI");
                            System.out.println("N <---> NO");
                            String cancelar = input.readLine();
                            if (cancelar.equalsIgnoreCase("Y") || cancelar.equalsIgnoreCase("SI")){
                                cancelarregistro=true;
                            }
                            break;
                        }
                        contador++;
                    }
                    if (contador==Usuarios.size()){
                        correoexitoso=true;
                    }
                }
                System.out.print("Ingresar nombre: ");
                String nombre = input.readLine();
                System.out.print("Ingresar apellido: ");
                String apellido = input.readLine();
                System.out.print("Ingresar contraseña: ");
                String contraseña = input.readLine();
                Usuario nuevousuario = new Usuario(documento,correo,nombre,apellido,contraseña);
                Usuarios.add(nuevousuario);
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Writer writer = Files.newBufferedWriter(Paths.get("Usuarios.json"));
                    gson.toJson(Usuarios, writer);
                    System.out.println("El nuevo usuario se ha registrado satisfactoriamente");
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Por favor, ingrese sus datos para acceder al sistema");
                seleccionsiregistro=true;
            }
            else if(seleccion.equals("0")){
                break;
                // falta relacionarlo con el menu
            }
            else{
                System.out.println("Por favor, ingrese una opción válida: \"1\", \"2\" o \"0\"");
            }
        }


        /*boolean condicion = true;
        while(condicion){
            System.out.println("1. Administración.");
            System.out.println("2. Búsqueda.");
            System.out.println("3. Diagnóstico de inconsistencias.");
            System.out.println("4. Guardar.");
            System.out.println("0. Salir");
            String opcion = input.readLine();
            if (opcion.equals("1")){
                Administracion.administrar(experimentos,muestras,modelos,informes,distribucionesapriori,distribucionposterior,descriptivas,inferenciales,IDs);
            }else if(opcion.equals("2")){

            }else if(opcion.equals("3")){

            }else if(opcion.equals("4")){

            }else if(opcion.equals("0")){
                while(true){
                    System.out.println("Al seleccionar esta opcion se perderan los cambios si no ha guardado");
                    System.out.println("Y. Salir del programa");
                    System.out.println("N. Permanecer en el programa");
                    opcion = input.readLine();
                    if (opcion.equals("Y")){
                        condicion = false;
                        break;
                    }else if (opcion.equals("N")){
                        break;
                    }else{
                        System.out.println("Por favor, inregese 'Y' o 'N' para continuar");
                    }
                }
            }
        }*/
    }

    /*public static void Ingresar(){
        System.out.println("Ingrese por favor su correo o contraseña");
    }
    public static void DistribucionAPriori(){
        
    }*/
    public static void CargarDatos(){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("Usuarios.json"));
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) Arrays.asList(gson.fromJson(reader, Usuario[].class));
            Usuarios = usuarios;
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}