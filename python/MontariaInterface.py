from abc import ABC,abstractmethod
from Montaria import Montaria
from Utils import Utils

class MontariaInterface(ABC):

    @classmethod
    def menu(cls, montarias):

        while(True):

            op = Utils.inputER("\n╔════════ MENU DE MONTARIAS ════════╗\n╠0 Voltar\n╠1 Adicionar Montaria\n╠2 Remover Montaria\n╚3 Visualizar Montarias\n⟶ ", int, "Entrada inválida, por favor escolha uma das opções.")

            if op == 0:
                return

            elif op == 1:
                cls.adicionaMontaria(montarias)

            elif op == 2:
                cls.removeMontaria(montarias)

            elif op == 3:
                cls.vizualizaMontaria(montarias)
            else:
                print("\nNão existe esta opção, por favor digite novamente.")


    @staticmethod
    def criaMontaria():

        print("\nAdicionando Montaria...")
        nome = input("Nome: ")
        raca = input("Raça: ")
        raridade = input("Raridade: ")
        capacidade = Utils.inputER("Capacidade: ", int, "Entrada inválida, insira um número inteiro para a capacidade.")
        velocidade = Utils.inputER("Velocidade: ", float, "Entrada inválida, insira um número real para a velocidade.")
        combustivel = input("Combustível: ")
        descricao = input("Descrição: ")
        return Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade)


    @classmethod
    def adicionaMontaria(cls, montarias):
        nova_montaria = cls.criaMontaria()
        montarias.append(nova_montaria)

    @staticmethod
    def removeMontaria(montarias):

        montId = Utils.inputER("\nQual montaria deseja remover? [Digite 0 para voltar] ", int, "Entrada inválida, digite o ID da montaria para removê-la.")

        if montId == 0:
            return

        for m in montarias:
            if m.getId() == montId:
                montarias.remove(m)
                print("Montaria removida. ")
                return

        print("Não há nenhuma montaria com o ID " + str(montId) + " na base de dados.")

    @staticmethod
    def vizualizaMontaria(montarias):
        print("")
        if len(montarias) == 0:
            print("Não há nenhuma montaria cadastrada na base de dados.")
        for m in montarias:
            print("["+str(m.getId())+"] "+m.getRaca()+", "+ str(m.getCapacidade())+", "+
					str(m.getCombustivel())+", "+ str(m.getVelocidade())+", "+ str(m.getRaridade()))
