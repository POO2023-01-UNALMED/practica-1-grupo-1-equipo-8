package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicación.clasesHeredadas.Cliente;
import gestorAplicación.clasesHeredadas.Trabajador;

public class Reserva implements Serializable {
    private int hora;
	private String IdR;
    private Cliente cliente;
    private Mesa mesa;
	public static ArrayList<Reserva> reservasHechas= new ArrayList<Reserva>();

	public Reserva(int hora, Cliente cliente, Mesa mesa) {
		this.hora = hora;
		this.cliente = cliente;
		this.mesa = mesa;
		this.IdR= hora+"-"+mesa.getId();
		reservasHechas.add(this);
		Trabajador.addMesasElegir(this);
	}
	
	//Métodos get
	public int getHora() {
		return hora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public String getIdR(){
		return IdR;
	}
	public static ArrayList<Reserva> getReservasHechas(){
		return reservasHechas;
	}
	
	//Métodos set
	public void setHora(int hora) {
		this.hora = hora;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public String toString(){
		return "Cliente: " + this.cliente + ", mesa: " + this.mesa + ", hora: " + this.hora + ", reservaID: " + this.IdR;
	}


	//Recibe una lista de mesas y revisa si estan disponibles en cierto horario
	public static ArrayList<Mesa> validarHorarioDisponible(ArrayList<Mesa> mesas, int hora) {
		ArrayList<Mesa> mesasReservadas = new ArrayList<>();
		for (Mesa m : mesas) {
			for (Reserva r : Reserva.reservasHechas) {
				if (r.getIdR().trim().equals(hora+"-"+m.getId())) {
					mesasReservadas.add(m);
				}
			}
		}
		mesas.removeAll(mesasReservadas);
		return mesas;
	}
		
	public static String devolverSede(int sede){
		String Isede = "";
		if (Sedes.B.ordinal() == sede) {
        	Isede = "B";
        } else if (Sedes.E.ordinal() == sede) {
        	Isede = "E";
        } else if (Sedes.SJ.ordinal() == sede) {
        	Isede = "SJ";
        }
		return Isede;
	}
	
	public void cambiarParametros(int hora, Mesa mesa){
		this.hora = hora;
		this.mesa = mesa;
		this.IdR = hora+"-"+mesa.getId();
	}

	public static Reserva buscarReserva(String id){
		for (Reserva r : reservasHechas){
			if (r.getIdR().trim().equals(id)){
				return r;
			}
		}
		return null;
	}
}