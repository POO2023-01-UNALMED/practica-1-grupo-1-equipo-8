import pickle
import os


class Serializar:
    archivo = "baseDatos"

    @staticmethod
    def serializarMiembros(miembrosActuales):
        try:
            with open(os.path.join(Serializar.archivo, "miembrosActuales.pickle"), "wb") as f:
                pickle.dump(miembrosActuales, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarReservas(reservasHechas):
        try:
            with open(os.path.join(Serializar.archivo, "reservasHechas.pickle"), "wb") as f:
                pickle.dump(reservasHechas, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarMesas(mesasDisponibles):
        try:
            with open(os.path.join(Serializar.archivo, "mesasDisponibles.pickle"), "wb") as f:
                pickle.dump(mesasDisponibles, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarFacturasPagas(facturasPagas):
        try:
            with open(os.path.join(Serializar.archivo, "facturasPagas.pickle"), "wb") as f:
                pickle.dump(facturasPagas, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarFacturasPendientes(facturasPendientes):
        try:
            with open(os.path.join(Serializar.archivo, "facturasPendientes.pickle"), "wb") as f:
                pickle.dump(facturasPendientes, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarTrabajadoresActivos(trabajadoresActivos):
        try:
            with open(os.path.join(Serializar.archivo, "trabajadoresActivos.pickle"), "wb") as f:
                pickle.dump(trabajadoresActivos, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarMesasElegir(mesasElegir):
        try:
            with open(os.path.join(Serializar.archivo, "mesasElegir.pickle"), "wb") as f:
                pickle.dump(mesasElegir, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)

    @staticmethod
    def serializarMesasAtendidas(mesasAtendidas):
        try:
            with open(os.path.join(Serializar.archivo, "mesasAtendidas.pickle"), "wb") as f:
                pickle.dump(mesasAtendidas, f)
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al escribir en el archivo:", e)