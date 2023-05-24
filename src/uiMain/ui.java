package uiMain;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import gestorAplicación.clasesHeredadas.Cliente;
import gestorAplicación.clasesHeredadas.Trabajador;
import gestorAplicación.clasesPrincipales.*;
import baseDatos.Deserializar;
import baseDatos.Serializar;
import java.text.DecimalFormat;

public class ui {
    public static void main(String[] args) {

		//Deserializar
		Trabajador.trabajadoresActivos = Deserializar.deserializarTrabajadoresActivos();
		Trabajador.mesasElegir = Deserializar.deserializarMesasElegir();
		Cliente.miembrosActuales = Deserializar.deserializarMiembros();
		Reserva.reservasHechas = Deserializar.deserializarReservas();
		Mesa.mesasDisponibles = Deserializar.deserializarMesas();
		Pago.facturasPagas = Deserializar.deserializarFacurasPagas();
		Pago.facturasPendientes = Deserializar.deserializarFacurasPendientes();
		Cliente.miembrosActuales = Deserializar.deserializarMiembros();

        Scanner inp = new Scanner(System.in);
        ArrayList<Reserva> historial = new ArrayList<Reserva>();
		
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
		Reserva re2 = new Reserva(7, cli2, me9);
		Factura f1 = new Factura(re1);
		Factura f2 = new Factura(re2);

		System.out.println("Bienvenido, escoja el menú al que desea entrar");
		System.out.println("1. Cliente");
		System.out.println("2. Trabajador");
		int opc = inp.nextInt();

		switch(opc){
			case 1:
				menuCliente();
				break;
			case 2:
				menuTrabajador();
				break;
		}
	}
        
	public static  void menuCliente(){
		Scanner inp = new Scanner(System.in);
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("|Bienvenido al apartado Cliente de RestauranteUN, escoja su opción:|");
        System.out.println("|                        1. Reservar                               |");
        System.out.println("|                        2. Reprogramar                            |");
        System.out.println("|                        3. cancelar                               |");
        System.out.println("|                        4. Pagar                                  |");
        System.out.println("|                        5. Obtener membresía                      |");
        System.out.println("|                        6. Salir                                  |");
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("Opción:");
        int opc2 = inp.nextInt();
        
        switch(opc2){
            case 1:
                hacerReserva();
                break;
            case 2:
            	hacerReprogramacion();
            	break;
            case 4:
               	 procederPago();
               	 break;
			case 5:
				membresias();
				break;
            case 6:
            	System.out.println("Muchas gracias por su visita vuelva pronto.");
            	break;
   		 }	
	}

	 public static void menuTrabajador() {
			Scanner inp = new Scanner(System.in);
			System.out.println(" ---------------------------------------------------------------------");
			System.out.println("|Bienvenido al apartado Trabajador de RestauranteUN, escoja su opción:|");
			System.out.println("|                     1. Ingresar al trabajo                          |");
			System.out.println("|                     2. Asignar mesa                                 |");
			System.out.println("|                     3. Visualizar sueldo actual                     |");
			System.out.println("|                     4. Salir                                        |");
			System.out.println(" ---------------------------------------------------------------------");
			int opc3 = inp.nextInt();

		switch(opc3){
			case 1:
				ingresarTrabajo();
				break;		
			case 2:
				asignarMesa();
				break;		
			case 3:
				visualizarSueldo();
				break;
			case 4:
            	System.out.println("Muchas gracias por su visita vuelva pronto.");
            	break;
		}
	 }
	 
