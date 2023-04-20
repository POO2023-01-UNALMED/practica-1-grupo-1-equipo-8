package gestorAplicación.clasesPrincipales;

public class Factura {
    private Reserva reserva;
    private String facturaHecha;
    private Cliente cliente;
    
    
    public Factura(Reserva reserva) {
    	this.reserva = reserva;
    	this.cliente = reserva.getCliente();
    }
    
    public Reserva getReserva() {
    	return reserva;
    }
    public void setReserva(Reserva reserva) {
    	this.reserva = reserva;
    }

    public void hacerFactura(Mesa mesa) {
    	this.facturaHecha =  ("-------------\nRestaurante Un \nFactura de la reserva número " + reserva.getIDReserva() + 
    			"\nCliente: " + reserva.getCliente() + "\nSede " + reserva.getSede() + "\nMesa #" + reserva.getMesa() + "\nPara " + reserva.getCantidadDePersonas() + 
    			" personas" + "\nHora: " + reserva.getHora());
    	
    	if (cliente.getMiembro() == true) {
    		facturaHecha = facturaHecha + "\nComo eres miembro se te aplicará un descuento del #% \n precioReserva \n-------------";
    	}
    	else {
    		facturaHecha = facturaHecha + "\nPrecioReserva \n-------------";
    	}
    }
    
    public void mostrarFactura() {
    	System.out.println(facturaHecha);
    }
}