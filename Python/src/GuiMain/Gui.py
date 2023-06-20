import locale
import tkinter as tk
from enum import Enum
from tkinter import messagebox
from tkinter import ttk

from src.Errores.ExceptionC1 import *
from src.Errores.ExceptionC2 import *
from src.baseDatos.Deserializar import Deserializador
from src.baseDatos.Serializar import Serializador
from src.gestorAplicación.clasesHeredadas import *
from src.gestorAplicación.clasesMain import *

Deserializador.deserializarDatos()

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
cli1 = Cliente("Juan", 243)
re1 = Reserva(6,cli1,me1)
print(re1.getIdR())

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


hojaDeVida1 = "Pedro Jimenez\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 324 6840606\n\nCorreo: pjimenezi@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"
hojaDeVida2 = "Jonhatan Cuartas\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 3004834080\n\nCorreo: jcuartasl@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"
hojaDeVida3 = "Manuel Sanchez\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 3104465081\n\nCorreo: msanchezda@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"
hojaDeVida4 = "Daniel Caro\n\nEstudiante de Ingenieria de sistemas e Informatica\n\nContacto:\n\nTelefono: 3103503746\n\nCorreo: dcarod@unal.edu.co\n\nUniversidad Nacional de Colombia sede Medellin"
cHojas = 1
cImages = 1

def cambioHojas(evento):
    global cHojas
    c = [hojaDeVida1, hojaDeVida2, hojaDeVida3, hojaDeVida4]
    etiqueta.config(text=c[cHojas])
    img1.config(image=imagenes[cHojas][0])
    img2.config(image=imagenes[cHojas][1])
    img3.config(image=imagenes[cHojas][2])
    img4.config(image=imagenes[cHojas][3])
    cHojas += 1
    if c[cHojas - 1] == c[-1]:
        cHojas = 0

def cambiarImg(evento):
    global cImages
    imgRest.config(image=imagenesResta[cImages])
    cImages += 1
    if imagenesResta[cImages-1] == imagenesResta[-1]:
        cImages = 0

def descripcion():
    descripcion = tk.Label(frameP3, bg="lightblue", text="Al ingresar a este programa podrás hacer reservas y administrarlas,\n"
                                                     " tambíen tenemos un apartado para nuestros trabajadores activos y los que\n"
                                                     " quieran trabajar con nosotros", font=("arial", 10))
    descripcion.pack(side=tk.BOTTOM)


