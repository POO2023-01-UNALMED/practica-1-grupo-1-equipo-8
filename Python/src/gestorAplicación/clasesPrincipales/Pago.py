class Pago:
    facturasPagas = []
    facturasPendientes = []
    registroPagos = []

    def __init__(self, factura, medioPago):
        self._factura = factura
        self._medioPago = medioPago
        self.registroPagos.append(factura)


    #Métodos get
    @staticmethod
    def getFactuasPagas():
        return Pago.facturasPagas
    
    @staticmethod
    def getFactuasPendientes():
        return Pago.facturasPendientes
    
    @staticmethod
    def getRegistroPagos():
        return Pago.registroPagos
    
    def getFactura(self):
        return self._factura
    
    def getMedioPago(self):
        return self._medioPago
    
    #Otros métodos
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