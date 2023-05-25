  package uiMain;
import java.util.Scanner;
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
		inp.close();
	}
	
	public static void RegresarC(){
		Scanner ret6 = new Scanner(System.in);
			System.out.println("Desea volver al menú de Cliente? (1: si, 2: no)");
				int conf = ret6.nextInt();
				if (conf == 1){
					menuCliente();
				} else{
					System.out.println("Fin del programa");
				}
			ret6.close();
	}

	public static void RegresarT(){
		Scanner ret6 = new Scanner(System.in);
			System.out.println("Desea volver al menú de Trabajador? (1: si, 2: no)");
				int conf = ret6.nextInt();
				if (conf == 1){
					menuTrabajador();
				} else{
					System.out.println("Fin del programa");
				}
			ret6.close();
	}

        //Se despliega el menú de cliente
	public static  void menuCliente(){
		Scanner inp = new Scanner(System.in);
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("|Bienvenido al apartado Cliente de RestauranteUN, escoja su opción:|");
        System.out.println("|                        1. Reservar                               |");
        System.out.println("|                        2. Reprogramar                            |");
        System.out.println("|                        3. Pagar                                  |");
        System.out.println("|                        4. Obtener membresía                      |");
        System.out.println("|                        5. Salir                                  |");
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
            case 3:
               	 procederPago();
               	 break;
			case 4:
				membresias();
				break;
            case 5:
            	System.out.println("Muchas gracias por su visita vuelva pronto.");
            	break;
   		 }
		 inp.close();
	}

	//Se despliega el menú de trabajador
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
		inp.close();
	 }
	 
	 //TRABAJADOR
	 //Ingresar al trabajo
    public static void ingresarTrabajo() {
	Scanner inp = new Scanner(System.in);
	System.out.println("Ingrese su nombre");
	String na = inp.nextLine();
	System.out.println("Ingrese su número de identificación");
	int na1 = inp.nextInt();
	//Se crea un trabajador y se añade en trabajadores activos
	Trabajador trabajador = new Trabajador(na, na1, "6pm-12pm");
	Trabajador.addTrabajadoresActivos(trabajador);
	System.out.println("¡Listo! Ahora eres un trabajador de RestauranteUN");
	RegresarT();

	Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
	Serializar.serializarMesasElegir(Trabajador.mesasElegir);
	inp.close();
	}
	 
//Asignar mesa
public static void asignarMesa() {
	Scanner inp = new Scanner(System.in);

	System.out.println("ingrese su ID de trabajador:");
	//Buscar el trabajador por su ID
	int spc2 = inp.nextInt();
	Trabajador trabajador = Persona.buscarTrabajador(spc2);
	if (trabajador	== null){
		System.out.println("No hemos encontrado ningun trabajador con esta ID");
		return;
	}
	if (trabajador != null) { //Si hay un trabajador con el ID introducido
		System.out.println("¡Bienvenido! " + trabajador.getNombre() + " ¿Que deseas hacer?");
		System.out.println("1. Asignar mesa");
		System.out.println("2. Ver mesas asignadas");
		int opc5 = inp.nextInt();
		
		//Asignar mesa
		if (opc5 == 1) { 
			if (Trabajador.mesasElegir.size() == 0){
				System.out.println("Lo sentimos, no hay mesas disponibles en este momento, espere a nuevas reservas");
				RegresarT();
				return;
			}

			//Se muestran todas las mesas sin un trabajador establecido
			System.out.println("Se mostrarán las mesas reservadas, escoja la que desee atender");
			int c = 1;
			for (Reserva r : Trabajador.mesasElegir){
				System.out.println(c + ". "+ r.getIdR() + "Hora: " + r.getHora());
				c++;
			}
			System.out.println("Escoja una");
			int opc6 = inp.nextInt();
			Reserva buscarR = Trabajador.mesasElegir.get(opc6-1);
			Factura facturaNow = Factura.buscarFactura(Pago.getFacturasPendientes(), buscarR.getIdR());
			Trabajador.removeMesasElegir(buscarR);
			trabajador.accion(facturaNow, trabajador.getSueldo());

			System.out.println("¡Listo!, se ha indicado que atenderás esta mesa");
			RegresarT();
		}
		//Ver mesas asignadas
		if (opc5 == 2) {
			System.out.println("A continuación aparecerán todas las mesas asignadas en pantalla:");
			for (Trabajador t : Trabajador.trabajadoresActivos){
				System.out.println(t);
				int c = 1;
				for (Reserva r : t.getMesasAtendidas()){
					System.out.println(c+". "+r);
					c++;
				}
			}
		}

		Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
		Serializar.serializarMesasElegir(Trabajador.mesasElegir);
	}


}
//Visualizar sueldo actual
public static void visualizarSueldo() {
	Scanner inp = new Scanner(System.in);

	System.out.println("ingrese su ID de trabajador:");
	int spc2 = inp.nextInt();
	//Buscar el trabajador por su ID
	Trabajador trabajador = Persona.buscarTrabajador(spc2);

    //Muestra el sueldo del trabajador en formato de pesos
	inp.close();
	if (trabajador != null) {
		DecimalFormat formato = new DecimalFormat("$#,###,###");
		String sueldo = formato.format(trabajador.getSueldo());
		System.out.println("¡Bienvenido! " + trabajador.getNombre() + "! Su sueldo es de: " + sueldo);
		}
	
	else {
		System.out.println("Lo sentimos, no encontramos ningún trabajador con los datos introducidos");
		RegresarT();
			return;
		}
		Serializar.serializarMesasElegir(Trabajador.mesasElegir);
		Serializar.serializarTrabajadoresActivos(Trabajador.trabajadoresActivos);
}

