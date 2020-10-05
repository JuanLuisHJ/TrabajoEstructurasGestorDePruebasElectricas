public class Dispositivo {
    public int ID;
    public String Nombre;
    public int Zona;
    public int PotenciaNominal;
    public int VoltajeNominal;
    public int CorrienteNominal;

    public Dispositivo(int ID, String nombre, int zona, int potenciaNominal, int voltajeNominal, int corrienteNominal) {
        this.ID = ID;
        Nombre = nombre;
        Zona = zona;
        PotenciaNominal = potenciaNominal;
        VoltajeNominal = voltajeNominal;
        CorrienteNominal = corrienteNominal;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Zona=" + Zona +
                ", PotenciaNominal=" + PotenciaNominal +
                ", VoltajeNominal=" + VoltajeNominal +
                ", CorrienteNominal=" + CorrienteNominal +
                '}';
    }
}
