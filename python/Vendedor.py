from Entidade import Entidade

class Vendedor (Entidade):
    __cont = 1
    def __init__(self, nome, raca, idade, descricao):
        self.setId(self.__cont)
        self.setCont(self.__cont+1)
        self.__nome = nome
        self.__raca = raca
        self.__idade = idade
        self.__descricao = descricao
        self.__estoque = []
    @classmethod
    def setCont(cls, cont):
        cls.__cont = cont

    def getEstoque(self):
        return self.__estoque

    def setEstoque(self, estoque):
        self.__estoque = estoque

    def getNome(self):
        return self.__nome

    def setNome(self, nome):
        self.__nome = nome

    def getRaca(self):
        return self.__raca

    def setRaca(self, raca):
        self.__raca = raca

    def getIdade(self):
        return self.__idade

    def setIdade(self, idade):
        self.__idade = idade

    def getDescricao(self):
        return self.__descricao

    def setDescricao(self, descricao):
        self.__descricao = descricao