//CLIENTE

// Funcionalidades implementadas
// Reservar
public static void hacerReserva() {
	Scanner inp = new Scanner(System.in);
	System.out.println("Para comenzar, ingrese su nombre");
	String a1 = inp.nextLine();
	System.out.println("ingrese su numero de identificación");
	int a2 = inp.nextInt();

    //Se crea un cliente con los datos de entrada
	Cliente clienteNow = new Cliente (a1,a2);

	System.out.println("Escoja la sede en la que quiera reservar");

	System.out.println("1. Bello");
	System.out.println("2. Envigado");
	System.out.println("3. San Javier");
    //Busca una mesa con todas las características requeridas
	int sede = inp.nextInt()-1;
	String Isede = Reserva.devolverSede(sede);

	System.out.println("Ingrese la cantidad de personas[2-4]");
	int cantidad = inp.nextInt();
	ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidad);

	System.out.println("Ingrese la hora en la que quiere reservar [6pm-12pm]");
	int hora = inp.nextInt();
	ArrayList<Mesa> mesasF = Reserva.validarHorarioDisponible(mesasRequeridas, hora);
	
	if (mesasF.size() == 0 ){ //Si no hay mesas disponibles
		System.out.println("Lo sentimos, pero no hay disponibilidad de mesas con estas caracteristicas");
		RegresarC();
		} else {
		System.out.println("Escoja una de las mesas que se mostrarán a continuación");
		int c = 1;
		//Imprime el toString de todas las mesas disponibles de mesasF
		for (Mesa mesa : mesasF){
			if (mesa.getDisponibilidad()) {
			System.out.println(c + ". "+ mesa.toString());
			c++;
			}
		}
	}

	//Se crea la reserva
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
			//Imprime la factura de la reserva creada
			System.out.println(facturaNow.toString());
		}
		RegresarC();
		
	} else {
		System.out.println("Sentimos que no desee finalizar su reserva "  + clienteNow.getNombre() +", lo esperamos en una nueva ocasion. ");
		RegresarC();
	}

	Serializar.serializarReservas(Reserva.reservasHechas);
	Serializar.serializarMesas(Mesa.mesasDisponibles);
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);
	Serializar.serializarMesasElegir(Trabajador.mesasElegir);
	inp.close();
}

// Funcionalidades implementadas
// Reprogramar

