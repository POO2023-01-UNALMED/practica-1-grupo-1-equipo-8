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

        this.membresia = null;
    }

    public Cliente(int id) {
        super("N/N", id);

// Implementación de características de POO
// Manejo de this
        
        this.membresia = null;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public String getNombre() {
        return super.getNombre();
    }

    public int getId() {
        return super.getId();
    }

    public String toString() {
        return this.getNombre() + this.getId();
    }

    public static ArrayList<Cliente> getMiembrosActuales() {
        return miembrosActuales;
    }
    public static void pagoEnLinea(Factura facturaNow, int saldo){
        if(saldo >= facturaNow.getPrecio()) {
            System.out.println("Su pago ha sido registrado");
            Pago.removePendiente(facturaNow);
            Pago.addFacturasPagas(facturaNow);
            Pago pagado = new Pago(facturaNow, "línea");
        }
        else {
            System.out.println("Su saldo no es suficiente, aún no podremos confirmar su reserva");
        }
    }

    public static void PagoEfectivo(Factura facturaNow){
        System.out.println("Haga su pago en caja al llegar a la sede " + facturaNow.getSede());
		Pago.removePendiente(facturaNow);
		Pago.addFacturasPagas(facturaNow);
	    Pago pagado = new Pago(facturaNow, "Efectivo");
    }
}
