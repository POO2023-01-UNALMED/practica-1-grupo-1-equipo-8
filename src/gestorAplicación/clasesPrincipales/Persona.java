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

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    public static Trabajador buscarTrabajador(int id){
        for (Trabajador t : Trabajador.trabajadoresActivos){
            if (id == t.getId()){
                return t;
            }
        }
        return null;
    }


    public abstract void accion(Factura facturaNow, int saldo);
    



}