public static void hacerReprogramacion(){
	Scanner inp = new Scanner(System.in);
	System.out.println("Ingrese el ID de su reserva:");
	String id = inp.nextLine();

	Factura facturaNow = Factura.buscarFactura(Pago.getFacturasPagas(), id);
	//Factura ya pagada
	if (facturaNow != null){
		System.out.println("Lo sentimos, pero no se puede reprogramar una factura ya pagada");
		RegresarC();
		return;
	} 
	facturaNow = Factura.buscarFactura(Pago.getFacturasPendientes(), id);
	//Ninguna factura con esta ID
	if (facturaNow == null){
		System.out.println("Lo sentimos, no hemos encontrado ninguna factura con la ID proporcionada");
		RegresarC();
	//Factura pendiente de pago	
	} else {
		System.out.println("Su factura ha sido encontrada");
		System.out.println("Escoja la sede en la que quiera reservar");

		System.out.println("1. Bello");
		System.out.println("2. Envigado");
		System.out.println("3. San Javier");
	    //Busca una mesa con todas las características requeridas
		int sede = inp.nextInt()-1;
		String Isede = Reserva.devolverSede(sede);
		System.out.println("Ingrese la nueva cantidad de personas[2-4]:");
		int cantidadR = inp.nextInt();
		ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidadR);

		System.out.println("Ingrese la hora en la que quiere reservar [6pm-12pm]");
		int hora = inp.nextInt();

		ArrayList<Mesa> mesasF = Reserva.validarHorarioDisponible(mesasRequeridas, hora);
	
		if (mesasF.size() == 0 ){ //Si no hay mesas disponibles
			System.out.println("Lo sentimos, pero no hay disponibilidad de mesas con estas caracteristicas");
			RegresarC();
		} else {
			System.out.println("Escoja una de las mesas que se mostrarán a continuación");
			int c = 1;
			//Imprime el método toString de todas las mesas disponibles de mesasF
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
			//se cambia la mesa y la hora de la reserva que se está reprogramando	
			Reserva reEl = Reserva.buscarReserva(id);
			reEl.cambiarParametros(hora, mesaEl);
			facturaNow.actualizarFactura(reEl);
			System.out.println("Su reserva ha sido actualizada, lo esperamos en una nueva ocasión.");
			RegresarC();      
		}
	}
	System.out.println(Pago.getFacturasPendientes());
	Serializar.serializarReservas(Reserva.reservasHechas);
	Serializar.serializarMesas(Mesa.mesasDisponibles);
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);
	Serializar.serializarMesasElegir(Trabajador.mesasElegir);
	inp.close();
}

// Funcionalidades implementadas
// Pagar

public static void procederPago(){
	Scanner inp = new Scanner(System.in);
	System.out.println("¿Que deseas hacer?");
	System.out.println("1. Pagar");
	System.out.println("2. Reembolsar");
	
	int sel = inp.nextInt();
	switch (sel) {

		case 1: //Pagar
		Scanner inp2 = new Scanner(System.in);
		System.out.println("Ingrese la ID de su reserva");
		String id = inp2.nextLine();
		Factura facturaNow = Factura.buscarFactura(Pago.getFacturasPagas(), id);
		 //Caso en que la factura ya fue pagada
		if (facturaNow != null){
			System.out.println("La factura " +facturaNow.getIDReserva()+ " ya ha sido pagada");
			System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaNow);
			RegresarC();
			break;
		}
		facturaNow = Factura.buscarFactura(Pago.getFacturasPendientes(), id);
		//Ninguna factura que tenga este Id
		if(facturaNow == null){ 
			System.out.println("No se ha encontrado ninguna factura con la ID: " +id);
			RegresarC();
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
					Cliente cliente = facturaNow.getClienteFactura();
					//Revisa si el saldo es suficiente y cambia la factura a facturasPagas, se crea un objeto de Pago en linea
						if (cliente.accion(facturaNow, saldo)){
							System.out.println("Su reserva ha sido pagada");
						} else {
							System.out.println("Su saldo no es suficiente, aún no podremos confirmar su reserva");
						}
				}
				else{
					//cambia la factura a facturasPagas, se crea un objeto de Pago en efectivo
					Cliente.pagoEnEfectivo(facturaNow);
				}
			}	else	{
				System.out.println("Ya que no fue posible realizar el pago de la reserva #" + facturaNow.getIDReserva() + " aún no podremos confirmar su reserva");
				RegresarC();
			}
			break;
		}
		//Reembolso
		case 2:
		Scanner inp3 = new Scanner(System.in);
		System.out.println("Ingrese la ID de su reserva");
		String id2 = inp3.nextLine();
		//Busca la factura que concuerde con la ID
		Factura facturaNow2 = Factura.buscarFactura(Pago.getFacturasPendientes(), id2);
		if (facturaNow2 != null){
			System.out.println("La factura " +facturaNow2.getIDReserva()+ " no ha sido pagada, por tanto, no se puede reembolsar");
			System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaNow2);
			RegresarC();
			break;
		} 
		facturaNow2 = Factura.buscarFactura(Pago.getFacturasPagas(), id2);
		if (facturaNow2 == null){ 
			System.out.println("No se ha encontrado ninguna factura con la ID: " +id2);
			RegresarC();
		} else {
			Pago.removePaga(facturaNow2); //Elimina la factura de facturasPagas
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
	    	RegresarC();    		
	     		break;        		
		}

	}
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);

}

