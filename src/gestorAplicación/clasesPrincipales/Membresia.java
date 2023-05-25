package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.Iterator;
import gestorAplicación.clasesHeredadas.Cliente;
public class Membresia implements Serializable {
	
    // Implementación de características de POO
    // Uso de constante
    private final String tipo;
    private boolean activa;

    public Membresia(String tipo, boolean activa) {
        this.tipo = "Gold";
        this.activa = activa;
    }

    //Métodos get
    public String getTipo() {
        return tipo;
    }
    public boolean esActiva() {
        return activa;
    }
    
    //Método set
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public static void verificarMiembro(String nombre, int id, Cliente verificar) {
        Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
                System.out.println("El cliente " + nombre + " hace parte de la lista de miembros.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " con ID " + id + " en la lista de miembros.");
    }

    public static void agregarMiembro(String nombre, int id, Cliente nuevoMiembro) {
        Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
                System.out.println("El cliente " + nombre + " ya hace parte de la lista de miembros.");
                return;
            }
        }
        Cliente miembro = new Cliente(nombre, id);
        Membresia membresia = new Membresia("Gold", true);
        membresia.setActiva(true);
        Cliente.getMiembrosActuales().add(miembro);
        System.out.println("El cliente " + nombre + " con ID " + id + " hace parte ahora de la lista de miembros.");
    }

    public static void cancelarMiembro(String nombre, int idEliminar, Cliente eliminar) {
        Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNombre().equals(nombre) && cliente.getId() == idEliminar) {
                cliente.setMembresia(null);
                iterator.remove();
                System.out.println("El cliente " + nombre + " ha sido eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el cliente " + nombre + " con ID " + idEliminar + " en la lista de miembros, no es posible eliminarlo.");
    }
}