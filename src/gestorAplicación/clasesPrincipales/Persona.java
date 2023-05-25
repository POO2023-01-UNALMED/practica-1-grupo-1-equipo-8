package gestorAplicación.clasesPrincipales;
import java.io.Serializable;

public abstract class Persona implements Serializable{
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

    public abstract void accion(Factura facturaNow, int saldo);

}
