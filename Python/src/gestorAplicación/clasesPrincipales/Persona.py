import gestorAplicación.clasesPrincipales
from abc import ABC, abstractclassmethod
from gestorAplicación.clasesHeredadas import Trabajador

class Persona(ABC):
    def __init__(self, nombre, id):
        self._nombre = nombre
        self._id = id

    def getId(self):
        return self._id
    
    def getNombre(self):
        return self._nombre
    

    @abstractclassmethod
    def accion(self, facturaNow, saldo):
        pass

    @staticmethod
    def buscarTrabajador(self,id):
        for t in Trabajador.trabajadoresActivos:
            if id == t.getId():
                return t
        return None