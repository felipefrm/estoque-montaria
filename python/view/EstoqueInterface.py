from tkinter import *
from Estoque import Estoque
from Montaria import Montaria
from Utils import Utils

class EstoqueInterface:
    def __init__(self, instancia_Tk):

        instancia_Tk.grid()
        instancia_Tk.title("Estoque Vendedor")
        instancia_Tk.minsize(440,400)

        fonte1 = ('Verdana', '10', 'bold')

        #ID
        label0 = Label(instancia_Tk, text='ID: ', font=fonte1, width=12)
        self.id = Entry(instancia_Tk)
        label0.grid(row=0, column=0)
        self.id.config(state='readonly')
        self.id.grid(row=0, column=1)
        #Montaria
        label1 = Label(instancia_Tk, text='Montaria: ', font=fonte1, width=12)
        self.montaria = Entry(instancia_Tk)
        self.montaria.focus_force() # Para o foco começar neste campo
        label1.grid(row=1, column=0)
        self.montaria.grid(row=1, column=1)
        #Quantidade
        label2 = Label(instancia_Tk, text='Quantidade: ', font=fonte1, width=12)
        self.quantidade = Entry(instancia_Tk)
        label2.grid(row=2, column=0)
        self.quantidade.grid(row=2, column=1)
        #Preço
        label3 = Label(instancia_Tk, text='Preço: ', font=fonte1, width=12)
        self.preco = Entry(instancia_Tk)
        label3.grid(row=3, column=0)
        self.preco.grid(row=3, column=1)

        self.botaoAdd = Button(instancia_Tk, text ='Adicionar', width=12)
        self.botaoAdd['height'] = 2
        self.botaoAdd.grid(row=4, column=0)

        self.botaoRem = Button(instancia_Tk, text ='Remover', width=12)
        self.botaoRem['height'] = 2
        self.botaoRem.grid(row=5, column=0)

        self.botaoLim = Button(instancia_Tk, text ='Limpar', width=12, command = self.clear)
        self.botaoLim['height'] = 2
        self.botaoLim.grid(row=6, column=0)

        self.botaoEdt = Button(instancia_Tk, text ='Editar', width=12)
        self.botaoEdt['height'] = 2
        self.botaoEdt.grid(row=7, column=0)


    def clear(self):
        self.id.delete(0,'end')
        self.montaria.delete(0,'end')
        self.quantidade.delete(0,'end')
        self.preco.delete(0,'end')
raiz=Tk()
EstoqueInterface(raiz)
raiz.mainloop()
