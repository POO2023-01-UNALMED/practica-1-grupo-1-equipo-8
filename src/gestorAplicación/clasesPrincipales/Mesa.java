package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;

public class Mesa {

    private String idMesa;
    private int capacidad;
    private boolean disponible;
    private String sede;
    static ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();

    public Mesa(String sede, int numero, int capacidad) {
        this.idMesa = sede +numero+"-"+capacidad;
        this.capacidad = capacidad;
        this.sede = sede;
        this.disponible = true;
        mesasDisponibles.add(this);
    }

    //get
    public String getId() {
        return idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean getDisponibilidad() {
        return disponible;
    }

    public String getSede() {
        return sede;
    }
    
    //set
    public void setDisponibilidad(boolean disponible){
        this.disponible = disponible;
    }

    public String toString(){
        return "Mesa: " + idMesa + ", Capacidad: " + capacidad;
    }
    
    public static ArrayList<Mesa> buscarMesas(String Isede, int capacidad){
        ArrayList<Mesa> mesasEsp = new ArrayList<Mesa>();
        for (Mesa m: mesasDisponibles){
            if (m.sede == Isede && m.capacidad == capacidad && m.getDisponibilidad() == true){
                mesasEsp.add(m);
            }
        }
        return mesasEsp;

    }
}