package gestorAplicación.clasesPrincipales;

public class Pago {
    private Factura factura;
    private boolean pagado;
    private Reserva reserva;
    
    public Pago(Factura factura) {
    	this.factura = factura;
    	this.reserva = factura.getReserva();
    	
    }
    
    public boolean isPagado() {
    	return pagado;
    }
    public void setPagado(boolean pagado) {
    	this.pagado = pagado;
    }
    
    public void metodoPago(int metodo) {
    	if(metodo == 1) {
    		System.out.println("Ingrese el saldo de su tarjeta");
    	}
    	else {
    		System.out.println("Haga su pago en caja al llegar a la sede " + reserva.getSede());
    	}
    	System.out.println("Su pago ha sido registrado");
    }
    
}