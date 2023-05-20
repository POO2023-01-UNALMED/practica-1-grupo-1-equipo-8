package gestorAplicación.clasesHeredadas;

import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.Membresia;
import gestorAplicación.clasesPrincipales.Persona;

public class Cliente extends Persona {
    public static ArrayList<Cliente> miembrosActuales = new ArrayList<Cliente>();
    private Membresia membresia;

    public Cliente(String nombre, int id) {
        super(nombre, id);
        this.membresia = null;
    }

    public Cliente(int id) {
        super("N/N", id);
        this.membresia = null;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public String getNombre() {
        return super.getNombre();
    }

    public int getId() {
        return super.getId();
    }

    public String toString() {
        return this.getNombre() + this.getId();
    }

    public static ArrayList<Cliente> getMiembrosActuales() {
        return miembrosActuales;
    }
}
