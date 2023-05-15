package uiMain;
import java.util.Scanner;
import java.util.ArrayList;
import gestorAplicación.clasesPrincipales.*;
import baseDatos.Deserializar;
import baseDatos.Serializar;

public class ui {

    public static void main(String[] args) {

		//Deserializar
		Cliente.miembrosActuales = Deserializar.deserializarMiembros();
		Reserva.reservasHechas = Deserializar.deserializarReservas();
		Mesa.mesasDisponibles = Deserializar.deserializarMesas();
		Pago.facturasPagas = Deserializar.deserializarFacurasPagas();
		Pago.facturasPendientes = Deserializar.deserializarFacurasPendientes();

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
        Reserva re2 = new Reserva(6, cli3, me11);

        System.out.println(" ---------------------------------------------");
        System.out.println("|Bienvenido a RestauranteUN, escoja su opción:|");
        System.out.println("|	   1. Reservar                        |"); // Jonhatan
        System.out.println("|	   2. Reprogramar	              |"); // Pedro
        System.out.println("|	   3. Cancelar                        |");
        System.out.println("|	   4. Pagar                           |");// Daniel
        System.out.println("|	   5. Obtener membresía               |");// Manuel
        System.out.println("|	   6. Salir                           |");                             
        System.out.println(" ---------------------------------------------");
        System.out.println("Opción:");
        int opc = inp.nextInt();
        
        switch(opc){
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
	
	for (Mesa m : mesasRequeridas) {
		m.setDisponibilidad(Reserva.validarHorarioDisponible(hora, m));
		}

		System.out.println(mesasRequeridas);
		System.out.println(Reserva.reservasHechas);
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
		Factura facturaNow = new Factura(reservaDone);
		facturaNow.escribirFactura();
		System.out.println("Desea visualizar su factura");
		System.out.println("1. Si");
		System.out.println("2. No");
		int decs = inp.nextInt();
		if (decs == 1){
			System.out.println(facturaNow.mostrarFactura());
		}
		
	} else {
		System.out.println("Sentimos que no desee finalizar su reserva "  + clienteNow.getNombre() +", lo esperamos en una nueva ocasion. ");
	}
	Serializar.serializarReservas(Reserva.reservasHechas);
	Serializar.serializarMesas(Mesa.mesasDisponibles);
	Serializar.serializarFacturasPagas(Pago.facturasPagas);
	Serializar.serializarFacturasPendientes(Pago.facturasPendientes);
}

//REPROGRAMAR
	public static void hacerReprogramacion() {
		Scanner inp = new Scanner(System.in);
		System.out.println("Ingrese la ID de su reserva:");
        int b2 = inp.nextInt();
        
        	System.out.println("Escoja la sede en la que quiera reprogramar su reserva:");
            System.out.println("1. Bello");
            System.out.println("2. Envigado");
            System.out.println("3. San Javier");
            int sedeR = inp.nextInt();
            String Isede = "";
            
            if (sedeR == 1) {
            	Isede = "B";
            } else if (sedeR == 2) {
            	Isede = "E";
            } else if (sedeR == 3) {
            	Isede = "SJ";
            }
            System.out.println("Ingrese la nueva cantidad de personas[2-4]:");
            int cantidadR = inp.nextInt();
            ArrayList<Mesa> mesasRequeridas = Mesa.buscarMesas(Isede, cantidadR);
            
            System.out.println("Ingrese la hora en la que quiere reprogramar su reserva [6pm-12pm].(escriba solo el numero): ");
            int horaR = inp.nextInt();
            
            for (Mesa m : mesasRequeridas) {
            	m.setDisponibilidad(Reserva.validarHorarioDisponible(horaR, m));
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
                System.out.println("Escoga una de las mesas disponibles:");
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
            System.out.println("Su reserva ha sido actualizada, lo esperamos en una nueva ocasión.");       
        }
            else {
            	System.out.println("Sentimos que no desee finalizar su reprogamacion de reserva, lo esperamos en una nueva ocasión.");
            }
		Serializar.serializarReservas(Reserva.reservasHechas);
		Serializar.serializarMesas(Mesa.mesasDisponibles);
		Serializar.serializarFacturasPagas(Pago.facturasPagas);
		Serializar.serializarFacturasPendientes(Pago.facturasPendientes);
	}
	
