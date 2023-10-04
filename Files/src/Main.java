import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        File fichero =  new File("ficheros");
        fichero.mkdir();
        fichero = new File("pruebas");
        fichero.mkdir();
        File archivo = new File("ficheros/archivo");
        archivo.createNewFile();
        //Files.copy(Path.of("ficheros/archivo"),Path.of("pruebas/archivo1"));
        Files.move(Path.of("ficheros/archivo"),Path.of("pruebas/archivo"));

    }
}