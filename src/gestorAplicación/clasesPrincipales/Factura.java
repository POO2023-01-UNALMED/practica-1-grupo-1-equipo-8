package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicación.clasesHeredadas.Cliente;

public class Factura implements Serializable {
    private Reserva reserva;
    private String facturaHecha;
    private Cliente cliente;
	private Mesa mesa;
	private int precio;
	private String sede;
	private String id;
	
    public Factura(Reserva reserva) {
    	this.reserva = reserva;
    	this.cliente = reserva.getCliente();
		this.mesa = reserva.getMesa();
		this.sede = mesa.getSede();
		this.id = reserva.getIdR();
		Pago.addFacturasPendientes(this);
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
	
	public String getIDReserva() {
	    return id;
	}

    public String toString() {
    	String facturaHecha =  ("-------------\nRestaurante Un \nId de la reserva: " + id + "\nCliente: " + reserva.getCliente() + 
    			"\nSede: " + sede + "\nMesa #" + mesa.getId() +  "\nHora: " + reserva.getHora());
				
    	if(cliente.getMembresia() != null) {
    		this.facturaHecha = facturaHecha + "\nComo eres miembro se te aplicará un descuento del 20% \nPrecio: 80.000$";
    		setPrecio(80000);
    	}
    	else {
    		this.facturaHecha = facturaHecha + "\nPrecio: 100.000$";
    		setPrecio(100000);
    	}
		facturaHecha = facturaHecha + "\n-------------";

		return facturaHecha;
    }

	public static void buscarFactura(ArrayList<Factura> facturas,String id){
        for (Factura f : facturas){
			System.out.println(f.getReserva().getIdR().trim());
			System.out.println(f.getReserva().getIdR().trim() == id);
			}
		}
}