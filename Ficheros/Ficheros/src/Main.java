import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Empezamos el programa");

        File directorio=new File("Fichertos");
        if (!directorio.exists()){
            if(directorio.mkdir()){
                System.out.println("Directorio creado");
            }else{
                System.out.println("Fallo al crear direcotiro");
            }
        }else {
            System.out.println("Ya existe la carpeta");
        }

        File fichero= new File(directorio.getPath(),"Fichero1.txt");
        if(!fichero.exists()) {
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error a la hora de crear el fichero");
                System.err.println("Este es el error:" + e.getMessage());
            }
        }else{
            System.out.println("El archivo ya existe");
        }
        if(fichero.canWrite()){
            if(fichero.delete()){
                System.out.println("archivo borrado");
            }else{
                System.err.println("No se ha podido borrar");
            }
        }else {
            System.err.println("No tienes permisos de escritura");
        }
        File fichero2= new File(directorio.getPath(),"Fichero2.txt");
        if(!fichero2.exists()) {
            try {
                fichero2.createNewFile();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error a la hora de crear el fichero");
                System.err.println("Este es el error:" + e.getMessage());
            }
        }else{
            System.out.println("El archivo ya existe");
        }
        File fichero3= new File(directorio.getPath(),"Fichero3.txt");
        if(!fichero3.exists()) {
            try {
                fichero3.createNewFile();
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error a la hora de crear el fichero");
                System.err.println("Este es el error:" + e.getMessage());
            }
        }else{
            System.out.println("El archivo ya existe");
        }

        for(int i=0;i<directorio.listFiles().length;i++){
            System.out.println(directorio.listFiles()[i].getName());
        }

        System.out.println("Acabamos el programa");
    }
}