from gestorAplicación.clasesPrincipales import Membresia, Cliente

class Membresia:

    #Implementación de características de POO

    def __init__(self, tipo: str, activa: bool):
        self.tipo = "Gold"
        self.activa = activa

    #Métodos get

    def getTipo(self):
        return self.tipo
    
    def esActiva(self):
        return self.activa
    
    #Método set

    def setActiva(self, activa: bool):
        self.activa = activa

    @staticmethod
    def verificarMiembro(nombre, id, verificar):
        for cliente in Cliente.getmiembrosActuales():
            if cliente.getNombre() == nombre and cliente.getId() == id:
                return True
            return False
    
    @staticmethod
    def agregarMiembro(nombre, id):
        for cliente in Cliente.getMiembrosActuales():
            if cliente.getNombre() == nombre and cliente.getId() == id:
                return False
        miembro = Cliente(nombre, id)
        membresia = Membresia("Gold", True)
        membresia.setActiva(True)
        Cliente.getMiembrosActuales().append(miembro)
        return True
    
    @staticmethod
    def cancelarMiembro(nombre, idEliminar, eliminar):
        for cliente in Cliente.getMiembrosActuales():
            if cliente.getNombre() == nombre and cliente.getId() == idEliminar:
                cliente.setMembresia(None)
                Cliente.getMiembrosActuales().remove(cliente)
                return True
        return False