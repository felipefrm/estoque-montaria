from tkinter import*
from tkinter import ttk
import tkinter as tk
class MontariaInterface:
    def __init__(self, instancia_Tk):

        instancia_Tk.grid()
        instancia_Tk.title("Montaria")
        instancia_Tk.minsize(440,400)

        self.dataCols = ('ID', 'Raça','currency')
        self.tree = ttk.Treeview(columns=self.dataCols, show='headings')
        self.tree.grid(row=7, column=3, sticky= tk.N + tk.S + tk.W + tk.E)


        fonte1 = ('Verdana', '10', 'bold')

        #ID
        label0 = Label(instancia_Tk, text='ID: ', font=fonte1, width=12)
        self.id = Entry(instancia_Tk)
        label0.grid(row=0, column=0)
        self.id.config(state='readonly')
        self.id.grid(row=0, column=1)
        #Raça
        label1 = Label(instancia_Tk, text='Raça: ', font=fonte1, width=8)
        self.raca = Entry(instancia_Tk)
        self.raca.focus_force() # Para o foco começar neste campo
        label1.grid(row=1, column=0)
        self.raca.grid(row=1, column=1)
        #Combustivel
        label2 = Label(instancia_Tk, text='Combustível: ', font=fonte1, width=12)
        self.combustivel = Entry(instancia_Tk)
        label2.grid(row=2, column=0)
        self.combustivel.grid(row=2, column=1)
        #Raridade
        label3 = Label(instancia_Tk, text='Raridade: ', font=fonte1, width=12)
        self.raridade=Entry(instancia_Tk)
        label3.grid(row=3, column=0)
        self.raridade.grid(row=3, column=1)
        #Capacidade
        label4 = Label(instancia_Tk, text='Capacidade: ', font=fonte1, width=12)
        self.capacidade=Entry(instancia_Tk)
        label4.grid(row=4, column=0)
        self.capacidade.grid(row=4, column=1)
        #Velocidade
        label5 = Label(instancia_Tk, text='Velocidade: ', font=fonte1, width=12)
        self.velocidade=Entry(instancia_Tk)
        label5.grid(row=5, column=0)
        self.velocidade.grid(row=5, column=1)


        self.botaoAdd = Button(instancia_Tk, text ='Adicionar')
        self.botaoAdd['height'] = 2
        self.botaoAdd.grid(row=6, column=0)

        self.botaoRem = Button(instancia_Tk, text ='Remover')
        self.botaoRem['height'] = 2
        self.botaoRem.grid(row=6, column=1)

        self.botaoLim = Button(instancia_Tk, text ='Limpar')
        self.botaoLim['height'] = 2
        self.botaoLim.grid(row=6, column=2)

raiz=Tk()
MontariaInterface(raiz)
raiz.mainloop()
