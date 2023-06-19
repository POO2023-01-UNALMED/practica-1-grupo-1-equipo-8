from gestorAplicación.clasesHeredadas import Trabajador,Cliente
import gestorAplicación.clasesPrincipales

class Reserva:

    reservasHechas = []

    #Constructor
    def __init__(self,hora,cliente,mesa):
        self._hora = hora
        self._cliente = cliente
        self._mesa = mesa
        self._IdR = hora+"-"+mesa.getId()
        Reserva.reservasHechas.append(self)
        Trabajador.addMesasElegir(self)


    #Getters
    @classmethod
    def getReservasHechas():
        return Reserva.reservasHechas
    
    def getHora(self):
        return self._hora
    
    def getCliente(self):
        return self._cliente
    
    def getMesa(self):
        return self._mesa
    
    def getIdR(self):
        return self._IdR
    
    #Setters
    def setCliente(self,cliente):
        self.cliente = cliente

    def setMesa(self, mesa):
        self.mesa = mesa

    def setHora(self, hora):
        self.hora = hora
    
    def __Str__(self):
        return "Cliente: " + self._cliente + ", mesa: " + self._mesa + ", hora: " + self._hora + ", reservaID: " + self._IdR
    
    #Recibe una lista de mesas y revisa si estan disponibles en cierto horario
    @classmethod
    def validarHorarioDisponible(mesas,hora):
        mesasReservadas = []
        for m in mesas:
            for r in Reserva.reservasHechas:
                if r.getIdR().trim() == (hora+"-"+m.getId()):
                    mesasReservadas.append(m)
        for i in mesasReservadas:
            mesas.pop(i)
        return mesas

    
    def cambiarParametros(self, hora, mesa):
        self.hora = hora
        self.mesa = mesa
        self.IdR = hora+"-"+mesa.getId()

    @classmethod
    def buscarReserva(id):
        for r in Reserva.reservasHechas:
            if (r.getIdR().trim() == id):
                return r
        return None