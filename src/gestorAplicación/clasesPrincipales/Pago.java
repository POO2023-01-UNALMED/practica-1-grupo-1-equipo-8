package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.ArrayList;

public class Pago implements Serializable {
    private Factura factura;
    private String medioPago;
    public static ArrayList<Factura> facturasPagas = new ArrayList<Factura>();
    public static ArrayList<Factura> facturasPendientes = new ArrayList<Factura>();
    public static ArrayList<Pago> registroPagos = new ArrayList<Pago>();

    public Pago(Factura factura, String medioPago) {
    	this.factura = factura;
    	this.medioPago = medioPago;
        registroPagos.add(this);  
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
    public Factura getFactura() {
    	return factura;
    }
    public String getMedioPago() {
    	return medioPago;
    }
    public static ArrayList<Pago> getRegistroPagos(){
    	return registroPagos;
    }
    public static void removePagos(Pago pago) {
    	registroPagos.remove(pago);
    }
}