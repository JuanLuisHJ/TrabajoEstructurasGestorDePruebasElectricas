import Clases.Clase;
import Clases.Norma;
import Clases.Prueba;
import Comparadores.ComparadoresClase.*;

import java.io.*;
import java.util.*;

public class MenuBusquedaClase {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void BusquedaClase () throws IOException {
        ArrayList<Clase> clases = Main.clases;
        while (true) {
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia de norma asociada.");
            System.out.println("3. Voltaje de prueba nominal.");
            System.out.println("4. Corriente de prueba nominal.");
            System.out.println("5. Voltaje de prueba máximo.");
            System.out.println("6. Corriente de prueba máximo. ");
            System.out.println("7. Tiempo de prueba. ");
            System.out.println("8. Mostrar todas las clases.");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                Nombre();
                return;

            } else if (opcionA.equals("2")) {
                ReferenciaNorma();
                return;

            } else if (opcionA.equals("3")) {
                VoltajeNominal();
                return;

            } else if (opcionA.equals("4")) {
                CorrienteNominal();
                return;

            } else if (opcionA.equals("5")) {
                VoltajeMaximo();
                return;
            } else if (opcionA.equals("6")) {
                CorrienteMaxima();
                return;

            } else if (opcionA.equals("7")) {
                Tiempo();
                return;

            } else if (opcionA.equals("8")) {
                OrganizarPorAtributo(clases);
                return;

            } else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }

        }
    }


        public static void Nombre() throws IOException {
            ArrayList<Clase> clases = Main.clases;
            while (true) {
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Valor exacto.");
                System.out.println("2. Valor sin considerar mayusculas. ");
                System.out.println("0. Cancelar. ");
                String opcion = input.readLine();
                if (opcion.equals("1")) {
                    System.out.println("Ingrese el nombre de la clase: ");
                    String nombre = input.readLine();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.Nombre.equalsIgnoreCase(nombre)) {
                            System.out.println(clase);
                            editareliminarUK(clase);
                            System.out.println("Operación realizada con éxito.\n ");
                            clasesquenoson.clear();
                            break;

                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna clase.\n");
                        clasesquenoson.clear();
                        return;
                    }

                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese el nombre de la clase: ");
                    String nombre = input.readLine();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                      if (clase.Nombre.equalsIgnoreCase(nombre)) {
                          System.out.println(clase);
                          editareliminarUK(clase);
                          System.out.println("Operación realizada con éxito.\n ");
                          clasesquenoson.clear();
                          break;

                      } else {
                          clasesquenoson.add(clase);
                      }
                    }
                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El nombre ingresado no se encuentra asignado a ninguna clase.\n");
                        clasesquenoson.clear();
                        return;
                    }

                } else if (opcion.equals("0")) {
                    break;

                } else {
                    System.out.println("La opción ingresada no es válida.\n");

                }
            }
        }

        public static void ReferenciaNorma() throws IOException {
            ArrayList<Clase> clases = Main.clases;
            while (true) {
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Valor exacto.");
                System.out.println("2. Valor sin considerar mayusculas. ");
                System.out.println("0. Cancelar. ");
                String opcion = input.readLine();
                if (opcion.equals("1")) {
                    System.out.println("Ingrese la referencia de la norma asociada: ");
                    String nombre = input.readLine();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.Nombre.equals(nombre)) {
                            System.out.println(clase);
                            editareliminarUK(clase);
                            System.out.println("Operación realizada con éxito.\n ");
                            clasesquenoson.clear();
                            break;

                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                        clasesquenoson.clear();
                        return;
                    }

                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese la referencia de la norma asociada: ");
                    String nombre = input.readLine();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.Nombre.equalsIgnoreCase(nombre)) {
                            System.out.println(clase);
                            editareliminarUK(clase);
                            System.out.println("Operación realizada con éxito.\n ");
                            clasesquenoson.clear();
                            break;

                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("La referencia ingresada no se encuentra asignada a ninguna norma.\n");
                        clasesquenoson.clear();
                        return;
                    }

                } else if (opcion.equals("0")) {
                    break;

                } else {
                    System.out.println("La opción ingresada no es válida.\n");
                }
            }
        }

        public static void VoltajeNominal() throws IOException {
            ArrayList<Clase> clases = Main.clases;
            while (true) {
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Valor exacto. ");
                System.out.println("2. Valor mínimo. ");
                System.out.println("3. Valor máximo. ");
                System.out.println("4. Rango. ");
                System.out.println("0. Cancelar. ");
                String opcion = input.readLine();
                if (opcion.equals("1")) {
                    System.out.println("Ingrese el voltaje de prueba nominal de la clase: ");
                    String volnom = input.readLine();
                    double volnomr = Double.parseDouble(volnom);
                    ArrayList<Clase> clases1 = new ArrayList<>();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.VoltajePrueba == volnomr) {
                            clases1.add(clase);
                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clases1.isEmpty()) {
                        clasesquenoson.clear();
                    }

                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El valor ingresado no ha sido encontrado. ");
                        clasesquenoson.clear();
                        return;
                    }
                    OrganizarPorAtributo(clases1);
                    return;

                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese el valor mínimo del voltaje de prueba nominal de la clase: ");
                    String volnom = input.readLine();
                    double volnomr = Double.parseDouble(volnom);
                    ArrayList<Clase> clases1 = new ArrayList<>();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.VoltajePrueba >= volnomr) {
                            clases1.add(clase);
                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clases1.isEmpty()) {
                        clasesquenoson.clear();
                    }

                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El valor ingresado no ha sido encontrado. ");
                        clasesquenoson.clear();
                        return;
                    }
                    OrganizarPorAtributo(clases1);
                    return;

                } else if (opcion.equals("3")) {
                    System.out.println("Ingrese el valor máximo del voltaje de prueba nominal de la clase: ");
                    String volnom = input.readLine();
                    double volnomr = Double.parseDouble(volnom);
                    ArrayList<Clase> clases1 = new ArrayList<>();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.VoltajePrueba <= volnomr) {
                            clases1.add(clase);
                        }else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clases1.isEmpty()) {
                        clasesquenoson.clear();
                    }

                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El valor ingresado no ha sido encontrado. ");
                        clasesquenoson.clear();
                        return;
                    }
                    OrganizarPorAtributo(clases1);
                    return;

                } else if (opcion.equals("4")) {
                    System.out.println("Ingrese el valor mínimo del rango para voltaje de prueba nominal de la clase: ");
                    String volnommin = input.readLine();
                    double volnomminr = Double.parseDouble(volnommin);
                    System.out.println("Ingrese el valor máximo del rango para voltaje de prueba nominal de la clase: ");
                    String volnommax = input.readLine();
                    double volnommaxr = Double.parseDouble(volnommax);
                    ArrayList<Clase> clases1 = new ArrayList<>();
                    ArrayList<Clase> clasesquenoson = new ArrayList<>();
                    for (Clase clase : clases) {
                        if (clase.VoltajePrueba >= volnomminr && clase.VoltajePrueba <= volnommaxr) {
                            clases1.add(clase);
                        } else {
                            clasesquenoson.add(clase);
                        }
                    }
                    if (!clases1.isEmpty()) {
                        clasesquenoson.clear();
                    }

                    if (!clasesquenoson.isEmpty()) {
                        System.out.println("El valor ingresado no ha sido encontrado. ");
                        clasesquenoson.clear();
                        return;
                    }
                    OrganizarPorAtributo(clases1);
                    return;

                }  else if (opcion.equals("0")) {
                    break;

                } else {
                    System.out.println("La opción ingresada no es válida.\n");
                }
            }
    }

    public static void CorrienteNominal() throws IOException {
        ArrayList<Clase> clases = Main.clases;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la corriente de prueba nominal de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrientePrueba == corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo de la corriente de prueba nominal de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrientePrueba >= corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo de la corriente de prueba nominal de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrientePrueba <= corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango para corriente de prueba nominal de la clase: ");
                String corrnommin = input.readLine();
                double corrnomminr = Double.parseDouble(corrnommin);
                System.out.println("Ingrese el valor máximo del rango para corriente de prueba nominal de la clase: ");
                String corrnommax = input.readLine();
                double corrnommaxr = Double.parseDouble(corrnommax);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrientePrueba >= corrnomminr && clase.CorrientePrueba <= corrnommaxr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void VoltajeMaximo() throws IOException {
        ArrayList<Clase> clases = Main.clases;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el voltaje de prueba máximo de la clase: ");
                String volnom = input.readLine();
                double volnomr = Double.parseDouble(volnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.VoltajeMaximo == volnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo del voltaje de prueba máximo de la clase: ");
                String volnom = input.readLine();
                double volnomr = Double.parseDouble(volnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.VoltajeMaximo >= volnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo del voltaje de prueba máximo de la clase: ");
                String volnom = input.readLine();
                double volnomr = Double.parseDouble(volnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.VoltajeMaximo <= volnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango para voltaje de prueba máximo de la clase: ");
                String volnommin = input.readLine();
                double volnomminr = Double.parseDouble(volnommin);
                System.out.println("Ingrese el valor máximo del rango para voltaje de prueba máximo de la clase: ");
                String volnommax = input.readLine();
                double volnommaxr = Double.parseDouble(volnommax);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.VoltajeMaximo >= volnomminr && clase.VoltajeMaximo <= volnommaxr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void CorrienteMaxima() throws IOException {
        ArrayList<Clase> clases = Main.clases;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese la corriente de prueba máxima de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrienteMaxima == corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo de la corriente de prueba máxima de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrienteMaxima >= corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo de la corriente de prueba máxima de la clase: ");
                String corrnom = input.readLine();
                double corrnomr = Double.parseDouble(corrnom);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrienteMaxima <= corrnomr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango para corriente de prueba máxima de la clase: ");
                String corrnommin = input.readLine();
                double corrnomminr = Double.parseDouble(corrnommin);
                System.out.println("Ingrese el valor máximo del rango para corriente de prueba máxima de la clase: ");
                String corrnommax = input.readLine();
                double corrnommaxr = Double.parseDouble(corrnommax);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.CorrienteMaxima >= corrnomminr && clase.CorrienteMaxima <= corrnommaxr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void Tiempo() throws IOException {
        ArrayList<Clase> clases = Main.clases;
        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Valor exacto. ");
            System.out.println("2. Valor mínimo. ");
            System.out.println("3. Valor máximo. ");
            System.out.println("4. Rango. ");
            System.out.println("0. Cancelar. ");
            String opcion = input.readLine();
            if (opcion.equals("1")) {
                System.out.println("Ingrese el tiempo de prueba de la clase: ");
                String tiempo = input.readLine();
                double tiempor = Double.parseDouble(tiempo);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.Tiempo == tiempor) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("2")) {
                System.out.println("Ingrese el valor mínimo del tiempo de prueba de la clase: ");
                String tiempo = input.readLine();
                double tiempor = Double.parseDouble(tiempo);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.Tiempo >= tiempor) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("3")) {
                System.out.println("Ingrese el valor máximo del tiempo de prueba de la clase: ");
                String tiempo = input.readLine();
                double tiempor = Double.parseDouble(tiempo);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.Tiempo <= tiempor) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            } else if (opcion.equals("4")) {
                System.out.println("Ingrese el valor mínimo del rango para el tiempo de prueba de la clase: ");
                String tiempomin = input.readLine();
                double tiempominnr = Double.parseDouble(tiempomin);
                System.out.println("Ingrese el valor máximo del rango para el tiempo de prueba de la clase: ");
                String tiempomax = input.readLine();
                double tiempomaxr = Double.parseDouble(tiempomax);
                ArrayList<Clase> clases1 = new ArrayList<>();
                ArrayList<Clase> clasesquenoson = new ArrayList<>();
                for (Clase clase : clases) {
                    if (clase.Tiempo >= tiempominnr && clase.Tiempo <= tiempomaxr) {
                        clases1.add(clase);
                    } else {
                        clasesquenoson.add(clase);
                    }
                }
                if (!clases1.isEmpty()) {
                    clasesquenoson.clear();
                }

                if (!clasesquenoson.isEmpty()) {
                    System.out.println("El valor ingresado no ha sido encontrado. ");
                    clasesquenoson.clear();
                    return;
                }
                OrganizarPorAtributo(clases1);
                return;

            }  else if (opcion.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void OrganizarPorAtributo(ArrayList<Clase> clases) throws IOException {
        while(true) {
            System.out.println("Seleccione el atributo por el que desea organizar la lista para impresión. ");
            System.out.println("1. Nombre.");
            System.out.println("2. Referencia norma asociada.");
            System.out.println("3. Voltaje nominal de prueba.");
            System.out.println("4. Corriente nominal de prueba.");
            System.out.println("5. Voltaje máxima de prueba.");
            System.out.println("6. Corriente máxima de prueba. ");
            System.out.println("7. Tiempo. ");
            System.out.println("0. Cancelar");
            String opcionA = input.readLine();
            if (opcionA.equals("1")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorNombreClase());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorNombreClase().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("2")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorNormaClase());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;

                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorNormaClase().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("3")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorVoltajePrueba());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorVoltajePrueba().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("4")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorCorrientePrueba());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorCorrientePrueba().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("5")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorVoltajePruebaMax());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorVoltajePruebaMax().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("6")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorCorrientePruebaMax());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorCorrientePruebaMax().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    }else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            } else if (opcionA.equals("7")) {
                while (true) {
                    System.out.println("Seleccione una opción:\n");
                    System.out.println("1. Organizar ascendente.");
                    System.out.println("2. Organizar descendente. ");
                    System.out.println("0. Cancelar. ");
                    String opc = input.readLine();
                    if (opc.equals("1")) {
                        clases.sort(new ComparadorTiempoPrueba());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("2")) {
                        clases.sort(new ComparadorTiempoPrueba().reversed());
                        for (int i = 0; i < clases.size(); i++) {
                            System.out.println("Indice: " + i + ".\n");
                            System.out.println(clases.get(i));
                        }
                        editareliminarlistas(clases);
                        return;
                    } else if (opc.equals("0")) {
                        break;

                    } else {
                        System.out.println("La opción ingresada no es válida.\n");
                    }
                }

            }else if (opcionA.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }

        }
    }

    public static void editareliminarlistas(ArrayList<Clase> clases) throws IOException {

        while (true) {
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar. ");
            System.out.println("0. Cancelar. ");
            String opc = input.readLine();
            if (opc.equals("1")) {
                System.out.println("Ingrese el indice del elemento que desea modificar: ");
                String indice = input.readLine();
                double indicer = Double.parseDouble(indice);
                if (indicer < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                for (int i = 0; i < clases.size(); i++) {
                    if (indicer == i) {
                        editar(clases.get(i));
                        break;
                    }
                }

            } else if (opc.equals("2")) {
                System.out.println("Ingrese el indice del elemento que desea modificar: ");
                String indice = input.readLine();
                double indicer = Double.parseDouble(indice);
                if (indicer < 0) {
                    System.out.println("No se permiten valores negativos.\n");
                    return;
                }
                for (int i = 0; i < clases.size(); i++) {
                    if (indicer == i) {
                        eliminar(clases.get(i));
                        break;
                    }
                }
            } else if (opc.equals("0")) {
                break;

            } else {
                System.out.println("La opción ingresada no es válida.\n");
            }
        }
    }

    public static void editareliminarUK(Clase clase) throws IOException {

        while (true) {
            System.out.println("Seleccione una opción:\n");
            System.out.println("1. Editar.");
            System.out.println("2. Eliminar. ");
            System.out.println("0. Cancelar. ");
            String opc = input.readLine();
            if (opc.equals("1")) {
                editar(clase);
                return;

            } else if (opc.equals("2")) {
                eliminar(clase);
                return;

            } else if (opc.equals("0")) {
                break;

            }
        }
    }

    public static void editar(Clase clase) throws IOException {
        System.out.println("El nombre de la clase seleccionada es: " + clase.Nombre + ".");
        System.out.println("¿Desea modificar el nombre? (Y/N)");
        String opcionnom = input.readLine();
        if (opcionnom.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevonom = input.readLine();
            if (nuevonom.equals("")) {
                System.out.println("No ingreso el nombre.\n");
            }
            for (Clase clase1 : Main.clases) {
                if (clase1.Nombre.equalsIgnoreCase(nuevonom)) {
                    System.out.println("El nombre ingresado ya se encuentra asignado a otra clase.\n");
                    return;
                }
            }
            for (Norma norma : Main.normas) {
                for (int i = 0; i < norma.Clases.size(); i++) {
                    if (norma.Clases.get(i).equalsIgnoreCase(clase.Nombre)) {
                        norma.Clases.set(i, nuevonom);
                        break;
                    }
                }
            }
            for (Prueba prueba : Main.pruebas) {
                if (prueba.Clase.equalsIgnoreCase(clase.Nombre)) {
                    prueba.Clase = nuevonom;
                }
            }
            clase.Nombre = nuevonom;
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("La referencia de la norma asociada a la clase es: " + clase.Norma + ".");
        System.out.println("¿Desea modificar la referencia de la norma asociada? (Y/N)");
        String opcionnombrenorm = input.readLine();
        if (opcionnombrenorm.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva referencia de la norma asociada: ");
            String nuevonombrenorm = input.readLine();
            if (nuevonombrenorm.equals("")) {
                System.out.println("No ingreso una nueva referencia.\n");
            }
            ArrayList<Norma> normasquenoson = new ArrayList<>();
            for (Norma norma : Main.normas) {
                if (!norma.Referencia.equalsIgnoreCase(nuevonombrenorm)) {
                    normasquenoson.add(norma);
                } else {
                    clase.Norma = nuevonombrenorm;
                    normasquenoson.clear();
                    System.out.println("Operación realizada con éxito.\n");
                    break;
                }
            }
            if (!normasquenoson.isEmpty()) {
                System.out.println("La referencia para la norma asociada no se encuentra guardada en la base de datos.\n ");
                normasquenoson.clear();
                return;
            }
        }
        System.out.println("El voltaje nominal de prueba de la clase seleccionada es: " + clase.VoltajePrueba + " [V].");
        System.out.println("¿Desea modificar el voltaje nominal de prueba de la clase? (Y/N)");
        String opcionvol = input.readLine();
        if (opcionvol.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo voltaje nominal de prueba [V]: ");
            String nuevovol = input.readLine();
            if (nuevovol.equals("")) {
                System.out.println("No ingreso un nuevo voltaje nominal de prueba.\n");
            }
            clase.VoltajePrueba = Double.parseDouble(nuevovol);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("La corriente nominal de prueba de la clase seleccionada es: " + clase.CorrientePrueba + " [A].");
        System.out.println("¿Desea modificar la corriente nominal de prueba de la clase? (Y/N)");
        String opcioncorr = input.readLine();
        if (opcioncorr.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva corriente nominal de prueba [A]: ");
            String nuevocorr = input.readLine();
            if (nuevocorr.equals("")) {
                System.out.println("No ingreso una nueva corriente nominal de prueba.\n");
            }
            clase.CorrientePrueba = Double.parseDouble(nuevocorr);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("El voltaje máximo de prueba de la clase seleccionada es: " + clase.VoltajeMaximo + " [V].");
        System.out.println("¿Desea modificar el voltaje máximo de prueba de la clase? (Y/N)");
        String opcionvolm = input.readLine();
        if (opcionvolm.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo voltaje máximo de prueba [V]: ");
            String nuevovolm = input.readLine();
            if (nuevovolm.equals("")) {
                System.out.println("No ingreso un nuevo voltaje máximo de prueba.\n");
            }
            clase.VoltajeMaximo = Double.parseDouble(nuevovolm);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("La corriente máxima de prueba de la clase seleccionada es: " + clase.CorrienteMaxima + " [A].");
        System.out.println("¿Desea modificar la corriente máxima de prueba de la clase? (Y/N)");
        String opcioncorrm = input.readLine();
        if (opcioncorrm.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese la nueva corriente máxima de prueba [A]: ");
            String nuevocorrm = input.readLine();
            if (nuevocorrm.equals("")) {
                System.out.println("No ingreso una nueva corriente máxima de prueba.\n");
            }
            clase.CorrienteMaxima = Double.parseDouble(nuevocorrm);
            System.out.println("Operación realizada con éxito.\n");
        }
        System.out.println("El tiempo de prueba de la clase seleccionada es: " + clase.Tiempo + " [s].");
        System.out.println("¿Desea modificar el tiempo de prueba de la clase? (Y/N)");
        String opciontiem = input.readLine();
        if (opciontiem.equalsIgnoreCase("Y")) {
            System.out.println("Ingrese el nuevo tiempo de prueba [s]: ");
            String nuevotiem = input.readLine();
            if (nuevotiem.equals("")) {
                System.out.println("No ingreso un nuevo tiempo de prueba.\n");
            }
            clase.Tiempo = Double.parseDouble(nuevotiem);
            System.out.println("Operación realizada con éxito.\n");
        }
    }

    public static void eliminar(Clase clase) {
        for (Norma norma : Main.normas) {
            for (String s : norma.Clases) {
                if (s.equalsIgnoreCase(clase.Nombre)) {
                    norma.Clases.remove(s);
                    break;
                }
            }
        }
        for (Prueba prueba : Main.pruebas) {
            if (prueba.Clase.equalsIgnoreCase(clase.Nombre)) {
                prueba.Clase = null;
            }
        }
        Main.clases.remove(clase);
        System.out.println("Operación realizada con éxito.\n");
    }
}

