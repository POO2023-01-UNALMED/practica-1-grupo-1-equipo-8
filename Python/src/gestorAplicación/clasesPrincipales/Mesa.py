import gestorAplicación.clasesPrincipales

class Mesa:

    mesasDisponibles = []

    #Constructor
    def __init__(self,sede,numero,capacidad) :
        self._idMesa = sede +numero+"-"+capacidad
        self._capacidad = capacidad
        self._sede = sede
        Mesa.mesasDisponibles.append(self)

    #Getters
    def getId(self):
        return self._idMesa
    
    def getCapacidad(self):
        return self._capacidad
    
    def getSede(self):
        return self._sede
    
    #Metodo toString
    def toString(self):
        return "Mesa: " + self._idMesa + ", Capacidad: " + self._capacidad
    
    #Busca una mesa con las caracteristicas dadas
    @classmethod
    def buscarMesas(Isede, capacidad):
        mesasEsp = []
        for m in Mesa.mesasDisponibles:
            if m.getSede() == Isede and m.getCapacidad() == capacidad:
                mesasEsp.append(m)
        return mesasEsp
    
    
