
from src.Errores.ErrorAplicación import *

class campoVacio(ErrorAplicación):
    def __init__(self, campo):
        super().__init__("El campo " + campo + " esta vacio, por favor rellenelo")
        print(self)


class horarioInvalido(ErrorAplicación):
    def __init__(self):
        super().__init__("A esta hora el resturante no presta servicio, por favor cambie su hora de reserva")


class sedeInvalida(ErrorAplicación):
    def __init__(self):
        super().__init__("Esta sede no existe, por favor verifique su valor")


class capacidadInvalida(ErrorAplicación):
    def __init__(self):
        super().__init__("Nuestras mesas solo disponen capacidad de 2 a 4 personas, verifique la capacidad que solicitó")