	 //TRABAJADOR
public static void ingresarTrabajo() {
	Scanner inp = new Scanner(System.in);
	System.out.println("Ingrese su nombre");
	String na = inp.nextLine();
	System.out.println("Ingrese su número de identificación");
	int na1 = inp.nextInt();
	Trabajador trabajador = new Trabajador(na, na1, "6pm-12pm");
	Trabajador.addTrabajadoresActivos(trabajador);
	System.out.println("¡Listo! Ahora eres un trabajador de RestauranteUN");

	Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
	Serializar.serializarMesasElegir(Trabajador.mesasElegir);
	}
	
public static void asignarMesa() {
	Scanner inp = new Scanner(System.in);

    Trabajador trabajador = null;
	System.out.println("Para comenzar, ingrese su nombre:");
	String spc1 = inp.nextLine();
	System.out.println("ingrese su numero de identificación:");
	int spc2 = inp.nextInt();
	ArrayList<Trabajador> lista = Trabajador.getTrabajadoresActivos();
	for (Trabajador BuscarT : lista) {
		if(BuscarT.getNombre() == spc1) {
			if(BuscarT.getId() == spc2) {
				trabajador = BuscarT;
				break;
			}
		}
	}

	if (trabajador != null) {
		System.out.println("¡Bienvenido!" + trabajador.getNombre() + "¿Que deseas hacer?");
		System.out.println("1. Asignar mesa");
		System.out.println("2. Ver mesas asignadas");
		int opc5 = inp.nextInt();
		
		if (opc5 == 1) {
			ArrayList<Reserva> mTrabajador = Trabajador.getMesasElegir();
			for (Reserva buscarR : mTrabajador) {
				System.out.println("Mesa " + buscarR.getMesa() + " reservada por " + buscarR.getCliente() + " a las " + buscarR.getHora());
				System.out.println("¿Desea atender esta mesa?");
				System.out.println("1. Sí");
				System.out.println("2. No");
				int opc4 = inp.nextInt();
				if (opc4 == 1) {
					trabajador.setAtenderMesa(buscarR);
					Trabajador.addTrabajadoresActivos(trabajador);
					Trabajador.removeMesasElegir(buscarR);
					System.out.println("¡Listo!, se ha indicado que atenderás esta mesa");
					break;
				}
			}
			if(trabajador.getAtenderMesa() == null) {
				System.out.println("Lo sentimos, estas son todas las mesas disponibles hasta el momento");
				}
			
		    }

		if (opc5 == 2) {
			System.out.println("A continuación aparecerán todas las mesas asignadas en pantalla:");
			ArrayList<Trabajador> listaMesas = Trabajador.getTrabajadoresActivos();
			for(Trabajador buscarT : listaMesas) {
				System.out.println("Mesa " + buscarT.getAtenderMesa() + " de " + buscarT.getNombre());
			    }  	
	        }
		}
	
	else {
		System.out.println("Lo sentimos, no encontramos ningún trabajador con los datos introducidos");
		}


		Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
		Serializar.serializarMesasElegir(Trabajador.mesasElegir);


}
public static void visualizarSueldo() {
	Scanner inp = new Scanner(System.in);

	Trabajador trabajador = null;
	System.out.println("Para comenzar, ingrese su nombre:");
	String spc1 = inp.nextLine();
	System.out.println("ingrese su numero de identificación:");
	int spc2 = inp.nextInt();
	ArrayList<Trabajador> lista = Trabajador.getTrabajadoresActivos();
	for (Trabajador BuscarT : lista) {
		if(BuscarT.getNombre() == spc1) {
			if(BuscarT.getId() == spc2) {
				trabajador = BuscarT;
				break;
			}
		}
	}

	if (trabajador != null) {
		DecimalFormat formato = new DecimalFormat("$#,###,###");
		String sueldo = formato.format(trabajador.getSueldo());
		System.out.println("¡Bienvenido! " + trabajador.getNombre() + "! Su sueldo es de: " + sueldo);
		}
	
	else {
		System.out.println("Lo sentimos, no encontramos ningún trabajador con los datos introducidos");
		}

		Serializar.serializarMesasElegir(Trabajador.mesasElegir);
		Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
}

	
	 //CLIENTE
//RESERVA
public static void hacerReserva() {
	Scanner inp = new Scanner(System.in);
	System.out.println("Para comenzar, ingrese su nombre");
	String a1 = inp.nextLine();
	System.out.println("ingrese su numero de identificación");
	int a2 = inp.nextInt();

	Cliente clienteNow = new Cliente (a1,a2);

	//IMPLEMENTAR LA BIENVENIDA A MIEMBROS
	System.out.println("Escoja la sede en la que quiera reservar");

	System.out.println("1. Bello");
	System.out.println("2. Envigado");
	System.out.println("3. San Javier");
	
	int sede = inp.nextInt()-1;
	String Isede = Reserva.devolverSede(sede);

	System.out.println("Ingrese la cantidad de personas[2-4]");
	int cantidad = inp.nextInt();
	ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidad);

