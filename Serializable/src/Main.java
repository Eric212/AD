import java.io.*;

public class Main {
    public static void main(String[] args) {
        File directorio = new File("fichero");
        directorio.mkdir();
        File fileBinario = new File("fichero/objeto");
        try{
            fileBinario.createNewFile();
        }catch (IOException ex){
            System.err.println("No se ha podido crear el fichero"+fileBinario.getName());
            System.err.println("Error "+ex.getMessage());
            System.exit(-1);
        }
        Persona persona = new Persona(1,"Eric",27,"C/Piruleta");
        guardarObjeto(fileBinario,persona);
        leerObjeto(fileBinario);
    }
    private static void guardarObjeto(File fileBinario,Object persona){
        FileOutputStream streamSalida = null;
        try{
            streamSalida = new FileOutputStream(fileBinario);
        }catch (FileNotFoundException ex){
            System.err.println("no se ha podido encontrar el fichero de salida "+fileBinario.getName());
            System.err.println("Error "+ ex.getMessage());
            System.exit(-2);
        }

        try{
            streamSalida.write(3);
            System.out.println("Se ha escrito correctamente");
        }catch (IOException ex){
            System.err.println("No se ha podido escribir en "+fileBinario.getName());
            System.err.println("Error "+ex.getMessage());
        }
        ObjectOutputStream streamObject = null;

        try{
            streamObject = new ObjectOutputStream(streamSalida);
        }catch (IOException ex){
            System.err.println("No se ha podido crear el Stream de salida de Objeto");
            System.err.println("Error "+ex.getMessage());
            System.exit(-3);
        }

        try{
            streamObject.writeObject(persona);

        } catch (IOException e) {
            System.err.println("No se ha podido escribir en el Stream de Objeto");
            System.err.println("Error "+e.getMessage());
            System.exit(-4);
        }

        try{
            streamSalida.close();
            streamObject.close();
        } catch (IOException e) {
            System.err.println("No se ha podido cerrar el fichero "+fileBinario.getName());
            System.err.println("Error "+e.getMessage());
            System.exit(-5);
        }
    }

    private static void leerObjeto(File fichero){
        FileInputStream streamEntrada = null;
        try{
            streamEntrada = new FileInputStream(fichero);
        } catch (FileNotFoundException e) {
            System.err.println("No se ha podido crear el Strem de entrada del fichero "+fichero.getName());
            System.err.println("Error "+e.getMessage());
            System.exit(-6);
        }

        ObjectInputStream streamEntradaObjeto = null;

        try{
            streamEntradaObjeto = new ObjectInputStream(streamEntrada);
        } catch (IOException e) {
            System.err.println("Error al crear el Stream de entrada de Objeto");
            System.err.println("Error "+e.getMessage());
            System.exit(-7);
        }
        try {
            Persona persona = (Persona) streamEntradaObjeto.readObject();
            System.out.println(persona.getId()+"\n"+persona.getNombre()+"\n"+ persona.getEdad()+"\n"+persona.getDireccion());
        } catch (IOException e) {
            System.err.println("No se ha podido leer el Objeto");
            System.err.println("Error "+e.getMessage());
            System.exit(-8);
        } catch (ClassNotFoundException e) {
            System.err.println("No se ha podido parsear a Persona el Objeto");
            System.err.println("Error "+e.getMessage());
            System.exit(-9);
        }

    }
}