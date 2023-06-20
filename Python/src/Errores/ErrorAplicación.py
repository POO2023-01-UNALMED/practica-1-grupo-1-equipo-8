class ErrorAplicación(Exception):
    def __init__(self, msg):
        self._msg = "Manejo de errores de la aplicación. " + msg

    def mostrarMensaje(self):
        return self._msg
