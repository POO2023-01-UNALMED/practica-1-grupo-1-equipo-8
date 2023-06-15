from tkinter import messagebox
import tkinter as tk

class Gui:

    #Ventana de inicio
    window = tk.Tk()
    window.title("Restaurante UN")
    window.geometry("1340x720")
    window.config(bg="white")
    window.resizable(0,0)

    menuBar = tk.Menu(window)
    window.config(menu=menuBar)

    menuInicio = tk.Menu(menuBar)
    menuBar.add_cascade(label="Inicio", menu=menuInicio)

    menuInicio.add_command(label = "Descripción")
    menuInicio.add_command(label = "Salir")

    descripcion = tk.Label(window,bg="white")
    descripcion.pack(anchor="center")

    #Frames
    frameP1 = tk.Frame(window,bg="black")
    frameP1.place(x=20,y=20,width=640,height=680)

    frameP2 = tk.Frame(window,bg="black")
    frameP2.place(x=680,y=20,width=640,height=680)

    frameP3 = tk.Frame(frameP1,bg="lightblue")
    frameP3.place(x=10,y=10,width=620,height=240)

    frameP4 = tk.Frame(frameP1,bg="lightblue")
    frameP4.place(x=10,y=260,width=620,height=410)

    frameP5 = tk.Frame(frameP2,bg="lightblue")
    frameP5.place(x=10,y=10,width=620,height=240)

    botonCambio = tk.Button(frameP5,text="Click para cambiar de hoja de vida",bg="teal")
    botonCambio.place(x=210,y=210)
    botonCambio.bind("<Button-1>")

    hojaDevida1 = tk.Label(frameP5,text="Pedro Jimenez\n\nEstudiante de Ingenieria de sistemas e informaticas\n\nContacto:\n\nTelefono: 3246840606\n\nCorreo: pjimenezi@unal.edu.co\n\nUniversidad nacional de Colombia sede Medellin",bg="lightblue")
    hojaDevida2 = tk.Label(frameP5,text="Pablo Jimenez\n\nEstudiante de Ingenieria de sistemas e informaticas\n\nContacto:\n\nTelefono: 3246840606\n\nCorreo: pjimenezi@unal.edu.co\n\nUniversidad nacional de Colombia sede Medellin",bg="lightblue")

    hojas = [hojaDevida1,hojaDevida2]

    frameP6 = tk.Frame(frameP2,bg="lightblue")
    frameP6.place(x=10,y=260,width=620,height=410)

    #Labels
    imagen1 = tk.PhotoImage(file = "imagenes/reserva.png")
    label1 = tk.Label(frameP4,image=imagen1,bg="lightblue")
    label1.place(height=360, width=620)

    mensajeBienvenida = tk.Label(frameP3,text="¡Bienvenido a RestauranteUN!",bg="lightblue")
    mensajeBienvenida.place(relx=0.5,rely=0.5,anchor="center")
    mensajeBienvenida.configure(font=("arial", 12, "bold"))

    #Buttons
    botonIngreso = tk.Button(frameP4,text="Click para ingresar a RestauranteUN", bg = "teal")
    botonIngreso.place(x=0,y=360,width=620,height=50)
    botonIngreso.configure(font=("arial", 11, "bold"))

    #Ventana principal del usuario
    def userVent(evento):

        windowUser = tk.Tk()
        windowUser.geometry("1290x720")
        windowUser.resizable(0,0)
        windowUser.title("Restaurante UN")
        windowUser.config(bg="white")

        frameU1 = tk.Frame(windowUser,bg="lightblue")
        frameU1.place(x=20,y=15,width=1250,height=685)

        frameU2 = tk.Frame(frameU1,bg="lightblue")
        frameU2.place(x=625,y=20,width=416,height=30,anchor="center")

        frameU3 = tk.Frame(frameU1,bg="lightblue")
        frameU3.place(x=20,y=50,width=1210,height=90)

        frameU4 = tk.Frame(frameU1,bg="white")
        frameU4.place(x=90,y=160,width=1090,height=500)

        nombre = tk.Label(frameU2,bg="lightblue")
        nombre.place(relx=0.5,rely=0.5,anchor="center")

        descripcion = tk.Label(frameU3,bg="lightblue")
        descripcion.place(relx=0.5,rely=0.5,anchor="center")

        def reservar():
            nombre.config(text="Reservar",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras gestionar y realizar las reservas",bg="lightblue",font=("arial", 12, "bold"))
        
        def reprogramar():
            nombre.config(text="Reprogramar",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras hacer un cambio de parametros en la reserva",bg="lightblue",font=("arial", 12, "bold"))

        def pagar():
            nombre.config(text="Pagar",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras efectuar el pago o reembolso de las reservas",bg="lightblue",font=("arial", 12, "bold"))

        def obtenerMembresia():
            nombre.config(text="Obtener membresia",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras convertirte en miembro del restaurante o cancelar la membresia",bg="lightblue",font=("arial", 12, "bold"))

        def ingresarAltrabajo():
            nombre.config(text="Ingresar al trabajo",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras convertirte en trabajador del restaurante",bg="lightblue",font=("arial", 12, "bold"))

        def asignarMesa():
            nombre.config(text="Asignar mesa",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui se te asignara una mesa como trabajador",bg="lightblue",font=("arial", 12, "bold"))

        def visualizarSueldoactual():
            nombre.config(text="Visualizar sueldo actual",bg="lightblue",font=("arial", 12, "bold"))
            descripcion.config(text="Aqui podras ver tu sueldo como trabajador",bg="lightblue",font=("arial", 12, "bold"))


        contenedorDemenu = tk.Frame(windowUser)
        contenedorDemenu.pack(side = tk.TOP)

        def aplicacion():
            messagebox.showinfo("Aplicación","¡Bienvenido a RestauranteUN!\n\nEste sistema le permite:\n• Realizar una reserva de mesa en el restaurante.\n• Visualizar los clientes con reservas asignadas.\n• Realizar una cancelacion y eventual reembolso de la reserva.")

        def salir():
            windowUser.destroy()

        def acercaDe():
            messagebox.showinfo("A cerca de","Autores de la aplicación:\n• Pedro Junior Jiménez Ibáñez\n• Manuel Alejandro Sánchez Daza\n• Jonhatan Cuartas Londoño\n• Daniel Steven Caro Durango")

        #Menus
        menuArchivo = tk.Menu(contenedorDemenu)
        menuArchivo.add_command(label="Aplicación",command=aplicacion)
        menuArchivo.add_command(label="Salir",command=salir)

        menuProcesosyConsultas = tk.Menu(contenedorDemenu)

        menuCliente = tk.Menu(menuProcesosyConsultas)
        menuCliente.add_command(label="Reservar",command=reservar)
        menuCliente.add_command(label="Reprogramar",command=reprogramar)
        menuCliente.add_command(label="Pagar",command=pagar)
        menuCliente.add_command(label="Obtener membresía",command=obtenerMembresia)

        menuProcesosyConsultas.add_cascade(label="Menu de cliente",menu=menuCliente)

        menuTrabajador = tk.Menu(menuProcesosyConsultas)
        menuTrabajador.add_command(label="Ingresar al trabajo",command=ingresarAltrabajo)
        menuTrabajador.add_command(label="Asignar mesa",command=asignarMesa)
        menuTrabajador.add_command(label="Visualizar sueldo actual",command=visualizarSueldoactual)

        menuProcesosyConsultas.add_cascade(label="Menu de trabajador",menu=menuTrabajador)

        menuAyuda = tk.Menu(contenedorDemenu)
        menuAyuda.add_command(label="Acerca de",command=acercaDe)

        barraDemenu = tk.Menu(windowUser)
        barraDemenu.add_cascade(label="Archivo",menu=menuArchivo)
        barraDemenu.add_cascade(label="Procesos y Consultas",menu=menuProcesosyConsultas)
        barraDemenu.add_cascade(label="Ayuda",menu=menuAyuda)

        windowUser.config(menu=barraDemenu)

    botonIngreso.bind("<Button-1>", userVent)

    window.mainloop()