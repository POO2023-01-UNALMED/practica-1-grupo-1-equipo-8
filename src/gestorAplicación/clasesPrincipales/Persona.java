package gestorAplicación.clasesPrincipales;
import java.io.Serializable;

public class Persona implements Serializable{
    private int id;
    private String nombre;

    public Persona(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
}
