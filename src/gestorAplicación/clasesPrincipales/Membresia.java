package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;

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

    public static boolean verificarMiembro(String nombreClienteVerificar){
        for (Cliente cliente : miembrosActuales){
            if (cliente.getNombre().equals(nombreClienteVerificar)){
                cliente.setMembresia(true);
                System.out.println("Usted hace parte de la membresía del Restaurante");
                return true;
            }
            else {
                System.out.println("Usted no hace parte de la membresía del restaurante");
            }
        }
        return false;
    }

    public static void agregarMiembro(Cliente clienteNuevoMiembro) {
        miembrosActuales.add(clienteNuevoMiembro);
    }

    public static boolean cancelarMiembro(String nombreCliente, Cliente clienteEliminar){
        for (Cliente cliente: miembrosActuales){
            if (cliente.getNombre().equals(nombreCliente)){
                cliente.setMembresia(false);
                miembrosActuales.remove(clienteEliminar);
                return false;
            }
        }
        return false;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getMiembrosActuales(){
        return miembrosActuales;
    }
}