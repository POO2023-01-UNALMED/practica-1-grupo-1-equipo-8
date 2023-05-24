package baseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import gestorAplicación.clasesHeredadas.Cliente;
import gestorAplicación.clasesPrincipales.Factura;
import gestorAplicación.clasesPrincipales.Mesa;
import gestorAplicación.clasesPrincipales.Reserva;

import java.util.ArrayList;

public class Serializar {
    static File archivo = new File("src/baseDatos/temp");

    public static void serializarMiembros(ArrayList<Cliente> miembrosActuales) {

        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/miembrosActuales.txt"));
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

    public static void serializarReservas(ArrayList<Reserva> reservasHechas) {

        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/reservasHechas.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(reservasHechas);

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

    public static void serializarMesas(ArrayList<Mesa> mesasDisponibles) {

        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/mesasDisponibles.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(mesasDisponibles);

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

    public static void serializarFacturasPagas(ArrayList<Factura> facturasPagas) {

        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/facturasPagas.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(facturasPagas);

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

    public static void serializarFacturasPendientes(ArrayList<Factura> facturasPendientes) {

        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+"/facturasPendientes.txt"), false);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(facturasPendientes);

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