package gestorAplicación.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
    public static ArrayList<Cliente> miembrosActuales = new ArrayList<Cliente>();
    private int id;
    private String nombre;
    private boolean membresia;

    public Cliente(String nombre, int id){
        this.id = id;
        this.nombre = nombre;
        this.membresia = false;
    }
    
    public Cliente(int id) {
    	this.id = id;
        this.nombre = "N/N";
        this.membresia = false;
    }


    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean getMiembro(){
        return membresia;
    }

    public void setMembresia(boolean membresia){
        this.membresia = membresia;
    }

    public String toString(){
        return nombre + id;
    }
    public static ArrayList<Cliente> getMiembrosActuales(){
        return miembrosActuales;
    }
}