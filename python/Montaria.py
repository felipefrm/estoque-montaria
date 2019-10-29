from Entidade import Entidade

class Montaria (Entidade):
    __cont = 1
    def __init__(self, nome, raca, descricao, combustivel, raridade, capacidade, velocidade):
        self._setId(self.__cont)
        self.setCont(self.__cont+1)
        self.__nome = nome
        self.__raca = raca
        self.__descricao = descricao
        self.__combustivel = combustivel
        self.__raridade = raridade
        self.__capacidade = capacidade
        self.__velocidade = velocidade
    @classmethod
    def setCont(cls, cont):
        cls.__cont = cont

    def getNome(self):
        return self.__nome

    def setNome(self, nome):
        self.__nome = nome

    def getRaca(self):
        return self.__raca

    def setRaca(self, raca):
        self.__raca = raca

    def getDescricao(self):
        return self._descricao

    def setDescricao(self, descricao):
        self.descricao = descricao

    def getCombustivel(self):
        return self.__combustivel

    def setCombustivel(self, combustivel):
        self.combustivel = combustivel

    def getRaridade(self):
        return self.__raridade

    def setRaridade(self, raridade):
        self.__raridade = raridade

    def getCapacidade(self):
        return self.__capacidade

    def setCapacidade(self, capacidade):
        self.__capacidade = capacidade

    def getVelocidade(self):
        return self.__velocidade

    def setVelocidade(self, velocidade):
        self.__velocidade = velocidade