from tkinter import *
class VendedorInterface:
    def __init__(self, instancia_Tk):

        instancia_Tk.grid()
        instancia_Tk.title("Vendedor")
        instancia_Tk.minsize(440,400)

        fonte1 = ('Verdana', '10', 'bold')

        #ID
        label0 = Label(instancia_Tk, text='ID: ', font=fonte1, width=12)
        self.id = Entry(instancia_Tk)
        label0.grid(row=0, column=0)
        self.id.config(state='readonly')
        self.id.grid(row=0, column=1)
        #Nome
        label1 = Label(instancia_Tk, text='Nome: ', font=fonte1, width=12)
        self.nome = Entry(instancia_Tk)
        self.nome.focus_force() # Para o foco começar neste campo
        label1.grid(row=1, column=0)
        self.nome.grid(row=1, column=1)
        #Raça
        label2 = Label(instancia_Tk, text='Raça: ', font=fonte1, width=12)
        self.raca = Entry(instancia_Tk)
        label2.grid(row=2, column=0)
        self.raca.grid(row=2, column=1)
        #Idade
        label3 = Label(instancia_Tk, text='Idade: ', font=fonte1, width=12)
        self.idade = Entry(instancia_Tk)
        label3.grid(row=3, column=0)
        self.idade.grid(row=3, column=1)

        self.botaoAdd = Button(instancia_Tk, text ='Adicionar', width = 12)
        self.botaoAdd['height'] = 2
        self.botaoAdd.grid(row=4, column=0)

        self.botaoRem = Button(instancia_Tk, text ='Remover', width = 12)
        self.botaoRem['height'] = 2
        self.botaoRem.grid(row=5, column=0)

        self.botaoLim = Button(instancia_Tk, text ='Limpar', width = 12)
        self.botaoLim['height'] = 2
        self.botaoLim.grid(row=6, column=0)

raiz=Tk()
VendedorInterface(raiz)
raiz.mainloop()
