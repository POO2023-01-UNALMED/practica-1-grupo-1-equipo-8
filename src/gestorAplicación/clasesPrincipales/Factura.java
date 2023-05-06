package gestorAplicación.clasesPrincipales;
public class Factura {
    private Reserva reserva;
    private String facturaHecha;
    private Cliente cliente;
	private Mesa mesa;
	private int precio;
	private String sede;
	private int id;
	
    public Factura(Reserva reserva) {
    	this.reserva = reserva;
    	this.cliente = reserva.getCliente();
		this.mesa = reserva.getMesa();
		this.sede = mesa.getSede();
		this.id = reserva.getIdR();
    }
    
    public Reserva getReserva() {
    	return reserva;
    }
    public void setReserva(Reserva reserva) {
    	this.reserva = reserva;
    }

	public Mesa getMesa() {
    	return mesa;
    }
	
	public String getFacturaHecha() {
		return facturaHecha;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getSede() {
		return sede;
	}    
	
	public int getIDReserva() {
	    return id;
	}

    public void escribirFactura() {
    	this.facturaHecha =  ("-------------\nRestaurante Un \nId de la reserva: " + id + "\nCliente: " + reserva.getCliente() + 
    			"\nSede: " + sede + "\nMesa #" + mesa.getId() +  "\nHora: " + reserva.getHora());
    	
    	if (cliente.getMiembro() == true) {
    		facturaHecha = facturaHecha + "\nComo eres miembro se te aplicará un descuento del 20% \n precioReserva: 80.000$ ";
    		setPrecio(80000);
    	}
    	
    	else {
    		facturaHecha = facturaHecha + "\nPrecioReserva: 100.000$ ";
    		setPrecio(100000);
    	}

		facturaHecha = facturaHecha + "\n-------------";
    }
	public String mostrarFactura(){
		return this.facturaHecha;
	}
}