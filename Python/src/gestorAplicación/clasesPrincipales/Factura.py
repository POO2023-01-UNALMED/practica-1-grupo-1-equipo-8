from gestorAplicación.clasesPrincipales import Pago
from gestorAplicación.clasesHeredadas import Cliente

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
    
    #Métodos get
    def getReserva(self):
        return self._reserva
    
    def getClienteFactura(self):
        return self._cliente
    
    def getMesa(self):
        return self._mesa
    
    #def getFacturaHecha(self):
    #    return self._facturaHecha
    
    def getPrecio(self):
        return self._precio
    
    def getSede(self):
        return self._sede
    
    def getFacturaMiembro(self):
        return self._membresia
    
    def getIDReserva(self):
        return self._id
    
    #Métodos set
    def setReserva(self, reserva):
        self._reserva = reserva
    
    def setPrecio(self, precio):
        self._precio = precio

    #Otros métodos
    @staticmethod
    def buscarFactura(facturas, id):
        for factura in facturas:
            if factura.getReserva().getIdR().strip() == id:
                return factura
        return None

    def clienteEsMiembro(self, cliente):
        lista = Cliente.getMiembrosActuales()
        for clienteActual in lista:
            if (clienteActual.getNombre() == cliente.getNombre) and (clienteActual.getId() == cliente.getId):
                return True
        return False
    
    def actualizarFactura(self, reserva):
        Pago.removePendiente(self)
        Factura(reserva)

    #ToString
    def __str__(self):
        facturaHecha = "-------------\nRestaurante Un\nId de la reserva: {}\nCliente: {}\nIdentificación: {}\nSede: {}\nMesa #{}\nHora: {}" 
        facturaHecha = facturaHecha.format(self._id, self._cliente.getNombre(), self._cliente.getId(), self._sede, self._mesa.getId(), self._reserva.getHora())

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