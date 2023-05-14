package gestorAplicación.clasesPrincipales;
import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {
    private int hora;
    private static int numeroDeReservas;
	private int IdR;
    private Cliente cliente;
    private Mesa mesa;
	public static ArrayList<Reserva> reservasHechas= new ArrayList<Reserva>();


	public Reserva(int hora, Cliente cliente, Mesa mesa) {
		this.hora = hora;
		this.cliente = cliente;
		this.mesa = mesa;
		Reserva.numeroDeReservas++;
		this.IdR = Reserva.numeroDeReservas;
		reservasHechas.add(this);
		
	}
	

	public String toString(){
		return "Cliente: " + this.cliente + ", mesa: " + this.mesa + ", hora: " + this.hora + ", reservaID: " + this.IdR;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
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
	public int getIdR(){
		return IdR;
	}
	public static int getNumeroDeReservas(){
		return Reserva.numeroDeReservas;
	} 

	public static boolean validarHorarioDisponible(int hora, Mesa m){
            for (Reserva reserva : reservasHechas){
            	if (reserva.hora == hora && reserva.mesa == m){
            		return false;
            }
        }
        return true;
    }

		
	public static ArrayList<Reserva> getReservasHechas(){
		return reservasHechas;
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
	

}