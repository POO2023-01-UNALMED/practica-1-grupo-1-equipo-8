package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicación.clasesHeredadas.Cliente;

public class Factura implements Serializable {
	private Reserva reserva;
    private String facturaHecha;
    private Cliente cliente;
	private Mesa mesa;
	private int precio;
	private String sede;
	private String id;
	private Membresia membresia;

	
    public Factura(Reserva reserva) {
    	this.reserva = reserva;
    	this.cliente = reserva.getCliente();
		this.mesa = reserva.getMesa();
		this.sede = mesa.getSede();
		this.id = reserva.getIdR();
		this.membresia = cliente.getMembresia();
		this.precio = 100000;
		Pago.addFacturasPendientes(this);
    }
    

    public Reserva getReserva() {
    	return reserva;
    }
    public void setReserva(Reserva reserva) {
    	this.reserva = reserva;
    }

	public Cliente getClienteFactura(){
		return reserva.getCliente();
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

	public Membresia getFacturaMiembro() {
		return membresia;
	}
	
	public String getIDReserva() {
	    return id;
	}


	private boolean clienteEsMiembro(Cliente cliente) {
		Iterator<Cliente> iterator = Cliente.getMiembrosActuales().iterator();
		while (iterator.hasNext()) {
			Cliente clienteActual = iterator.next();
			if (clienteActual.getNombre().equals(cliente.getNombre()) && clienteActual.getId() == cliente.getId()) {
				return true; 
			}
		}
		return false; 
		
	}
	
public String toString() {
    String facturaHecha = "-------------\nRestaurante Un\nId de la reserva: " + id + "\nCliente: " + cliente.getNombre() + "\nIdentificación: " + cliente.getId()
            + "\nSede: " + sede + "\nMesa #" + mesa.getId() + "\nHora: " + reserva.getHora();

    if (clienteEsMiembro(cliente)) {
        facturaHecha += "\nEl cliente es miembro Gold";
        int precioConDescuento = precio - 20000;
        facturaHecha += "\nDescuento del 20% aplicado\nPrecio: 80000$";
        if (precio == 100000) {
            this.precio = precioConDescuento;
        }
    } else {
        facturaHecha += "\nEl cliente no es miembro";
        facturaHecha += "\nPrecio: " + precio + "$";
    }

    facturaHecha += "\n-------------";
    return facturaHecha;
}


	public static Factura buscarFactura(ArrayList<Factura> facturas,String id){
        for (Factura f : facturas){
			if (f.getReserva().getIdR().trim().equals(id)){
				return f;
			}
		}
		return null;
    }
	public void actualizarFactura(Reserva reserva){
		Pago.removePendiente(this);
		new Factura(reserva);
	}
}