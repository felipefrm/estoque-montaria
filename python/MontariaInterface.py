from abc import ABC,abstractmethod
from Montaria import Montaria

class MontariaInterface(ABC):

    @classmethod
    def menu(cls, montarias):

        while(True):

            print("\n╔════════ MENU DE MONTARIAS ════════╗")
            op = int(input("╠0 Voltar\n╠1 Adicionar Montaria\n╠2 Remover Montaria\n╚3 Visualizar Montarias\n⟶ "))

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
        capacidade = int(input("Capacidade: "))
        velocidade = float(input("Velocidade: "))
        combustivel = input("Combustível: ")
        descricao = input("Descrição: ")
        return Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade)


    @classmethod
    def adicionaMontaria(cls, montarias):
        nova_montaria = cls.criaMontaria()
        montarias.append(nova_montaria)

    @staticmethod
    def removeMontaria(montarias):

        montId = input(("\nQual montaria deseja remover? [Digite 0 para voltar] "))

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
        if len(montarias) == 0:
            print("\nNão há nenhuma montaria cadastrada na base de dados.")
        for m in montarias:
            print("["+str(m.getId())+"] "+m.getRaca()+", "+ str(m.getCapacidade())+", "+
					str(m.getCombustivel())+", "+ str(m.getVelocidade())+", "+ str(m.getRaridade()))