// Funcionalidades implementadas
// Obtener membresia
	
	public static void membresias() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de membresía ¿Qué desea hacer?");
        System.out.println("1. Ingresar membresía");
        System.out.println("2. Cancelar membresía");
        System.out.println("3. Verificar membresía");
        int acc = in.nextInt();
        switch (acc) {

			//Hacer parte de la membresía
			
            case 1:
                Scanner input = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su número de identificación");
                String nvom1 = input.nextLine();
                int nvom2 = input.nextInt();
                Cliente clienteNuevoMiembro = new Cliente(nvom1, nvom2);
                String nombreClienteN = clienteNuevoMiembro.getNombre();
                int idAgregar = clienteNuevoMiembro.getId();
                if (Membresia.agregarMiembro(nombreClienteN, idAgregar, clienteNuevoMiembro)) {
                    System.out.println("El cliente " + nombreClienteN + " con ID " + idAgregar + " hace parte ahora de la lista de miembros.");
					RegresarC();
                } else {
                    System.out.println("El cliente " + nombreClienteN + " ya hace parte de la lista de miembros.");
					RegresarC();
                }
                break;
            case 2:
				
				//Cancelar membresía
				
                Scanner i = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su número de identificación");
                String elim1 = i.nextLine();
                int elim2 = i.nextInt();
                Cliente clienteEliminar = new Cliente(elim1, elim2);
                String nombreCliente = clienteEliminar.getNombre();
                int ideliminar = clienteEliminar.getId();
                if (Membresia.cancelarMiembro(nombreCliente, ideliminar, clienteEliminar)) {
                    System.out.println("El cliente " + nombreCliente + " ha sido eliminado.");
					RegresarC();
                } else {
                    System.out.println("No se encontró el cliente " + nombreCliente + " con ID " + ideliminar + " en la lista de miembros, no es posible eliminarlo.");
					RegresarC();
                }
                break;
            case 3:

				//Verificar si un cliente hace parte de la membresía

                Scanner a = new Scanner(System.in);
                System.out.println("Ingrese su nombre y su número de identificación");
                String verif1 = a.nextLine();
                int verif2 = a.nextInt();
                Cliente clienteVerificar = new Cliente(verif1, verif2);
                String nombreVerificar = clienteVerificar.getNombre();
                int idverificar = clienteVerificar.getId();
                if (Membresia.verificarMiembro(nombreVerificar, idverificar, clienteVerificar)) {
                    System.out.println("El cliente " + nombreVerificar + " hace parte de la lista de miembros.");
					RegresarC();
                } else {
                    System.out.println("No se encontró el cliente " + nombreVerificar + " con ID " + idverificar + " en la lista de miembros.");
					RegresarC();
                }
                break;
        }
        Serializar.serializarMiembros(Cliente.getMiembrosActuales());
    }
}