package baseDatos;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import gestorAplicación.clasesHeredadas.Cliente;
import gestorAplicación.clasesHeredadas.Trabajador;
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
        System.out.println("");
        return new ArrayList<Factura>();
    }
}

public static ArrayList<Trabajador> deserializarTrabajadoresActivos() {
    String rutaArchivo = archivo.getAbsolutePath() + "/trabajadoresActivos.txt";
    File archivoTrabajadores = new File(rutaArchivo);

    if (archivoTrabajadores.exists()) {
        try {
            FileInputStream file = new FileInputStream(archivoTrabajadores);
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Trabajador> trabajadoresActivos = (ArrayList<Trabajador>) o.readObject();

            file.close();
            o.close();

            return trabajadoresActivos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Trabajador>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Trabajador>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Trabajador>();
        }
    } else {
        System.out.println("");
        return new ArrayList<Trabajador>();
    }
}


public static ArrayList<Reserva> deserializarMesasElegir() {
    String rutaArchivo = archivo.getAbsolutePath() + "/mesasElegir.txt";
    File archivoMesasElegir = new File(rutaArchivo);

    if (archivoMesasElegir.exists()) {
        try {
            FileInputStream file = new FileInputStream(archivoMesasElegir);
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Reserva> mesasElegir = (ArrayList<Reserva>) o.readObject();

            file.close();
            o.close();

            return mesasElegir;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        }
    } else {
        System.out.println("");
        return new ArrayList<Reserva>();
    }
}

public static ArrayList<Reserva> deserializarMesasAtendidas() {
    String rutaArchivo = archivo.getAbsolutePath() + "/mesasAtendidas.txt";
    File archivoMesasAtendidas = new File(rutaArchivo);

    if (archivoMesasAtendidas.exists()) {
        try {
            FileInputStream file = new FileInputStream(archivoMesasAtendidas);
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<Reserva> mesasAtendidas = (ArrayList<Reserva>) o.readObject();

            file.close();
            o.close();

            return mesasAtendidas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Reserva>();
        }
    } else {
        return new ArrayList<Reserva>();
    }
}
    
}