class Gui:
    global etiqueta, img1, img2, img3, img4, imagenes, imagenesResta,imgRest, frameP3
    # Ventana de inicio
    window = tk.Tk()
    window.title("Restaurante UN")
    window.geometry("1340x720")
    window.config(bg="white")
    window.resizable(0, 0)

    imagen1 = tk.PhotoImage(file="imagenes/img1.png")
    imagen2 = tk.PhotoImage(file="imagenes/img2.png")
    imagen3 = tk.PhotoImage(file="imagenes/img3.png")
    imagen4 = tk.PhotoImage(file="imagenes/img4.png")
    imagen5 = tk.PhotoImage(file="imagenes/img5.png")
    imagen6 = tk.PhotoImage(file="imagenes/img6.png")
    imagen7 = tk.PhotoImage(file="imagenes/img7.png")
    imagen8 = tk.PhotoImage(file="imagenes/img8.png")
    imagen9 = tk.PhotoImage(file="imagenes/img9.png")
    imagen10 = tk.PhotoImage(file="imagenes/img10.png")
    imagen11 = tk.PhotoImage(file="imagenes/img11.png")
    imagen12 = tk.PhotoImage(file="imagenes/img12.png")
    imagen13 = tk.PhotoImage(file="imagenes/img13.png")
    imagen14 = tk.PhotoImage(file="imagenes/img14.png")
    imagen15 = tk.PhotoImage(file="imagenes/img15.png")
    imagen16 = tk.PhotoImage(file="imagenes/img16.png")
    resta1 = tk.PhotoImage(file="imagenes/rest1.png")
    resta2 = tk.PhotoImage(file="imagenes/rest2.png")
    resta3 = tk.PhotoImage(file="imagenes/rest3.png")
    resta4 = tk.PhotoImage(file="imagenes/rest4.png")

    imagenes = [[imagen1, imagen2, imagen3, imagen4], [imagen5, imagen6, imagen7, imagen8],[imagen9, imagen10, imagen11, imagen12], [imagen13, imagen14, imagen15, imagen16]]
    imagenesResta = [resta1, resta2, resta3, resta4]

    menuBar = tk.Menu(window)
    window.config(menu=menuBar)

    menuInicio = tk.Menu(menuBar)
    menuBar.add_cascade(label="Inicio", menu=menuInicio)

    menuInicio.add_command(label="Descripción", command=descripcion)
    menuInicio.add_command(label="Salir", command=quit)

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

    imgRest = tk.Label(frameP4, width=600, height=340, image=resta1)
    imgRest.pack(padx=10,pady=10, anchor="center")
    imgRest.bind("<Enter>", cambiarImg)

    frameP5 = tk.Frame(frameP2, bg="lightblue")
    frameP5.place(x=10, y=10, width=620, height=240)

    etiqueta = tk.Label(frameP5, text=hojaDeVida1, bg="lightblue")
    etiqueta.place(x=0, y=0, width=620, height=200)
    etiqueta.bind("<Button-1>", cambioHojas)


    frameP6 = tk.Frame(frameP2, bg="gray")
    frameP6.place(x=10, y=260, width=620, height=410)
    img1 = tk.Label(frameP6, image=imagen1, width=290, height=185, bg = "teal")
    img2 = tk.Label(frameP6, image=imagen2, width=290, height=185, bg = "teal")
    img3 = tk.Label(frameP6, image=imagen3, width=290, height=185, bg = "teal")
    img4 = tk.Label(frameP6, image=imagen4, width=290, height=185, bg = "teal")
    img1.grid(row=0, column=0, padx=8, pady=8, sticky="nw")
    img2.grid(row=0, column=1, padx=8, pady=8, sticky="ne")
    img3.grid(row=1, column=0, padx=8, pady=8, sticky="sw")
    img4.grid(row=1, column=1, padx=8, pady=8, sticky="se")

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

        def cerrar_userVent():
            windowUser.destroy()

        def reservar():

            def confirmend(self):
                c = mesass[mesas.get()]
                reservaDone = Reserva(hora, clienteNow, c)
                facturaNow = Factura(reservaDone)
                Serializador.serializarDatos()
                c = messagebox.askyesno("Factura", "Desea visualizar su factura?")
                facturaNow.getIDReserva()
                if c:
                    messagebox.showinfo("Factura", facturaNow.__str__())


            def validacion2(self):
                global hora
                from src.Errores.ExceptionC1 import campoVacio, horarioInvalido, sedeInvalida, capacidadInvalida
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
                    global mesass
                    mesasEsp = Mesa.buscarMesas(Sedes[sede].value, capacidad)
                    mesasF = Reserva.validarHorarioDisponible(mesasEsp, hora)
                    mesass = {}
                    for i in mesasF:
                        mesass[(i.__str__())] = i

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

            nameP.config(text=("Aqui puedes reprogramar tu reserva\n"
                               "Debes colocar tu ID de reserva para confirmar que estas en el programa\n"
                               "(este aparece en la sección de reservar)"))
            nameP.grid()
            reField = FieldFrame("Datos personales",["Id de reserva"],"valor",frameU4)
            reField.grid()
            id = reField.getValue("Id de reserva")

            def validarId(evento):
                factura1 = Factura.buscarFactura(Pago.getFacturasPagas(),id)
                factura2 = Factura.buscarFactura((Pago.getFacturasPendientes(), id))

                if factura1 != None:
                    messagebox.showerror(title="Error",message="Lo sentimos, pero no se puede reprogramar una factura ya pagada")

                elif factura2 == None:
                    messagebox.showerror(title="Error",message="Lo sentimos, no hemos encontrado ninguna factura con la ID proporcionada")

                else:
                    reField.destroy()
                    aField = FieldFrame("Datos de la Mesa", ["Capacidad: ", "Sede: ", "Hora: "], "valor", frameU4)
                    aField.grid()

            def confirmar(self):
                c = mesass[mesas.get()]
                print(c)
                reservaDone = Reserva(hora, clienteNow, c)
                facturaNow = Factura(reservaDone)
                print(Reserva.reservasHechas)
                c = messagebox.askyesno("¿Está seguro/a de reprogramar su reserva y cambiar sus parámetros?")
                if c:
                    reE1 = Reserva.buscarReserva(id)
                    reE1.cambiarParametros(hora,c)
                    facturaNow.actualizarFactura(reE1)
                    messagebox.showinfo("Su reserva ha sido actualizada, lo esperamos en una nueva ocasión.")

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

                    def validacion3(field):
                        valor = int(field.getValue("Saldo"))
                        if valor >= factura1.getPrecio():
                            Pago.facturasPendientes.remove(factura1)
                            Pago.addFacturasPagas(factura1)
                            factura = Pago(factura1, "Efectivo")
                            messagebox.showinfo(title="Listo!", message="La factura se ha pagado correctamente")
                        else:
                            messagebox.showerror(title="Error!",
                                                 message="No tienes saldo suficiente para pagar su factura"
                                                         " intenta en una nueva ocasión")
                            windowUser.destroy()
                        Serializador.serializarDatos()


                    def metodo():
                        estado = metPagos.get()
                        factura.destroy()
                        metPagos.destroy()
                        opc.destroy()
                        if estado == "En linea":
                            nameP.config(text="Ingrese el saldo de su tarjeta")
                            p1Field = FieldFrame("Datos", ["Saldo:"], "valor", frameU4)
                            p1Field.grid()
                            p1Field.aceptar.bind("<Button-1>", lambda event: validacion3(p1Field))

                        elif estado == "En efectivo":
                            messagebox.showinfo(title="Listo!",
                                                message="Realiza tu pago al llegar a la sede " + factura1.getSede())
                            Serializador.serializarDatos()
                            windowUser.destroy()

                    if factura1 is not None:
                        pField.destroy()
                        nameP.config(text="A continuación podrás ver tu factura en pantalla\n"
                                          "selecciona como deseas pagar tu factura")
                        factura = tk.Label(frameU4, text=factura1.__str__(), bg="gray77")
                        factura.grid(padx=10, pady=10)
                        metPagos = ttk.Combobox(frameU4, values=["En linea", "En efectivo"])
                        metPagos.grid(row=4, column=0, padx=10, pady=10)
                        opc = tk.Button(frameU4, text="Aceptar", bg="misty rose", width=50, heigh=3, command=metodo)
                        opc.grid(row=5, column=0, padx=10, pady=10)
                    elif factura2 is not None:
                        messagebox.showinfo(message="La factura ya ha sido pagada")
                    else:
                        messagebox.showerror(title="Error!", message="No hay ninguna factura con la id " + x +
                                                                     " asegurate de haber colocado bien la id")

                def razon1(evento, p1Field):
                    p1Field.destroy()
                    messagebox.showinfo(title="Listo!", message="Su reserva ha sido reembolsada correctamente\n"
                                                                "lamentamos las molestias")
                    windowUser.destroy()

                def razon(motivos, opc1):
                    mot = motivos.get()
                    motivos.destroy()
                    opc1.destroy()
                    if mot == "Otro (especificar)":
                        p1Field = FieldFrame("Datos", ["Razon de tu reembolso:"], "valor", frameU4)
                        p1Field.grid()
                        p1Field.aceptar.bind("<Button-1>", lambda event, field=p1Field: razon1(event, field))
                    else:
                        messagebox.showinfo(title="Listo!", message="Su reserva ha sido reembolsada correctamente\n"
                                                                    "lamentamos las molestias")
                        windowUser.destroy()

                def validacion4(evento):
                    x = pField.getValue("Id de la reserva")
                    factura1 = Factura.buscarFactura(Pago.getFacturasPendientes(), x)
                    factura2 = Factura.buscarFactura(Pago.getFacturasPagas(), x)
                    if factura1 != None:
                        messagebox.showwarning(title="Cuidado",
                                               message="La factura " + x + " todavía no ha sido pagada")
                    elif factura2 != None:
                        pField.destroy()
                        messagebox.showinfo(title="listo",
                                            message="La factura " + x + " ha sido reembolsada a su tarjeta usada para el pago")
                        Pago.facturasPagas.remove(factura2)
                        nameP.config(text="Para finalizar cuentanos cuál fue el motivo de su reembolso")
                        motivos = ttk.Combobox(frameU4,
                                               values=["Problemas con el horario", "Problemas con nuestro servicio",
                                                       "Dificultades con el precio y/o medio de pago",
                                                       "Otro (especificar)"], width=100)
                        motivos.grid(padx=10, pady=10)
                        opc1 = tk.Button(frameU4, text="Aceptar", bg="misty rose", width=50, heigh=3,
                                         command=lambda: razon(motivos, opc1))
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
            nameP.config(text=("Aqui podrás ingresar, cancelar o verificar el estado de tu membresía \n"
                               "Primero debes seleccionar la acción que deseas realizar\n"))
            nameP.grid()

            opciones = ["Obtener Membresía", "Cancelar Membresía", "Verificar Membresía"]

            combomiembros = ttk.Combobox(frameU4, values=opciones)
            combomiembros.grid(row=5, column=0, padx=10, pady=10)

            def obtenerMiembro():
                from src.Errores.ExceptionC1 import campoVacio
                rField = FieldFrame("Datos personales", ["Nombre:", "Identificación:"], "valor", frameU4)
                rField.grid()
                rField.aceptar.invoke()
                name = rField.getValue("Nombre")
                ide = rField.getValue("Identificación")

                def enlazarEvento(event):
                    cerrar_userVent()
                    resultado = Membresia.agregarMiembro(name, ide)
                    if resultado:
                        messagebox.showinfo("Membresia", "¡Felicidades, ahora es miembro!")
                        Serializador.serializarDatos()
                    else:
                        messagebox.showinfo("Membresia", "Ya es miembro")
                        Serializador.serializarDatos()

                rField.aceptar.bind("<Button-1>", enlazarEvento)

            def cancelarMiembro():
                from src.Errores.ExceptionC1 import campoVacio
                rField = FieldFrame("Datos personales", ["Nombre:", "Identificación:"], "valor", frameU4)
                rField.grid()
                rField.aceptar.invoke()
                name = rField.getValue("Nombre")
                ide = rField.getValue("Identificación")
                clienteEliminar = Cliente.validarDatosCliente(name, ide)

                def enlazarEvento(event):
                    resultado = Membresia.cancelarMiembro(name, ide, clienteEliminar)
                    cerrar_userVent()
                    if resultado:
                        messagebox.showinfo("Membresia", "Usted ya no hace parte de la membresia")
                        Serializador.serializarDatos()
                    else:
                        messagebox.showinfo("Membresia", "Usted no es miembro actualmente")
                        Serializador.serializarDatos()

                rField.aceptar.bind("<Button-1>", enlazarEvento)

            def verificanding():
                from src.Errores.ExceptionC1 import campoVacio
                rField = FieldFrame("Datos personales", ["Nombre:", "Identificación:"], "valor", frameU4)
                rField.grid()
                rField.aceptar.invoke()
                name = rField.getValue("Nombre")
                ide = rField.getValue("Identificación")
                clienteVerificar = Cliente.validarDatosCliente(name, ide)

                def enlazarEvento(event):
                    resultado = Membresia.verificarMiembro(name, ide, clienteVerificar)
                    cerrar_userVent()
                    if resultado:
                        messagebox.showinfo("Membresia", "Usted hace parte de la membresia")
                        Serializador.serializarDatos()
                    else:
                        messagebox.showinfo("Membresia", "Usted no es miembro actualmente")
                        Serializador.serializarDatos()

                rField.aceptar.bind("<Button-1>", enlazarEvento)

            def procesarOpcion():
                opcion = combomiembros.get()
                if opcion == "Cancelar Membresía":
                    cancelarMiembro()
                elif opcion == "Obtener Membresía":
                    obtenerMiembro()
                elif opcion == "Verificar Membresía":
                    verificanding()

            botonAceptar = tk.Button(frameU4, text="Aceptar", command=procesarOpcion)
            botonAceptar.grid(row=6, column=0, padx=10, pady=10)

        def ingresarAltrabajo():
            def trabajador(evento):
                nombre = iField.getValue("Nombre")
                ide = iField.getValue("Número de identificación")
                trabajadorNow = Trabajador(ide, "6pm-12pm", nombre)
                Trabajador.addTrabajadoresActivos(trabajadorNow)
                messagebox.showinfo(title="Listo!", message="Ahora eres un trabajador del RestauranteUn"
                                    " esperamos lo mejor para ti")
                Serializador.serializarDatos()
                windowUser.destroy()

            nombre.config(text="Ingresar al trabajo", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de ingresar al trabajo", bg="lightblue",
                               font=("arial", 12, "bold"))
            nameP.config(text="Si quieres formar parte de los trabajadores del RestauranteUn puedes hacerlo desde aquí\n"
                         "Primero debes ingresar tu nombre e identificación en las casillas correspondientes")
            nameP.grid(pady=10)
            iField = FieldFrame("Datos personales", ["Nombre:", "Número de identificación:"], "valor", frameU4)
            iField.grid()
            iField.aceptar.bind("<Button-1>", trabajador)

        def asignarMesa():
            def revisar(evento):
                def opc(parametro):
                    def aceptar():
                        mesa = mesas.get()
                        reserva = None
                        for i in Trabajador.getMesasElegir():
                            if i.getIdR() == mesa.split(" ")[-1]:
                                print("si")
                                reserva = i
                        for x in Pago.facturasPagas:
                            if str(x.getReserva()) == str(reserva):
                                Trabajador.removeMesasElegir(reserva)
                                trabajadorN.accion(x, x.getPrecio())
                                messagebox.showinfo(title="Listo!", message="La mesa fue asignada correctamente")
                        Serializador.serializarDatos()
                        windowUser.destroy()

                    asig.destroy()
                    ver.destroy()
                    if parametro == "Asignar mesa":
                        if len(Trabajador.getMesasElegir()) == 0:
                            messagebox.showerror(title="Error!", message="No hay mesas disponibles hasta el momento")
                            windowUser.destroy()
                        else:
                            values = []
                            for i in Trabajador.getMesasElegir():
                                values.append(i)
                            mesas = ttk.Combobox(frameU4, values=values, width=100)
                            mesas.grid(pady=10)
                            nameP.config(text="Despliega el recuadro para vere todas las mesas disponibles")
                            aceptar = tk.Button(frameU4, text="Aceptar", bg="misty rose", width=50, heigh=3,
                                                command=aceptar)
                            aceptar.grid(pady=10)
                    else:
                        if len(Trabajador.getMesasAtendidas()) == 0:
                            messagebox.showerror(title="Error!", message="No hay ninguna mesa atendida")
                            windowUser.destroy()
                        else:
                            nameP.config(text="Despliega el recuadro para ver todas las mesas asignadas")
                            values = []
                            a = 1
                            for i in Trabajador.getMesasAtendidas():
                                values.append(str(a) + ". " + i.__str__())
                                a += 1
                            mesas = ttk.Combobox(frameU4, values=values, width=100)
                            mesas.grid()

                nombre = asField.getValue("Nombre")
                ide = int(asField.getValue("Número de identificación"))

                trabajadorN = None
                for i in Trabajador.getTrabajadoresActivos():
                    print(nombre == i.getNombre())
                    print(ide == int(i.getId()))
                    if i.getNombre().strip() == nombre and int(i.getId().strip()) == ide:
                        trabajadorN = i
                        asField.destroy()
                        nameP.config(text="¡Bienvenido! " + nombre + " ¿Que deseas hacer?")
                        asig = tk.Button(frameU4, text="Asignar mesa", bg="misty rose", width=50, heigh=3,
                                         command=lambda: opc("Asignar mesa"))
                        asig.grid(padx=10, pady=10)
                        ver = tk.Button(frameU4, text="Ver mesas asignadas", bg="misty rose", width=50, heigh=3,
                                        command=lambda: opc("Ver mesas Asignadas"))
                        ver.grid(padx=10, pady=10)
                        break
                else:
                    messagebox.showwarning(title="Alerta!",
                                           message="No hay ningún trabajador con los datos introducidos")

            nombre.config(text="Asignar mesa", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de asignar mesa", bg="lightblue",
                               font=("arial", 12, "bold"))
            nameP.config(
                text="Para acceder primero debes colocar tu nombre e identificación (recuerda que debes ser un trabajador activo)")
            nameP.grid()

            asField = FieldFrame("Datos personales", ["Nombre:", "Número de identificación:"], "valor", frameU4)
            asField.grid(pady=10)
            asField.aceptar.bind("<Button-1>", revisar)

        def visualizarSueldo():
            def revisar(evento):
                locale.setlocale(locale.LC_ALL, '')
                trabajador = None
                for i in Trabajador.getTrabajadoresActivos():
                    numero = int(vField.getValue("Número de identificación"))
                    if numero == i.getId():
                        trabajador = i
                        break
                if trabajador is None:
                    messagebox.showerror(title="Error!", message="No hay ningún trabajador con el id introducido")
                    windowUser.destroy()
                sueldo = locale.currency(trabajador.getSueldo(), grouping=True)
                messagebox.showinfo(title="Sueldo!", message="su sueldo es de: " + sueldo)
                windowUser.destroy()

            nombre.config(text="Visualizar sueldo actual", bg="lightblue", font=("arial", 12, "bold"))
            descripcion.config(text="Esta es la funcionalidad de asignar mesa", bg="lightblue",
                               font=("arial", 12, "bold"))
            nameP.config(text="Para poder verificar que si hacer parte de la lista de trabajadores del RestauranteUN"
                         " necesitamos que coloques tu identificación en la casilla indicada")
            nameP.grid()
            vField = FieldFrame("Datos personales", ["Número de identificación:"], "valor", frameU4)
            vField.grid(pady=10)
            vField.aceptar.bind("<Button-1>", revisar)

        contenedorDemenu = tk.Frame(windowUser)
        contenedorDemenu.pack(side=tk.TOP)

        def aplicacion():
            messagebox.showinfo("Aplicación",
                                "¡Bienvenido a RestauranteUN!\n\nEste sistema le permite:\n• Realizar una reserva de mesa en el restaurante.\n• Visualizar los clientes con reservas asignadas.\n• Realizar una cancelacion y eventual reembolso de la reserva.")

        def acercaDe():
            messagebox.showinfo("A cerca de",
                                "Autores de la aplicación:\n• Pedro Junior Jiménez Ibáñez\n• Manuel Alejandro Sánchez Daza\n• Jonhatan Cuartas Londoño\n• Daniel Steven Caro Durango")

        # Menus
        contenedorDemenu = tk.Frame(windowUser)
        contenedorDemenu.pack(side=tk.TOP)

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
        menuTrabajador.add_command(label="Asignar mesa", command=asignarMesa)
        menuTrabajador.add_command(label="Visualizar sueldo actual", command=visualizarSueldo)

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