from abc import ABC, abstractmethod

class Entidade (ABC):

    @abstractmethod
    def __init__(self, id):
        pass

    def getId(self):
        return self.__id

    def _setId(self, id):
        self.__id = id
