from gestorAplicación.clasesPrincipales import Persona

class Trabajador(Persona):
    _mesasAtendidas = []
    trabajadoresActivos = []
    mesasElegir = []

    def __init__(self, id, horario, nombre = "N/N"):
        super().__init__(nombre, id)
        self._horario = horario
    
    #Métodos get
    @classmethod
    def getTrabajadoresActivos():
        return Trabajador.trabajadoresActivos
    
    @classmethod
    def getMesasElegir():
        return Trabajador.mesasElegir
    
    @classmethod
    def getMesasAtendidas():
        return Trabajador._mesasAtendidas
    
    def getSueldo(self):
        return self._sueldo
    
    #Otros métodos
    @classmethod
    def addTrabajadoresActivos(trabajador):
        Trabajador.trabajadoresActivos.append(trabajador)
    
    @classmethod
    def removeTrabajadoresActivos(trabajador):
        Trabajador.trabajadoresActivos.remove(trabajador)
    
    @classmethod
    def addMesasElegir(reserva):
        Trabajador.mesasElegir.append(reserva)
    
    @classmethod
    def removeMesasElegir(reserva):
        Trabajador.mesasElegir.remove(reserva)

    @classmethod
    def addMesasAtendidas(reserva):
        Trabajador.addMesasAtendidas.append(reserva)
    
    #Método ToString
    def __str__(self):
        return self.getNombre() + self.getId() + self._horario

    #Sobreescritura de método (Override) 
    def accion(self, facturaNow, sueldo):
        reserva = facturaNow.getReserva()
        Trabajador.addMesasAtendidas(reserva)

        sueldoFactura = facturaNow.getPrecio()
        self._sueldo += sueldoFactura/2
        return True