	System.out.println("Ingrese la hora en la que quiere reservar [6pm-12pm]");
	int hora = inp.nextInt();

	ArrayList<Mesa> mesasF = Reserva.validarHorarioDisponible(mesasRequeridas, hora);
	
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
		Factura facturaNow = new Factura(reservaDone);
		System.out.println("Desea visualizar su factura");
		System.out.println("1. Si");
		System.out.println("2. No");
		int decs = inp.nextInt();
		if (decs == 1){
			System.out.println(facturaNow.toString());
		}
		
	} else {
		System.out.println("Sentimos que no desee finalizar su reserva "  + clienteNow.getNombre() +", lo esperamos en una nueva ocasion. ");
	}

	Serializar.serializarReservas(Reserva.reservasHechas);
	Serializar.serializarMesas(Mesa.mesasDisponibles);
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);
	inp.close();
}

//REPROGRAMAR
public static void hacerReprogramacion(){
	Scanner inp = new Scanner(System.in);
	System.out.println("Ingrese el ID de su reserva:");
	String id = inp.nextLine();

	Factura facturaNow = Factura.buscarFactura(Pago.getFacturasPagas(), id);
	if (facturaNow == null){
		System.out.println("Lo sentimos, pero no se puede reprogramar una factura ya pagada");
	} 
	facturaNow = Factura.buscarFactura(Pago.getFacturasPendientes(), id);
	if (facturaNow == null){
		System.out.println("Lo sentimos, no hemos encontrado ninguna factura con la ID proporcionada");
	} else {
		System.out.println("Su factura ha sido encontrada");
		System.out.println("Escoja la sede en la que quiera reservar");

		System.out.println("1. Bello");
		System.out.println("2. Envigado");
		System.out.println("3. San Javier");
	
		int sede = inp.nextInt()-1;
		String Isede = Reserva.devolverSede(sede);
		System.out.println("Ingrese la nueva cantidad de personas[2-4]:");
		int cantidadR = inp.nextInt();
		ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidadR);

		System.out.println("Ingrese la hora en la que quiere reservar [6pm-12pm]");
		int hora = inp.nextInt();

		ArrayList<Mesa> mesasF = Reserva.validarHorarioDisponible(mesasRequeridas, hora);
	
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
		int mesaElegidaR = inp.nextInt();
		Mesa mesaEl = mesasF.get(mesaElegidaR-1);
			System.out.println("¿Está seguro/a de reprogramar su reserva y cambiar sus parámetros?");
			System.out.println("1. Si");
			System.out.println("2. No");
			int confirmacion = inp.nextInt();
			if(confirmacion == 1) {
			facturaNow.getReserva().cambiarParametros(hora, mesaEl);
			System.out.println("Su reserva ha sido actualizada, lo esperamos en una nueva ocasión.");      
		}
	}
	System.out.println(Pago.getFacturasPendientes());
	
}

	//PAGO
