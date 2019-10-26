from abc import ABC
from Montaria import Montaria

class montariaInterface(ABC):

    @staticmethod
    def menu(montarias):

        while(True):

            print("\n╔════════ MENU DE MONTARIAS ════════╗")
            op = input(int("╠0 Voltar\n╠1 Adicionar Montaria\n╠2 Remover Montaria\n╚3 Visualizar Montarias\n⟶ "))

            if op == 0:
                return

            elif op == 1:
                adicionaMontaria(montarias)

            elif op == 2:
                removeMontaria(montarias)

            elif op == 3:
                vizualizaMontaria(montarias)
            else:
                print("\nNão existe esta opção, por favor digite novamente.")


    @staticmethod
    def criaMontaria():

        print("\nAdicionando Montaria...")
        nome = input("Nome: ")
        raca = input("Raçã: ")
        raridade = input("Raridade: ")
        capacidade = int(input("Capacidade: "))
        velocidade = float(input("Velocidade: "))
        combustivel = input("Combustível: ")
        descricao = input("Descrição: ")
        return Montaria(nome, raca, descricao, combustivel, raridade, capacidade, velocidade)


    @staticmethod
    def adicionaMontaria(montarias):
        nova_montaria = criaMontaria()
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

        print("Não há nenhuma montaria com o ID " + montId + " na base de dados.")

    @staticmethod
    def vizualizaMontaria(montarias):
        if len(montarias) == 0:
            print("\nNão há nenhuma montaria cadastrada na base de dados.")
        for m in montarias:
            print("["+m.getId()+"], "+m.getRaca()+", "+ m.getCapacidade()+", "+
					m.getCombustivel()+", "+ m.getVelocidade()+", "+ m.getRaridade())