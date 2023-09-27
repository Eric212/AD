package randomaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
    public static void main(String[] args) {
        System.out.println("Empezamos con el ACESO Aleatorio");
        File nuwvo = new File("fichero/aleatorio.txt");

        RandomAccessFile aleatoriofile = null;
        try{
            aleatoriofile = new RandomAccessFile(nuwvo,"rw");
        }catch (FileNotFoundException ex){
            System.err.println("Ha habido un problema creando el fichero");
            System.err.println("Error"+ex.getMessage());
            System.exit(-1);
        }
        //escribir();
    }

    /*private static void escribir(RandomAccessFile auxiliar3, String texto) {
        System.out.printf("Escribiendo:"+"%10s",texto);
        try{

        }catch (IOException ex){

        }
    }*/

}
