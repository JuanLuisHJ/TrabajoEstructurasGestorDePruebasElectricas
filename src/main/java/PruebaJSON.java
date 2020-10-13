//   FUENTE :   https://attacomsian.com/blog/gson-read-write-json

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PruebaJSON{
    public static void main(String[] args){

        // ESTO CONVIERTE JAVA A JSON
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel"});

            // convert book object to JSON
            String json = new Gson().toJson(book);

            System.out.println("Esto es Java convertido a Json");
            // print JSON string
            System.out.println(json);
            System.out.println();


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // ESTO ESCRIBE JAVA A UN ARCHIVO JSON
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel"});

            // create Gson instance
            Gson gson = new Gson();

            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("book.json"));

            // convert book object to JSON file
            gson.toJson(book, writer);

            // close writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //ESTO ESCRIBE UN JSON BONITO. RESPECTO AL ANTERIOR SOLO CAMBIA LA INSTACIA DE GSON
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel"});


            // create Gson instance with pretty-print
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("book.json"));

            // convert book object to JSON file
            gson.toJson(book, writer);
            System.out.println("Buscar el archivo generado llamado \"book.json\"");
            System.out.println();

            // close writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ESTO CONVIERTE LISTA JAVA A ARREGLO JSON Y LO ESCRIBE EN ARCHIVO
        try {
            // create books list
            List<Book> books = Arrays.asList(
                    new Book("Thinking in Java", "978-0131872486", 1998,
                            new String[]{"Bruce Eckel"}),
                    new Book("Head First Java", "0596009208", 2003,
                            new String[]{"Kathy Sierra", "Bert Bates"})
            );

            // create Gson instance
            //Gson gson = new Gson();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get("books.json"));

            // convert books object to JSON file
            gson.toJson(books, writer);
            System.out.println("Buscar el archivo generado llamado \"books.json\"");
            System.out.println();

            // close writer
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // LO SIGUIENTE ES EL PROCESO INVERSO

        // ESTO CONVIERTE UN STRING DE JSON A OBJETO JAVA
        try {
            // JSON string
            String json = "{\"title\":\"Thinking in Java\",\"isbn\":\"978-0131872486\"" +
                    ",\"year\":1998,\"authors\":[\"Bruce Eckel\"]}";

            // create Gson instance
            Gson gson = new Gson();

            // convert JSON string to Book object
            Book book = gson.fromJson(json, Book.class);


            System.out.println("Esto es un objeto java convertido desde un string de json");
            // print book
            System.out.println(book);
            System.out.println();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ESTO CNVIERTE UN ARCHIVO JSON DE UN ELEMNTO A UN OBJETO DE JAVA
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("book.json"));

            // convert JSON string to Book object
            Book book = gson.fromJson(reader, Book.class);


            System.out.println("Esto es uno bjeto java convertido dede un archivo json con un elemento");
            // print book
            System.out.println(book);
            System.out.println();

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ESTO CONVIERTE UN ARREGLO DE ELEMNTOS JSON A UNA LISTA DE OBJETOS JAVA
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("books.json"));

            // convert JSON array to list of books
            List<Book> books = Arrays.asList(gson.fromJson(reader, Book[].class));


            System.out.println("Esto es una lista de objetos java convertidos desde un archivo json con dos elementos");
            // print books
            books.forEach(System.out::println);
            System.out.println();

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}