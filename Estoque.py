from Entidade import Entidade

class Estoque (Entidade):

    def __init__(self, quantidade, preco, montaria):
        self.__quantidade = quantidade
        self.__preco = preco
        self.__montaria = montaria

    def getMontaria(self):
        return self.__montaria

    def setMontaria(self, montaria):
        self.__montaria = montaria

    def getQuantidade(self):
        return self.__quantidade

    def setQuantidade(self, quantidade):
        self.__quantidade = quantidade

    def getPreco(self):
        return self.__preco

    def setPreco(self, preco):
        self.__preco = preco


