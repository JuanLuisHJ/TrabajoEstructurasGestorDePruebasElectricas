public class ElementoPrueba {
    public int ID;
    public String Nombre;
    public int Prueba;
    public int Informe;
    public int Clase;

    public ElementoPrueba(int ID, String nombre, int prueba, int informe, int clase) {
        this.ID = ID;
        Nombre = nombre;
        Prueba = prueba;
        Informe = informe;
        Clase = clase;
    }

    @Override
    public String toString() {
        return "ElementoPrueba{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Prueba=" + Prueba +
                ", Informe=" + Informe +
                ", Clase=" + Clase +
                '}';
    }
}
