package gestorAplicación.clasesPrincipales;

import java.util.ArrayList;

public class Pago {
    static ArrayList<Factura> facturasPagas = new ArrayList<Factura>();
    static ArrayList<Factura> facturasPendientes = new ArrayList<Factura>();
    
    public static void addFacturasPagas(Factura factura) {
    	facturasPagas.add(factura);
    }
   
    public static void addFacturasPendientes(Factura factura) {
    	facturasPagas.add(factura);
    }
}