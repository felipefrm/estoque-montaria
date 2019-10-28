# coding: utf-8

from abc import ABC,abstractmethod
import EstoqueInterface
from Vendedor import Vendedor

class VendedorInterface(ABC):

    @classmethod
    def menu(cls,vendedores, montarias):
        while True:
            print("\n╔════════ MENU DE VENDEDORES ════════╗")
            op = int(input("╠0 Voltar\n╠1 Adicionar Vendedor\n╠2 Remover Vendedor\n╠3 Visualizar Vendedores\n╚4 Estoque Vendedor\n⟶ "))

            if op == 0:
                return

            elif op == 1:
                cls.adicionaVendedor(vendedores)

            elif op == 2:
                cls.removeVendedor(vendedores)

            elif op == 3:
                cls.visualizaVendedores(vendedores)

            elif op == 4:
                vend = cls.selecionaVendedor(vendedores)
                if (vend != None):
                    EstoqueInterface.menu(vend.getEstoque(), vend.getNome(), montarias)

            else:
                print("Não existe esta opção, por favor digite novamente.")

    @staticmethod
    def criaVendedor():
        print("\nAdicionando Vendedor...")
        return Vendedor(input("Nome: "), input("Raça: "), int(input("Idade: ")), input("Descrição: "))

    @classmethod
    def adicionaVendedor(cls,vendedores):
        vendedores.append(cls.criaVendedor())

    @staticmethod
    def removeVendedor(vendedores):
        while True:
            vendId = int(input("Qual vendedor deseja remover? [Digite 0 para voltar] "))

            if vendId == 0:
                return

            for v in vendedores:
                if v.getId() == vendId:
                    vendedores.remove(v)
                    print("Vendedor removido.")
                    return

            print("Não há nenhum vendedor com o ID " + vendId + " na base de dados.")

    @staticmethod
    def selecionaVendedor(vendedores):

        vendId = int(input("Selecione um vendedor para acessar o estoque [Digite 0 para voltar] "))

        if vendId == 0:
            return None

        for v in vendedores:
            if v.getId() == vendId:
                return v

        print("Nao há nenhum vendedor com o ID " + vendId + " na base de dados\n")

    @staticmethod
    def visualizaVendedores(vendedores):

        if len(vendedores) == 0:
            print("\nNão há nenhum vendedor cadastrado na base de dados.")
            return

        print("")

        for v in vendedores:
            print("[{}] {}, {}, {} anos".format(v.getId(), v.getNome(), v.getRaca(), v.getIdade()))

