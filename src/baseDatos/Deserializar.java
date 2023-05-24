package baseDatos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import uiMain.ui;
import gestorAplicación.clasesHeredadas.Cliente;
import gestorAplicación.clasesPrincipales.*;

public class Deserializar {
    static File archivo = new File("src/baseDatos/temp");
    public static ArrayList<Cliente> deserializarMiembros(){
        try{
            FileInputStream file = new FileInputStream(new File(archivo.getAbsolutePath()+"/miembrosActuales.txt"));
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

    public static ArrayList<Reserva> deserializarReservas(){
        try{
            FileInputStream file = new FileInputStream(new File(archivo.getAbsolutePath()+"/reservasHechas.txt"));
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Reserva> reservasHechas = (ArrayList<Reserva>) o.readObject();

            file.close();
            o.close();
            return reservasHechas;
        }
        
        catch(FileNotFoundException e){
            return new ArrayList<Reserva>();
        }

        catch(IOException e){
            return new ArrayList<Reserva>();
        }

        catch(ClassNotFoundException e){
            return new ArrayList<Reserva>();
        }

    }

    public static ArrayList<Mesa> deserializarMesas(){
        try{
            FileInputStream file = new FileInputStream(new File(archivo.getAbsolutePath()+"/mesasDisponibles.txt"));
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Mesa> mesasDisponibles = (ArrayList<Mesa>) o.readObject();

            file.close();
            o.close();
            return mesasDisponibles;
        }
        
        catch(FileNotFoundException e){
            return new ArrayList<Mesa>();
        }

        catch(IOException e){
            return new ArrayList<Mesa>();
        }

        catch(ClassNotFoundException e){
            return new ArrayList<Mesa>();
        }

    }

    public static ArrayList<Factura> deserializarFacurasPagas(){
        try{
            FileInputStream file = new FileInputStream(new File(archivo.getAbsolutePath()+"/facturasPagas.txt"));
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Factura> facturasPagas = (ArrayList<Factura>) o.readObject();

            file.close();
            o.close();
            return facturasPagas;
        }
        
        catch(FileNotFoundException e){
            return new ArrayList<Factura>();
        }

        catch(IOException e){
            return new ArrayList<Factura>();
        }

        catch(ClassNotFoundException e){
            return new ArrayList<Factura>();
        }

    }

    public static ArrayList<Factura> deserializarFacurasPendientes() {
    String rutaArchivo = archivo.getAbsolutePath() + "/facturasPendientes.txt";
    File archivoFacturas = new File(rutaArchivo);

    if (archivoFacturas.exists()) {
        try {
            FileInputStream file = new FileInputStream(archivoFacturas);
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Factura> facturasPendientes = (ArrayList<Factura>) o.readObject();

            file.close();
            o.close();

            return facturasPendientes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Factura>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Factura>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Factura>();
        }
    } else {
        System.out.println("El archivo de facturas pendientes no existe.");
        return new ArrayList<Factura>();
    }
}
    
}
