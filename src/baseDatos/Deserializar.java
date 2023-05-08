package baseDatos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import uiMain.ui;
import gestorAplicación.clasesPrincipales.*;

public class Deserializar {
    static File archivo = new File("src/baseDatos/temp/miembrosActuales.txt");
    public static ArrayList<Cliente> deserializarMiembros(){
        try{
            FileInputStream file = new FileInputStream(archivo);
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Cliente> miembrosActuales = (ArrayList<Cliente>) o.readObject();

            file.close();
            o.close();
            return miembrosActuales;
        }
        
        catch(FileNotFoundException e){
            return new ArrayList<Cliente>();
        }

        catch(IOException e){
            return new ArrayList<Cliente>();
        }

        catch(ClassNotFoundException e){
            return new ArrayList<Cliente>();
        }

    }
    
}