	//PAGO
	public static void procederPago() {
		
		Scanner inp = new Scanner(System.in);
		
		System.out.println("¿Que deseas hacer?");
		System.out.println("1. Pagar");
    	System.out.println("2. Reembolsar");
		
		int sel = inp.nextInt();
		
		switch(sel) {
		    case 1: //PAGAR
				System.out.println("¿Ya tienes la factura de tu reserva?");
				System.out.println("1. Sí");
		    	System.out.println("2. No");
		    	
		    	
		    	int select = inp.nextInt();
		    	
		    	System.out.println("Ingrese el id de su reserva");
		    	int id = inp.nextInt();
		    	
		    	Factura facturaCliente = null;
		    	
		    	
		    	switch(select){
		            case 1:
		            	ArrayList<Factura> lista = Pago.getFacturasPendientes();
		            	boolean encontrado = false;
		            	for (Factura buscarFactura : lista) {
		            		
		            		if(buscarFactura.getIDReserva() == id) {
		            			facturaCliente = buscarFactura;
		            			encontrado = true;
		            		    System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaCliente.getFacturaHecha());
		     			        break;        		
		    	            }
		    	        }
		            	
		    	        if(encontrado == false) {		    	
		    	        	ArrayList<Factura> lista1 = Pago.getFacturasPagas();
		    	        	for (Factura buscarFactura : lista1) {
		    	        		
		    	        		if(buscarFactura.getIDReserva() == id) {
		    	        			encontrado = true;
			            		    System.out.println("La reserva ya fue pagada");
			     			        break;  
			     			        }
		    	        		}
		    	        	if(encontrado == false) {
		    	        		System.out.println("No se ha generado ninguna factura con el id introducido");
		    	        	}
		    	        }
		    	        break;
		    	        
		            case 2:
		            	ArrayList<Reserva> lista2 = Reserva.getReservasHechas();
		            	encontrado = false;
		    	        for (Reserva buscarReserva : lista2) {  	    
		    		        if (buscarReserva.getIdR() == id) {
		    			        encontrado = true;
		    			        facturaCliente = new Factura(buscarReserva);
		    			        facturaCliente.escribirFactura();
		    			        Pago.addFacturasPendientes(facturaCliente);
		    			        System.out.println("A continuación podrás ver tu factura en pantalla "+ "\n" + facturaCliente.getFacturaHecha());
		    			        break;
		    		        }
		    	        }
		    	        
		    	        if(encontrado == false) {
		    				System.out.println("El id introducido no concuerda con ninguno en nuestra lista");
		            }
		    	}

		    	if(facturaCliente != null) {
		    		System.out.println("¿Desea cancelar el monto de la factura?"); 			
			    	System.out.println("1. Sí");
			    	System.out.println("2. No");
			    	
			    	int opc = inp.nextInt();
			    	
			    	    switch(opc){
			            case 1:
			        	    System.out.println("Cuál será su método de pago:");
			        	    System.out.println("1. En línea");
		    	    	    System.out.println("2. Efectivo");
		    	    	    
		           	        int opc1 = inp.nextInt();
		            	    
		        	        switch(opc1){
		    	            case 1:
		    	        	    System.out.println("Ingrese el saldo de su tarjeta:");
		    	        	    int saldo = inp.nextInt();
		    	        	    
		    	        	    if(saldo >= facturaCliente.getPrecio()) {
		    	        		    System.out.println("Su pago ha sido registrado");
		    	        		    Pago.removePendiente(facturaCliente);
		    	        		    Pago.addFacturasPagas(facturaCliente);
		    	        	    }
		    	        	    
		    	        	    else {
		    	        		    System.out.println("Su saldo no es suficiente, aún no podremos confirmar su reserva");
		    	        	    }
		    	        	    break;
		    	            case 2:
		        	    	    System.out.println("Haga su pago en caja al llegar a la sede " + facturaCliente.getSede());
		        	    	    Pago.removePendiente(facturaCliente);
		        	    	    Pago.addFacturasPagas(facturaCliente);	    
		    	            }		   
		        	        break;
			            case 2:
			                System.out.println("Ya que no fue posible realizar el pago de la reserva #" + facturaCliente.getIDReserva()
			                + " aún no podremos confirmar su reserva");
			    	    }    
				}
		    	break;	    	
		    	case 2:  //REEMBOLSO
		    		
		    		System.out.println("Ingrese el id de su reserva");
			    	int idr = inp.nextInt();
			    	
			    	boolean encontrado = false;
	            	for (Factura buscarFactura : Pago.getFacturasPagas()) {
	            		
	            		if(buscarFactura.getIDReserva() == idr) {
	            			encontrado = true;
	            			Pago.removePaga(buscarFactura);
	            		    System.out.println("La factura " + idr + " ha sido reembolsada a su tarjeta usada para el pago");
	            		    
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
	            	
	    	        if(encontrado == false) {
	    				System.out.println("El reembolso de su reserva no fue posible ya que no se ha efectuado ningún pago");
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