package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;
import java.util.Iterator;

public class Membresia {
    private Cliente cliente;
    public static ArrayList<Cliente> miembrosActuales;


    public Membresia(Cliente cliente) {
        this.cliente = cliente;
        miembrosActuales = new ArrayList<>();
    }

    public Cliente getCliente(){
        return cliente;
    }


    public static void verificarMiembro(String nombre, Cliente Verificar){
        Iterator<Cliente> iterator = Cliente.miembrosActuales.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre)) {
                System.out.println("El cliente " + nombre + " hace parte de la lista de miembros.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " en la lista de miembros.");
    }

    public static void agregarMiembro(Cliente nuevoMiembro) {
        miembrosActuales.add(nuevoMiembro);
        nuevoMiembro.setMembresia(true);
    }

    public static void cancelarMiembro(String nombre, Cliente Eliminar){
        Iterator<Cliente> iterator = Cliente.miembrosActuales.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre)) {
                cliente.setMembresia(false);
                iterator.remove();
                System.out.println("El cliente " + nombre + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " en la lista de miembros.");
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getMiembrosActuales(){
        return miembrosActuales;
    }
}