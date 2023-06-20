from src.gestorAplicación.clasesMain import *
from tkinter import messagebox

class Cliente(Persona):
    miembrosActuales = []
    def __init__(self, id, nombre="N/N"):
        super().__init__(nombre, id)
        self._membresia = self.getMembresia()

    # Get
    @classmethod
    def getMiembrosActuales(cls):
        return cls.miembrosActuales
    def getMembresia(self):
        if self not in Cliente.miembrosActuales:
            return None
        else:
            return self._membresia

    def getTipodeMiembro(self):
        return self._membresia.getTipo()

    def getActividad(self):
        return self._membresia.esActiva()
    def getNombre(self):
        return super().getNombre()

    def getId(self):
        return super().getId()

    # Set
    def setMembresia(self, membresia):
        self._membresia = membresia

    # ToString
    def __str__(self):
        return "{} {}".format(self.getNombre, self.getId)

    # Ligadura dinámica (Override)
    def accion(self, facturaNow, saldo):
        if saldo >= facturaNow.getPrecio():
            Pago.removePendiente(facturaNow)
            Pago.addFacturasPagas(facturaNow)
            Trabajador.removeMesasElegir(facturaNow.getReserva())
            pagado = Pago(facturaNow, "línea")
            return True
        else:
            return False

    # Otros métodos
    @classmethod
    def pagoEnEfectivo(facturaNow):
        print("Haga su pago en caja al llegar a la sede {}".format(facturaNow.getSede()))
        Pago.removePendiente(facturaNow)
        Pago.addFacturasPagas(facturaNow)
        Trabajador.removeMesasElegir(facturaNow.getReserva())
        pagado = Pago(facturaNow, "Efectivo")

    @classmethod
    def validarDatosCliente(cls, nombre, id):
        try:
            id = int(id)
            return Cliente(nombre, id)
        except ValueError:
            return None

    @classmethod
    def datosVacios(cls, datos):
        from src.Errores.ExceptionC1 import campoVacio
        for i in datos:
            if i == "":
                raise campoVacio(i)

class Trabajador(Persona):
    _mesasAtendidas = []
    trabajadoresActivos = []
    mesasElegir = []

    def __init__(self, id, horario, nombre="N/N"):
        super().__init__(nombre, id)
        self._horario = horario

    # Métodos get
    @classmethod
    def getTrabajadoresActivos(cls):
        return Trabajador.trabajadoresActivos

    @classmethod
    def getMesasElegir(cls):
        return Trabajador.mesasElegir

    @classmethod
    def getMesasAtendidas(cls):
        return Trabajador._mesasAtendidas

    def getSueldo(self):
        return self._sueldo

    # Otros métodos
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

    # Método ToString
    def __str__(self):
        return self.getNombre() + self.getId() + self._horario

    # Sobreescritura de método (Override)
    def accion(self, facturaNow, sueldo):
        reserva = facturaNow.getReserva()
        Trabajador.addMesasAtendidas(reserva)

        sueldoFactura = facturaNow.getPrecio()
        self._sueldo += sueldoFactura / 2
        return True


