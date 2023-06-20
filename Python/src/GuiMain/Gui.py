from src.baseDatos import Deserializar
from src.gestorAplicación.clasesHeredadas import *
from src.gestorAplicación.clasesMain import *
from src.Errores.ExceptionC1 import *
from src.Errores.ExceptionC2 import *
from src.baseDatos.Serializar import *
from src.baseDatos.Deserializar import *

import tkinter as tk
from tkinter import messagebox
from enum import Enum

me1 = Mesa("E", 1, 2)
me2 = Mesa("SJ", 2, 2)
me3 = Mesa("B", 3, 2)
me4 = Mesa("B", 4, 3)
me5 = Mesa("E", 5, 3)
me6 = Mesa("SJ", 6, 4)
me7 = Mesa("SJ", 7, 3)
me8 = Mesa("E", 8, 2)
me9 = Mesa("E", 9, 2)
me10 = Mesa("E", 10, 3)
me11 = Mesa("B", 11, 5)


class Sedes(Enum):
    envigado = "E"
    bello = "B"
    sanjavier = "SJ"

class FieldFrame(tk.Frame):
    def __init__(self, tituloCriterios, criterios, tituloValores, frame, valores=None, habilitado=None):
        super().__init__(frame)
        self.grid()

        a = 1
        criterio = {}
        # Columna criterio
        self.criterio = tk.Label(self, text=tituloCriterios, font=("arial", 12, "bold"), bg="white")
        self.criterio.grid(padx=10, pady=10)
        # Columna valor
        self.valor = tk.Label(self, text=tituloValores, font=("arial", 12, "bold"), bg="white")
        self.valor.grid(row=0, column=1, padx=10, pady=10)

        # labels y entries
        entrys = []
        for i in criterios:
            self.label = tk.Label(self, text=i, font=("arial", 11))
            self.label.grid(row=a, padx=10, pady=10)
            self.entry = tk.Entry(self)
            self.entry.grid(row=a, column=1, padx=10, pady=10)
            entrys.append(self.entry)
            # Valores iniciales
            if valores != None and valores != []:
                self.entry.insert(0, valores[0])
                valores.pop(0)
                criterio[i.split(":")[0]] = self.entry.get()
                self.criterio = criterio
            # Campos no-editables
            if (habilitado != None) and (i in habilitado): self.entry.config(state='disabled')
            a += 1

        # Botones aceptar y borrar
        def borrado():
            for i in entrys:
                i.delete(0, "end")

        def aceptar():
            for i in range(len(criterios)):
                criterio[criterios[i].split(":")[0]] = entrys[i].get()
            self.criterio = criterio

        self.aceptar = tk.Button(self, text="Aceptar", bg="misty rose", width=15, command=aceptar)
        self.aceptar.grid(row=a, column=0, padx=10, pady=10)
        self.borrar = tk.Button(self, text="Borrar", bg="misty rose", width=15, command=borrado)
        self.borrar.grid(row=a, column=1, padx=10, pady=10)

    # get
    def getValue(self, a):
        self.aceptar.invoke()
        value = self.criterio[a]
        return value


