from MontariaInterface import MontariaInterface
from VendedorInterface import VendedorInterface
from Montaria import Montaria
from Vendedor import Vendedor
from Estoque import Estoque
from Utils import Utils

import json



if __name__ == '__main__':
    vendedores = []
    montarias = []
    print("╔════════ Bases de dados ════════╗")
    fname_mont=input("Nome do arquivo de montarias ⟶ ")
    max_id=1
    list_dict=list()
    try:
        with open(fname_mont, 'r') as fvend:
            list_dict=json.load(fvend)
            for obj in list_dict:
                max_id=max(max_id,obj['id']+1)
                montarias.append(Montaria(obj['nome'], obj['raca'], obj['descricao'], obj['combustivel'], 
                obj['raridade'], obj['capacidade'], obj['velocidade']))
                montarias[-1].setId(obj['id'])
        Montaria.setCont(max_id)
    except Exception as e:
        print(e)
        print("Arquivo não encontrado. Usando base vazia.")
    print(str(len(montarias))+" montarias carregadas da base")


    fname_vend=input("Nome do arquivo de vendedores ⟶ ")
    max_id=1
    list_dict=list()
    try:
        with open(fname_vend, 'r') as fvend:
            list_dict=json.load(fvend)
            for obj in list_dict:
                max_id=max(max_id,obj['id']+1)
                vendedores.append(Vendedor(obj['nome'], obj['raca'], obj['idade'], obj['descricao']))
                vendedores[-1].setId(obj['id'])
                estoque=list()
                for i in obj['estoque']:
                    montid=i['montaria']['id']
                    for m in montarias:
                        if m.getId() == montid:
                            estoque.append(Estoque(i['quantidade'],i['preco'],m))
                            break
                vendedores[-1].setEstoque(estoque)
        Vendedor.setCont(max_id)
    except Exception as e:
        print(e)
        print("Arquivo não encontrado. Usando base vazia.")
    print(str(len(vendedores))+" vendedores carregados da base")




    while True:
        print("\n╔════════ MENU ════════╗")
        try:
            op = Utils.inputER("╠0 Fechar programa\n╠1 Menu Vendedor\n╚2 Menu Montaria\n⟶ ", int, "Entrada inválida, por favor escolha uma das opções.\n")
        except ValueError:
            continue
        if op == 0:
            list_dict=list()
            if vendedores:
                for v in vendedores:
                    obj_dict=Utils.getObjDict(v)
                    ests=list()
                    for i in obj_dict['estoque']:
                        ests.append(Utils.getObjDict(i))
                        ests[-1]['montaria']=Utils.getObjDict(ests[-1]['montaria'])
                    obj_dict['estoque']=ests
                    list_dict.append(obj_dict)
                with open(fname_vend, 'w') as outfile:
                    json.dump(list_dict, outfile)
            list_dict=list()
            
            if montarias:
                for m in montarias:
                    list_dict.append(Utils.getObjDict(m))
                with open(fname_mont, 'w') as outfile:
                    json.dump(list_dict, outfile)
            break
        elif op == 1:
            VendedorInterface.menu(vendedores, montarias)

        elif op == 2:
            MontariaInterface.menu(montarias)

        else:
            print("\nNão há esta opção, por favor digite novamente.")
