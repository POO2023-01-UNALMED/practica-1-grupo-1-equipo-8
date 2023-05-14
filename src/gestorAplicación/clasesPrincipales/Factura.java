package gestorAplicación.clasesPrincipales;

import java.util.ArrayList;

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
    	this.facturaHecha =  ("-------------\nRestaurante Un \nId de la reserva: " + id + "\nCliente: " + cliente + 
    			"\nSede: " + sede + "\nMesa #" + mesa.getId() +  "\nHora: " + reserva.getHora());
		facturaHecha = facturaHecha + "\n-------------";
    }
	public String mostrarFactura(){
		return this.facturaHecha;
	}
}