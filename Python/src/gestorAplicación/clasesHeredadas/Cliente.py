from gestorAplicación.clasesPrincipales import Persona, Factura, Membresia, Pago, Persona
from gestorAplicación.clasesHeredadas import Trabajador
import tkinter as tk

class Cliente(Persona):
    miembrosActuales = []

    def __init__(self,id, nombre = "N/N"):
        super().__init__(nombre, id)
        self._membresia = self.getMembresia()

    #gets
    @classmethod
    def getMiembrosActuales():
        return Cliente.miembrosActuales
    
    def getMembresia(self):
        return self._membresia

    def getTipodeMiembro(self):
       return self._membresia.getTipo()

    def getActividad(self):
        return self._membresia.esActiva()

    def getNombre(self):
        return super.getNombre()

    def getId():
        return super.getId()
        
    #Set   
    def setMembresia(self, membresia):
        self._membresia = membresia
          
    #ToString
    def __str__(self):
        return "{} {}" .format(self.getNombre, self.getId)    

    #Ligadura dinámica (Override) 
    def accion(self,facturaNow,saldo):
        if saldo >= facturaNow.getPrecio():
            Pago.removePendiente(facturaNow)
            Pago.addFacturasPagas(facturaNow)
            Trabajador.removeMesasElegir(facturaNow.getReserva())
            pagado = Pago(facturaNow, "línea")
            return True
        else:
           return False
    
    #Otro método
    @classmethod
    def pagoEnEfectivo(facturaNow):
        print("Haga su pago en caja al llegar a la sede {}" .format(facturaNow.getSede()))
        Pago.removePendiente(facturaNow)
        Pago.addFacturasPagas(facturaNow)
        Trabajador.removeMesasElegir(facturaNow.getReserva())
        pagado = Pago(facturaNow, "Efectivo")

    def validarDatosCliente(nombre,id):
            if not isinstance(nombre, str) or len(nombre)==0:
                raise TypeError("El nombre no es válido")
            if not isinstance(id, int):
                raise TypeError("El número de identificación no es válido")
            else:
                return

