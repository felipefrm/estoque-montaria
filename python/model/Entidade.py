from abc import ABC, abstractmethod

class Entidade (ABC):

    def getId(self):
        return self.__id

    def setId(self, id):
        self.__id = id
