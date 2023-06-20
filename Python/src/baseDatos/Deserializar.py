import os
import pathlib
import pickle

from src.gestorAplicación.clasesHeredadas import Cliente
from src.gestorAplicación.clasesHeredadas import Trabajador
from src.gestorAplicación.clasesMain import Mesa
from src.gestorAplicación.clasesMain import Pago
from src.gestorAplicación.clasesMain import Reserva


class Deserializador:
    @staticmethod
    def deserializar(nombre):
        lista = []
        ruta = os.path.join(
            pathlib.Path(__file__).parent.absolute(), "temp/" + nombre + ".txt"
        )
        try:
            with open(ruta, "rb") as picklefile:
                if os.path.getsize(ruta) > 0:
                    lista = pickle.load(picklefile)
        except:
            print("Ocurrió un error gg")
        return lista

    @classmethod
    def deserializarDatos(cls):
        Cliente.miembrosActuales = cls.deserializar("miembrosActuales")
        Reserva.reservasHechas = cls.deserializar("reservasHechas")
        Mesa.mesasDisponibles = cls.deserializar("mesasDisponibles")
        Pago.facturasPagas = cls.deserializar("facturasPagas")
        Pago.facturasPendientes = cls.deserializar("facturasPendientes")
        Trabajador.mesasAtendidas = cls.deserializar("mesasAtendidas")
        Trabajador.mesasElegir = cls.deserializar("mesasElegir")
        Trabajador.trabajadoresActivos = cls.deserializa