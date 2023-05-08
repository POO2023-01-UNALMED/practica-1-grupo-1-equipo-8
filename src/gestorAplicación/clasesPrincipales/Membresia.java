package gestorAplicación.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Membresia implements Serializable{
    private Cliente cliente;
    public static ArrayList<Cliente> miembrosActuales;


    public Membresia(Cliente cliente) {
        this.cliente = cliente;
        miembrosActuales = new ArrayList<>();
    }

    public Cliente getCliente(){
        return cliente;
    }


    public static void verificarMiembro(String nombre, int id, Cliente Verificar){
        Iterator<Cliente> iterator = Cliente.miembrosActuales.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
                System.out.println("El cliente " + nombre + " hace parte de la lista de miembros.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " con ID " + id + " en la lista de miembros.");
    }

    public static void agregarMiembro(String nombre, int id, Cliente nuevoMiembro){
        Iterator<Cliente> iterator = Cliente.miembrosActuales.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
                System.out.println("El cliente " + nombre + " ya hace parte de la lista de miembros.");
                return;
            }
        }
        Cliente.miembrosActuales.add(new Cliente(nombre, id));;
        nuevoMiembro.setMembresia(true);
        System.out.println("El cliente " + nombre + " con ID " + id + " hace parte ahora de la lista de miembros.");
    }

    public static void cancelarMiembro(String nombre, int ideliminar, Cliente Eliminar){
        Iterator<Cliente> iterator = Cliente.miembrosActuales.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == ideliminar) {
                cliente.setMembresia(false);
                iterator.remove();
                System.out.println("El cliente " + nombre + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " con ID " + ideliminar + " en la lista de miembros, no es posible eliminarlo.");
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getMiembrosActuales(){
        return miembrosActuales;
    }
}