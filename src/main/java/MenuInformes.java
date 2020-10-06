import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuInformes {
    public static BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    public static void CRUDinforme() throws IOException {

        System.out.println("1. Ver informes");
        System.out.println("2. Crear Informe");
        System.out.println("3. Editar informe");
        System.out.println("4. Eliminar informe");
        System.out.println("0. Volver");
        String seleccion = input.readLine();
        if (seleccion.equals("1")){
            if (Main.Informes.size()==0){
                System.out.println("No hay informes registrados todavía");
            }
            else{
                for (Clases.Informe informe : Main.Informes){
                    System.out.println(informe);
                }
            }
        }
        else if (seleccion.equals("2")){
            System.out.print("Ingrese el identificador (ID) de la prueba a la cual desea generar el informe:");
            String ingreso = input.readLine();
            int identificador;
            boolean identificadoraprobado=false;
            boolean cancelarregistro=false;
            while (!cancelarregistro && !identificadoraprobado){
                try{
                    identificador=Integer.parseInt(ingreso);
                    if(identificador<0){
                        System.out.println("Ingrese un identificador numérico mayor que cero\n");
                        identificadoraprobado=false;
                    }
                }catch (Exception exc){
                    System.out.println("Ingrese un identificador numérico mayor que cero\n");
                    cancelarregistro=Main.CancelarRegistro();
                    System.out.println("Las pruebas sin registro son: ");
                    for(Clases.Prueba prueba : Main.Pruebas)
                }
            }

        }

    }
}
