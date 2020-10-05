import java.util.*;
import java.io.*;

public class Administracion {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void administrar(ArrayList<Experimento> experimentos, ArrayList<Muestra> muestras, ArrayList<Modelo> modelos, ArrayList<Informe> informes, ArrayList<Priori> distribucionesapriori, ArrayList<Posterior> distribucionposterior, ArrayList<Descriptiva> descriptivas, ArrayList<Inferencial> inferenciales, int[] IDs) throws IOException {
        while (true) {
            System.out.println("1. Experimento.");
            System.out.println("2. Muestra.");
            System.out.println("3. Modelo.");
            System.out.println("4. Informe.");
            System.out.println("5. Distribución a-priori.");
            System.out.println("6. Distribución posterior.");
            System.out.println("7. Descriptiva.");
            System.out.println("8. Inferencial.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                admiExperimentos(experimentos);
                return;
            } else if (opcionA.equals("2")) {

            } else if (opcionA.equals("3")) {

            } else if (opcionA.equals("4")) {

            } else if (opcionA.equals("5")) {

            } else if (opcionA.equals("6")) {

            } else if (opcionA.equals("7")) {
                admiDescriptiva(descriptivas);
                return;
            } else if (opcionA.equals("8")) {

            } else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("Los datos ingresados no son validos");
            }
        }
    }

    public static void admiExperimentos(ArrayList<Experimento> experimentos) throws IOException {
        while (true) {
            System.out.println("1. Ver Experimento.");
            System.out.println("2. Crear Experimento.");
            System.out.println("3. Editar Experimento.");
            System.out.println("4. Eliminar Experimento.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                for (Experimento experimento : experimentos) {
                    System.out.println(experimento);
                }
            } else if (opcionA.equals("2")) {

            } else if (opcionA.equals("3")) {

            } else if (opcionA.equals("4")) {

            } else if (opcionA.equals("0")) {
                return;
            } else {
                System.out.println("La opción ingresada no es válida");
            }
        }
    }

    public static void admiDescriptiva(ArrayList<Descriptiva> descriptivas) throws IOException {
        while (true) {
            System.out.println("1. Ver Descriptiva.");
            System.out.println("2. Crear Descriptiva.");
            System.out.println("3. Editar Descriptiva.");
            System.out.println("4. Eliminar Descriptiva.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                for (Descriptiva descriptiva : descriptivas) {
                    System.out.println(descriptiva);
                }
            } else if (opcionA.equals("2")) {
                System.out.println("Para crear una descriptiva, por favor ingrese en orden los datos solicitados:");
                System.out.println("Ingrese el ID unico de la muestra a la cual pertenece la desciptiva");
                int id = input.read();
                for (Muestra muestra : Main.muestras) {
                    if (muestra.ID != id) {
                        System.out.println("La muestra solicitada no existe en la base de datos.");
                        return;
                    }
                }
                System.out.println("Ingrese la centralidad y la dispersión de la muestra. ");
                System.out.println("Ingrese la centralidad: ");
                String centralidad = input.readLine();
                System.out.println("Ingrese la dispersión: ");
                String dispersion = input.readLine();
                String[] Centralidad_Dispersion = new String[2];
                Centralidad_Dispersion[0] = centralidad;
                Centralidad_Dispersion[1] = dispersion;
                System.out.println("Ingrese los gráficos usados en la descriptiva. ");
                System.out.println("Ingrese la cantidad de gráficos usados: ");
                int cangraf = input.read();
                String[] graficos = new String[cangraf];
                for (int i = 0; i < graficos.length; i++) {
                    System.out.println("Ingrese el nombre del gráfico usado: ");
                    String grafic = input.readLine();
                    graficos[i] = grafic;
                }
                int iduk = Main.IDs[6];
                for (Descriptiva descriptiva : Main.descriptivas) {
                    if (descriptiva.ID == iduk) {
                        iduk += 1;
                    }
                }
                Descriptiva descriptiva = new Descriptiva(iduk, id, Centralidad_Dispersion, graficos);
                Main.descriptivas.add(descriptiva);
                for (Muestra muestra : Main.muestras) {
                    if (muestra.ID == id) {
                        muestra.Descriptiva = descriptiva.ID;
                    }
                }

            } else if (opcionA.equals("3")) {
                if (Main.descriptivas.isEmpty()) {
                    System.out.println("No hay descriptivas guardadas en la base de datos. ");
                } else {
                    System.out.println("Para editar una descriptiva, por favor ingrese el ID único de la misma: ");
                    int id = input.read();
                    Descriptiva descriptiva = null;
                    for (int i = 0; i < Main.descriptivas.size(); i++) {
                        if (Main.descriptivas.get(i).ID != id) {
                            System.out.println("La descriptiva solicitada no existe en la base de datos.");
                            return;
                        } else {
                            descriptiva = Main.descriptivas.get(i);
                            break;
                        }
                    }
                    System.out.println("El ID único de la descriptiva seleccionado es: " + descriptiva.ID);
                    System.out.println("¿Desea modificar este valor? (Y/N) ");
                    String opcionid = input.readLine();
                    if (opcionid.equals("Y")) {
                        System.out.println("Ingrese el nuevo ID único para la descriptiva: ");
                        int id1 = input.read();
                        for (int i = 0; i < Main.descriptivas.size(); i++) {
                            if (Main.descriptivas.get(i).ID == id1) {
                                System.out.println("Este ID único ya está asignado a otra descriptiva.");
                                return;
                            } else {
                                Main.descriptivas.get(i).ID = id1;
                                System.out.println("Operación realizada con exito.");
                            }
                        }
                    }
                    System.out.println("El ID único de la muestra a la que pertenece esta descriptiva es: " + descriptiva.Muestra);
                    System.out.println("¿Desea modificar este valor? (Y/N) ");
                    String opcionidm = input.readLine();
                    if (opcionidm.equals("Y")) {
                        System.out.println("Ingrese el ID de la nueva muestra a la cual desea asociar esta descriptiva. ");
                        int id2 = input.read();
                        for (int i = 0; i < Main.muestras.size(); i++) {
                            if (Main.muestras.get(i).ID != id2) {
                                System.out.println("La muestra seleccionada no existe en la base de datos. ");
                            } else {
                                descriptiva.Muestra = id2;
                                System.out.println("Operacion realizada con exito. ");
                            }
                        }
                    }
                    System.out.println("La centralidad y dispersión de la descriptiva son los siguientes: " + Arrays.toString(descriptiva.Centralidad_Dispersion));
                    System.out.println("¿Desea modificar la centralidad? (Y/N) ");
                    String opcionc = input.readLine();
                    if (opcionc.equals("Y")) {
                        System.out.println("Ingrese la nueva centralidad de la descriptiva: ");
                        String centra = input.readLine();
                        descriptiva.Centralidad_Dispersion[0] = centra;
                        System.out.println("Ingrese la nueva dispersion de la descriptiva: ");
                        String dispe = input.readLine();
                        descriptiva.Centralidad_Dispersion[1] = dispe;
                        System.out.println("Operacion realizada con exito. ");
                    }
                    System.out.println("Los graficos de la descriptiva son los siguientes: " + Arrays.toString(descriptiva.Graficos));
                    System.out.println("¿Desea modificar los graficos de la descriptiva? (Y/N) ");
                    String opciong = input.readLine();
                    if (opciong.equals("Y")) {
                        System.out.println("Ingrese la nueva cantidad de graficos: ");
                        int canti = input.read();
                        String[] grafics = new String[canti];
                        for (int i = 0; i < grafics.length; i++) {
                            System.out.println("Ingrese el nombre del gráfico usado: ");
                            String grafic = input.readLine();
                            grafics[i] = grafic;
                        }
                        descriptiva.Graficos = grafics;
                        System.out.println("Operacion realizada con exito. ");
                    }
                }
            } else if (opcionA.equals("4")) {
                System.out.println("Para eliminar una descriptiva ingrese el valor ID único: ");
                int id = input.read();
                for (int i = 0; i < Main.descriptivas.size(); i++) {
                    if (Main.descriptivas.get(i).ID != id) {
                        System.out.println("La descriptiva seleccionada no existe en la base de datos. ");
                        return;
                    } else {
                        System.out.println("Esta a punto de eliminar la descriptiva con ID: " + Main.descriptivas.get(i).ID);
                        System.out.println("¿Aprueba la operación? (Y/N) ");
                        String opcion = input.readLine();
                        if (opcion.equals("Y")) {
                            Main.descriptivas.remove(i);
                            System.out.println("Operacion realizada con exito. ");
                        } else if (opcion.equals("N")) {
                            return;
                        } else {
                            break;
                        }
                    }
                }

            } else if (opcionA.equals("0")) {
                break;
            } else {
                System.out.println("La opción ingresada no es válida");
            }
        }
    }
}

