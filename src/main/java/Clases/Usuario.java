package Clases;

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
        String print = "---------------------------------------------";
        print += "Usuario:    " + "\n";
        print += "Documento:  " + Documento + "." + "\n";
        print += "Nombre:     " + Nombre + "." + "\n";
        print += "Apellido:   " + Apellido + "." + "\n";
        print += "Contraseña: " + Contraseña + "." + "\n";
        print += "---------------------------------------------";
        return print;
    }
}