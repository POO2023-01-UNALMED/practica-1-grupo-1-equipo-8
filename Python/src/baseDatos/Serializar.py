import os
import pathlib
import pickle

from src.gestorAplicación.clasesHeredadas import Cliente
from src.gestorAplicación.clasesHeredadas import Trabajador
from src.gestorAplicación.clasesMain import Mesa
from src.gestorAplicación.clasesMain import Pago
from src.gestorAplicación.clasesMain import Reserva


class Serializador:
    @staticmethod
    def serializar(nombre, lista):
        ruta = os.path.join(
            pathlib.Path(__file__).parent.absolute(), "temp/" + nombre + ".txt"
        )
        try:
            with open(ruta, "wb") as picklefile:
                pickle.dump(lista, picklefile)
        except:
            print("Ocurrió un error gg")

    @classmethod
    def serializarDatos(cls):
        cls.serializar("miembrosActuales", Cliente.getmiembrosActuales())
        cls.serializar("reservasHechas", Reserva.getReservasHechas())
        cls.serializar("mesasDisponibles", Mesa.mesasDisponibles)
        cls.serializar("facturasPagas", Pago.facturasPagas)
        cls.serializar("facturasPendientes", Pago.facturasPendientes)
        cls.serializar("mesasElegidas", Trabajador.mesasAtendidas)
        cls.serializar("mesasElegir", Trabajador.mesasElegir)
        cls.serializar("trabajadoresActivos", Trabajador.trabajadoresActivos)
