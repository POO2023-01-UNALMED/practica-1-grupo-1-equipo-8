package gestorAplicación.clasesHeredadas;


import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.*;

// Implementación de características de POO
// Herencia

public class Trabajador extends Persona {
    final private String horario;
    private ArrayList<Reserva> mesasAtendidas = new ArrayList<Reserva>();
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
        return this.getNombre() + this.getId() + this.horario;
    }
    
    public int getSueldo() {
        return sueldo;
        }
    public void addMesasAtendidas(Reserva reserva) {
            mesasAtendidas.add(reserva);
    }
    public ArrayList<Reserva> getMesasAtendidas() {
        return mesasAtendidas;
        }  


    @Override
     public void accion(Factura facturaNow, int sueldo){
        Reserva reserva = facturaNow.getReserva();
        addMesasAtendidas(reserva);
        System.out.println("La cantidad de reservas atendidas por el trabajador: " + getNombre());
        System.out.println("Es un total de: " + mesasAtendidas.size());
        

        int sueldoFactura = facturaNow.getPrecio();
        this.sueldo += sueldoFactura/2;
        System.out.println("Su sueldo actual es de: " + getSueldo());
     }

}
