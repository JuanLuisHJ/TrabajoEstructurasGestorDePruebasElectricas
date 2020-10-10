import Clases.Dispositivo;

import java.io.*;

public class Administracion {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void administrar() throws IOException {
        while (true) {
            System.out.println("1. Laboratorios.");
            System.out.println("2. Tipos de Prueba.");
            System.out.println("3. Pruebas.");
            System.out.println("4. Informes.");
            System.out.println("5. Dispositivos.");
            System.out.println("6. Normas.");
            System.out.println("7. Clases.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                MenuLaboratorio.munuLaboratorio();
                return;
            } else if (opcionA.equals("2")) {
                MenuTipoPrueba.munuTipoPrueba();
                return;
            } else if (opcionA.equals("3")) {
                MenuPrueba.munuPrueba();
                return;
            } else if (opcionA.equals("4")) {
                MenuInforme.MenuInforme();
                return;
            } else if (opcionA.equals("5")) {
                MenuDispositivo.MenuDispositivo();
                return;
            } else if (opcionA.equals("6")) {
                MenuNorma.MenuNorma();
                return;
            } else if (opcionA.equals("7")) {
                MenuClase.MenuClase();
                return;
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }
    public static void busqueda() throws IOException {
        while (true) {
            System.out.println("1. Laboratorios.");
            System.out.println("2. Tipos de Prueba.");
            System.out.println("3. Pruebas.");
            System.out.println("4. Informes.");
            System.out.println("5. Dispositivos.");
            System.out.println("6. Normas.");
            System.out.println("7. Clases.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                MenuBusquedaLaboratorio.menubusquedaLaboratorio();
                return;
            } else if (opcionA.equals("2")) {

            } else if (opcionA.equals("3")) {

            } else if (opcionA.equals("4")) {

            } else if (opcionA.equals("5")) {

            } else if (opcionA.equals("6")) {

            } else if (opcionA.equals("7")) {
                
            }else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son válidos\n");
            }
        }
    }
}

