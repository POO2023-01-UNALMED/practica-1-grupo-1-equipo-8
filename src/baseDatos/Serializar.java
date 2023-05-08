package baseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import gestorAplicación.*;
import gestorAplicación.clasesPrincipales.Cliente;

import java.util.ArrayList;

public class Serializar {
    static File archivo = new File("src/baseDatos/temp/miembrosActuales.txt");

    public static void serializarMiembros(ArrayList<Cliente> miembrosActuales) {

        try {
            FileOutputStream f = new FileOutputStream(archivo);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(miembrosActuales);

            o.close();
            f.close();
        }
        catch (FileNotFoundException e){
            System.out.println("No se encuentra el archivo: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}