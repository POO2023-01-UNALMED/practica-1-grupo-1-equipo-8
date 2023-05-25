package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import gestorAplicación.clasesHeredadas.Trabajador;

public abstract class Persona implements Serializable{
    private int id;
    private String nombre;

    public Persona(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }

    //Métodos get
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    
    //Método abstracto
    public abstract boolean accion(Factura facturaNow, int saldo);
    
    public static Trabajador buscarTrabajador(int id){
        for (Trabajador t : Trabajador.trabajadoresActivos){
            if (id == t.getId()){
                return t;
            }
        }
        return null;
    }
}