public static void procederPago(){
	Scanner inp = new Scanner(System.in);
	System.out.println("¿Que deseas hacer?");
	System.out.println("1. Pagar");
	System.out.println("2. Reembolsar");
	
	int sel = inp.nextInt();
	switch (sel) {

		case 1:
		Scanner inp2 = new Scanner(System.in);
		System.out.println("Ingrese la ID de su reserva");
		String id = inp2.nextLine();
		Factura facturaNow = Factura.buscarFactura(Pago.getFacturasPagas(), id);
		if (facturaNow != null){
			System.out.println("La factura " +facturaNow.getIDReserva()+ " ya ha sido pagada");
			System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaNow);
			break;
		}

		facturaNow = Factura.buscarFactura(Pago.getFacturasPendientes(), id);

		if(facturaNow == null){
			System.out.println("No se ha encontrado ninguna factura con la ID: " +id);
		} else {
			System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaNow);
			System.out.println("¿Desea cancelar el monto de la factura?"); 			
			System.out.println("1. Sí");
			System.out.println("2. No");
			
			int opc = inp.nextInt();
			if (opc == 1){
				System.out.println("Cuál será su método de pago:");
			    System.out.println("1. En línea");
		    	System.out.println("2. Efectivo");	    
		        int opc1 = inp.nextInt();
				if (opc1 == 1){
					System.out.println("Ingrese el saldo de su tarjeta");
					int saldo = inp.nextInt();
					Cliente.pagoEnLinea(facturaNow, saldo);
				}
				else{
					Cliente.PagoEfectivo(facturaNow);
				}
			}	else	{
				System.out.println("Ya que no fue posible realizar el pago de la reserva #" + facturaNow.getIDReserva() + " aún no podremos confirmar su reserva");
			}
			break;
		}
		case 2: //REEMBOLSO
		Scanner inp3 = new Scanner(System.in);
		System.out.println("Ingrese la ID de su reserva");
		String id2 = inp3.nextLine();
		Factura facturaNow2 = Factura.buscarFactura(Pago.getFacturasPendientes(), id2);
		if (facturaNow2 != null){
			System.out.println("La factura " +facturaNow2.getIDReserva()+ " no ha sido pagada, por tanto, no se puede reembolsar");
			System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaNow2);
			break;
		} 
		facturaNow2 = Factura.buscarFactura(Pago.getFacturasPagas(), id2);
		if (facturaNow2 == null){
			System.out.println("No se ha encontrado ninguna factura con la ID: " +id2);
		} else {
			Pago.removePaga(facturaNow2);
			System.out.println("La factura " + id2 + " ha sido reembolsada a su tarjeta usada para el pago");
	            		    
	            		    System.out.println("Para finalizar cuentanos cuál fue el motivo de su reembolso");
	    		    		System.out.println("1. Problemas con el horario");
	    		    		System.out.println("2. Problemas con nuestro servicio");
	    		    		System.out.println("3. Dificultades con el precio y/o medio de pago");
	    		    		System.out.println("4. Otro (especificar)");
	    		    		int opc2 = inp.nextInt();
	    		    		
	    		    		switch(opc2) {
	    		    		case 1, 2, 3:
	    		    			System.out.println("Lamentamos las molestias causadas, intentaremos solucionar su problema lo más rápido posible");
	    		    		break;
	    		    		
	    		    		case 4:
	    		    			System.out.println("Dinos cual fue su problema");
	    		    			String problema = inp.next();
	    		    			System.out.println("Gracias por notificarnos, haremos lo posible para solucionar su problema lo más rápido posible");
	    		    		}
	    		    		
	     			        break;        		
		}

	}
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);

}

	
	public static void membresias() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de membresía ¿Qué desea hacer?");
        System.out.println("1. Ingresar membresía");
        System.out.println("2. Cancelar membresía");
        System.out.println("3. Verificar membresía");
        int acc = in.nextInt();

        switch(acc){
            case 1:
                Scanner input = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su numero de identificacion");
                String nvom1 = input.nextLine();
                int nvom2 = input.nextInt();
                Cliente clienteNuevoMiembro = new Cliente(nvom1, nvom2);
				String nombreClienteN = clienteNuevoMiembro.getNombre();
				int idAgregar = clienteNuevoMiembro.getId();
                Membresia.agregarMiembro(nombreClienteN, idAgregar, clienteNuevoMiembro);
                break;
            case 2:
                Scanner i = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su numero de identificacion");
                String elim1 = i.nextLine();
                int elim2 = i.nextInt();
                Cliente clienteEliminar = new Cliente(elim1, elim2);
                String nombreCliente = clienteEliminar.getNombre();
				int ideliminar = clienteEliminar.getId();
                Membresia.cancelarMiembro(nombreCliente, ideliminar ,clienteEliminar);
                break;
            case 3:
                Scanner a = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su numero de identificacion");
                String verif1 = a.nextLine();
                int verif2 = a.nextInt();
                Cliente clienteVerificar = new Cliente(verif1, verif2);
                String nombreVerificar = clienteVerificar.getNombre();
				int idverificar = clienteVerificar.getId();
                Membresia.verificarMiembro(nombreVerificar, idverificar, clienteVerificar);
                break;
          }
		  Serializar.serializarMiembros(Cliente.miembrosActuales);
    }
}