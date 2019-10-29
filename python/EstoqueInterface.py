from abc import ABC,abstractmethod
from Estoque import Estoque
from Montaria import Montaria
from Utils import Utils

class EstoqueInterface(ABC):

    @classmethod
    def menu(cls, estoques, nome, montarias):

        while True:

            op = Utils.inputER("\n╔════════ MENU DO VENDEDOR " + nome.upper() + " ════════╗\n╠0 Voltar\n╠1 Adicionar nova montaria ao estoque\n╠2 Editar o estoque de uma montaria existente\n╠3 Remover uma montaria do estoque\n╚4 Visualizar estoque\n⟶ ", int, "Entrada inválida, por favor escolha uma das opções.")

            if op == 0:
                return

            elif op == 1:
                cls.adicionaEstoque(estoques, montarias)
            elif op == 2:
                cls.editaEstoque(estoques)

            elif op == 3:
                cls.removeEstoque(estoques)

            elif op == 4:
                cls.visualizaEstoque(estoques)

            else:
                print("\nNão existe esta opção, por favor digite novamente.")

    @staticmethod
    def adicionaEstoque(estoques, montarias):

        print("\nMontarias disponíveis:\n")

        if len(montarias) == 0:
            print("Não há nenhuma montaria na base de dados.")
            return

        else:

            for m in montarias:
                print("["+str(m.getId())+"] "+ str(m.getRaca()))

            montId = Utils.inputER(
                "\nSelecione uma montaria para adicionar ao estoque [Digite 0 para voltar]: ",
                int, "Entrada inválida, insira o ID da montaria que deseja adicionar ao estoque.\n")

            if montId == 0:
                    return

            for e in estoques:
                if e.getMontaria().getId() == montId:
                    print("Montaria já existe no estoque.")
                    return

            flag = 0

            monta = None
            for m in montarias:
                if m.getId() == montId:
                    flag = 1
                    monta = m
                    break

            if flag == 0:
                print("Não há nenhuma montaria com o ID " + str(montId) + " na base de dados.")
                return

            preco = Utils.inputER("Preço: U$", float, "Entrada inválida, insira um número real para o preço da montaria.\n")
            qtd = Utils.inputER("Quantidade: ", int, "Entrada inválida, insira um número inteiro para a quantidade da montaria no estoque.\n")

            estoques.append(Estoque(qtd, preco, monta))

    @staticmethod
    def editaEstoque(estoques):

        idEscolha = Utils.inputER("\nEscolha uma montaria para editar o estoque [Digite 0 para voltar]: ", int, "Entrada inválida, insira o ID da montaria que deseja remover do estoque.")

        if idEscolha == 0:
            return

        flag = 0
        for e in estoques:
            if e.getMontaria().getId() == idEscolha:
                flag = 1

                while True:

                    op = Utils.inputER("\n╔════════ MENU DE EDIÇÃO ════════╗\n╔0 Voltar\n╠1 Editar quantidade\n╚2 Editar preço\n⟶ ", int, "Entrada inválida, por favor escolha uma das opções.")

                    if op == 0:
                        return

                    elif op == 1:
                        print("\nAtual quantidade: " + str(e.getQuantidade()))
                        qtd = Utils.inputER("Nova quantidade: ", int, "Entrada inválida, insira um número inteiro para a quantidade.")
                        e.setQuantidade(qtd)
                        print("Quantidade alterada com sucesso!")

                    elif op == 2:
                        print("\nAtual preço: U$" + str(e.getPreco()))
                        preco = Utils.inputER("Novo preço: U$", float, "Entrada inválida, insira um número real para o preço da montaria.")
                        e.setPreco(preco)
                        print("Preço alterado com sucesso!\n")

                    else:
                        print("\nNão há esta opção, por favor digite novamente.")

        if flag == 0:
            print("Esta montaria não está contida no estoque deste vendedor.")

    @staticmethod
    def removeEstoque(estoques):

        idEscolha = Utils.inputER("\nEscolha uma montaria para remover do estoque [Digite 0 para voltar]: ", int, "Entrada inválida, insira o ID da montaria que deseja remover do estoque.")

        if idEscolha == 0:
            return

        for e in estoques:
            if e.getMontaria().getId() == idEscolha:
                estoques.remove(e)
                print("Montaria removida com sucesso do estoque!")
                return

        print("Está montaria não está contida no estoque.")

    @staticmethod
    def visualizaEstoque(estoques):

        print("")
        if len(estoques) == 0:
            print("Este vendedor não contém nenhuma montaria no estoque.")
            return

        for e in estoques:
            print("["+str(e.getMontaria().getId())+"] "+str(e.getMontaria().getRaca())+" - QTD: "+str(e.getQuantidade())+" - Preço: U$"+str(e.getPreco()))
