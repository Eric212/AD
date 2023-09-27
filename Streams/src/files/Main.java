package files;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File ficheros = new File("ficheros");
        if(!ficheros.exists()) {
            ficheros.mkdir();
        }else {
            System.err.println("El directorio ya existe");
        }
        File file = new File(ficheros.getPath(),"caracteres.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        }catch (IOException ex){
            System.err.println("Error de apertura en el fichero"+file.getName());
        }
        try {
            fileWriter.write("Esto es un texto de prueba");
        }catch (IOException ex){
            System.err.println("Error de escritura sobre el fichero"+file.getName());
        }
        try{
            fileWriter.close();
        }catch (IOException ex){
            System.err.println("Error al guardar las modificaciones en el fichero"+file.getName());
        }

        try{
            FileReader fileReader = new FileReader(file);
            int read;
            while ((read=fileReader.read())!=-1){
                System.out.print((char)read);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo"+file.getName());
        }
    }
}