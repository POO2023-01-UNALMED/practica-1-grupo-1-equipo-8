package gestorAplicación.clasesHeredadas;

import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.*;

public class Trabajador extends Persona {
    private String horario;
    private Reserva atenderMesa;
    private static ArrayList<Trabajador> trabajadoresActivos = new ArrayList<Trabajador>();
    private static ArrayList<Reserva> mesasElegir = new ArrayList<Reserva>();
    private int sueldo;

    public Trabajador(String nombre, int id, String horario){
        super(nombre, id);
        this.horario = horario;
    }

    public Trabajador(int id, String horario) {
        super("N/N", id);
        this.horario = horario;
    }
    
    public Reserva getAtenderMesa() {
        return atenderMesa;
        }
    public void setAtenderMesa(Reserva reserva) {
        atenderMesa = reserva;
        sueldo = sueldo + 35000;
    }

    public static ArrayList<Trabajador> getTrabajadoresActivos() {
        return trabajadoresActivos;
        }  
    public static void addTrabajadoresActivos(Trabajador trabajador) {
        trabajadoresActivos.add(trabajador);
        }
    public static void removeTrabajadoresActivos(Trabajador trabajador) {
        trabajadoresActivos.remove(trabajador);
        }

    public static ArrayList<Reserva> getMesasElegir() {
        return mesasElegir;
        }   
    public static void addMesasElegir(Reserva reserva) {
        mesasElegir.add(reserva);
    }
    public static void removeMesasElegir(Reserva reserva) {
        mesasElegir.remove(reserva);
        }
    
    public int getSueldo() {
        return sueldo;
        }
}
