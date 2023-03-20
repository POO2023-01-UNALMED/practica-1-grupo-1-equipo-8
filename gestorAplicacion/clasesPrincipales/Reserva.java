package clasesPrincipales;

public class Reserva {
	private int hora;
	private String IDReserva;
	private int cantidadDePersonas;
	private Cliente cliente;
	private String sede;
	private Mesa mesa;
	
	public Reserva(int hora, String iDReserva, int cantidadDePersonas, Cliente cliente, String sede, Mesa mesa) {
		super();
		this.hora = hora;
		this.IDReserva = iDReserva;
		this.cantidadDePersonas = cantidadDePersonas;
		this.cliente = cliente;
		this.sede = sede;
		this.mesa = mesa;
	}
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getIDReserva() {
		return IDReserva;
	}

	public void setIDReserva(String iDReserva) {
		IDReserva = iDReserva;
	}

	public int getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(int cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	// public String hacerReserva() {}
	// public String cancelarReserva(){}
	// reprogramarReserva(){}
	
}
