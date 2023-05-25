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

public static boolean verificarMiembro(String nombre, int id, Cliente verificar) {
    Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
    while (iterator.hasNext()) {
        Cliente cliente = iterator.next();
        if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
            return true;
        }
    }
    return false;
}

public static boolean agregarMiembro(String nombre, int id, Cliente nuevoMiembro) {
    Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
    while (iterator.hasNext()) {
        Cliente cliente = iterator.next();
        if (cliente.getNombre().equals(nombre) && cliente.getId() == id) {
            return false;
        }
    }
    Cliente miembro = new Cliente(nombre, id);
    Membresia membresia = new Membresia("Gold", true);
    membresia.setActiva(true);
    Cliente.getMiembrosActuales().add(miembro);
    return true;
}

public static boolean cancelarMiembro(String nombre, int idEliminar, Cliente eliminar) {
    Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
    while (iterator.hasNext()) {
        Cliente cliente = iterator.next();
        if (cliente.getNombre().equals(nombre) && cliente.getId() == idEliminar) {
            cliente.setMembresia(null);
            iterator.remove();
            return true;
        }
    }
    return false;
}
}