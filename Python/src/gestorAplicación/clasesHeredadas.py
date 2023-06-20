from abc import ABC,abstractclassmethod

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


class Mesa:
    cMesas = 0
    mesasDisponibles = []

    # Constructor
    def __init__(self, sede, numero, capacidad):
        self._idMesa = sede + str(numero) + "-" + str(capacidad)
        self._capacidad = capacidad
        self._sede = sede
        Mesa.mesasDisponibles.append(self)

    # Getters
    def getId(self):
        return self._idMesa

    def getCapacidad(self):
        return self._capacidad

    def getSede(self):
        return self._sede

    # Metodo toString
    def toString(self):
        return "Mesa: " + str(self._idMesa) + ", Capacidad: " + str(self._capacidad)

    # Busca una mesa con las caracteristicas dadas
    @classmethod
    def buscarMesas(Isede, capacidad):
        mesasEsp = []
        for m in Mesa.mesasDisponibles:
            if m.getSede() == Isede and m.getCapacidad() == capacidad:
                mesasEsp.append(m)
        return mesasEsp

    @classmethod
    def validarDatosMesa(cls, capacidad, sede, hora):
        from src.Errores.ExceptionC1 import DatoInvalido

        if capacidad > 4 or capacidad < 1:
            raise DatoInvalido("Las mesas de nuestros restaurantes están entre 2 y 4 personas")
        if hora > 10 or hora < 2:
            raise DatoInvalido("A esta hora el restaurante no estará prestando servicio")
        if not sede.lower() in ["envigado", "bello", "san javier"]:
            raise ValueError("La sede no es válida")
        else:
            try:
                global cMesas
                hora = int(hora)
                capacidad = int(capacidad)
                cls.cMesas += 1
                return Mesa(sede, cMesas, capacidad)

            except ValueError:
                return False



class Factura:

    def __init__(self, reserva):
        self._reserva = reserva
        self._cliente = reserva.getCliente()
        self._mesa = reserva.getMesa()
        self._sede = self._mesa.getSede()
        self._id = reserva.getIdR()
        self._membresia = self._cliente.getMembresia()
        self._precio = 100000
        Pago.addFacturasPendientes(self)

    # Métodos get
    def getReserva(self):
        return self._reserva

    def getClienteFactura(self):
        return self._cliente

    def getMesa(self):
        return self._mesa

    # def getFacturaHecha(self):
    #    return self._facturaHecha

    def getPrecio(self):
        return self._precio

    def getSede(self):
        return self._sede

    def getFacturaMiembro(self):
        return self._membresia

    def getIDReserva(self):
        return self._id

    # Métodos set
    def setReserva(self, reserva):
        self._reserva = reserva

    def setPrecio(self, precio):
        self._precio = precio

    # Otros métodos
    @staticmethod
    def buscarFactura(facturas, id):
        for factura in facturas:
            if factura.getReserva().getIdR().strip() == id:
                return factura
        return None

    def clienteEsMiembro(self, cliente):
        from src.gestorAplicación.clasesHeredadas import Cliente
        lista = Cliente.getMiembrosActuales()
        for clienteActual in lista:
            if (clienteActual.getNombre() == cliente.getNombre) and (clienteActual.getId() == cliente.getId):
                return True
        return False

    def actualizarFactura(self, reserva):
        Pago.removePendiente(self)
        Factura(reserva)

    # ToString
    def __str__(self):
        facturaHecha = "-------------\nRestaurante Un\nId de la reserva: {}\nCliente: {}\nIdentificación: {}\nSede: {}\nMesa #{}\nHora: {}"
        facturaHecha = facturaHecha.format(self._id, self._cliente.getNombre(), self._cliente.getId(), self._sede,
                                           self._mesa.getId(), self._reserva.getHora())

        if self.clienteEsMiembro(self._cliente):
            facturaHecha + "\nEl cliente es miembro Gold"
            precioConDescuento = self.precio - 20000
            facturaHecha += "\nDescuento del 20% aplicado\nPrecio: 80000$"
            if self._precio == 100000:
                self.precio = precioConDescuento
        else:
            facturaHecha += "\nEl cliente no es miembro"
            facturaHecha += "\nPrecio: {}$".format(self._precio)

        facturaHecha += "\n-------------"
        return facturaHecha


