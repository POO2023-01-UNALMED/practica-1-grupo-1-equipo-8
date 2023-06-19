import pickle
import os

class Serializar:

    archivo = "baseDatos"

    @staticmethod
    def deserializarMiembros():
        try:
            with open(os.path.join(Serializar.archivo, "miembrosActuales.pickle"), "rb") as f:
                miembrosActuales = pickle.load(f)
                return miembrosActuales
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarReservas():
        try:
            with open(os.path.join(Serializar.archivo, "reservasHechas.pickle"), "rb") as f:
                reservasHechas = pickle.load(f)
                return reservasHechas
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarMesas():
        try:
            with open(os.path.join(Serializar.archivo, "mesasDisponibles.pickle"), "rb") as f:
                mesasDisponibles = pickle.load(f)
                return mesasDisponibles
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarFacturasPagas():
        try:
            with open(os.path.join(Serializar.archivo, "facturasPagas.pickle"), "rb") as f:
                facturasPagas = pickle.load(f)
                return facturasPagas
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarFacturasPendientes():
        try:
            with open(os.path.join(Serializar.archivo, "facturasPendientes.pickle"), "rb") as f:
                facturasPendientes = pickle.load(f)
                return facturasPendientes
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarTrabajadoresActivos():
        try:
            with open(os.path.join(Serializar.archivo, "trabajadoresActivos.pickle"), "rb") as f:
                trabajadoresActivos = pickle.load(f)
                return trabajadoresActivos
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarMesasElegir():
        try:
            with open(os.path.join(Serializar.archivo, "mesasElegir.pickle"), "rb") as f:
                mesasElegir = pickle.load(f)
                return mesasElegir
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)

    @staticmethod
    def deserializarMesasAtendidas():
        try:
            with open(os.path.join(Serializar.archivo, "mesasAtendidas.pickle"), "rb") as f:
                mesasAtendidas = pickle.load(f)
                return mesasAtendidas
        except FileNotFoundError as e:
            print("No se encuentra el archivo:", e)
        except IOError as e:
            print("Error al leer el archivo:", e)
