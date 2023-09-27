package Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mainPath {
    public static void main(String[] args) {
        Path camino = Path.of("ficheros");
        System.out.println(camino.toAbsolutePath());
        System.out.println(camino);
        System.out.println("AHORA VAMOS A LISTAR UN DIRECTORIO");
        listarficheros(camino);
    }

    public static void listarficheros(Path camino) {
        try{
            Stream<Path> stream = Files.list(camino);
            ArrayList<Path> lista = (ArrayList<Path>) stream.collect(Collectors.toList());
            for (Path path : lista) {
                if (path.toFile().isDirectory()) {
                    listarficheros(Path.of(path.toString()));
                }
                System.out.println(path);
            }
        }catch (IOException ex){
            System.err.println("No se ha podido listar");
            System.err.println("Error" + ex.getMessage());
            System.exit(-1);
        }
    }
}
