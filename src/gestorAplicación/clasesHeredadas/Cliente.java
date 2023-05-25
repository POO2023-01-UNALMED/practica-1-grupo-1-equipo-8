package gestorAplicación.clasesHeredadas;
import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.Factura;
import gestorAplicación.clasesPrincipales.Membresia;
import gestorAplicación.clasesPrincipales.Pago;
import gestorAplicación.clasesPrincipales.Persona;

// Implementación de características de POO
// Herencia
public class Cliente extends Persona {
    public static ArrayList<Cliente> miembrosActuales = new ArrayList<Cliente>();
    private Membresia membresia;

// Implementación de características de POO
// Sobrecarga de cosntructores
    public Cliente(String nombre, int id) {
        super(nombre, id);

// Implementación de características de POO
// Manejo de this
        this.membresia = getMembresia();
    }
    
    public Cliente(int id) {
        super("N/N", id); 

// Implementación de características de POO
// Manejo de this
        this.membresia = getMembresia();
    }

    //Métodos get
    public Membresia getMembresia() {
        return membresia;
    }
    public String getTipodeMiembro(){
        return membresia.getTipo();
    }
    public boolean getActividad(){
        return membresia.esActiva();
    }
    public String getNombre() {
        return super.getNombre();
    }
    public int getId() {
        return super.getId();
    }
    public static ArrayList<Cliente> getMiembrosActuales() {
        return miembrosActuales;
    }
    
    //Métodos set
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    
    public String toString() {
        return this.getNombre() + " " + this.getId();
    }

    @Override//Ligadura dinámica
    public boolean accion(Factura facturaNow, int saldo){
        if(saldo >= facturaNow.getPrecio()) {
            Pago.removePendiente(facturaNow);
            Pago.addFacturasPagas(facturaNow);
            Trabajador.removeMesasElegir(facturaNow.getReserva());
            Pago pagado = new Pago(facturaNow, "línea");
            return true;
        }
        else {
            return false;
        }
    }

    public static void pagoEnEfectivo(Factura facturaNow){
        System.out.println("Haga su pago en caja al llegar a la sede " + facturaNow.getSede());
		Pago.removePendiente(facturaNow);
		Pago.addFacturasPagas(facturaNow);
        Trabajador.removeMesasElegir(facturaNow.getReserva());
	    Pago pagado = new Pago(facturaNow, "Efectivo");
    }
}