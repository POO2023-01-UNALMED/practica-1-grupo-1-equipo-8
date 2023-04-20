package uiMain;
import java.util.Scanner;
import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.*;
import gestorAplicación.clasesHeredadas.*;


public class ui {
    private static Membresia membresia1 = new Membresia(new Cliente("Juan", 987));
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Reserva> historial = new ArrayList<Reserva>();

        Cliente.miembrosActuales.add(new Cliente(987, "Juan"));
        Cliente.miembrosActuales.add(new Cliente(957, "Jose"));
        Cliente.miembrosActuales.add(new Cliente(917, "Alex"));
        Cliente.miembrosActuales.add(new Cliente(986, "Luis"));
        Mesa me1 = new Mesa("E", 1, 2);
        Mesa me2 = new Mesa("SJ", 2, 2);
        Mesa me3 = new Mesa("B", 3, 2);
        Mesa me4 = new Mesa("B", 4, 3);
        Mesa me5 = new Mesa("E", 5, 3);
        Mesa me6 = new Mesa("SJ", 6, 4);
        Mesa me7 = new Mesa("SJ", 7, 3);
        Mesa me8 = new Mesa("E", 8, 2);
        Mesa me9 = new Mesa("E", 9, 2);
        Mesa me10 = new Mesa("E", 10, 3);
        Mesa me11 = new Mesa("B", 11, 5);
        Cliente cli1 = new Cliente ("Juan", 353);
        Cliente cli2 = new Cliente ("Felipe", 3425);
        Cliente cli3 = new Cliente ("Pascual", 2345);
        Cliente cli4 = new Cliente ("Alberto", 546);
        Reserva re1 = new Reserva(6, cli1, me1);
        Reserva re2 = new Reserva(6, cli3, me11);

        
        System.out.println("Bienvenido a RestauranteUN, escoja su opción");
        System.out.println("1. Reservar"); // Jonhatan
        System.out.println("2. Reprogramar"); // Pedro
        System.out.println("3. Cancelar");
        System.out.println("4. Pagar"); // Daniel
        System.out.println("5. Obtener membresía");// Manuel
        System.out.println("6.Salir");
        int opc = inp.nextInt();
        
        switch(opc){
            case 1:
                hacerReserva();
    }
}
//Realizar reservas (MEMBRESIA, MESA, CLIENTE, FACTURA)
	public static void hacerReserva() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Ingrese su nombre y su numero de identificacion");
		String a1 = inp.nextLine();
        int a2 = inp.nextInt();
        Cliente clienteNow = new Cliente(a1, a2);
        //Toca revisar como hacer lo de los constructores sobrecargados


        boolean resultado = Membresia.verificarMiembro(clienteNow.getNombre(), Cliente.getMiembrosActuales());
        	clienteNow.setMembresia(resultado);
  
            if (clienteNow.getMiembro()){
                System.out.println("Bienvenido de nuevo " + clienteNow.getNombre());
            }

        System.out.println("Escoja la sede en la que quiera reservar");
        System.out.println("1. Bello");
        System.out.println("2. Envigado");
        System.out.println("3. San Javier");
        int sede = inp.nextInt();
        String Isede = "";
        
        if (sede == 1) {
        	Isede = "B";
        } else if (sede == 2) {
        	Isede = "E";
        } else if (sede == 3) {
        	Isede = "SJ";
        }

        System.out.println("Ingrese la cantidad de personas[2-4]");
        int cantidad = inp.nextInt();
        ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidad);

        System.out.println("Ingrese la hora en la que quiere reservar [6pm-12pm]");
        int hora = inp.nextInt();
        
        for (Mesa m : mesasRequeridas) {
        	m.setDisponibilidad(Reserva.validarHorarioDisponible(hora, m));
        	}
        ArrayList<Mesa> mesasF = new ArrayList<Mesa>();
        for (Mesa m : mesasRequeridas) {
        	if (m.getDisponibilidad()) {
        		mesasF.add(m);
        	}
        }
	
        if (mesasF.size() == 0 ){
            System.out.println("Lo sentimos, pero no hay disponibilidad de mesas con estas caracteristicas");
        } else {
            System.out.println("Escoja una de las mesas que se mostrarán a continuación");
            int c = 1;
            for (Mesa mesa : mesasF){
            	if (mesa.getDisponibilidad()) {
                System.out.println(c + ". "+ mesa.toString());
                c++;
            	}
            }
        }
        
        int mesaElegida = inp.nextInt();
        Mesa mesaEl = mesasF.get(mesaElegida-1);
        System.out.println("La " + mesaEl.getId() + " será reservada a nombre de " + clienteNow.getNombre() + " ¿Desea continuar y generar su factura?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int conf = inp.nextInt();
        if (conf == 1){
            Reserva reservaDone = new Reserva(hora, clienteNow, mesaEl);
        } else {
            System.out.println("Sentimos que no desee finalizar su reserva "  + clienteNow.getNombre() +", lo esperamos en una nueva ocasion. ");
        }
        
	}
}