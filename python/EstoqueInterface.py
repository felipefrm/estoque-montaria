from abc import ABC,abstractmethod
from Estoque import Estoque
from Montaria import Montaria

class EstoqueInterface(ABC):

    @classmethod
    def menu(cls, estoques, nome, montarias):

        while True:

            print("\n╔════════ MENU DO VENDEDOR " + nome.upper() + " ════════╗")
            op = int(input("╠0 Voltar\n╠1 Adicionar nova montaria ao estoque\n╠2 Editar o estoque de uma montaria existente\n╠3 Remover uma montaria do estoque\n╚4 Visualizar estoque\n⟶ "))

            if op == 0:
                return

            elif op == 1:
                cls.adicionaEstoque(estoques, montarias)
            elif op == 2:
                cls.editaEstoque(estoques)
                # pass
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

            montId = int(input("\nSelecione uma montaria para adicionar ao estoque [Digite 0 para voltar]: "))

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

            preco = float(input("Preço: U$"))
            qtd = int(input("Quantidade: "))

            estoques.append(Estoque(qtd, preco, monta))

    @staticmethod
    def editaEstoque(estoques):

        idEscolha = int(input("\nEscolha uma montaria para editar o estoque [Digite 0 para voltar]: "))

        if idEscolha == 0:
            return

        flag = 0
        for e in estoques:
            if e.getMontaria().getId() == idEscolha:
                flag = 1
                print("\n╔════════ MENU DE EDIÇÃO ════════╗")

                while True:

                    op = int(input("╔0 Voltar\n╠1 Editar quantidade\n╚2 Editar preço\n⟶ "))

                    if op == 0:
                        return

                    elif op == 1:
                        print("\nAtual quantidade: " + str(e.getQuantidade()))
                        qtd = int(input("\nNova quantidade: "))
                        e.setQuantidade(qtd)
                        print("Quantidade alterada com sucesso!\n")

                    elif op == 2:
                        print("\nAtual preço: U$" + str(e.getPreco()))
                        preco = float(input("\nNovo preço: "))
                        e.setPreco(preco)
                        print("Preço alterado com sucesso!\n")

                    else:
                        print("\nNão há esta opção, por favor digite novamente.")

        if flag == 0:
            print("Esta montaria não está contida no estoque deste vendedor.")

    @staticmethod
    def removeEstoque(estoques):

        idEscolha = int(input("\nEscolha uma montaria para remover do estoque [Digite 0 para voltar]: "))

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

        if len(estoques) == 0:
            print("\nEste vendedor não contém nenhuma montaria no estoque.")
            return

        for e in estoques:
            print("["+str(e.getMontaria().getId())+"], "+str(e.getMontaria().getRaca())+" - QTD: "+str(e.getQuantidade())+" - Preço: U$"+str(e.getPreco()))