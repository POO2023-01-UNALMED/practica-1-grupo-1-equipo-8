package gestorAplicación.clasesPrincipales;

public class Pago {
    private Factura factura;
    private Mesa mesa;

    public Pago(Factura factura) {
    	this.factura = factura;
        this.mesa = factura.getMesa();
    	
    }
    
    public void metodoPago(int metodo) {
    	if(metodo == 1) {
    		System.out.println("Ingrese el saldo de su tarjeta");
    	}
    	else {
    		System.out.println("Haga su pago en caja al llegar a la sede " + mesa.getSede());
    	}
    	System.out.println("Su pago ha sido registrado");
        factura.setPagado(true);
    }
}