class Membresia:

    # Implementación de características de POO

    def __init__(self, tipo: str, activa: bool):
        self.tipo = "Gold"
        self.activa = activa

    # Métodos get

    def getTipo(self):
        return self.tipo

    def esActiva(self):
        return self.activa

    # Método set

    def setActiva(self, activa: bool):
        self.activa = activa

    @staticmethod
    def verificarMiembro(nombre, id, verificar):
        from src.gestorAplicación.clasesHeredadas import Cliente
        for cliente in Cliente.getmiembrosActuales():
            if cliente.getNombre() == nombre and cliente.getId() == id:
                return True
            return False

    @staticmethod
    def agregarMiembro(nombre, id):
        from src.gestorAplicación.clasesHeredadas import Cliente
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
        from src.gestorAplicación.clasesHeredadas import Cliente
        for cliente in Cliente.getMiembrosActuales():
            if cliente.getNombre() == nombre and cliente.getId() == idEliminar:
                cliente.setMembresia(None)
                Cliente.getMiembrosActuales().remove(cliente)
                return True
        return False


class Pago:
    facturasPagas = []
    facturasPendientes = []
    registroPagos = []

    def __init__(self, factura, medioPago):
        self._factura = factura
        self._medioPago = medioPago
        self.registroPagos.append(factura)

    # Métodos get
    @staticmethod
    def getFacturasPagas():
        return Pago.facturasPagas

    @staticmethod
    def getFacturasPendientes():
        return Pago.facturasPendientes

    @staticmethod
    def getRegistroPagos():
        return Pago.registroPagos

    def getFactura(self):
        return self._factura

    def getMedioPago(self):
        return self._medioPago

    # Otros métodos
    @staticmethod
    def addFacturasPagas(factura):
        Pago.facturasPagas.append(factura)

    @staticmethod
    def removePaga(factura):
        Pago.facturasPagas.remove(factura)

    @staticmethod
    def addFacturasPendientes(factura):
        Pago.facturasPendientes.append(factura)

    @staticmethod
    def removePendiente(factura):
        Pago.facturasPendientes.remove(factura)

    @staticmethod
    def removePagos(pago):
        Pago.registroPagos.remove(pago)
class Reserva:

    reservasHechas = []
    # Constructor
    def __init__(self, hora, cliente, mesa):
        from src.gestorAplicación.clasesHeredadas import Trabajador
        self._hora = hora
        self._cliente = cliente
        self._mesa = mesa
        self._IdR = str(hora) + "-" + mesa.getId()
        Reserva.reservasHechas.append(self)
        Trabajador.addMesasElegir()

    # Getters
    @classmethod
    def getReservasHechas(cls):
        return cls.reservasHechas

    def getHora(self):
        return self._hora

    def getCliente(self):
        return self._cliente

    def getMesa(self):
        return self._mesa

    def getIdR(self):
        return self._IdR

    # Setters
    def setCliente(self, cliente):
        self.cliente = cliente

    def setMesa(self, mesa):
        self.mesa = mesa

    def setHora(self, hora):
        self.hora = hora

    def __Str__(self):
        return "Cliente: " + self._cliente + ", mesa: " + self._mesa + ", hora: " + self._hora + ", reservaID: " + self._IdR

    # Recibe una lista de mesas y revisa si estan disponibles en cierto horario
    @classmethod
    def validarHorarioDisponible(mesas, hora):
        mesasReservadas = []
        for m in mesas:
            for r in Reserva.reservasHechas:
                if r.getIdR().trim() == (hora + "-" + m.getId()):
                    mesasReservadas.append(m)
        for i in mesasReservadas:
            mesas.pop(i)
        return mesas

    def cambiarParametros(self, hora, mesa):
        self.hora = hora
        self.mesa = mesa
        self.IdR = hora + "-" + mesa.getId()

    @classmethod
    def buscarReserva(id):
        for r in Reserva.reservasHechas:
            if (r.getIdR().trim() == id):
                return r
        return None