class Gui:
    # Ventana de inicio
    window = tk.Tk()
    window.title("Restaurante UN")
    window.geometry("1340x720")
    window.config(bg="white")
    window.resizable(0, 0)

    menuBar = tk.Menu(window)
    window.config(menu=menuBar)

    menuInicio = tk.Menu(menuBar)
    menuBar.add_cascade(label="Inicio", menu=menuInicio)

    menuInicio.add_command(label="Descripción")
    menuInicio.add_command(label="Salir")

    descripcion = tk.Label(window, bg="white")
    descripcion.pack(anchor="center")

    # Frames
    frameP1 = tk.Frame(window, bg="black")
    frameP1.place(x=20, y=20, width=640, height=680)

    frameP2 = tk.Frame(window, bg="black")
    frameP2.place(x=680, y=20, width=640, height=680)

    frameP3 = tk.Frame(frameP1, bg="lightblue")
    frameP3.place(x=10, y=10, width=620, height=240)

    frameP4 = tk.Frame(frameP1, bg="lightblue")
    frameP4.place(x=10, y=260, width=620, height=410)

    frameP5 = tk.Frame(frameP2, bg="lightblue")
    frameP5.place(x=10, y=10, width=620, height=240)

    hojaDeVida1 = "Pedro Jimenez\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 324 6840606\n\nCorreo: pjimenezi@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"
    hojaDeVida2 = "Jonhatan Cuartas\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 3004834080\n\nCorreo: jcuartasl@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"

    botonCambio = tk.Button(frameP5, text="Click para cambiar de hoja de vida", bg="teal")
    botonCambio.place(x=210, y=210)
    botonCambio.bind("<Button-1>")

    etiqueta = tk.Label(frameP5, text=hojaDeVida1, bg="lightblue")
    etiqueta.place(x=0, y=0, width=620, height=200)

    frameP6 = tk.Frame(frameP2, bg="lightblue")
    frameP6.place(x=10, y=260, width=620, height=410)

    # Labels

    mensajeBienvenida = tk.Label(frameP3, text="¡Bienvenido a RestauranteUN!", bg="lightblue")
    mensajeBienvenida.place(relx=0.5, rely=0.5, anchor="center")
    mensajeBienvenida.configure(font=("arial", 12, "bold"))

    # Buttons
    botonIngreso = tk.Button(frameP4, text="Click para ingresar a RestauranteUN", bg="teal")
    botonIngreso.place(x=0, y=360, width=620, height=50)
    botonIngreso.configure(font=("arial", 11, "bold"))

    # Ventana principal del usuario
    def userVent(evento):

        windowUser = tk.Tk()
        windowUser.geometry("1290x720")
        windowUser.resizable(0, 0)
        windowUser.title("Restaurante UN")
        windowUser.config(bg="white")

        frameU1 = tk.Frame(windowUser, bg="lightblue")
        frameU1.place(x=20, y=15, width=1250, height=685)

        frameU2 = tk.Frame(frameU1, bg="lightblue")
        frameU2.place(x=625, y=20, width=416, height=30, anchor="center")

        frameU3 = tk.Frame(frameU1, bg="lightblue")
        frameU3.place(x=20, y=50, width=1210, height=90)

        frameU4 = tk.Frame(frameU1, bg="white")
        frameU4.place(x=90, y=160, width=1090, height=500)

        nombre = tk.Label(frameU2, bg="lightblue")
        nombre.place(relx=0.5, rely=0.5, anchor="center")

        descripcion = tk.Label(frameU3, bg="lightblue")
        descripcion.place(relx=0.5, rely=0.5, anchor="center")

        frameU4.grid_columnconfigure(0, weight=1)
        nameP = tk.Label(frameU4, bg="khaki", highlightthickness=1, highlightbackground="black", width=100,
                         font=("arial", 11))

        def reservar():

            def confirmend(self):
                c = mesass[mesas.get()]
                print(c)
                reservaDone = Reserva(hora, clienteNow, c)
                facturaNow = Factura(reservaDone)
                print(Reserva.reservasHechas)
                c = messagebox.askyesno("Factura", "Desea visualizar su factura?")
                if c:
                    messagebox.showinfo("Factura", facturaNow.__str__())



            def validacion2(self):
                global hora
                from src.Errores.ExceptionC1 import campoVacio, horarioInvalido, sedeInvalida, capacidadInvalida
                mField.aceptar.invoke()
                capacidad = mField.getValue("Capacidad")
                sede = mField.getValue("Sede").lower().replace(" ", "")
                hora = mField.getValue("Hora")

                try:
                    Cliente.datosVacios([capacidad, sede, hora])
                except campoVacio:
                    messagebox.showwarning("Manejo de Errores", "Por favor rellene todos los campos solicitados")
                    return

                try:
                    capacidad = int(capacidad)
                    hora = int(hora)
                    Mesa.validarDatosMesa(capacidad, sede, hora)
                except ValueError:
                    messagebox.showwarning("Manejo de Errores", "Uno de los campos ingresados no es válido")
                except horarioInvalido:
                    messagebox.showwarning("Manejo de errores", horarioInvalido().mostrarMensaje())
                except capacidadInvalida:
                    messagebox.showwarning("Manejo de errores", capacidadInvalida().mostrarMensaje())
                except sedeInvalida:
                    messagebox.showwarning("Manejo de errores", sedeInvalida().mostrarMensaje())
                else:
                    from tkinter import ttk
                    global mesass
                    mesasEsp = Mesa.buscarMesas(Sedes[sede].value, capacidad)
                    mesasF = Reserva.validarHorarioDisponible(mesasEsp, hora)
                    mesass = {}
                    for i in mesasF:
                        mesass[(i.toString())] = i

                    if len(mesass) == 0:
                        messagebox.showinfo("Mesas no disponibles", "Lo sentimos, pero no hay mesas con esas características")
                    else:
                        global mesas
                        mesas = ttk.Combobox(frameU4, values=list(mesass))
                        mesas.grid(row=4, column=0, padx=10, pady=15)
                        confirm = tk.Button(frameU4, text = "Confirmar reserva", bg="misty rose")
                        confirm.grid(row=5, column=0, padx=10, pady=10)
                        confirm.bind("<Button-1>", confirmend)



            def validacion(self):
                global clienteNow
                from src.Errores.ExceptionC1 import campoVacio
                rField.aceptar.invoke()
                name = rField.getValue("Nombre")
                ide = rField.getValue("Identificación")
                clienteNow = Cliente.validarDatosCliente(name, ide)
                print(clienteNow)

                try:
                    Cliente.datosVacios([name, ide])
                except campoVacio:
                    messagebox.showwarning("Manejo de Errores", "Por favor rellene todos los campos solicitados")
                    return

                if clienteNow == None:
                    messagebox.showwarning("Manejo de Errores", "Uno de los campos ingresados no es válido")
                else:
                    global mField
                    rField.destroy()
                    mField = FieldFrame("Datos de la Mesa", ["Capacidad: ", "Sede: ", "Hora: "], "valor", frameU4)
                    mField.grid()
                    mField.aceptar.bind("<Button-1>", validacion2)


            # Zona de descripción de la funcionalidad
            frameU4.grid_columnconfigure(0, weight=1)

            nombre.config(text="Reservar", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de reservar", bg="lightblue", font=("arial", 12, "bold"))

            nameP.config(text=("Aqui puedes agendar una de nuestras mesas\n"
                               "Primero debes colocar tu nombre y número de identificación\n"
                               "(recuerda que si eres miembro obtendrás un descuento del 20% en la reserva)\n"))
            nameP.grid()

            # Uso del fieldFrame
            rField = FieldFrame("Datos personales", ["Nombre:", "Identificación:"], "valor", frameU4)
            rField.grid()
            rField.aceptar.bind("<Button-1>", validacion)

        def reprogramar():
            nombre.config(text="Reprogramar", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de reprogramar", bg="lightblue",
                               font=("arial", 12, "bold"))

        def pagar():
            # Zona de descripción de la funcionalidad
            nombre.config(text="Pagar", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de pagar", bg="lightblue", font=("arial", 12, "bold"))

            nameP.config(
                text="Aqui puedes pagar tu reserva agendada previamente o efectuar el reembolso de tu reserva\n"
                     "selecciona la opción que desees")
            nameP.grid(pady=10)

            # Interacción con el usuario
            def opcion(opcion):
                pay.destroy()
                remb.destroy()

                def validacion2(evento):
                    x = pField.getValue("Id de la reserva")
                    factura1 = Factura.buscarFactura(Pago.getFacturasPendientes(), x)
                    factura2 = Factura.buscarFactura(Pago.getFacturasPagas(), x)

                    if factura1 != None:
                        from tkinter import ttk
                        pField.destroy()
                        nameP.config(text="A continuación podrás ver tu factura en pantalla\n"
                                          "selecciona como deseas pagar tu factura")
                        factura = tk.entry(frameU4, text=factura1.__str__, bg="gray77")
                        factura.grid(padx=10, pady=10)
                        metPagos = ttk.Combobox(frameU4, values=["En linea", "En efectivo"])
                        metPagos.grid(row=4, column=0, padx=10, pady=10)
                        opc = tk.Button(frameU4, text="Aceptar", bg="misty rose", width=50, heigh=3,
                                        command=lambda: metodo(metPagos.get()))
                        opc.grid(row=5, column=0, padx=10, pady=10)
                    elif factura2 != None:
                        messagebox.showinfo(message="La factura ya ha sido pagada")
                    else:
                        messagebox.showerror(title="Error!", message="No hay ninguna factura con la id " + x +
                                                                     " asegurate de haber colocado bien la id")

                    def validacion3(field):
                        if int(field.getValue("Saldo")) >= factura1.getPrecio():
                            Pago.facturasPendientes.remove(factura1)
                            factura = Pago(factura1, "Efectivo")

                    def metodo(metodo):
                        factura.destroy();
                        metPagos.destroy();
                        opc.destroy()
                        if metodo == "En linea":
                            nameP.config(text="Ingrese el saldo de su tarjeta")
                            p1Field = FieldFrame("Datos", ["Saldo:"], "valor", frameU4)
                            p1Field.grid()
                            p1Field.aceptar.bind("<Button-1>", validacion3(p1Field))

                        if metodo == "En efectivo":
                            messagebox.showinfo(title="Listo!",
                                                message="Realiza tu pago al llegar a la sede " + factura1.getSede())
                            windowUser.destroy()

                def razon(motivo):
                    if razon == "Otro (especificar)":
                        p1Field = FieldFrame("Datos", ["Razon de tu reembolso:"], "valor", frameU4)
                        p1Field.grid()
                        p1Field.aceptar.bind("<Button-1", p1Field.destroy())
                    messagebox.showinfo(
                        "Lamentamos las molestias causadas, intentaremos solucionar su problema lo más rápido posible")
                    windowUser.destroy()

                def validacion4(evento):
                    x = pField.getValue("Id de la reserva")
                    factura1 = Factura.buscarFactura(Pago.getFacturasPendientes(), x)
                    factura2 = Factura.buscarFactura(Pago.getFacturasPagas(), x)
                    if factura1 != None:
                        messagebox.showwarning(title="Cuidado",
                                               message="La factura " + x + " todavía no ha sido pagada")
                    elif factura2 != None:
                        from tkinter import ttk
                        pField.destroy()
                        messagebox.showinfo(title="listo",
                                            message="La factura " + x + " ha sido reembolsada a su tarjeta usada para el pago")
                        Pago.facturasPagas.remove(factura2)
                        nameP.config(text="Para finalizar cuentanos cuál fue el motivo de su reembolso")
                        motivos = ttk.Combobox(frameU4,
                                               values=["Problemas con el horario", "Problemas con nuestro servicio",
                                                       "Dificultades con el precio y/o medio de pago",
                                                       "Otro (especificar)"])
                        motivos.grid(padx=10, pady=10)
                        opc1 = tk.Button(frameU4, text="Aceptar", bg="misty rose", width=50, heigh=3,
                                         command=lambda: razon(motivos.get()))
                        opc1.grid(padx=10, pady=10)
                    else:
                        messagebox.showerror(title="Error!", message="No hay ninguna factura con la id " + x +
                                                                     " asegurate de haber colocado bien la id")

                if opcion == "Pagar":
                    nameP.config(text="Haz elegido pagar"
                                      "Anota el id de tu reserva en la casilla correspondiente")
                    pField = FieldFrame("Datos", ["Id de la reserva:"], "valor", frameU4)
                    pField.grid()
                    pField.aceptar.bind("<Button-1>", validacion2)

                if opcion == "Reembolsar":
                    nameP.config(text="Haz elegido reembolsar"
                                      "Ingresa el id de su factura")
                    pField = FieldFrame("Datos", ["Id de la reserva:"], "valor", frameU4)
                    pField.grid()
                    pField.aceptar.bind("<Button-1>", validacion4)

            pay = tk.Button(frameU4, text="Pagar", bg="misty rose", width=50, heigh=3, command=lambda: opcion("Pagar"))
            pay.grid(padx=10, pady=10)
            remb = tk.Button(frameU4, text="Reembolsar", bg="misty rose", width=50, heigh=3,
                             command=lambda: opcion("Reembolsar"))
            remb.grid(padx=10, pady=10)

        def obtenerMembresia():
            nombre.config(text="Obtener membresia", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de Obtener membresia", bg="lightblue",
                               font=("arial", 12, "bold"))

        def ingresarAltrabajo():
            nombre.config(text="Ingresar al trabajo", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de ingresar al trabajo", bg="lightblue",
                               font=("arial", 12, "bold"))

        contenedorDemenu = tk.Frame(windowUser)
        contenedorDemenu.pack(side=tk.TOP)

        def aplicacion():
            messagebox.showinfo("Aplicación",
                                "¡Bienvenido a RestauranteUN!\n\nEste sistema le permite:\n• Realizar una reserva de mesa en el restaurante.\n• Visualizar los clientes con reservas asignadas.\n• Realizar una cancelacion y eventual reembolso de la reserva.")

        def acercaDe():
            messagebox.showinfo("A cerca de",
                                "Autores de la aplicación:\n• Pedro Junior Jiménez Ibáñez\n• Manuel Alejandro Sánchez Daza\n• Jonhatan Cuartas Londoño\n• Daniel Steven Caro Durango")

        # Menus
        menuArchivo = tk.Menu(contenedorDemenu)
        menuArchivo.add_command(label="Aplicación", command=aplicacion)
        menuArchivo.add_command(label="Salir", command=windowUser.destroy)

        menuProcesosyConsultas = tk.Menu(contenedorDemenu)

        menuCliente = tk.Menu(menuProcesosyConsultas)
        menuCliente.add_command(label="Reservar", command=reservar)
        menuCliente.add_command(label="Reprogramar", command=reprogramar)
        menuCliente.add_command(label="Pagar", command=pagar)
        menuCliente.add_command(label="Obtener membresía", command=obtenerMembresia)

        menuProcesosyConsultas.add_cascade(label="Menu de cliente", menu=menuCliente)

        menuTrabajador = tk.Menu(menuProcesosyConsultas)
        menuTrabajador.add_command(label="Ingresar al trabajo", command=ingresarAltrabajo)
        menuTrabajador.add_command(label="Asignar mesa")
        menuTrabajador.add_command(label="Visualizar sueldo actual")

        menuProcesosyConsultas.add_cascade(label="Menu de trabajador", menu=menuTrabajador)

        menuAyuda = tk.Menu(contenedorDemenu)
        menuAyuda.add_command(label="Acerca de", command=acercaDe)

        barraDemenu = tk.Menu(windowUser)
        barraDemenu.add_cascade(label="Archivo", menu=menuArchivo)
        barraDemenu.add_cascade(label="Procesos y Consultas", menu=menuProcesosyConsultas)
        barraDemenu.add_cascade(label="Ayuda", menu=menuAyuda)

        windowUser.config(menu=barraDemenu)

    botonIngreso.bind("<Button-1>", userVent)

    window.mainloop()