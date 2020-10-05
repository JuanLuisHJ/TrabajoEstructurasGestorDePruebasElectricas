public class Usuario {
    public int Documento;
    public String Correo;
    public String Nombre;
    public String Apellido;
    public String Contraseña;


    public Usuario(int Documento, String Correo, String Nombre, String Apellido, String Contraseña) {
        this.Documento = Documento;
        this.Correo = Correo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Contraseña = Contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Documento=" + Documento +
                ", Correo='" + Correo + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }
}