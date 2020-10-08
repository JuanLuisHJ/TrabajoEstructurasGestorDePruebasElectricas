import Clases.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class Main {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Usuario> Usuarios = new ArrayList<>();
    public static ArrayList<Laboratorio> laboratorios = new ArrayList<>();
    public static ArrayList<TipoPrueba> tipopruebas = new ArrayList<>();
    public static ArrayList<Prueba> pruebas = new ArrayList<>();
    public static ArrayList<Informe> informes = new ArrayList<>();
    public static ArrayList<Dispositivo> dispositivos = new ArrayList<>();
    public static ArrayList<Norma> normas = new ArrayList<>();
    public static ArrayList<Clase> clases = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        CargarDatos();
        boolean acceso = false;
        boolean seleccionsiregistro = false;
        while (!acceso) {
            String seleccion = "";
            if (!seleccionsiregistro) {
                System.out.println("Sistema de gestión de pruebas eléctricas:\n");
                System.out.println("  1. Ingresar");
                System.out.println("  2. Registrarse");
                System.out.println("  0. Salir");
                seleccion = input.readLine();
            }
            if (seleccion.equals("1") || seleccionsiregistro) {
                if (seleccionsiregistro) {
                    seleccionsiregistro = false;
                }
                System.out.print("Ingrese correo electrónico o documento: ");
                String ingreso = input.readLine();
                boolean encontrado = false;
                try {
                    int documento = Integer.parseInt(ingreso);
                    int index = -1;
                    for (int indice = 0; indice < Usuarios.size(); indice++) {
                        if (Usuarios.get(indice).Documento == documento) {
                            encontrado = true;
                            index = indice;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Clases.Usuario con documento: \"" + documento + "\" no econtrado\n");
                    } else {
                        System.out.print("Ingrese contraseña: ");
                        String contraseña = input.readLine();
                        if (Usuarios.get(index).Contraseña.equals(contraseña)) {
                            System.out.println("¡Hola! "+Usuarios.get(index).Nombre+", Bienvenido al sistema de gestión de pruebas eléctricas\n");
                            acceso = true;
                        } else {
                            System.out.println("Contraseña incorrecta\n");
                        }
                    }
                } catch (Exception exc) {
                    int index = -1;
                    for (int indice = 0; indice < Usuarios.size(); indice++) {
                        if (Usuarios.get(indice).Correo.equals(ingreso)) {
                            encontrado = true;
                            index = indice;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Clases.Usuario con correo: \"" + ingreso + "\" no econtrado\n");
                    } else {
                        System.out.print("Ingrese contraseña: ");
                        String contraseña = input.readLine();

                        if (Usuarios.get(index).Contraseña.equals(contraseña)) {
                            System.out.println("¡Hola! "+Usuarios.get(index).Nombre+", Bienvenido al sistema de gestión de pruebas eléctricas\n");
                            acceso = true;
                        } else {
                            System.out.println("Contraseña incorrecta");
                        }
                    }
                }
            } else if (seleccion.equals("2")) {
                int documento = -1;
                boolean documentovalido = false;
                boolean cancelarregistro = false;
                boolean documentoadmitido = false;
                while (!documentoadmitido && !cancelarregistro) {
                    System.out.print("Ingresar documento: ");
                    String doc = input.readLine();
                    try {
                        documento = Integer.parseInt(doc);
                        if (documento < 0) {
                            System.out.println("Ingrese un documento válido: Valor numérico entero mayor que cero\n");
                            documentovalido = false;
                        } else {
                            documentovalido = true;
                        }
                    } catch (Exception exc) {
                        System.out.println("Ingrese un documento válido: Valor numérico entero mayor que cero\n");
                        cancelarregistro=CancelarRegistro();
                    }
                    if (documentovalido) {
                        int contador = 0;
                        for (Usuario usuario : Usuarios) {
                            if (usuario.Documento == documento) {
                                System.out.println("El documento ingresado ya se encuentra regstrado con el correo: \"" + usuario.Correo + "\"\n");
                                System.out.println("¿Cancelar registro?");
                                System.out.println("Y <---> SI");
                                System.out.println("N <---> NO");
                                String cancelar = input.readLine();
                                if (cancelar.equalsIgnoreCase("y") || cancelar.equalsIgnoreCase("si")) {
                                    cancelarregistro = true;
                                }
                                break;
                            }
                            contador++;
                        }
                        if (contador == Usuarios.size()) {
                            documentoadmitido = true;
                        }
                    }
                }
                if (cancelarregistro) {
                    continue;
                }
                String correo = "";
                boolean correoexitoso = false;
                cancelarregistro = false;
                while (!correoexitoso && !cancelarregistro) {
                    System.out.print("Ingresar correo: ");
                    correo = input.readLine();
                    int contador = 0;
                    for (Usuario usuario : Usuarios) {
                        if (usuario.Correo.equalsIgnoreCase(correo)) {
                            System.out.println("El correo ingresado ya se encuentra registrado con el documento: \"" + usuario.Documento + "\"\n");
                            cancelarregistro=CancelarRegistro();
                            break;
                        }
                        contador++;
                    }
                    if (contador == Usuarios.size()) {
                        correoexitoso = true;
                    }
                }
                if (cancelarregistro) {
                    continue;
                }
                System.out.print("Ingresar nombre: ");
                String nombre = input.readLine();
                System.out.print("Ingresar apellido: ");
                String apellido = input.readLine();
                System.out.print("Ingresar contraseña: ");
                String contraseña = input.readLine();
                Usuario nuevousuario = new Usuario(documento, correo, nombre, apellido, contraseña);
                Usuarios.add(nuevousuario);
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Writer writer = Files.newBufferedWriter(Paths.get("Usuarios.json"));
                    gson.toJson(Usuarios, writer);
                    System.out.println("El nuevo usuario se ha registrado satisfactoriamente\n");
                    System.out.println("Usuarios registrados: \n");
                    for (Usuario usuario : Usuarios) {
                        System.out.println(usuario);
                    }
                    System.out.println();
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Por favor, ingrese sus datos para acceder al sistema\n");
                seleccionsiregistro = true;
            } else if (seleccion.equals("0")) {
                break;
            } else {
                System.out.println("Por favor, ingrese una opción válida: \"1\", \"2\" o \"0\"");
            }
            while(acceso){
                System.out.println("1. Administración.");
                System.out.println("2. Búsqueda.");
                System.out.println("3. Diagnóstico de inconsistencias.");
                System.out.println("4. Guardar.");
                System.out.println("0. Salir");
                String opcion = input.readLine();
                if (opcion.equals("1")){
                    Administracion.administrar();
                }else if(opcion.equals("2")){
                    Administracion.busqueda();
                }else if(opcion.equals("3")){

                }else if(opcion.equals("4")){
                    GuardarDatos();
                    System.out.println("Los datos se guardaron satisfactoriamente\n");
                }else if(opcion.equals("0")){
                    while(true){
                        System.out.println("Al seleccionar esta opcion se perderan los cambios si no ha guardado");
                        System.out.println("Y. Salir del programa");
                        System.out.println("N. Permanecer en el programa");
                        opcion = input.readLine();
                        if (opcion.equalsIgnoreCase("y")){
                            acceso = false;
                            break;
                        }else if (opcion.equalsIgnoreCase("n")){
                            break;
                        }else{
                            System.out.println("Por favor, inregese 'Y' o 'N' para continuar");
                        }
                    }
                }
            }
        }
    }
    public static void CargarDatos(){
        try {
            Gson gson = new Gson();

            Reader readerUsuarios = Files.newBufferedReader(Paths.get("Usuarios.json"));
            ArrayList<Usuario> usuarios = new ArrayList<> (Arrays.asList(gson.fromJson(readerUsuarios, Usuario[].class)));
            Usuarios = usuarios;
            readerUsuarios.close();

            Reader readerLaboratorios = Files.newBufferedReader(Paths.get("Laboratorios.json"));
            ArrayList<Laboratorio> Laboratorios = new ArrayList<> (Arrays.asList(gson.fromJson(readerLaboratorios, Laboratorio[].class)));
            laboratorios = Laboratorios;
            readerLaboratorios.close();

            Reader readerTipoPruebas = Files.newBufferedReader(Paths.get("TipoPruebas.json"));
            ArrayList<TipoPrueba> TipoPruebas = new ArrayList<> (Arrays.asList(gson.fromJson(readerTipoPruebas, TipoPrueba[].class)));
            tipopruebas = TipoPruebas;
            readerTipoPruebas.close();

            Reader readerPruebas = Files.newBufferedReader(Paths.get("Pruebas.json"));
            ArrayList<Prueba> Pruebas = new ArrayList<> (Arrays.asList(gson.fromJson(readerPruebas, Prueba[].class)));
            pruebas = Pruebas;
            readerPruebas.close();

            Reader readerInformes = Files.newBufferedReader(Paths.get("Informes.json"));
            ArrayList<Informe> Informes = new ArrayList<> (Arrays.asList(gson.fromJson(readerInformes, Informe[].class)));
            informes = Informes;
            readerInformes.close();

            Reader readerDispositivos = Files.newBufferedReader(Paths.get("Dispositivos.json"));
            ArrayList<Dispositivo> Dispositivos = new ArrayList<> (Arrays.asList(gson.fromJson(readerDispositivos, Dispositivo[].class)));
            dispositivos = Dispositivos;
            readerDispositivos.close();

            Reader readerNormas = Files.newBufferedReader(Paths.get("Normas.json"));
            ArrayList<Norma> Normas = new ArrayList<> (Arrays.asList(gson.fromJson(readerNormas, Norma[].class)));
            normas = Normas;
            readerNormas.close();

            Reader readerClases = Files.newBufferedReader(Paths.get("Clases.json"));
            ArrayList<Clase> Clases = new ArrayList<> (Arrays.asList(gson.fromJson(readerClases, Clase[].class)));
            clases = Clases;
            readerClases.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void GuardarDatos(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Writer writerLaboratorios = Files.newBufferedWriter(Paths.get("Laboratorios.json"));
            gson.toJson(Main.laboratorios, writerLaboratorios);
            writerLaboratorios.close();

            Writer writerTipoPruebas = Files.newBufferedWriter(Paths.get("TipoPruebas.json"));
            gson.toJson(Main.tipopruebas, writerTipoPruebas);
            writerTipoPruebas.close();

            Writer writerPruebas = Files.newBufferedWriter(Paths.get("Pruebas.json"));
            gson.toJson(Main.pruebas, writerPruebas);
            writerPruebas.close();

            Writer writerInformes = Files.newBufferedWriter(Paths.get("Informes.json"));
            gson.toJson(Main.informes, writerInformes);
            writerInformes.close();

            Writer writerDispositivos = Files.newBufferedWriter(Paths.get("Dispositivos.json"));
            gson.toJson(Main.dispositivos, writerDispositivos);
            writerDispositivos.close();

            Writer writerNormas = Files.newBufferedWriter(Paths.get("Normas.json"));
            gson.toJson(Main.normas, writerNormas);
            writerNormas.close();

            Writer writerClases = Files.newBufferedWriter(Paths.get("Clases.json"));
            gson.toJson(Main.clases, writerClases);
            writerClases.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void BorrarDatos(String nombreDeArchivoJsonConExtension){
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(nombreDeArchivoJsonConExtension));
            gson.toJson(usuarios, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static boolean CancelarRegistro() throws IOException{
        while(true){
            System.out.println("¿Cancelar registro?");
            System.out.println("Y <---> SI");
            System.out.println("N <---> NO");
            String cancelar = input.readLine();
            if (cancelar.equalsIgnoreCase("y") || cancelar.equalsIgnoreCase("si")) {
                return true;
            }
            else if (cancelar.equalsIgnoreCase("n") || cancelar.equalsIgnoreCase("no")){
                return false;
            }
            else {
                System.out.println("Debe ingresar una opción: \"si\",\"y\" o \"no\",\"n\"");
            }
        }
    }
}