package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;

public class Pago {
    private Factura factura;
    private Mesa mesa;
    static ArrayList<Factura> facturasPagas = new ArrayList<Factura>();
    static ArrayList<Factura> facturasPendientes = new ArrayList<Factura>();

    public Pago(Factura factura) {
    	this.factura = factura;
        this.mesa = factura.getMesa();
    	
    }
    public static void addFacturasPagas(Factura factura) {
    	facturasPagas.add(factura);
    }
    public static ArrayList<Factura> getFacturasPagas() {
    	return facturasPagas;
    }
    public static void removePaga(Factura factura) {
    	facturasPagas.remove(factura);
    }
   
    public static void addFacturasPendientes(Factura factura) {
    	facturasPendientes.add(factura);
    }
    public static ArrayList<Factura> getFacturasPendientes() {
    	return facturasPendientes;
    }
    public static void removePendiente(Factura factura) {
    	facturasPendientes.remove(factura);
    }
}