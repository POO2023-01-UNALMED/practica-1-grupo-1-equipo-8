package gestorAplicación.clasesHeredadas;


import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.*;

// Implementación de características de POO
// Herencia

public class Trabajador extends Persona {
    private String horario;
    private Reserva atenderMesa;
    private ArrayList<Mesa> mesasAtendidas = new ArrayList<Mesa>();
    public static ArrayList<Trabajador> trabajadoresActivos = new ArrayList<Trabajador>();
    public static ArrayList<Reserva> mesasElegir = new ArrayList<Reserva>();
    private int sueldo;

// Implementación de características de POO
// Sobrecarga de constructores

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
    public String toString() {
        return this.getNombre() + this.getId();
    }
    
    public int getSueldo() {
        return sueldo;
        }

    public void añadirServicio(Reserva buscarR){
        this.setAtenderMesa(buscarR);
		Trabajador.addTrabajadoresActivos(this);
		Trabajador.removeMesasElegir(buscarR);
        this.mesasAtendidas.add(buscarR.getMesa());
    }
}
