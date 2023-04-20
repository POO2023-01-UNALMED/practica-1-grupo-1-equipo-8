package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;

public class Membresia {
    private Cliente cliente;
    private ArrayList<Cliente> miembrosActuales;


    public Membresia(Cliente cliente) {
        this.cliente = cliente;
        miembrosActuales = new ArrayList<>();
    }

    public Cliente getCliente(){
        return cliente;
    }

    public static boolean verificarMiembro(String nombreCliente, ArrayList<Cliente> miembrosActuales){
        for (Cliente cliente : miembrosActuales){
            if (cliente.getNombre().equals(nombreCliente)){
                cliente.setMembresia(true);
                return true;
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