package gestorAplicación.clasesPrincipales;

public class Factura {
    private Reserva reserva;
    private String facturaHecha;
    private Cliente cliente;
	private Mesa mesa;
	private boolean pagado;
	private static int facturaId = 1;
    
    
    public Factura(Reserva reserva) {
    	this.reserva = reserva;
    	this.cliente = reserva.getCliente();
		this.mesa = reserva.getMesa();
    }
    
    public Reserva getReserva() {
    	return reserva;
    }
    public void setReserva(Reserva reserva) {
    	this.reserva = reserva;
    }

	public boolean isPagado() {
    return pagado;
    }
    public void setPagado(boolean pagado) {
    	this.pagado = pagado;
    }

	public Mesa getMesa() {
    	return mesa;
    }

    public void hacerFactura() {
    	this.facturaHecha =  ("-------------\nRestaurante UN \nFactura de la reserva número " + reserva.getIDReserva() + 
    			"\nCliente: " + reserva.getCliente() + "\nSede: " + mesa.getSede() + "\nMesa #" + mesa.getId() +  "\nHora: " + reserva.getHora());
    	
    	if (cliente.getMiembro() == true) {
    		facturaHecha = facturaHecha + "\nComo eres miembro se te aplicará un descuento del #% \n precioReserva";
    	}
    	else {
    		facturaHecha = facturaHecha + "\nPrecioReserva";
    	}

		facturaHecha = facturaHecha + "\nEl número de tu factura es:" + Factura.facturaId + "\n-------------";
		Factura.facturaId ++;
    }
    
    public void mostrarFactura() {
    	System.out.println(facturaHecha);
    }
}