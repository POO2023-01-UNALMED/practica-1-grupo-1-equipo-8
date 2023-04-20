package gestorAplicación.clasesPrincipales;
import java.util.ArrayList;
public class Reserva {
    private int hora;
    private static int id;
    private Cliente cliente;
    private Mesa mesa;
	static ArrayList<Reserva> reservasHechas= new ArrayList<Reserva>();

    public Reserva(int hora, Cliente cliente, Mesa mesa) {
		this.hora = hora;
		this.cliente = cliente;
		this.mesa = mesa;
		Reserva.id++;
		reservasHechas.add(this);
	}
	

	public String toString(){
		return "Cliente: " + this.cliente + ",mesa: " + this.mesa + ",hora: " + this.hora;
	}
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getIDReserva() {
		return id;
	}

	public void setIDReserva(int iDReserva) {
		id = iDReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public static boolean validarHorarioDisponible(int hora, Mesa m){
            for (Reserva reserva : reservasHechas){
            	if (reserva.hora == hora && reserva.mesa == m){
            		return false;
            }
        }
        return true;
    }
    



}
