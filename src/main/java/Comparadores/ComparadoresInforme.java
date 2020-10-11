/*package Comparadores;
import Clases.Informe;

import java.util.Comparator;

public class ComparadoresInforme {

    public static class ComparadorNumInforme implements Comparator<Informe> {
        @Override
        public int compare(Informe informe1, Informe informe2) {
            if (informe1.IDPrueba < informe2.IDPrueba) {
                return -1;
            } else if (informe1.IDPrueba == informe2.IDPrueba) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorComentariosInforme implements Comparator<Informe> {
        @Override
        public int compare(Informe informe1, Informe informe2) {
            if (informe1.Comentarios.toLowerCase().compareTo(informe2.Comentarios.toLowerCase()) < 0) {
                return -1;
            } else if (informe1.Comentarios.equalsIgnoreCase(informe2.Comentarios)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorTemperaturaInforme implements Comparator<Informe> {
        @Override
        public int compare(Informe informe1, Informe informe2) {
            if (informe1.Temperatura < informe2.Temperatura) {
                return -1;
            } else if (informe1.Temperatura == informe2.Temperatura) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorHumedadInforme implements Comparator<Informe> {
        @Override
        public int compare(Informe informe1, Informe informe2) {
            if (informe1.Humedad < informe2.Humedad) {
                return -1;
            } else if (informe1.Humedad == informe2.Humedad) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class ComparadorPresionInforme implements Comparator<Informe> {
        @Override
        public int compare(Informe informe1, Informe informe2) {
            if (informe1.Presion < informe2.Presion) {
                return -1;
            } else if (informe1.Presion == informe2.Presion) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
*/